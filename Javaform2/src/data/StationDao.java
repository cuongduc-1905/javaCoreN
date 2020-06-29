/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.sun.org.glassfish.external.arc.Stability;
import entity.Station;
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
public class StationDao {
    
    public List<Station> getAll(){
        List<Station> data = new ArrayList<>();
        try {
            Connection conn = ConnectionDB.getJDBCconnect();
            String sql = "SELECT * FROM Station";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Station b = new Station();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                data.add(b);
            } 
        }catch (Exception e) {
             e.printStackTrace();
        }
        return data;
        
    } 
   
}
