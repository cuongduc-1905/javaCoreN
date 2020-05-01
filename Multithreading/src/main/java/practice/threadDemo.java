/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author minh
 */
public class threadDemo extends Thread{
    
    private Thread t;
    
    private String threadName;
    
    PrintDemo PD;

    public threadDemo(String threadName, PrintDemo PD) {
        this.threadName = threadName;
        this.PD = PD;
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        synchronized(PD){
            PD.PrintCount();
        }
        System.out.println("Thread" + threadName + "exitting");
    }

  
    
    
    
    
    
}
