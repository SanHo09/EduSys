/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.DAO;

import com.edusys.entity.Learner;
import com.edusys.utils.XDate;
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
public class LearnerDAO extends EdusysDao<Learner, String>{

    @Override
    public void insert(Learner model) {
        String sql = "INSERT INTO Learner(LearnerID, Name, Birth, Gender, PhoneNumber, Email, LearnerDescription, StaffID, RegistDate, Picture, AcademicLevel) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        jdbcHelper.update(sql, model.getLearnerID()
                , model.getName()
                , model.getBirth()
                , model.getGender()
                , model.getPhoneNumber()
                , model.getEmail()
                , model.getLearnerDescription()
                , model.getStaffID()
                , model.getRegistDate()
                , model.getPicture()
                , model.getAcademicLevel());
                
                                
    }

    @Override
    public void update(Learner model) {
        String sql = "UPDATE Learner SET Name=?, Birth=?, Gender =?, PhoneNumber=?, Email=?, LearnerDescription=?, StaffID=?, RegistDate=?, Picture=?, AcademicLevel=? WHERE LearnerID = ?";
        jdbcHelper.update(sql, model.getName()
                             , model.getBirth()
                             , model.getGender()
                             , model.getPhoneNumber()
                             , model.getEmail()
                             , model.getLearnerDescription()
                             , model.getStaffID()
                             , model.getRegistDate()
                             , model.getPicture()
                             , model.getAcademicLevel()
                             , model.getLearnerID());
                             
    }

    @Override
    public void delete(Learner model) {
        String sql = "DELETE Learner WHERE LearnerID = ?";
        jdbcHelper.update(sql, model.getLearnerID());
    }

    @Override
    public List<Learner> selectAll() {
        String sql = "SELECT * FROM Learner";
        return selectBySql(sql);
    }

    @Override
    public Learner selectByID(String LearnerID) {
        String sql = "SELECT * FROM Learner WHERE LearnerID = ?";
        List<Learner> list = selectBySql(sql, LearnerID);
        return list.size()>0?list.get(0):null;
    }

    @Override
    protected List<Learner> selectBySql(String SQL, Object... args) {
        List<Learner> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.query(SQL, args);
                while(rs.next()){
                    Learner entity = new Learner();
                    entity.setLearnerID(rs.getString("LearnerID"));
                    entity.setName(rs.getString("Name"));
                    entity.setBirth(rs.getDate("Birth"));
                    entity.setGender(rs.getBoolean("Gender"));
                    entity.setPhoneNumber(rs.getString("PhoneNumber"));
                    entity.setEmail(rs.getString("Email"));
                    entity.setLearnerDescription(rs.getString("LearnerDescription"));
                    entity.setStaffID(rs.getString("StaffID"));
                    entity.setRegistDate(rs.getDate("RegistDate"));
                    entity.setAcademicLevel(rs.getString("AcademicLevel"));
                    entity.setPicture(rs.getString("Picture"));
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
    
    public List<Learner> selectNotInCourse(int CourseID, String learnerName) {
        String sql = "SELECT * FROM Learner "
                + "WHERE Name LIKE ?  "
                + "AND LearnerID NOT IN (SELECT LearnerID FROM Student WHERE CourseID = ?) ";
        return this.selectBySql(sql,"%"+learnerName+"%", CourseID);
                        
    }
    
    
}
