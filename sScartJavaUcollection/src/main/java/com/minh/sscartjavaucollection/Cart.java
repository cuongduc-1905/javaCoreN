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
public class Cart {
    List<Product> cartItem = new ArrayList<>();
    
    public void addProductToCartById(int pid){
        Product product = getProductByProductId(pid);
        addToCart(product);
    }

    private Product getProductByProductId(int pid) {
        Product product = null;
        List<Product> products = new ProductsApp().getProduct();
        for(Product prod: products){
            if(prod.getPid() == pid){
                product = prod;
                break;
            }
        }
        return product;
    }

    private void addToCart(Product product) {
        cartItem.add(product);
    }
    
    public void removeProductById(int pid){
        Product prod = getProductByProductId(pid);
        cartItem.remove(prod);
    }
    void printCartItem(){
        for (Product product : cartItem) {
            System.out.println(product.getName());
        }
    }
}
