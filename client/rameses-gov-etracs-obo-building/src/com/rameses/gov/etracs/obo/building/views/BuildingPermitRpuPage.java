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
public class BuildingPermitRpuPage extends javax.swing.JPanel {

    /**
     * Creates new form BuildingApplicationRpuPage
     */
    public BuildingPermitRpuPage() {
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

        xActionBar2 = new com.rameses.rcp.control.XActionBar();
        jPanel1 = new javax.swing.JPanel();
        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        xTextField1 = new com.rameses.rcp.control.XTextField();
        xButton1 = new com.rameses.rcp.control.XButton();
        xLabel10 = new com.rameses.rcp.control.XLabel();
        xLabel3 = new com.rameses.rcp.control.XLabel();
        xCheckBox1 = new com.rameses.rcp.control.XCheckBox();
        xLabel4 = new com.rameses.rcp.control.XLabel();
        xLabel5 = new com.rameses.rcp.control.XLabel();
        xLabel6 = new com.rameses.rcp.control.XLabel();
        xLabel7 = new com.rameses.rcp.control.XLabel();
        xLabel8 = new com.rameses.rcp.control.XLabel();
        xLabel9 = new com.rameses.rcp.control.XLabel();

        setLayout(new java.awt.BorderLayout());

        xActionBar2.setFormName("formName");
        xActionBar2.setName("formActions"); // NOI18N
        xActionBar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xActionBar2.setDynamic(true);
        xActionBar2.setPreferredSize(new java.awt.Dimension(91, 30));
        add(xActionBar2, java.awt.BorderLayout.NORTH);

        xFormPanel1.setCaptionWidth(120);

        xPanel1.setCaption("Enter TD No");
        xPanel1.setVisibleWhen("#{ mode == 'create' }");
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0);
        flowLayout1.setAlignOnBaseline(true);
        xPanel1.setLayout(flowLayout1);

        xTextField1.setCaption("Enter TD No");
        xTextField1.setName("tdno"); // NOI18N
        xTextField1.setPreferredSize(new java.awt.Dimension(200, 20));
        xPanel1.add(xTextField1);

        xButton1.setCaption("");
        xButton1.setName("lookupTD"); // NOI18N
        xButton1.setText("Search");
        xPanel1.add(xButton1);

        xFormPanel1.add(xPanel1);

        xLabel10.setCaption("TD No");
        xLabel10.setExpression("#{ entity.tdno }");
        xLabel10.setVisibleWhen("#{ mode != 'create' }");
        xLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel10.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel10.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel10);

        xLabel3.setCaption("Owner Name");
        xLabel3.setExpression("#{ entity.owner.name }");
        xLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel3.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel3.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel3);

        xCheckBox1.setCaption("");
        xCheckBox1.setCheckValue(1);
        xCheckBox1.setDisableWhen("#{ mode != 'create' }");
        xCheckBox1.setName("entity.lotowned"); // NOI18N
        xCheckBox1.setUncheckValue(0);
        xCheckBox1.setText("Lot Owned");
        xFormPanel1.add(xCheckBox1);

        xLabel4.setCaption("PIN");
        xLabel4.setExpression("#{ entity.pin }");
        xLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel4.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel4);

        xLabel5.setCaption("Block No");
        xLabel5.setExpression("#{ entity.blockno }");
        xLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel5.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel5);

        xLabel6.setCaption("Lot No");
        xLabel6.setExpression("#{ entity.lotno }");
        xLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel6.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel6);

        xLabel7.setCaption("Barangay");
        xLabel7.setExpression("#{ entity.barangay }");
        xLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel7.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel7);

        xLabel8.setCaption("Area (sqm)");
        xLabel8.setExpression("#{ entity.areasqm }");
        xLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel8.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel8);

        xLabel9.setCaption("Class");
        xLabel9.setExpression("#{ entity.classcode }");
        xLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel9.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel9);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private com.rameses.rcp.control.XActionBar xActionBar2;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XCheckBox xCheckBox1;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XLabel xLabel10;
    private com.rameses.rcp.control.XLabel xLabel3;
    private com.rameses.rcp.control.XLabel xLabel4;
    private com.rameses.rcp.control.XLabel xLabel5;
    private com.rameses.rcp.control.XLabel xLabel6;
    private com.rameses.rcp.control.XLabel xLabel7;
    private com.rameses.rcp.control.XLabel xLabel8;
    private com.rameses.rcp.control.XLabel xLabel9;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XTextField xTextField1;
    // End of variables declaration//GEN-END:variables
}
