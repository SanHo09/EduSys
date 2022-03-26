/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.DAO;

import com.edusys.utils.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sang
 */
public class StatisticDAO {
    public List<Object[]> getMarkTable(Integer courseID) {
        String sql = "{CALL sp_MarkTable(?)}";
        String cols[] = {"LearnerID","Name","Mark"};
        return this.getListOfArray(sql,cols,courseID);
    }
    
    public List<Object[]> getNumberOfStudent() {
        String sql = "{CALL sp_Student_Statistical}";
        String[] cols = {"","LearnerNumber","FirstDate","LastDate"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> getThematicMark() {
        String sql = "{CALL sp_Mark_statistical}";
        String[] cols = {"Thematic","StudentNumber","Logest","Highest","Average"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> getRevenue(int year) {
        String sql = "{CALL sp_Tuition_Statistical(?)}";
        String[] cols = {"Thematic","CourseNumber","StudentNumber","Revenue","LowestTuition","HighestTuition","TuitionAverage"};
        return this.getListOfArray(sql, cols, year);
    }
    public List<Object[]>getListOfArray(String sql, String cols[],Object ...arg) {
        try {
            List<Object[]>list = new ArrayList<>();
            ResultSet rs = jdbcHelper.query(sql, arg);
            while(rs.next()) {
                Object[] vals = new Object[cols.length];
                for(int i=0;i<cols.length;i++) {
                    vals[i] = rs.getObject(cols[i]);  
                }
                list.add(vals);
            }
            rs.getStatement().close();
            return list;
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    
}
