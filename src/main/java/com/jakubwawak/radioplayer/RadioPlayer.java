/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.radioplayer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *Object for loading stream data
 * @author jakubwawak
 */
public class RadioPlayer {
    
    String current_url;
    boolean playing;
    URLConnection urlConnection;
    Player main_player;
    
    /**
     * Constructor
     * @param url 
     */
    public RadioPlayer(String url){
        current_url = url;
        playing = false;
    }
    
    /**
     * Constructor using RadioStation object
     * @param object 
     */
    public RadioPlayer(RadioStation radio){
        current_url = radio.radiostation_url;
        playing = false;
    }
    
    /**
     * Main function for playing radio data
     * @throws MalformedURLException
     * @throws IOException
     * @throws JavaLayerException 
     */
    public void play() throws MalformedURLException, IOException, JavaLayerException{
        
        try{
            urlConnection = new URL(current_url).openConnection ();
            
            urlConnection.connect();
  
            main_player = new Player (urlConnection.getInputStream());
            
            main_player.play();
        }catch(Exception e){
            System.out.println("Failed to play ("+e.toString()+")");
        }
    }
    /**
     * Function for stoping stream
     */
    public void stop(){
        try{
            main_player.close();
        
        }catch(Exception e){
            System.out.println("Failed to stop: ("+e.toString()+")");
        }
    }
    
    
}
