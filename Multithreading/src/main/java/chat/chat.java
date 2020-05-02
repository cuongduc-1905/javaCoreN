/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class chat {
    boolean flag = false;
    
    public synchronized void Quenstion(String msg){
        if(flag){
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
           
           
        }
        System.out.println(msg);
        flag = true;
        notify();
        
        
    }
    
    public synchronized void Answer(String msg){
        if(flag){
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            
        }
        System.out.println(msg);
        flag = true;
        notify();
        
    }
    
    
}
