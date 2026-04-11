package solenetech.ao.credit.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solenetech.ao.credit.core.entity.CreditResult;

import java.util.UUID;

public interface CreditResultRepository extends JpaRepository<CreditResult, UUID> {
}
