/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.*;
/**
 *
 * @author Sang
 */
public class HeaderColor extends DefaultTableCellRenderer{
       public HeaderColor() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            setForeground(Color.white);
            setFont(new Font("Segoe UI",Font.BOLD,14));
            setBackground(new java.awt.Color(44,40,39));
            
            return this;
        }

}

