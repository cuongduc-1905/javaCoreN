/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.warehouse;
import java.util.List;

/**
 *
 * @author minh
 */
public class wreaHousDao implements Dao<warehouse, Integer>{

    @Override
    public List<warehouse> getAll() {
        String sql = "select * from wareHoues";
        return DataProcedir.getInstance().excutQuery(sql, warehouse.class, null);
    }

    @Override
    public List<warehouse> where() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public warehouse getid(Integer id) {
        return getAll().stream().filter(x -> x.getId() == id).findFirst().get();
    }

    @Override
    public warehouse getName(String name) {
        return getAll().stream().filter(x -> x.getName().contains(name)).findFirst().get();
    }

    @Override
    public void insert(warehouse entity) {
        String sql = "insert into wareHoues values(?,?,?,?)";
        Object[] params = new Object[]{
            entity.getId(),
            entity.getName(),
            entity.getDate(),
            entity.getQyt()
        };
        DataProcedir.getInstance().execUpdate(sql, params);
        
    }

    @Override
    public void update(warehouse entity, Integer id) {
        try {
             warehouse w = getid(id);
            if(w.getId() == id){
            String sql = "insert into wareHoues values(?,?,?,?)";
            Object[] params = new Object[]{
            entity.getId(),
            entity.getName(),
            entity.getDate(),
            entity.getQyt()
            };
            DataProcedir.getInstance().execUpdate(sql, params);
        }else{
            System.out.println("not id ");
        }  
        } catch (Exception e) {
            System.out.println("retype");
        }
  
    }
    
    

    @Override
    public void delete(Integer id) {
        try {
            warehouse w = getid(id);
            if(w.getId() == id){
                String sql ="delete from wareHoues";
                DataProcedir.getInstance().execUpdate(sql, id);
            }
           
        } catch (Exception e) {
            System.out.println("not id");
        }
    }
    
}
