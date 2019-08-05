/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.views;

import com.rameses.rcp.ui.annotations.Template;
import com.rameses.seti2.views.CrudFormPage;

/**
 *
 * @author elmonazareno
 */
@Template(CrudFormPage.class)
public class OboEvaluationTypePage extends javax.swing.JPanel {

    /**
     * Creates new form OboRequirementTypePage
     */
    public OboEvaluationTypePage() {
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
        xTextField1 = new com.rameses.rcp.control.XTextField();
        xTextField2 = new com.rameses.rcp.control.XTextField();
        xLookupField1 = new com.rameses.rcp.control.XLookupField();
        xComboBox1 = new com.rameses.rcp.control.XComboBox();
        xComboBox3 = new com.rameses.rcp.control.XComboBox();
        xIntegerField1 = new com.rameses.rcp.control.XIntegerField();
        xTextField3 = new com.rameses.rcp.control.XTextField();
        xComboBox4 = new com.rameses.rcp.control.XComboBox();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        xCheckBox2 = new com.rameses.rcp.control.XCheckBox();
        xCheckBox3 = new com.rameses.rcp.control.XCheckBox();

        xFormPanel1.setCaption("General Info");
        com.rameses.rcp.control.border.XTitledBorder xTitledBorder1 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder1.setPadding(new java.awt.Insets(25, 15, 15, 20));
        xTitledBorder1.setTitle("General Info");
        xFormPanel1.setBorder(xTitledBorder1);
        xFormPanel1.setCaptionVAlignment(com.rameses.rcp.constant.UIConstants.CENTER);
        xFormPanel1.setCaptionWidth(150);

        xTextField1.setCaption("Code");
        xTextField1.setDisableWhen("#{ mode != 'create' }");
        xTextField1.setName("entity.objid"); // NOI18N
        xTextField1.setRequired(true);
        xTextField1.setSpaceChar('_');
        xFormPanel1.add(xTextField1);

        xTextField2.setCaption("Title");
        xTextField2.setName("entity.title"); // NOI18N
        xTextField2.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField2.setRequired(true);
        xTextField2.setTextCase(com.rameses.rcp.constant.TextCase.NONE);
        xFormPanel1.add(xTextField2);

        xLookupField1.setCaption("Org");
        xLookupField1.setExpression("#{ entity.org.name }");
        xLookupField1.setHandler("org:lookup");
        xLookupField1.setName("entity.org"); // NOI18N
        xLookupField1.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLookupField1);

        xComboBox1.setCaption("Activation State");
        xComboBox1.setItems("workflowStates");
        xComboBox1.setName("entity.activationstate"); // NOI18N
        xComboBox1.setDynamic(true);
        xComboBox1.setPreferredSize(new java.awt.Dimension(150, 22));
        xComboBox1.setRequired(true);
        xFormPanel1.add(xComboBox1);

        xComboBox3.setCaption("Validation State");
        xComboBox3.setItems("workflowStates");
        xComboBox3.setName("entity.validationstate"); // NOI18N
        xComboBox3.setDynamic(true);
        xComboBox3.setPreferredSize(new java.awt.Dimension(150, 22));
        xComboBox3.setRequired(true);
        xFormPanel1.add(xComboBox3);

        xIntegerField1.setCaption("Sort Index");
        xIntegerField1.setName("entity.sortindex"); // NOI18N
        xIntegerField1.setPreferredSize(new java.awt.Dimension(50, 20));
        xIntegerField1.setRequired(true);
        xFormPanel1.add(xIntegerField1);

        xTextField3.setCaption("Role");
        xTextField3.setName("entity.role"); // NOI18N
        xTextField3.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField3.setSpaceChar('_');
        xFormPanel1.add(xTextField3);

        xComboBox4.setCaption("Associated Permit");
        xComboBox4.setExpression("#{ item.objid }");
        xComboBox4.setItems("permitTypes");
        xComboBox4.setName("entity.permittype"); // NOI18N
        xComboBox4.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xComboBox4.setPreferredSize(new java.awt.Dimension(0, 22));
        xFormPanel1.add(xComboBox4);

        xLabel1.setCaption("Permit Type");
        xLabel1.setDepends(new String[] {"entity.permittype"});
        xLabel1.setExpression("#{ entity.permittype.type }");
        xFormPanel1.add(xLabel1);

        xCheckBox2.setCaption("");
        xCheckBox2.setCheckValue(1);
        xCheckBox2.setDisableWhen("#{ mode == 'read' }");
        xCheckBox2.setName("entity.allowassessment"); // NOI18N
        xCheckBox2.setUncheckValue(0);
        xCheckBox2.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xCheckBox2.setShowCaption(false);
        xCheckBox2.setText("Allow Assessment");
        xCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xCheckBox2ActionPerformed(evt);
            }
        });
        xFormPanel1.add(xCheckBox2);

        xCheckBox3.setCaption("");
        xCheckBox3.setCheckValue(1);
        xCheckBox3.setDisableWhen("#{ mode == 'read' }");
        xCheckBox3.setName("entity.issuepermit"); // NOI18N
        xCheckBox3.setUncheckValue(0);
        xCheckBox3.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xCheckBox3.setShowCaption(false);
        xCheckBox3.setText("Issue Permit");
        xCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xCheckBox3ActionPerformed(evt);
            }
        });
        xFormPanel1.add(xCheckBox3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void xCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xCheckBox2ActionPerformed

    private void xCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xCheckBox3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.rcp.control.XCheckBox xCheckBox2;
    private com.rameses.rcp.control.XCheckBox xCheckBox3;
    private com.rameses.rcp.control.XComboBox xComboBox1;
    private com.rameses.rcp.control.XComboBox xComboBox3;
    private com.rameses.rcp.control.XComboBox xComboBox4;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XIntegerField xIntegerField1;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLookupField xLookupField1;
    private com.rameses.rcp.control.XTextField xTextField1;
    private com.rameses.rcp.control.XTextField xTextField2;
    private com.rameses.rcp.control.XTextField xTextField3;
    // End of variables declaration//GEN-END:variables
}
