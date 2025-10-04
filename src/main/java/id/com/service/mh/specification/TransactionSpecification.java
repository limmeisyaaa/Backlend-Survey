package id.com.service.mh.specification;

import id.com.service.mh.dto.TransactionSearchDTO;
import id.com.service.mh.entity.Transaction;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class TransactionSpecification {

    public static Specification<Transaction> getSpecification(TransactionSearchDTO transactionSearchDTO){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(transactionSearchDTO.getNik()!= null){
                Predicate customerNik = criteriaBuilder.like(criteriaBuilder.lower(root.get("customerId").get("nik")), "%" + transactionSearchDTO.getNik().toLowerCase() + "%");
                predicates.add(customerNik);
            }
            if(transactionSearchDTO.getFullName() != null){
                Predicate customerName = criteriaBuilder.like(criteriaBuilder.lower(root.get("customerId").get("fullName")), "%" + transactionSearchDTO.getFullName().toLowerCase() + "%");
                predicates.add(customerName);
            }
            if(transactionSearchDTO.getDelete()!= null){
                Predicate isSurvey = criteriaBuilder.equal(root.get("isDelete"), transactionSearchDTO.getDelete());
                predicates.add(isSurvey);
            }

            Predicate[] arrayPredicates = predicates.toArray(new Predicate[0]);
            return criteriaBuilder.and(arrayPredicates);
        });
    }
}
