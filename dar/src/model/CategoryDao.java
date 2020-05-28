/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Main_program.DateProvider;
import entities.Category;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author minh
 */
public class CategoryDao implements IDbHandler<Category, Integer>{
    private static CategoryDao instance = new CategoryDao();
    private CategoryDao(){
        
    }
    public static CategoryDao getInstance(){
        if (instance == null) {
            instance = new CategoryDao();
        }
        return instance;
    }

    @Override
    public List<Category> getAll() {
        String sql = "select * from category";
        return DateProvider.getinstance().executeQuery(sql, Category.class, null);
  
    }

    @Override
    public List<Category> where(Predicate<Category> predicate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category get(Integer id) {
        return getAll().stream().filter(x -> x.getId() == id).findFirst().get();
    }

    @Override
    public void insert(Category entity) {
       String sql = "insert into ";
    }

    @Override
    public void update(Category entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    

    
    

    
    
}
