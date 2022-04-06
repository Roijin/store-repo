package com.mandiri.controller;

import com.mandiri.dto.CustomPage;
import com.mandiri.dto.StockItemForm;
import com.mandiri.entity.Stock;
import com.mandiri.entity.Store;
import com.mandiri.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @PostMapping
    public Stock saveStock(@Valid @RequestBody Stock stock){
        return stockService.register(stock);
    }

    @DeleteMapping
    public void deleteStock(@RequestParam String id){
        stockService.deleteById(id);
    }

    @PutMapping
    public Stock updateStock(@Valid @RequestBody Stock stock){
        return stockService.update(stock);
    }

    @GetMapping
    public CustomPage<Stock> findStock(
            @RequestParam (defaultValue = "1")Integer page,
            @RequestParam (defaultValue = "10") Integer size,
            @RequestParam (defaultValue = "") String searchName,
            @RequestParam (required = false)Integer searchMinPrice,
            @RequestParam (required = false)Integer searchMaxPrice
    ){
        StockItemForm stockItemForm = new StockItemForm(searchName,searchMinPrice,searchMaxPrice);
        Pageable pageable = PageRequest.of(page-1,size);
        return stockService.findAll(stockItemForm, pageable);
    }



}
