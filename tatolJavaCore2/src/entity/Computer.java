/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author minh
 */
public class Computer implements Serializable{
    private int Id;
    private String Name;
    private float Price;
    private int Year;
    private int qty;

    public Computer() {
    }

    public Computer(int Id, String Name, float Price, int Year, int qty) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.Year = Year;
        this.qty = qty;
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

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    
    public void inputData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ten");
        Name = sc.nextLine();
        System.out.println("nhap gia");
        Price = sc.nextFloat();
        System.out.println("nhap nam");
        Year = sc.nextInt();
        System.out.println("nhap so luong");
        qty = sc.nextInt();
        
    }
    public void display(){
        System.out.println(this.Id +"\t"+ this.Name +"\t"+ this.Price +"\t"+ this.Year +"\t"+ this.qty);
    }
    public String inputWrite(){
        return this.Id +","+ this.Name +","+ this.Price +","+ this.Year +","+ this.qty;
 
    }
     public void inputExport(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap id");
        Id = sc.nextInt();
        sc.nextLine();
        System.out.println("nhap so luong xuat");
        qty = sc.nextInt();
    } 
     
    public void Update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap id");
        Id = sc.nextInt();
        System.out.println("nhap gia");
        Price = sc.nextFloat();
        System.out.println("nhap so luong");
        qty = sc.nextInt();
        
    } 
    public void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap id");
        Id = sc.nextInt();
    } 
}
