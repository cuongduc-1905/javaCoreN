/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minh.Jframe;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author minh
 */
public class JFrames {

    /**
     * @param args the command line arguments
     */
    private JFrame frame;
    JButton button;
    
    public JFrames(){
        creatAndShow();
    }
    
    public void creatAndShow(){
        button = new JButton();
        frame = new JFrame("Title");
        frame.setSize(400,300);//kich thuoc
        frame.setLocationRelativeTo(null);//cho ra giu mang hinh
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//an x tat
        frame.add(button);
            
        frame.setVisible(true);//hien thi no
        
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new JFrames();
    }

    
    
}
