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
import until.ConnectDBs;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author minh
 */
public class Procider {
    private static Procider instance = new Procider();
    
    private Procider(){
        
    }
    public static Procider getInstance(){
        if(instance == null){
            instance = new Procider();
        }
        return instance;
    }
    
    public <T> List<T> execuQuery(String sql, Class<T>sourtType, Object... params){
        List<T> data = new ArrayList<>();
        Connection conn = ConnectDBs.getJDBCconnect();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if(params != null && params.length > 0){
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1, params[i]);
                }
            }
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {                    
                    T obj = sourtType.newInstance();
                    
                    Field[] field = obj.getClass().getDeclaredFields();
                    for (Field fs : field) {
                        fs.setAccessible(true);
                        
                        fs.set(obj, rs.getObject(fs.getName()));
                    }
                    data.add(obj);
                    
                }
        
        } catch (Exception ex) {
            Logger.getLogger(Procider.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return data;
    }
    public int excuUpdate(String sql,Object... params){
        Connection conn = ConnectDBs.getJDBCconnect();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if(params != null && params.length > 0){
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1, params[i]);
                }
            }
            return ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Procider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    
}
