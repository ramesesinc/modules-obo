/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.building.views;

import com.rameses.osiris2.themes.FormPage;
import com.rameses.rcp.ui.annotations.StyleSheet;
import com.rameses.rcp.ui.annotations.Template;

/**
 *
 * @author elmonazareno
 */
@Template(FormPage.class)
@StyleSheet
public class BuildingApplicationEditPage extends javax.swing.JPanel {

    /**
     * Creates new form BuildingApplicationCapturePage
     */
    public BuildingApplicationEditPage() {
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
        xLabel7 = new com.rameses.rcp.control.XLabel();
        xTextField1 = new com.rameses.rcp.control.XTextField();
        xTextField2 = new com.rameses.rcp.control.XTextField();
        pnlLocation = new com.rameses.rcp.control.XPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        xTextArea1 = new com.rameses.rcp.control.XTextArea();
        jPanel1 = new javax.swing.JPanel();
        xButton3 = new com.rameses.rcp.control.XButton();
        xPanel2 = new com.rameses.rcp.control.XPanel();
        xLabel5 = new com.rameses.rcp.control.XLabel();
        xButton2 = new com.rameses.rcp.control.XButton();
        xIntegerField1 = new com.rameses.rcp.control.XIntegerField();
        xIntegerField2 = new com.rameses.rcp.control.XIntegerField();
        xDecimalField1 = new com.rameses.rcp.control.XDecimalField();
        xDecimalField2 = new com.rameses.rcp.control.XDecimalField();
        xDecimalField3 = new com.rameses.rcp.control.XDecimalField();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        xButton1 = new com.rameses.rcp.control.XButton();
        xLookupField3 = new com.rameses.rcp.control.XLookupField();
        xDateField1 = new com.rameses.rcp.control.XDateField();
        xDateField2 = new com.rameses.rcp.control.XDateField();
        xLookupField1 = new com.rameses.rcp.control.XLookupField();
        xLabel3 = new com.rameses.rcp.control.XLabel();
        xLabel21 = new com.rameses.rcp.control.XLabel();
        xLabel4 = new com.rameses.rcp.control.XLabel();
        xTextField8 = new com.rameses.rcp.control.XTextField();
        xLookupField2 = new com.rameses.rcp.control.XLookupField();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xLabel8 = new com.rameses.rcp.control.XLabel();
        xTextField6 = new com.rameses.rcp.control.XTextField();
        xLabel2 = new com.rameses.rcp.control.XLabel();
        xTextField10 = new com.rameses.rcp.control.XTextField();
        xLabel6 = new com.rameses.rcp.control.XLabel();
        xComboBox1 = new com.rameses.rcp.control.XComboBox();
        xComboBox2 = new com.rameses.rcp.control.XComboBox();
        xDateField5 = new com.rameses.rcp.control.XDateField();
        xTextField3 = new com.rameses.rcp.control.XTextField();
        xTextField4 = new com.rameses.rcp.control.XTextField();
        xTextField5 = new com.rameses.rcp.control.XTextField();
        xLabel9 = new com.rameses.rcp.control.XLabel();
        xTextField7 = new com.rameses.rcp.control.XTextField();
        xDateField3 = new com.rameses.rcp.control.XDateField();
        xDateField4 = new com.rameses.rcp.control.XDateField();
        xTextField9 = new com.rameses.rcp.control.XTextField();
        xDateField7 = new com.rameses.rcp.control.XDateField();
        xDecimalField4 = new com.rameses.rcp.control.XDecimalField();

        xFormPanel1.setCaptionWidth(190);

        xLabel7.setCaption("");
        xLabel7.setExpression("Project Info");
        xLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        xLabel7.setShowCaption(false);
        xFormPanel1.add(xLabel7);

        xTextField1.setCaption("Project Title");
        xTextField1.setName("entity.title"); // NOI18N
        xTextField1.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField1.setRequired(true);
        xFormPanel1.add(xTextField1);

        xTextField2.setCaption("Project Description");
        xTextField2.setName("entity.description"); // NOI18N
        xTextField2.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField2.setRequired(true);
        xFormPanel1.add(xTextField2);

        pnlLocation.setCaption("Location");
        pnlLocation.setPreferredSize(new java.awt.Dimension(0, 60));
        pnlLocation.setLayout(new java.awt.BorderLayout());

        xTextArea1.setCaption("Location");
        xTextArea1.setName("entity.location.text"); // NOI18N
        xTextArea1.setRequired(true);
        jScrollPane1.setViewportView(xTextArea1);

        pnlLocation.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(30, 112));

        xButton3.setName("viewLocation"); // NOI18N
        xButton3.setIconResource("images/toolbars/edit.png");
        xButton3.setImmediate(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(xButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(xButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        pnlLocation.add(jPanel1, java.awt.BorderLayout.EAST);

        xFormPanel1.add(pnlLocation);

        xPanel2.setCaption("Applicant");
        xPanel2.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xPanel2.setPreferredSize(new java.awt.Dimension(0, 29));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0);
        flowLayout2.setAlignOnBaseline(true);
        xPanel2.setLayout(flowLayout2);

        xLabel5.setCaption("Applicant");
        xLabel5.setExpression("#{ entity.applicant.name }");
        xLabel5.setName("entity.applicant"); // NOI18N
        xLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel5.setPreferredSize(new java.awt.Dimension(280, 25));
        xPanel2.add(xLabel5);

        xButton2.setName("lookupApplicant"); // NOI18N
        xButton2.setIconResource("images/buttons/search.png");
        xButton2.setImmediate(true);
        xButton2.setPreferredSize(new java.awt.Dimension(30, 29));
        xButton2.setTarget("");
        xPanel2.add(xButton2);

        xFormPanel1.add(xPanel2);

        xIntegerField1.setCaption("No. of Units");
        xIntegerField1.setName("entity.numunits"); // NOI18N
        xIntegerField1.setRequired(true);
        xFormPanel1.add(xIntegerField1);

        xIntegerField2.setCaption("No. of Floors");
        xIntegerField2.setName("entity.numfloors"); // NOI18N
        xIntegerField2.setRequired(true);
        xFormPanel1.add(xIntegerField2);

        xDecimalField1.setCaption("Total Floor Area (sqm)");
        xDecimalField1.setName("entity.totalfloorarea"); // NOI18N
        xDecimalField1.setRequired(true);
        xFormPanel1.add(xDecimalField1);

        xDecimalField2.setCaption("Bldg Height (m)");
        xDecimalField2.setName("entity.height"); // NOI18N
        xDecimalField2.setRequired(true);
        xFormPanel1.add(xDecimalField2);

        xDecimalField3.setCaption("Project Cost");
        xDecimalField3.setName("entity.projectcost"); // NOI18N
        xDecimalField3.setCellPadding(new java.awt.Insets(5, 0, 0, 0));
        xDecimalField3.setPreferredSize(new java.awt.Dimension(180, 20));
        xDecimalField3.setRequired(true);
        xFormPanel1.add(xDecimalField3);

        xPanel1.setCaption("Work Types ");
        xPanel1.setPreferredSize(new java.awt.Dimension(0, 29));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0);
        flowLayout1.setAlignOnBaseline(true);
        xPanel1.setLayout(flowLayout1);

        xLabel1.setExpression("#{ entity.worktypes?.join(',') }");
        xLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel1.setPreferredSize(new java.awt.Dimension(280, 25));
        xPanel1.add(xLabel1);

        xButton1.setName("selectWorkTypes"); // NOI18N
        xButton1.setIconResource("images/buttons/search.png");
        xButton1.setImmediate(true);
        xButton1.setPreferredSize(new java.awt.Dimension(30, 29));
        xPanel1.add(xButton1);

        xFormPanel1.add(xPanel1);

        xLookupField3.setCaption("Project Supervisor");
        xLookupField3.setExpression("#{ entity.supervisor?.objid == null ? '' : entity.supervisor.lastname + ', ' + entity.supervisor.firstname + '/'+ entity.supervisor.profession + '-PRC No:' + entity.supervisor.prc.idno }");
        xLookupField3.setHandler("obo_professional:lookup");
        xLookupField3.setName("entity.supervisor"); // NOI18N
        xLookupField3.setPreferredSize(new java.awt.Dimension(0, 20));
        xLookupField3.setRequired(true);
        xFormPanel1.add(xLookupField3);

        xDateField1.setCaption("Proposed cons. Date");
        xDateField1.setName("entity.dtproposedconstruction"); // NOI18N
        xDateField1.setPreferredSize(new java.awt.Dimension(180, 20));
        xDateField1.setRequired(true);
        xFormPanel1.add(xDateField1);

        xDateField2.setCaption("Est. Completion Date");
        xDateField2.setName("entity.dtexpectedcompletion"); // NOI18N
        xDateField2.setPreferredSize(new java.awt.Dimension(180, 20));
        xDateField2.setRequired(true);
        xFormPanel1.add(xDateField2);

        xLookupField1.setCaption("Occupancy Type");
        xLookupField1.setExpression("#{ entity.occupancytype.title }");
        xLookupField1.setHandler("vw_obo_occupancy_type:lookup");
        xLookupField1.setName("entity.occupancytype"); // NOI18N
        xLookupField1.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
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

        xLabel4.setCaption("");
        xLabel4.setExpression("Zoning Classification");
        xLabel4.setVisibleWhen("#{ showZoning == true }");
        xLabel4.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        xLabel4.setShowCaption(false);
        xFormPanel1.add(xLabel4);

        xTextField8.setCaption("Zone");
        xTextField8.setName("entity.zone"); // NOI18N
        xTextField8.setVisibleWhen("#{ showZoning == true }");
        xTextField8.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField8.setRequired(true);
        xFormPanel1.add(xTextField8);

        xLookupField2.setCaption("Classification");
        xLookupField2.setExpression("#{ entity.zoneclass.title }");
        xLookupField2.setHandler("obo_zoneclass:lookup");
        xLookupField2.setName("entity.zoneclass"); // NOI18N
        xLookupField2.setVisibleWhen("#{ showZoning == true }");
        xLookupField2.setPreferredSize(new java.awt.Dimension(0, 20));
        xLookupField2.setRequired(true);
        xFormPanel1.add(xLookupField2);

        xFormPanel2.setCaptionWidth(150);

        xLabel8.setCaption("");
        xLabel8.setExpression("Application Info");
        xLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        xLabel8.setShowCaption(false);
        xFormPanel2.add(xLabel8);

        xTextField6.setCaption("App No");
        xTextField6.setName("entity.appno"); // NOI18N
        xTextField6.setVisibleWhen("#{ entity.txnmode == 'CAPTURE' }");
        xTextField6.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xTextField6);

        xLabel2.setCaption("");
        xLabel2.setExpression("Leave this blank to auto generate the app no");
        xLabel2.setName("entity.appno"); // NOI18N
        xLabel2.setVisibleWhen("#{ entity.txnmode == 'CAPTURE' }");
        xFormPanel2.add(xLabel2);

        xTextField10.setCaption("Tracking No");
        xTextField10.setName("entity.trackingno"); // NOI18N
        xTextField10.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xTextField10);

        xLabel6.setCaption("Txn Mode");
        xLabel6.setExpression("#{ entity.txnmode }");
        xLabel6.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel6.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel6);

        xComboBox1.setCaption("Txn Type");
        xComboBox1.setItems("txnTypes");
        xComboBox1.setName("entity.txntype"); // NOI18N
        xComboBox1.setRequired(true);
        xFormPanel2.add(xComboBox1);

        xComboBox2.setCaption("App Type");
        xComboBox2.setItems("appTypes");
        xComboBox2.setName("entity.apptype"); // NOI18N
        xComboBox2.setRequired(true);
        xFormPanel2.add(xComboBox2);

        xDateField5.setCaption("App Date");
        xDateField5.setName("entity.appdate"); // NOI18N
        xDateField5.setVisibleWhen("#{ entity.txnmode == 'CAPTURE' }");
        xDateField5.setPreferredSize(new java.awt.Dimension(120, 20));
        xDateField5.setRequired(true);
        xFormPanel2.add(xDateField5);

        xTextField3.setCaption("Contact Name");
        xTextField3.setName("entity.contact.name"); // NOI18N
        xTextField3.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xTextField3.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField3.setRequired(true);
        xFormPanel2.add(xTextField3);

        xTextField4.setCaption("Contact Email");
        xTextField4.setName("entity.contact.email"); // NOI18N
        xTextField4.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField4.setRequired(true);
        xTextField4.setTextCase(com.rameses.rcp.constant.TextCase.NONE);
        xFormPanel2.add(xTextField4);

        xTextField5.setCaption("Contact Mobile No");
        xTextField5.setName("entity.contact.mobileno"); // NOI18N
        xTextField5.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField5.setRequired(true);
        xFormPanel2.add(xTextField5);

        xLabel9.setCaption("");
        xLabel9.setVisibleWhen("#{ entity.txnmode == 'CAPTURE' && entity.task.state == 'end' }");
        xLabel9.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        xLabel9.setShowCaption(false);
        xLabel9.setText("Building Permit Info");
        xFormPanel2.add(xLabel9);

        xTextField7.setCaption("Permit No");
        xTextField7.setName("entity.permitno"); // NOI18N
        xTextField7.setVisibleWhen("#{ entity.txnmode == 'CAPTURE' && entity.task.state == 'end' }");
        xTextField7.setPreferredSize(new java.awt.Dimension(180, 20));
        xTextField7.setRequired(true);
        xFormPanel2.add(xTextField7);

        xDateField3.setCaption("Date Issued");
        xDateField3.setName("entity.permitdtissued"); // NOI18N
        xDateField3.setVisibleWhen("#{ entity.txnmode == 'CAPTURE' && entity.task.state == 'end' }");
        xDateField3.setPreferredSize(new java.awt.Dimension(180, 20));
        xDateField3.setRequired(true);
        xFormPanel2.add(xDateField3);

        xDateField4.setCaption("Permit Expiry Date");
        xDateField4.setName("entity.permitexpirydate"); // NOI18N
        xDateField4.setVisibleWhen("#{ entity.txnmode == 'CAPTURE' && entity.task.state == 'end' }");
        xDateField4.setPreferredSize(new java.awt.Dimension(180, 20));
        xDateField4.setRequired(true);
        xFormPanel2.add(xDateField4);

        xTextField9.setCaption("Payment Ref No");
        xTextField9.setName("entity.receiptno"); // NOI18N
        xTextField9.setVisibleWhen("#{ entity.txnmode == 'CAPTURE' && entity.task.state == 'end' }");
        xTextField9.setPreferredSize(new java.awt.Dimension(180, 20));
        xTextField9.setRequired(true);
        xFormPanel2.add(xTextField9);

        xDateField7.setCaption("Payment Date");
        xDateField7.setName("entity.receiptdate"); // NOI18N
        xDateField7.setVisibleWhen("#{ entity.txnmode == 'CAPTURE' && entity.task.state == 'end' }");
        xDateField7.setPreferredSize(new java.awt.Dimension(180, 20));
        xDateField7.setRequired(true);
        xFormPanel2.add(xDateField7);

        xDecimalField4.setCaption("Amount Paid");
        xDecimalField4.setName("entity.amtpaid"); // NOI18N
        xDecimalField4.setVisibleWhen("#{ entity.txnmode == 'CAPTURE' && entity.task.state == 'end' }");
        xFormPanel2.add(xDecimalField4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addComponent(xFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.rameses.rcp.control.XPanel pnlLocation;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton2;
    private com.rameses.rcp.control.XButton xButton3;
    private com.rameses.rcp.control.XComboBox xComboBox1;
    private com.rameses.rcp.control.XComboBox xComboBox2;
    private com.rameses.rcp.control.XDateField xDateField1;
    private com.rameses.rcp.control.XDateField xDateField2;
    private com.rameses.rcp.control.XDateField xDateField3;
    private com.rameses.rcp.control.XDateField xDateField4;
    private com.rameses.rcp.control.XDateField xDateField5;
    private com.rameses.rcp.control.XDateField xDateField7;
    private com.rameses.rcp.control.XDecimalField xDecimalField1;
    private com.rameses.rcp.control.XDecimalField xDecimalField2;
    private com.rameses.rcp.control.XDecimalField xDecimalField3;
    private com.rameses.rcp.control.XDecimalField xDecimalField4;
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
    private com.rameses.rcp.control.XLabel xLabel6;
    private com.rameses.rcp.control.XLabel xLabel7;
    private com.rameses.rcp.control.XLabel xLabel8;
    private com.rameses.rcp.control.XLabel xLabel9;
    private com.rameses.rcp.control.XLookupField xLookupField1;
    private com.rameses.rcp.control.XLookupField xLookupField2;
    private com.rameses.rcp.control.XLookupField xLookupField3;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XTextArea xTextArea1;
    private com.rameses.rcp.control.XTextField xTextField1;
    private com.rameses.rcp.control.XTextField xTextField10;
    private com.rameses.rcp.control.XTextField xTextField2;
    private com.rameses.rcp.control.XTextField xTextField3;
    private com.rameses.rcp.control.XTextField xTextField4;
    private com.rameses.rcp.control.XTextField xTextField5;
    private com.rameses.rcp.control.XTextField xTextField6;
    private com.rameses.rcp.control.XTextField xTextField7;
    private com.rameses.rcp.control.XTextField xTextField8;
    private com.rameses.rcp.control.XTextField xTextField9;
    // End of variables declaration//GEN-END:variables
}
