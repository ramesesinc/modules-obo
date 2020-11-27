/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.views;

import com.rameses.rcp.ui.annotations.StyleSheet;
import com.rameses.rcp.ui.annotations.Template;
import com.rameses.seti2.views.CrudFormPage;

/**
 *
 * @author elmonazareno
 */
//@Template(OKCancelPage.class)
@Template(CrudFormPage.class)
@StyleSheet
public class ApplicationRequirementPage extends javax.swing.JPanel {

    /**
     * Creates new form BuildingPermitRequirementPage
     */
    public ApplicationRequirementPage() {
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

        xPanel2 = new com.rameses.rcp.control.XPanel();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xLabel2 = new com.rameses.rcp.control.XLabel();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        xRadio1 = new com.rameses.rcp.control.XRadio();
        xRadio2 = new com.rameses.rcp.control.XRadio();
        xRadio3 = new com.rameses.rcp.control.XRadio();
        xRadio4 = new com.rameses.rcp.control.XRadio();
        jScrollPane1 = new javax.swing.JScrollPane();
        xTextArea1 = new com.rameses.rcp.control.XTextArea();
        xLabel3 = new com.rameses.rcp.control.XLabel();
        xLabel4 = new com.rameses.rcp.control.XLabel();
        jPanel1 = new javax.swing.JPanel();
        xButton2 = new com.rameses.rcp.control.XButton();
        xButton3 = new com.rameses.rcp.control.XButton();
        xButton4 = new com.rameses.rcp.control.XButton();
        xButton1 = new com.rameses.rcp.control.XButton();

        setMinimumSize(new java.awt.Dimension(607, 528));
        setPreferredSize(new java.awt.Dimension(607, 528));
        setLayout(new java.awt.CardLayout());

        xPanel2.setVisibleWhen("#{ pagename == 'view' }");
        xPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        xPanel2.setLayout(new java.awt.BorderLayout());

        xFormPanel2.setCaptionWidth(120);

        xLabel2.setVisibleWhen("#{ editable == true }");
        xLabel2.setShowCaption(false);
        xLabel2.setText("Select an appropriate status of the requirement then click OK to save and continue");
        xFormPanel2.add(xLabel2);

        xLabel1.setCaption("Requirement");
        xLabel1.setExpression("<html>#{ entity.type.title }</html>");
        xLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel1.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel1.setPreferredSize(new java.awt.Dimension(0, 80));
        xFormPanel2.add(xLabel1);

        xRadio1.setCaption("Status");
        xRadio1.setName("info.state"); // NOI18N
        xRadio1.setOptionValue(1);
        xRadio1.setText("Pass");
        xRadio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xRadio1ActionPerformed(evt);
            }
        });
        xFormPanel2.add(xRadio1);

        xRadio2.setCaption("");
        xRadio2.setName("info.state"); // NOI18N
        xRadio2.setOptionValue(2);
        xRadio2.setText("Send for Revision");
        xFormPanel2.add(xRadio2);

        xRadio3.setCaption("");
        xRadio3.setName("info.state"); // NOI18N
        xRadio3.setOptionValue(3);
        xRadio3.setCellPadding(new java.awt.Insets(0, 0, 0, 20));
        xRadio3.setText("Not applicable");
        xFormPanel2.add(xRadio3);

        xRadio4.setCaption("");
        xRadio4.setName("info.state"); // NOI18N
        xRadio4.setOptionValue(0);
        xRadio4.setVisibleWhen("#{ false }");
        xRadio4.setText("NA");
        xRadio4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xRadio4ActionPerformed(evt);
            }
        });
        xFormPanel2.add(xRadio4);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 150));

        xTextArea1.setCaption("Remarks");
        xTextArea1.setLineWrap(true);
        xTextArea1.setName("info.remarks"); // NOI18N
        xTextArea1.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xTextArea1.setPreferredSize(new java.awt.Dimension(0, 60));
        jScrollPane1.setViewportView(xTextArea1);

        xFormPanel2.add(jScrollPane1);

        xLabel3.setCaption("Reviewed by");
        xLabel3.setExpression("#{ entity.reviewer.name }");
        xLabel3.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xFormPanel2.add(xLabel3);

        xLabel4.setCaption("Date Reviewed");
        xLabel4.setExpression("#{ entity.dtreviewed }");
        xLabel4.setDateFormat("yyyy-MM-dd");
        xFormPanel2.add(xLabel4);

        xPanel2.add(xFormPanel2, java.awt.BorderLayout.CENTER);

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

        xButton1.setCaption("Close");
        xButton1.setName("_close"); // NOI18N
        xButton1.setText("Cancel");
        jPanel1.add(xButton1);

        xPanel2.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        add(xPanel2, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void xRadio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xRadio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xRadio1ActionPerformed

    private void xRadio4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xRadio4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xRadio4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton2;
    private com.rameses.rcp.control.XButton xButton3;
    private com.rameses.rcp.control.XButton xButton4;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLabel xLabel2;
    private com.rameses.rcp.control.XLabel xLabel3;
    private com.rameses.rcp.control.XLabel xLabel4;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XRadio xRadio1;
    private com.rameses.rcp.control.XRadio xRadio2;
    private com.rameses.rcp.control.XRadio xRadio3;
    private com.rameses.rcp.control.XRadio xRadio4;
    private com.rameses.rcp.control.XTextArea xTextArea1;
    // End of variables declaration//GEN-END:variables
}
