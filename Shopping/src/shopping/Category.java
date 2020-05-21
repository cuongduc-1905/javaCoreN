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
public class Category {
    
    MyConnection myConnection = new MyConnection();
    
    public boolean addCategory(int id, String name){
        PreparedStatement ps;
        
        String sql = "insert into category(ID, nameCategory)value(?,?)";
        
        try {
            ps = myConnection.getJDBCConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public boolean editCategory(int id, String name){
        PreparedStatement ps;
        
        String sql = "update category  set nameCategory = ? where ID = ?";
        
        try {
            ps = myConnection.getJDBCConnection().prepareStatement(sql);
            
            ps.setInt(2, id);
            ps.setString(1, name);
            
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean deleteCategory(int id){
        PreparedStatement ps;
        
        String sql = "delete from category where ID = ?";
        
        try {
            ps = myConnection.getJDBCConnection().prepareStatement(sql);
            
            ps.setInt(1, id);
           
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public void displayJTable(JTable table){
        PreparedStatement ps;
        ResultSet rs;
        
        String sql = "select * from category";
        
        try {
            ps = myConnection.getJDBCConnection().prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            
            Object[] row;
            while (rs.next()) {                
                row = new Object[2];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                
                tableModel.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
