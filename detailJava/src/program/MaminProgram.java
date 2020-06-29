/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import entity.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.StudentDao;

/**
 *
 * @author minh
 */
public class MaminProgram {
    
    StudentDao studentDao = new StudentDao();
    
    public int showMenu(){
        System.out.println("======menu=======");
        System.out.println("1.nhap thon tin");
        System.out.println("2.hien thi");
        System.out.println("3.input file in data.text");
        System.out.println("4.input on databse");
        Scanner sc = new Scanner(System.in);
        int chose = sc.nextInt();
        return chose;
    }
    
    public void inputData(){
        Student s = new Student();
        s.inputData();
        studentDao.insert(s);
    }
    
    public void display(){
        List<Student> data = studentDao.getAll();
        
        for (Student s : data) {
            s.display();
        }
        
    }
    public void wrifile(){
        List<Student> data = studentDao.getAll();
        try {
            FileOutputStream fos = new FileOutputStream("data.txt");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (Student st : data) {
                bw.write(st.writeBuf());
                bw.newLine();
                
            }
            System.out.println("sueccfully");
            bw.flush();
            bw.close();
            fos.close();
            
        } catch (Exception ex) {
            Logger.getLogger(MaminProgram.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void readFile(){
        
        String line;
        String datafile[];
        
        try {
            FileInputStream fis = new FileInputStream("/home/minh/NetBeansProjects/detailJava/data.txt");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            int ctn = 1;
            while ((line = br.readLine()) != null) {                
                datafile = line.split(",");
                Student s = new Student();
                s.setName(datafile[1]);
                s.setAge(Integer.parseInt(datafile[2]));
                s.setClass(datafile[3]);
                
                System.out.println(ctn +"\t" + line);
                ctn++;
            }
            
            br.close();
            fis.close();
        } catch (Exception ex) {
            Logger.getLogger(MaminProgram.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    

    public static void main(String[] args) {
        MaminProgram menu = new MaminProgram();
        int selection = 0;
        do {            
            selection = menu.showMenu();
            switch(selection){
                case 1 :
                    menu.inputData();
                    break;
                case 2 : 
                    menu.display();
                    break;
                case 3 :
                    menu.wrifile();
                    break;
                case 4 :
                    menu.readFile();
                    break;
                case 5 :
                    System.out.println("thoat");
                    break;
                default:
                    System.out.println("ban nhap sai");
                    break;
            }
            
        } while (selection > 0 && selection < 5);
    }
    
    
    
}
