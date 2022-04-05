package com.mandiri.repository;

import com.mandiri.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, String> {
    public Page<Store> findAllByNameContainingOrAddressContainingOrPhoneNumberContaining(String name, String address, String phoneNumber, Pageable pageable);

    public List<Store> findAllByName(String name);
    public List<Store> findAllByAddress(String address);
    public List<Store> findAllByPhoneNumber(String phoneNumber);

}