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
public interface Dao<T, Tkey> {
    List<T> getAll();
    T getid(Tkey id);
    T getName(String name);
    void insert(T entity);
    void update(T entity,Tkey id);
    void delete(Tkey id);
}
