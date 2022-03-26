/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Sang
 */
public class Ximage {
    public static Image getAppIcon() {
        URL url = Ximage.class.getResource("src\\main\\resources\\fpt.png");
        return new ImageIcon(url).getImage();
    }
    
    public static void save(File src) {
        File dst = new File("logos", src.getName());
        if(!dst.getParentFile().exists()) {
            dst.getParentFile().mkdir();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static ImageIcon read(String fileName, JLabel lblImage) {
        File path = new File("logos",fileName);
        ImageIcon myImage = new ImageIcon(path.getAbsolutePath());
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
}
