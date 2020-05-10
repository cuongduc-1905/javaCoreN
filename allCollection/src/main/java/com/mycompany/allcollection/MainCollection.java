/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.allcollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author minh
 */
public class MainCollection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> nameList = new ArrayList<>();
        
        System.out.println("xin vui long nhap chon so de nhap");
        boolean isDone = true;
        while(isDone){
            System.out.println(" 1. app Sv\n 2. delete Sv \n 3. update Sv \n 4. display \n 5. exit");
            Scanner input = new Scanner(System.in);
            int selection = Integer.parseInt(input.nextLine());
            
            switch(selection){
                case 1:
                    System.out.println("nhap ten sv");
                    String name = input.nextLine();
                    while(!name.isEmpty()){
                       nameList.add(name);
                       System.out.println("nhap ten sv");
                       name = input.nextLine();
                       
                   }
                    break;
                case 2:
                    System.out.println("ban nhap id de xoa");
                    int id = Integer.parseInt(input.nextLine());
                    nameList.remove(id);
                    break;
                case 3:
                    Scanner up = new Scanner(System.in);
                    System.out.println("tong so lan ban may update");
                    int choise = Integer.parseInt(up.nextLine());
                    for(int i = 0; i < choise ;i++){
                        System.out.println("so lan update thu:"+ (i+1));
                        System.out.println("nhap id vs");
                        int ids = Integer.parseInt(up.nextLine());
                        System.out.println("thong tin nguoi update");
                        //for(int j = 0; j < nameList.size(); j++){
                           
                            System.out.println(nameList.get(ids));
                        //}
                        System.out.println("nhap name vs");
                        String namess = up.nextLine();
                        nameList.set(ids,namess);
                    }
                    break;
                case 4:
                    System.out.println("danh sach sv");
                    for (int i =0; i < nameList.size() ; i++){
                        System.out.println("id:"+ i +" "+ "name:" +nameList.get(i));
                    }
    
                    break;
                case 5:
                    isDone = false;
                    break;
                
            }
            
        }
        
        
        
        
    }
    
}
