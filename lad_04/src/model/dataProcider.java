/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import uitl.connectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class dataProcider {
    
    private static dataProcider instance = new dataProcider();
    
    private dataProcider(){
        
    }
    public static dataProcider getInstance(){
        if(instance == null){
            instance = new dataProcider();
        }
        return  instance;
    }

     public <T> List<T> executeQuery(String sql, Class<T>sourCode, Object... param){
         List<T> data = new ArrayList<>();
         Connection conn = connectDB.getJDBC();
         
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if(param != null && param.length > 0){
                for (int i = 0; i < param.length; i++) {
                    ps.setObject(i + 1, param[i]);
                }
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                try {
                    T obj = sourCode.newInstance();
                    
                    Field[] field = obj.getClass().getDeclaredFields();
                    for (Field fs : field) {
                        fs.setAccessible(true);
                        
                        fs.set(obj, rs.getObject(fs.getName()));
                    }
                    data.add(obj);
                    
                } catch (InstantiationException ex) {
                    Logger.getLogger(dataProcider.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(dataProcider.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(dataProcider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
         
    }
     
    public int executeUpdate(String sql, Object... param){
        Connection conn = connectDB.getJDBC();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if(param != null && param.length > 0){
                for (int i = 0; i < param.length; i++) {
                    ps.setObject(i + 1, param[i]);
                }
            }
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dataProcider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
        
    } 
     
    
}
