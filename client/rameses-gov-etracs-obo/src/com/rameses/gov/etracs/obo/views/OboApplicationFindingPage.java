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
public class OboApplicationFindingPage extends javax.swing.JPanel {

    /**
     * Creates new form BuildingApplicationFindingPage
     */
    public OboApplicationFindingPage() {
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
        xButton5 = new com.rameses.rcp.control.XButton();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        xButton6 = new com.rameses.rcp.control.XButton();
        xButton7 = new com.rameses.rcp.control.XButton();
        xRadio1 = new com.rameses.rcp.control.XRadio();
        xRadio2 = new com.rameses.rcp.control.XRadio();
        jPanel1 = new javax.swing.JPanel();
        xButton2 = new com.rameses.rcp.control.XButton();
        xButton3 = new com.rameses.rcp.control.XButton();
        xButton4 = new com.rameses.rcp.control.XButton();
        xButton1 = new com.rameses.rcp.control.XButton();
        xPanel2 = new com.rameses.rcp.control.XPanel();
        xDataTable1 = new com.rameses.rcp.control.XDataTable();

        setLayout(new java.awt.CardLayout());

        xPanel1.setVisibleWhen("#{ pagename == 'view' }");
        xPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        xPanel1.setPreferredSize(new java.awt.Dimension(593, 394));
        xPanel1.setLayout(new java.awt.BorderLayout());

        xFormPanel2.setCaptionWidth(100);

        xLabel2.setCaption("Section");
        xLabel2.setExpression("#{ entity.section.type.title }");
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

        xButton5.setDisableWhen("");
        xButton5.setName("addAttachment"); // NOI18N
        xButton5.setVisibleWhen("#{ editable == true  && entity.attachment?.fileid == null }");
        xButton5.setContentAreaFilled(false);
        xButton5.setText("Add");
        xPanel3.add(xButton5);

        xLabel1.setDepends(new String[] {"entity.attachment"});
        xLabel1.setExpression("#{ entity.attachment.title }");
        xPanel3.add(xLabel1);

        xButton6.setName("removeAttachment"); // NOI18N
        xButton6.setVisibleWhen("#{ editable == true && entity.attachment?.fileid != null }");
        xButton6.setText("Remove");
        xPanel3.add(xButton6);

        xButton7.setName("viewAttachment"); // NOI18N
        xButton7.setVisibleWhen("#{ entity.attachment?.fileid != null }");
        xButton7.setText("View");
        xPanel3.add(xButton7);

        xFormPanel2.add(xPanel3);

        xRadio1.setCaption("Status");
        xRadio1.setName("entity.state"); // NOI18N
        xRadio1.setOptionValue(1);
        xRadio1.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xRadio1.setText("Resolved");
        xRadio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xRadio1ActionPerformed(evt);
            }
        });
        xFormPanel2.add(xRadio1);

        xRadio2.setCaption("");
        xRadio2.setName("entity.state"); // NOI18N
        xRadio2.setOptionValue(2);
        xRadio2.setText("Send for Revision");
        xFormPanel2.add(xRadio2);

        xPanel1.add(xFormPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(100, 30));

        xButton2.setName("save"); // NOI18N
        xButton2.setVisibleWhen("#{ editable == true }");
        xButton2.setText("OK");
        jPanel1.add(xButton2);

        xButton3.setName("supersede"); // NOI18N
        xButton3.setVisibleWhen("#{ overridable == true }");
        xButton3.setText("Supersede");
        jPanel1.add(xButton3);

        xButton4.setName("closeIssue"); // NOI18N
        xButton4.setVisibleWhen("#{ overridable == true }");
        xButton4.setText("Close Issue");
        jPanel1.add(xButton4);

        xButton1.setName("_close"); // NOI18N
        xButton1.setText("Cancel");
        jPanel1.add(xButton1);

        xPanel1.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        add(xPanel1, "card4");

        xPanel2.setVisibleWhen("#{ pagename == 'hist' }");
        xPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        xPanel2.setLayout(new java.awt.BorderLayout());

        xDataTable1.setHandler("listModel");
        xDataTable1.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "particulars"}
                , new Object[]{"caption", "Particulars"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "createdby.name"}
                , new Object[]{"caption", "Raised By"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 150}
                , new Object[]{"maxWidth", 250}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "dtcreated"}
                , new Object[]{"caption", "Date"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.DateColumnHandler(null, null, null)}
            })
        });
        xDataTable1.setRowHeight(40);
        xPanel2.add(xDataTable1, java.awt.BorderLayout.CENTER);

        add(xPanel2, "card5");
    }// </editor-fold>//GEN-END:initComponents

    private void xRadio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xRadio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xRadio1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton2;
    private com.rameses.rcp.control.XButton xButton3;
    private com.rameses.rcp.control.XButton xButton4;
    private com.rameses.rcp.control.XButton xButton5;
    private com.rameses.rcp.control.XButton xButton6;
    private com.rameses.rcp.control.XButton xButton7;
    private com.rameses.rcp.control.XDataTable xDataTable1;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLabel xLabel2;
    private com.rameses.rcp.control.XLabel xLabel3;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XPanel xPanel3;
    private com.rameses.rcp.control.XRadio xRadio1;
    private com.rameses.rcp.control.XRadio xRadio2;
    private com.rameses.rcp.control.XTextArea xTextArea2;
    // End of variables declaration//GEN-END:variables
}
