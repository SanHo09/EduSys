/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.DAO;

import com.edusys.entity.Staff;
import com.edusys.utils.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sang
 */
public class StaffDAO extends EdusysDao<Staff, String> {

    @Override
    public void insert(Staff model) {
        String sql = "INSERT INTO Staff (StaffID, StaffPassword, StaffName, StaffRole, StaffEmail ) VALUES (?,?,?,?,?)";
        jdbcHelper.update(sql, model.getStaffID(), model.getStaffPassword(),model.getStaffName(), model.getStaffRole(), model.getStaffEmail());
        
    }

    @Override
    public void update(Staff model) {
        String sql = "UPDATE Staff SET StaffPassword = ?, StaffName = ?, StaffRole = ?, StaffEmail = ? WHERE StaffID = ?";
        jdbcHelper.update(sql, model.getStaffPassword(),model.getStaffName(), model.getStaffRole(), model.getStaffEmail(), model.getStaffID());
    }

    @Override
    public void delete(Staff model) {
        String sql = "DELETE FROM Staff Where StaffID = ?";
        jdbcHelper.update(sql, model.getStaffID());
    }

    @Override
    public List<Staff> selectAll() {
        String sql = "Select * FROM Staff ";
        return selectBySql(sql);
    }

    @Override
    public Staff selectByID(String StaffID) {
        String sql="SELECT * FROM Staff WHERE StaffID=?";
        List<Staff> list = selectBySql(sql, StaffID);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Staff> selectBySql(String sql, Object... args) {
        List<Staff> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.query(sql, args);
                while(rs.next()){
                    Staff entity = new Staff();
                    entity.setStaffID(rs.getString("StaffID"));
                    entity.setStaffPassword(rs.getString("StaffPassword"));
                    entity.setStaffName(rs.getString("StaffName"));
                    entity.setStaffRole(rs.getBoolean("StaffRole"));
                    entity.setStaffEmail(rs.getString("StaffEmail"));
                    list.add(entity);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
    
}
