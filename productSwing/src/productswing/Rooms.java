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
import javax.swing.JComboBox;
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
     public void fillRoomTypeJcomboboxJTable(JComboBox combobox){
        
        PreparedStatement ps;
        
        ResultSet rs;
        String sql = "select * from type";
        
        
        try {
            ps = myConnection.getJDBCConnection().prepareStatement(sql);
        
            rs = ps.executeQuery();
            
            
            while (rs.next()) {
       
                
                combobox.addItem(rs.getInt(1));
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
     //create function a add room
     public boolean addRooms(int number, int type, String phone){
        
        PreparedStatement st;
        
        //ResultSet rs;
        
        String addSql = "insert into room(r_number,type,phone,revered)value(?,?,?,?)";
        
        try {
            st = myConnection.getJDBCConnection().prepareStatement(addSql);
            
            st.setInt(1, number);
            st.setInt(2, type);
            st.setString(3, phone);
            st.setString(4, "No");
            //when we add a new room
            //the resvered colum will be set to no
            // the revered colum mean i this room is free or not
            
            if(st.executeUpdate() > 0){
                return true;
                
            }else{
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     
    }
     //create a function to add a new room
    public boolean editRoom(int number, String phone, String isRevered, int type){
         
         PreparedStatement st;
         
         String editSql = "update room set type = ?, phone = ?,revered =? where  r_number = ?";
         
        try {
            st = myConnection.getJDBCConnection().prepareStatement(editSql);
            st.setInt(1, type);
            st.setString(2, phone);
            st.setString(3, isRevered);
            st.setInt(4, number);
            return (st.executeUpdate() > 0);
            
        
        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
         
         
         
     }
     //create function to remove th select from room
    public boolean removeRooms(int roomNumber){
        PreparedStatement st;
        
        String removeSql = "delete from room where r_number = ?";
        
        try {
            st = myConnection.getJDBCConnection().prepareStatement(removeSql);
            
            st.setInt(1, roomNumber);
            return (st.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
        
    } 
     
    public void fillRoomJTable(JTable table){
        
        PreparedStatement ps;
        
        ResultSet rs;
        String sql = "select * from room";
        
        
        try {
            ps = myConnection.getJDBCConnection().prepareStatement(sql);
        
            rs = ps.executeQuery();
            
            DefaultTableModel TableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            while (rs.next()) {
                row = new Object[4];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                TableModel.addRow(row);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
   
         
     //create a function to set a room reserved or not 
     public boolean setRoomToReserved(String isResered, int number){
         
         PreparedStatement st;
         
         String editSql = "update room set revered = ? where r_number = ?";
         
        try {
            st = myConnection.getJDBCConnection().prepareStatement(editSql);
         
            st.setString(1, isResered);
            st.setInt(2, number);
            return (st.executeUpdate() > 0);
            
        
        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
         
         
         
     }
     
     //create a fuction to check if a room is alredy reservaed
    
    public String isRoomReserved(int number){
         
         PreparedStatement st;
         ResultSet rs;
         String editSql = "select revered from room where r_number = ?";
         
         
         
        try {
            st = myConnection.getJDBCConnection().prepareStatement(editSql);
         
           
            st.setInt(1, number);
            rs = st.executeQuery();
            
            if(rs.next()){
                return rs.getString(1);
            }else{
                return "";
            }
             
        
        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
         
         
         
     } 
     
     
     
    
}
