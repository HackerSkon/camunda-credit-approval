package solenetech.ao.credit.api.dtos;

import jakarta.persistence.*;
import solenetech.ao.credit.core.entity.CreditResult;
import solenetech.ao.credit.core.enuns.RequestStatus;

import java.util.UUID;

public record CreatCreditRequest(String name, double income, int age) {
    public CreatCreditRequest {
        if (income <= 0 ) {
            throw new IllegalArgumentException("Income must be positive");
        }
        if (age < 18 || age > 45) {
            throw new IllegalArgumentException("Age must be between 18 and 45");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
    }
    public static CreatCreditRequest of(String name, Double income, Integer age)  {
        return new CreatCreditRequest(name,income, age);
    }

}

