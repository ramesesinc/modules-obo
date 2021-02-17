/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.components;

import com.rameses.common.MethodResolver;
import com.rameses.osiris2.client.WorkUnitUIController;
import com.rameses.rcp.common.MsgBox;
import com.rameses.rcp.control.XComponentPanel;
import com.rameses.rcp.util.UIControlUtil;

/**
 *
 * @author elmonazareno
 */
public class AbstractComponent extends XComponentPanel {

    private String schemaName;
    private String entitySchemaName;
    private String appid;
    private String parentid;
    private String editableWhen;
    private String filter;
    private String handler;
    
    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }
    
      /**
     * @return the entitySchemaName
     */
    public String getEntitySchemaName() {
        return entitySchemaName;
    }

    /**
     * @param entitySchemaName the entitySchemaName to set
     */
    public void setEntitySchemaName(String entitySchemaName) {
        this.entitySchemaName = entitySchemaName;
    }
    
    public void afterInitComponent( com.rameses.rcp.common.ComponentBean bean ) {;}
    
    @Override
    protected void initComponentBean(com.rameses.rcp.common.ComponentBean bean) { 
        bean.setProperty("schemaName", getSchemaName()); 
        bean.setProperty("entitySchemaName", getEntitySchemaName()); 
        
        WorkUnitUIController wu = (WorkUnitUIController)bean.getCallerBinding().getController();
        String conn = (String)wu.getWorkunit().getModule().getProperties().get("connection");
        bean.setProperty("connection", conn); 
        if( getAppid()!=null ) {
            bean.setProperty("appid", getProperty(getAppid()) );
        }
        if( getParentid()!=null ) {
            bean.setProperty("parentid", getProperty(getParentid()) );
        } 
        if( getFilter()!=null ) {
            bean.setProperty("filter", getProperty(getFilter()) );            
        }
        if( getHandler() !=null) {
            bean.setProperty("handler", getProperty(getHandler()) );                        
        }
        afterInitComponent( bean );
        try {
            MethodResolver.getInstance().invoke(bean, "init",  new Object[]{});    
        }
        catch(Exception e) {
            System.out.println("exception " + e.getMessage());
            //do nothing
        }
    } 
    
    public void reload() {
        com.rameses.rcp.common.ComponentBean bean = (com.rameses.rcp.common.ComponentBean)getComponentBean();
        if( getAppid()!=null ) {
            bean.setProperty("appid", getProperty(getAppid()) );
        }
        if( getParentid()!=null ) {
            bean.setProperty("parentid", getProperty(getParentid()) );
        } 
        if( getFilter()!=null ) {
            bean.setProperty("filter", getProperty(getFilter()) );            
        }
        if( getHandler() !=null) {
            bean.setProperty("handler", getProperty(getHandler()) );                        
        }
        afterInitComponent( bean );
        try {
            MethodResolver.getInstance().invoke(bean, "init",  new Object[]{});    
        }
        catch(Exception e) {
            System.out.println("exception " + e.getMessage());
            //do nothing
        }
    }
    
    
    public void beforeRefresh() { 
        try { 
            com.rameses.rcp.common.ComponentBean bean = (com.rameses.rcp.common.ComponentBean)getComponentBean();
            Object xbean = super.getBean();
            boolean editable = false;
            if( getEditableWhen() != null ) {
                boolean b = UIControlUtil.evaluateExprBoolean(xbean, getEditableWhen());
                bean.setProperty("editable", b );
                editable = b;
            }
            else {
                bean.setProperty("editable", false);
            }
            
        } catch(Throwable t) {
            MsgBox.err( t ); 
        }        
    }

    public void afterRefresh() { 
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getEditableWhen() {
        return editableWhen;
    }

    public void setEditableWhen(String editableWhen) {
        this.editableWhen = editableWhen;
    }

    /**
     * @return the filter
     */
    public String getFilter() {
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter(String filter) {
        this.filter = filter;
    }

    /**
     * @return the handler
     */
    public String getHandler() {
        return handler;
    }

    /**
     * @param handler the handler to set
     */
    public void setHandler(String handler) {
        this.handler = handler;
    }

  

    
}
