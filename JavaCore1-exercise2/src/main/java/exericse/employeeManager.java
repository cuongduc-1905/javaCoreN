/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exericse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 *
 * @author minh
 */
public class employeeManager {

    /**
     * @param args the command line arguments
     */
    ArrayList<NhanVien> listNhanVien = new ArrayList<>();
     
    public int showMenu(){
        System.out.println("|=======Menu=======|");
        System.out.println("1. Nhập thông tin nhân viên");
        System.out.println("2. Hiển thị thông tin nhân viên");
        System.out.println("3. Sắp xếp nhân viên theo lương tăng dần");
        System.out.println("4. Sắp xếp nhân viên theo tên");
        System.out.println("5. Danh sách nhân viên trẻ nhất");
        System.out.println("6. Tìm nhân viên theo tên, id");
        System.out.println("7. thoat");
        System.out.println("moi chon so: 1 -> 7");
        Scanner nhap = new Scanner(System.in);
        int Chonso = nhap.nextInt();
        return Chonso;
        
    }
    //input
     public void nhapTT(){
        Scanner nhap = new Scanner(System.in);
        System.out.println("Tong so lan nhap ");
        int n = nhap.nextInt();
        for(int i = 0 ; i < n ; i++){
            System.out.println("xin vui long nhap lan:" + (i+1));
            Scanner input = new Scanner(System.in);
            System.out.println("|===chonso===|");
            System.out.println("ban chon so");
            System.out.println("1.nhap nhan vien ke toan");
            System.out.println("2.nhap nhan vien van phong");            
            int Chonso = input.nextInt();
            int an = 0;
            do{
                switch (Chonso) {
                case 1:
                    {
                        NhanVien nv = new NhanVienKT();
                        nv.input();
                        listNhanVien.add(nv);
                        break;
                    }
                case 2:
                    {
                        NhanVien nv = new NhanVienVP();
                        nv.input();
                        listNhanVien.add(nv);
                        break;
                    }
                default:
                    System.out.println("ban nhap sai lan so:"+ (i+1));
                    System.out.println("===========================");
                    break;
            }
            }while(an > 0 && an < 3);
            
                  
                
          
        }
        System.out.println("ok cam on");
    }
    
     
    //display
    public void hienThiTT() {
         for (NhanVien nv : listNhanVien) {
             nv.display();
             nv.calSalary();
         }
    }
    //expression ladan odar name 
    Comparator<NhanVien> sxtheoten = 
    (NhanVien nv1, NhanVien nv2) -> nv1.getName().compareToIgnoreCase(nv2.getName());
    public void oderName(){
        Collections.sort(listNhanVien, sxtheoten);
        
         for (NhanVien nv : listNhanVien) {
             nv.display();
         }
        
    }
    
        public void sxtheotenBubbleSort() {
        // thuat toan xap xep noi bot
        for (int i = 0; i < listNhanVien.size() - 1; i++) {
            for (int j = i + 1; j < listNhanVien.size(); j++) {
                if (listNhanVien.get(i).getName().compareTo(listNhanVien.get(j).getName()) > 0) {
                    NhanVien nv= listNhanVien.get(i);
                     listNhanVien.set(i, listNhanVien.get(j));
                     listNhanVien.set(j, nv);
                }
            }
       
        }
        hienThiTT();
    }
    
     //expression ladan oder salary
    Comparator<NhanVien> sxsalary = 
    (NhanVien nv1, NhanVien nv2) -> (nv1.calSalary() < nv2.calSalary()) ? -1: (nv1.calSalary() > nv2.calSalary() ? 1 : 0);
    
    public void oderSalary(){
        Collections.sort(listNhanVien, sxsalary);
        
         for (NhanVien nv : listNhanVien) {
             nv.display();
             nv.calSalary();
         }
        
    }
    
    public void sxCalsalary() {
        // thuat toan xap xep noi bot
        for (int i = 0; i < listNhanVien.size() - 1; i++) {
            for (int j = i + 1; j < listNhanVien.size(); j++) {
                if (listNhanVien.get(i).calSalary() > listNhanVien.get(j).calSalary()) {
                    NhanVien nv= listNhanVien.get(i);
                     listNhanVien.set(i, listNhanVien.get(j));
                     listNhanVien.set(j, nv);
                }
            }
        
        }
         hienThiTT();
    }
    
    
    //dislay young Age
    public void youngAge (){
        int Age = 0;
        
        for (int i = 0; i < listNhanVien.size(); i++) {
            if(listNhanVien.get(i).getYearOfBirth() > Age){
               Age = listNhanVien.get(i).getYearOfBirth();
            }
        }
        
        for (NhanVien nv : listNhanVien) {
            if(nv.getYearOfBirth() == Age){
                nv.display();
            }
        }
        
    }
     
    public void saerchNameAndId() {
        Scanner nhap = new Scanner(System.in);
        System.out.println("nhap ten nhan vien can tim: ");
        String Name = nhap.nextLine();
        System.out.println("nhap ma nhan vien can tim");
        String id = nhap.nextLine();
        for (NhanVien nv : listNhanVien) {
            if(nv.getName().contains(Name) || nv.getId().contains(id)){
                nv.display();
            }
        }
    }
    
    public static void main(String args[]) {
       employeeManager EM = new employeeManager();
        int menu = 0;
        do{
            menu = EM.showMenu();
            switch(menu){
                case 1:
                    EM.nhapTT();
                    break;
                case 2:
                    EM.hienThiTT();
                    break;
                case 3:
                    //EM.oderSalary();
                    EM.sxCalsalary();
                    break;
                case 4:
                    EM.sxtheotenBubbleSort();
                    //EM.oderName();
                    break;
                case 5:
                    EM.youngAge();
                    break;
                case 6:
                    EM.saerchNameAndId();
                    break;
                 case 7:
                    System.out.println("Thoát");
                    break;
            }
            
            
        }while(menu > 0 && menu <7 );
    }
}
