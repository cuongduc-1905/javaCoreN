/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.DateTimeAtCompleted;

/**
 *
 * @author minh
 */
public class FoodCargo extends Cargo{
    private int exDate;
    
    @Override
    public void displayData() {
        super.displayData(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("\than su dung:" + exDate);
        
    }

    @Override
    public void inputData() {
        super.inputData();
        boolean isDone = false;
        
        do{
            Scanner input = new Scanner(System.in);
            System.out.println("nhap han su dung");
            this.exDate = Integer.parseInt(input.nextLine());
            if(this.exDate > 3){
                isDone = true ;
            }else{
                System.out.println("nhap lon nho 3 ngay");
            }
            
        }while(!isDone);
    }

    public int getExDate() {
        return exDate;
    }

    public void setExDate(int exDate) {
        this.exDate = exDate;
    }

    @Override
    public float tax() {
        return 0;
        
    }
    @Override
    public int ngay(){
        return exDate;
    }
    
    
}
