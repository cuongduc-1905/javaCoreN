/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iset;

import java.util.HashSet;
import java.util.TreeSet;

/**
 *
 * @author minh
 */
public class mainIset {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //HashSet
        HashSet<Integer> hs = new HashSet<>();
       // hs.add(1);
        hs.add(-1);
        hs.add(4);
        hs.add(1);
        for (Integer h : hs) {
            System.out.println(h);
        }
        
        //treeSet xap xep theo thu tu
        TreeSet<Integer> ts2 = new TreeSet<>();
        ts2.add(1);
        ts2.add(-1);
        ts2.add(1);
        ts2.add(4);
        System.err.println("treeset");
        for (Integer ts : ts2) {
            System.out.println(ts);
        }
    }
    
}
