package solenetech.ao.credit.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import solenetech.ao.credit.api.dtos.CreatCreditRequest;
import solenetech.ao.credit.core.entity.CreditRequest;
import solenetech.ao.credit.core.service.CreditRequestService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/creditrequests")
public class CreditRequestController {
    private final CreditRequestService creditRequestService;
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

}
