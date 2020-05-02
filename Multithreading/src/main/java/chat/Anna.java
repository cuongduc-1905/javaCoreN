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
public class Anna implements Runnable{
    
    chat m;
    String[] s1 = {"hi","how are you?", "i am also doing finel"};
    
    public Anna(chat m1){
        this.m = m1;
        new Thread(this,"Question").start();
    }
    
    
    
    @Override
    public void run() {
        for(int i =0; i < s1.length; i++){
            m.Quenstion(s1[i]);
        }
    }
    
}
