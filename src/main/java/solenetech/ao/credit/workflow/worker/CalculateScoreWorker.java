package solenetech.ao.credit.workflow.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CalculateScoreWorker {
    @JobWorker(type = "calculate-score")
    public Map<String, Object> calculateScore(final ActivatedJob job) {

        var variables = job.getVariablesAsMap();
        // Extrai os valores que você enviou
        Double income = (Double) variables.get("income");
        Integer age = (Integer) variables.get("age");
        double score = income/age;
        return Map.of("score", score);
    }
}
