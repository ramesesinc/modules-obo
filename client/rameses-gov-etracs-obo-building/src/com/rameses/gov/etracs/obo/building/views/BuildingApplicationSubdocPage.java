/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.building.views;

import com.rameses.rcp.ui.annotations.Template;
import com.rameses.seti2.views.CrudFormPage;

/**
 *
 * @author elmonazareno
 */
@Template(CrudFormPage.class)
public class BuildingApplicationSubdocPage extends javax.swing.JPanel {

    /**
     * Creates new form BuildingPermitAncillaryPage
     */
    public BuildingApplicationSubdocPage() {
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

        xTabbedPane1 = new com.rameses.rcp.control.XTabbedPane();
        xPanel2 = new com.rameses.rcp.control.XPanel();
        applicationInfoList1 = new com.rameses.gov.etracs.obo.components.ApplicationInfoList();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        applicationFeeList1 = new com.rameses.gov.etracs.obo.components.ApplicationFeeList();
        xPanel3 = new com.rameses.rcp.control.XPanel();
        applicationChecklist1 = new com.rameses.gov.etracs.obo.components.ApplicationChecklist();
        jPanel1 = new javax.swing.JPanel();
        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xLabel9 = new com.rameses.rcp.control.XLabel();
        xLabel8 = new com.rameses.rcp.control.XLabel();
        xLabel7 = new com.rameses.rcp.control.XLabel();
        xLabel4 = new com.rameses.rcp.control.XLabel();
        xLabel5 = new com.rameses.rcp.control.XLabel();
        xLabel10 = new com.rameses.rcp.control.XLabel();
        xLabel11 = new com.rameses.rcp.control.XLabel();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xLabel12 = new com.rameses.rcp.control.XLabel();
        xLabel15 = new com.rameses.rcp.control.XLabel();
        xLabel16 = new com.rameses.rcp.control.XLabel();
        xLabel17 = new com.rameses.rcp.control.XLabel();
        xLabel14 = new com.rameses.rcp.control.XLabel();
        xLabel18 = new com.rameses.rcp.control.XLabel();
        xLabel13 = new com.rameses.rcp.control.XLabel();
        xPanel4 = new com.rameses.rcp.control.XPanel();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        xList1 = new com.rameses.rcp.control.XList();

        setPreferredSize(new java.awt.Dimension(809, 488));
        setLayout(new java.awt.BorderLayout());

        xPanel2.setVisibleWhen("#{ showInfos == true }");
        xPanel2.setLayout(new java.awt.BorderLayout());

        applicationInfoList1.setAppid("entity.appid");
        applicationInfoList1.setEditableWhen("#{ editable }");
        applicationInfoList1.setHandler("infoHandler");
        applicationInfoList1.setParentid("entity.objid");
        applicationInfoList1.setSchemaName("vw_building_application_info");
        xPanel2.add(applicationInfoList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Infos", xPanel2);

        xPanel1.setVisibleWhen("#{ showFees == true }");
        xPanel1.setLayout(new java.awt.BorderLayout());

        applicationFeeList1.setAppid("entity.appid");
        applicationFeeList1.setEditableWhen("#{ editable }");
        applicationFeeList1.setEntitySchemaName("building_application_fee");
        applicationFeeList1.setHandler("feeHandler");
        applicationFeeList1.setParentid("entity.objid");
        applicationFeeList1.setSchemaName("vw_building_application_fee");
        xPanel1.add(applicationFeeList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Fees", xPanel1);

        xPanel3.setVisibleWhen("#{ showChecklist == true }");
        xPanel3.setLayout(new java.awt.BorderLayout());

        applicationChecklist1.setAppid("entity.appid");
        applicationChecklist1.setDoctypeid("entity.doctypeid");
        applicationChecklist1.setEditableWhen("#{ editable }");
        applicationChecklist1.setHandler("checklistHandler");
        applicationChecklist1.setParentid("entity.objid");
        applicationChecklist1.setSchemaName("building_application_checklist_item");
        xPanel3.add(applicationChecklist1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Checklist Items", xPanel3);

        add(xTabbedPane1, java.awt.BorderLayout.CENTER);

        com.rameses.rcp.control.border.XTitledBorder xTitledBorder1 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder1.setTitle("General Info");
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5), xTitledBorder1));
        jPanel1.setPreferredSize(new java.awt.Dimension(766, 220));

        xFormPanel1.setCaptionWidth(100);

        xLabel9.setCaption("Doc Type");
        xLabel9.setExpression("#{entity.doctype.title}");
        xLabel9.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel9);

        xLabel8.setCaption("Control No");
        xLabel8.setExpression("#{entity.controlno}");
        xLabel8.setVisibleWhen("#{ entity.issuanceid !=null }");
        xLabel8.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel8);

        xLabel7.setCaption("Date Issued");
        xLabel7.setExpression("#{entity.dtissued}");
        xLabel7.setVisibleWhen("#{ entity.issuanceid !=null }");
        xLabel7.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel7);

        xLabel4.setCaption("Issued by");
        xLabel4.setExpression("#{entity.issuedby.name}");
        xLabel4.setVisibleWhen("#{ entity.issuanceid !=null }");
        xLabel4.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel4);

        xLabel5.setCaption("Expiry date");
        xLabel5.setExpression("#{entity.expirydate}");
        xLabel5.setVisibleWhen("#{ entity.issuanceid !=null }");
        xLabel5.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel5);

        xLabel10.setCaption("Design Prof");
        xLabel10.setExpression("#{entity.designprofessional.name}");
        xLabel10.setVisibleWhen("#{ showProfessionals == true }");
        xLabel10.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel10);

        xLabel11.setCaption("Super. In Charge");
        xLabel11.setExpression("#{entity.supervisor.name}");
        xLabel11.setVisibleWhen("#{ showProfessionals == true }");
        xLabel11.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel11);

        xFormPanel2.setCaptionWidth(120);

        xLabel12.setCaption("App No");
        xLabel12.setExpression("#{entity.app.appno}");
        xLabel12.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel12);

        xLabel15.setCaption("Project Title");
        xLabel15.setExpression("#{entity.app.title}");
        xLabel15.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel15);

        xLabel16.setCaption("Location");
        xLabel16.setExpression("#{entity.app.location.text}");
        xLabel16.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel16);

        xLabel17.setCaption("Applicant");
        xLabel17.setExpression("#{entity.app.applicant.name}");
        xLabel17.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel17);

        xLabel14.setCaption("Occupancy Type");
        xLabel14.setExpression("#{entity.occupancytypeid}");
        xLabel14.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel14);

        xLabel18.setCaption("Project Cost");
        xLabel18.setExpression("#{entity.app.projectcost}");
        xLabel18.setNumberFormat("#,##0.00");
        xLabel18.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel18);

        xLabel13.setCaption("Remarks");
        xLabel13.setExpression("#{entity.remarks}");
        xLabel13.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel13);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(xFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(81, 81, 81))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        xPanel4.setVisibleWhen("#{ showOtherDocs == true }");
        xPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        xPanel4.setPreferredSize(new java.awt.Dimension(200, 100));

        xLabel1.setText("Other Related Documents");

        xList1.setExpression("#{ item.doctype.title }");
        xList1.setItems("docList");
        xList1.setName("selectedDoc"); // NOI18N
        jScrollPane1.setViewportView(xList1);

        javax.swing.GroupLayout xPanel4Layout = new javax.swing.GroupLayout(xPanel4);
        xPanel4.setLayout(xPanel4Layout);
        xPanel4Layout.setHorizontalGroup(
            xPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(xPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(xPanel4Layout.createSequentialGroup()
                        .addComponent(xLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        xPanel4Layout.setVerticalGroup(
            xPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(xPanel4, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.gov.etracs.obo.components.ApplicationChecklist applicationChecklist1;
    private com.rameses.gov.etracs.obo.components.ApplicationFeeList applicationFeeList1;
    private com.rameses.gov.etracs.obo.components.ApplicationInfoList applicationInfoList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLabel xLabel10;
    private com.rameses.rcp.control.XLabel xLabel11;
    private com.rameses.rcp.control.XLabel xLabel12;
    private com.rameses.rcp.control.XLabel xLabel13;
    private com.rameses.rcp.control.XLabel xLabel14;
    private com.rameses.rcp.control.XLabel xLabel15;
    private com.rameses.rcp.control.XLabel xLabel16;
    private com.rameses.rcp.control.XLabel xLabel17;
    private com.rameses.rcp.control.XLabel xLabel18;
    private com.rameses.rcp.control.XLabel xLabel4;
    private com.rameses.rcp.control.XLabel xLabel5;
    private com.rameses.rcp.control.XLabel xLabel7;
    private com.rameses.rcp.control.XLabel xLabel8;
    private com.rameses.rcp.control.XLabel xLabel9;
    private com.rameses.rcp.control.XList xList1;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XPanel xPanel3;
    private com.rameses.rcp.control.XPanel xPanel4;
    private com.rameses.rcp.control.XTabbedPane xTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
