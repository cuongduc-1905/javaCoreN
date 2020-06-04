/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainComputer;

import java.sql.Connection;
import entity.Computer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ComputerDao;
import until.ConnectDBs;

/**
 *
 * @author minh
 */
public class MainComputer {
    
    ComputerDao computer = new ComputerDao();
    Computer c = new Computer();
    
    public int showMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===============Menu===============");
        System.out.println("1.nhap thong tin may tinh");
        System.out.println("2.hien thi");
        System.out.println("3.tim kiem theo ten");
        System.out.println("4.xap xep theo gia");
        System.out.println("5.tim nam cao nhat");
        System.out.println("6.xap xep theo ten");
        System.out.println("7.ghi vao file tu database");
        System.out.println("8.doc tu file vao database");
        System.out.println("9.xuat kho");
        System.out.println("10.sua so luong,sua gia");
        System.out.println("11.xoa san pham");
        System.out.println("12.thoat");
        int chose = sc.nextInt();
        return chose;
    }
    
    public void inputData(){
        c.inputData();
        computer.insert(c);
    }
    
    
    public void displayData(){
        List<Computer> data = computer.getAll();
        for (Computer c : data) {
            c.display();
        } 
    }
    
    public void searchName(){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        computer.getName(name).display();
    }
    public void sortByPrice(){
        List<Computer> data = computer.getAll();
        data.sort( ( x1, x2) -> (int)(x1.getPrice() - x2.getPrice()));
        for (Computer c : data) {
            c.display();
        }
    }
    public void searchYaerMax(){
        int max = 0;
        List<Computer> data = computer.getAll();
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getYear() > max){
                max = data.get(i).getYear();
            }
        }
        
        for (Computer c : data) {
            if(c.getYear() == max){
                c.display();
            }
        }
        
    }
    public void sortByName(){
        List<Computer> data = computer.getAll();
        data.sort((x1,x2) -> x1.getName().compareTo(x2.getName()));
        for (Computer c : data) {
            c.display();
        }
    }
    public void writeFile(){
        List<Computer> data = computer.getAll();
        try {
            FileOutputStream fos = new FileOutputStream("data.txt");
            //ObjectOutputStream oOs = new ObjectOutputStream(fos);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (Computer c : data) {
                bw.write(c.inputWrite());
                bw.newLine();   
            }
            bw.flush();
            bw.close();
            System.out.println("succsesfully");
        } catch (Exception ex) {
            Logger.getLogger(MainComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void readFile(){
         
        String filePath = "/home/minh/NetBeansProjects/tatolJavaCore2/data.txt";
        String[] tokens;
        String line;
        try {
            File myFile = new File(filePath);
            //FileReader fis = new FileReader(filePath);
            FileInputStream fis = new FileInputStream(myFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
            int cnt = 1;
            while ((line = bufferedReader.readLine()) != null) {                
                tokens = line.split(",");
                //computer.insert(tokens);
               
                System.out.println(cnt +".\t"+ line);
                cnt++;
            }
             System.out.println("succsessfully");
            
        }catch (Exception ex) {
            Logger.getLogger(MainComputer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void export(){
        Computer c = new Computer();
        c.inputExport();
        computer.export(c, c.getId(), c.getQty());
        
    }
    public void update(){
        Computer c = new Computer();
        c.Update();
        computer.update(c, c.getId());
        
    }
    public void delete(){
        Computer c = new Computer();
        
        c.delete();
        computer.delete(c.getId());
        
    }
    
    public static void main(String[] args) {
        MainComputer menu = new MainComputer();
        int selection = 0;
        do {            
            selection = menu.showMenu();
           switch(selection){
                case 1:
                    menu.inputData();
                    break;
                case 2:
                    menu.displayData();
                    break;
                case 3:
                    menu.searchName();
                    break;   
                case 4:
                    menu.sortByPrice();
                    break;
                case 5:
                    menu.searchYaerMax();
                    break;
                case 6:
                    menu.sortByName();
                    break;  
                case 7:
                    menu.writeFile();
                    break;
                case 8:
                    menu.readFile();
                    break;  
                case 9:
                    menu.export();
                    break;      
                case 10:
                    menu.update();
                    break;
                case 11:
                    menu.delete();
                    break;
                default:
                    System.out.println("ban nhap kg dung");
                    break;
           }
        } while (selection <= 12);
  
    }
    
}
