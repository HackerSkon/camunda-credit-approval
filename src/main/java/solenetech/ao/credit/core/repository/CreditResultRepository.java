package solenetech.ao.credit.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import solenetech.ao.credit.core.entity.CreditRequest;
import solenetech.ao.credit.core.entity.CreditResult;

import java.util.List;
import java.util.UUID;


public interface CreditResultRepository extends JpaRepository<CreditResult, UUID> {

  CreditResult findByCreditRequestId(@Param("creditrequest_id") UUID creditrequest_id);
}