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
public class GiangVienThinhGiang extends GiangVien{
    String company;
    int     huors;
    int salary;
    
    
    public GiangVienThinhGiang(){
        
    }
    public  GiangVienThinhGiang(String nameGv, String address,String phone
        ,int time,int huors,String company,int salary){
        
        super(nameGv,address,phone,time);
        this.huors = huors;
        this.company = company;
        this.salary = salary;
     }
    //use override

    public String getCompany() {
        return company;
    }

    public int getHuors() {
        return huors;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setHuors(int huors) {
        this.huors = huors;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    
     
    @Override
    public void input(){
        super.input();
        Scanner inputs = new Scanner(System.in);
        System.out.println("ten co ty");
        company = inputs.nextLine();
        System.out.println("do gio co the giang day");
        huors = Integer.parseInt(inputs.nextLine());
        salary = 200000;
    }
    @Override
    public void display(){
        super.display();
        System.out.println("GiangVienThinhCo{"
                +"co ty =" + company + ",luong cua thinh giang =" + salary + ",so gio day =" + huors +'}'
        );
    }
}
