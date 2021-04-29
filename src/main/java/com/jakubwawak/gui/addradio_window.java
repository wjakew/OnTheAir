/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.gui;

import com.jakubwawak.radioplayer.Boombox;
import com.jakubwawak.radioplayer.RadioStation;
import java.awt.Color;
import org.apache.commons.validator.UrlValidator;

/**
 *
 * @author jakubwawak
 */
public class addradio_window extends javax.swing.JDialog {

    /**
     * Creates new form addradio_window
     */
    Boombox session_boombox;
    
    public addradio_window(javax.swing.JDialog parent, boolean modal,Boombox boombox) {
        super(parent, modal);
        session_boombox = boombox;
        this.setUndecorated(true);
        initComponents();
        getContentPane().setBackground(Color.DARK_GRAY);
        this.setLocationRelativeTo(parent);
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

        field_url = new javax.swing.JTextField();
        field_text = new javax.swing.JTextField();
        label_close = new javax.swing.JLabel();
        label_add = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        field_url.setBackground(new java.awt.Color(0, 0, 0));
        field_url.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        field_url.setForeground(new java.awt.Color(255, 255, 255));
        field_url.setText("url");

        field_text.setBackground(new java.awt.Color(0, 0, 0));
        field_text.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        field_text.setForeground(new java.awt.Color(255, 255, 255));
        field_text.setText("name");

        label_close.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        label_close.setForeground(new java.awt.Color(255, 255, 255));
        label_close.setText("Close");
        label_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_closeMouseClicked(evt);
            }
        });

        label_add.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        label_add.setForeground(new java.awt.Color(255, 255, 255));
        label_add.setText("Add");
        label_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_addMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(field_text, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_url, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_close)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_add)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(field_text, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(field_url, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_close)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(label_add)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_closeMouseClicked
        dispose();
    }//GEN-LAST:event_label_closeMouseClicked

    private void label_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_addMouseClicked
        if ( validate_url(field_url.getText()) ){
            if ( !field_text.getText().isEmpty() && !field_text.getText().equals("blank")){
                session_boombox.add_radio(new RadioStation(field_text.getText(),field_url.getText()));
                dispose();
            }
            else{
                field_text.setText("blank");
            }
            
        }
        else{
            field_url.setText("Wrong url");
            field_text.setEnabled(false);
            field_url.setEnabled(false);
            label_add.setEnabled(false);
            label_add.setVisible(false);
        }
        
    }//GEN-LAST:event_label_addMouseClicked

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField field_text;
    private javax.swing.JTextField field_url;
    private javax.swing.JLabel label_add;
    private javax.swing.JLabel label_close;
    // End of variables declaration//GEN-END:variables
}