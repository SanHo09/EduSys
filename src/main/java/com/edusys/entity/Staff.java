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
public class Staff {
    String  StaffID;
    String  StaffPassword;
    String  StaffName;
    Boolean StaffRole;
    String  StaffEmail;

    public String getStaffID() {
        return StaffID;
    }

    public String getStaffPassword() {
        return StaffPassword;
    }

    public String getStaffName() {
        return StaffName;
    }

    public Boolean getStaffRole() {
        return StaffRole;
    }

    public String getStaffEmail() {
        return StaffEmail;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public void setStaffPassword(String StaffPassword) {
        this.StaffPassword = StaffPassword;
    }

    public void setStaffName(String StaffName) {
        this.StaffName = StaffName;
    }

    public void setStaffRole(Boolean StaffRole) {
        this.StaffRole = StaffRole;
    }

    public void setStaffEmail(String StaffEmail) {
        this.StaffEmail = StaffEmail;
    }
    
}
