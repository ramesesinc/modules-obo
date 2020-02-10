/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.views;

import com.rameses.rcp.ui.annotations.Template;
import com.rameses.seti2.views.CrudFormPage;

/**
 *
 * @author dell
 */
@Template(CrudFormPage.class)
public class OboVariablePage extends javax.swing.JPanel {

    /**
     * Creates new form OboVariableInfoPage
     */
    public OboVariablePage() {
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

        formPanel1 = new com.rameses.rcp.util.FormPanel();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        xTextField1 = new com.rameses.rcp.control.XTextField();
        xTextField2 = new com.rameses.rcp.control.XTextField();
        xTextField3 = new com.rameses.rcp.control.XTextField();
        xTextField4 = new com.rameses.rcp.control.XTextField();
        xComboBox1 = new com.rameses.rcp.control.XComboBox();
        xIntegerField1 = new com.rameses.rcp.control.XIntegerField();
        xTextField5 = new com.rameses.rcp.control.XTextField();
        xLookupField1 = new com.rameses.rcp.control.XLookupField();
        xTextField6 = new com.rameses.rcp.control.XTextField();

        formPanel1.setCaptionWidth(130);
        formPanel1.setPadding(new java.awt.Insets(5, 5, 5, 0));

        xLabel1.setCaption("Type");
        xLabel1.setExpression("#{ entity.typeid }");
        xLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel1.setPreferredSize(new java.awt.Dimension(0, 20));
        formPanel1.add(xLabel1);

        xTextField1.setCaption("Name");
        xTextField1.setName("entity.name"); // NOI18N
        xTextField1.setPreferredSize(new java.awt.Dimension(0, 19));
        xTextField1.setRequired(true);
        xTextField1.setSpaceChar('_');
        formPanel1.add(xTextField1);

        xTextField2.setName("entity.caption"); // NOI18N
        xTextField2.setPreferredSize(new java.awt.Dimension(0, 19));
        xTextField2.setRequired(true);
        xTextField2.setTextCase(com.rameses.rcp.constant.TextCase.NONE);
        formPanel1.add(xTextField2);

        xTextField3.setCaption("Description");
        xTextField3.setName("entity.description"); // NOI18N
        xTextField3.setPreferredSize(new java.awt.Dimension(0, 19));
        xTextField3.setTextCase(com.rameses.rcp.constant.TextCase.NONE);
        formPanel1.add(xTextField3);

        xTextField4.setCaption("Unit of Measure");
        xTextField4.setName("entity.unit"); // NOI18N
        xTextField4.setPreferredSize(new java.awt.Dimension(80, 20));
        xTextField4.setRequired(true);
        xTextField4.setTextCase(com.rameses.rcp.constant.TextCase.NONE);
        formPanel1.add(xTextField4);

        xComboBox1.setCaption("Data Type");
        xComboBox1.setItems("datatypes");
        xComboBox1.setName("entity.datatype"); // NOI18N
        xComboBox1.setPreferredSize(new java.awt.Dimension(170, 22));
        xComboBox1.setRequired(true);
        formPanel1.add(xComboBox1);

        xIntegerField1.setCaption("Sort order");
        xIntegerField1.setName("entity.sortorder"); // NOI18N
        xIntegerField1.setRequired(true);
        formPanel1.add(xIntegerField1);

        xTextField5.setCaption("Category");
        xTextField5.setName("entity.category"); // NOI18N
        xTextField5.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField5.setTextCase(com.rameses.rcp.constant.TextCase.NONE);
        formPanel1.add(xTextField5);

        xLookupField1.setCaption("Classification");
        xLookupField1.setExpression("#{entity.classification.title}");
        xLookupField1.setHandler("lookupClassifcations");
        xLookupField1.setName("entity.classification"); // NOI18N
        xLookupField1.setPreferredSize(new java.awt.Dimension(0, 20));
        formPanel1.add(xLookupField1);

        xTextField6.setCaption("Occupancy Type");
        xTextField6.setDisableWhen("");
        xTextField6.setName("entity.occupancytypeid"); // NOI18N
        xTextField6.setVisibleWhen("#{ entity.type != 'ACCESSORIES' }");
        xTextField6.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField6.setTextCase(com.rameses.rcp.constant.TextCase.NONE);
        formPanel1.add(xTextField6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.rcp.util.FormPanel formPanel1;
    private com.rameses.rcp.control.XComboBox xComboBox1;
    private com.rameses.rcp.control.XIntegerField xIntegerField1;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLookupField xLookupField1;
    private com.rameses.rcp.control.XTextField xTextField1;
    private com.rameses.rcp.control.XTextField xTextField2;
    private com.rameses.rcp.control.XTextField xTextField3;
    private com.rameses.rcp.control.XTextField xTextField4;
    private com.rameses.rcp.control.XTextField xTextField5;
    private com.rameses.rcp.control.XTextField xTextField6;
    // End of variables declaration//GEN-END:variables
}
