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

    public StockSpecification(StockItemForm stockItemForm){
        this.stockItemForm = stockItemForm;
    }

    @Override
    public Predicate toPredicate(Root<Stock> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (!stockItemForm.getName().isEmpty()){
            Predicate byName = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+stockItemForm.getName().toLowerCase()+"%");
            predicates.add(byName);
        }

        if (stockItemForm.getMinPrice()!=0&&stockItemForm.getMaxPrice()!=0){
            Predicate byPrice = criteriaBuilder.between(root.get("price"),stockItemForm.getMinPrice(),stockItemForm.getMaxPrice());
            predicates.add(byPrice);
        }
        Predicate [] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);

        return criteriaBuilder.and(arrayPredicates);
    }
}
