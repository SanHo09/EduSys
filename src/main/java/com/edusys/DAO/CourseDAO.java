/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.DAO;

import com.edusys.entity.Course;
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
public class CourseDAO extends EdusysDao<Course, String>{

    @Override
    public void insert(Course model) {
        String sql  = "INSERT INTO Course(ThematicID, Tuition, Times, OpenDay, CourseDescription, StaffID, CreateDay) VALUES(?,?,?,?,?,?,?)";
        jdbcHelper.update(sql, model.getThematicID()
                , model.getTuition()
                , model.getTimes()
                , model.getOpenDay()
                , model.getCourseDescription()
                , model.getStaffID()
                , model.getCreateDay());
             
    }

    @Override
    public void update(Course model) {
        String sql = "UPDATE Course SET ThematicID = ?, Tuition = ?, Times = ?, OpenDay = ?, CourseDescription = ?, StaffID = ?, CreateDay = ? WHERE CourseID = ?";
        jdbcHelper.update(sql, model.getThematicID()
                            , model.getTuition()
                            , model.getTimes()
                            , model.getOpenDay()
                            , model.getCourseDescription()
                            , model.getStaffID()
                            , model.getCreateDay()
                            , model.getCourseID());
    }

    @Override
    public void delete(Course model) {
        String sql = "DELETE Course WHERE CourseID = ?";
        jdbcHelper.update(sql, model.getCourseID());
    }

    @Override
    public List<Course> selectAll() {
        String sql = "Select * FROM Course ";
        return selectBySql(sql);
    }

    @Override
    public Course selectByID(String CourseID) {
        String sql="SELECT * FROM Course WHERE CourseID=?";
        List<Course> list = selectBySql(sql, CourseID);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Course> selectBySql(String SQL, Object... args) {
        List<Course> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.query(SQL, args);
                while(rs.next()){
                    Course entity = new Course();
                    entity.setCourseID(rs.getInt("CourseID"));
                    entity.setThematicID(rs.getString("ThematicID"));
                    entity.setTuition(rs.getDouble("Tuition"));
                    entity.setTimes(rs.getInt("Times"));
                    entity.setOpenDay(rs.getDate("OpenDay"));
                    entity.setCourseDescription(rs.getString("CourseDescription"));
                    entity.setStaffID(rs.getString("StaffID"));
                    entity.setCreateDay(rs.getDate("CreateDay"));
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
    
    public List<Course> selectByThematic(String thematicID) {
        String sql = "SELECT * FROM Course WHERE ThematicID = ?";
        return this.selectBySql(sql, thematicID);
    }
    
     public List<Integer> selectYears() {
         String sql = "SELECT DISTINCT year(OpenDay) FROM Course ORDER BY year(OpenDay) DESC";
         List <Integer> list = new ArrayList<>();
         try {
             ResultSet rs = jdbcHelper.query(sql);
             while(rs.next()) {
                 list.add(rs.getInt(1));
             }
             rs.getStatement().getConnection().close();;
             return list;
         } catch (Exception ex) {
             throw new RuntimeException(ex);
         }
     }
    
    
}
