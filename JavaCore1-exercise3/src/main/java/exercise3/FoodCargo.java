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
        super.inputData(); //To change body of generated methods, choose Tools | Templates.
        SimpleDateFormat input = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("nhap han su dung");
        try {
            Date exDates = input.parse(exDate);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
