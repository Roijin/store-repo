package com.mandiri.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public class CustomPage<T> {

    private List<T> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalPages;
    private Long totalElement;

    public CustomPage(Page<T> pageData) {
        this.content = pageData.getContent();
        this.pageNumber = pageData.getPageable().getPageNumber()+1;
        this.pageSize = pageData.getPageable().getPageSize();
        this.totalPages = pageData.getTotalPages();
        this.totalElement = pageData.getTotalElements();
    }

    public List<T> getContent() {
        return content;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Long getTotalElement() {
        return totalElement;
    }
}
