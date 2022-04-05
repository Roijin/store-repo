package com.mandiri.service;

import com.mandiri.constants.ResponseMessage;
import com.mandiri.dto.CustomPage;
import com.mandiri.dto.StockItemForm;
import com.mandiri.entity.Stock;
import com.mandiri.entity.Store;
import com.mandiri.repository.StockRepository;
import com.mandiri.repository.StoreRepository;
import com.mandiri.specification.StockSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StockService implements CRUDService<Stock, StockItemForm, String>{

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StoreRepository storeRepository;

    @Override
    public CustomPage<Stock> findAll(StockItemForm stockItemForm, Pageable pageable) {
        StockSpecification stockSpecification = new StockSpecification(stockItemForm);
        Page<Stock> stockPage = stockRepository.findAll(stockSpecification,pageable);
        return new CustomPage<Stock>(stockPage);
    }

    @Override
    public Stock getById(String id) {
        if(!stockRepository.existsById(id)){
            String message = String.format(ResponseMessage.RESOURCE_NOT_FOUND, Store.class.getSimpleName(),id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
        return stockRepository.findById(id).get();

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
    public Stock update(Stock stock) {
        getById(stock.getId());

        return stockRepository.save(stock);
    }

    @Override
    public void deleteById(String id) {
        stockRepository.deleteById(id);
    }
}
