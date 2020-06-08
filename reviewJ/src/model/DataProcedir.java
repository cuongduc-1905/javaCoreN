/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.connectDB;
import java.sql.ResultSet;

/**
 *
 * @author minh
 */
public class DataProcedir {
    private static DataProcedir instance = new DataProcedir();
    private DataProcedir(){
        
    }
    public static DataProcedir getInstance(){
        if(instance == null){
            instance = new DataProcedir();
        }
        return instance;
    }
    
    public <T>List<T> excutQuery(String sql, Class<T>sourType, Object...params){
        List<T> data = new ArrayList<>();
        Connection conn = connectDB.getJDBC();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if(params != null && params.length > 0){
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1, params[i]);
                }
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                T obj = sourType.newInstance();
                Field[] field = obj.getClass().getDeclaredFields();
                for (Field fs : field) {
                    fs.setAccessible(true);
                    fs.set(fs, rs.getObject(fs.getName()));
                }
                data.add(obj);
                
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(DataProcedir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public int execUpdate(String sql, Object...params){
        Connection conn = connectDB.getJDBC();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if(params != null && params.length > 0){
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1, params[i]);
                }
            }
            return ps.executeUpdate();
        }catch (Exception ex) {
             Logger.getLogger(DataProcedir.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return 0;
    }
    
    
}
