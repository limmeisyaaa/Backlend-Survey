package id.com.service.mh.service;

import id.com.service.mh.dto.TransactionSearchDTO;
import id.com.service.mh.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {
    Page<Transaction> getAllTrxPerPage(Pageable pageable, TransactionSearchDTO transactionSearchDTO);
    Page<TransactionSearchDTO> getAllTrxByCustomerNik(String nik, Pageable pageable);
    Transaction getTrxById(String trxId);
    Transaction updateStatusSurvey(Transaction transaction);
}
