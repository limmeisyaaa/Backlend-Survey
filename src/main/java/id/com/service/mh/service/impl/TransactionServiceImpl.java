package id.com.service.mh.service.impl;

import id.com.service.mh.dto.TransactionSearchDTO;
import id.com.service.mh.entity.Transaction;
import id.com.service.mh.repository.TransactionRepository;
import id.com.service.mh.service.CustomerService;
import id.com.service.mh.service.TransactionService;
import id.com.service.mh.specification.TransactionSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    CustomerService customerService;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, CustomerService customerService) {
        this.transactionRepository = transactionRepository;
        this.customerService = customerService;
    }

    @Override
    public Page<Transaction> getAllTrxPerPage(Pageable pageable, TransactionSearchDTO transactionSearchDTO) {
        Specification<Transaction> transactionSpecification = TransactionSpecification.getSpecification(transactionSearchDTO);
        return transactionRepository.findAll(transactionSpecification, pageable);
    }

    @Override
    public Page<TransactionSearchDTO> getAllTrxByCustomerNik(String nik, Pageable pageable) {
        TransactionSearchDTO transactionSearchDTO = new TransactionSearchDTO();
        return transactionRepository.findAllByCustomerIdNikAndIsDelete(nik, pageable, false).map(TransactionSearchDTO::new);
    }

    @Override
    public Transaction getTrxById(String trxId) {
        return transactionRepository.findById(trxId).get();
    }

    @Override
    public Transaction updateStatusSurvey(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
