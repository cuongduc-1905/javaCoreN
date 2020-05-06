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
public  class AgriCargo extends Cargo{
    private float tax ;
    
    
    @Override
    public void displayData() {
        super.displayData(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("\tthong tin thue:" + tax +"%");
    }

    @Override
    public void inputData() {
        super.inputData(); //To change body of generated methods, choose Tools | Templates.
        Scanner input = new Scanner(System.in);
        boolean isDone = false;
        do{
            
            System.out.println("nhap so tien thue");
            this.tax = Float.parseFloat(input.nextLine());
            if(this.tax >= 0 && this.tax <= 100){
                isDone = true;
            }else{
                System.out.println("gioi han tien thue tu 0-100");
            }
        }while(!isDone);
        
        
        System.out.println("nhap tien thue");
        tax = Float.parseFloat(input.nextLine());
    }    
    
    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    @Override
    public float tax() {
        super.displayData();
        System.out.println("\tthong tin thue:" + tax +"%");
        return tax;
    }
    
    
}
