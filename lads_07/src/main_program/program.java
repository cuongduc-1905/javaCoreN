/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_program;

import entities.student;
import java.util.Scanner;
import model.DbHandlerFactory;
import model.IDvhandler;
import model.StudentDAO;

/**
 *
 * @author minh
 */
public class program {
    //StudentDAO stundent = new StudentDAO();
    public int showMenu(){
            System.out.println("nhap thong tin");
            System.out.println(
                    "1. nhap thong tin sinh vien\n" +
                    "2. hien thi thongtin sinh vien\n" +
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
        IDvhandler handler = DbHandlerFactory.getInstance().getHandler(DbHandlerFactory.STUDENT);
        Scanner click = new Scanner(System.in);
        System.out.println("tong so lan nhap");
        int n = click.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("xin vui long nhap lan:" + (i+1));
            student sut = new student();
            sut.input();
            handler.insert(sut);
                    
        }
    }
    
    public void display(){
        IDvhandler handler = DbHandlerFactory.getInstance().getHandler(DbHandlerFactory.STUDENT);//=StudentDAO.getInstance()
        for (Object item : handler.getAll()) {
            student st = (student) item;
            //System.out.println(st.getId() + "\t" + st.getSV_name());
            st.display();
            System.out.println("==================");
        }
    }
    public void search(){
        IDvhandler handler = DbHandlerFactory.getInstance().getHandler(DbHandlerFactory.STUDENT);//=StudentDAO.getInstance()
        Scanner input = new Scanner(System.in);
        System.out.println("ban nhap email cam tim:");
        String email = input.nextLine();
        //handler.getEmail(email);
        for (Object item : handler.getAll()) {
            student st = (student) item;
            if(st.getSV_email().contains(email)){
                st.display();
                System.out.println("==================");
            }
            
        }
        
    }
    public void searchName(){
        IDvhandler handler = DbHandlerFactory.getInstance().getHandler(DbHandlerFactory.STUDENT);
        Scanner input = new Scanner(System.in);
        System.out.println("ban nhap ten can tim");
        String name = input.nextLine();
        handler.getName(name);
    }
    
    
    public static void main(String[] args) {
       program main = new program();
        int menu = 0;
        do{
            menu = main.showMenu();
            switch(menu){
                case 1:
                    main.inputTT();
                    break;
                case 2:
                    main.display();
                    break;
                case 3:
                    main.search();
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
//    public static void main(String[] args) {
//        IDvhandler handler = DbHandlerFactory.getInstance().getHandler(DbHandlerFactory.STUDENT);
//         student st = new student("sv05","duong van minh","ha noi","090909","minh@gmail.com");
//         //handler.insert(st);
//        for (Object item : handler.getAll()) {
//            student _st = (student) item;
//            System.out.printf("%s\t%s\n", _st.getId(), _st.getMa_sv());
//           
//        }
//    }
}
