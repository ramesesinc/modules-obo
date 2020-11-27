/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.occupancy.views;

import com.rameses.rcp.ui.annotations.Template;
import com.rameses.seti2.views.WorkflowTaskFormPage;

/**
 *
 * @author elmonazareno
 */
@Template(WorkflowTaskFormPage.class)
public class OccupancyApplicationPage extends javax.swing.JPanel {

    /**
     * Creates new form OccupancyApplicationCapturePage
     */
    public OccupancyApplicationPage() {
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
        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xLabel21 = new com.rameses.rcp.control.XLabel();
        xLabel9 = new com.rameses.rcp.control.XLabel();
        xLabel8 = new com.rameses.rcp.control.XLabel();
        xLabel7 = new com.rameses.rcp.control.XLabel();
        xLabel6 = new com.rameses.rcp.control.XLabel();
        xLabel4 = new com.rameses.rcp.control.XLabel();
        xLabel2 = new com.rameses.rcp.control.XLabel();
        jPanel1 = new javax.swing.JPanel();
        xFormPanel3 = new com.rameses.rcp.control.XFormPanel();
        xLabel11 = new com.rameses.rcp.control.XLabel();
        xLabel10 = new com.rameses.rcp.control.XLabel();
        xLabel32 = new com.rameses.rcp.control.XLabel();
        xLabel36 = new com.rameses.rcp.control.XLabel();
        xLabel37 = new com.rameses.rcp.control.XLabel();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        xLabel5 = new com.rameses.rcp.control.XLabel();
        xLabel13 = new com.rameses.rcp.control.XLabel();
        xLabel14 = new com.rameses.rcp.control.XLabel();
        xLabel34 = new com.rameses.rcp.control.XLabel();
        xLabel47 = new com.rameses.rcp.control.XLabel();
        xLabel15 = new com.rameses.rcp.control.XLabel();
        xLabel16 = new com.rameses.rcp.control.XLabel();
        xFormPanel4 = new com.rameses.rcp.control.XFormPanel();
        xLabel12 = new com.rameses.rcp.control.XLabel();
        xLabel23 = new com.rameses.rcp.control.XLabel();
        xLabel24 = new com.rameses.rcp.control.XLabel();
        xLabel25 = new com.rameses.rcp.control.XLabel();
        xLabel26 = new com.rameses.rcp.control.XLabel();
        xLabel27 = new com.rameses.rcp.control.XLabel();
        xLabel28 = new com.rameses.rcp.control.XLabel();
        xLabel29 = new com.rameses.rcp.control.XLabel();
        xLabel30 = new com.rameses.rcp.control.XLabel();
        xLabel35 = new com.rameses.rcp.control.XLabel();
        xLabel48 = new com.rameses.rcp.control.XLabel();
        xLabel38 = new com.rameses.rcp.control.XLabel();
        xLabel39 = new com.rameses.rcp.control.XLabel();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xLabel22 = new com.rameses.rcp.control.XLabel();
        xLabel59 = new com.rameses.rcp.control.XLabel();
        xLabel58 = new com.rameses.rcp.control.XLabel();
        xLabel57 = new com.rameses.rcp.control.XLabel();
        xLabel60 = new com.rameses.rcp.control.XLabel();
        xLabel61 = new com.rameses.rcp.control.XLabel();
        xLabel62 = new com.rameses.rcp.control.XLabel();
        xLabel63 = new com.rameses.rcp.control.XLabel();
        xLabel19 = new com.rameses.rcp.control.XLabel();
        xLabel55 = new com.rameses.rcp.control.XLabel();
        xLabel56 = new com.rameses.rcp.control.XLabel();
        xLabel46 = new com.rameses.rcp.control.XLabel();
        xLabel31 = new com.rameses.rcp.control.XLabel();
        xPanel2 = new com.rameses.rcp.control.XPanel();
        xLabel18 = new com.rameses.rcp.control.XLabel();
        xButton2 = new com.rameses.rcp.control.XButton();
        xLabel45 = new com.rameses.rcp.control.XLabel();
        xLabel20 = new com.rameses.rcp.control.XLabel();
        xLabel17 = new com.rameses.rcp.control.XLabel();
        xLabel40 = new com.rameses.rcp.control.XLabel();
        xLabel41 = new com.rameses.rcp.control.XLabel();
        xLabel42 = new com.rameses.rcp.control.XLabel();
        xPanel8 = new com.rameses.rcp.control.XPanel();
        xLabel44 = new com.rameses.rcp.control.XLabel();
        xButton1 = new com.rameses.rcp.control.XButton();
        xLabel43 = new com.rameses.rcp.control.XLabel();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        applicationDocumentList1 = new com.rameses.gov.etracs.obo.components.ApplicationDocumentList();
        xPanel4 = new com.rameses.rcp.control.XPanel();
        applicationRequirementList1 = new com.rameses.gov.etracs.obo.components.ApplicationRequirementList();
        xPanel3 = new com.rameses.rcp.control.XPanel();
        applicationSubTaskList1 = new com.rameses.gov.etracs.obo.components.ApplicationSubTaskList();
        xPanel5 = new com.rameses.rcp.control.XPanel();
        applicationFeeList1 = new com.rameses.gov.etracs.obo.components.ApplicationFeeList();
        xActionBar2 = new com.rameses.rcp.control.XActionBar();

        setLayout(new java.awt.BorderLayout());

        xFormPanel1.setCaptionWidth(190);
        xFormPanel1.setPreferredSize(new java.awt.Dimension(200, 300));

        xLabel21.setExpression("Project Info");
        xLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        xLabel21.setShowCaption(false);
        xFormPanel1.add(xLabel21);

        xLabel9.setCaption("Bldg Permit No");
        xLabel9.setExpression("<html>#{entity.bldgpermit.controlno}</html>");
        xLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel9.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel9);

        xLabel8.setCaption("Project Title");
        xLabel8.setExpression("<html>#{entity.bldgpermit.title}</html>");
        xLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel8.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel8);

        xLabel7.setCaption("Project Description");
        xLabel7.setExpression("<html>#{entity.bldgpermit.description}</html>");
        xLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel7.setPreferredSize(new java.awt.Dimension(0, 35));
        xFormPanel1.add(xLabel7);

        xLabel6.setCaption("Location");
        xLabel6.setExpression("<html>#{entity.bldgpermit.location.text}</html>");
        xLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel6.setPreferredSize(new java.awt.Dimension(0, 35));
        xFormPanel1.add(xLabel6);

        xLabel4.setCaption("Applicant");
        xLabel4.setExpression("#{entity.bldgpermit.applicant.name}");
        xLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel4.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel4);

        xLabel2.setCaption("Occupancy Type");
        xLabel2.setExpression("<html>#{entity.occupancytype.group.objid} ( #{entity.occupancytype.division.objid} ) - #{entity.occupancytype.title }</html>");
        xLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel2.setPreferredSize(new java.awt.Dimension(0, 40));
        xFormPanel1.add(xLabel2);

        jPanel1.setLayout(new java.awt.BorderLayout());

        xFormPanel3.setCaptionWidth(190);
        xFormPanel3.setPreferredSize(new java.awt.Dimension(400, 199));

        xLabel11.setCaption("");
        xLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel11.setPreferredSize(new java.awt.Dimension(0, 20));
        xLabel11.setText("<html><b>Planned</b></html>");
        xFormPanel3.add(xLabel11);

        xLabel10.setCaption("No. of Units");
        xLabel10.setExpression("#{entity.bldgpermit.numunits}");
        xLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel10.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel10);

        xLabel32.setCaption("No. of Storeys");
        xLabel32.setExpression("#{entity.bldgpermit.numfloors}");
        xLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel32.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel32);

        xLabel36.setCaption("Total Floor Area");
        xLabel36.setExpression("#{entity.bldgpermit.totalfloorarea}");
        xLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel36.setNumberFormat("##0.00");
        xLabel36.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel36);

        xLabel37.setCaption("Bldg Height");
        xLabel37.setExpression("#{entity.bldgpermit.height}");
        xLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel37.setNumberFormat("##0.00");
        xLabel37.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel37);

        xLabel1.setCaption("");
        xLabel1.setExpression("Total Material Cost");
        xLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xLabel1.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel1.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel1);

        xLabel5.setCaption("");
        xLabel5.setExpression("Total Direct Labor Cost");
        xLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xLabel5.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel5);

        xLabel13.setCaption("");
        xLabel13.setExpression("Total Equipment Cost");
        xLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xLabel13.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel13);

        xLabel14.setCaption("");
        xLabel14.setExpression("Total Other Cost");
        xLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xLabel14.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel14);

        xLabel34.setCaption("Est. Project Cost");
        xLabel34.setExpression("#{entity.bldgpermit.projectcost}");
        xLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xLabel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel34.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel34.setNumberFormat("#,##0.00");
        xLabel34.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel34);

        xLabel47.setCaption("Fixed Cost");
        xLabel47.setExpression("#{entity.bldgpermit.fixedcost}");
        xLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xLabel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel47.setNumberFormat("#,##0.00");
        xLabel47.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel47);

        xLabel15.setCaption("Start Construction Date");
        xLabel15.setExpression("#{entity.bldgpermit.dtproposedconstruction}");
        xLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel15.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel15.setDateFormat("yyyy MMM dd");
        xLabel15.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel15);

        xLabel16.setCaption("Completion Date");
        xLabel16.setExpression("#{entity.bldgpermit.dtexpectedcompletion}");
        xLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel16.setDateFormat("yyyy MMM dd");
        xLabel16.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel16);

        jPanel1.add(xFormPanel3, java.awt.BorderLayout.CENTER);

        xFormPanel4.setCaptionWidth(190);
        xFormPanel4.setShowCaption(false);

        xLabel12.setCaption("");
        xLabel12.setExpression("<html><b>Actual</b></html>");
        xLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel12.setPreferredSize(new java.awt.Dimension(0, 20));
        xLabel12.setShowCaption(false);
        xFormPanel4.add(xLabel12);

        xLabel23.setExpression("#{ entity.actualnumunits }");
        xLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel23.setNumberFormat("###");
        xLabel23.setPreferredSize(new java.awt.Dimension(0, 20));
        xLabel23.setShowCaption(false);
        xFormPanel4.add(xLabel23);

        xLabel24.setExpression("#{entity.actualnumfloors}");
        xLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel24.setNumberFormat("###");
        xLabel24.setPreferredSize(new java.awt.Dimension(0, 20));
        xLabel24.setShowCaption(false);
        xFormPanel4.add(xLabel24);

        xLabel25.setExpression("#{entity.actualtotalfloorarea}");
        xLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel25.setNumberFormat("#,##0.00");
        xLabel25.setPreferredSize(new java.awt.Dimension(0, 20));
        xLabel25.setShowCaption(false);
        xFormPanel4.add(xLabel25);

        xLabel26.setExpression("#{entity.actualheight}");
        xLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel26.setNumberFormat("#,##0.00");
        xLabel26.setPreferredSize(new java.awt.Dimension(0, 20));
        xLabel26.setShowCaption(false);
        xFormPanel4.add(xLabel26);

        xLabel27.setExpression("#{entity.totalmaterialcost}");
        xLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel27.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel27.setNumberFormat("#,##0.00");
        xLabel27.setPreferredSize(new java.awt.Dimension(0, 20));
        xLabel27.setShowCaption(false);
        xFormPanel4.add(xLabel27);

        xLabel28.setExpression("#{entity.totaldirectlaborcost}");
        xLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel28.setNumberFormat("#,##0.00");
        xLabel28.setPreferredSize(new java.awt.Dimension(0, 20));
        xLabel28.setShowCaption(false);
        xFormPanel4.add(xLabel28);

        xLabel29.setExpression("#{entity.totalequipmentcost}");
        xLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel29.setNumberFormat("#,##0.00");
        xLabel29.setPreferredSize(new java.awt.Dimension(0, 20));
        xLabel29.setShowCaption(false);
        xFormPanel4.add(xLabel29);

        xLabel30.setExpression("#{entity.totalothercost}");
        xLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel30.setNumberFormat("#,##0.00");
        xLabel30.setPreferredSize(new java.awt.Dimension(0, 20));
        xLabel30.setShowCaption(false);
        xFormPanel4.add(xLabel30);

        xLabel35.setCaption("");
        xLabel35.setExpression("#{entity.actualprojectcost}");
        xLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xLabel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel35.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel35.setNumberFormat("#,##0.00");
        xLabel35.setPreferredSize(new java.awt.Dimension(0, 20));
        xLabel35.setShowCaption(false);
        xFormPanel4.add(xLabel35);

        xLabel48.setCaption("");
        xLabel48.setExpression("#{entity.actualfixedcost}");
        xLabel48.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xLabel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel48.setNumberFormat("#,##0.00");
        xLabel48.setPreferredSize(new java.awt.Dimension(0, 20));
        xLabel48.setShowCaption(false);
        xFormPanel4.add(xLabel48);

        xLabel38.setCaption("");
        xLabel38.setExpression("#{entity.dtactualstarted}");
        xLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        xLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel38.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel38.setDateFormat("yyyy-MMM-dd");
        xLabel38.setPreferredSize(new java.awt.Dimension(0, 20));
        xLabel38.setShowCaption(false);
        xFormPanel4.add(xLabel38);

        xLabel39.setCaption("");
        xLabel39.setExpression("#{entity.dtactualcompleted}");
        xLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        xLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel39.setDateFormat("yyyy-MMM-dd");
        xLabel39.setPreferredSize(new java.awt.Dimension(180, 20));
        xLabel39.setShowCaption(false);
        xFormPanel4.add(xLabel39);

        jPanel1.add(xFormPanel4, java.awt.BorderLayout.EAST);

        xFormPanel2.setCaptionWidth(160);

        xLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        xLabel22.setShowCaption(false);
        xLabel22.setText("Application Info");
        xFormPanel2.add(xLabel22);

        xLabel59.setCaption("App No");
        xLabel59.setExpression("#{entity.appno}");
        xLabel59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel59.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel59);

        xLabel58.setCaption("App Type");
        xLabel58.setExpression("#{entity.apptype}");
        xLabel58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel58.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel58);

        xLabel57.setCaption("Txn Type");
        xLabel57.setExpression("#{entity.txntype}");
        xLabel57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel57.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel57);

        xLabel60.setCaption("App Date");
        xLabel60.setExpression("#{entity.appdate}");
        xLabel60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel60.setDateFormat("yyyy-MM-dd");
        xLabel60.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel60);

        xLabel61.setCaption("Contact Name");
        xLabel61.setExpression("#{entity.contact.name}");
        xLabel61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel61.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel61.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel61);

        xLabel62.setCaption("Contact Email");
        xLabel62.setExpression("#{entity.contact.email}");
        xLabel62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel62.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel62);

        xLabel63.setCaption("Contact Address");
        xLabel63.setExpression("#{entity.contact.address}");
        xLabel63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel63.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel63);

        xLabel19.setExpression("Zone Classification");
        xLabel19.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        xLabel19.setShowCaption(false);
        xFormPanel2.add(xLabel19);

        xLabel55.setCaption("Zone classification");
        xLabel55.setExpression("#{entity.bldgpermit.zoneclass.objid} - #{entity.bldgpermit.zoneclass.title}");
        xLabel55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel55.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel55);

        xLabel56.setCaption("Zone ");
        xLabel56.setExpression("#{entity.bldgpermit.zone}");
        xLabel56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel56.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel56);

        xLabel46.setExpression("Project Supervisor/Contractor");
        xLabel46.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel46.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        xLabel46.setShowCaption(false);
        xFormPanel2.add(xLabel46);

        xLabel31.setCaption("Project Supervisor");
        xLabel31.setExpression("#{ entity.supervisor?.objid == null ? '' : entity.supervisor.lastname + ', ' + entity.supervisor.firstname + '/'+ entity.supervisor.profession + '-PRC No:' + entity.supervisor.prc.idno }");
        xLabel31.setName("entity.inspectiondate"); // NOI18N
        xFormPanel2.add(xLabel31);

        xPanel2.setCaption("Contractor Name");
        xPanel2.setPreferredSize(new java.awt.Dimension(0, 29));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0);
        flowLayout1.setAlignOnBaseline(true);
        xPanel2.setLayout(flowLayout1);

        xLabel18.setCaption("Contractor");
        xLabel18.setExpression("#{ entity.contractor.name }");
        xLabel18.setName("entity.contractor"); // NOI18N
        xLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel18.setPreferredSize(new java.awt.Dimension(250, 25));
        xPanel2.add(xLabel18);

        xButton2.setName("editContractor"); // NOI18N
        xButton2.setIconResource("images/toolbars/edit.png");
        xButton2.setImmediate(true);
        xButton2.setPreferredSize(new java.awt.Dimension(30, 29));
        xButton2.setTarget("");
        xPanel2.add(xButton2);

        xFormPanel2.add(xPanel2);

        xLabel45.setExpression("Inspection Date");
        xLabel45.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xLabel45.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        xLabel45.setShowCaption(false);
        xFormPanel2.add(xLabel45);

        xLabel20.setCaption("Inspection Date");
        xLabel20.setExpression("#{ entity.inspectiondate }");
        xLabel20.setName("entity.inspectiondate"); // NOI18N
        xLabel20.setDateFormat("yyyy-MMM-dd HH:mm");
        xFormPanel2.add(xLabel20);

        xLabel17.setCaption("");
        xLabel17.setExpression("Occupancy Permit Info");
        xLabel17.setName("zonetitle"); // NOI18N
        xLabel17.setVisibleWhen("#{ entity.controlno != null }");
        xLabel17.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        xLabel17.setShowCaption(false);
        xFormPanel2.add(xLabel17);

        xLabel40.setCaption("Permit No");
        xLabel40.setExpression("#{entity.controlno}");
        xLabel40.setVisibleWhen("#{ entity.controlno != null }");
        xLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel40.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel40);

        xLabel41.setCaption("Permit Date Issued");
        xLabel41.setExpression("#{entity.dtissued}");
        xLabel41.setVisibleWhen("#{ entity.controlno != null }");
        xLabel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel41.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel41);

        xLabel42.setCaption("Date Issued");
        xLabel42.setExpression("#{entity.payment.refdate} ");
        xLabel42.setVisibleWhen("#{ entity.payment?.objid != null }");
        xLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel42.setDateFormat("yyyy-MM-dd");
        xLabel42.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel42);

        xPanel8.setCaption("Payment Receipt No");
        xPanel8.setVisibleWhen("#{ entity.payment?.objid != null }");
        xPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xPanel8.setCellPadding(new java.awt.Insets(5, 0, 0, 0));
        xPanel8.setOpaque(false);
        xPanel8.setPreferredSize(new java.awt.Dimension(0, 25));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0);
        flowLayout2.setAlignOnBaseline(true);
        xPanel8.setLayout(flowLayout2);

        xLabel44.setExpression("#{ entity.payment.refno } - ( #{ entity.payment.reftype } )");
        xLabel44.setVisibleWhen("#{ entity.payment?.objid != null }");
        xLabel44.setPreferredSize(new java.awt.Dimension(230, 25));
        xPanel8.add(xLabel44);

        xButton1.setName("viewReceipt"); // NOI18N
        xButton1.setIconResource("images/buttons/search.png");
        xButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xButton1ActionPerformed(evt);
            }
        });
        xPanel8.add(xButton1);

        xFormPanel2.add(xPanel8);

        xLabel43.setCaption("Amount Paid");
        xLabel43.setExpression("#{entity.payment.amount} ");
        xLabel43.setVisibleWhen("#{ entity.payment?.objid != null }");
        xLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel43.setNumberFormat("#,##0.00");
        xLabel43.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel2.add(xLabel43);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1125, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(xFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(43, Short.MAX_VALUE)))
        );

        xTabbedPane1.addTab("General Info", jPanel2);

        xPanel1.setLayout(new java.awt.BorderLayout());

        applicationDocumentList1.setAppid("entity.objid");
        applicationDocumentList1.setApptype("occupancy");
        applicationDocumentList1.setEditableWhen("#{ canEdit == true }");
        applicationDocumentList1.setEntitySchemaName("occupancy_application_subdoc");
        applicationDocumentList1.setHandler("docHandler");
        applicationDocumentList1.setSchemaName("vw_occupancy_application_subdoc");
        xPanel1.add(applicationDocumentList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Documents", xPanel1);

        xPanel4.setLayout(new java.awt.BorderLayout());

        applicationRequirementList1.setAppid("entity.objid");
        applicationRequirementList1.setEditableWhen("#{ canEdit == true }");
        applicationRequirementList1.setParentid("");
        applicationRequirementList1.setSchemaName("occupancy_application_requirement");
        xPanel4.add(applicationRequirementList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Requirements", xPanel4);

        xPanel3.setLayout(new java.awt.BorderLayout());

        applicationSubTaskList1.setAppid("entity.objid");
        applicationSubTaskList1.setEditableWhen("#{ canEdit == true }");
        applicationSubTaskList1.setEntitySchemaName("occupancy_inspection");
        applicationSubTaskList1.setSchemaName("vw_occupancy_inspection");
        applicationSubTaskList1.setTypeSchema("occupancy_inspection_type");
        xPanel3.add(applicationSubTaskList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Inspections", xPanel3);

        xPanel5.setLayout(new java.awt.BorderLayout());

        applicationFeeList1.setAppid("entity.objid");
        applicationFeeList1.setEditableWhen("#{ canEdit == true }");
        applicationFeeList1.setEntitySchemaName("occupancy_application_fee");
        applicationFeeList1.setSchemaName("vw_occupancy_application_fee");
        xPanel5.add(applicationFeeList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Assessment", xPanel5);

        add(xTabbedPane1, java.awt.BorderLayout.CENTER);

        xActionBar2.setFormName("formName");
        xActionBar2.setName("appActions"); // NOI18N
        xActionBar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xActionBar2.setDynamic(true);
        xActionBar2.setPreferredSize(new java.awt.Dimension(91, 30));
        add(xActionBar2, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void xButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.gov.etracs.obo.components.ApplicationDocumentList applicationDocumentList1;
    private com.rameses.gov.etracs.obo.components.ApplicationFeeList applicationFeeList1;
    private com.rameses.gov.etracs.obo.components.ApplicationRequirementList applicationRequirementList1;
    private com.rameses.gov.etracs.obo.components.ApplicationSubTaskList applicationSubTaskList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.rameses.rcp.control.XActionBar xActionBar2;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton2;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XFormPanel xFormPanel3;
    private com.rameses.rcp.control.XFormPanel xFormPanel4;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLabel xLabel10;
    private com.rameses.rcp.control.XLabel xLabel11;
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
    private com.rameses.rcp.control.XLabel xLabel22;
    private com.rameses.rcp.control.XLabel xLabel23;
    private com.rameses.rcp.control.XLabel xLabel24;
    private com.rameses.rcp.control.XLabel xLabel25;
    private com.rameses.rcp.control.XLabel xLabel26;
    private com.rameses.rcp.control.XLabel xLabel27;
    private com.rameses.rcp.control.XLabel xLabel28;
    private com.rameses.rcp.control.XLabel xLabel29;
    private com.rameses.rcp.control.XLabel xLabel30;
    private com.rameses.rcp.control.XLabel xLabel31;
    private com.rameses.rcp.control.XLabel xLabel32;
    private com.rameses.rcp.control.XLabel xLabel34;
    private com.rameses.rcp.control.XLabel xLabel35;
    private com.rameses.rcp.control.XLabel xLabel36;
    private com.rameses.rcp.control.XLabel xLabel37;
    private com.rameses.rcp.control.XLabel xLabel38;
    private com.rameses.rcp.control.XLabel xLabel39;
    private com.rameses.rcp.control.XLabel xLabel4;
    private com.rameses.rcp.control.XLabel xLabel40;
    private com.rameses.rcp.control.XLabel xLabel41;
    private com.rameses.rcp.control.XLabel xLabel42;
    private com.rameses.rcp.control.XLabel xLabel43;
    private com.rameses.rcp.control.XLabel xLabel44;
    private com.rameses.rcp.control.XLabel xLabel45;
    private com.rameses.rcp.control.XLabel xLabel46;
    private com.rameses.rcp.control.XLabel xLabel47;
    private com.rameses.rcp.control.XLabel xLabel48;
    private com.rameses.rcp.control.XLabel xLabel5;
    private com.rameses.rcp.control.XLabel xLabel55;
    private com.rameses.rcp.control.XLabel xLabel56;
    private com.rameses.rcp.control.XLabel xLabel57;
    private com.rameses.rcp.control.XLabel xLabel58;
    private com.rameses.rcp.control.XLabel xLabel59;
    private com.rameses.rcp.control.XLabel xLabel6;
    private com.rameses.rcp.control.XLabel xLabel60;
    private com.rameses.rcp.control.XLabel xLabel61;
    private com.rameses.rcp.control.XLabel xLabel62;
    private com.rameses.rcp.control.XLabel xLabel63;
    private com.rameses.rcp.control.XLabel xLabel7;
    private com.rameses.rcp.control.XLabel xLabel8;
    private com.rameses.rcp.control.XLabel xLabel9;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XPanel xPanel3;
    private com.rameses.rcp.control.XPanel xPanel4;
    private com.rameses.rcp.control.XPanel xPanel5;
    private com.rameses.rcp.control.XPanel xPanel8;
    private com.rameses.rcp.control.XTabbedPane xTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
