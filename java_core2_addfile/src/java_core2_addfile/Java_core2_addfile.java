/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_core2_addfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class Java_core2_addfile {
    private static final String filePath = "/home/minh/NetBeansProjects/java_core2_addfile/studen.db";
    List<studen> st = new ArrayList<>();
    
    private  void BookManager(){
        st.add(new studen(5, "nguyen van q", "10", "090909", "ha noi"));
        st.add(new studen(6, "nguyen van w", "12", "090909", "ha noi"));
        st.add(new studen(7, "nguyen van e", "14", "090909", "ha noi"));
        //st.add(new studen(4, "nguyen van f", "16", "090909", "ha noi"));
    }
    private void readWriteFile()  throws Exception{
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oOs = new ObjectOutputStream(fos);
        oOs.writeObject(st);
        oOs.flush();
        oOs.close();
        oOs.close();
//        FileInputStream fis = new FileInputStream(filePath);
//        ObjectInputStream oIs = new ObjectInputStream(fis);
    }
    private void display() throws Exception{
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream oIs = new ObjectInputStream(fis);
        st = (List<studen>) oIs.readObject();
        oIs.close();
        for (int i = 0; i < st.size(); i++) {
            System.out.println(st.get(i).toString());
        }
    }
    
    public static void main(String[] args) {
        Java_core2_addfile mainc = new Java_core2_addfile();
            mainc.BookManager();
        try {
            mainc.readWriteFile();
            mainc.display();
        } catch (Exception ex) {
            Logger.getLogger(Java_core2_addfile.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
