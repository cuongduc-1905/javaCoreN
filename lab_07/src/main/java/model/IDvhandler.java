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
public interface IDvhandler<T, Tkey>{
    List<T> getAll();
    T getId(Tkey id);
    void insert(T entity);
    void update(T entity);
    void delete(Tkey id);
}
