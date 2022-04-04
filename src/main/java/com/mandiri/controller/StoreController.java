package com.mandiri.controller;

import com.mandiri.entity.Store;
import com.mandiri.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StoreController {

    @Autowired
    StoreService storeService;

    @PostMapping("/store")
    public Store saveStore(@Valid @RequestBody Store store){
        return storeService.registerStore(store);
    }

    @GetMapping("/store")
    public Page<Store> getStores(
            @RequestParam(defaultValue = "1")Integer page,
            @RequestParam (defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return storeService.search(pageable);
    }
}
