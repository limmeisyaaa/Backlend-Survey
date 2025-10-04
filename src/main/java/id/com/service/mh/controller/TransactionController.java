package id.com.service.mh.controller;

import id.com.service.mh.constant.ApiUrlConstant;
import id.com.service.mh.constant.ResponseMessage;
import id.com.service.mh.dto.TransactionSearchDTO;
import id.com.service.mh.entity.Customer;
import id.com.service.mh.entity.Transaction;
import id.com.service.mh.entity.shared.AppUser;
import id.com.service.mh.service.AuthService;
import id.com.service.mh.service.CustomerService;
import id.com.service.mh.service.TransactionService;
import id.com.service.mh.utils.PageResponseWrapper;
import id.com.service.mh.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiUrlConstant.TRX)
public class TransactionController {
    TransactionService transactionService;
    AuthService authService;
    CustomerService customerService;

    @Autowired
    public TransactionController(TransactionService transactionService, AuthService authService, CustomerService customerService) {
        this.transactionService = transactionService;
        this.authService = authService;
        this.customerService = customerService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_STAFF', 'ROLE_SUPERVISOR', 'ROLE_MANAGER')")
    public ResponseEntity<Response<PageResponseWrapper<Transaction>>> getAllTrxPerPage(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                                                                            @RequestParam(name = "size", defaultValue = "6") Integer size,
                                                                                            @RequestParam(name = "SortBy", defaultValue = "trxId") String sortBy,
                                                                                            @RequestParam(name = "direction", defaultValue = "ASC") String direction,
                                                                                       @RequestParam(name = "nik", required = false) String nik,
                                                                                       @RequestParam(name = "fullName", required = false) String fullName){
        String message = String.format(ResponseMessage.READ, ResponseMessage.TRX);
        Pageable pageable = PageRequest.of(page-1, size, Sort.by(Sort.Direction.fromString(direction),sortBy));
        TransactionSearchDTO transactionSearchDTO = new TransactionSearchDTO();
        transactionSearchDTO.setNik(nik);
        transactionSearchDTO.setFullName(fullName);
        Page<Transaction> transactionPage = transactionService.getAllTrxPerPage(pageable, transactionSearchDTO);
        Response<PageResponseWrapper<Transaction>> response = new Response<>(message, new PageResponseWrapper<>(transactionPage));
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<Response<PageResponseWrapper<TransactionSearchDTO>>> getAllTrxByCustomerNikPerPage(Authentication authentication,
                                                                                                             @RequestParam(name = "page", defaultValue = "1") Integer page,
                                                                                                             @RequestParam(name = "size", defaultValue = "6") Integer size,
                                                                                                             @RequestParam(name = "SortBy", defaultValue = "customerId") String sortBy,
                                                                                                             @RequestParam(name = "direction", defaultValue = "ASC") String direction){
        AppUser appUser = authService.getAppUserByToken(authentication);
        Customer customer = customerService.findCustomerByAppUser(appUser);
        String message = String.format(ResponseMessage.READ, ResponseMessage.TRX);
        Pageable pageable = PageRequest.of(page-1, size, Sort.by(Sort.Direction.fromString(direction),sortBy));
        Page<TransactionSearchDTO> transactionPage = transactionService.getAllTrxByCustomerNik(customer.getNik(), pageable);
        Response<PageResponseWrapper<TransactionSearchDTO>> response = new Response<>(message, new PageResponseWrapper<>(transactionPage));
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/id/{trxId}")
    public ResponseEntity<Response<Transaction>> readTrxById(@PathVariable String trxId){
        String message = String.format(ResponseMessage.READ, ResponseMessage.TRX);
        Response<Transaction> response = new Response<>(message, transactionService.getTrxById(trxId));
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
