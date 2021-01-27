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
public class BuildingPermitDocPage extends javax.swing.JPanel {

    /**
     * Creates new form BuildingPermitAncillaryPage
     */
    public BuildingPermitDocPage() {
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

        xTabbedPane2 = new com.rameses.rcp.control.XTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        xTabbedPane1 = new com.rameses.rcp.control.XTabbedPane();
        xPanel2 = new com.rameses.rcp.control.XPanel();
        applicationInfoList1 = new com.rameses.gov.etracs.obo.components.ApplicationInfoList();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        applicationFeeList1 = new com.rameses.gov.etracs.obo.components.ApplicationFeeList();
        xPanel3 = new com.rameses.rcp.control.XPanel();
        applicationChecklist1 = new com.rameses.gov.etracs.obo.components.ApplicationChecklist();
        jPanel3 = new javax.swing.JPanel();
        xActionBar3 = new com.rameses.rcp.control.XActionBar();
        jPanel1 = new javax.swing.JPanel();
        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xLabel8 = new com.rameses.rcp.control.XLabel();
        xLabel7 = new com.rameses.rcp.control.XLabel();
        xLabel4 = new com.rameses.rcp.control.XLabel();
        xLabel5 = new com.rameses.rcp.control.XLabel();
        xLabel10 = new com.rameses.rcp.control.XLabel();
        xLabel11 = new com.rameses.rcp.control.XLabel();
        xLabel13 = new com.rameses.rcp.control.XLabel();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xLabel9 = new com.rameses.rcp.control.XLabel();
        xLabel12 = new com.rameses.rcp.control.XLabel();
        xLabel15 = new com.rameses.rcp.control.XLabel();
        xLabel16 = new com.rameses.rcp.control.XLabel();
        xLabel17 = new com.rameses.rcp.control.XLabel();
        xLabel14 = new com.rameses.rcp.control.XLabel();
        xLabel18 = new com.rameses.rcp.control.XLabel();
        xPanel4 = new com.rameses.rcp.control.XPanel();
        xDataTable1 = new com.rameses.rcp.control.XDataTable();
        jPanel4 = new javax.swing.JPanel();
        xButton1 = new com.rameses.rcp.control.XButton();
        xButton2 = new com.rameses.rcp.control.XButton();

        setPreferredSize(new java.awt.Dimension(1201, 539));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        xPanel2.setVisibleWhen("#{ showInfos == true }");
        xPanel2.setLayout(new java.awt.BorderLayout());

        applicationInfoList1.setAppid("entity.appid");
        applicationInfoList1.setDoctypeid("entity.doctypeid");
        applicationInfoList1.setEditableWhen("#{ editable }");
        applicationInfoList1.setEntitySchemaName("building_permit_info");
        applicationInfoList1.setParentid("entity.objid");
        applicationInfoList1.setSchemaName("vw_building_permit_info");
        xPanel2.add(applicationInfoList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Infos", xPanel2);

        xPanel1.setVisibleWhen("#{ showFees == true }");
        xPanel1.setLayout(new java.awt.BorderLayout());

        applicationFeeList1.setAppid("entity.appid");
        applicationFeeList1.setDoctypeid("entity.doctypeid");
        applicationFeeList1.setEditableWhen("#{ editable }");
        applicationFeeList1.setEntitySchemaName("building_permit_fee");
        applicationFeeList1.setParentid("entity.objid");
        applicationFeeList1.setSchemaName("vw_building_permit_fee");
        xPanel1.add(applicationFeeList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Fees", xPanel1);

        xPanel3.setVisibleWhen("#{ showChecklist == true }");
        xPanel3.setLayout(new java.awt.BorderLayout());

        applicationChecklist1.setAppid("entity.appid");
        applicationChecklist1.setDoctypeid("entity.doctypeid");
        applicationChecklist1.setEditableWhen("#{ editable }");
        applicationChecklist1.setEntitySchemaName("building_permit_checklist");
        applicationChecklist1.setParentid("entity.objid");
        applicationChecklist1.setSchemaName("building_permit_checklist");
        xPanel3.add(applicationChecklist1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Checklist Items", xPanel3);

        jPanel2.add(xTabbedPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());

        xActionBar3.setFormName("formName");
        xActionBar3.setName("docActions"); // NOI18N
        xActionBar3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xActionBar3.setDynamic(true);
        xActionBar3.setPreferredSize(new java.awt.Dimension(91, 30));
        jPanel3.add(xActionBar3, java.awt.BorderLayout.NORTH);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5), null));
        jPanel1.setPreferredSize(new java.awt.Dimension(766, 220));

        xFormPanel1.setCaptionWidth(120);

        xLabel8.setCaption("Control No");
        xLabel8.setExpression("#{entity.controlno}");
        xLabel8.setVisibleWhen("#{ entity.controlid !=null }");
        xLabel8.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel8);

        xLabel7.setCaption("Date Issued");
        xLabel7.setExpression("#{entity.dtissued}");
        xLabel7.setVisibleWhen("#{ entity.controlid !=null }");
        xLabel7.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel7);

        xLabel4.setCaption("Issued by");
        xLabel4.setExpression("#{entity.issuedby.name}");
        xLabel4.setVisibleWhen("#{ entity.controlid !=null }");
        xLabel4.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel4);

        xLabel5.setCaption("Expiry date");
        xLabel5.setExpression("#{entity.expirydate}");
        xLabel5.setVisibleWhen("#{ entity.controlid !=null }");
        xLabel5.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel5);

        xLabel10.setCaption("Design Prof");
        xLabel10.setExpression("#{entity.designprofessional.name} ( #{entity.designprofessional.prc.idno} )");
        xLabel10.setVisibleWhen("#{ entity.designprofessional.objid !=null  }");
        xLabel10.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel10);

        xLabel11.setCaption("Super. In Charge");
        xLabel11.setExpression("#{entity.supervisor.name} ( #{entity.designprofessional.prc.idno} )");
        xLabel11.setVisibleWhen("#{ entity.supervisor.objid !=null  }");
        xLabel11.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel11);

        xLabel13.setCaption("Remarks");
        xLabel13.setExpression("#{entity.remarks}");
        xLabel13.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel13);

        xFormPanel2.setCaptionWidth(120);

        xLabel9.setCaption("Doc Type");
        xLabel9.setExpression("#{entity.doctype.title}");
        xLabel9.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel9);

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
        xLabel14.setExpression("#{entity.app.occupancytype.group.title}");
        xLabel14.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel14);

        xLabel18.setCaption("Project Cost");
        xLabel18.setExpression("#{entity.app.projectcost}");
        xLabel18.setNumberFormat("#,##0.00");
        xLabel18.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel18);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(xFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(81, 81, 81))
        );

        jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        xTabbedPane2.addTab("General", jPanel2);

        xPanel4.setVisibleWhen("#{ showDocList == true }");
        xPanel4.setLayout(new java.awt.BorderLayout());

        xDataTable1.setHandler("docListHandler");
        xDataTable1.setName("selectedRefDoc"); // NOI18N
        xDataTable1.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "doctype.title"}
                , new Object[]{"caption", "Document Type"}
                , new Object[]{"width", 250}
                , new Object[]{"minWidth", 300}
                , new Object[]{"maxWidth", 350}
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
                new Object[]{"name", "controlno"}
                , new Object[]{"caption", "Control No"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 150}
                , new Object[]{"maxWidth", 200}
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
                new Object[]{"name", "dtissued"}
                , new Object[]{"caption", "Date Issued"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 100}
                , new Object[]{"maxWidth", 100}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.DateColumnHandler(null, "yyyy-MM-dd", null)}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", null}
                , new Object[]{"caption", " "}
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
            })
        });
        xPanel4.add(xDataTable1, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(1180, 30));
        jPanel4.setLayout(new com.rameses.rcp.control.layout.XLayout());

        xButton1.setName("openRefDoc"); // NOI18N
        xButton1.setText("Open");
        jPanel4.add(xButton1);

        xButton2.setDepends(new String[] {"selectedRefDoc"});
        xButton2.setName("issueRefControlNo"); // NOI18N
        xButton2.setVisibleWhen("#{  entity.app?.task?.state == 'releasing' && selectedRefDoc.controlno == null }");
        xButton2.setText("Issue Control No");
        jPanel4.add(xButton2);

        xPanel4.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        xTabbedPane2.addTab("Related Documents", xPanel4);

        add(xTabbedPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.gov.etracs.obo.components.ApplicationChecklist applicationChecklist1;
    private com.rameses.gov.etracs.obo.components.ApplicationFeeList applicationFeeList1;
    private com.rameses.gov.etracs.obo.components.ApplicationInfoList applicationInfoList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private com.rameses.rcp.control.XActionBar xActionBar3;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton2;
    private com.rameses.rcp.control.XDataTable xDataTable1;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
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
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XPanel xPanel3;
    private com.rameses.rcp.control.XPanel xPanel4;
    private com.rameses.rcp.control.XTabbedPane xTabbedPane1;
    private com.rameses.rcp.control.XTabbedPane xTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
