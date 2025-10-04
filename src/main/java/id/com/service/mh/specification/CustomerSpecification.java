package id.com.service.mh.specification;

import id.com.service.mh.dto.CustomerSearchDTO;
import id.com.service.mh.entity.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CustomerSpecification {

    public static Specification<Customer> getSpecification(CustomerSearchDTO customerSearchDTO){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(customerSearchDTO.getSearchByNik() != null){
                Predicate customerNik = criteriaBuilder.like(criteriaBuilder.lower(root.get("nik")), "%" + customerSearchDTO.getSearchByNik().toLowerCase() + "%");
                predicates.add(customerNik);
            }
            if(customerSearchDTO.getSearchByFullName() != null){
                Predicate customerFullName = criteriaBuilder.like(criteriaBuilder.lower(root.get("fullName")), "%" + customerSearchDTO.getSearchByFullName().toLowerCase() + "%");
                predicates.add(customerFullName);
            }

            Predicate[] arrayPredicates = predicates.toArray(new Predicate[0]);
            return criteriaBuilder.and(arrayPredicates);
        });
    }
}
