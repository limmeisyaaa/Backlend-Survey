package id.com.service.mh.service;

import id.com.service.mh.dto.CustomerDTO;
import id.com.service.mh.entity.Customer;
import id.com.service.mh.entity.shared.AppUser;

public interface CustomerService {
    Customer readCustomerById(String id);
    CustomerDTO readCustomerByNik(String nik);
    Customer readCustomer(String nik);
    Customer findCustomerByAppUser(AppUser appUser);
}
