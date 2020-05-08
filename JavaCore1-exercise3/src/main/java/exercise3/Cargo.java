/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise3;

import java.util.Scanner;

/**
 *
 * @author minh
 */
public abstract class Cargo {
    private int id;
    private String name;
    private String supplier;
    private int quantity;
    private float price;
    
    public abstract float tax();
    
    public abstract int ngay();
   // public abstract int ngay();
    public Cargo(){
        
    }
    public Cargo(int id, String name, String supplier, float price) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.price = price;
    }
    
    public void inputData(){
        Scanner input = new Scanner(System.in);
        System.out.println("nhap ma hang");
        id = Integer.parseInt(input.nextLine());
        //nhap dung name dinh dang
        boolean isDone = false;
        do{
            System.out.println("nhap ten hang");
            this.name = input.nextLine();
            if(this.name.length() >=5 && this.name.length() <= 32){
                isDone = true;
            }else{
                System.out.println("nhap tu 5 den 32 ky tuc");
            }    
           
        }while(!isDone);
        
        //nhap supplier
        do{
            System.out.println("nhap ten nha cung cap");
            this.supplier = input.nextLine();
            if(this.supplier.length() >= 32 && this.supplier.length() <= 128){
                isDone = true;
            }else{
                System.out.println("gioi han tu 32 den 128 ky tu");
            }
        }while(!isDone);
        
        do{
            System.out.println("nhap so luong");
            this.quantity = Integer.parseInt(input.nextLine());
            if(this.quantity >= 0 ){
                isDone = true;
            }else{
                System.out.println("lon hon hoac bang 0");
            }
        }while(!isDone);
        
        do{
            System.out.println("nhap gia");
            this.price = Float.parseFloat(input.nextLine());
            if(this.price >= 0){
                isDone = true;
            }else{
                System.out.println("lon hon hoac bang 0");
            }
            
        }while(!isDone);
        
 
        
    }
    
    
    public void displayData(){
        System.out.println("thong tin don hang");
        System.out.println("\tthong tin id:" + id);
        System.out.println("\tthong tin name:" + name);
        System.out.println("\tthong tin supplier:" + supplier);
        System.out.println("\tthong tin quantity:" + quantity);
        System.out.println("\tthong tin price:" + price);
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

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

   

    
    
    
}
