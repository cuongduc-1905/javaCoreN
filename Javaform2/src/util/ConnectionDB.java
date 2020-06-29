/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class ConnectionDB {
    private static String url = "jdbc:mysql://localhost:3306/Student";
    private static String use = "root";
    private static String pass = "";
    
    public static Connection getJDBCconnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return  DriverManager.getConnection(url, use, pass);
        } catch (Exception ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        Connection conn = getJDBCconnect();
        if(conn != null){
            System.out.println("succsess");
        }else{
            System.out.println("false");
        }
    }
}
