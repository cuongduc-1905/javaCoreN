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
    private String name;
    private String Classs;
    private int age;

    public Student() {
    }

    public Student(int Id, String name, String Classs, int age) {
        this.Id = Id;
        this.name = name;
        this.Classs = Classs;
        this.age = age;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasss() {
        return Classs;
    }

    public void setClasss(String Classs) {
        this.Classs = Classs;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void inputData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ten sinh vien");
        name  = sc.nextLine();
        System.out.println("nhap lop hoc");
        Classs = sc.nextLine();
        System.out.println("nhap so tuoi");
        age = sc.nextInt();
       
    }
    public void display(){
        System.out.println(this.Id + "|" + this.name + "|" +this.Classs + "|" + this.age);
    }
    public String writeFiel(){
        return this.Id + "," + this.name + "," +this.Classs +"," + this.age;
    }
    
}
