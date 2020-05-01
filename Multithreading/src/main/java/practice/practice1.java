/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class practice1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PrintDemo PD = new PrintDemo();
        threadDemo T =  new threadDemo("thread -1", PD);
        threadDemo T2 = new threadDemo("thread-2", PD);
        
        T.start();
        T2.start();
        
        
        try {
            T.join();
            T2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(practice1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
