package com.mandiri.controller;

import com.mandiri.entity.Stock;
import com.mandiri.entity.Store;
import com.mandiri.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
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


}
