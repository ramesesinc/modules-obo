package com.rameses.gov.etracs.obo.building.views;


import com.rameses.rcp.ui.annotations.Template;
import com.rameses.seti2.views.WorkflowTaskFormPage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elmonazareno
 */
@Template(WorkflowTaskFormPage.class)
public class BuildingApplicationPage extends javax.swing.JPanel {

    /**
     * Creates new form BuildingApplicationPage1
     */
    public BuildingApplicationPage() {
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

        xActionBar2 = new com.rameses.rcp.control.XActionBar();
        xTabbedPane1 = new com.rameses.rcp.control.XTabbedPane();
        pnlProject = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xLabel8 = new com.rameses.rcp.control.XLabel();
        xLabel7 = new com.rameses.rcp.control.XLabel();
        xLabel6 = new com.rameses.rcp.control.XLabel();
        xPanel9 = new com.rameses.rcp.control.XPanel();
        xLabel11 = new com.rameses.rcp.control.XLabel();
        xButton2 = new com.rameses.rcp.control.XButton();
        xLabel10 = new com.rameses.rcp.control.XLabel();
        xLabel32 = new com.rameses.rcp.control.XLabel();
        xLabel36 = new com.rameses.rcp.control.XLabel();
        xLabel37 = new com.rameses.rcp.control.XLabel();
        xLabel34 = new com.rameses.rcp.control.XLabel();
        xLabel35 = new com.rameses.rcp.control.XLabel();
        xLabel15 = new com.rameses.rcp.control.XLabel();
        xLabel16 = new com.rameses.rcp.control.XLabel();
        xLabel2 = new com.rameses.rcp.control.XLabel();
        xLabel55 = new com.rameses.rcp.control.XLabel();
        xLabel56 = new com.rameses.rcp.control.XLabel();
        xFormPanel3 = new com.rameses.rcp.control.XFormPanel();
        xLabel5 = new com.rameses.rcp.control.XLabel();
        xLabel12 = new com.rameses.rcp.control.XLabel();
        xLabel14 = new com.rameses.rcp.control.XLabel();
        xLabel9 = new com.rameses.rcp.control.XLabel();
        xLabel38 = new com.rameses.rcp.control.XLabel();
        xLabel26 = new com.rameses.rcp.control.XLabel();
        xLabel17 = new com.rameses.rcp.control.XLabel();
        xLabel19 = new com.rameses.rcp.control.XLabel();
        xLabel20 = new com.rameses.rcp.control.XLabel();
        xPanel10 = new com.rameses.rcp.control.XPanel();
        xLabel3 = new com.rameses.rcp.control.XLabel();
        xButton3 = new com.rameses.rcp.control.XButton();
        xLabel29 = new com.rameses.rcp.control.XLabel();
        xLabel30 = new com.rameses.rcp.control.XLabel();
        xLabel39 = new com.rameses.rcp.control.XLabel();
        xPanel8 = new com.rameses.rcp.control.XPanel();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        xButton1 = new com.rameses.rcp.control.XButton();
        xLabel40 = new com.rameses.rcp.control.XLabel();
        xPanel2 = new com.rameses.rcp.control.XPanel();
        applicationDocumentList1 = new com.rameses.gov.etracs.obo.components.ApplicationDocumentList();
        xPanel3 = new com.rameses.rcp.control.XPanel();
        applicationRequirementList1 = new com.rameses.gov.etracs.obo.components.ApplicationRequirementList();
        jPanel2 = new javax.swing.JPanel();
        buildingApplicationRptList1 = new com.rameses.gov.etracs.obo.building.components.BuildingApplicationRptList();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        applicationSubTaskList1 = new com.rameses.gov.etracs.obo.components.ApplicationSubTaskList();
        xPanel4 = new com.rameses.rcp.control.XPanel();
        applicationFindingList2 = new com.rameses.gov.etracs.obo.components.ApplicationFindingList();
        xPanel5 = new com.rameses.rcp.control.XPanel();
        transmittalList1 = new com.rameses.gov.etracs.obo.components.TransmittalList();
        xPanel6 = new com.rameses.rcp.control.XPanel();
        professionalList1 = new com.rameses.gov.etracs.obo.components.ProfessionalList();
        xPanel7 = new com.rameses.rcp.control.XPanel();
        applicationFeeList1 = new com.rameses.gov.etracs.obo.components.ApplicationFeeList();

        setPreferredSize(new java.awt.Dimension(1050, 620));
        setLayout(new java.awt.BorderLayout());

        xActionBar2.setFormName("formName");
        xActionBar2.setName("appActions"); // NOI18N
        xActionBar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xActionBar2.setDynamic(true);
        xActionBar2.setPreferredSize(new java.awt.Dimension(91, 30));
        add(xActionBar2, java.awt.BorderLayout.NORTH);

        xTabbedPane1.setDynamic(true);

        pnlProject.setPreferredSize(new java.awt.Dimension(999, 500));

        com.rameses.rcp.control.border.XTitledBorder xTitledBorder1 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder1.setPadding(new java.awt.Insets(20, 10, 10, 10));
        xTitledBorder1.setTitle("Project Information");
        xFormPanel1.setBorder(xTitledBorder1);
        xFormPanel1.setCaptionWidth(190);
        xFormPanel1.setPreferredSize(new java.awt.Dimension(200, 300));

        xLabel8.setCaption("Project Title");
        xLabel8.setExpression("<html>#{entity.title}</html>");
        xLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel8.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel8);

        xLabel7.setCaption("Project Description");
        xLabel7.setExpression("<html>#{entity.description}</html>");
        xLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel7.setPreferredSize(new java.awt.Dimension(0, 40));
        xFormPanel1.add(xLabel7);

        xLabel6.setCaption("Location");
        xLabel6.setExpression("<html>#{entity.location.text?.replace('\\n', '<br>')}</html>");
        xLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel6.setPreferredSize(new java.awt.Dimension(0, 40));
        xFormPanel1.add(xLabel6);

        xPanel9.setCaption("Applicant");
        xPanel9.setCellPadding(new java.awt.Insets(10, 0, 0, 0));
        xPanel9.setOpaque(false);
        xPanel9.setPreferredSize(new java.awt.Dimension(0, 29));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0);
        flowLayout2.setAlignOnBaseline(true);
        xPanel9.setLayout(flowLayout2);

        xLabel11.setCaption("Applicant");
        xLabel11.setExpression("#{ entity.applicant.name }");
        xLabel11.setName("entity.applicant"); // NOI18N
        xLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel11.setPreferredSize(new java.awt.Dimension(320, 25));
        xPanel9.add(xLabel11);

        xButton2.setName("viewApplicant"); // NOI18N
        xButton2.setIconResource("images/buttons/search.png");
        xButton2.setImmediate(true);
        xButton2.setPreferredSize(new java.awt.Dimension(30, 29));
        xButton2.setTarget("");
        xPanel9.add(xButton2);

        xFormPanel1.add(xPanel9);

        xLabel10.setCaption("No. of Units");
        xLabel10.setExpression("#{entity.numunits}");
        xLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel10.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel10.setPreferredSize(new java.awt.Dimension(150, 20));
        xFormPanel1.add(xLabel10);

        xLabel32.setCaption("No. of Storeys");
        xLabel32.setExpression("#{entity.numfloors}");
        xLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel32.setPreferredSize(new java.awt.Dimension(150, 20));
        xFormPanel1.add(xLabel32);

        xLabel36.setCaption("Total Floor Area");
        xLabel36.setExpression("#{entity.totalfloorarea}");
        xLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        xLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel36.setNumberFormat("##0.00");
        xLabel36.setPreferredSize(new java.awt.Dimension(150, 20));
        xFormPanel1.add(xLabel36);

        xLabel37.setCaption("Bldg Height");
        xLabel37.setExpression("#{entity.height}");
        xLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        xLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel37.setNumberFormat("##0.00");
        xLabel37.setPreferredSize(new java.awt.Dimension(150, 20));
        xFormPanel1.add(xLabel37);

        xLabel34.setCaption("Est. Project Cost");
        xLabel34.setExpression("#{entity.projectcost}");
        xLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xLabel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel34.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel34.setNumberFormat("#,##0.00");
        xLabel34.setPreferredSize(new java.awt.Dimension(180, 20));
        xFormPanel1.add(xLabel34);

        xLabel35.setCaption("Fixed Unit Cost (computed)");
        xLabel35.setExpression("#{entity.fixedcost}");
        xLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xLabel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel35.setNumberFormat("#,##0.00");
        xLabel35.setPreferredSize(new java.awt.Dimension(180, 20));
        xFormPanel1.add(xLabel35);

        xLabel15.setCaption("Const. Date");
        xLabel15.setExpression("#{entity.dtproposedconstruction}");
        xLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel15.setDateFormat("yyyy MMM dd");
        xLabel15.setPreferredSize(new java.awt.Dimension(180, 20));
        xFormPanel1.add(xLabel15);

        xLabel16.setCaption("Est. Completion Date");
        xLabel16.setExpression("#{entity.dtexpectedcompletion}");
        xLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel16.setDateFormat("yyyy MMM dd");
        xLabel16.setPreferredSize(new java.awt.Dimension(180, 20));
        xFormPanel1.add(xLabel16);

        xLabel2.setCaption("Occupancy Type ");
        xLabel2.setExpression("<html>#{entity.occupancytype.group.objid} ( #{entity.occupancytype.division.objid} ) - #{entity.occupancytype.title }</html>");
        xLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel2.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel2.setPreferredSize(new java.awt.Dimension(0, 40));
        xFormPanel1.add(xLabel2);

        xLabel55.setCaption("Zone classification");
        xLabel55.setExpression("#{entity.zoneclass.objid} - #{entity.zoneclass.title}");
        xLabel55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel55.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel55.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel55);

        xLabel56.setCaption("Zone ");
        xLabel56.setExpression("#{entity.zone}");
        xLabel56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel56.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xLabel56);

        xFormPanel3.setCaption("");
        com.rameses.rcp.control.border.XTitledBorder xTitledBorder2 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder2.setPadding(new java.awt.Insets(20, 10, 10, 10));
        xTitledBorder2.setTitle("Application Info");
        xFormPanel3.setBorder(xTitledBorder2);
        xFormPanel3.setCaptionWidth(180);
        xFormPanel3.setPreferredSize(new java.awt.Dimension(0, 100));

        xLabel5.setCaption("App No");
        xLabel5.setExpression("#{entity.appno}");
        xLabel5.setName("entity.rptinfo.text"); // NOI18N
        xLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel5.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel5);

        xLabel12.setCaption("App Date");
        xLabel12.setExpression("#{entity.appdate}");
        xLabel12.setName("entity.rptinfo.text"); // NOI18N
        xLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel12.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel12);

        xLabel14.setCaption("App Type");
        xLabel14.setExpression("#{entity.apptype}");
        xLabel14.setName("entity.rptinfo.text"); // NOI18N
        xLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel14.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel14);

        xLabel9.setCaption("Web Tracking No");
        xLabel9.setExpression("#{entity.trackingno}");
        xLabel9.setName("entity.trackingno"); // NOI18N
        xLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel9.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel9);

        xLabel38.setCaption("Txn Type");
        xLabel38.setExpression("#{entity.txntype}");
        xLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel38.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel38.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel38);

        xLabel26.setCaption("Task State");
        xLabel26.setExpression("#{entity.task.state}");
        xLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel26.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel26);

        xLabel17.setCaption("Contact Name");
        xLabel17.setExpression("#{entity.contact.name} ( #{entity.contact.description} )");
        xLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel17.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel17.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel17);

        xLabel19.setCaption("Contact Email");
        xLabel19.setExpression("#{entity.contact.email}");
        xLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel19.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel19);

        xLabel20.setCaption("Contact Mobile No");
        xLabel20.setExpression("#{entity.contact.mobileno}");
        xLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel20.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel20);

        xPanel10.setCaption("Project Supervisor");
        xPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xPanel10.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xPanel10.setOpaque(false);
        xPanel10.setPreferredSize(new java.awt.Dimension(0, 25));
        java.awt.FlowLayout flowLayout3 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0);
        flowLayout3.setAlignOnBaseline(true);
        xPanel10.setLayout(flowLayout3);

        xLabel3.setExpression("#{entity.supervisor.lastname}, #{entity.supervisor.firstname} -  ( PRC No: #{entity.supervisor.prc.idno} )");
        xLabel3.setVisibleWhen("#{ entity.supervisor?.objid != null }");
        xLabel3.setPreferredSize(new java.awt.Dimension(230, 25));
        xPanel10.add(xLabel3);

        xButton3.setDisableWhen("#{ !entity.contractor }");
        xButton3.setName("viewProfessional"); // NOI18N
        xButton3.setVisibleWhen("#{ entity.contractor?.objid != null}");
        xButton3.setIconResource("images/buttons/search.png");
        xButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xButton3ActionPerformed(evt);
            }
        });
        xPanel10.add(xButton3);

        xFormPanel3.add(xPanel10);

        xLabel29.setCaption("Permit No");
        xLabel29.setExpression("#{entity.controlno}");
        xLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel29.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel29.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel29);

        xLabel30.setCaption("Permit Date Issued");
        xLabel30.setExpression("#{entity.dtissued}");
        xLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel30.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel30);

        xLabel39.setCaption("Date Issued");
        xLabel39.setExpression("#{entity.payment.refdate} ");
        xLabel39.setVisibleWhen("#{ entity.payment?.objid != null }");
        xLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel39.setDateFormat("yyyy-MM-dd");
        xLabel39.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel39);

        xPanel8.setCaption("Payment Receipt No");
        xPanel8.setVisibleWhen("#{ entity.payment?.objid != null }");
        xPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xPanel8.setCellPadding(new java.awt.Insets(5, 0, 0, 0));
        xPanel8.setOpaque(false);
        xPanel8.setPreferredSize(new java.awt.Dimension(0, 25));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0);
        flowLayout1.setAlignOnBaseline(true);
        xPanel8.setLayout(flowLayout1);

        xLabel1.setExpression("#{ entity.payment.refno } - ( #{ entity.payment.reftype } )");
        xLabel1.setPreferredSize(new java.awt.Dimension(230, 25));
        xPanel8.add(xLabel1);

        xButton1.setName("viewReceipt"); // NOI18N
        xButton1.setIconResource("images/buttons/search.png");
        xButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xButton1ActionPerformed(evt);
            }
        });
        xPanel8.add(xButton1);

        xFormPanel3.add(xPanel8);

        xLabel40.setCaption("Amount Paid");
        xLabel40.setExpression("#{entity.payment.amount} ");
        xLabel40.setVisibleWhen("#{ entity.payment?.objid != null }");
        xLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel40.setNumberFormat("#,##0.00");
        xLabel40.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel3.add(xLabel40);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xFormPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addComponent(xFormPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout pnlProjectLayout = new javax.swing.GroupLayout(pnlProject);
        pnlProject.setLayout(pnlProjectLayout);
        pnlProjectLayout.setHorizontalGroup(
            pnlProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProjectLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlProjectLayout.setVerticalGroup(
            pnlProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProjectLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        xTabbedPane1.addTab("Project Details", pnlProject);

        xPanel2.setLayout(new java.awt.BorderLayout());

        applicationDocumentList1.setAppid("entity.objid");
        applicationDocumentList1.setApptype("building");
        applicationDocumentList1.setEditableWhen("#{ canEdit == true }");
        applicationDocumentList1.setEntitySchemaName("building_application_subdoc");
        applicationDocumentList1.setHandler("docHandler");
        applicationDocumentList1.setSchemaName("vw_building_application_subdoc");
        xPanel2.add(applicationDocumentList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Documents", xPanel2);

        xPanel3.setLayout(new java.awt.BorderLayout());

        applicationRequirementList1.setAppid("entity.objid");
        applicationRequirementList1.setEditableWhen("#{ canEdit == true }");
        applicationRequirementList1.setParentid("");
        applicationRequirementList1.setSchemaName("building_application_requirement");
        xPanel3.add(applicationRequirementList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Requirements", xPanel3);

        jPanel2.setLayout(new java.awt.BorderLayout());

        buildingApplicationRptList1.setAppid("entity.objid");
        buildingApplicationRptList1.setEditableWhen("#{ true }");
        jPanel2.add(buildingApplicationRptList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Real Property", jPanel2);

        xPanel1.setLayout(new java.awt.BorderLayout());

        applicationSubTaskList1.setAppid("entity.objid");
        applicationSubTaskList1.setEditableWhen("#{ canEdit == true }");
        applicationSubTaskList1.setEntitySchemaName("building_evaluation");
        applicationSubTaskList1.setSchemaName("vw_building_evaluation");
        applicationSubTaskList1.setTypeSchema("building_evaluation_type");
        xPanel1.add(applicationSubTaskList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Evaluations", xPanel1);

        xPanel4.setLayout(new java.awt.BorderLayout());

        applicationFindingList2.setAppid("entity.objid");
        applicationFindingList2.setEditableWhen("#{ canEdit == true }");
        applicationFindingList2.setSchemaName("building_evaluation_finding");
        applicationFindingList2.setSectionTitle("entity.type.title");
        xPanel4.add(applicationFindingList2, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Findings", xPanel4);

        xPanel5.setLayout(new java.awt.BorderLayout());

        transmittalList1.setAppid("entity.objid");
        transmittalList1.setSchemaName("building_application_transmittal");
        xPanel5.add(transmittalList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Transmittals", xPanel5);

        xPanel6.setLayout(new java.awt.BorderLayout());

        professionalList1.setHandler("professionalListHandler");
        xPanel6.add(professionalList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Professionals", xPanel6);

        xPanel7.setLayout(new java.awt.BorderLayout());

        applicationFeeList1.setAppid("entity.objid");
        applicationFeeList1.setEditableWhen("#{ canEdit == true }");
        applicationFeeList1.setEntitySchemaName("building_application_fee");
        applicationFeeList1.setSchemaName("vw_building_application_fee");
        xPanel7.add(applicationFeeList1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("Assessment", xPanel7);

        add(xTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void xButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xButton1ActionPerformed

    private void xButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.gov.etracs.obo.components.ApplicationDocumentList applicationDocumentList1;
    private com.rameses.gov.etracs.obo.components.ApplicationFeeList applicationFeeList1;
    private com.rameses.gov.etracs.obo.components.ApplicationFindingList applicationFindingList2;
    private com.rameses.gov.etracs.obo.components.ApplicationRequirementList applicationRequirementList1;
    private com.rameses.gov.etracs.obo.components.ApplicationSubTaskList applicationSubTaskList1;
    private com.rameses.gov.etracs.obo.building.components.BuildingApplicationRptList buildingApplicationRptList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlProject;
    private com.rameses.gov.etracs.obo.components.ProfessionalList professionalList1;
    private com.rameses.gov.etracs.obo.components.TransmittalList transmittalList1;
    private com.rameses.rcp.control.XActionBar xActionBar2;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton2;
    private com.rameses.rcp.control.XButton xButton3;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XFormPanel xFormPanel3;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLabel xLabel10;
    private com.rameses.rcp.control.XLabel xLabel11;
    private com.rameses.rcp.control.XLabel xLabel12;
    private com.rameses.rcp.control.XLabel xLabel14;
    private com.rameses.rcp.control.XLabel xLabel15;
    private com.rameses.rcp.control.XLabel xLabel16;
    private com.rameses.rcp.control.XLabel xLabel17;
    private com.rameses.rcp.control.XLabel xLabel19;
    private com.rameses.rcp.control.XLabel xLabel2;
    private com.rameses.rcp.control.XLabel xLabel20;
    private com.rameses.rcp.control.XLabel xLabel26;
    private com.rameses.rcp.control.XLabel xLabel29;
    private com.rameses.rcp.control.XLabel xLabel3;
    private com.rameses.rcp.control.XLabel xLabel30;
    private com.rameses.rcp.control.XLabel xLabel32;
    private com.rameses.rcp.control.XLabel xLabel34;
    private com.rameses.rcp.control.XLabel xLabel35;
    private com.rameses.rcp.control.XLabel xLabel36;
    private com.rameses.rcp.control.XLabel xLabel37;
    private com.rameses.rcp.control.XLabel xLabel38;
    private com.rameses.rcp.control.XLabel xLabel39;
    private com.rameses.rcp.control.XLabel xLabel40;
    private com.rameses.rcp.control.XLabel xLabel5;
    private com.rameses.rcp.control.XLabel xLabel55;
    private com.rameses.rcp.control.XLabel xLabel56;
    private com.rameses.rcp.control.XLabel xLabel6;
    private com.rameses.rcp.control.XLabel xLabel7;
    private com.rameses.rcp.control.XLabel xLabel8;
    private com.rameses.rcp.control.XLabel xLabel9;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XPanel xPanel10;
    private com.rameses.rcp.control.XPanel xPanel2;
    private com.rameses.rcp.control.XPanel xPanel3;
    private com.rameses.rcp.control.XPanel xPanel4;
    private com.rameses.rcp.control.XPanel xPanel5;
    private com.rameses.rcp.control.XPanel xPanel6;
    private com.rameses.rcp.control.XPanel xPanel7;
    private com.rameses.rcp.control.XPanel xPanel8;
    private com.rameses.rcp.control.XPanel xPanel9;
    private com.rameses.rcp.control.XTabbedPane xTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
