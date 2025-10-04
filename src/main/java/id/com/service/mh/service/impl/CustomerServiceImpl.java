package id.com.service.mh.service.impl;

import id.com.service.mh.constant.ResponseMessage;
import id.com.service.mh.dto.CustomerDTO;
import id.com.service.mh.entity.Customer;
import id.com.service.mh.entity.shared.AppUser;
import id.com.service.mh.repository.CustomerRepository;
import id.com.service.mh.service.CustomerService;
import id.com.service.mh.utils.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer readCustomerById(String id) {
        return customerRepository.findById(id).get();
    }
    @Override
    public CustomerDTO readCustomerByNik(String nik) {
        if (customerRepository.findByNik(nik).isPresent()){
            Customer customer = customerRepository.findByNik(nik).get();
            return new CustomerDTO(customer);
        }
        else{
            throw new DataNotFoundException("Error");
        }
    }
    @Override
    public Customer readCustomer(String nik) {
        return customerRepository.findByNik(nik).get();
    }

    @Override
    public Customer findCustomerByAppUser(AppUser appUser) {
        return customerRepository.findCustomerByUserId(appUser);
    }

    @Override
    public String uploadCustomerData(MultipartFile file) {
        try{
            if (file == null || file.isEmpty()) {
                throw new Exception("File is empty or null");
            }

            if (!isValidCsvFile(file)) {
                throw new Exception("Invalid file type. Please upload a CSV file");
            }

            List<Customer> customerList = processFile(file);
            customerRepository.saveAll(customerList);

            return String.format(ResponseMessage.UPLOAD, ResponseMessage.CUSTOMER);
        } catch (Exception ee){
            return ee.getMessage();
        }
    }

    private List<Customer> processFile(MultipartFile file) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            List<Customer>  customerList = br.lines()
                    .filter(line -> !line.trim().isEmpty()) // Skip empty lines
                    .map(line -> {
                        String[] dataList = line.split(",");
                        if (dataList.length < 17) {
                            throw new IllegalArgumentException(
                                    String.format("Invalid data format. Expected at least 17 columns, got %d", dataList.length));
                        }
                        return CustomerDTO.createCustomer(dataList);
                    })
                    .collect(Collectors.toList());

            Map<String, Long> duplicateNikCount = customerList.stream()
                    .collect(Collectors.groupingBy(Customer::getNik, Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() > 1)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            if (duplicateNikCount != null || !duplicateNikCount.isEmpty()){
                throw new Exception("Duplicate NIKs found: " + duplicateNikCount);
            } else return customerList;
        }
    }

    private boolean isValidCsvFile(MultipartFile file) {
        String contentType = file.getContentType();
        String filename = file.getOriginalFilename();

        return (contentType != null && contentType.equals("text/csv")) ||
                (filename != null && filename.toLowerCase().endsWith(".csv"));
    }
}
