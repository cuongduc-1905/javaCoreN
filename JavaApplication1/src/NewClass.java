/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author minh
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NewClass {

    public static Connection getJDBCConnection() {
        final String url = "jdbc:mysql://localhost:3306/Student";
        final String user = "root";
        final String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        Connection connection = getJDBCConnection();
        if (connection != null) {
            System.out.println("thanh cong");
        } else {
            System.out.println("that bai");
        }
    }
}
