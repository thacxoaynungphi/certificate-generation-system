
/*
 * pnlHomeStudent.java
 *
 * Created on Apr 2, 2011, 9:17:04 PM
 */
package com.hueic.CerGS.ui;

/**
 *
 * @author nhchung
 */
public class pnlHomeStudent extends javax.swing.JPanel {

    /** Creates new form pnlHomeStudent */
    frmMain main;

    public pnlHomeStudent() {
        initComponents();
    }

    pnlHomeStudent(frmMain main) {
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
        jPanel6 = new javax.swing.JPanel();
        lblCampaignMaster2 = new javax.swing.JLabel();
        detail_Campaign_Description2 = new javax.swing.JLabel();
        lblViewMark = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblCampaignMaster3 = new javax.swing.JLabel();
        detail_Campaign_Description3 = new javax.swing.JLabel();
        lblViewPayment = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setMaximumSize(new java.awt.Dimension(860, 600));
        panelRight.setMinimumSize(new java.awt.Dimension(860, 600));
        panelRight.setPreferredSize(new java.awt.Dimension(860, 600));
        panelRight.setLayout(new java.awt.GridBagLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setText("<html> <body> Certificate Generator System </body> </html>");
        jLabel15.setMinimumSize(new java.awt.Dimension(400, 40));
        jLabel15.setPreferredSize(new java.awt.Dimension(400, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        panelRight.add(jLabel15, gridBagConstraints);

        jLabel16.setForeground(new java.awt.Color(3, 3, 3));
        jLabel16.setText("<html> <body> This is a Certificate Department which works for “ABC” institute for developing  the certificate for the<br/> students who had completed their course. This system also deals with the student  registration,<br/> checking the payment scenario, inputting the marks of the students and after all verification is<br/>  done they develop the certificate of completion of the course for the students. </body> </html> ");
        jLabel16.setMinimumSize(new java.awt.Dimension(700, 80));
        jLabel16.setPreferredSize(new java.awt.Dimension(700, 80));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelRight.add(jLabel16, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/logoFinal.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(150, 30, 0, 10);
        panelRight.add(jLabel1, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMinimumSize(new java.awt.Dimension(280, 134));
        jPanel6.setPreferredSize(new java.awt.Dimension(280, 134));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        lblCampaignMaster2.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblCampaignMaster2.setForeground(new java.awt.Color(153, 0, 0));
        lblCampaignMaster2.setText("View Mark");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel6.add(lblCampaignMaster2, gridBagConstraints);

        detail_Campaign_Description2.setFont(new java.awt.Font("Arial", 0, 11));
        detail_Campaign_Description2.setText("<html>See details mark courses that students have the test."); // NOI18N
        detail_Campaign_Description2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        detail_Campaign_Description2.setMinimumSize(new java.awt.Dimension(153, 42));
        detail_Campaign_Description2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel6.add(detail_Campaign_Description2, gridBagConstraints);

        lblViewMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/ViewMark.jpg"))); // NOI18N
        lblViewMark.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblViewMark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewMarkMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel6.add(lblViewMark, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(100, 60, 0, 25);
        panelRight.add(jPanel6, gridBagConstraints);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setMinimumSize(new java.awt.Dimension(280, 134));
        jPanel7.setPreferredSize(new java.awt.Dimension(280, 134));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        lblCampaignMaster3.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblCampaignMaster3.setForeground(new java.awt.Color(153, 0, 0));
        lblCampaignMaster3.setText("View Payment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel7.add(lblCampaignMaster3, gridBagConstraints);

        detail_Campaign_Description3.setFont(new java.awt.Font("Arial", 0, 11));
        detail_Campaign_Description3.setText("<html>Review the status of student deposit."); // NOI18N
        detail_Campaign_Description3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        detail_Campaign_Description3.setMinimumSize(new java.awt.Dimension(153, 42));
        detail_Campaign_Description3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel7.add(detail_Campaign_Description3, gridBagConstraints);

        lblViewPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/ViewPayment.png"))); // NOI18N
        lblViewPayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblViewPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewPaymentMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel7.add(lblViewPayment, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(100, 100, 0, 0);
        panelRight.add(jPanel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelRight, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void lblViewMarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewMarkMouseClicked

        if (main.accCur != null) {
            main.tpnBusiness.setSelectedComponent(main.pnlViewMarkTab);
        }
    }//GEN-LAST:event_lblViewMarkMouseClicked

    private void lblViewPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewPaymentMouseClicked

        if (main.accCur != null) {
            main.tpnBusiness.setSelectedComponent(main.pnlViewPaymentTab);
        }
    }//GEN-LAST:event_lblViewPaymentMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel detail_Campaign_Description2;
    private javax.swing.JLabel detail_Campaign_Description3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblCampaignMaster2;
    private javax.swing.JLabel lblCampaignMaster3;
    private javax.swing.JLabel lblViewMark;
    private javax.swing.JLabel lblViewPayment;
    private javax.swing.JPanel panelRight;
    // End of variables declaration//GEN-END:variables
}
