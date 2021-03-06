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
public class BuildingPermitCapturePage extends javax.swing.JPanel {

    /**
     * Creates new form ApplicationEntryPage
     */
    public BuildingPermitCapturePage() {
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
        xFormPanel3 = new com.rameses.rcp.control.XFormPanel();
        xTextField3 = new com.rameses.rcp.control.XTextField();
        xTextField4 = new com.rameses.rcp.control.XTextField();
        xDateField4 = new com.rameses.rcp.control.XDateField();
        xComboBox1 = new com.rameses.rcp.control.XComboBox();
        xTextField1 = new com.rameses.rcp.control.XTextField();
        addressEditor1 = new com.rameses.enterprise.components.AddressEditor();
        jScrollPane1 = new javax.swing.JScrollPane();
        xTextArea1 = new com.rameses.rcp.control.XTextArea();
        entityLookup1 = new com.rameses.entity.components.EntityLookup();
        entityAddressLookup1 = new com.rameses.entity.components.EntityAddressLookup();
        xLookupField3 = new com.rameses.rcp.control.XLookupField();
        xLabel21 = new com.rameses.rcp.control.XLabel();
        xLabel3 = new com.rameses.rcp.control.XLabel();
        xLookupField2 = new com.rameses.rcp.control.XLookupField();
        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xIntegerField1 = new com.rameses.rcp.control.XIntegerField();
        xDecimalField4 = new com.rameses.rcp.control.XDecimalField();
        xDecimalField3 = new com.rameses.rcp.control.XDecimalField();
        xIntegerField2 = new com.rameses.rcp.control.XIntegerField();
        xDecimalField1 = new com.rameses.rcp.control.XDecimalField();
        xDecimalField2 = new com.rameses.rcp.control.XDecimalField();
        xDateField2 = new com.rameses.rcp.control.XDateField();
        xDateField3 = new com.rameses.rcp.control.XDateField();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        schemaList8 = new com.rameses.seti2.components.SchemaList();

        jPanel2.setLayout(new java.awt.BorderLayout());

        com.rameses.rcp.control.border.XTitledBorder xTitledBorder1 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder1.setPadding(new java.awt.Insets(30, 10, 10, 10));
        xTitledBorder1.setTitle("General Info");
        xFormPanel3.setBorder(xTitledBorder1);
        xFormPanel3.setCaptionWidth(200);

        xTextField3.setCaption("Bldg Permit No");
        xTextField3.setName("entity.permitno"); // NOI18N
        xTextField3.setPreferredSize(new java.awt.Dimension(200, 20));
        xTextField3.setRequired(true);
        xFormPanel3.add(xTextField3);

        xTextField4.setCaption("App No");
        xTextField4.setName("entity.appno"); // NOI18N
        xTextField4.setPreferredSize(new java.awt.Dimension(200, 20));
        xTextField4.setRequired(true);
        xFormPanel3.add(xTextField4);

        xDateField4.setCaption("App Date");
        xDateField4.setName("entity.appdate"); // NOI18N
        xFormPanel3.add(xDateField4);

        xComboBox1.setCaption("App Type");
        xComboBox1.setExpression("");
        xComboBox1.setItems("appTypes");
        xComboBox1.setName("entity.apptype"); // NOI18N
        xComboBox1.setPreferredSize(new java.awt.Dimension(120, 27));
        xComboBox1.setRequired(true);
        xFormPanel3.add(xComboBox1);

        xTextField1.setCaption("Project Title");
        xTextField1.setName("entity.title"); // NOI18N
        xTextField1.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField1.setRequired(true);
        xFormPanel3.add(xTextField1);

        addressEditor1.setCaption("Project Location");
        addressEditor1.setName("entity.location"); // NOI18N
        addressEditor1.setPreferredSize(new java.awt.Dimension(0, 53));
        xFormPanel3.add(addressEditor1);

        jScrollPane1.setName("entity.particulars"); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 65));

        xTextArea1.setCaption("Description");
        xTextArea1.setName("entity.description"); // NOI18N
        jScrollPane1.setViewportView(xTextArea1);

        xFormPanel3.add(jScrollPane1);

        entityLookup1.setCaption("Applicant");
        entityLookup1.setEntityType("entityindividual");
        entityLookup1.setName("entity.applicant"); // NOI18N
        entityLookup1.setPreferredSize(new java.awt.Dimension(0, 21));
        entityLookup1.setRequired(true);
        xFormPanel3.add(entityLookup1);

        entityAddressLookup1.setCaption("Home Address");
        entityAddressLookup1.setDepends(new String[] {"entity.applicant"});
        entityAddressLookup1.setName("entity.applicant.address"); // NOI18N
        entityAddressLookup1.setPreferredSize(new java.awt.Dimension(0, 40));
        entityAddressLookup1.setRequired(true);
        xFormPanel3.add(entityAddressLookup1);

        xLookupField3.setCaption("Occupancy Type");
        xLookupField3.setExpression("#{entity.occupancytype.title}");
        xLookupField3.setHandler("obo_occupancy_type:lookup");
        xLookupField3.setName("entity.occupancytype"); // NOI18N
        xLookupField3.setPreferredSize(new java.awt.Dimension(0, 20));
        xLookupField3.setRequired(true);
        xFormPanel3.add(xLookupField3);

        xLabel21.setCaption("Group");
        xLabel21.setDepends(new String[] {"entity.occupancytype"});
        xLabel21.setExpression("#{entity.occupancytype.group.objid}");
        xLabel21.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel21);

        xLabel3.setCaption("Division");
        xLabel3.setDepends(new String[] {"entity.occupancytype"});
        xLabel3.setExpression("#{entity.occupancytype.division.objid}");
        xLabel3.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel3);

        xLookupField2.setCaption("Type of Work");
        xLookupField2.setExpression("#{entity.worktype.objid}");
        xLookupField2.setHandler("obo_work_type:lookup");
        xLookupField2.setName("entity.worktype"); // NOI18N
        xLookupField2.setPreferredSize(new java.awt.Dimension(0, 20));
        xLookupField2.setRequired(true);
        xFormPanel3.add(xLookupField2);

        com.rameses.rcp.control.border.XTitledBorder xTitledBorder2 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder2.setPadding(new java.awt.Insets(30, 10, 10, 10));
        xTitledBorder2.setTitle("Building Info");
        xFormPanel1.setBorder(xTitledBorder2);
        xFormPanel1.setCaptionWidth(200);

        xIntegerField1.setCaption("No of Units");
        xIntegerField1.setName("entity.numunits"); // NOI18N
        xFormPanel1.add(xIntegerField1);

        xDecimalField4.setCaption("Height (m)");
        xDecimalField4.setName("entity.height"); // NOI18N
        xFormPanel1.add(xDecimalField4);

        xDecimalField3.setCaption("Total Floor Area (sqm)");
        xDecimalField3.setName("entity.totalfloorarea"); // NOI18N
        xFormPanel1.add(xDecimalField3);

        xIntegerField2.setCaption("No of Floors");
        xIntegerField2.setName("entity.numfloors"); // NOI18N
        xFormPanel1.add(xIntegerField2);

        xDecimalField1.setCaption("Project Cost");
        xDecimalField1.setName("entity.projectcost"); // NOI18N
        xDecimalField1.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xDecimalField1.setPreferredSize(new java.awt.Dimension(200, 20));
        xFormPanel1.add(xDecimalField1);

        xDecimalField2.setCaption("Fixed Cost (Computed)");
        xDecimalField2.setDisableWhen("#{ true }");
        xDecimalField2.setName("entity.fixedcost"); // NOI18N
        xDecimalField2.setPreferredSize(new java.awt.Dimension(200, 20));
        xFormPanel1.add(xDecimalField2);

        xDateField2.setCaption("Proposed Const. Date");
        xDateField2.setName("entity.dtproposedconstruction"); // NOI18N
        xFormPanel1.add(xDateField2);

        xDateField3.setCaption("Expected Completion Date");
        xDateField3.setName("entity.dtexpectedcompletion"); // NOI18N
        xFormPanel1.add(xDateField3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(xFormPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                    .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("General Info", jPanel2);

        schemaList8.setAllowOpen(false);
        schemaList8.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "prc.refno"}
                , new Object[]{"caption", "PRC No"}
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
                new Object[]{"name", "ptr.refno"}
                , new Object[]{"caption", "PTR No"}
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
                new Object[]{"name", "profession"}
                , new Object[]{"caption", "Profession"}
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
                new Object[]{"name", "lastname"}
                , new Object[]{"caption", "Last Name"}
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
                new Object[]{"name", "firstname"}
                , new Object[]{"caption", "First Name"}
                , new Object[]{"width", 200}
                , new Object[]{"minWidth", 200}
                , new Object[]{"maxWidth", 300}
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
                new Object[]{"name", "middlename"}
                , new Object[]{"caption", "Middle Name"}
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
        schemaList8.setCustomFilter("appid = :objid ");
        schemaList8.setQueryName("entity");
        schemaList8.setRowHeight(20);
        schemaList8.setSchemaName("building_permit_rpu");

        javax.swing.GroupLayout xPanel1Layout = new javax.swing.GroupLayout(xPanel1);
        xPanel1.setLayout(xPanel1Layout);
        xPanel1Layout.setHorizontalGroup(
            xPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(schemaList8, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
                .addContainerGap())
        );
        xPanel1Layout.setVerticalGroup(
            xPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(schemaList8, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        xTabbedPane1.addTab("Professionals", xPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1111, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.enterprise.components.AddressEditor addressEditor1;
    private com.rameses.entity.components.EntityAddressLookup entityAddressLookup1;
    private com.rameses.entity.components.EntityLookup entityLookup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.rameses.seti2.components.SchemaList schemaList8;
    private com.rameses.rcp.control.XComboBox xComboBox1;
    private com.rameses.rcp.control.XDateField xDateField2;
    private com.rameses.rcp.control.XDateField xDateField3;
    private com.rameses.rcp.control.XDateField xDateField4;
    private com.rameses.rcp.control.XDecimalField xDecimalField1;
    private com.rameses.rcp.control.XDecimalField xDecimalField2;
    private com.rameses.rcp.control.XDecimalField xDecimalField3;
    private com.rameses.rcp.control.XDecimalField xDecimalField4;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XFormPanel xFormPanel3;
    private com.rameses.rcp.control.XIntegerField xIntegerField1;
    private com.rameses.rcp.control.XIntegerField xIntegerField2;
    private com.rameses.rcp.control.XLabel xLabel21;
    private com.rameses.rcp.control.XLabel xLabel3;
    private com.rameses.rcp.control.XLookupField xLookupField2;
    private com.rameses.rcp.control.XLookupField xLookupField3;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XTabbedPane xTabbedPane1;
    private com.rameses.rcp.control.XTextArea xTextArea1;
    private com.rameses.rcp.control.XTextField xTextField1;
    private com.rameses.rcp.control.XTextField xTextField3;
    private com.rameses.rcp.control.XTextField xTextField4;
    // End of variables declaration//GEN-END:variables
}
