package com.mandiri.repository;

import com.mandiri.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    public List<Store> findAllByName(String name);
    public List<Store> findAllByAddress(String address);
    public List<Store> findAllByPhoneNumber(String phoneNumber);

}