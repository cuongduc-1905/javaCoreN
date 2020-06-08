/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPropram;

import entity.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.StudenDao;

/**
 *
 * @author minh
 */
public class mainProgam {

    StudenDao studenDao = new StudenDao();

    public int showMenu() {
        System.out.println("======menu======");
        System.out.println("1.nhap");
        System.out.println("2.hien thi");
        System.out.println("3.tim theo ten");
        System.out.println("4.xap xep theo tuoi tu c->t");
        System.out.println("5.tim tuoi max");
        System.out.println("6.ghi vao file");
        System.out.println("7.file ghi vao database");
        System.out.println("8.thoat");
        Scanner sc = new Scanner(System.in);
        int chose = sc.nextInt();
        return chose;
    }

    public void inputData() {
        Student s = new Student();
        s.inputData();
        studenDao.insert(s);
    }

    public void display() {
        // Student s = new Student();
        List<Student> data = studenDao.getAll();
        for (Student s : data) {
            s.display();
        }
    }

    public void searchName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ban nhap ten cau tim");
        String name = sc.nextLine();
        studenDao.getName(name).display();
    }

    public void sortAge() {
        List<Student> data = studenDao.getAll();

        data.sort((x1, x2) -> x2.getAge() - x1.getAge());
        for (Student s : data) {
            s.display();
        }
    }

    public void AgeMax() {
        List<Student> data = studenDao.getAll();
        int max = 0;
        for (int i = 0; i < data.size(); i++) {
            max = data.get(i).getAge();
        }
        for (Student s : data) {
            if (s.getAge() == max) {
                s.display();
            }
        }

    }

    public void witeField() {
        List<Student> data = studenDao.getAll();
        try {
            FileOutputStream fos = new FileOutputStream("data.txt", true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Student s : data) {
                bw.write(s.writeFiel());
                bw.newLine();
            }
            bw.flush();
            bw.close();
            fos.close();
            System.out.println("succsessfully");

        } catch (Exception ex) {
            Logger.getLogger(mainProgam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readField() {
        List<Student> data = studenDao.getAll();
        String pathname = "/home/minh/NetBeansProjects/tatol2JavaCore2/data.txt";
        File myFile = new File(pathname);
        String[] datafile = null;
        String line;
        int cnt = 1;
        try {
            FileInputStream fis = new FileInputStream(myFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            while ((line = br.readLine()) != null) {
                System.out.println(cnt + ".\t" + line);
                cnt++;
                datafile = line.split(",");
                //1,minh,c1812m,18
                //[1,minh,c182m,18];

                Student c = new Student();
                //c.setId(Integer.parseInt(datafile[0]));
                c.setName(datafile[1]);
                c.setClasss(datafile[2]);
                c.setAge(Integer.parseInt(datafile[3]));
                studenDao.insert(c);
            }
            System.out.println("succsessFully");

        } catch (Exception ex) {
            Logger.getLogger(mainProgam.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        mainProgam menu = new mainProgam();
        int selection = 0;
        do {
            selection = menu.showMenu();
            switch (selection) {
                case 1:
                    menu.inputData();
                    break;
                case 2:
                    menu.display();
                    break;
                case 3:
                    menu.searchName();
                    break;
                case 4:
                    menu.sortAge();
                    break;
                case 5:
                    menu.AgeMax();
                    break;
                case 6:
                    menu.witeField();
                    break;
                case 7:
                    menu.readField();
                    break;
                case 8:
                    //menu.inputData();
                    break;

                default:
                    System.out.println("ban chon sai so");
                    break;
            }
        } while (true);
    }
}
