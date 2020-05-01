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
public class GiangVienHuuCo extends GiangVien{
    int salary;
    int times ;
     
    public GiangVienHuuCo (){ 
    }
    public  GiangVienHuuCo(String nameGv, String address,String phone,int time,int times,int salary){
         super(nameGv,address,phone,time);
         this.times =  times;
         this.salary = salary;
     }
    //use override

    public float getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
    
    
    @Override
    public void input(){
        super.input();
        Scanner inputs = new Scanner(System.in);
        System.out.println("nhap luong");
        salary = Integer.parseInt(inputs.nextLine());
        times = 40; 
       
    }
    @Override
    public void display(){
        super.display();
        System.out.println("GiangVienHuuCo{"
                +"luong giang vien =" + salary
                +",so gio day=" + times +'}'
        );
    }
}
