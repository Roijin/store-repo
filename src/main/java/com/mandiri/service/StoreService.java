package com.mandiri.service;

import com.mandiri.constants.ResponseMessage;
import com.mandiri.entity.Store;
import com.mandiri.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    public Store update(Store store) {
        getById(store.getId());

        return storeRepository.save(store);
    }

    public Store getById(Integer id){
        if(!storeRepository.existsById(id)){
            String message = String.format(ResponseMessage.RESOURCE_NOT_FOUND, Store.class.getSimpleName(),id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
        return storeRepository.findById(id).get();

    }

    public Store registerStore(Store store) {
        return storeRepository.save(store);
    }


    public Page<Store> search(Pageable pageable) {
        return storeRepository.findAll(pageable);
    }
    

    public void delete(Integer id) {
        storeRepository.deleteById(id);
    }

    public List<Store> getByName(String name) {
        return storeRepository.findAllByName(name);
    }

    public List<Store> getByAddress(String address) {
        return storeRepository.findAllByAddress(address);
    }
}
