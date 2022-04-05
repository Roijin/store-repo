package com.mandiri.service;

import com.mandiri.entity.Stock;
import com.mandiri.repository.StockRepository;
import com.mandiri.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StockService implements CRUDService<Stock, String>{

    @Autowired
    StockRepository stockRepository;


    @Override
    public Page<Stock> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Stock getById(String s) {
        return null;
    }

    @Override
    public Stock register(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void update(Stock stock) {

    }

    @Override
    public void deleteById(String s) {

    }
}
