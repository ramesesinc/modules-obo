/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.views;

import com.rameses.osiris2.themes.FormPage;
import com.rameses.rcp.ui.annotations.StyleSheet;
import com.rameses.rcp.ui.annotations.Template;

/**
 *
 * @author elmonazareno
 */
@StyleSheet
@Template(FormPage.class)
public class ApplicationFindingPage extends javax.swing.JPanel {

    /**
     * Creates new form BuildingApplicationFindingPage
     */
    public ApplicationFindingPage() {
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

        xPanel1 = new com.rameses.rcp.control.XPanel();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xLabel2 = new com.rameses.rcp.control.XLabel();
        xLabel3 = new com.rameses.rcp.control.XLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        xTextArea2 = new com.rameses.rcp.control.XTextArea();
        xPanel3 = new com.rameses.rcp.control.XPanel();
        addFile = new com.rameses.rcp.control.XButton();
        xButton6 = new com.rameses.rcp.control.XButton();
        xButton7 = new com.rameses.rcp.control.XButton();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        jPanel1 = new javax.swing.JPanel();
        xButton2 = new com.rameses.rcp.control.XButton();
        xButton3 = new com.rameses.rcp.control.XButton();
        xButton4 = new com.rameses.rcp.control.XButton();
        xButton1 = new com.rameses.rcp.control.XButton();

        setLayout(new java.awt.CardLayout());

        xPanel1.setVisibleWhen("#{ pagename == 'view' }");
        xPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        xPanel1.setPreferredSize(new java.awt.Dimension(593, 394));
        xPanel1.setLayout(new java.awt.BorderLayout());

        xFormPanel2.setCaptionWidth(100);

        xLabel2.setCaption("Section");
        xLabel2.setExpression("#{ sectiontitle }");
        xLabel2.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel2);

        xLabel3.setCaption("Created By");
        xLabel3.setExpression("#{ entity.createdby.name }");
        xLabel3.setVisibleWhen("#{ entity.objid != null }");
        xLabel3.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel3);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(0, 150));

        xTextArea2.setCaption("Particulars");
        xTextArea2.setLineWrap(true);
        xTextArea2.setName("entity.particulars"); // NOI18N
        xTextArea2.setPreferredSize(new java.awt.Dimension(0, 60));
        jScrollPane2.setViewportView(xTextArea2);

        xFormPanel2.add(jScrollPane2);

        xPanel3.setCaption("Attachment");
        xPanel3.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        addFile.setCaption("");
        addFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clip.png"))); // NOI18N
        addFile.setName("addAttachment"); // NOI18N
        addFile.setVisibleWhen("#{ editable == true  && entity.attachment == null }");
        addFile.setFontStyle("font-size: 10;");
        addFile.setMargin(new java.awt.Insets(2, 4, 2, 4));
        addFile.setText("Add Attachment");
        xPanel3.add(addFile);

        xButton6.setName("removeAttachment"); // NOI18N
        xButton6.setVisibleWhen("#{ editable == true && entity.attachment != null }");
        xButton6.setText("Remove");
        xPanel3.add(xButton6);

        xButton7.setName("viewAttachment"); // NOI18N
        xButton7.setVisibleWhen("#{ entity.attachment != null }");
        xButton7.setText("View");
        xPanel3.add(xButton7);

        xFormPanel2.add(xPanel3);

        xLabel1.setCaption("Status");
        xLabel1.setExpression("#{ entity.state == 1 ? 'CLOSED' : 'FOR-REVISION' }");
        xLabel1.setVisibleWhen("");
        xLabel1.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xFormPanel2.add(xLabel1);

        xPanel1.add(xFormPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(100, 30));

        xButton2.setName("save"); // NOI18N
        xButton2.setVisibleWhen("#{ showSave == true }");
        xButton2.setText("Save");
        jPanel1.add(xButton2);

        xButton3.setName("supersede"); // NOI18N
        xButton3.setVisibleWhen("#{ showSupersede == true }");
        xButton3.setText("Supersede");
        jPanel1.add(xButton3);

        xButton4.setName("closeIssue"); // NOI18N
        xButton4.setVisibleWhen("#{ showCloseIssue == true }");
        xButton4.setText("Close Issue");
        jPanel1.add(xButton4);

        xButton1.setName("_close"); // NOI18N
        xButton1.setVisibleWhen("");
        xButton1.setText("Cancel");
        jPanel1.add(xButton1);

        xPanel1.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        add(xPanel1, "card4");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.rcp.control.XButton addFile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton2;
    private com.rameses.rcp.control.XButton xButton3;
    private com.rameses.rcp.control.XButton xButton4;
    private com.rameses.rcp.control.XButton xButton6;
    private com.rameses.rcp.control.XButton xButton7;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLabel xLabel2;
    private com.rameses.rcp.control.XLabel xLabel3;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XPanel xPanel3;
    private com.rameses.rcp.control.XTextArea xTextArea2;
    // End of variables declaration//GEN-END:variables
}