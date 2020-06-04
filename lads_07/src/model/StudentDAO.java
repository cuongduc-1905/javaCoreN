/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.student;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author minh
 */
public class StudentDAO implements IDvhandler<student, String>{
    private static StudentDAO instance = new StudentDAO();
    public static StudentDAO getInstance(){
        if (instance == null) {
            instance = new StudentDAO();
        }
        return instance;
    }
    
    
    @Override
    public List<student> getAll() {
        String sql = "select * from SinhVien";
        return DataProcider.getInstance().executeQuery(sql, student.class, null);
    }
    
    @Override
    public List<student> where(Predicate<student> predicate) {
        return getAll().stream().filter(predicate).collect(Collectors.toList());
    }
    
    @Override
    public student getEmail(String email) {
        return getAll().stream().filter(x -> x.getSV_email().equals(email)).findFirst().get();
    }
    
    @Override
    public student getName(String name) {
        return getAll().stream().filter(x -> x.getSV_name().contains(name)).findFirst().get();
    }

    @Override
    public void insert(student entity) {
        String sql = "INSERT INTO SinhVien VALUES(?,?,?,?,?,?)";
        Object[] params = new Object[] {
            entity.getId(),
            entity.getMa_sv(), 
            entity.getSV_name(), 
            entity.getSV_address(), 
            entity.getSV_phone(),
            entity.getSV_email()
        };
        DataProcider.getInstance().excuteUpdate(sql, params);
    }

    @Override
    public void update(student entity) {
        String sql = "UPDATE SinhVien SET Sv_name = ?, Sv_address = ?, Sv_phone = ?, Sv_email = ?  WHERE getMa_sv = ?";
        Object[] params = new Object[] {
            
            entity.getSV_name(), 
            entity.getSV_address(), 
            entity.getSV_phone(),
            entity.getSV_email(),
            entity.getMa_sv()
        };
        DataProcider.getInstance().excuteUpdate(sql, params);
    }

    @Override
    public void delete(String id) {
        String sql ="DELETE FROM SinhVien WHERE id = ?";
        DataProcider.getInstance().excuteUpdate(sql, id);
    }

    @Override
    public student getId(Integer id) {
        return getAll().stream().filter(x -> x.getId() == id).findFirst().get();
    }

    

}
