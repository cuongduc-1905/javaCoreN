/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



/**
 *
 * @author minh
 */
public class mainFile{
    private String filePath = "/home/minh/Documents/data.dat";
    
    ArrayList<Book> listBook = new ArrayList();
    
    private void BookManager () {
        listBook.add(new Book ("b01","cha giau cha ngheo","minh","kim dong",20f));
        listBook.add(new Book ("b01","song chet mac bay","kim lan","kim dong",24f));
        listBook.add(new Book ("b01","chi cheo","nam cao","kim dong",100f));
    }
    
    private void readWriteFile () throws FileNotFoundException, IOException, ClassNotFoundException{
        // open stream to write 
        FileOutputStream fOs = new FileOutputStream(filePath);// dec file
        ObjectOutputStream oOs = new  ObjectOutputStream(fOs); // dec object(name file)
        
        oOs.writeObject(listBook);//ghi object  listBook into file
        oOs.flush();
        oOs.close();
        fOs.close();
        // open stream to read
        FileInputStream fIs = new FileInputStream(filePath);
        ObjectInputStream oIs = new ObjectInputStream(fIs);
        
        oIs.readObject();
        
        
    }
    
    public static void main(String args[]) {
        
    }
}
