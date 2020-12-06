/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.occupancy.views;

import com.rameses.rcp.ui.annotations.Template;
import com.rameses.seti2.views.WorkflowTaskFormPage;

/**
 *
 * @author elmonazareno
 */
@Template(WorkflowTaskFormPage.class)
public class OccupancyInspectionPage extends javax.swing.JPanel {

    /**
     * Creates new form OboBuildingSubapplicationPage
     */
    public OccupancyInspectionPage() {
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xLabel8 = new com.rameses.rcp.control.XLabel();
        xLabel7 = new com.rameses.rcp.control.XLabel();
        xLabel4 = new com.rameses.rcp.control.XLabel();
        xLabel2 = new com.rameses.rcp.control.XLabel();
        xLabel9 = new com.rameses.rcp.control.XLabel();
        xLabel10 = new com.rameses.rcp.control.XLabel();
        xLabel15 = new com.rameses.rcp.control.XLabel();
        xLabel16 = new com.rameses.rcp.control.XLabel();
        xLabel20 = new com.rameses.rcp.control.XLabel();
        xLabel21 = new com.rameses.rcp.control.XLabel();
        xFormPanel3 = new com.rameses.rcp.control.XFormPanel();
        xLabel5 = new com.rameses.rcp.control.XLabel();
        xLabel12 = new com.rameses.rcp.control.XLabel();
        xLabel14 = new com.rameses.rcp.control.XLabel();
        xLabel13 = new com.rameses.rcp.control.XLabel();
        xLabel17 = new com.rameses.rcp.control.XLabel();
        jPanel3 = new javax.swing.JPanel();
        applicationDocumentList1 = new com.rameses.gov.etracs.obo.components.ApplicationDocumentList();
        xPanel2 = new com.rameses.rcp.control.XPanel();
        applicationFindingList2 = new com.rameses.gov.etracs.obo.components.ApplicationFindingList();
        xActionBar4 = new com.rameses.rcp.control.XActionBar();

        setPreferredSize(new java.awt.Dimension(909, 627));
        setLayout(new java.awt.BorderLayout());

        xTabbedPane1.setItems("sections");
        xTabbedPane1.setDynamic(true);

        jPanel1.setName("sections"); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        com.rameses.rcp.control.border.XTitledBorder xTitledBorder1 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder1.setPadding(new java.awt.Insets(20, 10, 10, 10));
        xTitledBorder1.setTitle("Project Information");
        xFormPanel1.setBorder(xTitledBorder1);
        xFormPanel1.setCaptionWidth(180);

        xLabel8.setCaption("Project Title");
        xLabel8.setExpression("<html>#{entity.app.title}</html>");
        xLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel8.setPreferredSize(new java.awt.Dimension(0, 40));
        xFormPanel1.add(xLabel8);

        xLabel7.setCaption("Project Description");
        xLabel7.setExpression("<html>#{entity.app.description}</html>");
        xLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel7.setPreferredSize(new java.awt.Dimension(0, 40));
        xFormPanel1.add(xLabel7);

        xLabel4.setCaption("Applicant");
        xLabel4.setExpression("#{entity.app.applicant.name}");
        xLabel4.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel4);

        xLabel2.setCaption("Occupancy Type");
        xLabel2.setExpression("<html>#{entity.app.occupancytype.title}</html>");
        xLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel2.setPreferredSize(new java.awt.Dimension(0, 60));
        xFormPanel1.add(xLabel2);

        xLabel9.setCaption("Project Cost");
        xLabel9.setExpression("#{entity.app.projectcost}");
        xLabel9.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel9.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel9);

        xLabel10.setCaption("Fixed Cost (computed)");
        xLabel10.setExpression("#{entity.app.fixedcost}");
        xLabel10.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel10);

        xLabel15.setCaption("Proposed Const. Date");
        xLabel15.setExpression("#{entity.app.dtproposedconstruction}");
        xLabel15.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel15.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel15);

        xLabel16.setCaption("Est. Completion Date");
        xLabel16.setExpression("#{entity.app.dtexpectedcompletion}");
        xLabel16.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel16);

        xLabel20.setCaption("Zone");
        xLabel20.setExpression("#{entity.app.zone}");
        xLabel20.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel20.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel20);

        xLabel21.setCaption("Zone Class");
        xLabel21.setExpression("#{entity.app.zoneclass.title}");
        xLabel21.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel21);

        xFormPanel3.setCaption("");
        com.rameses.rcp.control.border.XTitledBorder xTitledBorder2 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder2.setPadding(new java.awt.Insets(20, 10, 10, 10));
        xTitledBorder2.setTitle("Application");
        xFormPanel3.setBorder(xTitledBorder2);
        xFormPanel3.setCaptionWidth(120);
        xFormPanel3.setPreferredSize(new java.awt.Dimension(0, 100));

        xLabel5.setCaption("App No");
        xLabel5.setExpression("#{entity.app.appno}");
        xLabel5.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel5);

        xLabel12.setCaption("App Date");
        xLabel12.setExpression("#{entity.app.dtfiled}");
        xLabel12.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel12);

        xLabel14.setCaption("App Type");
        xLabel14.setExpression("#{entity.app.apptype}");
        xLabel14.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel14);

        xLabel13.setCaption("Task State");
        xLabel13.setExpression("#{entity.task.state}");
        xLabel13.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel13);

        xLabel17.setCaption("Section");
        xLabel17.setExpression("#{entity.sectionid}");
        xLabel17.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel17.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel17);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xFormPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                    .addComponent(xFormPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("General Info", jPanel1);

        jPanel3.setLayout(new java.awt.BorderLayout());

        applicationDocumentList1.setAppid("entity.appid");
        applicationDocumentList1.setApptype("occupancy");
        applicationDocumentList1.setEditableWhen("#{ canEdit == true }");
        applicationDocumentList1.setEntitySchemaName("occupancy_permit_doc");
        applicationDocumentList1.setHandler("docHandler");
        applicationDocumentList1.setSchemaName("vw_occupancy_permit_doc");
        applicationDocumentList1.setSectionid("entity.sectionid");
        jPanel3.add(applicationDocumentList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Documents", jPanel3);

        xPanel2.setLayout(new java.awt.BorderLayout());

        applicationFindingList2.setAppid("entity.appid");
        applicationFindingList2.setEditableWhen("#{ canEdit == true }");
        applicationFindingList2.setParentid("entity.objid");
        applicationFindingList2.setSchemaName("occupancy_inspection_finding");
        applicationFindingList2.setSectionTitle("entity.type.title");
        xPanel2.add(applicationFindingList2, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Findings", xPanel2);

        add(xTabbedPane1, java.awt.BorderLayout.CENTER);

        xActionBar4.setFormName("formName");
        xActionBar4.setName("extActions"); // NOI18N
        xActionBar4.setUseToolBar(false);
        add(xActionBar4, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.gov.etracs.obo.components.ApplicationDocumentList applicationDocumentList1;
    private com.rameses.gov.etracs.obo.components.ApplicationFindingList applicationFindingList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.rameses.rcp.control.XActionBar xActionBar4;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XFormPanel xFormPanel3;
    private com.rameses.rcp.control.XLabel xLabel10;
    private com.rameses.rcp.control.XLabel xLabel12;
    private com.rameses.rcp.control.XLabel xLabel13;
    private com.rameses.rcp.control.XLabel xLabel14;
    private com.rameses.rcp.control.XLabel xLabel15;
    private com.rameses.rcp.control.XLabel xLabel16;
    private com.rameses.rcp.control.XLabel xLabel17;
    private com.rameses.rcp.control.XLabel xLabel2;
    private com.rameses.rcp.control.XLabel xLabel20;
    private com.rameses.rcp.control.XLabel xLabel21;
    private com.rameses.rcp.control.XLabel xLabel4;
    private com.rameses.rcp.control.XLabel xLabel5;
    private com.rameses.rcp.control.XLabel xLabel7;
    private com.rameses.rcp.control.XLabel xLabel8;
    private com.rameses.rcp.control.XLabel xLabel9;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XTabbedPane xTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
