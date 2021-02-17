/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.ontheair;

import com.jakubwawak.gui.main_window;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.NoSuchAlgorithmException;
import javazoom.jl.decoder.JavaLayerException;

/**
 *Object created for testing
 * @author jakubwawak
 */
public class Tests {
    
    Tests() throws IOException, MalformedURLException, JavaLayerException, NoSuchAlgorithmException{
        
        new main_window();
    }
    
}
