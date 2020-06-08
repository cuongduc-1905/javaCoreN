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
public class connectDB {

    private static final String url = "jdbc:mysql://localhost:3306/Student";
    private static final String use = "root";
    private static final String pass = "";

    public static Connection getJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection(url, use, pass);

        } catch (Exception ex) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static void main(String[] args) {
        Connection conn = connectDB.getJDBC();

        if (conn != null) {
            System.out.println("successfully");
        } else {
            System.out.println("false");
        }

    }

}
