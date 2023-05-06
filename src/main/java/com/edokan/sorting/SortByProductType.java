package com.edokan.sorting;

import java.util.Comparator;

import com.edokan.Entity.Product;

public class SortByProductType implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return product1.getpType().compareTo(product2.getpType());
    }
}
