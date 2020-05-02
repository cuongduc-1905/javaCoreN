/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batdongbo;

/**
 *
 * @author minh
 */
public class ATM extends Thread{

   private Account acc;

    public ATM(Account acc, String name) {
        super(name);
        this.acc = acc;
    }
   
    
    
    
    
    @Override
    public void run() {
        //xu ly rut tien
        synchronized(acc){//yeu cau dong bo doi tuong
            acc.withdraw(getName());
        }
    }
    
    
    
}
