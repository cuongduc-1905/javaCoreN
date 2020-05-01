/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duongvanminh;
import java.util.Scanner;
/**
 *
 * @author minh
 */
public class GiangVien {
    String nameGv;
    String address;
    String phone;
    int     time;
           
            
    public  GiangVien(){
    }
    
     public  GiangVien(String nameGv, String address,String phone,int time){
         this.nameGv = nameGv;
         this.address = address;
         this.phone = phone;
         this.time = time;
     }

    public String getNameGv() {
        return nameGv;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getTime() {
        return time;
    }

    public void setNameGv(String nameGv) {
        this.nameGv = nameGv;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTime(int time) {
        this.time = time;
    }
    public void input(){
        Scanner input = new Scanner(System.in);
        System.out.println("nhap ten giao vien:");
        nameGv = input.nextLine();
        System.out.println("nhap dia chi:");
        address = input.nextLine();
        System.out.println("nhap so dien thoai");
        phone = input.nextLine();
        System.out.println("so gio giang day");
        time = Integer.parseInt(input.nextLine());
    }
    public  void display() {
        System.out.println("GiangVien{"
                +"ten giang vien =" + nameGv
                +",dia chi =" + address
                +",so dein thoai =" + phone
                +",so gio giang day =" + time + '}'
        
        );
    
    }
     
}

