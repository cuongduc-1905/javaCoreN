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
    private String exDate;

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
            exDate = input.nextLine();
            SimpleDateFormat idate = new SimpleDateFormat("yyyy-MM-dd");
            
            try {
                Date exDates = idate.parse(exDate);
            } catch (ParseException ex) {
                Logger.getLogger(FoodCargo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(isDone);
    }

    public String getExDate() {
        return exDate;
    }

    public void setExDate(String exDate) {
        this.exDate = exDate;
    }

    @Override
    public float tax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
