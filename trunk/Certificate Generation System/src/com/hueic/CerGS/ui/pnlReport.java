/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pnlReport.java
 *
 * Created on Apr 2, 2011, 9:18:42 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.ui.report.pnlStudentReport;
import javax.swing.JPanel;

/**
 *
 * @author nhchung
 */
public class pnlReport extends javax.swing.JPanel {

    /** Creates new form pnlReport */
    frmMain main;
    JPanel pnlOld = null;

    public pnlReport(frmMain main) {
        initComponents();
        this.main = main;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tabpanel1 = new javax.swing.JTabbedPane();
        panel4 = new javax.swing.JPanel();
        panel5 = new javax.swing.JPanel();
        panel6 = new javax.swing.JPanel();
        panel7 = new javax.swing.JPanel();
        panel8 = new javax.swing.JPanel();
        panel9 = new javax.swing.JPanel();
        panel10 = new javax.swing.JPanel();
        pnlViewReport = new javax.swing.JPanel();
        panel11 = new javax.swing.JPanel();
        btnCreate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(860, 600));
        setPreferredSize(new java.awt.Dimension(860, 600));
        setLayout(new java.awt.GridBagLayout());

        tabpanel1.setMaximumSize(new java.awt.Dimension(860, 550));
        tabpanel1.setMinimumSize(new java.awt.Dimension(860, 550));
        tabpanel1.setOpaque(true);
        tabpanel1.setPreferredSize(new java.awt.Dimension(860, 550));
        tabpanel1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabpanel1StateChanged(evt);
            }
        });

        panel4.setBackground(new java.awt.Color(255, 255, 255));
        panel4.setLayout(new java.awt.GridBagLayout());
        tabpanel1.addTab("Certificate Develop", panel4);

        panel5.setBackground(new java.awt.Color(255, 255, 255));
        panel5.setLayout(new java.awt.GridBagLayout());
        tabpanel1.addTab("Employee", panel5);

        panel6.setBackground(new java.awt.Color(255, 255, 255));
        panel6.setLayout(new java.awt.GridBagLayout());
        tabpanel1.addTab("Student New Registration", panel6);

        panel7.setBackground(new java.awt.Color(255, 255, 255));
        panel7.setLayout(new java.awt.GridBagLayout());
        tabpanel1.addTab("Student", panel7);

        panel8.setBackground(new java.awt.Color(255, 255, 255));
        panel8.setLayout(new java.awt.GridBagLayout());
        tabpanel1.addTab("Student Fee", panel8);

        panel9.setBackground(new java.awt.Color(255, 255, 255));
        panel9.setLayout(new java.awt.GridBagLayout());
        tabpanel1.addTab("Student Mark", panel9);

        panel10.setBackground(new java.awt.Color(255, 255, 255));
        panel10.setLayout(new java.awt.GridBagLayout());
        tabpanel1.addTab("Subject In Course", panel10);

        pnlViewReport.setBackground(new java.awt.Color(255, 255, 255));
        tabpanel1.addTab("View Report", pnlViewReport);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tabpanel1, gridBagConstraints);

        panel11.setBackground(new java.awt.Color(255, 255, 255));

        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        btnCreate.setText("Report");
        btnCreate.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCreate.setMaximumSize(new java.awt.Dimension(80, 23));
        btnCreate.setMinimumSize(new java.awt.Dimension(80, 23));
        btnCreate.setPreferredSize(new java.awt.Dimension(80, 23));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        panel11.add(btnCreate);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(panel11, gridBagConstraints);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow_left_green.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.setMaximumSize(new java.awt.Dimension(80, 25));
        btnBack.setMinimumSize(new java.awt.Dimension(80, 25));
        btnBack.setPreferredSize(new java.awt.Dimension(80, 25));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(btnBack, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void tabpanel1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabpanel1StateChanged
        // TODO add your handling code here:
}//GEN-LAST:event_tabpanel1StateChanged

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        pnlOld = (JPanel) this.tabpanel1.getSelectedComponent();
        this.pnlViewReport.add(new pnlStudentReport("ARENA"));
        this.tabpanel1.setSelectedComponent(pnlViewReport);
        this.btnBack.setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.tabpanel1.setSelectedComponent(pnlOld);
        this.btnBack.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed
    public void reportCertificateDevelop() {
    }

    public void reportEmployee() {
    }

    public void reportNewStudentRegistration() {
    }

    public void reportStudent() {
    }

    public void reportStudentFee() {
    }

    public void reportStudentMark() {
    }

    public void reportSubjectInCourse() {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JPanel panel10;
    private javax.swing.JPanel panel11;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JPanel panel7;
    private javax.swing.JPanel panel8;
    private javax.swing.JPanel panel9;
    private javax.swing.JPanel pnlViewReport;
    private javax.swing.JTabbedPane tabpanel1;
    // End of variables declaration//GEN-END:variables
}
