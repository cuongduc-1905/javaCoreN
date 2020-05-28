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
public class Product {
    private int Id;
    private String Name;
    private String Producer;
    private int qty;
    private float price ;
    private int VAT;

    public Product() {
    }

    public Product(int Id, String Name, String Producer, int qty, float price, int VAT) {
        this.Id = Id;
        this.Name = Name;
        this.Producer = Producer;
        this.qty = qty;
        this.price = price;
        this.VAT = VAT;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String Producer) {
        this.Producer = Producer;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getVAT() {
        return VAT;
    }

    public void setVAT(int VAT) {
        this.VAT = VAT;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        System.out.println("nhap ten san pham");
        Name = sc.nextLine();
        System.out.println("nhap nha san xuat");
        Producer = sc.nextLine();
        System.out.println("nhap so luong san pham");
        qty = Integer.parseInt(sc.nextLine());
        System.out.println("nhap gia san pham");
        price = Float.parseFloat(sc.nextLine());
        System.out.println("nhap VAT san pham");
        VAT = Integer.parseInt(sc.nextLine());
    }
    
    public void display(){
        System.out.printf("%2d %-15s %-15s %3d %8.2f %2d\n",this.Id,
                this.Name,this.Producer,this.VAT,this.price,this.qty);
    }
    
    public void update(){
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        System.out.println("nhap ten ma san pham");
        Id = Integer.parseInt(sc.nextLine());
        System.out.println("nhap ten san pham");
        Name = sc.nextLine();
        System.out.println("nhap nha san xuat");
        Producer = sc.nextLine();
        System.out.println("nhap so luong san pham");
        qty = Integer.parseInt(sc.nextLine());
        System.out.println("nhap gia san pham");
        price = Float.parseFloat(sc.nextLine());
        System.out.println("nhap VAT san pham");
        VAT = Integer.parseInt(sc.nextLine());
    }
    
    public void export(){
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        System.out.println("nhap ten ma san pham");
        Id = Integer.parseInt(sc.nextLine());
        System.out.println("nhap so luong muon xuat");
        qty = Integer.parseInt(sc.nextLine());
    }
    
    
}
