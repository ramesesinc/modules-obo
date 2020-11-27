/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.ui.annotations.ComponentBean;

/**
 *
 * @author elmonazareno
 */
@ComponentBean("com.rameses.gov.etracs.obo.components.ApplicationInfoListModel")
public class ApplicationInfoList extends AbstractComponent {

    private String doctypeid;
    
    /**
     * Creates new form ApplicationFeeList
     */
    public ApplicationInfoList() {
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

        xDataTable5 = new com.rameses.rcp.control.XDataTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        xButton8 = new com.rameses.rcp.control.XButton();
        xButton11 = new com.rameses.rcp.control.XButton();
        xButton9 = new com.rameses.rcp.control.XButton();
        xButton12 = new com.rameses.rcp.control.XButton();

        setLayout(new java.awt.BorderLayout());

        xDataTable5.setHandler("listHandler");
        xDataTable5.setName("selectedItem"); // NOI18N
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
        add(xDataTable5, java.awt.BorderLayout.CENTER);

        jPanel9.setPreferredSize(new java.awt.Dimension(0, 50));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        xButton8.setDisableWhen("#{ editable == false }");
        xButton8.setName("addInfos"); // NOI18N
        xButton8.setIconResource("images/toolbars/plus.png");
        xButton8.setImmediate(true);
        jPanel1.add(xButton8);

        xButton11.setDisableWhen("#{ editable == false }");
        xButton11.setName("editInfos"); // NOI18N
        xButton11.setIconResource("images/toolbars/edit.png");
        xButton11.setImmediate(true);
        jPanel1.add(xButton11);

        xButton9.setDisableWhen("#{ editable == false }");
        xButton9.setName("removeInfos"); // NOI18N
        xButton9.setIconResource("images/toolbars/trash.png");
        xButton9.setImmediate(true);
        jPanel1.add(xButton9);

        xButton12.setDisableWhen("#{ editable == false }");
        xButton12.setName("editRemarks"); // NOI18N
        xButton12.setText("Edit Info Remarks");
        jPanel1.add(xButton12);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel9, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void initComponentBean(com.rameses.rcp.common.ComponentBean bean) { 
        super.initComponentBean( bean );
        bean.setProperty("doctypeid", getProperty(getDoctypeid())); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel9;
    private com.rameses.rcp.control.XButton xButton11;
    private com.rameses.rcp.control.XButton xButton12;
    private com.rameses.rcp.control.XButton xButton8;
    private com.rameses.rcp.control.XButton xButton9;
    private com.rameses.rcp.control.XDataTable xDataTable5;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the doctypeid
     */
    public String getDoctypeid() {
        return doctypeid;
    }

    /**
     * @param doctypeid the doctypeid to set
     */
    public void setDoctypeid(String doctypeid) {
        this.doctypeid = doctypeid;
    }
}
