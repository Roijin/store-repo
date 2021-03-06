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

import java.util.List;

@Service
public class StockService implements CRUDService<Stock, StockItemForm, String>{

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StoreService storeService;

    @Override
    public CustomPage<Stock> findAll(StockItemForm stockItemForm, Pageable pageable) {
        StockSpecification stockSpecification = new StockSpecification(stockItemForm);
        Page<Stock> stockPage = stockRepository.findAll(stockSpecification,pageable);
        return new CustomPage<Stock>(stockPage);
    }

    @Override
    public Stock getById(String id) {
        stockValidation(id);
        return stockRepository.findById(id).get();

    }

    public List<Stock> getByStoreId(String id){
        storeService.validateStore(id);
        StockSpecification stockSpecification = new StockSpecification(id);
        return stockRepository.findAll(stockSpecification);
    }

    private void stockValidation(String id) {
        if(!stockRepository.existsById(id)){
            String message = String.format(ResponseMessage.RESOURCE_NOT_FOUND, Store.class.getSimpleName(), id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
    }

    @Override
    public Stock register(Stock stock) {
//        storeService.validateStore(stock.getStoreId());
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
