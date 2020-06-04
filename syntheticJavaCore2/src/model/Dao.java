/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author minh
 */
public interface Dao<T, Tkey>{
    List<T> getAllShoes();
    List<T> where(Tkey id);
    T getId(Tkey id);
    T getShoesByName(String Name);
    void addShoes(T entity);
    void update(T entity);
    void delete(Tkey id);
}
