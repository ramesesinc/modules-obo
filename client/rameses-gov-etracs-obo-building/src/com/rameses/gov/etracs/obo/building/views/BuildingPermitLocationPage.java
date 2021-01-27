/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.building.views;

import com.rameses.osiris2.themes.OKCancelPage;
import com.rameses.rcp.ui.annotations.Template;

/**
 *
 * @author elmonazareno
 */
@Template(OKCancelPage.class)
public class BuildingPermitLocationPage extends javax.swing.JPanel {

    /**
     * Creates new form BuildingLocationPage
     */
    public BuildingPermitLocationPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xTextField4 = new com.rameses.rcp.control.XTextField();
        xTextField5 = new com.rameses.rcp.control.XTextField();
        xTextField7 = new com.rameses.rcp.control.XTextField();
        xTextField2 = new com.rameses.rcp.control.XTextField();
        xTextField1 = new com.rameses.rcp.control.XTextField();
        xTextField6 = new com.rameses.rcp.control.XTextField();
        xTextField3 = new com.rameses.rcp.control.XTextField();
        barangayLookup1 = new com.rameses.etracs.components.BarangayLookup();
        xDecimalField1 = new com.rameses.rcp.control.XDecimalField();

        xFormPanel1.setCaptionWidth(150);

        xTextField4.setCaption("Unit No");
        xTextField4.setName("entity.unitno"); // NOI18N
        xTextField4.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xTextField4.setPreferredSize(new java.awt.Dimension(200, 20));
        xTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xTextField4ActionPerformed(evt);
            }
        });
        xFormPanel1.add(xTextField4);

        xTextField5.setCaption("Bldg No");
        xTextField5.setName("entity.bldgno"); // NOI18N
        xTextField5.setPreferredSize(new java.awt.Dimension(200, 20));
        xTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xTextField5ActionPerformed(evt);
            }
        });
        xFormPanel1.add(xTextField5);

        xTextField7.setCaption("Bldg Name");
        xTextField7.setName("entity.bldgname"); // NOI18N
        xTextField7.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xTextField7ActionPerformed(evt);
            }
        });
        xFormPanel1.add(xTextField7);

        xTextField2.setCaption("Lot No");
        xTextField2.setName("entity.lotno"); // NOI18N
        xTextField2.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xTextField2.setPreferredSize(new java.awt.Dimension(200, 20));
        xTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xTextField2ActionPerformed(evt);
            }
        });
        xFormPanel1.add(xTextField2);

        xTextField1.setCaption("Block No");
        xTextField1.setName("entity.blockno"); // NOI18N
        xTextField1.setPreferredSize(new java.awt.Dimension(200, 20));
        xFormPanel1.add(xTextField1);

        xTextField6.setCaption("Street");
        xTextField6.setName("entity.street"); // NOI18N
        xTextField6.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xTextField6);

        xTextField3.setCaption("Subdivision");
        xTextField3.setName("entity.subdivision"); // NOI18N
        xTextField3.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xTextField3);

        barangayLookup1.setCaption("Barangay");
        barangayLookup1.setName("entity.barangay"); // NOI18N
        xFormPanel1.add(barangayLookup1);

        xDecimalField1.setCaption("Lot Area");
        xDecimalField1.setName("entity.lotarea"); // NOI18N
        xDecimalField1.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xFormPanel1.add(xDecimalField1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void xTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xTextField2ActionPerformed

    private void xTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xTextField4ActionPerformed

    private void xTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xTextField5ActionPerformed

    private void xTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xTextField7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.etracs.components.BarangayLookup barangayLookup1;
    private com.rameses.rcp.control.XDecimalField xDecimalField1;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XTextField xTextField1;
    private com.rameses.rcp.control.XTextField xTextField2;
    private com.rameses.rcp.control.XTextField xTextField3;
    private com.rameses.rcp.control.XTextField xTextField4;
    private com.rameses.rcp.control.XTextField xTextField5;
    private com.rameses.rcp.control.XTextField xTextField6;
    private com.rameses.rcp.control.XTextField xTextField7;
    // End of variables declaration//GEN-END:variables
}
