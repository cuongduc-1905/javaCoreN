/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IMap;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author minh
 */
public class iMap {
    //hashMap kg thep tu tu 
    public static void main(String[] args) {
         HashMap<Integer, String> hn = new HashMap<>();  
         hn.put(1, "one");
         hn.put(2, "two");
         hn.put(3, "three");
         for (int key : hn.keySet()) {
             System.out.println(key + "" + hn.get(key) + "");
        }
        Iterator<Integer> iterator = hn.keySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        for(String value : hn.values()){
            System.out.println(value);
        }
    }
    
   
    
}
