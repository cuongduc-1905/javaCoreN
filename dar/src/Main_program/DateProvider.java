/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_program;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectDB;

/**
 *
 * @author minh
 */
public class DateProvider {
    private static DateProvider instance = new DateProvider();
    
    private DateProvider(){
        
    }
    
    public static DateProvider getinstance(){
        if (instance == null) {
            instance = new DateProvider();
        }
        return instance;
    }
    public <T> List<T> executeQuery(String sql, Class<T> sourceType, Object... params){
        List<T> data = new ArrayList<>();
        
        Connection conn = ConnectDB.getJDBCConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if(params != null && params.length > 0){
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1, params[i]);
                }
            }
            ResultSet rt = ps.executeQuery();
            while (rt.next()) {                
                try {
                    // tao doi tuong tu surceType
                    T obj = sourceType.newInstance();
                    Field[] fields = obj.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        field.set(obj, rt.getObject(field.getName()));
                        
                    }
                    
                    data.add(obj);
                } catch (InstantiationException ex) {
                    Logger.getLogger(DateProvider.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(DateProvider.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DateProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return data;
        
        
    }
    
    public int executeUpdate(String sql, Object... params){
        Connection conn = ConnectDB.getJDBCConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            if(params != null && params.length > 0){
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1,params[i]);
                }
            }
            return ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DateProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
    }
    
}
