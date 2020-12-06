/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.obo.occupancy.views;

import com.rameses.osiris2.themes.FormPage;
import com.rameses.rcp.ui.annotations.Template;

/**
 *
 * @author elmonazareno
 */
@Template(FormPage.class)
public class OccupancyApplicationCapturePage extends javax.swing.JPanel {

    /**
     * Creates new form OccupancyApplicationCapturePage
     */
    public OccupancyApplicationCapturePage() {
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

        pnlSearchBldgPermitNo = new com.rameses.rcp.control.XPanel();
        jPanel1 = new javax.swing.JPanel();
        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xTextField1 = new com.rameses.rcp.control.XTextField();
        xButton1 = new com.rameses.rcp.control.XButton();
        xButton2 = new com.rameses.rcp.control.XButton();
        jPanel2 = new javax.swing.JPanel();
        xFormPanel5 = new com.rameses.rcp.control.XFormPanel();
        xLabel35 = new com.rameses.rcp.control.XLabel();
        xLabel67 = new com.rameses.rcp.control.XLabel();
        xLabel66 = new com.rameses.rcp.control.XLabel();
        xLabel3 = new com.rameses.rcp.control.XLabel();
        xLabel7 = new com.rameses.rcp.control.XLabel();
        xLabel21 = new com.rameses.rcp.control.XLabel();
        xLabel53 = new com.rameses.rcp.control.XLabel();
        xLabel54 = new com.rameses.rcp.control.XLabel();
        xLabel65 = new com.rameses.rcp.control.XLabel();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xLabel49 = new com.rameses.rcp.control.XLabel();
        xLabel50 = new com.rameses.rcp.control.XLabel();
        xLabel51 = new com.rameses.rcp.control.XLabel();
        xLabel52 = new com.rameses.rcp.control.XLabel();
        pnlOccupancyApplicationEntry = new com.rameses.rcp.control.XPanel();
        jPanel6 = new javax.swing.JPanel();
        xFormPanel3 = new com.rameses.rcp.control.XFormPanel();
        xLabel46 = new com.rameses.rcp.control.XLabel();
        xTabbedPane2 = new com.rameses.rcp.control.XTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        xFormPanel6 = new com.rameses.rcp.control.XFormPanel();
        xLabel36 = new com.rameses.rcp.control.XLabel();
        xLabel10 = new com.rameses.rcp.control.XLabel();
        xLabel11 = new com.rameses.rcp.control.XLabel();
        xLabel15 = new com.rameses.rcp.control.XLabel();
        xLabel16 = new com.rameses.rcp.control.XLabel();
        xLabel22 = new com.rameses.rcp.control.XLabel();
        xLabel23 = new com.rameses.rcp.control.XLabel();
        xLabel24 = new com.rameses.rcp.control.XLabel();
        xLabel25 = new com.rameses.rcp.control.XLabel();
        xFormPanel7 = new com.rameses.rcp.control.XFormPanel();
        xLabel31 = new com.rameses.rcp.control.XLabel();
        xLabel32 = new com.rameses.rcp.control.XLabel();
        xLabel37 = new com.rameses.rcp.control.XLabel();
        xLabel38 = new com.rameses.rcp.control.XLabel();
        xLabel39 = new com.rameses.rcp.control.XLabel();
        xLabel40 = new com.rameses.rcp.control.XLabel();
        xLabel41 = new com.rameses.rcp.control.XLabel();
        xLabel42 = new com.rameses.rcp.control.XLabel();
        xLabel43 = new com.rameses.rcp.control.XLabel();
        xLabel44 = new com.rameses.rcp.control.XLabel();
        xLabel45 = new com.rameses.rcp.control.XLabel();

        setLayout(new java.awt.CardLayout());

        pnlSearchBldgPermitNo.setVisibleWhen("#{ capturestep == 1 }");
        pnlSearchBldgPermitNo.setLayout(new java.awt.BorderLayout());

        xFormPanel1.setCaptionWidth(150);

        xTextField1.setCaption("Enter Bldg Permit No");
        xTextField1.setDisableWhen("#{ blocksearch == true }");
        xTextField1.setName("bldgpermitno"); // NOI18N
        xTextField1.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xTextField1);

        xButton1.setCaption("");
        xButton1.setName("doSearch"); // NOI18N
        xButton1.setVisibleWhen("#{ blocksearch == false}");
        xButton1.setText("Search");
        xFormPanel1.add(xButton1);

        xButton2.setCaption("");
        xButton2.setName("resetSearch"); // NOI18N
        xButton2.setVisibleWhen("#{ blocksearch == true  }");
        xButton2.setText("Reset");
        xFormPanel1.add(xButton2);

        com.rameses.rcp.control.border.XTitledBorder xTitledBorder1 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder1.setTitle("Building Permit Information");
        jPanel2.setBorder(xTitledBorder1);

        xFormPanel5.setCaptionWidth(190);

        xLabel35.setCaption("Bldg Permit No");
        xLabel35.setExpression("#{entity.bldgpermit.permitno}");
        xLabel35.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel5.add(xLabel35);

        xLabel67.setCaption("Project Title");
        xLabel67.setExpression("#{entity.bldgpermit.title}");
        xLabel67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel67.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel5.add(xLabel67);

        xLabel66.setCaption("Applicant");
        xLabel66.setExpression("#{entity.bldgpermit.applicant.name}");
        xLabel66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel66.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel66.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel5.add(xLabel66);

        xLabel3.setCaption("Occupancy Type ");
        xLabel3.setExpression("<html>#{entity.bldgpermit.occupancytype.title }</html>");
        xLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel3.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel3.setPreferredSize(new java.awt.Dimension(0, 40));
        xFormPanel5.add(xLabel3);

        xLabel7.setCaption("Division");
        xLabel7.setExpression("#{entity.bldgpermit.occupancytype.division.objid}");
        xLabel7.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel5.add(xLabel7);

        xLabel21.setCaption("Group");
        xLabel21.setExpression("#{entity.bldgpermit.occupancytype.group.objid}");
        xLabel21.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel5.add(xLabel21);

        xLabel53.setCaption("Proposed Start Date");
        xLabel53.setExpression("#{entity.bldgpermit.dtproposedconstruction}");
        xLabel53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel53.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel53.setDateFormat("yyyy-MM-dd");
        xLabel53.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel5.add(xLabel53);

        xLabel54.setCaption("Estimated Completion Date");
        xLabel54.setExpression("#{entity.bldgpermit.dtexpectedcompletion}");
        xLabel54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel54.setDateFormat("yyyy-MM-dd");
        xLabel54.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel5.add(xLabel54);

        xLabel65.setCaption("Project Cost");
        xLabel65.setExpression("#{entity.bldgpermit.projectcost}");
        xLabel65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel65.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel65.setNumberFormat("#,##0.00");
        xLabel65.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel5.add(xLabel65);

        xFormPanel2.setCaptionWidth(120);

        xLabel49.setCaption("No. of Units");
        xLabel49.setExpression("#{entity.bldgpermit.numunits}");
        xLabel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel49.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel49);

        xLabel50.setCaption("No. of Storeys");
        xLabel50.setExpression("#{entity.bldgpermit.numfloors}");
        xLabel50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel50.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel50);

        xLabel51.setCaption("Floor Area");
        xLabel51.setExpression("#{entity.bldgpermit.totalfloorarea}");
        xLabel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel51.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel51);

        xLabel52.setCaption("Height");
        xLabel52.setExpression("#{entity.bldgpermit.height}");
        xLabel52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel52.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel52);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(xFormPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xFormPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pnlSearchBldgPermitNo.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(pnlSearchBldgPermitNo, "card3");

        pnlOccupancyApplicationEntry.setVisibleWhen("#{ capturestep == 2 }");
        pnlOccupancyApplicationEntry.setLayout(new java.awt.BorderLayout());

        jPanel6.setPreferredSize(new java.awt.Dimension(0, 80));

        xLabel46.setCaption("Bldg Permit No");
        xLabel46.setExpression("#{entity.bldgpermit.permitno}");
        xLabel46.setCaptionWidth(150);
        xLabel46.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xLabel46);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(xFormPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(544, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(xFormPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pnlOccupancyApplicationEntry.add(jPanel6, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 998, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        xTabbedPane2.addTab("tab1", jPanel7);

        com.rameses.rcp.control.border.XTitledBorder xTitledBorder2 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder2.setTitle("General Info");
        jPanel9.setBorder(xTitledBorder2);

        xFormPanel6.setCaptionWidth(190);

        xLabel36.setCaption("Bldg Permit No");
        xLabel36.setExpression("#{entity.bldgpermit.permitno}");
        xLabel36.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel6.add(xLabel36);

        xLabel10.setCaption("Project Title");
        xLabel10.setExpression("#{entity.title}");
        xLabel10.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel6.add(xLabel10);

        xLabel11.setCaption("Location");
        xLabel11.setExpression("#{entity.location.text}");
        xLabel11.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel6.add(xLabel11);

        xLabel15.setCaption("Applicant");
        xLabel15.setExpression("#{entity.applicant.name}");
        xLabel15.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel6.add(xLabel15);

        xLabel16.setCaption("Occupancy Type ");
        xLabel16.setExpression("<html>#{entity.occupancytype.title}</html>");
        xLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xLabel16.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel16.setPreferredSize(new java.awt.Dimension(0, 40));
        xFormPanel6.add(xLabel16);

        xLabel22.setCaption("Contact Name");
        xLabel22.setExpression("#{entity.contact.name}");
        xLabel22.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel22.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel6.add(xLabel22);

        xLabel23.setCaption("Contact Description");
        xLabel23.setExpression("#{entity.contact.description}");
        xLabel23.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel6.add(xLabel23);

        xLabel24.setCaption("Contact Email");
        xLabel24.setExpression("#{entity.contact.email}");
        xLabel24.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel6.add(xLabel24);

        xLabel25.setCaption("Contact Phone");
        xLabel25.setExpression("#{entity.contact.mobileno}");
        xLabel25.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel6.add(xLabel25);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(xFormPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        xFormPanel7.setCaption("");
        com.rameses.rcp.control.border.XTitledBorder xTitledBorder3 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder3.setPadding(new java.awt.Insets(20, 10, 10, 10));
        xTitledBorder3.setTitle("Application Info");
        xFormPanel7.setBorder(xTitledBorder3);
        xFormPanel7.setCaptionWidth(180);
        xFormPanel7.setPreferredSize(new java.awt.Dimension(0, 100));

        xLabel31.setCaption("Permit No");
        xLabel31.setExpression("#{entity.permitno}");
        xLabel31.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel7.add(xLabel31);

        xLabel32.setCaption("Permit Date Issued");
        xLabel32.setExpression("#{entity.dtissued}");
        xLabel32.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel7.add(xLabel32);

        xLabel37.setCaption("App No");
        xLabel37.setExpression("#{entity.appno}");
        xLabel37.setName("entity.rptinfo.text"); // NOI18N
        xLabel37.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel7.add(xLabel37);

        xLabel38.setCaption("App Date");
        xLabel38.setExpression("#{entity.dtfiled}");
        xLabel38.setName("entity.rptinfo.text"); // NOI18N
        xLabel38.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel7.add(xLabel38);

        xLabel39.setCaption("App Type");
        xLabel39.setExpression("#{entity.apptype}");
        xLabel39.setName("entity.rptinfo.text"); // NOI18N
        xLabel39.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel7.add(xLabel39);

        xLabel40.setCaption("Web Tracking No");
        xLabel40.setExpression("#{entity.trackingno}");
        xLabel40.setName("entity.trackingno"); // NOI18N
        xLabel40.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel7.add(xLabel40);

        xLabel41.setCaption("Task State");
        xLabel41.setExpression("#{entity.task.state}");
        xLabel41.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel41.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel7.add(xLabel41);

        xLabel42.setCaption("Task Start");
        xLabel42.setExpression("#{entity.task.startdate}");
        xLabel42.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel7.add(xLabel42);

        xLabel43.setCaption("Task Assign To");
        xLabel43.setExpression("#{entity.task.assignee.name}");
        xLabel43.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel7.add(xLabel43);

        xLabel44.setCaption("Elapsed Time");
        xLabel44.setExpression("#{entity.task.elapsedtime}");
        xLabel44.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel7.add(xLabel44);

        xLabel45.setCaption("Inspection Date");
        xLabel45.setExpression("#{entity.inspectiondate}");
        xLabel45.setCellPadding(new java.awt.Insets(20, 0, 0, 0));
        xLabel45.setPreferredSize(new java.awt.Dimension(0, 16));
        xFormPanel7.add(xLabel45);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xFormPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(xFormPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        xTabbedPane2.addTab("Application Info", jPanel8);

        pnlOccupancyApplicationEntry.add(xTabbedPane2, java.awt.BorderLayout.CENTER);

        add(pnlOccupancyApplicationEntry, "card3");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private com.rameses.rcp.control.XPanel pnlOccupancyApplicationEntry;
    private com.rameses.rcp.control.XPanel pnlSearchBldgPermitNo;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton2;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XFormPanel xFormPanel3;
    private com.rameses.rcp.control.XFormPanel xFormPanel5;
    private com.rameses.rcp.control.XFormPanel xFormPanel6;
    private com.rameses.rcp.control.XFormPanel xFormPanel7;
    private com.rameses.rcp.control.XLabel xLabel10;
    private com.rameses.rcp.control.XLabel xLabel11;
    private com.rameses.rcp.control.XLabel xLabel15;
    private com.rameses.rcp.control.XLabel xLabel16;
    private com.rameses.rcp.control.XLabel xLabel21;
    private com.rameses.rcp.control.XLabel xLabel22;
    private com.rameses.rcp.control.XLabel xLabel23;
    private com.rameses.rcp.control.XLabel xLabel24;
    private com.rameses.rcp.control.XLabel xLabel25;
    private com.rameses.rcp.control.XLabel xLabel3;
    private com.rameses.rcp.control.XLabel xLabel31;
    private com.rameses.rcp.control.XLabel xLabel32;
    private com.rameses.rcp.control.XLabel xLabel35;
    private com.rameses.rcp.control.XLabel xLabel36;
    private com.rameses.rcp.control.XLabel xLabel37;
    private com.rameses.rcp.control.XLabel xLabel38;
    private com.rameses.rcp.control.XLabel xLabel39;
    private com.rameses.rcp.control.XLabel xLabel40;
    private com.rameses.rcp.control.XLabel xLabel41;
    private com.rameses.rcp.control.XLabel xLabel42;
    private com.rameses.rcp.control.XLabel xLabel43;
    private com.rameses.rcp.control.XLabel xLabel44;
    private com.rameses.rcp.control.XLabel xLabel45;
    private com.rameses.rcp.control.XLabel xLabel46;
    private com.rameses.rcp.control.XLabel xLabel49;
    private com.rameses.rcp.control.XLabel xLabel50;
    private com.rameses.rcp.control.XLabel xLabel51;
    private com.rameses.rcp.control.XLabel xLabel52;
    private com.rameses.rcp.control.XLabel xLabel53;
    private com.rameses.rcp.control.XLabel xLabel54;
    private com.rameses.rcp.control.XLabel xLabel65;
    private com.rameses.rcp.control.XLabel xLabel66;
    private com.rameses.rcp.control.XLabel xLabel67;
    private com.rameses.rcp.control.XLabel xLabel7;
    private com.rameses.rcp.control.XTabbedPane xTabbedPane2;
    private com.rameses.rcp.control.XTextField xTextField1;
    // End of variables declaration//GEN-END:variables
}