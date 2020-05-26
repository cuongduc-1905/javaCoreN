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
public interface IDbHandler<T, TKey> {//generic
     List<T> getAll();
    List<T> where(Predicate<T> predicate);
    T get(TKey id);
    void insert(T entity);
    void update(T entity);
    void delete(TKey id);
    
}
