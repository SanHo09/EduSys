/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.DAO;

import com.edusys.entity.Student;
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
public class StudentDAO extends EdusysDao<Student, String> {

    @Override
    public void insert(Student model) {
        String sql = "INSERT INTO Student (LearnerID, CourseID, Mark) VALUES (?,?,?)";
        jdbcHelper.update(sql, model.getLearnerID()
                , model.getCourseID()
                , model.getMark());
    }

    @Override
    public void update(Student model) {
        String sql = "UPDATE Student SET LearnerID = ?, CourseID = ?, Mark = ? WHERE StudentID = ?";
        jdbcHelper.update(sql, model.getLearnerID()
                             , model.getCourseID()
                             , model.getMark()
                             , model.getStudentID());
    }

    @Override
    public void delete(Student model) {
        String sql = " DELETE Student WHERE StudentID = ?";
        jdbcHelper.update(sql, model.getStudentID());
    }

    @Override
    public List<Student> selectAll() {
        String sql = "SELECT * FROM Student";
        return selectBySql(sql);
    }

    @Override
    public Student selectByID(String StudentID) {
        String sql = "SELECT * FROM Student WHERE StudentID = ?";
        List<Student> list = selectBySql(sql, StudentID);
        return list.size()>0?list.get(0):null;
    }

    @Override
    protected List<Student> selectBySql(String SQL, Object... args) {
        List<Student> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.query(SQL, args);
                while(rs.next()) {
                    Student entity = new Student();
                    entity.setStudentID(rs.getInt("StudentID"));
                    entity.setLearnerID(rs.getString("LearnerID"));
                    entity.setCourseID(rs.getInt("CourseID"));
                    entity.setMark(rs.getDouble("Mark"));
                    list.add(entity);
                }
            } 
            finally {
                rs.getStatement().getConnection().close();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
    public List<Student> selectByCourse(int courseID) {
        String sql = "SELECT * FROM Student WHERE CourseID = ?";
        return this.selectBySql(sql, courseID);
    }
    
}
