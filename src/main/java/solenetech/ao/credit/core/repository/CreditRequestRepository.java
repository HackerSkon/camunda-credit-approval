package solenetech.ao.credit.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solenetech.ao.credit.core.entity.CreditRequest;

import java.rmi.server.UID;

public interface CreditRequestRepository extends JpaRepository<CreditRequest, UID> {
}
