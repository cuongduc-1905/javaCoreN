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
public class Student1 implements IStudent1{
    
    private String id,name;
    private float score1, score2, score3,rank;

    public Student1() {
    }

    public Student1(String id, String name, float score1, float score2, float score3) {
        this.id = id;
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
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

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }
    
    
    
    
    
    
    
    
    @Override
    public void inputData() {
        Scanner input = new Scanner(System.in);
        System.out.println("nhap id");
        id = input.nextLine();
        System.out.println("nhap name");
        name = input.nextLine();
        System.out.println("nhap score1");
        score1 = Float.parseFloat(input.nextLine());
        System.out.println("nhap score2");
        score2 = Float.parseFloat(input.nextLine());
        System.out.println("nhap score3");
        score3 = Float.parseFloat(input.nextLine());
        rank = (score1 + score2 + score3)/3;
        if(rank >= 8){
            System.out.println("gioi");
        }else if(rank< 6.5f && rank < 8){
            System.out.println("kha");
        }else{
            System.out.println("trung binh");
        }
    }

    @Override
    public void DisplayData() {
        System.out.println("thong tin cu sinh vien");
        System.out.println("ma sinh vien id:"+ id+"\n" 
                + "ten sinh vien name:"+ name +"\n" 
                +"score1:"+ score1 +"\n"
                +"score2:"+ score2 +"\n"
                +"score3:"+ score3 +"\n"
                +"rank :" + rank +"\n"
        );
    }

    @Override
    public void calculateAGV() {
        float AGV = 0;
        AGV = (score1 + score2 + score3)/3;
    }
    
}
