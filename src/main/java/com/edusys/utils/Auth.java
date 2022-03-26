/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.utils;

import com.edusys.entity.Staff;

/**
 *
 * @author Sang
 */
public class Auth {
    public static Staff user = null;
    public static void clear() {
        Auth.user = null;
    }
    public static boolean islogin() {
        return Auth.user!=null;
    }
    public static boolean isManager() {
        return Auth.islogin() && user.getStaffRole();
    }
}
