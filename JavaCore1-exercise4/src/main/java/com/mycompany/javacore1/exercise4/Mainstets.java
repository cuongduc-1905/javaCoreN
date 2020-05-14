/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javacore1.exercise4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author minh
 */
public class Mainstets {

    /**
     * @param args the command line arguments
     */
    List<Student1> lisStundent = new ArrayList<>();
    
    
    public int showMenu(){
        System.out.println("==========menu========");
        System.out.println(
                "1. nhap thong tin sinh vien\n"+
                "2. hien thi thong tin sinh vien\n"+
                "3. tinh diem agv\n"+
                "4. tim ten sinh vien\n"+
                "5. xap xep theo ten\n"+
                "6. xap xap theo diem avg\n"+
                "7.thoat"
        );
        Scanner input = new Scanner(System.in);
        int chosse = input.nextInt();
        return chosse;
    }
    
    public void inputData(){
        System.out.println("nhap thong tin sinh vien");
        Scanner input = new Scanner(System.in);
        try {
            int n = Integer.parseInt(input.nextLine());
            for(int i = 0; i < n; i++){
                    System.out.println("lan thu:" +(i+1));
                    Student1 st = new Student1();
                    st.inputData();
                    lisStundent.add(st);
                }
        } catch (Exception e) {
            System.out.println("ban phai nhap so");
        }
        
        
    } 
    
    public void displaydata1(){
        for (Student1 st1 : lisStundent) {
            st1.DisplayData();
        }
    }
    
    public void saerchName(){
        Scanner input = new Scanner(System.in);
        System.out.println("nhap ten ten muon tim");
        String name = input.nextLine();
        
        for(int i = 0; i < lisStundent.size(); i++){
            if(lisStundent.get(i).getName().contains(name)){
                lisStundent.get(i).DisplayData();
            }
        }
    }
    public void calcu(){
        for (Student1 student1 : lisStundent) {
            student1.calculateAGV();
        }
    }
    
    
//    public void sortAgv(){
//        for (int i = 0; i < lisStundent.size() -1; i++) {
//            for (int j = i + 1; j < lisStundent.size() ; j++) {
//                if(lisStundent.get(i).getRank() > lisStundent.get(j).getRank()){
//                    Student1 temp = lisStundent.get(j);
//                    lisStundent.set(i, lisStundent.get(j));
//                    lisStundent.set(j, temp);
//                    
//                }
//            }
//        }
//        displaydata1();
//        
//    }
    
    public void sortAgv(){
    
        for (int i = 0; i < lisStundent.size() - 1 ; i++) {
            for (int j =  i + 1; j < lisStundent.size() - i; j++) {
                if(lisStundent.get(i).getRank()> lisStundent.get(j).getRank()){
                    Student1 st = lisStundent.get(i);
                    lisStundent.set(i, lisStundent.get(j));
                    lisStundent.set(j, st);
                }
            }
        }
        displaydata1();
        
    }
    
    
    public static void main(String[] args) {
       Mainstets main = new Mainstets();
       int menu = 0;
       do{
           menu = main.showMenu();
           switch(menu){
                case 1:
                   main.inputData();
                   break;
                case 2:
                    main.displaydata1();
                    break;
                case 3:
                    main.calcu();
                    break;
                case 4:
                    main.saerchName();
                    break;
                case 5:
                    //main.
                case 6:
                    main.sortAgv();
                    break;
                case 7:
                    System.out.println("thoat");
                    break;
                default:
                    System.out.println("ban nhap sai so thu tu 1-->7");
                    break;
           }
           
       }while(menu > 0 && menu < 7 );
       //main.showMenu();
       
    }
    
}
