package entities;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author minh
 */
public class student {
    private int Id ;
    private String Ma_sv;
    private String SV_name;
    private String SV_address;
    private String SV_phone;
    private String SV_email;

    public student() {
    }

    public student(String Ma_sv, String SV_name, String SV_address, String SV_phone, String SV_email) {
        this.Ma_sv = Ma_sv;
        this.SV_name = SV_name;
        this.SV_address = SV_address;
        this.SV_phone = SV_phone;
        this.SV_email = SV_email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getMa_sv() {
        return Ma_sv;
    }

    public void setMa_sv(String Ma_sv) {
        this.Ma_sv = Ma_sv;
    }

    public String getSV_name() {
        return SV_name;
    }

    public void setSV_name(String SV_name) {
        this.SV_name = SV_name;
    }

    public String getSV_address() {
        return SV_address;
    }

    public void setSV_address(String SV_address) {
        this.SV_address = SV_address;
    }

    public String getSV_phone() {
        return SV_phone;
    }

    public void setSV_phone(String SV_phone) {
        this.SV_phone = SV_phone;
    }

    public String getSV_email() {
        return SV_email;
    }

    public void setSV_email(String SV_email) {
        this.SV_email = SV_email;
    }
    
    public void input(){
        Scanner input = new Scanner(System.in);
        System.out.println("nhap ma sinh vien");
        Ma_sv = input.nextLine();
        System.out.println("nhap ten sinh vien");
        SV_name = input.nextLine();
        System.out.println("nhap dia chi sinh vien");
        SV_address = input.nextLine();
        System.out.println("nhap so dien thoai");
        SV_phone = input.nextLine();
        System.out.println("nhap email");
        SV_email = input.nextLine();
    }
//    public void display(){
//        System.out.println("thong tin cu sinh vien");
//        System.out.println("ma sinh vien id:"+ id+"\n" 
//                + "ten sinh vien name:"+ name +"\n" 
//                +"score1:"+ score1 +"\n"
//                +"score2:"+ score2 +"\n"
//                +"score3:"+ score3 +"\n"
//                +"rank :" + rank +"\n"
//        );
//    }
    
    
}
