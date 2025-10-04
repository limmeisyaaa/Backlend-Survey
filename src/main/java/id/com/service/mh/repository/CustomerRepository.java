package id.com.service.mh.repository;

import id.com.service.mh.entity.Customer;
import id.com.service.mh.entity.shared.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {
    Optional<Customer> findByNik(String nik);
    Customer findCustomerByUserId(AppUser appUser);
}
