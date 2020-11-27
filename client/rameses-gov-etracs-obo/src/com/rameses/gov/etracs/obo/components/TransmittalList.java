/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.components;

import com.rameses.osiris2.common.BasicListModel;
import com.rameses.rcp.ui.annotations.ComponentBean;

/**
 *
 * @author elmonazareno
 */
@ComponentBean("com.rameses.gov.etracs.obo.components.TransmittalListModel")
public class TransmittalList extends AbstractComponent {

    
    /**
     * Creates new form ApplicationDocumentList
     */
    public TransmittalList() {
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

        xDataTable1 = new com.rameses.rcp.control.XDataTable();
        jPanel9 = new javax.swing.JPanel();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        btnRefresh = new com.rameses.rcp.control.XButton();
        xButton3 = new com.rameses.rcp.control.XButton();

        setLayout(new java.awt.BorderLayout());

        xDataTable1.setHandler("listHandler");
        xDataTable1.setItems("");
        xDataTable1.setName("selectedItem"); // NOI18N
        xDataTable1.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "objid"}
                , new Object[]{"caption", "Transmiital No"}
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
                new Object[]{"name", "type"}
                , new Object[]{"caption", "Type"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 100}
                , new Object[]{"maxWidth", 150}
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
                , new Object[]{"width", 200}
                , new Object[]{"minWidth", 250}
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
                new Object[]{"name", "dtcreated"}
                , new Object[]{"caption", "Date Created"}
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
            })
        });
        add(xDataTable1, java.awt.BorderLayout.CENTER);

        jPanel9.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel9.setLayout(new java.awt.BorderLayout());

        xPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        xPanel1.setPreferredSize(new java.awt.Dimension(896, 33));
        xPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnRefresh.setCaption("");
        btnRefresh.setName("refresh"); // NOI18N
        btnRefresh.setAccelerator("ctrl R");
        btnRefresh.setAutoRefresh(false);
        btnRefresh.setFocusable(false);
        btnRefresh.setIconResource("images/toolbars/refresh.png");
        btnRefresh.setImmediate(true);
        btnRefresh.setMargin(new java.awt.Insets(1, 1, 1, 1));
        xPanel1.add(btnRefresh);

        xButton3.setName("openItem"); // NOI18N
        xButton3.setText("View");
        xPanel1.add(xButton3);

        jPanel9.add(xPanel1, java.awt.BorderLayout.CENTER);

        add(jPanel9, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.rcp.control.XButton btnRefresh;
    private javax.swing.JPanel jPanel9;
    private com.rameses.rcp.control.XButton xButton3;
    private com.rameses.rcp.control.XDataTable xDataTable1;
    private com.rameses.rcp.control.XPanel xPanel1;
    // End of variables declaration//GEN-END:variables

  

   
}
