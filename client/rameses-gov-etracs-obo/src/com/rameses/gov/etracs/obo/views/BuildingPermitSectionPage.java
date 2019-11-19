/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.views;

import com.rameses.rcp.ui.annotations.Template;
import com.rameses.seti2.views.WorkflowTaskFormPage;

/**
 *
 * @author elmonazareno
 */
@Template(WorkflowTaskFormPage.class)
public class BuildingPermitSectionPage extends javax.swing.JPanel {

    /**
     * Creates new form OboBuildingSubapplicationPage
     */
    public BuildingPermitSectionPage() {
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
        xLabel18 = new com.rameses.rcp.control.XLabel();
        xLabel19 = new com.rameses.rcp.control.XLabel();
        xActionBar4 = new com.rameses.rcp.control.XActionBar();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        schemaList2 = new com.rameses.seti2.components.SchemaList();
        xActionBar2 = new com.rameses.rcp.control.XActionBar();
        xPanel2 = new com.rameses.rcp.control.XPanel();
        schemaList1 = new com.rameses.seti2.components.SchemaList();
        xActionBar3 = new com.rameses.rcp.control.XActionBar();

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
        xLabel8.setExpression("#{entity.app.title}");
        xLabel8.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel8);

        xLabel7.setCaption("Project Description");
        xLabel7.setExpression("#{entity.app.description}");
        xLabel7.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel7);

        xLabel4.setCaption("Applicant");
        xLabel4.setExpression("#{entity.app.applicant.name}");
        xLabel4.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel4);

        xLabel2.setCaption("Occupancy Type");
        xLabel2.setExpression("#{entity.app.occupancytype.title}");
        xLabel2.setPreferredSize(new java.awt.Dimension(0, 20));
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
        xLabel14.setName("entity.rptinfo.text"); // NOI18N
        xLabel14.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel14);

        xLabel13.setCaption("Task State");
        xLabel13.setExpression("#{entity.task.state}");
        xLabel13.setName("entity.rptinfo.text"); // NOI18N
        xLabel13.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel13);

        xLabel17.setCaption("Payment Info");
        xLabel17.setExpression("#{receipt.receiptno}");
        xLabel17.setName("entity.rptinfo.text"); // NOI18N
        xLabel17.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel17.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel17);

        xLabel18.setCaption("Date Paid");
        xLabel18.setExpression("#{receipt.receiptdate}");
        xLabel18.setName("entity.rptinfo.text"); // NOI18N
        xLabel18.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel18);

        xLabel19.setCaption("Amount");
        xLabel19.setExpression("#{receipt.amount}");
        xLabel19.setName("entity.rptinfo.text"); // NOI18N
        xLabel19.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel19);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xFormPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(xFormPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        xActionBar4.setFormName("formName");
        xActionBar4.setName("extActions"); // NOI18N
        xActionBar4.setUseToolBar(false);
        jPanel1.add(xActionBar4, java.awt.BorderLayout.PAGE_START);

        xTabbedPane1.addTab("General Info", jPanel1);

        xPanel1.setLayout(new java.awt.BorderLayout());

        schemaList2.setAllowDelete(true);
        schemaList2.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "item.title"}
                , new Object[]{"caption", "Title"}
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
                new Object[]{"name", "amount"}
                , new Object[]{"caption", "Amount"}
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
                , new Object[]{"typeHandler", new com.rameses.rcp.common.DecimalColumnHandler("#,##0.00", -1.0, -1.0, false, 2)}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "remarks"}
                , new Object[]{"caption", "Remarks"}
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
        schemaList2.setCustomFilter("appid = :appid AND sectionid = :typeid");
        schemaList2.setHandlerName("feeListHandler");
        schemaList2.setName(""); // NOI18N
        schemaList2.setQueryName("entity");
        schemaList2.setRowHeight(20);
        schemaList2.setSchemaName("building_permit_fee");
        xPanel1.add(schemaList2, java.awt.BorderLayout.CENTER);

        xActionBar2.setFormName("formName");
        xActionBar2.setName("feeActions"); // NOI18N
        xActionBar2.setUseToolBar(false);
        xPanel1.add(xActionBar2, java.awt.BorderLayout.PAGE_START);

        xTabbedPane1.addTab("Fees", xPanel1);

        xPanel2.setLayout(new java.awt.BorderLayout());

        schemaList1.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "particulars"}
                , new Object[]{"caption", "Particulars"}
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
                new Object[]{"name", "createdby.name"}
                , new Object[]{"caption", "Created By"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 200}
                , new Object[]{"maxWidth", 250}
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
                , new Object[]{"expression", "#{ item.state == 1 ? 'CLOSED' : '' }"}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.LabelColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "transmittalid"}
                , new Object[]{"caption", "Transmittal No"}
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
            })
        });
        schemaList1.setCustomFilter("parentid=:objid AND supersederid IS NULL");
        schemaList1.setHandlerName("findingListHandler");
        schemaList1.setName(""); // NOI18N
        schemaList1.setQueryName("entity");
        schemaList1.setRowHeight(20);
        schemaList1.setSchemaName("building_permit_finding");
        xPanel2.add(schemaList1, java.awt.BorderLayout.CENTER);

        xActionBar3.setFormName("formName");
        xActionBar3.setName("findingActions"); // NOI18N
        xActionBar3.setUseToolBar(false);
        xPanel2.add(xActionBar3, java.awt.BorderLayout.PAGE_START);

        xTabbedPane1.addTab("Findings", xPanel2);

        add(xTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.rameses.seti2.components.SchemaList schemaList1;
    private com.rameses.seti2.components.SchemaList schemaList2;
    private com.rameses.rcp.control.XActionBar xActionBar2;
    private com.rameses.rcp.control.XActionBar xActionBar3;
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
    private com.rameses.rcp.control.XLabel xLabel18;
    private com.rameses.rcp.control.XLabel xLabel19;
    private com.rameses.rcp.control.XLabel xLabel2;
    private com.rameses.rcp.control.XLabel xLabel20;
    private com.rameses.rcp.control.XLabel xLabel21;
    private com.rameses.rcp.control.XLabel xLabel4;
    private com.rameses.rcp.control.XLabel xLabel5;
    private com.rameses.rcp.control.XLabel xLabel7;
    private com.rameses.rcp.control.XLabel xLabel8;
    private com.rameses.rcp.control.XLabel xLabel9;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XTabbedPane xTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
