/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minh.sscartjavaucollection;

import java.util.Objects;

/**
 *
 * @author minh
 */
public class Product {
    private Integer pid;
    private String name;
    private float price;
    private Integer stock;

    public Product() {
    }

    public Product(Integer pid, String name, float price, Integer stock) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Integer getPid() {
        return pid;
    }
    public void setPid(Integer pid){
        this.pid = pid;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.pid);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.price);
        hash = 29 * hash + Objects.hashCode(this.stock);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Product other = (Product) obj;
        if(!Objects.equals(this.name, other.name)){
            return false;
        }
        if(!Objects.equals(this.pid, other.pid)){
            return false;
        }
        if(!Objects.equals(this.price, other.price)){
            return false;
        }
        if(!Objects.equals(this.stock, other.stock)){
            return false;
        }
        return true;
    }
    
    
    
    
}
