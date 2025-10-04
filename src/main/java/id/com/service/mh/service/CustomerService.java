package id.com.service.mh.service;

import id.com.service.mh.dto.CustomerDTO;
import id.com.service.mh.entity.Customer;
import id.com.service.mh.entity.shared.AppUser;
import org.springframework.web.multipart.MultipartFile;

public interface CustomerService {
    Customer readCustomerById(String id);
    CustomerDTO readCustomerByNik(String nik);
    Customer readCustomer(String nik);
    Customer findCustomerByAppUser(AppUser appUser);
    String uploadCustomerData(MultipartFile file);
}
