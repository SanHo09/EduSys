/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.entity;

import java.util.Date;



/**
 *
 * @author Sang
 */
public class Course {
    int     CourseID;
    String  ThematicID;
    double   Tuition;
    int     Times;	
    Date    OpenDay;
    String  CourseDescription;
    String  StaffID;
    Date    CreateDay;

    public int getCourseID() {
        return CourseID;
    }

    public String getThematicID() {
        return ThematicID;
    }

    public double getTuition() {
        return Tuition;
    }

    public int getTimes() {
        return Times;
    }

    public Date getOpenDay() {
        return OpenDay;
    }

    public String getCourseDescription() {
        return CourseDescription;
    }

    public String getStaffID() {
        return StaffID;
    }

    public Date getCreateDay() {
        return CreateDay;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public void setThematicID(String ThematicID) {
        this.ThematicID = ThematicID;
    }

    public void setTuition(double Tuition) {
        this.Tuition = Tuition;
    }

    public void setTimes(int Times) {
        this.Times = Times;
    }

    public void setOpenDay(Date OpenDay) {
        this.OpenDay = OpenDay;
    }

    public void setCourseDescription(String CourseDescription) {
        this.CourseDescription = CourseDescription;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public void setCreateDay(Date CreateDay) {
        this.CreateDay = CreateDay;
    }

    @Override
    public String toString() {
        return this.ThematicID +"   " +this.OpenDay;
    }

    
    
    
	
}
