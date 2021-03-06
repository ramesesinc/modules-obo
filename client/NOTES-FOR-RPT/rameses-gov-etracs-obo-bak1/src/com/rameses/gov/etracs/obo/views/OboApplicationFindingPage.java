/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.views;

import com.rameses.osiris2.themes.FormPage;
import com.rameses.rcp.ui.annotations.StyleSheet;
import com.rameses.rcp.ui.annotations.Template;

/**
 *
 * @author elmonazareno
 */
@StyleSheet
@Template(FormPage.class)
public class OboApplicationFindingPage extends javax.swing.JPanel {

    /**
     * Creates new form BuildingApplicationFindingPage
     */
    public OboApplicationFindingPage() {
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

        xPanel1 = new com.rameses.rcp.control.XPanel();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xLabel2 = new com.rameses.rcp.control.XLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        xTextArea2 = new com.rameses.rcp.control.XTextArea();
        xLabel3 = new com.rameses.rcp.control.XLabel();
        xPanel2 = new com.rameses.rcp.control.XPanel();
        xDataTable1 = new com.rameses.rcp.control.XDataTable();

        setLayout(new java.awt.CardLayout());

        xPanel1.setVisibleWhen("#{ pagename == 'view' }");
        xPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        xPanel1.setPreferredSize(new java.awt.Dimension(593, 394));
        xPanel1.setLayout(new java.awt.BorderLayout());

        xFormPanel2.setCaptionWidth(100);

        xLabel2.setCaption("Section");
        xLabel2.setExpression("#{ entity.section.type.title }");
        xLabel2.setVisibleWhen("#{ entity.objid != null }");
        xLabel2.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel2);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(0, 150));

        xTextArea2.setCaption("Particulars");
        xTextArea2.setLineWrap(true);
        xTextArea2.setName("entity.particulars"); // NOI18N
        xTextArea2.setPreferredSize(new java.awt.Dimension(0, 60));
        jScrollPane2.setViewportView(xTextArea2);

        xFormPanel2.add(jScrollPane2);

        xLabel3.setCaption("Raised By");
        xLabel3.setExpression("#{ entity.createdby.name }");
        xLabel3.setVisibleWhen("#{ entity.objid != null }");
        xLabel3.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel3);

        xPanel1.add(xFormPanel2, java.awt.BorderLayout.CENTER);

        add(xPanel1, "card4");

        xPanel2.setVisibleWhen("#{ pagename == 'hist' }");
        xPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        xPanel2.setLayout(new java.awt.BorderLayout());

        xDataTable1.setHandler("listModel");
        xDataTable1.setColumns(new com.rameses.rcp.common.Column[]{
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
                , new Object[]{"caption", "Raised By"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 150}
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
                new Object[]{"name", "dtcreated"}
                , new Object[]{"caption", "Date"}
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
                , new Object[]{"typeHandler", new com.rameses.rcp.common.DateColumnHandler(null, null, null)}
            })
        });
        xDataTable1.setRowHeight(40);
        xPanel2.add(xDataTable1, java.awt.BorderLayout.CENTER);

        add(xPanel2, "card5");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private com.rameses.rcp.control.XDataTable xDataTable1;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XLabel xLabel2;
    private com.rameses.rcp.control.XLabel xLabel3;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XTextArea xTextArea2;
    // End of variables declaration//GEN-END:variables
}
