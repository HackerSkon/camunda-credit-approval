package solenetech.ao.credit.api.controllers;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import solenetech.ao.credit.api.dtos.CreatCreditRequest;
import solenetech.ao.credit.api.dtos.DetaisCreditResult;
import solenetech.ao.credit.core.entity.CreditRequest;
import solenetech.ao.credit.core.service.CreditRequestService;
import solenetech.ao.credit.core.service.CreditResultService;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/creditrequests")
public class CreditRequestController {
    private final CreditRequestService creditRequestService;
    private final CreditResultService creditResultService;
    @PostMapping
    public ResponseEntity<CreditRequest> creatCreditRequest(@RequestBody CreatCreditRequest creatCreditRequest) {
        var request = creditRequestService.createCreditRequest(creatCreditRequest);
        return ResponseEntity.ok(request);
    }
    @GetMapping
    public ResponseEntity<List<CreditRequest>> listCreditRequest() {
        var listCreditRequest = creditRequestService.getAll();
        return ResponseEntity.ok(listCreditRequest);
    }
    @GetMapping("/{creditRequest_id}")
    public ResponseEntity<CreditRequest> getCreditRequest(@Param("creditRequest_id") UUID creditRequest_id) {
        var CreditRequest = creditRequestService.getById(creditRequest_id);
        if(CreditRequest == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(CreditRequest);
    }

    @GetMapping("/result/{creditresult_id}")
    public ResponseEntity<DetaisCreditResult> seeResultedCreditRequest( @PathVariable("creditresult_id") UUID creditresult_id) {  // CORRETO!
        return creditResultService.getDetaisCreditResult(creditresult_id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
