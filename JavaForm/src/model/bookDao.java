/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnectionDB;


/**
 *
 * @author minh
 */
public class bookDao {
    public List<Book> getAll(){
        List<Book> data = new ArrayList<>();
        try {
            Connection conn = ConnectionDB.getJDBCconnect();
            String sql = "SELECT * FROM `book`";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Book b = new Book();
                b.setId(rs.getString("id"));
                b.setAuthor(rs.getString("author"));
                b.setPublishing(rs.getString("publishing"));
                b.setYear(rs.getInt("year"));
                b.setPrice(rs.getFloat("price"));
                b.setDate(rs.getString("date"));
                data.add(b);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(bookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return data;
        
        
        
    }
    
    public boolean insert(Book entity){
       Connection conn = ConnectionDB.getJDBCconnect();
            String sql = "INSERT INTO `book` value(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            Book b = new Book();
            ps.setObject(1, entity.getId());
            ps.setObject(2, entity.getAuthor());
            ps.setObject(3, entity.getPublishing());
            ps.setObject(4, entity.getYear());
            ps.setObject(5, entity.getPrice());
            ps.setObject(6, entity.getDate());
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(bookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
            
    }
    public boolean delete(String id){
       Connection conn = ConnectionDB.getJDBCconnect();
            String sql = "DELETE FROM `book` WHERE id= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            Book b = new Book();
            ps.setObject(1, id);
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(bookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
            
    }
    public boolean update(Book entity){
       Connection conn = ConnectionDB.getJDBCconnect();
            String sql = "UPDATE `book` SET  WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            Book b = new Book();
            ps.setObject(2, b.getAuthor());
            ps.setObject(3, b.getPublishing());
            ps.setObject(4, b.getYear());
            ps.setObject(5, b.getPrice());
            ps.setObject(6, b.getDate());
            ps.setObject(1, b.getId());
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(bookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
            
    }
    
    
}
