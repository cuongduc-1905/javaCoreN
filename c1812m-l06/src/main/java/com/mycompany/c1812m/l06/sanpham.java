/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.c1812m.l06;

/**
 *
 * @author minh
 */
public class sanpham {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        claas04 sp1,sp2;
        
        sp1 = new claas04();
        sp2 = new claas04("sp02","tu lanh","sanyo",2020,70000);
        sp1.input();
        sp1.display();
        sp2.display();
    }
}
