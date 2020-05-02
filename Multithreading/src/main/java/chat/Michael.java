/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

/**
 *
 * @author minh
 */
public class Michael implements Runnable{
    
    chat m ;
    String[] s2 = {"hi","i am good,what about you?","Great"};

    public Michael(chat m2) {
        this.m = m2;
        new Thread(this,"Answer").start();
        
    }
    
    
    @Override
    public void run() {
        for(int i = 0; i < s2.length ; i++){
            m.Answer(s2[i]);
        }
    }
    
}
