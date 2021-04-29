/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.radioplayer;

import java.util.ArrayList;
import org.apache.commons.validator.UrlValidator;

/**
 *Object for storing radiostations
 * @author x
 */

public class Boombox {
    
    private ArrayList<RadioStation> radio_list;
    public String picked;
    
    /**
     * Constructor
     */
    public Boombox(){
        radio_list = new ArrayList<>();
        radio_list.add(new RadioStation("Radio Nowy Swiat","https://stream.nowyswiat.online/mp3"));
        radio_list.add(new RadioStation("Radio LUZ","http://radioluz.pwr.edu.pl:8000/luzhifi.mp3"));
        picked = radio_list.get(0).radiostation_name;
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
                picked = title;
                return radio;
            }
        }
        return null;
    }
    
    /**
     * Function for checking for duplicate
     * @param radiostation
     * @return boolean
     */
    boolean check_for_duplicat(RadioStation radiostation){
        for( RadioStation rs : radio_list){
            if ( rs.compare(radiostation)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Function for adding new radio to the list
     * @param radio 
     */
    public boolean add_radio(RadioStation radio){
        if ( !check_for_duplicat(radio)){
            radio_list.add(radio);
            return true;
        }
        return false;
        
    }
    
    /**
     * Function for validation url
     * @param url
     * @return boolean
     */
    boolean validate_url(String url){
        String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        return urlValidator.isValid(url);
    }
    
}
