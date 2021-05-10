/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.gui;

import com.jakubwawak.ontheair.Database;
import java.awt.Color;

/**
 *
 * @author jakubwawak
 */
public class information_window extends javax.swing.JDialog {

    /**
     * Creates new form information_window
     */
    Database database;
    
    public information_window(javax.swing.JDialog parent, boolean modal,Database database,String version) {
        super(parent, modal);
        this.database = database;
        this.setUndecorated(true);
        initComponents();
        load_window();
        label_version.setText(version);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setLocationRelativeTo(parent);
        setVisible(true);
    }
    
    /**
     * Function for loading window
     */
    void load_window(){
        if (database.connected){
            label_database.setText("Database connected");
        }
        else{
            label_database.setText("Database disconnected");
        }
        if ( database.ota_user_id != -1){
            label_register.setForeground(Color.blue);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_by = new javax.swing.JLabel();
        label_database = new javax.swing.JLabel();
        label_close = new javax.swing.JLabel();
        label_desc = new javax.swing.JLabel();
        label_version = new javax.swing.JLabel();
        label_date = new javax.swing.JLabel();
        label_register = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        label_by.setForeground(new java.awt.Color(255, 255, 255));
        label_by.setText("by Jakub Wawak 2021");

        label_database.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        label_database.setForeground(new java.awt.Color(255, 255, 255));
        label_database.setText("Database Connected");
        label_database.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_databaseMouseClicked(evt);
            }
        });

        label_close.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        label_close.setForeground(new java.awt.Color(255, 255, 255));
        label_close.setText("Close");
        label_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_closeMouseClicked(evt);
            }
        });

        label_desc.setForeground(new java.awt.Color(255, 255, 255));
        label_desc.setText("App for listening online radio.");

        label_version.setForeground(new java.awt.Color(255, 255, 255));
        label_version.setText("1.0.0XX");

        label_date.setForeground(new java.awt.Color(255, 255, 255));
        label_date.setText("05.2021");

        label_register.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        label_register.setForeground(new java.awt.Color(255, 255, 255));
        label_register.setText("Register account");
        label_register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_registerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(label_version)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_date)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(label_by))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(label_close))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(label_desc))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(label_register))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(label_database)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(label_by)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_desc)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_version)
                    .addComponent(label_date))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_register)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_database)
                .addGap(18, 18, 18)
                .addComponent(label_close)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_closeMouseClicked
        dispose();
    }//GEN-LAST:event_label_closeMouseClicked

    private void label_registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_registerMouseClicked
        new register_window(this,true,database);
    }//GEN-LAST:event_label_registerMouseClicked

    private void label_databaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_databaseMouseClicked
        new database_window(this,true,database);
    }//GEN-LAST:event_label_databaseMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label_by;
    private javax.swing.JLabel label_close;
    private javax.swing.JLabel label_database;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_desc;
    private javax.swing.JLabel label_register;
    private javax.swing.JLabel label_version;
    // End of variables declaration//GEN-END:variables
}
