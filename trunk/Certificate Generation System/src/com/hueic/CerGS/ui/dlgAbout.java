
/*
 * dlgAbount.java
 *
 * Created on Mar 31, 2011, 5:36:51 AM
 */
package com.hueic.CerGS.ui;

/**
 *
 * @author nhchung
 */
public class dlgAbout extends javax.swing.JDialog {

    /** Creates new form dlgAbount */
    public dlgAbout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelBanner = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        panelContent = new javax.swing.JPanel();
        lblInfoSoft = new javax.swing.JLabel();
        lblInfoGroup = new javax.swing.JLabel();
        seqarator1 = new javax.swing.JSeparator();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelBanner.setBackground(new java.awt.Color(255, 255, 255));
        panelBanner.setMinimumSize(new java.awt.Dimension(440, 122));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/AboutTam.png"))); // NOI18N

        javax.swing.GroupLayout panelBannerLayout = new javax.swing.GroupLayout(panelBanner);
        panelBanner.setLayout(panelBannerLayout);
        panelBannerLayout.setHorizontalGroup(
            panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        panelBannerLayout.setVerticalGroup(
            panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelBanner, gridBagConstraints);

        panelContent.setBackground(new java.awt.Color(255, 255, 255));
        panelContent.setMinimumSize(new java.awt.Dimension(440, 120));
        panelContent.setPreferredSize(new java.awt.Dimension(440, 120));
        panelContent.setLayout(new java.awt.GridBagLayout());

        lblInfoSoft.setForeground(new java.awt.Color(3, 3, 3));
        lblInfoSoft.setText("<html> <body> Certificate Generation System<br/>Version 1.0<br/>© 2011 ConnectPlus.<br/>All rights reserved.<br/> </body> </html>");
        lblInfoSoft.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblInfoSoft.setPreferredSize(new java.awt.Dimension(150, 57));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 5);
        panelContent.add(lblInfoSoft, gridBagConstraints);

        lblInfoGroup.setForeground(new java.awt.Color(3, 3, 3));
        lblInfoGroup.setText("<html> <body> Develop by: Connec tPlus <br/> Contact: cergs.hueic@gmail.com </body> </html>");
        lblInfoGroup.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 55, 5, 5);
        panelContent.add(lblInfoGroup, gridBagConstraints);

        seqarator1.setPreferredSize(new java.awt.Dimension(440, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelContent.add(seqarator1, gridBagConstraints);

        btnClose.setText("Close");
        btnClose.setPreferredSize(new java.awt.Dimension(75, 23));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelContent.add(btnClose, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelContent, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_btnCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel lblInfoGroup;
    private javax.swing.JLabel lblInfoSoft;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelBanner;
    private javax.swing.JPanel panelContent;
    private javax.swing.JSeparator seqarator1;
    // End of variables declaration//GEN-END:variables
}
