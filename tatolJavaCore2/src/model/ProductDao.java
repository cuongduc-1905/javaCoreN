/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Product;
import java.util.List;

/**
 *
 * @author minh
 */
public class ProductDao implements Dao<Product, Integer>{

    @Override
    public List<Product> getAll() {
        String sql = "select * from productt";
        return DataProcider.getInstance().executeQuery(sql, Product.class, null);
    }

    @Override
    public List<Product> where(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getId(Integer id) {
        return getAll().stream().filter(x -> x.getId() == id).findFirst().get();
    }

    @Override
    public Product getName(Integer name) {
        return getAll().stream().filter(x -> x.getName().equals(name)).findFirst().get();
    }

    @Override
    public void insert(Product entity) {
        String sql = "INSERT INTO `product` VALUES(?,?,?,?,?)";
        Object[] param = new Object[]{
            entity.getId(),
            entity.getName(),
            entity.getCategory(),
            entity.getDateStrart(),
            entity.getDateEnd()
        };
        DataProcider.getInstance().excuteUpdate(sql, param);
    }

    @Override
    public void update(Product entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
