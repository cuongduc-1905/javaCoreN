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
public class Shoes implements Serializable{
    
    private int Id;
    private String name;
    private float price;
    private int Year;
    private String Desciption;

    public Shoes() {
    }

    public Shoes(int Id, String name, float price, int Year, String Desciption) {
        this.Id = Id;
        this.name = name;
        this.price = price;
        this.Year = Year;
        this.Desciption = Desciption;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public String getDesciption() {
        return Desciption;
    }

    public void setDesciption(String Desciption) {
        this.Desciption = Desciption;
    }
    
    public void inputData(){
        Scanner input = new Scanner(System.in);
        input.nextLine();
        System.out.println("nhap ten ");
        name = input.nextLine();
        System.out.println("nhap so tien");
        price = input.nextFloat();
        System.out.println("nhap nam");
        Year = input.nextInt();
        System.out.println("nhap mo ta");
        Desciption = input.nextLine();
    }
    public void display(){
        System.out.println("thong tin cu sinh vien");
        System.out.println(
                "ID:"+ Id +"\n" 
                +"name:"+ name +"\n"
                +"price:"+ price +"\n"
                +"Year:"+ Year +"\n"
                +"Desciption:" + Desciption +"\n"
        );
    }
            
    
    
}
