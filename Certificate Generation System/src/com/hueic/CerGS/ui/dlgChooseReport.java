/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * dlgChooseReport.java
 *
 * Created on Apr 2, 2011, 9:35:36 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.ui.report.pnlCertificateDevelopedReport;
import com.hueic.CerGS.ui.report.pnlCertificateReport;
import com.hueic.CerGS.ui.report.pnlEmployeeReport;
import com.hueic.CerGS.ui.report.pnlStudentFeeReport;
import com.hueic.CerGS.ui.report.pnlStudentMarkReport;
import com.hueic.CerGS.ui.report.pnlStudentNewRegistrationReport;
import com.hueic.CerGS.ui.report.pnlStudentReport;
import com.hueic.CerGS.ui.report.pnlSubjectInCourseReport;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author nhchung
 */
public class dlgChooseReport extends javax.swing.JPanel {

    pnlCertificateReport cerReport;
    pnlCertificateDevelopedReport cerDevReport;
    pnlEmployeeReport empReport;
    pnlStudentFeeReport feeReport;
    pnlStudentMarkReport markReport;
    pnlStudentNewRegistrationReport newRegistratorReport;
    pnlStudentReport studentReport;
    pnlSubjectInCourseReport subInCourseRerport;
    String courseId = "ARENA";
    String studentId;
    String subjectId;
    JPanel pnlOld;
    frmMain parent;

    /** Creates new form dlgChooseReport */
    public dlgChooseReport(frmMain parent, JPanel pnlOld, int type) {
        initComponents();
        this.pnlOld = pnlOld;
        this.parent = parent;
        switch (type) {
            case 0:
                //cerReport = new pnlCertificateReport();
                //  this.pnlBrowser = cerReport;
                break;
            case 1:
                cerDevReport = new pnlCertificateDevelopedReport();
                this.pnlBrowser = cerDevReport;
                break;
            case 2:
                empReport = new pnlEmployeeReport();
                this.pnlBrowser = empReport;
                break;
            case 3:
                feeReport = new pnlStudentFeeReport(courseId);
                this.pnlBrowser = feeReport;
                break;
            case 4:
                markReport = new pnlStudentMarkReport(studentId);
                this.pnlBrowser = markReport;
                break;
            case 5:
                newRegistratorReport = new pnlStudentNewRegistrationReport(courseId);
                this.pnlBrowser = newRegistratorReport;
                break;
            case 6:
                studentReport = new pnlStudentReport(courseId);
                this.pnlBrowser.add(studentReport);
                System.out.println("hi");
                break;
            case 7:
                subInCourseRerport = new pnlSubjectInCourseReport(subjectId);
                this.pnlBrowser = subInCourseRerport;
                break;
        }
    }

    public JPanel getViewer() {
        return this.pnlBrowser;
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

        pnlButton = new javax.swing.JPanel();
        btnSelect = new javax.swing.JButton();
        pnlBrowser = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(860, 600));
        setPreferredSize(new java.awt.Dimension(860, 600));
        setLayout(new java.awt.GridBagLayout());

        pnlButton.setLayout(new javax.swing.BoxLayout(pnlButton, javax.swing.BoxLayout.LINE_AXIS));

        btnSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow_left_green.png"))); // NOI18N
        btnSelect.setText("Back");
        btnSelect.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnSelect.setMaximumSize(new java.awt.Dimension(80, 25));
        btnSelect.setMinimumSize(new java.awt.Dimension(80, 25));
        btnSelect.setPreferredSize(new java.awt.Dimension(80, 25));
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        pnlButton.add(btnSelect);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(pnlButton, gridBagConstraints);

        pnlBrowser.setMinimumSize(new java.awt.Dimension(860, 550));
        pnlBrowser.setPreferredSize(new java.awt.Dimension(860, 550));
        pnlBrowser.setLayout(new java.awt.BorderLayout());

        pnlBrowser = pnlBrowser;

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(pnlBrowser, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        // TODO add your handling code here:
        parent.tpnBusiness.setSelectedComponent(this.pnlOld);
    }//GEN-LAST:event_btnSelectActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    protected javax.swing.JPanel pnlBrowser;
    protected javax.swing.JPanel pnlButton;
    // End of variables declaration//GEN-END:variables
}
