/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exericse;

import java.util.Scanner;


/**
 *
 * @author minh
 */
public class NhanVienVP extends NhanVien{
    protected float range = 1.5f; //salary range
    protected float salaryVp ;
    
    public NhanVienVP() {
       
    }

    public NhanVienVP(float salaryVp, String id, String Name, float baseSalary, float salary, int yearOfBirth) {
        super(id, Name, baseSalary, salary, yearOfBirth);
        this.salaryVp = salaryVp;
    }
    
    

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public float getSalaryVp() {
        return salaryVp;
    }

    public void setSalaryVp(float salaryVp) {
        this.salaryVp = salaryVp;
    }
    
    
    
     @Override
    public void input (){
        super.input();
        Scanner input = new  Scanner(System.in);
        
        System.out.println("nhap so tien luong");
        this.salaryVp = Float.parseFloat(input.nextLine());
    }
    
    
     @Override
    public float calSalary() {
       float salarys = 0;
       salarys = getSalaryVp() + getRange();
       System.out.printf("tien luong  = %.2f\n", salarys);
       return salarys;
    }

    @Override
    public int compareTo(NhanVien arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
