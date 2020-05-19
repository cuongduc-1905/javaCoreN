package productswing;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import productswing.MyConnection;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author minh
 */
public class Reservation {
    
    
    //in the reservation table we need to add two forgein keys;
    //1 for the client:
    //ALTER TABLE revervation ADD CONSTRAINT fk_client_id FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE
    //2 for the room:
    //ALTER TABLE revervation ADD CONSTRAINT fk_room_id FOREIGN KEY (room_number) REFERENCES room(r_number) ON DELETE CASCADE
    //3 
    MyConnection myConnection = new MyConnection();
    
    Rooms room = new Rooms();
    //create function a add room
     public boolean addReservation(int clinet_id, int room_Nuber, String dateIn, String dateOut){
        
        PreparedStatement st;
        
        //ResultSet rs;
        
        String addSql = "insert into  revervation("
                + "client_id, "
                + "room_number,"
                + "data_in,"
                + "data_out)value(?,?,?,?)";
        
        try {
            st = myConnection.getJDBCConnection().prepareStatement(addSql);
            
            st.setInt(1, clinet_id);
            st.setInt(2, room_Nuber);            
            st.setString(3, dateIn);
            st.setString(4, dateOut);
            
            if(room.isRoomReserved(room_Nuber).equals("No")){
                if(st.executeUpdate() > 0){
                    room.setRoomToReserved("Yes", room_Nuber);
                    return true;
                
                }else{
                    return false;
            }
            }else{
                JOptionPane.showMessageDialog(null, "this room is already ", "rom reservaed", JOptionPane.WARNING_MESSAGE);

                return false;
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     
    }
    //edit 
    public boolean editReservation(int reservation_id, int clien_id, int room_number, String dateIn, String dateOut){
         
         PreparedStatement st;
         
         String editSql = "update revervation set client_id = ?"
                 + ", room_number = ?,data_in =? "
                 + ", data_out = ? "
                 + "where  id = ?";
         
        try {
            st = myConnection.getJDBCConnection().prepareStatement(editSql);
            st.setInt(1, clien_id);
            st.setInt(2, room_number);
            st.setString(3, dateIn);
            st.setString(4, dateOut);
            st.setInt(5, reservation_id);
            
            return (st.executeUpdate() > 0);
            
        
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
         
         
         
     } 
    
    public boolean removeReservation(int reservation_id){
        PreparedStatement st;
        
        String removeSql = "delete from revervation where id = ?";
        
        try {
            st = myConnection.getJDBCConnection().prepareStatement(removeSql);
            
            st.setInt(1, reservation_id);
            int Room_number = getRoomNumberFromReservation(reservation_id) ;
            if((st.executeUpdate() > 0)){
                room.setRoomToReserved("No", Room_number);
                return true;
                
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    } 
     
    public void fillReservationJTable(JTable table){
        
        PreparedStatement ps;
        
        ResultSet rs;
        String sql = "select * from revervation";
        
        
        try {
            ps = myConnection.getJDBCConnection().prepareStatement(sql);
        
            rs = ps.executeQuery();
            
            DefaultTableModel TableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            while (rs.next()) {
                row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                
                TableModel.addRow(row);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    // create a fuction to get the room number from reservation i
    public int getRoomNumberFromReservation(int reservationID){
        PreparedStatement ps;
        ResultSet rs;
        String selecSql = "select room_number from revervation where id = ?";
        
        try{
            ps = myConnection.getJDBCConnection().prepareStatement(selecSql);
            
            ps.setInt(1, reservationID);
            
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
                
            }else{
                return 0 ;
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
        
    }
    
    
    
}
