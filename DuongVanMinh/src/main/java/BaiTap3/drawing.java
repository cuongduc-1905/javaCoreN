/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTap3;

import java.util.Scanner;

/**
 *
 * @author minh
 */
public class drawing {

    /**
     * @return 
     */
    public int showMenu(){
        System.out.println("|=======Menu=======|");
        System.out.println("1. hinh tam giac bang *");
        System.out.println("2. hinh tam giac nguoc");
        System.out.println("3. hinh tam giac bang so");
        System.out.println("4. hinh chu nhat");
        System.out.println("5. hinh hinh vuong co 2 duong cheo");
        System.out.println("6.thoat");
        System.out.println("moi chon so: 1 -> 6");
        Scanner nhap = new Scanner(System.in);
        int Chonso = nhap.nextInt();
        return Chonso;
        
    }
    public int triangle() {
        //int n;
        System.out.println("nhap so :");
        Scanner nhap = new Scanner(System.in);
        int n = nhap.nextInt();
        int i,j ;
        for( i = 1 ; i <= n ; i++ ){
            for( j = 1 ; j <= i ; j++ ){
                System.out.print("*");
            }
            System.out.println("");
        }
        return n;
    }
    public void reverseTriangle() {
        //int n;
        System.out.println("nhap so :");
        Scanner nhap = new Scanner(System.in);
        int n = nhap.nextInt();
        int i, j ;
        for ( i = n; i >= 1; --i){
           for( j = i ; j >= 1 ; --j){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
    public void number() {
        //int n;
        System.out.println("nhap so :");
        Scanner nhap = new Scanner(System.in);
        int n = nhap.nextInt();
        int i, j ;
        for( i = 1 ; i <= n ; i++ ){
            for( j = 1 ; j <= i ; j++ ){
                System.out.print(j);
            }
            System.out.println("");
        }
    }
    
    public void numbers() {
        //int n;
        System.out.println("nhap so :");
        Scanner nhap = new Scanner(System.in);
        int n = nhap.nextInt();
        int i, j ;
        for( i = 1 ; i <= n ; i++ ){
            for( j = 1 ; j <= n ; j++ ){
               if(i == 1 ||  j == 1 || i == n || j == n || j == (n - i + 1) || i == j)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public void rectangular() {
         int i, j ;
        System.out.println("nhap so :");
        Scanner nhap = new Scanner(System.in);
        System.out.println("nhap so cot:");
        int n = nhap.nextInt();
        System.out.println("nhap so hang:");
        int m = nhap.nextInt();
       
    
        for( i = 1 ; i <= n ; i++ ){
            for( j = 1 ; j <= m ; j++ ){
                if(i == 1 ||  j == 1 || i == n || j == m  )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String args[]) {
        drawing ql = new drawing();
        int menu = 0;
        do{
            menu = ql.showMenu();
            switch(menu){
                case 1:
                    ql.triangle();
                    break;
                case 2:
                    ql.reverseTriangle();
                    break;
                case 3:
                    ql.number();
                    break;
                case 4:
                    ql.rectangular();
                    break;
                case 5:
                    ql.numbers();
                    break;
                 case 6:
                    System.out.println("Thoát");
                    break;
            }
            
            
        }while(menu > 0 && menu < 6 );
        System.out.println("Chương trình kết thúc");
    }
}
