package solenetech.ao.credit.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solenetech.ao.credit.core.entity.CreditResult;

import java.rmi.server.UID;

public interface CreditResultRepository extends JpaRepository<CreditResult, UID> {
}
