/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.ontheair;

import com.jakubwawak.radioplayer.RadioPlayer;
import java.io.IOException;
import java.net.MalformedURLException;
import javazoom.jl.decoder.JavaLayerException;

/**
 *Object created for testing
 * @author jakubwawak
 */
public class Tests {
    
    Tests() throws IOException, MalformedURLException, JavaLayerException{
        
        RadioPlayer rp = new RadioPlayer("https://stream.nowyswiat.online/mp3");
        
        rp.play();
        
        
    }
    
}
