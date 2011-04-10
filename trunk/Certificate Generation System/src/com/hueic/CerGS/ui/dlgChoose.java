
package com.hueic.CerGS.ui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Load added panel
 * @author nhchung
 */
public class dlgChoose extends javax.swing.JDialog {

    private JPanel pnlBrowser;
    private JTextField txtID;
    private int type;
    pnlAccount acc;
    pnlCertificate certificate;
    pnlCourse course;
    pnlEmployee employee;
    pnlMark mark;
    pnlPayment pay;
    pnlPermission per;
    pnlRegister register;
    pnlStudent student;
    pnlSubject subject;
    frmMain main;

    /** Creates new form ManagementDlg */
    public dlgChoose(frmMain main, JTextField txtId, boolean modal, int type) {
        super(main, modal);
        this.main = main;
        this.txtID = txtId;
        this.type = type;
        acc = new pnlAccount();
        certificate = new pnlCertificate();
        course = new pnlCourse();
        employee = new pnlEmployee();
        mark = new pnlMark();
        pay = new pnlPayment();
        per = new pnlPermission();
        register = new pnlRegister();
        student = new pnlStudent();
        subject = new pnlSubject();
        switch (type) {
            case 0:
                this.pnlBrowser = acc;
                break;
            case 1:
                this.pnlBrowser = certificate;
                break;
            case 2:
                this.pnlBrowser = course;
                break;
            case 3:
                this.pnlBrowser = employee;
                break;
            case 4:
                this.pnlBrowser = mark;
                break;
            case 5:
                this.pnlBrowser = pay;
                break;
            case 6:
                certificate.tpCertificate.remove(certificate.pnlEdit);
                this.pnlBrowser = certificate;
                break;
            case 7:
                course.tpCourse.remove(course.pnlEdit);
                this.pnlBrowser = course;
                break;
            case 8:
                employee.tpEmployee.remove(employee.pnlEdit);
                this.pnlBrowser = employee;
                break;
            case 9:
                mark.tpMark.remove(mark.pnlEdit);
                this.pnlBrowser = mark;
                break;
            case 10:
                pay.tpPayment.remove(pay.pnlEdit);
                this.pnlBrowser = pay;
                break;
            case 11:
                per.tpPermission.remove(per.pnlEdit);
                this.pnlBrowser = per;
                break;
            case 12:
                register.tpRegister.remove(register.pnlEdit);
                this.pnlBrowser = register;
                break;
            case 13:
                student.tpStudent.remove(student.pnlEdit);
                this.pnlBrowser = student;
                break;
            case 14:
                subject.tpSubject.remove(subject.pnlEdit);
                this.pnlBrowser = subject;
                break;
        }
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Logochuan.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlManagement = new javax.swing.JPanel();
        pnlButton = new javax.swing.JPanel();
        btnSelect = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout pnlManagementLayout = new javax.swing.GroupLayout(pnlManagement);
        pnlManagement.setLayout(pnlManagementLayout);
        pnlManagementLayout.setHorizontalGroup(
            pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnlManagementLayout.setVerticalGroup(
            pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        pnlManagement = pnlBrowser;

        getContentPane().add(pnlManagement, java.awt.BorderLayout.CENTER);

        pnlButton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        btnSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/button_ok - 16x16.png"))); // NOI18N
        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        pnlButton.add(btnSelect);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnlButton.add(btnCancel);

        getContentPane().add(pnlButton, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed

        String priSelected = "";
        switch (type) {
            case 6:
                priSelected = certificate.getSelectedType();
                break;
            case 7:
                priSelected = course.getSelectedType();
                break;
            case 8:
                priSelected = employee.getSelectedType();
                break;
            case 9:
                priSelected = mark.getSelectedName();
                break;
            case 10:
                priSelected = pay.getSelectedType();
                break;
            case 11:
                priSelected = per.getSelectedCode();
                break;
            case 12:
                priSelected = register.getSelectedCode();
                break;
            case 13:
                priSelected = student.getSelectedCode();
                break;
            case 14:
                priSelected = subject.getSelectedCode();
                break;
        }
        if (!priSelected.equals("")) {
            txtID.setText(priSelected);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Please choose one");
        }
}//GEN-LAST:event_btnSelectActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
}//GEN-LAST:event_btnCancelActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSelect;
    protected javax.swing.JPanel pnlButton;
    protected javax.swing.JPanel pnlManagement;
    // End of variables declaration//GEN-END:variables
}
