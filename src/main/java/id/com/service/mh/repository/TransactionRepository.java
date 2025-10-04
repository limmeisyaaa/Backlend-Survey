package id.com.service.mh.repository;

import id.com.service.mh.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String>, JpaSpecificationExecutor<Transaction> {
    Page<Transaction> findAllByCustomerIdNikAndIsDelete(String nik, Pageable pageable, Boolean isDelete);

}
