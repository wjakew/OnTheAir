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
import java.sql.SQLException;
import javazoom.jl.decoder.JavaLayerException;

/**
 *Main object of the program
 * @author jakubwawak
 */
public class OnTheAir {
    static String version = "v1.0.0B4";
    /**
     * Flag for debugging
     */
    static int debug = 0;
    
    /**
     * Main constructor
     * @param args
     * @throws IOException
     * @throws MalformedURLException
     * @throws JavaLayerException
     * @throws NoSuchAlgorithmException 
     */
    public static void main(String[] args) throws IOException, MalformedURLException, JavaLayerException, NoSuchAlgorithmException, SQLException, ClassNotFoundException {
        show_header();
        
        if ( debug ==  1 ){
            new Tests(version);   
        }
        else{
            new main_window(version);
        }
        
    }
    
    
    /**
     * Function for showing header
     */
    static void show_header(){
        String header = "  ___  _ __ | |_| |__   ___  __ _(_)_ __ \n" +
                        " / _ \\| '_ \\| __| '_ \\ / _ \\/ _` | | '__|\n" +
                        "| (_) | | | | |_| | | |  __/ (_| | | |   \n" +
                        " \\___/|_| |_|\\__|_| |_|\\___|\\__,_|_|_|\n";
        header = header+"by JAKUB WAWAK    2021   version "+version;
        System.out.println(header);
    }
    
}
