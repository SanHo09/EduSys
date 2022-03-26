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
public class Learner {
    String  LearnerID;
    String  Name;
    Date    Birth;
    Boolean Gender;
    String  PhoneNumber;
    String  Email;
    String  LearnerDescription;
    String  StaffID;
    Date    RegistDate;
    String  Picture;
    String  academicLevel;

    public String getLearnerID() {
        return LearnerID;
    }

    public String getName() {
        return Name;
    }

    public Date getBirth() {
        return Birth;
    }

    public Boolean getGender() {
        return Gender;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public String getLearnerDescription() {
        return LearnerDescription;
    }

    public String getStaffID() {
        return StaffID;
    }

    public Date getRegistDate() {
        return RegistDate;
    }

    public String getPicture() {
        return Picture;
    }

    public void setLearnerID(String LearnerID) {
        this.LearnerID = LearnerID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setBirth(Date Birth) {
        this.Birth = Birth;
    }

    public void setGender(Boolean Gender) {
        this.Gender = Gender;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setLearnerDescription(String LearnerDescription) {
        this.LearnerDescription = LearnerDescription;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public void setRegistDate(Date RegistDate) {
        this.RegistDate = RegistDate;
    }

    public void setPicture(String Picture) {
        this.Picture = Picture;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }
    
    
	
    
}
