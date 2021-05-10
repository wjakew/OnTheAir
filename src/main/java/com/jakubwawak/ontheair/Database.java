/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.ontheair;

import com.jakubwawak.radioplayer.RadioStation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *Object for maintaining database connection
 * @author jakubwawak
 */
public class Database {
    
    // version of database 
    final String version = "v1.0.0";
    // header for logging data
    // connection object for maintaing connection to the database
    Connection con;
    
    // variable for debug purposes
    final int debug = 1;
    public int ota_user_id;
    public boolean evaluation_copy;
    
    public boolean connected;                      // flag for checking connection to the database
    public String ip;                              // ip data for the connector
    public String database_name;                   // name of the database
    public String database_user,database_password; // user data for cred
    ArrayList<String> database_log;         // collection for storing data
    
    /**
     * Constructor
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Database() throws SQLException, ClassNotFoundException, SQLException{
        System.out.println("Database object invoked...");
        con = null;
        database_log = new ArrayList<>();
        connected = false;
        ota_user_id = -1;
        ip = "";
        database_name = "";
        database_user = "";
        database_password = "";
        //log("Started! Database Connector initzialazed");
    }
    
    /**
     * Function for connecting to the database
     * @param ip
     * @param database_name
     * @param user
     * @param password
     * @throws SQLException 
     */
    public void connect(String ip,String database_name,String user,String password) throws SQLException{
        System.out.println("Trying to connect...");
        this.ip = ip;
        this.database_name = database_name;
        database_user = user;
        database_password = password;
        
        String login_data = "jdbc:mysql://"+this.ip+"/"+database_name+"?"
                + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&" +
                                   "user="+database_user+"&password="+database_password;
        try{
            con = DriverManager.getConnection(login_data);
            connected = true;
            System.out.println("Connected succesfully");
        }catch(SQLException e){
            connected = false;
            System.out.println("Failed to connect to database ("+e.toString()+")");
        }
    }
    
    /**
     * Function for loading presets
     */
    public ResultSet unload_presets() throws SQLException{
        String query = "SELECT * FROM RADIOSTATION WHERE OTA_USER_ID = ?;";
        
        try{
            PreparedStatement ppst = con.prepareStatement(query);
            
            ppst.setInt(1,ota_user_id);
            
            ResultSet rs = ppst.executeQuery();
            
            if ( rs.next() ){
                return rs;
            }
            return null;
        }catch(SQLException e){
            System.out.println("Database error: "+e.toString());
            return null;
        }
    }
    
    /**
     * Function for inserting presets
     * @param radio
     * @return Integer
     */
    public int insert_preset(RadioStation radio){
        String query = "INSERT INTO RADIOSTATION\n" +
                        "(ota_user_id,image_lib_id,playlist_id,radiostation_name,radiostation_url)\n" +
                        "VALUES\n" +
                        "(?,?,?,?,?);";
        
        try{
            PreparedStatement ppst = con.prepareStatement(query);
            // TODO
            return 1;
        }catch(SQLException e){
            System.out.println("Error: "+e.toString());
            return -1;
        }
    }
    
    /**
     * Function for logging ota user
     * @param login
     * @param password
     * @return Integer
     */
    public int log_ota_user(String login,String password) throws SQLException{
        
        String query = "SELECT * FROM OTA_USER WHERE ota_user_login = ? and ota_user_password = ?;";
        
        try{
            PreparedStatement ppst = con.prepareStatement(query);
            
            ppst.setString(1,login);
            ppst.setString(2,password);
            
            
            ResultSet rs = ppst.executeQuery();
            
            if ( rs.next() ){
                ota_user_id = rs.getInt("ota_user_id");
                return rs.getInt("ota_user_id");
            }
        }catch(SQLException e){
            return -2;
        }
        return 0;
    }
    
    /**
     * Function for logging user 
     * @param ota_user_id
     * @return String
     */
    public String log_ota_name(int ota_user_id) throws SQLException{
        String query = "SELECT ota_user_login FROM OTA_USER WHERE ota_user_id = ?;";
        
        try{
            PreparedStatement ppst = con.prepareStatement(query);
            ppst.setInt(1,ota_user_id);
            
            ResultSet rs = ppst.executeQuery();
            
            if (rs.next()){
                return rs.getString("ota_user_login");
            }
        }catch(SQLException e){
            System.out.println("Error: "+e.toString());
            return "";
        }
        return "";
    }
    
    /**
     * Function for checking login availability
     * @param login
     * @return boolean
     */
    public boolean check_login_availability(String login){
        String query = "SELECT ota_user_id FROM OTA_USER WHERE ota_user_login = ?;";
        
        try{
            PreparedStatement ppst = con.prepareStatement(query);
            
            ppst.setString(1,login);
            
            ResultSet rs = ppst.executeQuery();
            
            if (rs.next()){
                if (rs.getString("ota_user_login").equals(login)){
                    return false;
                }
            }
            return true;
            
        }catch(SQLException e){
            System.out.println("Error: "+e.toString());
            return false;
        }
    }
    
    
    /**
     * Function for register user on database
     * @param name
     * @param surname
     * @param login
     * @param password
     * @return
     * @throws SQLException 
     */
    public int register_user(String name,String surname,String login,String password) throws SQLException{
        String query = "INSERT INTO OTA_USER\n" +
                        "(OTA_USER_LOGIN,OTA_USER_NAME,OTA_USER_SURNAME,OTA_USER_PASSWORD)\n" +
                        "VALUES\n" +
                        "(?,?,?,?);";
        
        try{
            PreparedStatement ppst = con.prepareStatement(query);
            
            ppst.setString(1,login);
            ppst.setString(2,name);
            ppst.setString(3,surname);
            ppst.setString(4,password);
            
            ppst.execute();
            return 1;
            
        }catch(SQLException e){
            System.out.println("Error: "+e.toString());
            return -1;
        }
    }
    
}
