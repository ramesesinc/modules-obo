/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.common.components;

import com.rameses.osiris2.client.WorkUnitUIController;
import com.rameses.rcp.common.MsgBox;
import com.rameses.rcp.control.XComponentPanel;
import com.rameses.rcp.ui.annotations.ComponentBean;
import com.rameses.rcp.util.UIControlUtil;

/**
 *
 * @author elmonazareno
 */

@ComponentBean("com.rameses.gov.etracs.common.components.ApplicationRequirementListModel")
public class ApplicationRequirementList extends XComponentPanel {

    private String schemaName;
    private String appid;
    private String editableWhen;
    
    /**
     * Creates new form RequirementList
     */
    public ApplicationRequirementList() {
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

        jPanel9 = new javax.swing.JPanel();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        btnRefresh = new com.rameses.rcp.control.XButton();
        xButton1 = new com.rameses.rcp.control.XButton();
        xPanel2 = new com.rameses.rcp.control.XPanel();
        xRadio4 = new com.rameses.rcp.control.XRadio();
        xRadio5 = new com.rameses.rcp.control.XRadio();
        xRadio6 = new com.rameses.rcp.control.XRadio();
        xDataTable1 = new com.rameses.rcp.control.XDataTable();

        setLayout(new java.awt.BorderLayout());

        jPanel9.setPreferredSize(new java.awt.Dimension(100, 70));
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

        xButton1.setName("viewRequirement"); // NOI18N
        xButton1.setText("View Requirement");
        xPanel1.add(xButton1);

        jPanel9.add(xPanel1, java.awt.BorderLayout.CENTER);

        xPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        xRadio4.setName("viewType"); // NOI18N
        xRadio4.setOptionValue("all");
        xRadio4.setText("View all");
        xPanel2.add(xRadio4);

        xRadio5.setName("viewType"); // NOI18N
        xRadio5.setOptionValue("open");
        xRadio5.setText("View only open items");
        xPanel2.add(xRadio5);

        xRadio6.setName("viewType"); // NOI18N
        xRadio6.setOptionValue("applicable");
        xRadio6.setText("View only applicable items");
        xPanel2.add(xRadio6);

        jPanel9.add(xPanel2, java.awt.BorderLayout.PAGE_START);

        add(jPanel9, java.awt.BorderLayout.PAGE_START);

        xDataTable1.setHandler("listHandler");
        xDataTable1.setItems("");
        xDataTable1.setName("selectedItem"); // NOI18N
        xDataTable1.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "status"}
                , new Object[]{"caption", "Status"}
                , new Object[]{"width", 80}
                , new Object[]{"minWidth", 100}
                , new Object[]{"maxWidth", 120}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"expression", "#{  [ '-', 'PASS', 'FOR REVISION', 'NA'][item.state]   }"}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.LabelColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "type.title"}
                , new Object[]{"caption", "Type"}
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
                new Object[]{"name", "dtreviewed"}
                , new Object[]{"caption", "Date Reviewed"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 110}
                , new Object[]{"maxWidth", 110}
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
        add(xDataTable1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.rcp.control.XButton btnRefresh;
    private javax.swing.JPanel jPanel9;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XDataTable xDataTable1;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XRadio xRadio4;
    private com.rameses.rcp.control.XRadio xRadio5;
    private com.rameses.rcp.control.XRadio xRadio6;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the schemaName
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * @param schemaName the schemaName to set
     */
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }
    
    @Override
    protected void initComponentBean(com.rameses.rcp.common.ComponentBean bean) { 
        bean.setProperty("schemaName", getSchemaName()); 
        WorkUnitUIController wu = (WorkUnitUIController)bean.getCallerBinding().getController();
        String conn = (String)wu.getWorkunit().getModule().getProperties().get("connection");
        bean.setProperty("connection", conn); 
        bean.setProperty("appid",  getProperty(getAppid()) );
        
    } 
    
    public void afterRefresh() { 
        try { 
            com.rameses.rcp.common.ComponentBean bean = (com.rameses.rcp.common.ComponentBean)getComponentBean();
            Object xbean = super.getBean();
            if( getEditableWhen() != null ) {
                boolean b = UIControlUtil.evaluateExprBoolean(xbean, getEditableWhen());
                bean.setProperty("editable", b );
            }
            else {
                bean.setProperty("editable", false);
            }
            //MethodResolver.getInstance().invoke(bean, "init",  new Object[]{}); 
        } catch(Throwable t) {
            MsgBox.err( t ); 
        }
    }

    /**
     * @return the appid
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid the appid to set
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }


    /**
     * @return the editableWhen
     */
    public String getEditableWhen() {
        return editableWhen;
    }

    /**
     * @param editableWhen the editableWhen to set
     */
    public void setEditableWhen(String editableWhen) {
        this.editableWhen = editableWhen;
    }

    
}
