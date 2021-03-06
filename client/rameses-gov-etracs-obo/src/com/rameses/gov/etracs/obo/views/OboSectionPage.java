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
public class OboSectionPage extends javax.swing.JPanel {

    /**
     * Creates new form OboSectionPage
     */
    public OboSectionPage() {
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
        xLabel1 = new com.rameses.rcp.control.XLabel();
        xTextField2 = new com.rameses.rcp.control.XTextField();
        xTextField1 = new com.rameses.rcp.control.XTextField();
        xLookupField1 = new com.rameses.rcp.control.XLookupField();

        xLabel1.setCaption("ID");
        xLabel1.setExpression("#{ entity.objid }");
        xLabel1.setVisibleWhen("#{ mode != 'create' }");
        xLabel1.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel1);

        xTextField2.setCaption("ID");
        xTextField2.setName("entity.objid"); // NOI18N
        xTextField2.setVisibleWhen("#{ mode == 'create' }");
        xTextField2.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xTextField2);

        xTextField1.setCaption("Title");
        xTextField1.setName("entity.title"); // NOI18N
        xTextField1.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xTextField1);

        xLookupField1.setCaption("Org");
        xLookupField1.setExpression("#{ entity.org.name }");
        xLookupField1.setHandler("org:lookup");
        xLookupField1.setName("entity.org"); // NOI18N
        xLookupField1.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLookupField1.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLookupField1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLookupField xLookupField1;
    private com.rameses.rcp.control.XTextField xTextField1;
    private com.rameses.rcp.control.XTextField xTextField2;
    // End of variables declaration//GEN-END:variables
}
