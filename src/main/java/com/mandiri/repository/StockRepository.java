package com.mandiri.repository;

import com.mandiri.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StockRepository extends JpaRepository<Stock, String>, JpaSpecificationExecutor<Stock> {
}