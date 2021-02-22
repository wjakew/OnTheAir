/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.gui;

/**
 *Object for creating timer object
 * @author jakubwawak
 */
public class Timer implements Runnable{
    int seconds,minutes,hours;
    
    /**
     * Constructor
     */
    Timer(){
        seconds = 00;
        minutes = 00;
        hours = 00;
    }
    
    /**
     * Constructor with 3 parameters
     * @param seconds
     * @param minutes
     * @param hours 
     */
    Timer(int seconds,int minutes,int hours){
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    /**
     * Start counting
     */
    @Override
    public void run() {
        if ( seconds < 60){
            seconds++;
        }
        else if ( seconds > 60){
            seconds = 00;
            minutes++;
            if ( minutes > 60){
                hours = 00;
            }
        }
    }
    
    void show_timer(){
        System.out.println();
    }
    
}
