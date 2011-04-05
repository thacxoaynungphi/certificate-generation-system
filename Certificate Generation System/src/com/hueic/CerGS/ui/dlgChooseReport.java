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

import com.hueic.CerGS.entity.Certificate;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Employee;
import com.hueic.CerGS.entity.Mark;
import com.hueic.CerGS.entity.Payment;
import com.hueic.CerGS.entity.Register;
import com.hueic.CerGS.entity.Student;
import com.hueic.CerGS.entity.Subject;
import com.hueic.CerGS.ui.report.pnlCertificateDevelopedReport;
import com.hueic.CerGS.ui.report.pnlCertificateReport;
import com.hueic.CerGS.ui.report.pnlCourseReport;
import com.hueic.CerGS.ui.report.pnlEmployeeDetailReport;
import com.hueic.CerGS.ui.report.pnlEmployeeReport;
import com.hueic.CerGS.ui.report.pnlFeeReport;
import com.hueic.CerGS.ui.report.pnlRegisterReport;
import com.hueic.CerGS.ui.report.pnlStudentDetailReport;
import com.hueic.CerGS.ui.report.pnlStudentFeeReport;
import com.hueic.CerGS.ui.report.pnlStudentMarkAllReport;
import com.hueic.CerGS.ui.report.pnlStudentMarkReport;
import com.hueic.CerGS.ui.report.pnlStudentReport;
import com.hueic.CerGS.ui.report.pnlSubjectReport;
import java.util.ArrayList;
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
    pnlStudentReport studentReport;
    String courseId = "ARENA";
    String studentId;
    String subjectId;
    JPanel pnlOld;
    frmMain parent;
    public boolean  status = true;

    /** Creates new form dlgChooseReport */
    public dlgChooseReport(frmMain parent, JPanel pnlOld) {
        initComponents();
        setVisible(true);
        setSize(860, 600);
        this.pnlOld = pnlOld;
        this.parent = parent;
    }

    public void getCertificateReport(String studentId) {
        cerReport = new pnlCertificateReport(studentId);
        if (cerReport.status == false) {
            parent.tpnBusiness.setSelectedComponent(this.pnlOld);
            status = false;
            return;
        }
        this.pnlBrowser.add(cerReport);
    }

    public void getCertificateDevelopedReport(ArrayList<Certificate> list) {
        cerDevReport = new pnlCertificateDevelopedReport(list);
        this.pnlBrowser.add(cerDevReport);
    }

    public void getEmployeeReport(ArrayList<Employee> list) {
        empReport = new pnlEmployeeReport(list);
        this.pnlBrowser.add(empReport);
    }

    public void getStudentReport(ArrayList<Student> list) {
        studentReport = new pnlStudentReport(list);
        this.pnlBrowser.add(studentReport);
    }

    public void getStudentFeeReport(String studentId) {
        feeReport = new pnlStudentFeeReport(studentId);
        this.pnlBrowser.add(feeReport);
    }

    public void getStudentMarkReport(String studentId) {
        markReport = new pnlStudentMarkReport(studentId);
        this.pnlBrowser.add(markReport);
    }

    public void getSubjectReport(ArrayList<Subject> list) {
        pnlSubjectReport subjectReport = new pnlSubjectReport(list);
        this.pnlBrowser.add(subjectReport);
    }

    public void getCourseReport(ArrayList<Course> list) {
        pnlCourseReport courseReport = new pnlCourseReport(list);
        this.pnlBrowser.add(courseReport);
    }

    public void getEmployeeDetailsReport(Employee emp) {
        pnlEmployeeDetailReport employeeDetailReport = new pnlEmployeeDetailReport(emp);
        this.pnlBrowser.add(employeeDetailReport);
    }

    public void getStudentDetailsReport(Student student) {
        pnlStudentDetailReport studentDetailReport = new pnlStudentDetailReport(student);
        this.pnlBrowser.add(studentDetailReport);
    }

    public void getFeesReport(ArrayList<Payment> list) {
        pnlFeeReport feeReport = new pnlFeeReport(list);
        this.pnlBrowser.add(feeReport);
    }

    public void getMarkAllReport(ArrayList<Mark> list) {
        pnlStudentMarkAllReport markAllReport = new pnlStudentMarkAllReport(list);
        this.pnlBrowser.add(markAllReport);
    }

    public void getRegisterReport(ArrayList<Register> list) {
        pnlRegisterReport registerReport = new pnlRegisterReport(list);
        this.pnlBrowser.add(registerReport);
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

        pnlBrowser.setBackground(new java.awt.Color(255, 255, 255));
        pnlBrowser.setMinimumSize(new java.awt.Dimension(860, 560));
        pnlBrowser.setPreferredSize(new java.awt.Dimension(860, 560));
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