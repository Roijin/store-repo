package com.mandiri.service;

import com.mandiri.dto.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CRUDService<T,U,ID> {

    public CustomPage<T> findAll(U u,Pageable pageable);
    public T getById(ID id);
    public T register(T t);
    public T update(T t);
    public void deleteById(ID id);

}
