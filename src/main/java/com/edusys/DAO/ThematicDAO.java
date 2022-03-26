/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.DAO;

import com.edusys.entity.Thematic;
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
public class ThematicDAO extends EdusysDao<Thematic, String> {

    @Override
    public void insert(Thematic model) {
        String sql = "INSERT INTO Thematic (ThematicID, ThematicName, tuition, Times, Picture, ThematicDescription) VALUES (?,?,?,?,?,?)";
        jdbcHelper.update(sql, model.getThematicID()
                , model.getThematicName()
                , model.getTuition()
                , model.getTimes()
                , model.getPicture()
                , model.getThematicDescription());
    }

    @Override
    public void update(Thematic model) {
        String sql = "UPDATE Thematic SET ThematicName = ?, tuition = ?, Times = ?, Picture = ?, ThematicDescription = ? WHERE ThematicID = ?";
        jdbcHelper.update(sql   , model.getThematicName()
                                , model.getTuition()
                                , model.getTimes()
                                , model.getPicture()
                                , model.getThematicDescription()
                                , model.getThematicID());
    }

    @Override
    public void delete(Thematic model) {
        String sql = "DELETE Thematic WHERE ThematicID = ?";
        jdbcHelper.update(sql, model.getThematicID());
    }

    @Override
    public List<Thematic> selectAll() {
        String sql = "SELECT * FROM Thematic";
        return selectBySql(sql);
    }

    @Override
    public Thematic selectByID(String key) {
        String sql = "SELECT * FROM Thematic WHERE ThematicID = ?";
        List<Thematic> list = selectBySql(sql, key);
        return list.size()>0?list.get(0):null;
    }

    @Override
    protected List<Thematic> selectBySql(String SQL, Object... args) {
        List<Thematic> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.query(SQL, args);
                while(rs.next()) {
                    Thematic entity = new Thematic();
                    entity.setThematicID(rs.getString("ThematicID"));
                    entity.setThematicName(rs.getString("ThematicName"));
                    entity.setTuition(rs.getDouble("tuition"));
                    entity.setTimes(rs.getInt("times"));
                    entity.setThematicDescription(rs.getString("ThematicDescription"));
                    entity.setPicture(rs.getString("picture"));
                    list.add(entity);
                }
            } 
            finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
    
}
