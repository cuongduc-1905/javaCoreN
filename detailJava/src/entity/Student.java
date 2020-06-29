/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Scanner;

/**
 *
 * @author minh
 */
public class Student {
    private int Id;
    private String Name;
    private int Age;
    private String ClassS;

    public Student() {
    }

    public Student(int Id, String Name, int Age, String ClassS) {
        this.Id = Id;
        this.Name = Name;
        this.Age = Age;
        this.ClassS = ClassS;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getClassS() {
        return ClassS;
    }

    public void setClass(String ClassS) {
        this.ClassS = ClassS;
    }
    
    public void inputData(){
        Scanner sc = new Scanner(System.in);
        
        boolean isDone = false;
       
            do {       
            System.out.println("nhan ten hoc sinh");
            Name = sc.nextLine();
            if(this.Name.length() > 0 && this.Name.length() < 20){
                isDone = true;
            }else{
                System.out.println("ban hay nhap ti nhat 8 ki tu");
            }
            } while (!isDone);
        
    
       
            do {       
                System.out.println("nhan tuoi hoc sinh");
                Age = Integer.parseInt(sc.nextLine());
                if(this.Age > 10){
                    isDone = true;
                }else{
                    System.out.println("ban hay nhap so");
                }
            } while (!isDone);
       
        
        
        do {       
            System.out.println("nhan lop hoc sinh");
            ClassS = sc.nextLine();
            if(this.ClassS.length() > 0 && this.ClassS.length() <= 6){
                isDone = true;
            }else{
                System.out.println("ban hay nhap nho hon 6");
                
            }
        } while (!isDone);
        
    }
    
    public void display(){
        System.out.println(this.Id + this.Name + this.Age + this.ClassS);
    }
    
    public String writeBuf(){
        return this.Id +"," + this.Name + "," + this.Age +"," + this.ClassS ;
    }
    
}
