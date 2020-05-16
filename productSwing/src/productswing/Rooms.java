/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productswing;

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
public class Rooms {
    MyConnection myConnection = new MyConnection();
    //create a function to display all rooms type in jtable
    public void fillRoomTypeJTable(JTable table){
        
        PreparedStatement ps;
        
        ResultSet rs;
        String sql = "select * from type";
        
        
        try {
            ps = myConnection.getJDBCConnection().prepareStatement(sql);
        
            rs = ps.executeQuery();
            
            DefaultTableModel TableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            while (rs.next()) {
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                
                TableModel.addRow(row);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    //create a function to fill a combobox with the rooms id 
    
    
    
}
