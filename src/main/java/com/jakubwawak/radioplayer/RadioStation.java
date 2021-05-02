/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.radioplayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *Object for storing presets
 * @author jakubwawak
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
    public RadioStation(String preset_name,String url){
        this.radiostation_name = preset_name;
        this.radiostation_url = url;
        
        playlist_id = -1;
        radiostation_desc = "";
        radiostation_id = -1;
    }
    
    /**
     * Constructor for database data
     * @param data 
     */
    public RadioStation(ResultSet data) throws SQLException{
        radiostation_name = data.getString("radiostation_name");
        radiostation_url = data.getString("radiostation_url");
        
        playlist_id = data.getInt("playlist_id");
        radiostation_desc = "";
        radiostation_id = data.getInt("radiostation_id");
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
    
    /**
     * Function for comparing two radiostation objects
     * @param another
     * @return Boolean
     */
    public boolean compare(RadioStation another){
        return this.radiostation_name.equals(another.radiostation_name)
                && this.radiostation_url.equals(another.radiostation_url);
    }

}
