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
public class class8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String arrSinhVien[][] = new String[3][2];
        
        for(int i=0;i < arrSinhVien.length ; i++){
            Scanner input = new Scanner(System.in);
            arrSinhVien[i] = input.nextLine();
        }
        for(String arrSinhViens : arrSinhVien){
            System.out.println(arrSinhViens);
        }
    }
}
