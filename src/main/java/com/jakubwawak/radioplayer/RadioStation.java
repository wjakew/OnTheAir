/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.radioplayer;

import java.util.ArrayList;

/**
 *Object for storing presets
 * @author x
 */
public class RadioStation {
    
    String radiostation_name;
    String radiostation_url;
    int radiostation_id;
    int playlist_id;
    String radiostation_desc;
    
    /**
     * Constructor
     * @param preset_name
     * @param url 
     */
    RadioStation(String preset_name,String url){
        this.radiostation_name = preset_name;
        this.radiostation_url = url;
        
        playlist_id = -1;
        radiostation_desc = "";
        radiostation_id = -1;
    }
    
    
    /**
     * Function for setting description
     * @param description 
     */
    void set_radiostation_desc(String description){
        radiostation_desc = description;
    }
    
    /**
     * Function for showing data from object
     * @return String
     */
    public String show_data(){
        String data = radiostation_name +"\n";
        
        data = data + "url: "+radiostation_url +"\n";
        
        data = data + "description:"+"\n";
        data = data + radiostation_desc +"\n";
        
        if ( playlist_id == -1){
            data = data + "Radio is not in any playlist";
        }
        else{
            data = data + "Id of the playlist: "+playlist_id;
        }
        return data;
    }

}
