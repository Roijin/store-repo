package com.mandiri.service;

import com.mandiri.constants.ResponseMessage;
import com.mandiri.entity.Stock;
import com.mandiri.entity.Store;
import com.mandiri.repository.StockRepository;
import com.mandiri.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StockService implements CRUDService<Stock, String>{

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StoreRepository storeRepository;

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
        if(!storeRepository.existsById(stock.getStoreId())){
            String message = String.format(ResponseMessage.RESOURCE_NOT_FOUND, Store.class.getSimpleName(),stock.getStoreId());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
        return stockRepository.save(stock);
    }

    @Override
    public void update(Stock stock) {

    }

    @Override
    public void deleteById(String id) {
        stockRepository.deleteById(id);
    }
}
