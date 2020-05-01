/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duongvanminh;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author minh
 */
public class quanLyGv {

    /**
     * @param args the command line arguments
     */
      ArrayList<data> listGv = new ArrayList<>();
    
    public int showMenu(){
        System.out.println("|=======Menu=======|");
        System.out.println("1.nhap thong tin cua giang vien");
        System.out.println("2. danh sach toan bo giang vien");
        System.out.println("3. danh sach toan bo giang vien huu co");
        System.out.println("4. danh sach toan bo giang vien thin giang");
        System.out.println("5.tinh tong so luong tien toan bo giang vien");
        System.out.println("6.tinh luong cua giang vien cao nhat");
        System.out.println("7.thoat");
        System.out.println("moi chon so: 1 -> 7");
        Scanner nhap = new Scanner(System.in);
        int Chonso = nhap.nextInt();
        return Chonso;
        
    }
   
    public void nhapTT(){
        Scanner nhap = new Scanner(System.in);
        System.out.println("Tong so l nhap Gv");
        int n = nhap.nextInt();
        for(int i = 0 ; i < n ; i++){
            System.out.println("so lan nhap la:" + (i+1));
            Scanner input = new Scanner(System.in);
            System.out.println("|===chonso===|");
            System.out.println("ban chon so");
            System.out.println("1.nhap GVHC ");
            System.out.println("2.nhap GVTG");
            int Chonso = input.nextInt();
            switch (Chonso) {
                case 1:
                    {
                        data dt = new data(Chonso);
                        dt.inputDaTa();
                        listGv.add(dt);
                        break;
                    }
                case 2:
                    {
                        data dt = new data(Chonso);
                        dt.inputDaTa();
                        listGv.add(dt);
                        break;
                    }
                default:
                    System.out.println("ban nhap sai");
                    break;
            }
                  
                
          
        }
        System.out.println("cam on");
    }
    
    public void hienThiTT() {
        for (data dt : listGv) {
            dt.displayDataHC();
            dt.displayDataTG();
        }
    }
    public void hienThiHC() {
        for (data dt : listGv) {
            dt.displayDataHC();
        }
    }
    public void hienThiTG() {
        for (data dt : listGv) {
            dt.displayDataTG();
        }
    }
    public void TongTien(){ 
        int TTHC = 0;
        int TTTG = 0;
        for (data dt : listGv) {
            ArrayList<GiangVienHuuCo> listTLHC = dt.getListGiangVienHuuCo();
            ArrayList<GiangVienThinhGiang> listTLTG = dt.getListGiangVienThinhGiang();
            for(GiangVienHuuCo GVHC : listTLHC){
                TTHC += GVHC.getSalary() * GVHC.getTimes();
                
            }
            for(GiangVienThinhGiang GVTG : listTLTG){
                 TTTG += GVTG.getSalary() * GVTG.getHuors();
                
            }
           
        }
        System.out.println("tong tien="+ Integer.sum(TTHC, TTTG));
      
    }
 
  
    
    public void timGiangVienNhieuTien() {
        float max = 0;
//        
//        for (data dt : listGv) {
//            ArrayList<GiangVienHuuCo> listTLHC = dt.getListGiangVienHuuCo();
//            //ArrayList<GiangVienThinhGiang> listTLTG = dt.getListGiangVienThinhGiang();
//            for(GiangVienHuuCo GVHC : listTLHC){
//                if (GVHC.getSalary() > max) {
//                    max = GVHC.getSalary();
//                }
//                
//                
//            }
//        }

//         Hiển thị tất cả các cuốn sách có giá = max
//        for (Book b : arrBook) {
//            if (b.getPrice() == max) {
//                b.hienThiTT();
//            }
//        }
          System.out.println("em chua lam ");
    }
    
    public static void main(String args[]) {
        quanLyGv ql = new quanLyGv();
        int menu = 0;
        do{
            menu = ql.showMenu();
            switch(menu){
                case 1:
                    ql.nhapTT();
                    break;
                case 2:
                    ql.hienThiTT();
                    break;
                case 3:
                    ql.hienThiHC();
                    break;
                case 4:
                    ql.hienThiTG();
                    break;
                case 5:
                    ql.TongTien();
                    break;
                case 6:
                    ql.timGiangVienNhieuTien();
                    break;
                 case 7:
                    System.out.println("Thoát");
                    break;
            }
            
            
        }while(menu > 0 && menu <7 );
    }
}
