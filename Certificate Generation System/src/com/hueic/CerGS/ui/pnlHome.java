
/*
 * pnlHome.java
 *
 * Created on Apr 2, 2011, 9:17:56 PM
 */
package com.hueic.CerGS.ui;

/**
 *
 * @author nhchung
 */
public class pnlHome extends javax.swing.JPanel {

    /** Creates new form pnlHome */
    frmMain main;

    public pnlHome() {
        initComponents();
    }

    pnlHome(frmMain main) {
        initComponents();
        this.main = main;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelRight = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblCampaignMaster1 = new javax.swing.JLabel();
        detail_Campaign_Description1 = new javax.swing.JLabel();
        lblManagerPayment = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblCampaignMaster2 = new javax.swing.JLabel();
        detail_Campaign_Description2 = new javax.swing.JLabel();
        lblManagerEmployee = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblCampaignMaster3 = new javax.swing.JLabel();
        detail_Campaign_Description3 = new javax.swing.JLabel();
        lblManagerStudent = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblCampaignMaster4 = new javax.swing.JLabel();
        detail_Campaign_Description4 = new javax.swing.JLabel();
        lblManagerRegister = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblCampaignMaster5 = new javax.swing.JLabel();
        detail_Campaign_Description5 = new javax.swing.JLabel();
        lblManagerMark = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lblCampaignMaster6 = new javax.swing.JLabel();
        detail_Campaign_Description6 = new javax.swing.JLabel();
        lblManagerCertificate = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setMaximumSize(new java.awt.Dimension(860, 600));
        panelRight.setMinimumSize(new java.awt.Dimension(860, 600));
        panelRight.setPreferredSize(new java.awt.Dimension(860, 600));
        panelRight.setLayout(new java.awt.GridBagLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setText("<html>\n<body>\nCertificate Generator System\n</body>\n</html>");
        jLabel15.setMinimumSize(new java.awt.Dimension(400, 40));
        jLabel15.setPreferredSize(new java.awt.Dimension(400, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panelRight.add(jLabel15, gridBagConstraints);

        jLabel16.setForeground(new java.awt.Color(3, 3, 3));
        jLabel16.setText("<html>\n<body>\nThis is a Certificate Department which works for “ABC” institute for developing  the certificate for the<br/> students who had completed their course. This system also deals with the student  registration,<br/> checking the payment scenario, inputting the marks of the students and after all verification is<br/>  done they develop the certificate of completion of the course for the students.\n</body>\n</html>\n");
        jLabel16.setMinimumSize(new java.awt.Dimension(700, 80));
        jLabel16.setPreferredSize(new java.awt.Dimension(700, 80));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 0);
        panelRight.add(jLabel16, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/logoFinal.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(100, 220, 0, 10);
        panelRight.add(jLabel1, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMinimumSize(new java.awt.Dimension(280, 134));
        jPanel5.setPreferredSize(new java.awt.Dimension(280, 134));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        lblCampaignMaster1.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblCampaignMaster1.setForeground(new java.awt.Color(153, 0, 0));
        lblCampaignMaster1.setText("Manager Payment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel5.add(lblCampaignMaster1, gridBagConstraints);

        detail_Campaign_Description1.setFont(new java.awt.Font("Arial", 0, 11));
        detail_Campaign_Description1.setText("<html>Manage the payment of students<br> in each course."); // NOI18N
        detail_Campaign_Description1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        detail_Campaign_Description1.setMinimumSize(new java.awt.Dimension(153, 42));
        detail_Campaign_Description1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel5.add(detail_Campaign_Description1, gridBagConstraints);

        lblManagerPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Dollar.png"))); // NOI18N
        lblManagerPayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblManagerPayment.setMaximumSize(new java.awt.Dimension(101, 101));
        lblManagerPayment.setMinimumSize(new java.awt.Dimension(101, 101));
        lblManagerPayment.setPreferredSize(new java.awt.Dimension(101, 101));
        lblManagerPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManagerPaymentMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel5.add(lblManagerPayment, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelRight.add(jPanel5, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMinimumSize(new java.awt.Dimension(280, 134));
        jPanel6.setPreferredSize(new java.awt.Dimension(280, 134));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        lblCampaignMaster2.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblCampaignMaster2.setForeground(new java.awt.Color(153, 0, 0));
        lblCampaignMaster2.setText("Manager Employee");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel6.add(lblCampaignMaster2, gridBagConstraints);

        detail_Campaign_Description2.setFont(new java.awt.Font("Arial", 0, 11));
        detail_Campaign_Description2.setText("<html>Manage storage, updates and delete the information of its employee."); // NOI18N
        detail_Campaign_Description2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        detail_Campaign_Description2.setMinimumSize(new java.awt.Dimension(153, 42));
        detail_Campaign_Description2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel6.add(detail_Campaign_Description2, gridBagConstraints);

        lblManagerEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/emp_icon.png"))); // NOI18N
        lblManagerEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblManagerEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManagerEmployeeMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel6.add(lblManagerEmployee, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelRight.add(jPanel6, gridBagConstraints);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setMinimumSize(new java.awt.Dimension(280, 134));
        jPanel7.setPreferredSize(new java.awt.Dimension(280, 134));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        lblCampaignMaster3.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblCampaignMaster3.setForeground(new java.awt.Color(153, 0, 0));
        lblCampaignMaster3.setText("Manager Student");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel7.add(lblCampaignMaster3, gridBagConstraints);

        detail_Campaign_Description3.setFont(new java.awt.Font("Arial", 0, 11));
        detail_Campaign_Description3.setText("<html>Manage storage, updates and delete the information of its student."); // NOI18N
        detail_Campaign_Description3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        detail_Campaign_Description3.setMinimumSize(new java.awt.Dimension(153, 42));
        detail_Campaign_Description3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel7.add(detail_Campaign_Description3, gridBagConstraints);

        lblManagerStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/student_icon.png"))); // NOI18N
        lblManagerStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblManagerStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManagerStudentMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel7.add(lblManagerStudent, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelRight.add(jPanel7, gridBagConstraints);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setMinimumSize(new java.awt.Dimension(280, 134));
        jPanel8.setPreferredSize(new java.awt.Dimension(280, 134));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        lblCampaignMaster4.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblCampaignMaster4.setForeground(new java.awt.Color(153, 0, 0));
        lblCampaignMaster4.setText("Manager Register");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel8.add(lblCampaignMaster4, gridBagConstraints);

        detail_Campaign_Description4.setFont(new java.awt.Font("Arial", 0, 11));
        detail_Campaign_Description4.setText("<html>Manage students enrolling in courses."); // NOI18N
        detail_Campaign_Description4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        detail_Campaign_Description4.setMinimumSize(new java.awt.Dimension(153, 42));
        detail_Campaign_Description4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel8.add(detail_Campaign_Description4, gridBagConstraints);

        lblManagerRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/register_icon.jpg"))); // NOI18N
        lblManagerRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblManagerRegister.setMaximumSize(new java.awt.Dimension(101, 101));
        lblManagerRegister.setMinimumSize(new java.awt.Dimension(101, 101));
        lblManagerRegister.setPreferredSize(new java.awt.Dimension(101, 101));
        lblManagerRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManagerRegisterMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel8.add(lblManagerRegister, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelRight.add(jPanel8, gridBagConstraints);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setMinimumSize(new java.awt.Dimension(280, 134));
        jPanel9.setPreferredSize(new java.awt.Dimension(280, 134));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        lblCampaignMaster5.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblCampaignMaster5.setForeground(new java.awt.Color(153, 0, 0));
        lblCampaignMaster5.setText("Manager Mark");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel9.add(lblCampaignMaster5, gridBagConstraints);

        detail_Campaign_Description5.setFont(new java.awt.Font("Arial", 0, 11));
        detail_Campaign_Description5.setText("<html>Manage storage, updates and delete the student marks."); // NOI18N
        detail_Campaign_Description5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        detail_Campaign_Description5.setMinimumSize(new java.awt.Dimension(153, 42));
        detail_Campaign_Description5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel9.add(detail_Campaign_Description5, gridBagConstraints);

        lblManagerMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/mark_icon.jpg"))); // NOI18N
        lblManagerMark.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblManagerMark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManagerMarkMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel9.add(lblManagerMark, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelRight.add(jPanel9, gridBagConstraints);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setMinimumSize(new java.awt.Dimension(280, 134));
        jPanel10.setPreferredSize(new java.awt.Dimension(280, 134));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        lblCampaignMaster6.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblCampaignMaster6.setForeground(new java.awt.Color(153, 0, 0));
        lblCampaignMaster6.setText("Manager Certificate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel10.add(lblCampaignMaster6, gridBagConstraints);

        detail_Campaign_Description6.setFont(new java.awt.Font("Arial", 0, 11));
        detail_Campaign_Description6.setText("<html>Manage the grant degree to <br>students after completing the<br> course."); // NOI18N
        detail_Campaign_Description6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        detail_Campaign_Description6.setMinimumSize(new java.awt.Dimension(153, 42));
        detail_Campaign_Description6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel10.add(detail_Campaign_Description6, gridBagConstraints);

        lblManagerCertificate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Certificate_icon_blue.png"))); // NOI18N
        lblManagerCertificate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblManagerCertificate.setMaximumSize(new java.awt.Dimension(101, 101));
        lblManagerCertificate.setMinimumSize(new java.awt.Dimension(101, 101));
        lblManagerCertificate.setPreferredSize(new java.awt.Dimension(101, 101));
        lblManagerCertificate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManagerCertificateMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel10.add(lblManagerCertificate, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelRight.add(jPanel10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelRight, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void lblManagerEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManagerEmployeeMouseClicked
        // TODO add your handling code here:
        if (main.accCur != null) {
            main.tpnBusiness.setSelectedComponent(main.pnlEmployeeTab);
        }
    }//GEN-LAST:event_lblManagerEmployeeMouseClicked

    private void lblManagerStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManagerStudentMouseClicked

        if (main.accCur != null) {
            main.tpnBusiness.setSelectedComponent(main.pnlStudentTab);
        }
    }//GEN-LAST:event_lblManagerStudentMouseClicked

    private void lblManagerRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManagerRegisterMouseClicked
       
        if (main.accCur != null) {
            main.tpnBusiness.setSelectedComponent(main.pnlRegisterTab);
        }
    }//GEN-LAST:event_lblManagerRegisterMouseClicked

    private void lblManagerMarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManagerMarkMouseClicked

        if (main.accCur != null) {
            main.tpnBusiness.setSelectedComponent(main.pnlMarkTab);
        }
    }//GEN-LAST:event_lblManagerMarkMouseClicked

    private void lblManagerCertificateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManagerCertificateMouseClicked

        if (main.accCur != null) {
            main.tpnBusiness.setSelectedComponent(main.pnlCertificateTab);
        }
    }//GEN-LAST:event_lblManagerCertificateMouseClicked

    private void lblManagerPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManagerPaymentMouseClicked

        if (main.accCur != null) {
            main.tpnBusiness.setSelectedComponent(main.pnlPaymentTab);
        }
    }//GEN-LAST:event_lblManagerPaymentMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel detail_Campaign_Description1;
    private javax.swing.JLabel detail_Campaign_Description2;
    private javax.swing.JLabel detail_Campaign_Description3;
    private javax.swing.JLabel detail_Campaign_Description4;
    private javax.swing.JLabel detail_Campaign_Description5;
    private javax.swing.JLabel detail_Campaign_Description6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblCampaignMaster1;
    private javax.swing.JLabel lblCampaignMaster2;
    private javax.swing.JLabel lblCampaignMaster3;
    private javax.swing.JLabel lblCampaignMaster4;
    private javax.swing.JLabel lblCampaignMaster5;
    private javax.swing.JLabel lblCampaignMaster6;
    private javax.swing.JLabel lblManagerCertificate;
    private javax.swing.JLabel lblManagerEmployee;
    private javax.swing.JLabel lblManagerMark;
    private javax.swing.JLabel lblManagerPayment;
    private javax.swing.JLabel lblManagerRegister;
    private javax.swing.JLabel lblManagerStudent;
    private javax.swing.JPanel panelRight;
    // End of variables declaration//GEN-END:variables
}
