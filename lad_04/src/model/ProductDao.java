/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import entity.Product;
import java.util.List;
import java.util.function.Predicate;
import java.sql.PreparedStatement;
import static javax.swing.UIManager.get;
import uitl.connectDB;

/**
 *
 * @author minh
 */
public class ProductDao implements Dao<Product, Integer>{

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM `product`";
        return dataProcider.getInstance().executeQuery(sql, Product.class, null);
    }

    @Override
    public List<Product> where(Integer id) {
        return null;
    }

    @Override
    public Product getId(Integer id) {
        return getAll().stream().filter(x -> x.getId() == id).findFirst().get();
    }
    
     @Override
    public Product getName(String name) {
        return getAll().stream().filter(x -> x.getName().contains(name)).findFirst().get();
    }

    @Override
    public void add(Product entity) {
        String sql ="INSERT INTO product VALUES(?,?,?,?,?,?)";
        Object[] params = new Object[]{
          entity.getId(),
          entity.getName(),
          entity.getProducer(),
          entity.getQty(),
          entity.getPrice(),
          entity.getVAT()
        };
        dataProcider.getInstance().executeUpdate(sql, params);
    }

    @Override
    public void export(Product entity, Integer id, Integer qty) {
        Product p = getId(id);
        if(p.getQty() > qty){
            String sql = "UPDATE product SET qty = qty - ? WHERE id = ?";//qty = qty -?
        Object[] params = new Object[] {
            entity.getQty(),
            entity.getId()
        };
        dataProcider.getInstance().executeUpdate(sql, params);
        }else{
            System.out.println("khong du hang de xuat ban nhap nho hon");
        }
        
    }

    @Override
    public void update(Product entity) {
        String sql = "UPDATE `product` SET `name`= ?,`produces`= ?,`qty`= ?,`price`= ?,`Vat`= ? WHERE id =?";
        Object[] params = new Object[] {
            
            entity.getName(), 
            entity.getProducer(), 
            entity.getQty(),
            entity.getPrice(),
            entity.getVAT(),
            entity.getId()
        };
        dataProcider.getInstance().executeUpdate(sql, params);
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from product";
        dataProcider.getInstance().executeUpdate(sql, id);
    }

   

    
    
}
