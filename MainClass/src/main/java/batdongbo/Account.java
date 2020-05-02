/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batdongbo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class Account {
    
    private int amount = 10;
    
    
    public  void withdraw(String atm){
        if(amount <= 0){
            System.out.println("so tien trong tai khaoan kg du");
        }else{
            int turn = amount;
            for (int i = 0; i < turn; i++) {
                try {
                    System.out.println(atm + "\t" + amount );
                    amount--;
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
}
