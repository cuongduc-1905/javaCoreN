/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testasynchronous;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class FaxMachine {
    
    Fax fx = new Fax();

    private class Fax {
        private String data;
        
        public void read(){
            Scanner  sc = new Scanner(System.in);
            data = sc.nextLine();
            
        }
        
        
        public void write(){
            System.out.println("\t" + data);
            
        }
        
    }
    
    Runnable taskRead = new Runnable() {
        @Override
        public void run() {
            synchronized(fx){
                while (true) {                    
                    try {
                        fx.read();//doi nguoi dung nhap du lieu
                        fx.notify();//nhập xong >> nhả đối tượng
                        fx.wait();// đăng kí chờ đối tượng;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FaxMachine.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        }
    };
    
    Runnable taskWrite = new Runnable() {
            @Override
            public void run() {
                synchronized(fx){
                    while (true) {                    
                        try {
                            fx.write();//doi nguoi dung nhap du lieu
                            fx.notify();//nhập xong >> nhả đối tượng
                            fx.wait();// đăng kí chờ đối tượng;
                        } catch (InterruptedException ex) {
                            Logger.getLogger(FaxMachine.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
            }
    };
//    Runnable taskEnd = new Runnable() {
//        @Override
//        public void run() {
//            synchronized(fx){
//                while (true) {                    
//                    fx.read();
//      
//                }
//                
//            }
//        }
//    };
    /**
     * @param args the command line arguments
     */
    private void demo(){
        Thread read = new Thread(taskRead);
        Thread write = new Thread(taskWrite);
        //Thread end = new Thread(taskEnd);
        read.start();
        write.start();
        //end.stop();
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        FaxMachine faxM = new FaxMachine();
        faxM.demo();
        
    }
    
}
