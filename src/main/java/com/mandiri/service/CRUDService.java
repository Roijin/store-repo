package com.mandiri.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CRUDService<T,ID> {

    public Page<T> findAll(Pageable pageable);
    public T getById(ID id);
    public T register(T t);
    public void update(T t);
    public void deleteById(ID id);

}
