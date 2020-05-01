/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.c1812m.l06;
import java.util.Scanner;
/**
 *
 * @author minh
 */
public class arrys {
    String arrNhaVien[][] = new String [3][2];
    
    public void nhapDuLeu (){
        for(int i=0;i < arrNhaVien.length ; i++ ){
             System.out.println("nhap thong tin cho nha vien"+ (i+1));
             Scanner input = new Scanner(System.in);
             arrNhaVien[i][0] = input.nextLine();
             arrNhaVien[i][1] = input.nextLine();
        }
        System.out.println("cam on da nhap lieu");
    }
    public void sapXep (){
        for(int i=0;i < arrNhaVien.length ; i++){
            for(int j=0; j < arrNhaVien.length; j++){
        
        }
        }
    
    }
    
    }
}
