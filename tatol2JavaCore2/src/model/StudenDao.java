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
public class StudenDao implements Dao<Student, Integer>{

    @Override
    public List<Student> getAll() {
       String sql = "select * from hocSinh";
       return DataProceder.getInstance().excuQuery(sql, Student.class, null);
    }

    @Override
    public Student getid(Integer id) {
        return getAll().stream().filter(x -> x.getId() == id).findFirst().get();
    }

    @Override
    public Student getName(String name) {
        return getAll().stream().filter(x -> x.getName().contains(name)).findFirst().get();
    }

    @Override
    public void insert(Student entity) {
        String sql = "insert into hocSinh values(?,?,?,?)";
        Object[] params = new Object[]{
            entity.getId(),
            entity.getName(),
            entity.getClasss(),
            entity.getAge()
        };
        DataProceder.getInstance().excuUpdate(sql, params);
    }

    @Override
    public void update(Student entity, Integer id) {
        Student s = getid(id);
        if(s.getId() == id){
            String sql = "update hocSinh set name = ? ,age= ? where id = ?";
            Object[] params = new Object[]{
            entity.getName(),
            entity.getAge(),
            entity.getId()
            };
            DataProceder.getInstance().excuUpdate(sql, params);
        } 
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete hocSinh where id = ?";
        DataProceder.getInstance().excuUpdate(sql, id);
    }
}
    