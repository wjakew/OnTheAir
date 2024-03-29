/*
by Jakub Wawak
kubawawak@gmail.com
all rights reserved
 */
package com.jakubwawak.gui;

import com.jakubwawak.ontheair.Jukebox;
import com.jakubwawak.radioplayer.Boombox;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author kubaw
 */
public class radiolist_window extends javax.swing.JDialog {

    /**
     * Creates new form radiolist_window
     */
    Boombox boombox;
    public radiolist_window(javax.swing.JDialog parent, boolean modal,Boombox boombox) {
        super(parent, modal);
        this.boombox = boombox;
        this.setUndecorated(true);
        initComponents();
        load_list();
        getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(parent);
        label_url.setVisible(false);
        setVisible(true);
    }
    
    /**
     * Function for loading list
     */
    void load_list(){
        DefaultListModel dlm = new DefaultListModel();
        dlm.addAll(boombox.list_of_names());
        list_radios.setModel(dlm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        list_radios = new javax.swing.JList<>();
        label_url = new javax.swing.JLabel();
        label_delete = new javax.swing.JLabel();
        label_save = new javax.swing.JLabel();
        label_close = new javax.swing.JLabel();
        button_add = new javax.swing.JLabel();
        label_delete2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        list_radios.setBackground(new java.awt.Color(0, 0, 0));
        list_radios.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        list_radios.setForeground(new java.awt.Color(255, 255, 0));
        list_radios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list_radios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_radiosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(list_radios);

        label_url.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        label_url.setForeground(new java.awt.Color(255, 255, 51));
        label_url.setText("jLabel1");

        label_delete.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        label_delete.setForeground(new java.awt.Color(255, 255, 255));
        label_delete.setText("Delete");
        label_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_deleteMouseClicked(evt);
            }
        });

        label_save.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        label_save.setForeground(new java.awt.Color(255, 255, 255));
        label_save.setText("Save to jukebox");
        label_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_saveMouseClicked(evt);
            }
        });

        label_close.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        label_close.setForeground(new java.awt.Color(255, 255, 255));
        label_close.setText("Close");
        label_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_closeMouseClicked(evt);
            }
        });

        button_add.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        button_add.setForeground(new java.awt.Color(255, 255, 255));
        button_add.setText("Add");
        button_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_addMouseClicked(evt);
            }
        });

        label_delete2.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        label_delete2.setForeground(new java.awt.Color(255, 255, 255));
        label_delete2.setText("/");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_url, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(button_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_delete2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_delete)
                        .addGap(27, 27, 27)
                        .addComponent(label_close)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_url)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_save)
                    .addComponent(button_add)
                    .addComponent(label_delete2)
                    .addComponent(label_delete)
                    .addComponent(label_close))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_closeMouseClicked
        dispose();
    }//GEN-LAST:event_label_closeMouseClicked

    private void button_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_addMouseClicked
        new addradio_window(this,true,boombox);
        boombox.show_data();
        load_list();
        
    }//GEN-LAST:event_button_addMouseClicked

    private void label_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_deleteMouseClicked
        String selected = list_radios.getSelectedValue();
        if (boombox.remove_radio(selected)){
            load_list();
        }
    }//GEN-LAST:event_label_deleteMouseClicked

    private void list_radiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_radiosMouseClicked
        label_url.setVisible(true);
        String selected = list_radios.getSelectedValue();
        label_url.setText(boombox.get_url(selected));
    }//GEN-LAST:event_list_radiosMouseClicked

    private void label_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_saveMouseClicked
        Jukebox jukebox = new Jukebox();
            try {
                jukebox.save_file(boombox);
                boombox.show_data();
            } catch (IOException ex) {
                System.out.println("Error reading file ("+ex.toString()+")");
            }
    }//GEN-LAST:event_label_saveMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel button_add;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_close;
    private javax.swing.JLabel label_delete;
    private javax.swing.JLabel label_delete2;
    private javax.swing.JLabel label_save;
    private javax.swing.JLabel label_url;
    private javax.swing.JList<String> list_radios;
    // End of variables declaration//GEN-END:variables
}
