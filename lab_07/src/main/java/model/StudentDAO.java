/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.student;
import java.util.List;
import main_program.DataProcider;

/**
 *
 * @author minh
 */
public class StudentDAO implements IDvhandler<student, Integer>{
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
    public student getId(Integer id) {
        return getAll().stream().filter(x -> x.getId() == id).findFirst().get();
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
        String sql = "UPDATE SinhVien SET Ma_sv= ? , Sv_name = ?, Sv_address = ?, Sv_phone = ?, Sv_email = ?  WHERE id = ?";
        Object[] params = new Object[] {
            entity.getMa_sv(), 
            entity.getSV_name(), 
            entity.getSV_address(), 
            entity.getSV_phone(),
            entity.getSV_email(),
            entity.getId()
        };
        DataProcider.getInstance().excuteUpdate(sql, params);
    }

    @Override
    public void delete(Integer id) {
        String sql ="DELETE FROM SinhVien WHERE id = ?";
        DataProcider.getInstance().excuteUpdate(sql, id);
    }

    
    
}
