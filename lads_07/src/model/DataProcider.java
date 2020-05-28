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
import uitl.ConnectDbs;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author minh
 */
public class DataProcider {
    private static DataProcider instance = new DataProcider();
    
    private DataProcider(){
        
    }
    public static DataProcider getInstance(){
        if(instance == null){
            instance = new DataProcider();
        }
        return instance;
    }
    
    public <T> List<T> executeQuery(String sql, Class<T>sourceType, Object... params){
        List<T> data = new ArrayList<>();
        Connection conn = ConnectDbs.getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if(params != null && params.length > 0){
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1, params[i]);
                }
            }
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                
                try {
                    T obj = sourceType.newInstance();
                    
                    Field[] field = obj.getClass().getDeclaredFields();
                    for (Field fs : field) {
                        fs.setAccessible(true);
                        
                        fs.set(obj, rs.getObject(fs.getName()));
                    }
                    data.add(obj);
                    
                    
                } catch (InstantiationException ex) {   
                    Logger.getLogger(DataProcider.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(DataProcider.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DataProcider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
        
        
    }
    public int excuteUpdate(String sql, Object... params){
        try {
            Connection conn = ConnectDbs.getJDBCConnection();
            
            PreparedStatement ps = conn.prepareStatement(sql);
            if(params != null && params.length > 0){
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1, params[i]);
                }
            }
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
