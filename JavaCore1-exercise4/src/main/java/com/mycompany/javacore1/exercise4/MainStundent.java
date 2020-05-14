/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javacore1.exercise4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author minh
 */
public class MainStundent {

    /**
     * @param args the command line arguments
     */
    ArrayList<Stundent> listStundent = new ArrayList<>();
    
    public int showMenu(){
            System.out.println("nhap thong tin");
            System.out.println(
                    "1. nhap thong tin sinh vien\n" +
                    "2. tinh diem trung binh\n" +
                    "3. tim sinh vien theo ten\n" +
                    "4. hien thi thong tin sinh vien\n" +
                    "5. thoat"
            );
            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();
            return selection;
    }
    
    public void inputTT(){
        Scanner click = new Scanner(System.in);
        System.out.println("tong so lan nhap");
        int n = click.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("xin vui long nhap lan:" + (i+1));
            Stundent sut = new Stundent();
            sut.inputData();
            listStundent.add(sut);
                    
        }
    }
    public void displayTT(){
        for (Stundent iStudent : listStundent) {
            iStudent.display();
        }
    }
    public void avg(){
        for (Stundent iStudent : listStundent) {
            iStudent.calculateAvg();
        }
    }
    
    public void searchName(){
        Scanner names = new Scanner(System.in);
        String name = names.nextLine();
        for (int i = 0; i < listStundent.size(); i++) {
           if(listStundent.get(i).getName().contains(name)){
               listStundent.get(i).display();
           } 
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        MainStundent main = new MainStundent();
        int menu = 0;
        do{
            menu = main.showMenu();
            switch(menu){
                case 1:
                    main.inputTT();
                    break;
                case 2:
                    main.displayTT();
                    break;
                case 3:
                    main.avg();
                    break;
                case 4:
                   main.searchName();
                   break;
                case 5:
                    
            }
            
            
        }while(menu > 0 && menu < 5);
        
        
    }
    
}
