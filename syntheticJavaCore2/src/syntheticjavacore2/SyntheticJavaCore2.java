/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syntheticjavacore2;

import entity.Shoes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DataProcider;
import model.ShoesDao;

/**
 *
 * @author minh
 */
public class SyntheticJavaCore2 {
    
    private static String filePath = "/home/minh/Documents/shoes.db";
   
    public static void readWriteFile(){
        FileOutputStream fos;
        try {
                fos = new FileOutputStream(filePath);
            
                ObjectOutputStream oOs = new ObjectOutputStream(fos);
                 ShoesDao shoes = new ShoesDao();
                 List<Shoes> data = shoes.getAllShoes();
                
                oOs.writeObject(data);
                oOs.flush();
                oOs.close();
                fos.close();
                
                FileInputStream fIs = new FileInputStream(filePath);
                ObjectInputStream oIs = new ObjectInputStream(fIs);
            
                oIs.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SyntheticJavaCore2.class.getName()).log(Level.SEVERE, null, ex);    
            }catch (IOException ex) {
                Logger.getLogger(SyntheticJavaCore2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void witeraddFile(){
        File file = new File(filePath);
        try {
            PrintWriter writers = new PrintWriter(file);
            Scanner input = new Scanner(System.in);
            System.out.println("ban nhap ");
             String name = input.nextLine();
            writers.write(name);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SyntheticJavaCore2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    } 
    
    
    public static void main(String[] args) throws IOException {
        ShoesDao main = new ShoesDao();
        
//        for (Object i : main.where(2)) {
//             Shoes p = (Shoes) i;
//            p.display();
//        }
//        
//        System.out.println("successFully");
//        for (Object item : main.getAllShoes()) {
//            Shoes s = (Shoes)item;
//            s.display();
//        }
//        Shoes s = new Shoes();
//        s.inputData();
//        main.addShoes(s);
//     
//        System.out.println("tim");
        
        //main.delete(1);
        // SyntheticJavaCore2 chosi = new SyntheticJavaCore2();
        //SyntheticJavaCore2.witeraddFile();
        //SyntheticJavaCore2.readWriteFile();
        
        //DataProcider prodci = DataProcider.getInstance();
       // String sql = "SELECT * FROM `Shoes` WHERE id = ?";
        //List<Shoes> data = prodci.excuteQuery(sql, Shoes.class, 2);
         
//         List<Shoes> out = (List<Shoes>) main.getId(1);
//        for (Shoes shoe : out) {
//            shoe.display();
//        }
          //main.getId(2).display();
        File myobj = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(myobj));
            String st;
            while ((st = br.readLine()) != null) {                
                System.out.println(st);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SyntheticJavaCore2.class.getName()).log(Level.SEVERE, null, ex);
        }
       
          
          
    }
    
}
