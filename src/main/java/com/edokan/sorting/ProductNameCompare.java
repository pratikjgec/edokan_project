package com.edokan.sorting;

import java.util.Comparator;

import com.edokan.Entity.Product;

public class ProductNameCompare implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return product1.getpName().compareTo(product2.getpName());
    }
}
