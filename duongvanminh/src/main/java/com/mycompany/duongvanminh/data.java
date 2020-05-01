/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.duongvanminh;
import java.util.ArrayList;
import java.util.logging.Logger;
/**
 *
 * @author minh
 */
public class data {
    int soGv;
    ArrayList<GiangVienHuuCo> listGiangVienHuuCo;
    ArrayList<GiangVienThinhGiang> listGiangVienThinhGiang;
    public data(){
        
    }
    
    public data(int soGv){
        this.soGv = soGv;
        listGiangVienHuuCo = new ArrayList<>();
        listGiangVienThinhGiang = new ArrayList<>();
    }
    
    public void inputDaTa(){
        //for(int i = 0 ;i < soGv-1;i++){
            switch (soGv) {
                case 1:
                    System.out.println("nhap TT giang vien huu co");
                    GiangVienHuuCo gvhc = new GiangVienHuuCo();
                    gvhc.input();
                    listGiangVienHuuCo.add(gvhc);
                    break;
                case 2:
                    System.out.println("nhap TT giang vien thinh giang");
                    GiangVienThinhGiang gvtg = new GiangVienThinhGiang();
                    gvtg.input();
                    listGiangVienThinhGiang.add(gvtg);
                    break;
                default:
                    System.out.println("ban nhap sai");
                    break;
            }
            
        //}
    }
    
    public void displayDataHC(){
        for (GiangVienHuuCo gvhc : listGiangVienHuuCo) {
                gvhc.display();
        }
    }
        
    public void displayDataTG(){
        for (GiangVienThinhGiang gvtg : listGiangVienThinhGiang) {
                gvtg.display();
        }
    }
    public int getSoGv() {
        return soGv;
    }

    public ArrayList<GiangVienHuuCo> getListGiangVienHuuCo() {
        return listGiangVienHuuCo;
    }

    public void setSoGv(int soGv) {
        this.soGv = soGv;
    }

    public void setListGiangVienHuuCo(ArrayList<GiangVienHuuCo> listGiangVienHuuCo) {
        this.listGiangVienHuuCo = listGiangVienHuuCo;
    }

    public ArrayList<GiangVienThinhGiang> getListGiangVienThinhGiang() {
        return listGiangVienThinhGiang;
    }

    public void setListGiangVienThinhGiang(ArrayList<GiangVienThinhGiang> listGiangVienThinhGiang) {
        this.listGiangVienThinhGiang = listGiangVienThinhGiang;
    }
  
    
  
    
    
}
