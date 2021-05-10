/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.gui;

import com.jakubwawak.ontheair.Database;
import com.jakubwawak.radioplayer.Boombox;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Function for loading myaccount window
 * @author jakubwawak
 */
public class myaccount_window extends javax.swing.JDialog {

    /**
     * Creates new form myaccount_window
     */
    Database database;
    Boombox boombox;
    String version;
    
    boolean first_start;
    
    public myaccount_window(java.awt.Frame parent, boolean modal,Boombox boombox,String version) throws SQLException, ClassNotFoundException {
        super(parent, modal);
        this.boombox = boombox;
        this.version = version;
        database = new Database();
        this.setUndecorated(true);
        first_start = true;
        initComponents();
        getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(parent);
        load_window();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_syncpresets = new javax.swing.JLabel();
        label_login = new javax.swing.JLabel();
        label_addradio = new javax.swing.JLabel();
        label_close = new javax.swing.JLabel();
        label_information = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        label_syncpresets.setFont(new java.awt.Font("Calisto MT", 0, 36)); // NOI18N
        label_syncpresets.setForeground(new java.awt.Color(255, 255, 255));
        label_syncpresets.setText("Sync Presets");
        label_syncpresets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_syncpresetsMouseClicked(evt);
            }
        });

        label_login.setFont(new java.awt.Font("Calisto MT", 0, 36)); // NOI18N
        label_login.setForeground(new java.awt.Color(255, 255, 255));
        label_login.setText("Log in");
        label_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_loginMouseClicked(evt);
            }
        });

        label_addradio.setFont(new java.awt.Font("Calisto MT", 0, 36)); // NOI18N
        label_addradio.setForeground(new java.awt.Color(255, 255, 255));
        label_addradio.setText("Add Radio");
        label_addradio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_addradioMouseClicked(evt);
            }
        });

        label_close.setFont(new java.awt.Font("Calisto MT", 0, 36)); // NOI18N
        label_close.setForeground(new java.awt.Color(255, 255, 255));
        label_close.setText("Close");
        label_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_closeMouseClicked(evt);
            }
        });

        label_information.setFont(new java.awt.Font("Calisto MT", 0, 36)); // NOI18N
        label_information.setForeground(new java.awt.Color(255, 255, 255));
        label_information.setText("Information");
        label_information.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_informationMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_addradio)
                    .addComponent(label_login)
                    .addComponent(label_close)
                    .addComponent(label_information)
                    .addComponent(label_syncpresets))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(label_login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_addradio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_syncpresets)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_information)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_close)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_closeMouseClicked
        dispose();
    }//GEN-LAST:event_label_closeMouseClicked

    private void label_addradioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_addradioMouseClicked
        new addradio_window(this,true,boombox);
    }//GEN-LAST:event_label_addradioMouseClicked
    
    /**
     * Function for loading window
     * @throws SQLException 
     */
    void load_window() throws SQLException{
        if (first_start){
            database.connect("localhost", "ontheair_database", "root", "password");
            first_start = false;
        }
        if ( database.ota_user_id != -1 ){
            label_login.setText(database.log_ota_name(database.ota_user_id));
        }
        if ( !database.connected ){
            System.out.println("Database connection failed");
            label_login.setForeground(Color.BLACK);
            label_syncpresets.setForeground(Color.BLACK);
        }
    }
    private void label_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_loginMouseClicked
        if ( label_login.getText().equals("Log in")){
            try {
                if ( database.connected ){
                    new login_window(this,true,database);
                    if ( database.ota_user_id > 0){
                        label_login.setText(database.log_ota_name(database.ota_user_id));    
                    }
                }
                else{
                    label_login.setText("No database");
                }
            } catch (SQLException ex) {
                System.out.println("Database error: "+ex.toString());
            }
        }
        else{
            label_login.setText("Log in");
            database.ota_user_id = -1;
        }
    }//GEN-LAST:event_label_loginMouseClicked

    private void label_syncpresetsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_syncpresetsMouseClicked
        if ( database.connected && database.ota_user_id != -1){
            label_syncpresets.setText("Not supported yet");
        }
    }//GEN-LAST:event_label_syncpresetsMouseClicked

    private void label_informationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_informationMouseClicked
        new information_window(this,true,database,version);
        try {
            load_window();
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.toString());
            dispose();
        }
    }//GEN-LAST:event_label_informationMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label_addradio;
    private javax.swing.JLabel label_close;
    private javax.swing.JLabel label_information;
    private javax.swing.JLabel label_login;
    private javax.swing.JLabel label_syncpresets;
    // End of variables declaration//GEN-END:variables
}
