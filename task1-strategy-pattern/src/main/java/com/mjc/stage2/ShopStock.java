package com.mjc.stage2;

import java.util.ArrayList;
import java.util.List;

public class ShopStock {
    private final List<Product> productList;

    public ShopStock(List<Product> productList) {
        this.productList = productList;
    }

    // Write your code here!
    int size = 0;
    public void addProduct(Product product) {
        productList.add(product);
        size++;
    }

    public Product getProduct() {
        Product product;
        if (size >= 0) {
            return productList.get(productList.size() - 1);
        }
        return null;
    }

    public List<Product> executeFilteringStrategy(FilteringStrategy filteringStrategy){
        List<Product> list = new ArrayList<>();
        for (Product product : productList){
            if(filteringStrategy.filter(product)){
                list.add(product);
            }
        }
        return list;
    }
}
