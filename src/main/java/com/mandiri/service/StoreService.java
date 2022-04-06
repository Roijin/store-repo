package com.mandiri.service;

import com.mandiri.constants.ResponseMessage;
import com.mandiri.entity.Store;
import com.mandiri.repository.StoreRepository;
import org.hibernate.annotations.Cascade;
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

    public Store getById(String id){
        validateStore(id);
        return storeRepository.findById(id).get();

    }

    public void validateStore(String id) {
        if(!storeRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ResponseMessage.getResourceNotFound(Store.class.getSimpleName(), id));
        }
    }

    public Store registerStore(Store store) {
        return storeRepository.save(store);
    }


    public Page<Store> search(Pageable pageable, String keyword) {
        return storeRepository.findAllByNameContainingOrAddressContainingOrPhoneNumberContaining(keyword,keyword,keyword,pageable);
    }
    

    public void delete(String id) {

        storeRepository.deleteById(id);
    }

    public List<Store> getByName(String name) {
        return storeRepository.findAllByName(name);
    }

    public List<Store> getByAddress(String address) {
        return storeRepository.findAllByAddress(address);
    }

    public List<Store> getByPhoneNumber(String phoneNumber) {
        return storeRepository.findAllByPhoneNumber(phoneNumber);
    }
}
