/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javacore1.exercise4;

import java.util.Scanner;

/**
 *
 * @author minh
 */
public class Stundent extends IStudent{
    private String id,name;
    private float score1,score2,score3,avg;

    public Stundent() {
    }

    public Stundent(String id, String name, float score1, float score2, float score3, float avg) {
        this.id = id;
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.avg = avg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore1() {
        return score1;
    }

    public void setScore1(float score1) {
        this.score1 = score1;
    }

    public float getScore2() {
        return score2;
    }

    public void setScore2(float score2) {
        this.score2 = score2;
    }

    public float getScore3() {
        return score3;
    }

    public void setScore3(float score3) {
        this.score3 = score3;
    }

    public float getAvg() {
        return avg;
    }

    
    
    
    @Override
    public void inputData() {
        Scanner input = new Scanner(System.in);
        System.out.println("nhap ma sinh vien");
        id = input.nextLine();
        System.out.println("nhap ten sinh");
        name = input.nextLine();
        System.out.println("nhap diem 1");
        score1 = Float.parseFloat(input.nextLine());
        System.out.println("nhap diem 2");
        score2 = Float.parseFloat(input.nextLine());
        System.out.println("nhap diem 3");
        score3 = Float.parseFloat(input.nextLine());
    }

    @Override
    public void display() {
        System.out.println("thong tin sinh vien");
        System.out.println("\tthong tin id:" + id);
        System.out.println("\tthong tin name:" + name);
        System.out.println("\tthong tin score1:" + score1);
        System.out.println("\tthong tin score2:" + score2);
        System.out.println("\tthong tin score3:" + score3);
        
//        if(avg >= 8.0){
//            System.out.println("\tthong tin gio");
//        }else if(6.5 <= avg  && avg < 8.0){
//            System.out.println("diem kha");
//        }else{
//            System.out.println("diem trung binh");
//        }
        
        
    }

    @Override
    public void calculateAvg() {
       float cAvg = 0;
       cAvg = (getScore1() + getScore2() + getScore3())/3;
       System.out.println("diem trung binh" + cAvg);
    }
    
}
