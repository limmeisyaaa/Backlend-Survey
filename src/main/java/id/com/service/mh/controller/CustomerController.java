package id.com.service.mh.controller;

import id.com.service.mh.constant.ApiUrlConstant;
import id.com.service.mh.constant.ResponseMessage;
import id.com.service.mh.dto.CustomerDTO;
import id.com.service.mh.service.CustomerService;
import id.com.service.mh.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiUrlConstant.CUSTOMER)
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{nik}")
    public ResponseEntity<Response<CustomerDTO>> readCustomerByNik(@PathVariable String nik){
        String message = String.format(ResponseMessage.READ, ResponseMessage.CUSTOMER);
        CustomerDTO customerDTO = customerService.readCustomerByNik(nik);
        Response<CustomerDTO> response = new Response<>(message, customerDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
