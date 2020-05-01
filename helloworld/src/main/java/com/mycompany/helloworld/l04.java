/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.helloworld;

import java.util.Scanner;
/**
 *
 * @author minh
 */
public class l04 {
    private String rollNumber;
    private String fullName;
    private String className;
    //khởi tạo giá trị
    
    public l04() {
    }
    //đẻ tí ra phần bên index gọi lại 
    public l04 (String rollNumber,String fullName, String className){
    this.rollNumber = rollNumber;
    this.fullName = fullName;
    this.className = className;
    }
    //gán tham số vào 

    public String getRollNumber(){
        return rollNumber;
    }
    public void setRollNumber(String rollNumber){
        this.rollNumber = rollNumber;
    }
    //chuyền tham số rollNumber vào trẻ về l04
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    // chuyền tham số fullName vào trả về l04
     public String getClassName(){
        return fullName;
    }
    public void setClassName(String className){
        this.fullName = className;
    }
    //chuyền tham sô clasName vào trả về l04

    public void inputData(){
    Scanner nhap = new Scanner(System.in );
    System. out .println("Nhap vao ma sinh vien:");
    rollNumber = nhap.nextLine();
    System. out .println("Nhap vao ho ten sinh vien:");
    fullName = nhap.nextLine();
    System. out .println("Nhap vao ten lop hoc:");
    className = nhap.nextLine();
    }
    //nhận giá trị vào
    public void displayData(){
    System. out .println("Sinh vien:");
    System. out .println("\tMa sinh vien: "+rollNumber);
    System. out .println("\tHo ten: "+fullName);
    System. out .println("\tLop: "+className);
    }
    //đẻ hiển thị ra 
}


