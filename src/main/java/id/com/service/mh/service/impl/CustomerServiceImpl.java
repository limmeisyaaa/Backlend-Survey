package id.com.service.mh.service.impl;

import id.com.service.mh.dto.CustomerDTO;
import id.com.service.mh.entity.Customer;
import id.com.service.mh.entity.shared.AppUser;
import id.com.service.mh.repository.CustomerRepository;
import id.com.service.mh.service.CustomerService;
import id.com.service.mh.utils.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
