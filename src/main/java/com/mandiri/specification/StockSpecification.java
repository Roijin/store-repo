package com.mandiri.specification;

import com.mandiri.dto.StockItemForm;
import com.mandiri.entity.Stock;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StockSpecification implements Specification<Stock> {
    private StockItemForm stockItemForm;
    private String id;

    public StockSpecification(StockItemForm stockItemForm){
        this.stockItemForm = stockItemForm;
    }

    public StockSpecification(String id){
        this.id = id;
    }


    @Override
    public Predicate toPredicate(Root<Stock> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (id!=null){
            Predicate byUserId = criteriaBuilder.equal(root.get("storeId"),id);
            predicates.add(byUserId);
        }
        else {
        if (!stockItemForm.getName().isEmpty()){
            Predicate byName = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+stockItemForm.getName().toLowerCase()+"%");
            predicates.add(byName);
        }

        if (stockItemForm.getMinPrice() != null){
            Predicate byPrice = criteriaBuilder.ge(root.get("price"),stockItemForm.getMinPrice());
            predicates.add(byPrice);
        }
        if (stockItemForm.getMaxPrice() != null){
            Predicate byPrice = criteriaBuilder.le(root.get("price"),stockItemForm.getMaxPrice());
            predicates.add(byPrice);
        }}

        Predicate [] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);

        return criteriaBuilder.and(arrayPredicates);
    }
}
