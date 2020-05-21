/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author minh
 */
public class Product {
    
    MyConnection myConnection = new MyConnection();
    
    public void showProduct(JTable table){
        PreparedStatement ps;
        ResultSet rs;
        
        String sql = "select * from product";
        try {
            ps = myConnection.getJDBCConnection().prepareStatement(sql);
            
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            
            rs = ps.executeQuery();
            Object[] row;
            while (rs.next()) {                
                row = new Object[7];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getInt(4);
                row[4] = rs.getInt(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                
                tableModel.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
}
