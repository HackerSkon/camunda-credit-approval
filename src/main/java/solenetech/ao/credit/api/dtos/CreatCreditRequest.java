package solenetech.ao.credit.api.dtos;

import jakarta.persistence.*;
import solenetech.ao.credit.core.entity.CreditResult;
import solenetech.ao.credit.core.enuns.RequestStatus;

import java.util.UUID;

public record CreatCreditRequest(String id, String name, double income, int age) {
}

