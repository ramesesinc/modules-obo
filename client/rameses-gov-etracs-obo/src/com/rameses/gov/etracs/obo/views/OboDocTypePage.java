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
public class OboDocTypePage extends javax.swing.JPanel {

    /**
     * Creates new form BuildingSubdocTypePage
     */
    public OboDocTypePage() {
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
        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xTextField1 = new com.rameses.rcp.control.XTextField();
        xTextField2 = new com.rameses.rcp.control.XTextField();
        xComboBox2 = new com.rameses.rcp.control.XComboBox();
        xComboBox5 = new com.rameses.rcp.control.XComboBox();
        xComboBox7 = new com.rameses.rcp.control.XComboBox();
        xTextField3 = new com.rameses.rcp.control.XTextField();
        xTextField7 = new com.rameses.rcp.control.XTextField();
        xComboBox4 = new com.rameses.rcp.control.XComboBox();
        xComboBox6 = new com.rameses.rcp.control.XComboBox();
        xTextField8 = new com.rameses.rcp.control.XTextField();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        xCheckBox4 = new com.rameses.rcp.control.XCheckBox();
        xCheckBox3 = new com.rameses.rcp.control.XCheckBox();
        xLabel2 = new com.rameses.rcp.control.XLabel();
        xRadio3 = new com.rameses.rcp.control.XRadio();
        xRadio4 = new com.rameses.rcp.control.XRadio();
        xRadio5 = new com.rameses.rcp.control.XRadio();
        xRadio6 = new com.rameses.rcp.control.XRadio();
        xTextField4 = new com.rameses.rcp.control.XTextField();
        xTextField6 = new com.rameses.rcp.control.XTextField();
        xLabel3 = new com.rameses.rcp.control.XLabel();
        xLookupField1 = new com.rameses.rcp.control.XLookupField();
        xLookupField2 = new com.rameses.rcp.control.XLookupField();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        schemaList3 = new com.rameses.seti2.components.SchemaList();
        xPanel2 = new com.rameses.rcp.control.XPanel();
        schemaList4 = new com.rameses.seti2.components.SchemaList();
        xPanel3 = new com.rameses.rcp.control.XPanel();
        schemaList5 = new com.rameses.seti2.components.SchemaList();

        setLayout(new java.awt.BorderLayout());

        xTabbedPane1.setPreferredSize(new java.awt.Dimension(666, 608));

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel1.setLayout(new java.awt.BorderLayout());

        xFormPanel1.setCaption("General Info");
        com.rameses.rcp.control.border.XTitledBorder xTitledBorder1 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder1.setPadding(new java.awt.Insets(25, 15, 15, 20));
        xTitledBorder1.setTitle("General Info");
        xFormPanel1.setBorder(xTitledBorder1);
        xFormPanel1.setCaptionVAlignment(com.rameses.rcp.constant.UIConstants.CENTER);
        xFormPanel1.setCaptionWidth(200);

        xTextField1.setCaption("Code");
        xTextField1.setDisableWhen("#{ mode != 'create' }");
        xTextField1.setName("entity.objid"); // NOI18N
        xTextField1.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField1.setRequired(true);
        xTextField1.setSpaceChar('_');
        xFormPanel1.add(xTextField1);

        xTextField2.setCaption("Title");
        xTextField2.setName("entity.title"); // NOI18N
        xTextField2.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField2.setRequired(true);
        xTextField2.setTextCase(com.rameses.rcp.constant.TextCase.NONE);
        xFormPanel1.add(xTextField2);

        xComboBox2.setCaption("Doc Type");
        xComboBox2.setItemKey("");
        xComboBox2.setItems("docTypes");
        xComboBox2.setName("entity.type"); // NOI18N
        xComboBox2.setPreferredSize(new java.awt.Dimension(200, 22));
        xComboBox2.setRequired(true);
        xFormPanel1.add(xComboBox2);

        xComboBox5.setCaption("App Type");
        xComboBox5.setItemKey("");
        xComboBox5.setItems("appTypes");
        xComboBox5.setName("entity.apptype"); // NOI18N
        xComboBox5.setPreferredSize(new java.awt.Dimension(200, 22));
        xComboBox5.setRequired(true);
        xFormPanel1.add(xComboBox5);

        xComboBox7.setCaption("Section");
        xComboBox7.setExpression("#{ item.objid }");
        xComboBox7.setItemKey("");
        xComboBox7.setItems("sectionList");
        xComboBox7.setName("entity.section"); // NOI18N
        xComboBox7.setVisibleWhen("");
        xComboBox7.setPreferredSize(new java.awt.Dimension(200, 22));
        xFormPanel1.add(xComboBox7);

        xTextField3.setCaption("Report Template");
        xTextField3.setName("entity.template"); // NOI18N
        xTextField3.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField3.setTextCase(com.rameses.rcp.constant.TextCase.NONE);
        xFormPanel1.add(xTextField3);

        xTextField7.setCaption("Report Header");
        xTextField7.setName("entity.reportheader"); // NOI18N
        xTextField7.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField7.setTextCase(com.rameses.rcp.constant.TextCase.NONE);
        xFormPanel1.add(xTextField7);

        xComboBox4.setCaption("SubType Of");
        xComboBox4.setDepends(new String[] {"entity.type"});
        xComboBox4.setItemKey("");
        xComboBox4.setItems("subTypes");
        xComboBox4.setName("entity.subtypeof"); // NOI18N
        xComboBox4.setVisibleWhen("#{ entity.type == 'CHECKLIST' }");
        xComboBox4.setPreferredSize(new java.awt.Dimension(200, 22));
        xFormPanel1.add(xComboBox4);

        xComboBox6.setCaption("Accompanying document of");
        xComboBox6.setDepends(new String[] {"entity.type"});
        xComboBox6.setItemKey("");
        xComboBox6.setItems("refDocTypes");
        xComboBox6.setName("entity.refdoc"); // NOI18N
        xComboBox6.setPreferredSize(new java.awt.Dimension(200, 22));
        xFormPanel1.add(xComboBox6);

        xTextField8.setCaption("App No Pattern");
        xTextField8.setDepends(new String[] {"entity.type"});
        xTextField8.setName("entity.appnopattern"); // NOI18N
        xTextField8.setVisibleWhen("#{ entity.type == 'MAIN' }");
        xTextField8.setPreferredSize(new java.awt.Dimension(200, 20));
        xTextField8.setTextCase(com.rameses.rcp.constant.TextCase.NONE);
        xFormPanel1.add(xTextField8);

        xLabel1.setExpression("Options");
        xLabel1.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel1.setShowCaption(false);
        xFormPanel1.add(xLabel1);

        xCheckBox4.setCheckValue(1);
        xCheckBox4.setName("entity.autocreate"); // NOI18N
        xCheckBox4.setUncheckValue(0);
        xCheckBox4.setShowCaption(false);
        xCheckBox4.setText("Auto create (if document does not exist)");
        xFormPanel1.add(xCheckBox4);

        xCheckBox3.setCheckValue(1);
        xCheckBox3.setName("entity.requirefee"); // NOI18N
        xCheckBox3.setUncheckValue(0);
        xCheckBox3.setShowCaption(false);
        xCheckBox3.setText("Require Fees to be assessed before approval ");
        xFormPanel1.add(xCheckBox3);

        xLabel2.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel2.setShowCaption(false);
        xLabel2.setText("Issuance options");
        xFormPanel1.add(xLabel2);

        xRadio3.setCaption("");
        xRadio3.setName("entity.issuetype"); // NOI18N
        xRadio3.setOptionValue(0);
        xRadio3.setShowCaption(false);
        xRadio3.setText("Not issued");
        xFormPanel1.add(xRadio3);

        xRadio4.setCaption("");
        xRadio4.setName("entity.issuetype"); // NOI18N
        xRadio4.setOptionValue(1);
        xRadio4.setShowCaption(false);
        xRadio4.setText("Manual release, control number auto-generated");
        xFormPanel1.add(xRadio4);

        xRadio5.setCaption("");
        xRadio5.setName("entity.issuetype"); // NOI18N
        xRadio5.setOptionValue(2);
        xRadio5.setShowCaption(false);
        xRadio5.setText("Manually issue control number specified");
        xFormPanel1.add(xRadio5);

        xRadio6.setCaption("");
        xRadio6.setName("entity.issuetype"); // NOI18N
        xRadio6.setOptionValue(3);
        xRadio6.setShowCaption(false);
        xRadio6.setText("Auto-issue of control number before releasing");
        xFormPanel1.add(xRadio6);

        xTextField4.setCaption("Control No Pattern");
        xTextField4.setDepends(new String[] {"entity.issuetype"});
        xTextField4.setName("entity.controlnopattern"); // NOI18N
        xTextField4.setVisibleWhen("#{ entity.issuetype == 1 || entity.issuetype == 3 }");
        xTextField4.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xTextField4.setPreferredSize(new java.awt.Dimension(200, 20));
        xTextField4.setTextCase(com.rameses.rcp.constant.TextCase.NONE);
        xFormPanel1.add(xTextField4);

        xTextField6.setCaption("Releaser Role");
        xTextField6.setDepends(new String[] {"entity.issuetype"});
        xTextField6.setName("entity.role"); // NOI18N
        xTextField6.setVisibleWhen("#{ entity.issuetype != 0 }");
        xTextField6.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xTextField6.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField6.setSpaceChar('_');
        xFormPanel1.add(xTextField6);

        xLabel3.setDepends(new String[] {"entity.issuetype"});
        xLabel3.setExpression("Default Signatures");
        xLabel3.setVisibleWhen("#{ entity.issuetype != 0 }");
        xLabel3.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel3.setShowCaption(false);
        xFormPanel1.add(xLabel3);

        xLookupField1.setCaption("Endorser");
        xLookupField1.setDepends(new String[] {"entity.issuetype"});
        xLookupField1.setExpression("#{ entity.endorser.displayname } / #{ entity.endorser.position }");
        xLookupField1.setHandler("sys_signature:lookup");
        xLookupField1.setName("entity.endorser"); // NOI18N
        xLookupField1.setVisibleWhen("#{ entity.issuetype != 0 }");
        xLookupField1.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLookupField1);

        xLookupField2.setCaption("Approver");
        xLookupField2.setDepends(new String[] {"entity.issuetype"});
        xLookupField2.setExpression("#{ entity.approver.displayname } / #{ entity.approver.position }");
        xLookupField2.setHandler("sys_signature:lookup");
        xLookupField2.setName("entity.approver"); // NOI18N
        xLookupField2.setVisibleWhen("#{ entity.issuetype != 0 }");
        xLookupField2.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLookupField2);

        jPanel1.add(xFormPanel1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("General", jPanel1);

        xPanel1.setLayout(new java.awt.BorderLayout());

        schemaList3.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "objid"}
                , new Object[]{"caption", "ID"}
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
                new Object[]{"name", "title"}
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
                new Object[]{"name", "item.title"}
                , new Object[]{"caption", "Acct Mapping"}
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
        schemaList3.setCustomFilter("doctypeid = :objid");
        schemaList3.setHandlerName("itemHandler");
        schemaList3.setQueryName("entity");
        schemaList3.setSchemaName("obo_itemaccount");
        schemaList3.setAllowOpen(false);
        schemaList3.setRowHeight(20);
        xPanel1.add(schemaList3, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Fee Accounts", xPanel1);

        xPanel2.setLayout(new java.awt.BorderLayout());

        schemaList4.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "name"}
                , new Object[]{"caption", "Name"}
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
                new Object[]{"name", "caption"}
                , new Object[]{"caption", "Caption"}
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
                new Object[]{"name", "datatype"}
                , new Object[]{"caption", "Data Type"}
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
                , new Object[]{"caption", "Unit "}
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
        schemaList4.setCustomFilter("doctypeid = :objid");
        schemaList4.setQueryName("entity");
        schemaList4.setSchemaName("obo_variable");
        schemaList4.setAllowCreate(true);
        schemaList4.setAllowDelete(true);
        schemaList4.setRowHeight(20);
        xPanel2.add(schemaList4, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Infos", xPanel2);

        xPanel3.setLayout(new java.awt.BorderLayout());

        schemaList5.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "objid"}
                , new Object[]{"caption", "ID"}
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
                new Object[]{"name", "title"}
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
            })
        });
        schemaList5.setCustomFilter("doctypeid = :objid");
        schemaList5.setQueryName("entity");
        schemaList5.setSchemaName("obo_checklist_master");
        schemaList5.setAllowCreate(true);
        schemaList5.setAllowDelete(true);
        schemaList5.setRowHeight(20);
        xPanel3.add(schemaList5, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Checklist Items", xPanel3);

        add(xTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private com.rameses.seti2.components.SchemaList schemaList3;
    private com.rameses.seti2.components.SchemaList schemaList4;
    private com.rameses.seti2.components.SchemaList schemaList5;
    private com.rameses.rcp.control.XCheckBox xCheckBox3;
    private com.rameses.rcp.control.XCheckBox xCheckBox4;
    private com.rameses.rcp.control.XComboBox xComboBox2;
    private com.rameses.rcp.control.XComboBox xComboBox4;
    private com.rameses.rcp.control.XComboBox xComboBox5;
    private com.rameses.rcp.control.XComboBox xComboBox6;
    private com.rameses.rcp.control.XComboBox xComboBox7;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLabel xLabel2;
    private com.rameses.rcp.control.XLabel xLabel3;
    private com.rameses.rcp.control.XLookupField xLookupField1;
    private com.rameses.rcp.control.XLookupField xLookupField2;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XPanel xPanel3;
    private com.rameses.rcp.control.XRadio xRadio3;
    private com.rameses.rcp.control.XRadio xRadio4;
    private com.rameses.rcp.control.XRadio xRadio5;
    private com.rameses.rcp.control.XRadio xRadio6;
    private com.rameses.rcp.control.XTabbedPane xTabbedPane1;
    private com.rameses.rcp.control.XTextField xTextField1;
    private com.rameses.rcp.control.XTextField xTextField2;
    private com.rameses.rcp.control.XTextField xTextField3;
    private com.rameses.rcp.control.XTextField xTextField4;
    private com.rameses.rcp.control.XTextField xTextField6;
    private com.rameses.rcp.control.XTextField xTextField7;
    private com.rameses.rcp.control.XTextField xTextField8;
    // End of variables declaration//GEN-END:variables
}
