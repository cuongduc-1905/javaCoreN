/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Computer;
import java.util.List;

/**
 *
 * @author minh
 */
public class ComputerDao implements Daos<Computer, Integer>{

    @Override
    public List<Computer> getAll() {
        String sql = "SELECT * FROM `Comouter`";
        return Procider.getInstance().execuQuery(sql, Computer.class, null);
    }

    @Override
    public Computer getId(Integer id) {
        return getAll().stream().filter(x -> x.getId() == id).findFirst().get();
    }

    @Override
    public Computer getName(String Name) {
        return getAll().stream().filter(x -> x.getName().contains(Name)).findFirst().get();
    }

    @Override
    public void insert(Computer entity) {
        String sql = "insert into Comouter value(?,?,?,?)";
        Object[] params = new Object[]{
            entity.getId(),
            entity.getName(),
            entity.getPrice(),
            entity.getYear()
        };
        Procider.getInstance().excuUpdate(sql, params);
    }

    @Override
    public void update(Computer entity, Integer id) {
        try {
            Computer cm = getId(id);
            if(cm.getId() == id){
            String sql = "update Comouter set Price = ?, qty = ? where Id = ? ";
            Object[] params = new Object[]{
                entity.getPrice(),
                entity.getQty(),
                entity.getId()
            };
            Procider.getInstance().excuUpdate(sql, params);
        }
        } catch (Exception e) {
            System.out.println("id khong dung hoac kg co");
        }
        
        
    }

    @Override
    public void delete(Integer id) {
        try {
            Computer cm = getId(id);
        
        if(cm.getId() == id){
           String sql = "delete from Comouter where Id = ?";
           Procider.getInstance().excuUpdate(sql, id);
        }
        } catch (Exception e) {
            System.out.println("id kh dung hoac kg co");
        }
    }

    @Override
    public void export(Computer entity, Integer id, Integer qty) {
        try {
            Computer c = getId(id);
        if(c.getQty() > qty){
            String sql = "update Comouter set qty = qty - ? where Id = ?";
            Object[] params = new Object[]{
                entity.getQty(),
                entity.getId()
            };
            Procider.getInstance().excuUpdate(sql, params);
            System.out.println("succsesfully");
        }else{
            System.out.println("so luong kg du");
        }
        } catch (Exception e) {
            System.out.println("sai id");
        } 
    }
    
}
