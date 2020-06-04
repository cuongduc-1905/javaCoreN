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
    private String category;
    private String DateStrart;
    private String DateEnd;

    public Product() {
    }

    public Product(int Id, String Name, String category, String DateStrart, String DateEnd) {
        this.Id = Id;
        this.Name = Name;
        this.category = category;
        this.DateStrart = DateStrart;
        this.DateEnd = DateEnd;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDateStrart() {
        return DateStrart;
    }

    public void setDateStrart(String DateStrart) {
        this.DateStrart = DateStrart;
    }

    public String getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(String DateEnd) {
        this.DateEnd = DateEnd;
    }
    
    public void inputData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ten san pham");
        Name = sc.nextLine();
        System.out.println("nhap loai san pham");
        category = sc.nextLine();
        System.out.println("nhap ngay bat dau");
        DateStrart = sc.nextLine();
        System.out.println("nhap ngay ket thuc");
        DateEnd = sc.nextLine();
    }
    public void display(){
        System.out.println(this.Id + "\t"+ this.Name + "\t" + this.category + "\t" + this.DateStrart + "\t" +this.DateEnd );
    }
    
}
