/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.occupancy.views;

import com.rameses.rcp.ui.annotations.Template;
import com.rameses.seti2.views.CrudFormPage;

/**
 *
 * @author elmonazareno
 */
@Template(CrudFormPage.class)
public class OccupancyApplicationSubdocPage extends javax.swing.JPanel {

    /**
     * Creates new form OccupancyApplicationSubDocPage
     */
    public OccupancyApplicationSubdocPage() {
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

        jPanel1 = new javax.swing.JPanel();
        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xLabel8 = new com.rameses.rcp.control.XLabel();
        xLabel7 = new com.rameses.rcp.control.XLabel();
        xLabel4 = new com.rameses.rcp.control.XLabel();
        xLabel5 = new com.rameses.rcp.control.XLabel();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xLabel9 = new com.rameses.rcp.control.XLabel();
        xLabel12 = new com.rameses.rcp.control.XLabel();
        xLabel13 = new com.rameses.rcp.control.XLabel();
        xButton1 = new com.rameses.rcp.control.XButton();
        xTabbedPane1 = new com.rameses.rcp.control.XTabbedPane();
        xPanel2 = new com.rameses.rcp.control.XPanel();
        xDataTable5 = new com.rameses.rcp.control.XDataTable();
        jPanel9 = new javax.swing.JPanel();
        xButton8 = new com.rameses.rcp.control.XButton();
        xButton9 = new com.rameses.rcp.control.XButton();
        xButton11 = new com.rameses.rcp.control.XButton();
        xButton12 = new com.rameses.rcp.control.XButton();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        schemaList2 = new com.rameses.seti2.components.SchemaList();
        xActionBar2 = new com.rameses.rcp.control.XActionBar();
        xPanel3 = new com.rameses.rcp.control.XPanel();
        xActionBar5 = new com.rameses.rcp.control.XActionBar();
        xDataTable1 = new com.rameses.rcp.control.XDataTable();

        setPreferredSize(new java.awt.Dimension(834, 556));
        setLayout(new java.awt.BorderLayout());

        com.rameses.rcp.control.border.XTitledBorder xTitledBorder1 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder1.setTitle("General Information");
        jPanel1.setBorder(xTitledBorder1);

        xFormPanel1.setCaptionWidth(100);

        xLabel8.setCaption("Control No");
        xLabel8.setExpression("#{entity.controlno}");
        xLabel8.setVisibleWhen("#{ canIssue == true }");
        xLabel8.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel8);

        xLabel7.setCaption("Date Issued");
        xLabel7.setExpression("#{entity.dtissued}");
        xLabel7.setVisibleWhen("#{ canIssue == true }");
        xLabel7.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel7);

        xLabel4.setCaption("Issued by");
        xLabel4.setExpression("#{entity.issuedby.name}");
        xLabel4.setVisibleWhen("#{ canIssue == true }");
        xLabel4.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel4);

        xLabel5.setCaption("Expiry date");
        xLabel5.setExpression("#{entity.expirydate}");
        xLabel5.setVisibleWhen("#{ canIssue == true }");
        xLabel5.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel5);

        xFormPanel2.setCaptionWidth(180);

        xLabel9.setCaption("Doc Type");
        xLabel9.setExpression("#{entity.doctype.title}");
        xLabel9.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel9);

        xLabel12.setCaption("Asessed Amount");
        xLabel12.setExpression("#{entity.amount}");
        xLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xLabel12.setNumberFormat("#,##0.00");
        xLabel12.setPreferredSize(new java.awt.Dimension(150, 20));
        xFormPanel2.add(xLabel12);

        xLabel13.setCaption("Remarks");
        xLabel13.setExpression("#{entity.remarks}");
        xLabel13.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel13);

        xButton1.setCaption("");
        xButton1.setName("editRemarks"); // NOI18N
        xButton1.setVisibleWhen("#{ editable == true }");
        xButton1.setText("Edit Remarks");
        xFormPanel2.add(xButton1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(515, Short.MAX_VALUE)
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(393, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 54, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(xFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        xPanel2.setVisibleWhen("#{ showInfos == true }");
        xPanel2.setLayout(new java.awt.BorderLayout());

        xDataTable5.setHandler("infoListModel");
        xDataTable5.setName("selectedInfo"); // NOI18N
        xDataTable5.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "caption"}
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
                new Object[]{"name", "unit"}
                , new Object[]{"caption", "Unit"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 100}
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
                new Object[]{"name", "value"}
                , new Object[]{"caption", "Value"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 100}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.LabelColumnHandler()}
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
        xDataTable5.setDynamic(true);
        xPanel2.add(xDataTable5, java.awt.BorderLayout.CENTER);

        jPanel9.setPreferredSize(new java.awt.Dimension(0, 50));

        xButton8.setDisableWhen("#{ editable == false }");
        xButton8.setName("addInfos"); // NOI18N
        xButton8.setIconResource("images/toolbars/plus.png");
        xButton8.setImmediate(true);

        xButton9.setDisableWhen("#{ editable == false }");
        xButton9.setName("removeInfos"); // NOI18N
        xButton9.setIconResource("images/toolbars/trash.png");
        xButton9.setImmediate(true);

        xButton11.setDisableWhen("#{ editable == false }");
        xButton11.setName("editInfos"); // NOI18N
        xButton11.setIconResource("images/toolbars/edit.png");
        xButton11.setImmediate(true);

        xButton12.setDisableWhen("#{ editable == false }");
        xButton12.setName("editRemarks"); // NOI18N
        xButton12.setText("Edit Info Remarks");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(xButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 498, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(xButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(xButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(xButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(xButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        xPanel2.add(jPanel9, java.awt.BorderLayout.SOUTH);

        xTabbedPane1.addTab("Infos", xPanel2);

        xPanel1.setVisibleWhen("#{ showFees }");
        xPanel1.setLayout(new java.awt.BorderLayout());

        schemaList2.setAllowOpen(false);
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
                , new Object[]{"expression", "#{ item.balance == 0 ? 'Paid' : '' }"}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.LabelColumnHandler()}
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
        schemaList2.setCustomFilter("parentid = :objid");
        schemaList2.setHandlerName("feeListHandler");
        schemaList2.setName("selectedFee"); // NOI18N
        schemaList2.setQueryName("entity");
        schemaList2.setRowHeight(20);
        schemaList2.setSchemaName("building_application_fee");
        xPanel1.add(schemaList2, java.awt.BorderLayout.CENTER);

        xActionBar2.setFormName("formName");
        xActionBar2.setName("feeActions"); // NOI18N
        xActionBar2.setUseToolBar(false);
        xPanel1.add(xActionBar2, java.awt.BorderLayout.PAGE_START);

        xTabbedPane1.addTab("Fees", xPanel1);

        xPanel3.setVisibleWhen("#{ showChecklist }");
        xPanel3.setLayout(new java.awt.BorderLayout());

        xActionBar5.setFormName("formName");
        xActionBar5.setName("checklistActions"); // NOI18N
        xActionBar5.setUseToolBar(false);
        xPanel3.add(xActionBar5, java.awt.BorderLayout.PAGE_START);

        xDataTable1.setHandler("checklistHandler");
        xDataTable1.setName("selectedChecklistItem"); // NOI18N
        xDataTable1.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "indexno"}
                , new Object[]{"caption", "No"}
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
                , new Object[]{"typeHandler", new com.rameses.rcp.common.IntegerColumnHandler(null, -1, -1)}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "category"}
                , new Object[]{"caption", "Category"}
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
            })
        });
        xPanel3.add(xDataTable1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Checklist Items", xPanel3);

        add(xTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel9;
    private com.rameses.seti2.components.SchemaList schemaList2;
    private com.rameses.rcp.control.XActionBar xActionBar2;
    private com.rameses.rcp.control.XActionBar xActionBar5;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton11;
    private com.rameses.rcp.control.XButton xButton12;
    private com.rameses.rcp.control.XButton xButton8;
    private com.rameses.rcp.control.XButton xButton9;
    private com.rameses.rcp.control.XDataTable xDataTable1;
    private com.rameses.rcp.control.XDataTable xDataTable5;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XLabel xLabel12;
    private com.rameses.rcp.control.XLabel xLabel13;
    private com.rameses.rcp.control.XLabel xLabel4;
    private com.rameses.rcp.control.XLabel xLabel5;
    private com.rameses.rcp.control.XLabel xLabel7;
    private com.rameses.rcp.control.XLabel xLabel8;
    private com.rameses.rcp.control.XLabel xLabel9;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XPanel xPanel3;
    private com.rameses.rcp.control.XTabbedPane xTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
