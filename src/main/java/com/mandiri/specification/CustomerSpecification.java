package com.mandiri.specification;

import com.mandiri.dto.CustomerForm;
import com.mandiri.entity.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerSpecification implements Specification<Customer> {

    private CustomerForm customerForm;

    public CustomerSpecification(CustomerForm customerForm) {
        this.customerForm = customerForm;
    }

    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if(!customerForm.getName().isEmpty()){
            Predicate byName = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+customerForm.getName().toLowerCase()+"%");
            predicates.add(byName);
        }
        if(!customerForm.getUsername().isEmpty()){
            Predicate byUserName = criteriaBuilder.like(criteriaBuilder.lower(root.get("username")),"%"+customerForm.getUsername().toLowerCase()+"%");
            predicates.add(byUserName);
        }
        if(!customerForm.getEmail().isEmpty()){
            Predicate byEmail = criteriaBuilder.like(criteriaBuilder.lower(root.get("email")),"%"+customerForm.getEmail().toLowerCase()+"%");
            predicates.add(byEmail);
        }
        if(!customerForm.getGender().isEmpty()){
            Predicate byGender = criteriaBuilder.equal(criteriaBuilder.lower(root.get("gender")),customerForm.getGender().toLowerCase());
            predicates.add(byGender);
        }
        if(!customerForm.getPhoneNumber().isEmpty()){
            Predicate byPhoneNumber = criteriaBuilder.equal(criteriaBuilder.lower(root.get("phoneNumber")),customerForm.getPhoneNumber().toLowerCase());
            predicates.add(byPhoneNumber);
        }
        if(!(Math.abs(customerForm.getBirthDate().getYear()-LocalDate.now().getYear())>100)){
            Predicate byBirthDate = criteriaBuilder.equal(root.get("birthDate"),customerForm.getBirthDate());
            predicates.add(byBirthDate);
        }

        Predicate [] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);

        return criteriaBuilder.and(arrayPredicates);
    }
}
