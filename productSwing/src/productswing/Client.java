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
public class Client {
    
    MyConnection myConnection = new MyConnection();
    //ceate a funtion t add a client

    public boolean addClient(String fname, String lname, String phone, String email){
        
        PreparedStatement st;
        
        //ResultSet rs;
        
        String addSql = "insert into client(first_name,last_name,phone,email)value(?,?,?,?)";
        
        try {
            st = myConnection.getJDBCConnection().prepareStatement(addSql);
            
            st.setString(1, fname);
            st.setString(2, lname);
            st.setString(3, phone);
            st.setString(4, email);
            
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
    
    
    //create a funtion to edit the selected client
    public boolean editClient(int id, String fname, String lname, String phone, String email){
        PreparedStatement st;
        String editSql = "update client set first_name = ?, last_name = ?, phone = ?, email = ? where id = ?";
        
        try {
            st = myConnection.getJDBCConnection().prepareStatement(editSql);
        
            st.setString(1, fname);
            st.setString(2, lname);
            st.setString(3, phone);
            st.setString(4, email);
            st.setInt(5, id);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
        
        
    }
    
    //create a funtion to remove thr selected client
    public boolean removeclient(int id){
        PreparedStatement st ;
        String UpdateSql = "delete from client where id = ?";
        
        try {
            st = myConnection.getJDBCConnection().prepareStatement(UpdateSql);
            
            st.setInt(1, id);
            
            return (st.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
    //create a function to return a list of all clients
    
    //create a function to populate the jtabel with all the clients in database
    public void fillclientJTable(JTable table){
        PreparedStatement ps ; 
        ResultSet rs;
        
        String sql = "select * from client";
        
        try {
            ps = myConnection.getJDBCConnection().prepareStatement(sql);
        
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
        
            Object[] row;
            while(rs.next()){
                row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                
                tableModel.addRow(row);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
