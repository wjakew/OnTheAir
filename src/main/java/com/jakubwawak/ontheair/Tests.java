/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.ontheair;

import com.jakubwawak.gui.information_window;
import com.jakubwawak.gui.main_window;
import com.jakubwawak.gui.main_window2;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javazoom.jl.decoder.JavaLayerException;

/**
 *Object created for testing
 * @author jakubwawak
 */
public class Tests {
    
    
    
    Tests(String version) throws IOException, MalformedURLException, JavaLayerException, NoSuchAlgorithmException, SQLException, ClassNotFoundException{
        System.out.println("Test object invoked...");
        Database database = new Database();
        database.connect("localhost","ontheair_database","root","password");
        
        new information_window(null,true,database,"X.X.XXX");
        
    }
    
}
