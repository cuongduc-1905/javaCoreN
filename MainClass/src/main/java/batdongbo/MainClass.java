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
public class MainClass {
    
    
    public static void main(String[] args) {
        //khoi tao doi tuong tai khoan
        
        Account acc = new Account();
        
        ATM atmPVD = new ATM(acc, "pham van dong");
        ATM atmHQV = new ATM(acc, "hoang quoc viet");
    
        
        atmPVD.start();
        atmHQV.start();
        
       
    
    }
}
