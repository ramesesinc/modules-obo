/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.views;

import com.rameses.rcp.ui.annotations.StyleSheet;
import com.rameses.rcp.ui.annotations.Template;
import com.rameses.seti2.views.CrudFormPage;

/**
 *
 * @author elmonazareno
 */
//@Template(OKCancelPage.class)
@Template(CrudFormPage.class)
@StyleSheet
public class BuildingPermitRequirementPage extends javax.swing.JPanel {

    /**
     * Creates new form BuildingPermitRequirementPage
     */
    public BuildingPermitRequirementPage() {
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

        xPanel2 = new com.rameses.rcp.control.XPanel();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        xTextArea1 = new com.rameses.rcp.control.XTextArea();
        xLabel2 = new com.rameses.rcp.control.XLabel();
        xPanel3 = new com.rameses.rcp.control.XPanel();
        schemaList6 = new com.rameses.seti2.components.SchemaList();

        setLayout(new java.awt.CardLayout());

        xPanel2.setVisibleWhen("#{ pagename == 'view' }");
        xPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        xPanel2.setLayout(new java.awt.BorderLayout());

        xFormPanel2.setCaptionWidth(100);

        xLabel1.setCaption("Requirement");
        xLabel1.setExpression("<html>#{ entity.type.title }</html>");
        xLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel1.setPreferredSize(new java.awt.Dimension(0, 80));
        xFormPanel2.add(xLabel1);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 150));

        xTextArea1.setCaption("Remarks");
        xTextArea1.setLineWrap(true);
        xTextArea1.setName("entity.remarks"); // NOI18N
        xTextArea1.setPreferredSize(new java.awt.Dimension(0, 60));
        jScrollPane1.setViewportView(xTextArea1);

        xFormPanel2.add(jScrollPane1);

        xLabel2.setCaption("Status");
        xLabel2.setExpression("#{  [ '-', 'PASS', 'FOR REVISION', 'NA'][entity.state]   }");
        xLabel2.setVisibleWhen("#{ entity.state != 0 }");
        xFormPanel2.add(xLabel2);

        xPanel2.add(xFormPanel2, java.awt.BorderLayout.CENTER);

        add(xPanel2, "card2");

        xPanel3.setVisibleWhen("#{ pagename == 'hist' }");
        xPanel3.setLayout(new java.awt.BorderLayout());

        schemaList6.setAllowOpen(false);
        schemaList6.setColumns(new com.rameses.rcp.common.Column[]{
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
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "reviewer.name"}
                , new Object[]{"caption", "Reviewed By"}
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
                new Object[]{"name", "dtreviewed"}
                , new Object[]{"caption", "Date"}
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
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "transmittalid"}
                , new Object[]{"caption", "Transmittal No"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 120}
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
        schemaList6.setCustomFilter("appid =:appid  AND typeid = :typeid");
        schemaList6.setOrderBy("dtreviewed");
        schemaList6.setQueryName("entity");
        schemaList6.setRowHeight(20);
        schemaList6.setSchemaName("building_permit_requirement");
        xPanel3.add(schemaList6, java.awt.BorderLayout.CENTER);

        add(xPanel3, "card3");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private com.rameses.seti2.components.SchemaList schemaList6;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLabel xLabel2;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XPanel xPanel3;
    private com.rameses.rcp.control.XTextArea xTextArea1;
    // End of variables declaration//GEN-END:variables
}
