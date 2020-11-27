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
public class BuildingPermitPage extends javax.swing.JPanel {

    /**
     * Creates new form BuildingPermitPage
     */
    public BuildingPermitPage() {
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
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xLabel29 = new com.rameses.rcp.control.XLabel();
        xLabel30 = new com.rameses.rcp.control.XLabel();
        xLabel33 = new com.rameses.rcp.control.XLabel();
        xLabel8 = new com.rameses.rcp.control.XLabel();
        xLabel7 = new com.rameses.rcp.control.XLabel();
        xLabel6 = new com.rameses.rcp.control.XLabel();
        xLabel4 = new com.rameses.rcp.control.XLabel();
        xLabel34 = new com.rameses.rcp.control.XLabel();
        xLabel35 = new com.rameses.rcp.control.XLabel();
        xLabel15 = new com.rameses.rcp.control.XLabel();
        xLabel16 = new com.rameses.rcp.control.XLabel();
        xLabel5 = new com.rameses.rcp.control.XLabel();
        xLabel12 = new com.rameses.rcp.control.XLabel();
        xLabel14 = new com.rameses.rcp.control.XLabel();
        xLabel17 = new com.rameses.rcp.control.XLabel();
        xFormPanel3 = new com.rameses.rcp.control.XFormPanel();
        xLabel2 = new com.rameses.rcp.control.XLabel();
        xLabel3 = new com.rameses.rcp.control.XLabel();
        xLabel11 = new com.rameses.rcp.control.XLabel();
        xLabel31 = new com.rameses.rcp.control.XLabel();
        xLabel21 = new com.rameses.rcp.control.XLabel();
        xLabel10 = new com.rameses.rcp.control.XLabel();
        xLabel32 = new com.rameses.rcp.control.XLabel();
        xLabel36 = new com.rameses.rcp.control.XLabel();
        xLabel37 = new com.rameses.rcp.control.XLabel();
        pnlDoc = new javax.swing.JPanel();
        schemaList4 = new com.rameses.seti2.components.SchemaList();
        xActionBar4 = new com.rameses.rcp.control.XActionBar();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        xFormPanel2.setCaption("Building Permit Info");
        com.rameses.rcp.control.border.XTitledBorder xTitledBorder1 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder1.setPadding(new java.awt.Insets(20, 10, 10, 10));
        xTitledBorder1.setTitle("Project Information");
        xFormPanel2.setBorder(xTitledBorder1);
        xFormPanel2.setCaptionWidth(190);

        xLabel29.setCaption("Bldg Permit No");
        xLabel29.setExpression("#{entity.permitno}");
        xLabel29.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel29.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel29);

        xLabel30.setCaption("Permit Date Issued");
        xLabel30.setExpression("#{entity.dtissued}");
        xLabel30.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel30);

        xLabel33.setCaption("Expiry date");
        xLabel33.setExpression("#{entity.expirydate}");
        xLabel33.setDateFormat("yyyy MMM dd");
        xLabel33.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel33);

        xLabel8.setCaption("Project Title");
        xLabel8.setExpression("<html>#{entity.title}</html>");
        xLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel8.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel8.setPreferredSize(new java.awt.Dimension(0, 40));
        xFormPanel2.add(xLabel8);

        xLabel7.setCaption("Project Description");
        xLabel7.setExpression("#{entity.description}");
        xLabel7.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel7);

        xLabel6.setCaption("Location");
        xLabel6.setExpression("<html>#{entity.location.text}</html>");
        xLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel6.setPreferredSize(new java.awt.Dimension(0, 40));
        xFormPanel2.add(xLabel6);

        xLabel4.setCaption("Applicant");
        xLabel4.setExpression("#{entity.applicant.name}");
        xLabel4.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel4);

        xLabel34.setCaption("Project Cost");
        xLabel34.setExpression("#{entity.projectcost}");
        xLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xLabel34.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel34.setNumberFormat("#,##0.00");
        xLabel34.setPreferredSize(new java.awt.Dimension(180, 20));
        xFormPanel2.add(xLabel34);

        xLabel35.setCaption("Fixed Unit Cost (computed)");
        xLabel35.setExpression("#{entity.fixedcost}");
        xLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xLabel35.setNumberFormat("#,##0.00");
        xLabel35.setPreferredSize(new java.awt.Dimension(180, 20));
        xFormPanel2.add(xLabel35);

        xLabel15.setCaption("Const. Date");
        xLabel15.setExpression("#{entity.dtproposedconstruction}");
        xLabel15.setDateFormat("yyyy MMM dd");
        xLabel15.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel15);

        xLabel16.setCaption("Est. Completion Date");
        xLabel16.setExpression("#{entity.dtexpectedcompletion}");
        xLabel16.setDateFormat("yyyy MMM dd");
        xLabel16.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel16);

        xLabel5.setCaption("App No");
        xLabel5.setExpression("#{entity.appno}");
        xLabel5.setName("entity.rptinfo.text"); // NOI18N
        xLabel5.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel5.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel5);

        xLabel12.setCaption("App Date");
        xLabel12.setExpression("#{entity.dtfiled}");
        xLabel12.setName("entity.rptinfo.text"); // NOI18N
        xLabel12.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel12);

        xLabel14.setCaption("App Type");
        xLabel14.setExpression("#{entity.apptype}");
        xLabel14.setName("entity.rptinfo.text"); // NOI18N
        xLabel14.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel14);

        xLabel17.setCaption("Txn Mode");
        xLabel17.setExpression("#{entity.txnmode}");
        xLabel17.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel17);

        xFormPanel3.setCaption("");
        com.rameses.rcp.control.border.XTitledBorder xTitledBorder2 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder2.setPadding(new java.awt.Insets(20, 10, 10, 10));
        xTitledBorder2.setTitle("Building Info");
        xFormPanel3.setBorder(xTitledBorder2);
        xFormPanel3.setCaptionWidth(180);
        xFormPanel3.setPreferredSize(new java.awt.Dimension(0, 100));

        xLabel2.setCaption("Occupancy Type ");
        xLabel2.setExpression("<html>#{entity.occupancytype.title}</html>");
        xLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel2.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel2.setPreferredSize(new java.awt.Dimension(0, 40));
        xFormPanel3.add(xLabel2);

        xLabel3.setCaption("Division");
        xLabel3.setExpression("#{entity.occupancytype.division.objid}");
        xLabel3.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel3);

        xLabel11.setCaption("Zone classification");
        xLabel11.setExpression("#{entity.zoneclass.objid} - #{entity.zoneclass.title}");
        xLabel11.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel11.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel11);

        xLabel31.setCaption("Zone ");
        xLabel31.setExpression("#{entity.zone}");
        xLabel31.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel31);

        xLabel21.setCaption("Group");
        xLabel21.setExpression("#{entity.occupancytype.group.objid}");
        xLabel21.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel21);

        xLabel10.setCaption("No. of Units");
        xLabel10.setExpression("#{entity.numunits}");
        xLabel10.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel10.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel10);

        xLabel32.setCaption("No. of Storeys");
        xLabel32.setExpression("#{entity.numfloors}");
        xLabel32.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel32);

        xLabel36.setCaption("Total Floor Area");
        xLabel36.setExpression("#{entity.totalfloorarea}");
        xLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        xLabel36.setNumberFormat("##0.00");
        xLabel36.setPreferredSize(new java.awt.Dimension(200, 20));
        xFormPanel3.add(xLabel36);

        xLabel37.setCaption("Bldg Height");
        xLabel37.setExpression("#{entity.height}");
        xLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        xLabel37.setNumberFormat("##0.00");
        xLabel37.setPreferredSize(new java.awt.Dimension(200, 20));
        xFormPanel3.add(xLabel37);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xFormPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(xFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(xFormPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("General Info", jPanel2);

        pnlDoc.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlDoc.setLayout(new java.awt.BorderLayout());

        schemaList4.setAllowCreate(true);
        schemaList4.setAllowDelete(true);
        schemaList4.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "doctype.title"}
                , new Object[]{"caption", "Title"}
                , new Object[]{"width", 200}
                , new Object[]{"minWidth", 200}
                , new Object[]{"maxWidth", 0}
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
                new Object[]{"name", "doctype.type"}
                , new Object[]{"caption", "Doc Type"}
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
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "amount"}
                , new Object[]{"caption", "Amount"}
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
                , new Object[]{"typeHandler", new com.rameses.rcp.common.DecimalColumnHandler("#,##0.00", -1.0, -1.0, false, 2)}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", null}
                , new Object[]{"caption", "Status"}
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
                , new Object[]{"expression", "#{ item.state == 1 ? 'RELEASED' : '' }"}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.LabelColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "controlno"}
                , new Object[]{"caption", "Control No"}
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
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "issuedby.name"}
                , new Object[]{"caption", "Issued By"}
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
                , new Object[]{"typeHandler", new com.rameses.rcp.common.DateColumnHandler(null, null, null)}
            })
        });
        schemaList4.setCustomFilter("appid = :appid");
        schemaList4.setEntityName("building_application_subdoc");
        schemaList4.setHandler("listPermissionModel");
        schemaList4.setHandlerName("");
        schemaList4.setName("selectedDoc"); // NOI18N
        schemaList4.setQueryName("appQry");
        schemaList4.setSchemaName("vw_building_application_subdoc");
        pnlDoc.add(schemaList4, java.awt.BorderLayout.CENTER);

        xActionBar4.setFormName("formName");
        xActionBar4.setName("docActions"); // NOI18N
        pnlDoc.add(xActionBar4, java.awt.BorderLayout.NORTH);

        xTabbedPane1.addTab("Documents", pnlDoc);

        add(xTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlDoc;
    private com.rameses.seti2.components.SchemaList schemaList4;
    private com.rameses.rcp.control.XActionBar xActionBar4;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XFormPanel xFormPanel3;
    private com.rameses.rcp.control.XLabel xLabel10;
    private com.rameses.rcp.control.XLabel xLabel11;
    private com.rameses.rcp.control.XLabel xLabel12;
    private com.rameses.rcp.control.XLabel xLabel14;
    private com.rameses.rcp.control.XLabel xLabel15;
    private com.rameses.rcp.control.XLabel xLabel16;
    private com.rameses.rcp.control.XLabel xLabel17;
    private com.rameses.rcp.control.XLabel xLabel2;
    private com.rameses.rcp.control.XLabel xLabel21;
    private com.rameses.rcp.control.XLabel xLabel29;
    private com.rameses.rcp.control.XLabel xLabel3;
    private com.rameses.rcp.control.XLabel xLabel30;
    private com.rameses.rcp.control.XLabel xLabel31;
    private com.rameses.rcp.control.XLabel xLabel32;
    private com.rameses.rcp.control.XLabel xLabel33;
    private com.rameses.rcp.control.XLabel xLabel34;
    private com.rameses.rcp.control.XLabel xLabel35;
    private com.rameses.rcp.control.XLabel xLabel36;
    private com.rameses.rcp.control.XLabel xLabel37;
    private com.rameses.rcp.control.XLabel xLabel4;
    private com.rameses.rcp.control.XLabel xLabel5;
    private com.rameses.rcp.control.XLabel xLabel6;
    private com.rameses.rcp.control.XLabel xLabel7;
    private com.rameses.rcp.control.XLabel xLabel8;
    private com.rameses.rcp.control.XTabbedPane xTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
