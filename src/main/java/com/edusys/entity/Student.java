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
public class Student {
    int     StudentID;
    String  LearnerID;
    int     CourseID;
    double   Mark;

    public int getStudentID() {
        return StudentID;
    }

    public String getLearnerID() {
        return LearnerID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public double getMark() {
        return Mark;
    }


    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public void setLearnerID(String LearnerID) {
        this.LearnerID = LearnerID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public void setMark(double Mark) {
        this.Mark = Mark;
    }


    
}
