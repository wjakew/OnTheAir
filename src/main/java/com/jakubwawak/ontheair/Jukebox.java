/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.ontheair;

import com.jakubwawak.radioplayer.Boombox;
import com.jakubwawak.radioplayer.RadioStation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;

/**
 *Object for mantaining .air file with all the stations saved
 * @author kubaw
 */
public class Jukebox {
    
    /**
     * File:
     * -file for storing radio data
     * $name$url
     * $name$url
     * ...
     * -end of file
     */
    
    final String jukebox_src = "jukebox.air";
    public boolean error,read;
    ArrayList<String> raw_data;
    public Boombox boombox;
    
    /**
     * Constructor
     */
    public Jukebox(){
        try{
            File f = new File(jukebox_src);
            
            if ( !f.exists() ){
                error = true;
            }
            else{
                error = false;
            }
        }catch(Exception e){
            error = true;
        }
        boombox = new Boombox();
        read = false;
        raw_data = new ArrayList<>();
    }
    
    /**
     * Function for loading file
     * @throws FileNotFoundException 
     */
    public void load_file() throws FileNotFoundException, IOException{
        try{
            BufferedReader br = new BufferedReader(new FileReader(jukebox_src));
            
            String line;
            
            while((line = br.readLine())!=null){
                raw_data.add(line);
            }
            read = true;
        }catch(IOException e){
            read = false;
            error = true;
        }
    }
    
    /**
     * Function for saving Boombox data to file
     * @param boombox
     * @throws IOException 
     */
    public void save_file(Boombox boombox) throws IOException{
        Date actual = new Date();
        try{
            FileWriter fw = new FileWriter(jukebox_src);
            
            /**
            * File:
            * -file for storing radio data
            * $name$url
            * $name$url
            * ...
            * -end of file
            */
            fw.write("-"+actual.toString()+"\n");
            fw.write("-file for storing radio data\n");
            for(RadioStation rs : boombox.radio_list){
                fw.write(rs.radiostation_name+"%"+rs.radiostation_url+"\n");
            }
            fw.write("-end of file");
            fw.close();
        }catch(IOException e){
            error = true;
        }
    }
    
    /**
     * Function for validation dataset
     * @return Boolean
     */
    public boolean validate(){
        return boombox.radio_list.size() > 0;
    }
    
    /**
     * Function for loading data from file
     */
    public void load_data(){
        boombox = new Boombox();
        for(String line : raw_data){
            if ( !line.startsWith("-")){
                System.out.println(line);
                String[] data = line.split("%");
                RadioStation rs = new RadioStation(data[0],data[1]);
                boombox.add_radio(rs);
            }
        }
        
        if ( boombox.radio_list.size() == 0 ){
            error = true;
        }
    }
}
