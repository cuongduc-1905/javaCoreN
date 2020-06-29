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
import util.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
   public <T> List <T> execuQuery(String sql, Class<T>suorType, Object... params){
       List<T> data = new ArrayList<>();
       Connection conn = ConnectionDB.getJDBC();
       try {
           PreparedStatement ps = conn.prepareStatement(sql);
            if(params != null && params.length > 0){
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {               
               T ojb = suorType.newInstance();
               Field[] field = ojb.getClass().getDeclaredFields();
               for (Field fs : field) {
                   fs.setAccessible(true);
                   
                   fs.set(ojb, rs.getObject(fs.getName()));
               }
               data.add(ojb);
               
           }
           
           
       } catch (Exception ex) {
           Logger.getLogger(DataProcider.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return data;
 
   }
   public int execuUpdate(String sql,Object... params){
       Connection conn = ConnectionDB.getJDBC();
       try {
           PreparedStatement ps = conn.prepareStatement(sql);
           if(params.length > 0 && params != null){
               for (int i = 0; i < params.length; i++) {
                   ps.setObject(i + 1, params[i]);
               }
           }
           return ps.executeUpdate();
           
       } catch (Exception ex) {
           Logger.getLogger(DataProcider.class.getName()).log(Level.SEVERE, null, ex);
       }
       return 0;
       
   }
   
    
}
