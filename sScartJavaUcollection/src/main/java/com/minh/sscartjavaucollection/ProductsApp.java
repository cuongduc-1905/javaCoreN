/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minh.sscartjavaucollection;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minh
 */
public class ProductsApp {
    
    private final List<Product> product = new ArrayList<>();

    public ProductsApp() {
        this.initStoreItems();
    }

    public List<Product> getProduct() {
        return product;
    }

    public void initStoreItems() {
        String [] productName = {"products a", "product b" , "product c"};
        float [] productPrice = {40f,30f,50f};
        Integer [] stock = {10, 6 , 10};
        
        for(int i =0; i < productName.length; i++){
            this.product.add(new Product(
                    i + 1, productName[i], 
                    productPrice[i], 
                    stock[i])
            );
        }
    }
    
    
    
    
    
}
