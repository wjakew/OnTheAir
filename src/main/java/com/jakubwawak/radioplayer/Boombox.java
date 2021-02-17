/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.radioplayer;

import java.util.ArrayList;

/**
 *Object for storing radiostations
 * @author x
 */
public class Boombox {
    
    private ArrayList<RadioStation> radio_list;
    
    /**
     * Constructor
     */
    public Boombox(){
        radio_list = new ArrayList<>();
        radio_list.add(new RadioStation("Radio Nowy Świat","https://stream.nowyswiat.online/mp3"));
        radio_list.add(new RadioStation("Radio LUZ","http://radioluz.pwr.edu.pl:8000/luzhifi.mp3"));
    }
    
    /**
     * Function for getting list of radiostations
     * @return ArrayList<>
     */
    public ArrayList<String> list_of_names(){
        ArrayList<String> data = new ArrayList<>();
        for(RadioStation radio : radio_list){
            data.add(radio.radiostation_name);
        }
        return data;
    }
    
    /**
     * Function for getting url from RadioStation with given name
     * @param title
     * @return 
     */
    public String get_url(String title){
        for(RadioStation radio : radio_list){
            if ( radio.radiostation_name.equals(title) ){
                return radio.radiostation_url;
            }
        }
        return null;
    }
    
    /**
     * Function for getting selected RadioStation object
     * @param title
     * @return RadioStation
     */
    public RadioStation get_radio(String title){
        for(RadioStation radio : radio_list){
            if ( radio.radiostation_name.equals(title) ){
                return radio;
            }
        }
        return null;
    }
    
}
