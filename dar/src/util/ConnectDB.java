/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author minh
 */
public class ConnectDB {
    public static Connection getJDBCConnection(){
       

        final String url = "jdbc:mysql://localhost:3306/test";
        final String user = "root";
        final String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
            
    }
    
    
    
    
}
