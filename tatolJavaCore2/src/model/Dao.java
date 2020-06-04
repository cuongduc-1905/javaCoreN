/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author minh
 */
public interface Dao<T, key> {
    List<T> getAll();
    List<T> where(key id);
    T getId(key id);
    T getName(key name);
    void insert(T entity);
    void update(T entity);
    void delete(key id);
    
}
