package com.mandiri.service;

import com.mandiri.entity.Store;
import com.mandiri.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;


    public Store registerStore(Store store) {
        return storeRepository.save(store);
    }

    public Page<Store> search(Pageable pageable) {
        return storeRepository.findAll(pageable);
    }
}
