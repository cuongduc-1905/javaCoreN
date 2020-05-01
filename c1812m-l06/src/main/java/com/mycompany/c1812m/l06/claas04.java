/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.c1812m.l06;

/**
 *
 * @author minh
 */
import java.util.Scanner;
public class claas04 {
    private String maSp;
    private String tenSp;
    private String nhaSx;
    private int namSx;
    private float price;
    
    public claas04(){
        
    }
    //contructor có tham số
    public claas04(String maSp, String tenSp, String nhaSx, int namSx, float price){
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.nhaSx = nhaSx;
        this.namSx = namSx;
        this.price = price;
    }

    public String getMaSp() {
        return maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public String getNhaSx() {
        return nhaSx;
    }

    public int getNamSx() {
        return namSx;
    }

    public float getPrice() {
        return price;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public void setNhaSx(String nhaSx) {
        this.nhaSx = nhaSx;
    }

    public void setNamSx(int namSx) {
        this.namSx = namSx;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ma san pham");
        maSp = sc.nextLine();
        System.out.println("nhap ten san pham");
        tenSp = sc.nextLine();
        System.out.println("nhap nha san xuat");
        nhaSx = sc.nextLine();
        System.out.println("nhap nam san xuat");
        namSx = Integer.parseInt(sc.nextLine());
        System.out.println("nhap gia tien");
        price = Float.parseFloat(sc.nextLine());
    }
    
    public void display(){
        System.out.println("san pham:");
        System.out.println("\tMa san pham:"+maSp);
        System.out.println("\tTen san pham:"+tenSp);
        System.out.println("\tNha san xuat:"+nhaSx);
        System.out.println("\tNam san xuat:"+namSx);
        System.out.println("\tgia ban:"+price);
    }
    
}
