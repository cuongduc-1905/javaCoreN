/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uitl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class connectDB {
    private static String URL ="jdbc:mysql://localhost:3306/Student";//jdbc:mysql://localhost:3306/Student
    private static String name ="root";
    private static String password ="";
    
    public static Connection getJDBC(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL,name,password);
        }catch (SQLException ex) {
                Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        Connection conn = getJDBC();
        if(conn != null){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    
    
}
