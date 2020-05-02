/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class DemoExcuterService {
    
    private class MyTask implements Runnable {
        
        private String name;

        public MyTask(String name) {
            this.name = name;
        }
        
        
        
        @Override
        public void run() {
            for (int i = 0 ; i < 10 ; i++){
                try {
                    System.out.println(this.name + "......");
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DemoExcuterService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    
    private void demo(){
        MyTask t0 = new MyTask("Task 0");
        MyTask t1 = new MyTask("Task 1");
        MyTask t2 = new MyTask("Task 2");
        MyTask t3 = new MyTask("Task 3");
        MyTask t4 = new MyTask("Task 4");
        MyTask t5 = new MyTask("Task 5");
        //khoi tao doi tuong excutor voi cai dat so Thread song song va dong thoi
       
        ExecutorService es = Executors.newFixedThreadPool(1);
        
        es.submit(t0);
        es.submit(t1);
        es.submit(t2);
        es.submit(t3);
        es.submit(t4);
        es.submit(t5);
        es.shutdown();
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        DemoExcuterService dm = new DemoExcuterService();
        
        dm.demo();
        
    }
    
}
