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
public class Cargo {
    private int id;
    private String name;
    private String supplier;
    private int quantity;
    private float price;
    
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
        System.out.println("nhap ten hang");
        name = input.nextLine();
        System.out.println("nhap so luong ");
        quantity = Integer.parseInt(input.nextLine());
        System.out.println("nhap gia ");
        price = Float.parseFloat(input.nextLine());
    }
    
    
    public void displayData(){
        System.out.println("thong tin don hang");
        System.out.println("\tthong tin id:" + id);
        System.out.println("\tthong tin name:" + name);
        System.out.println("\tthong tin supplier:" + supplier);
        System.out.println("\tthong tin quantity:" + quantity);
        System.out.println("\tthong tin price:" + price);
    }
    
}
