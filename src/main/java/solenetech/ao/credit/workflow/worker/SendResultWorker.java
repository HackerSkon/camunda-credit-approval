package solenetech.ao.credit.workflow.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import solenetech.ao.credit.core.entity.CreditRequest;
import solenetech.ao.credit.core.entity.CreditResult;
import solenetech.ao.credit.core.enuns.RequestStatus;
import solenetech.ao.credit.core.enuns.ResultStatus;
import solenetech.ao.credit.core.repository.CreditRequestRepository;
import solenetech.ao.credit.core.repository.CreditResultRepository;

import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@Component
public class SendResultWorker {
    @Autowired
    private CreditRequestRepository creditRequestRepository;
    private CreditResultRepository creditResultRepository;

     @JobWorker(type = "send-result")
    public void sendResult(final ActivatedJob job) {
         var variables = job.getVariablesAsMap();
         if(variables == null)
             throw new IllegalArgumentException("variables is null");

         String decision =  (String) variables.get("decision");
         String creditRequestId = (String) variables.get("creditRequestId");
         double score = (Double) variables.get("score");

         CreditRequest request =creditRequestRepository.findById(UUID.fromString(creditRequestId)).get();
         var resultStatus = switch (decision.toLowerCase()) {
             case "aproved" -> {
                 request.setStatus(RequestStatus.approved);
                 yield ResultStatus.Approved;
             }
             case "rejected" -> {
                 request.setStatus(RequestStatus.rejected);
                 yield ResultStatus.Rejected;
             }
             default -> {
                 request.setStatus(RequestStatus.processing);
                 yield ResultStatus.Review;
             }
         };

         CreditResult result = new CreditResult(
                 null,
                 resultStatus,
                 score,
                 request
         );
         creditResultRepository.save(result);
         creditRequestRepository.save(request);
     }
}
