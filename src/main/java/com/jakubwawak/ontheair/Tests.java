/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.ontheair;

import com.jakubwawak.gui.information_window;
import com.jakubwawak.gui.main_window;
import com.jakubwawak.gui.main_window2;
import com.jakubwawak.gui.radiolist_window;
import com.jakubwawak.radioplayer.Boombox;
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
        Boombox b = new Boombox();
        new radiolist_window(null,true,b);
    }
    
}
