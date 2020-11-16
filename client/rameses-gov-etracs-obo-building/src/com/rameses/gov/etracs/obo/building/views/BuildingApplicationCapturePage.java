/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.building.views;

import com.rameses.osiris2.themes.FormPage;
import com.rameses.rcp.ui.annotations.Template;

/**
 *
 * @author elmonazareno
 */
@Template(FormPage.class)
public class BuildingApplicationCapturePage extends javax.swing.JPanel {

    /**
     * Creates new form BuildingApplicationCapturePage
     */
    public BuildingApplicationCapturePage() {
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
        addressEditor1 = new com.rameses.enterprise.components.AddressEditor();
        entityLookup1 = new com.rameses.entity.components.EntityLookup();
        xIntegerField1 = new com.rameses.rcp.control.XIntegerField();
        xIntegerField2 = new com.rameses.rcp.control.XIntegerField();
        xDecimalField1 = new com.rameses.rcp.control.XDecimalField();
        xDecimalField2 = new com.rameses.rcp.control.XDecimalField();
        xDecimalField3 = new com.rameses.rcp.control.XDecimalField();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        xButton1 = new com.rameses.rcp.control.XButton();
        xDateField1 = new com.rameses.rcp.control.XDateField();
        xDateField2 = new com.rameses.rcp.control.XDateField();
        xLookupField1 = new com.rameses.rcp.control.XLookupField();
        xLabel3 = new com.rameses.rcp.control.XLabel();
        xLabel21 = new com.rameses.rcp.control.XLabel();
        xPanel2 = new com.rameses.rcp.control.XPanel();
        xLabel5 = new com.rameses.rcp.control.XLabel();
        xButton2 = new com.rameses.rcp.control.XButton();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xTextField6 = new com.rameses.rcp.control.XTextField();
        xLabel2 = new com.rameses.rcp.control.XLabel();
        xComboBox1 = new com.rameses.rcp.control.XComboBox();
        xComboBox2 = new com.rameses.rcp.control.XComboBox();
        xDateField5 = new com.rameses.rcp.control.XDateField();
        xTextField3 = new com.rameses.rcp.control.XTextField();
        xTextField4 = new com.rameses.rcp.control.XTextField();
        xTextField5 = new com.rameses.rcp.control.XTextField();
        xLabel4 = new com.rameses.rcp.control.XLabel();
        xTextField8 = new com.rameses.rcp.control.XTextField();
        xLookupField2 = new com.rameses.rcp.control.XLookupField();
        xCheckBox1 = new com.rameses.rcp.control.XCheckBox();
        xTextField7 = new com.rameses.rcp.control.XTextField();
        xDateField3 = new com.rameses.rcp.control.XDateField();
        xDateField4 = new com.rameses.rcp.control.XDateField();

        xFormPanel1.setCaptionWidth(190);

        xTextField1.setCaption("Project Title");
        xTextField1.setName("entity.title"); // NOI18N
        xTextField1.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xTextField1);

        xTextField2.setCaption("Project Description");
        xTextField2.setName("entity.description"); // NOI18N
        xTextField2.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xTextField2);

        addressEditor1.setCaption("Project Location");
        addressEditor1.setName("entity.location"); // NOI18N
        addressEditor1.setPreferredSize(new java.awt.Dimension(0, 53));
        xFormPanel1.add(addressEditor1);

        entityLookup1.setCaption("Applicant");
        entityLookup1.setName("entity.applicant"); // NOI18N
        entityLookup1.setPreferredSize(new java.awt.Dimension(0, 20));
        entityLookup1.setRequired(true);
        xFormPanel1.add(entityLookup1);

        xIntegerField1.setCaption("No. of Units");
        xIntegerField1.setName("entity.numunits"); // NOI18N
        xIntegerField1.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xFormPanel1.add(xIntegerField1);

        xIntegerField2.setCaption("No. of Floors");
        xIntegerField2.setName("entity.numfloors"); // NOI18N
        xFormPanel1.add(xIntegerField2);

        xDecimalField1.setCaption("Total Floor Area (sqm)");
        xDecimalField1.setName("entity.totalfloorarea"); // NOI18N
        xFormPanel1.add(xDecimalField1);

        xDecimalField2.setCaption("Bldg Height (m)");
        xDecimalField2.setName("entity.height"); // NOI18N
        xFormPanel1.add(xDecimalField2);

        xDecimalField3.setCaption("Project Cost");
        xDecimalField3.setName("entity.projectcost"); // NOI18N
        xDecimalField3.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xDecimalField3.setPreferredSize(new java.awt.Dimension(180, 20));
        xFormPanel1.add(xDecimalField3);

        xPanel1.setCaption("Work Types ");
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0);
        flowLayout1.setAlignOnBaseline(true);
        xPanel1.setLayout(flowLayout1);

        xLabel1.setExpression("#{ entity.worktypes?.join(',') }");
        xPanel1.add(xLabel1);

        xButton1.setName("selectWorkTypes"); // NOI18N
        xButton1.setImmediate(true);
        xButton1.setPreferredSize(new java.awt.Dimension(30, 29));
        xButton1.setText("...");
        xPanel1.add(xButton1);

        xFormPanel1.add(xPanel1);

        xDateField1.setCaption("Proposed cons. Date");
        xDateField1.setName("entity.dtproposedconstruction"); // NOI18N
        xDateField1.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xDateField1.setPreferredSize(new java.awt.Dimension(180, 20));
        xFormPanel1.add(xDateField1);

        xDateField2.setCaption("Est. Completion Date");
        xDateField2.setName("entity.dtexpectedcompletion"); // NOI18N
        xDateField2.setPreferredSize(new java.awt.Dimension(180, 20));
        xFormPanel1.add(xDateField2);

        xLookupField1.setCaption("Occupancy Type");
        xLookupField1.setExpression("#{ entity.occupancytype.title }");
        xLookupField1.setHandler("vw_obo_occupancy_type:lookup");
        xLookupField1.setName("entity.occupancytype"); // NOI18N
        xLookupField1.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLookupField1.setPreferredSize(new java.awt.Dimension(0, 20));
        xLookupField1.setRequired(true);
        xLookupField1.setToolTipText("");
        xFormPanel1.add(xLookupField1);

        xLabel3.setCaption("Division");
        xLabel3.setDepends(new String[] {"entity.occupancytype"});
        xLabel3.setExpression("#{entity.occupancytype.division.objid}");
        xLabel3.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel3);

        xLabel21.setCaption("Group");
        xLabel21.setDepends(new String[] {"entity.occupancytype"});
        xLabel21.setExpression("#{entity.occupancytype.group.objid}");
        xLabel21.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel21);

        xPanel2.setCaption("Applicant");
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0);
        flowLayout2.setAlignOnBaseline(true);
        xPanel2.setLayout(flowLayout2);

        xLabel5.setCaption("Applicant");
        xLabel5.setExpression("#{ entity.applicant.name }");
        xPanel2.add(xLabel5);

        xButton2.setName("lookupApplicant"); // NOI18N
        xButton2.setIconResource("images/buttons/search.png");
        xButton2.setImmediate(true);
        xButton2.setPreferredSize(new java.awt.Dimension(30, 29));
        xButton2.setTarget("");
        xPanel2.add(xButton2);

        xFormPanel1.add(xPanel2);

        xFormPanel2.setCaptionWidth(140);

        xTextField6.setCaption("App No");
        xTextField6.setName("entity.appno"); // NOI18N
        xTextField6.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xTextField6);

        xLabel2.setCaption("");
        xLabel2.setExpression("Leave this blank to auto generate the app no");
        xFormPanel2.add(xLabel2);

        xComboBox1.setCaption("Txn Type");
        xComboBox1.setItems("txnTypes");
        xComboBox1.setName("entity.txntype"); // NOI18N
        xFormPanel2.add(xComboBox1);

        xComboBox2.setCaption("App Type");
        xComboBox2.setItems("appTypes");
        xComboBox2.setName("entity.apptype"); // NOI18N
        xFormPanel2.add(xComboBox2);

        xDateField5.setCaption("App Date");
        xDateField5.setName("entity.appdate"); // NOI18N
        xDateField5.setPreferredSize(new java.awt.Dimension(120, 20));
        xFormPanel2.add(xDateField5);

        xTextField3.setCaption("Contact Name");
        xTextField3.setName("entity.contact.name"); // NOI18N
        xTextField3.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xTextField3.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xTextField3);

        xTextField4.setCaption("Contact Email");
        xTextField4.setName("entity.contact.email"); // NOI18N
        xTextField4.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField4.setTextCase(com.rameses.rcp.constant.TextCase.NONE);
        xFormPanel2.add(xTextField4);

        xTextField5.setCaption("Contact Mobile No");
        xTextField5.setName("entity.contact.mobileno"); // NOI18N
        xTextField5.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xTextField5);

        xLabel4.setCaption("");
        xLabel4.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel4.setShowCaption(false);
        xLabel4.setText("Zoning Classification");
        xFormPanel2.add(xLabel4);

        xTextField8.setCaption("Zone");
        xTextField8.setName("entity.zone"); // NOI18N
        xTextField8.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField8.setRequired(true);
        xFormPanel2.add(xTextField8);

        xLookupField2.setCaption("Classification");
        xLookupField2.setExpression("#{ entity.zoneclass.title }");
        xLookupField2.setHandler("obo_zoneclass:lookup");
        xLookupField2.setName("entity.zoneclass"); // NOI18N
        xLookupField2.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLookupField2);

        xCheckBox1.setCaption("");
        xCheckBox1.setName("entity.permitissued"); // NOI18N
        xCheckBox1.setVisibleWhen("#{askpermitissued == true }");
        xCheckBox1.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xCheckBox1.setShowCaption(false);
        xCheckBox1.setText("Is Building Permit already issued?");
        xFormPanel2.add(xCheckBox1);

        xTextField7.setCaption("Permit No");
        xTextField7.setDepends(new String[] {"entity.permitissued"});
        xTextField7.setName("entity.permitno"); // NOI18N
        xTextField7.setVisibleWhen("#{ entity.permitissued == true }");
        xTextField7.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xTextField7.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField7.setRequired(true);
        xFormPanel2.add(xTextField7);

        xDateField3.setCaption("Date Issued");
        xDateField3.setDepends(new String[] {"entity.permitissued"});
        xDateField3.setName("entity.permitdtissued"); // NOI18N
        xDateField3.setVisibleWhen("#{ entity.permitissued == true }");
        xDateField3.setPreferredSize(new java.awt.Dimension(180, 20));
        xDateField3.setRequired(true);
        xFormPanel2.add(xDateField3);

        xDateField4.setCaption("Permit Expiry Date");
        xDateField4.setDepends(new String[] {"entity.permitissued"});
        xDateField4.setName("entity.permitexpirydate"); // NOI18N
        xDateField4.setVisibleWhen("#{ entity.permitissued == true }");
        xDateField4.setPreferredSize(new java.awt.Dimension(180, 20));
        xDateField4.setRequired(true);
        xFormPanel2.add(xDateField4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.enterprise.components.AddressEditor addressEditor1;
    private com.rameses.entity.components.EntityLookup entityLookup1;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton2;
    private com.rameses.rcp.control.XCheckBox xCheckBox1;
    private com.rameses.rcp.control.XComboBox xComboBox1;
    private com.rameses.rcp.control.XComboBox xComboBox2;
    private com.rameses.rcp.control.XDateField xDateField1;
    private com.rameses.rcp.control.XDateField xDateField2;
    private com.rameses.rcp.control.XDateField xDateField3;
    private com.rameses.rcp.control.XDateField xDateField4;
    private com.rameses.rcp.control.XDateField xDateField5;
    private com.rameses.rcp.control.XDecimalField xDecimalField1;
    private com.rameses.rcp.control.XDecimalField xDecimalField2;
    private com.rameses.rcp.control.XDecimalField xDecimalField3;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XIntegerField xIntegerField1;
    private com.rameses.rcp.control.XIntegerField xIntegerField2;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLabel xLabel2;
    private com.rameses.rcp.control.XLabel xLabel21;
    private com.rameses.rcp.control.XLabel xLabel3;
    private com.rameses.rcp.control.XLabel xLabel4;
    private com.rameses.rcp.control.XLabel xLabel5;
    private com.rameses.rcp.control.XLookupField xLookupField1;
    private com.rameses.rcp.control.XLookupField xLookupField2;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XTextField xTextField1;
    private com.rameses.rcp.control.XTextField xTextField2;
    private com.rameses.rcp.control.XTextField xTextField3;
    private com.rameses.rcp.control.XTextField xTextField4;
    private com.rameses.rcp.control.XTextField xTextField5;
    private com.rameses.rcp.control.XTextField xTextField6;
    private com.rameses.rcp.control.XTextField xTextField7;
    private com.rameses.rcp.control.XTextField xTextField8;
    // End of variables declaration//GEN-END:variables
}
