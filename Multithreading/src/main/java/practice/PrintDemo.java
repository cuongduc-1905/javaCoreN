/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import com.sun.source.tree.TryTree;

/**
 *
 * @author minh
 */
public class PrintDemo {

    public void PrintCount() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Counter --" + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
