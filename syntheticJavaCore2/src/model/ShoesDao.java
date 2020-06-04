/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Shoes;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author minh
 */
public class ShoesDao implements Dao<Shoes, Integer>{
    
    @Override
    public List<Shoes> getAllShoes() {
        String sql = "select * from Shoes";
        return DataProcider.getInstance().excuteQuery(sql, Shoes.class, null);
    }

    @Override
    public List<Shoes> where(Integer id) {
       String sql = "select * from Shoes where id = ?";
       return DataProcider.getInstance().excuteQuery(sql, Shoes.class, id);
    }

    @Override
    public Shoes getId(Integer id) {
        return getAllShoes().stream().filter(x -> x.getId() == id).findAny().get();
        
    }

    @Override
    public Shoes getShoesByName(String Name) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addShoes(Shoes entity) {
        String sql = "insert into Shoes values(?,?,?,?,?)";
        Object[] param = new Object[]{
          entity.getId(),
          entity.getName(),
          entity.getPrice(),
          entity.getYear(),
          entity.getDesciption()
        };
       DataProcider.getInstance().excuteUpdate(sql, param);
    }

    @Override
    public void update(Shoes entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM `Shoes` WHERE id = ?";
      DataProcider.getInstance().excuteUpdate(sql, id);
    }
    
}
