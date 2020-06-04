/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lad_04;

import entity.Product;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import model.ProductDao;

/**
 *
 * @author minh
 */
public class Lad_04 {
    //private static final Locale currentLocal = new Locale("en", "US");
    ProductDao product = new ProductDao();
    public int showMenu(){  
            System.out.println("nhap thong tin");
            System.out.println(
                    "1. nhap thong tin san pham\n" +
                    "2. hien thi thong tin San pham\n" +
                    "3. tim sinh vien theo email\n" +
                    "4. tim sinh vien theo ten\n" +
                    "5. sua thong tin sinh vien theo ma roll No" +
                    "6. xoa thong tin sinh vien theo ma roll No" + 
                    "7. thoat"
            );
            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();
            return selection;   
    }
    public void inputTT(){
        //IDvhandler handler = DbHandlerFactory.getInstance().getHandler(DbHandlerFactory.STUDENT);
        //ProductDao product = new ProductDao();
        Scanner click = new Scanner(System.in);
        System.out.println("tong so lan nhap");
        int n = click.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("xin vui long nhap lan:" + (i+1));
            Product p = new Product();
            p.input();
            product.add(p);
                    
        }
    }
    public void searchName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ban nhap ten");
        String name = sc.nextLine();
        product.getName(name).display();
        //product.getId(1).display();
    }
    
    public void export(){
        ProductDao product = new ProductDao();
        Product p = new Product();
        p.export();
        int id = p.getId();
        int qty = p.getQty();
        product.export(p,id,qty);
        
    }
    
    public void update(){
        ProductDao product = new ProductDao();
        Product p = new Product();
        p.update();
        product.update(p);
        
    }
    
    
    
    
    public static void main(String[] args) {
        Lad_04 main = new Lad_04();
        int menu = 0;
        do{
            menu = main.showMenu();
            switch(menu){
                case 1:
                    main.inputTT();
                    break;
                case 2:
                    main.update();
                    break;
                case 3:
                    main.export();
                    break;
                case 4:
                   main.searchName();
                   break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
            
            
        }while(menu > 0 && menu < 7);
    
        
        
    }
    
//    public static String getResource(String key){
//        ResourceBundle bundle = ResourceBundle.getBundle("internationalize/menu", currentLocal);
//        return bundle.getString(key);
//    }
    
}
