package com.mandiri.controller;

import com.mandiri.entity.Store;
import com.mandiri.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
            @RequestParam (defaultValue = "5") Integer size,
            @RequestParam (defaultValue = "")String keyword) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return storeService.search(pageable,keyword);
    }

    @DeleteMapping("/store")
    public void deleteStore(@RequestParam String id){
        storeService.delete(id);
    }

    @GetMapping("/store/{id}")
    public Store getById(@PathVariable String id){
        return storeService.getById(id);
    }

    @PutMapping("/store")
    public Store updateStore(@Valid @RequestBody Store store){
        return storeService.update(store);
    }

    @GetMapping("/store/name")
    public List<Store> getByName(@RequestParam String name){
        return storeService.getByName(name);
    }

    @GetMapping("/store/address")
    public List<Store> getByAddress(@RequestParam String address){
        return storeService.getByAddress(address);
    }

    @GetMapping("/store/phone")
    public List<Store> getByPhoneNumber(@RequestParam String phoneNumber){
        return storeService.getByPhoneNumber(phoneNumber);
    }
}
