/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exericse;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author minh
 */
public abstract class NhanVien implements Comparable<NhanVien>{
    protected String id; //mã nhân viên kiểu String - giới hạn 5 ký tự
    protected String Name;  //tên nhân viên kiểu String - tối đa 30 ký tự
    protected float baseSalary = 970.000f;//lương cơ bản kiểu float cố định là 970.000 - phải lớn hơn 0
    protected float salary; //lương cơ bản kiểu float
    protected int yearOfBirth; //năm sinh kiểu int - phải lớn hơn 0  
    
    public abstract float calSalary();
    public NhanVien() {
       
    }
    public NhanVien(String id, String Name, float baseSalary, float salary, int yearOfBirth) {
        this.id = id;
        this.Name = Name;
        this.baseSalary = baseSalary;
        this.salary = salary;
        this.yearOfBirth = yearOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

   
      
        
    public void input(){
       
            String regexId = "[a-zA-Z0-9]{5}";
        //String regexName = "[a-zA-Z]{30}";
        //do{
//            Scanner input = new Scanner(System.in);
//            System.out.println("ma nhan vien");
//            id = input.nextLine();
//            Pattern r = Pattern.compile(regexId);
//            Matcher m = r.matcher(id);
//            if(m.matches()){
//                System.out.println("id hop le");
//                //break;
//            }else{
//                System.out.println("ten khong hop le,id < 5 ki tu");
//            }
//            System.out.println("ten nhan vien");
//            Name = input.nextLine();
//            Pattern name = Pattern.compile(regexName);
//            Matcher n = name.matcher(Name);
//            if(n.matches()){
//                System.out.println("Name hop le");
//                break;
//            } else{
//                System.out.println("ten khong hop le,ten toi da 30 ki tu");
//            }
//            System.out.println("nam sinh");
//            yearOfBirth = Integer.parseInt(input.nextLine());
        //}while(true);
        
        
        
       
            
            

//        System.out.println("ten nhan vien");
//        Name = input.nextLine();
//        System.out.println("nam sinh");
//        yearOfBirth = Integer.parseInt(input.nextLine());
       
        
    }
    
     public  void display() {
        System.out.println("thong tin nhan vien:");
        System.out.println("\tMa nhan vien:"+id);
        System.out.println("\tten nhan vien:"+Name);
        System.out.println("\tnam sinh:"+yearOfBirth);
        //System.out.println("\tluong cua nhan vien:"+salary);

    }

//    @Override
//    public int compareTo(NhanVien NameNv) {
//        return this.Name.compareTo(NameNv.getName());
//    }
    
}
