/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Student;
import java.util.List;

/**
 *
 * @author minh
 */
public class StudentDao implements Dao<Student, Integer>{

    @Override
    public List<Student> getAll() {
        String sql = "select * from test";
        return DataProcider.getInstance().execuQuery(sql, Student.class, null);
    }

    @Override
    public Student getId(Integer id) {
        return getAll().stream().filter(x -> x.getId() == id).findFirst().get();
    }

    @Override
    public Student getName(String name) {
        return getAll().stream().filter(x ->x.getName().contains(name)).findFirst().get();
    }

    @Override
    public void insert(Student entity) {
        String slq = "insert into test values(?,?,?,?)";
        Object[] params = new Object[]{
            entity.getId(),
            entity.getName(),
            entity.getAge(),
            entity.getClassS()
        };
        DataProcider.getInstance().execuUpdate(slq, params);
    }

    @Override
    public void update(Student entity, Integer id) {
        
        try {
            Student s = (Student) getAll();
            if(s.getId() == id){
                String sql = "update test set name = ? , Age = ? , ClassS = ? where Id = ?";
                Object[] params = new Object[]{
            
                entity.getName(),
                entity.getAge(),
                entity.getClassS(),
                entity.getId()
            };
            DataProcider.getInstance().execuUpdate(sql, params);
            }
        } catch (Exception e) {
            System.out.println("ban nhap sai id");
        }
         
    }

    @Override
    public void delete(Integer id) {
        try {
            Student s = (Student) getAll();
            if(s.getId() == id){    
                String sql = "delete from test where Id = ?";
                DataProcider.getInstance().execuUpdate(sql, id);
            }
        } catch (Exception e) {
            System.out.println("ban nhap sai id");
            
        }
       
    }
}
