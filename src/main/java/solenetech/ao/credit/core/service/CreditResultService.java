package solenetech.ao.credit.core.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import solenetech.ao.credit.api.dtos.DetaisCreditResult;
import solenetech.ao.credit.core.entity.CreditResult;
import solenetech.ao.credit.core.repository.CreditRequestRepository;
import solenetech.ao.credit.core.repository.CreditResultRepository;

import java.util.Optional;
import java.util.UUID;


@AllArgsConstructor
@Service
public class CreditResultService {
    private final CreditResultRepository creditResultRepository;

    public Optional<DetaisCreditResult> getDetaisCreditResult(UUID id) {

        return creditResultRepository.findById(id).
                map(result -> new DetaisCreditResult(
                        result.getId(),
                        result.getStatus(),
                        result.getScore()
                ));
    }

}
