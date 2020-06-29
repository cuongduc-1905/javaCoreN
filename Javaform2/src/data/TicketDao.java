/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Station;
import entity.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionDB;

/**
 *
 * @author minh
 */
public class TicketDao {
    	


     public List<Ticket> getAll(){
        List<Ticket> data = new ArrayList<>();
        try {
            Connection conn = ConnectionDB.getJDBCconnect();
            String sql = "SELECT * FROM ticket";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setPassenger(rs.getString("passenger"));
                ticket.setPhone(rs.getString("phone"));
                ticket.setFromSName(rs.getString("fromSName"));
                ticket.setToSName(rs.getString("toSName"));
                ticket.setType(rs.getInt("Type"));
                ticket.setStartDate(rs.getString("startDate"));
                ticket.setEndDate(rs.getString("endDate"));
                ticket.setAdult(rs.getInt("adult"));
                ticket.setChild(rs.getInt("child"));
               data.add(ticket);
            } 
        }catch (Exception e) {
             e.printStackTrace();
        }
        return data;
        
    } 
     
//id passenger phone Type startDate endDate fromSName toSName adult child
     public boolean insert(Ticket entyti){
         try {
            Connection conn = ConnectionDB.getJDBCconnect();
            String sql = "INSERT INTO ticket values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, entyti.getId());
            ps.setObject(2, entyti.getPassenger());
            ps.setObject(3, entyti.getPhone());
            ps.setObject(4, entyti.getType());
            ps.setObject(5, entyti.getStartDate());
            ps.setObject(6, entyti.getEndDate());
            ps.setObject(7, entyti.getFromSName());
            ps.setObject(8, entyti.getToSName());
            ps.setObject(9, entyti.getAdult());
            ps.setObject(10, entyti.getChild());

            if(ps.executeUpdate() > 0){
               return true;
            }
      
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
        
         
     }
    // passenger phone Type startDate endDate fromSName toSName adult child
    public boolean update(Ticket entyti, int id){
         try {
            Connection conn = ConnectionDB.getJDBCconnect();
            StringBuilder  sql = new StringBuilder("update ticket set");
            sql.append("passenger = ?, phone = ?, Type = ?, startDate = ?, endDate = ?");
            sql.append("fromSName = ?, toSName = ?,adult = ?, child = ?  where id = ?");
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            
            ps.setObject(1, entyti.getPassenger());
            ps.setObject(2, entyti.getPhone());
            ps.setObject(3, entyti.getType());
            ps.setObject(4, entyti.getStartDate());
            ps.setObject(5, entyti.getEndDate());
            ps.setObject(6, entyti.getFromSName());
            ps.setObject(7, entyti.getToSName());
            ps.setObject(8, entyti.getAdult());
            ps.setObject(9, entyti.getChild());
            ps.setObject(10, id);

            if(ps.executeUpdate() > 0){
               return true;
            }
      
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
        
         
     } 
    public boolean delete(int id){
         try {
            Connection conn = ConnectionDB.getJDBCconnect();
            String sql = "delete form  ticket  where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            if(ps.executeUpdate() > 0){
               return true;
            }
      
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
        
         
     }
    
}
