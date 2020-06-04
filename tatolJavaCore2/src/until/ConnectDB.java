/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class ConnectDB {
    
    private static final String url = "jdbc:mysql://localhost:3306/Student";
    private static final String user = "root";
    private static final String password = "";
    
    public static Connection getJDBC() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
           
            return DriverManager.getConnection(url, user, password);
         } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return null;
    
    }
}
