/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramdo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author minh
 */
public class numberRamdo {

    ArrayList<Integer> isNumberA = new ArrayList<>();
    ArrayList<Integer> isNumberb = new ArrayList<>();
    
    private void generateNumber(){
        int min = 0;
        int max = 20;
        
        for(int i = 0 ; i < 9 ;i++ ){
            Random ran = new Random();
            int number = ran.nextInt(max - min +1) + min;
            isNumberA.add(number);
        }
        System.out.println("Arr 1:" + isNumberA);
        for(int i = 0 ; i < 12 ; i++){
            int number = (int) (Math.random() * ((max - min) +1)) + min ;
            isNumberb.add(number);
        }
        System.out.println("Arr 2:" + isNumberb);
    }
    
    private void intersect(){
        ArrayList<Integer> lstNumATemp = new ArrayList<>(isNumberA);
        ArrayList<Integer> lstNumbTemp = new ArrayList<>(isNumberb);
        //phan tap hop a ma kg co tap hop b 
        if(lstNumATemp.removeAll(isNumberb)){
            System.out.println("phan tu chi co o tap hop A");
            System.out.println(lstNumATemp);
        }else{
            System.out.println("2 tap hop hoan toan khac biet");
        }
        
        if(lstNumbTemp.removeAll(isNumberA)){
            System.out.println("phan tu chi co o tap hop A");
            System.out.println(lstNumbTemp);
        }else{
            System.out.println("2 tap hop hoan toan khac biet");
        }
        
        ArrayList<Integer> intersectionA = new ArrayList<>(isNumberA);
        ArrayList<Integer> intersectionB = new ArrayList<>(isNumberb);
        
        // Phần chung A
        intersectionA.removeAll(lstNumATemp);
        System.out.println("Phần chung A: " + intersectionA);
        // Phần chung B
        intersectionB.removeAll(lstNumbTemp);
        System.out.println("Phần chung B: " + intersectionB);
        // Tổng hợp phần chung A + B
        Set<Integer> totalIntersect = new TreeSet<>(intersectionA);
        totalIntersect.addAll(intersectionB);
        System.out.println("Phần chung A + B: " + totalIntersect);
        
    }   
    
    
    
    public static void main(String args[]) {
       numberRamdo ram = new numberRamdo();
       ram.generateNumber();
       ram.intersect();
    }
}
