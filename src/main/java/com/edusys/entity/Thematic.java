/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.entity;

/**
 *
 * @author Sang
 */
public class Thematic {
    String ThematicID;
    String ThematicName;
    double tuition;
    int Times;
    String Picture;
    String ThematicDescription;

    public String getThematicID() {
        return ThematicID;
    }

    public String getThematicName() {
        return ThematicName;
    }

    public double getTuition() {
        return tuition;
    }

    public int getTimes() {
        return Times;
    }

    public String getPicture() {
        return Picture;
    }

    public String getThematicDescription() {
        return ThematicDescription;
    }

    public void setThematicID(String ThematicID) {
        this.ThematicID = ThematicID;
    }

    public void setThematicName(String ThematicName) {
        this.ThematicName = ThematicName;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public void setTimes(int Times) {
        this.Times = Times;
    }

    public void setPicture(String Picture) {
        this.Picture = Picture;
    }

    public void setThematicDescription(String ThematicDescription) {
        this.ThematicDescription = ThematicDescription;
    }

    @Override
    public String toString() {
        return this.ThematicName; 
    }

    @Override
    public boolean equals(Object obj) {
        Thematic other = (Thematic)obj;
        return other.getThematicID().equals(this.getThematicID());
    }

    
    
    
    
    
    
    
    
}
