package solenetech.ao.credit.api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import solenetech.ao.credit.core.entity.CreditRequest;
import solenetech.ao.credit.core.enuns.ResultStatus;

import java.util.UUID;

public record DetaisCreditResult(UUID id,ResultStatus status, double score) {
}
