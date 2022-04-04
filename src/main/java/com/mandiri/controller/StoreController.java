package com.mandiri.controller;

import com.mandiri.entity.Store;
import com.mandiri.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class StoreController {

    @Autowired
    StoreService storeService;

    @PostMapping("/store")
    public Store saveStore(@Valid @RequestBody Store store){
        return storeService.registerStore(store);
    }
}
