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
public class OboItemAccountPage extends javax.swing.JPanel {

    /**
     * Creates new form BillItemTypePage
     */
    public OboItemAccountPage() {
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
        xIntegerField1 = new com.rameses.rcp.control.XIntegerField();
        xLookupField1 = new com.rameses.rcp.control.XLookupField();
        xLookupField3 = new com.rameses.rcp.control.XLookupField();

        xFormPanel1.setCaptionWidth(150);

        xTextField1.setCaption("Code");
        xTextField1.setDisableWhen("#{ mode != 'create' }");
        xTextField1.setName("entity.objid"); // NOI18N
        xTextField1.setPreferredSize(new java.awt.Dimension(150, 20));
        xTextField1.setRequired(true);
        xFormPanel1.add(xTextField1);

        xTextField2.setCaption("Title");
        xTextField2.setName("entity.title"); // NOI18N
        xTextField2.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField2.setRequired(true);
        xFormPanel1.add(xTextField2);

        xIntegerField1.setCaption("Sort Order");
        xIntegerField1.setName("entity.sortorder"); // NOI18N
        xIntegerField1.setRequired(true);
        xFormPanel1.add(xIntegerField1);

        xLookupField1.setCaption("Item Account");
        xLookupField1.setExpression("#{ entity.item.title }");
        xLookupField1.setHandler("itemaccount:lookup");
        xLookupField1.setName("entity.item"); // NOI18N
        xLookupField1.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLookupField1.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLookupField1);

        xLookupField3.setCaption("Section");
        xLookupField3.setExpression("#{ entity.sectionid }");
        xLookupField3.setHandler("lookupSection");
        xLookupField3.setName("entity.sectionid"); // NOI18N
        xLookupField3.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLookupField3.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLookupField3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XIntegerField xIntegerField1;
    private com.rameses.rcp.control.XLookupField xLookupField1;
    private com.rameses.rcp.control.XLookupField xLookupField3;
    private com.rameses.rcp.control.XTextField xTextField1;
    private com.rameses.rcp.control.XTextField xTextField2;
    // End of variables declaration//GEN-END:variables
}
