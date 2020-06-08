/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import  java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectDB;

/**
 *
 * @author minh
 */
public class DataProceder {
    private static DataProceder instance = new DataProceder();
    private DataProceder(){
        
    }
    public static DataProceder getInstance(){
        if(instance == null){
            instance = new DataProceder();
           
        }
        return instance;
        
    }
    
    public<T>List<T> excuQuery(String sql, Class<T>sourType,Object...params){
        List<T>data = new ArrayList<>();
        Connection conn = ConnectDB.getJDBC();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if(params != null && params.length > 0 ){
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
                    fs.set(obj, rs.getObject(fs.getName()));
                }
                data.add(obj);
                
                
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(DataProceder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
        
    }
    
    public int excuUpdate(String sql, Object...params){
        Connection conn = ConnectDB.getJDBC();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if(params != null && params.length > 0){
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1, params[i]);
                }
            }
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DataProceder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
    }
    
}
