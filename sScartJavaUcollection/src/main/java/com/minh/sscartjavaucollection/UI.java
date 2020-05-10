/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minh.sscartjavaucollection;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author minh
 */
public class UI {
    
    Cart cart = new Cart();
    
    private int ch = 0;
    
    public UI (){
        menu();
    }
    
    public void startScreen(){
        System.out.println("1. display Store Product");
        System.out.println("2. display cart");
        System.out.println("0. exit");
    }
    
    public void storeProductMenu(){
        System.out.println("1. add to cart");
        System.out.println("2. remove from cart");
        System.out.println("0. exit");
        
    }
    
    public void menu() {
        do{
            startScreen();
            getUserInput();
            switch(ch){
                case 1:
                    displayStoreProduct();
                    storeProductMenu();
                    getUserInput();
                    innerChoice1();
                    break;
                case 2:
                    showCart();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    break;
                    
            }
        }while(ch != 0);
    }

   


    private void innerChoice1() {
        switch(ch){
            case 1:
                addProductToCart();
                showCart();
                break;
            case 2:
                removeProductFromCart();
                break;
            default:
                break;
        }
    }
    
    private int getUserInput() {
        Scanner in = new Scanner(System.in);
        ch = Integer.parseInt(in.nextLine());
        return ch;
    }
    
    private void displayStoreProduct() {
        List<Product> products = new ProductsApp().getProduct();
        for (Product product1 : products) {
            System.out.println(
                product1.getPid() +"-"+
                product1.getName() +" "+
                product1.getPrice() +" "+
                product1.getStock()
                    
            );
        }
    }
    private void showCart() {
       cart.printCartItem();
    }

    private void addProductToCart() {
        int pid = getUserInput();
        cart.addProductToCartById(pid);
    }

    private void removeProductFromCart() {
        int pid = getUserInput();
        cart.removeProductById(pid);
    }
    
    
}
