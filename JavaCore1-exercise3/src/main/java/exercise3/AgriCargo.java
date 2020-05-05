/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise3;

import java.util.Scanner;

/**
 *
 * @author minh
 */
public class AgriCargo extends Cargo{
    private float tax ;

    @Override
    public void displayData() {
        super.displayData(); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void inputData() {
        super.inputData(); //To change body of generated methods, choose Tools | Templates.
        Scanner input = new Scanner(System.in);
        System.out.println("nhap tien thue");
        tax = Float.parseFloat(input.nextLine());
    }
    
    
}
