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
public class NhanVienKT extends NhanVien{
    protected float bonus; // salary tuong

    public NhanVienKT() {
       
    }
    public NhanVienKT(float bonus, String id, String Name, float baseSalary, float salary, int yearOfBirth) {
        super(id, Name, baseSalary, salary, yearOfBirth);
        this.bonus = bonus;
    }

    
    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    
    @Override
    public void input (){
        super.input();
        Scanner input = new  Scanner(System.in);
        
        System.out.println("nhap so tien thuong");
        this.bonus = Float.parseFloat(input.nextLine());
    }

    /**
     *
     * @return
     */
    
    @Override
    public float calSalary() {
       float salarys = 0;
       salarys = getBaseSalary() + getBonus();
       System.out.printf("tien luong = %.2f\n", salarys);
       return salarys;
    }

    @Override
    public int compareTo(NhanVien arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
