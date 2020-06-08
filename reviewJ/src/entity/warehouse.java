/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Scanner;

/**
 *
 * @author minh
 */
public class warehouse {
    private int id;
    private String name;
    private String date;
    private int qty;
    private float price;
    
    public warehouse() {
    }
    
    public warehouse(int id, String name, String date, int qty, float price) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.qty = qty;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQyt() {
        return qty;
    }

    public void setQyt(int qyt) {
        this.qty = qty;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void inputData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ban nhap ten ");
        name = sc.nextLine();
        System.out.println("ban nhap ngay");
        date = sc.nextLine();
        System.out.println("ban nhap so luong ");
        qty = Integer.parseInt(sc.nextLine());
        System.out.println("ban nhap price");
        
    }
    public void display(){
        System.out.println(this.id + this.name + this.date + this.price +this.qty);
    }
    
    
    
    
}
