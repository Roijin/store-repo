package com.mandiri.dto;

import java.io.Serializable;
import java.util.Objects;

public class StockItemForm implements Serializable {
    private final String name;
    private final Integer minPrice;
    private final Integer maxPrice;

    public StockItemForm(String name,  Integer minPrice, Integer maxPrice) {
        this.name = name;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getName() {
        return name;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

}
