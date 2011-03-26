/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginFrm.java
 *
 * Created on Mar 22, 2011, 10:38:33 PM
 */
package com.hueic.CerGS.ui.system;

import com.hueic.CerGS.component.IconSystem;
import com.hueic.CerGS.dao.AccountDAO;
import com.hueic.CerGS.dao.PermissionDAO;
import com.hueic.CerGS.dao.RememberAccount;
import com.hueic.CerGS.entity.Account;
import com.hueic.CerGS.entity.Permission;
import com.hueic.CerGS.ui.main.frmMain;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author qhvic
 */
public class frmLogin extends javax.swing.JFrame {

    /** Creates new form LoginFrm */
    PermissionDAO perDao = new PermissionDAO();
    frmMain  main;
    public frmLogin() {
        initComponents();
        new IconSystem(this);
        setLocationRelativeTo(null);
        bindingData();
    }

     public frmLogin(frmMain  main) {
        initComponents();
        new IconSystem(this);
        this.main = main;
        setLocationRelativeTo(null);
        bindingData();
    }

    public void bindingData() {
        cbxPermission.removeAllItems();
        ArrayList<Permission> list = perDao.readByAll();
        if (list != null) {
            for (Permission per : list) {
                cbxPermission.addItem(per.getName());
            }
        }
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

        panel1 = new javax.swing.JPanel();
        lblBannerLogin = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        chbRepass = new javax.swing.JCheckBox();
        txtUsername = new javax.swing.JTextField();
        cbxPermission = new javax.swing.JComboBox();
        sepa1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setMinimumSize(new java.awt.Dimension(380, 100));
        panel1.setPreferredSize(new java.awt.Dimension(380, 100));
        panel1.setRequestFocusEnabled(false);
        panel1.setLayout(new java.awt.GridBagLayout());

        lblBannerLogin.setBackground(new java.awt.Color(255, 255, 255));
        lblBannerLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/banner login.png"))); // NOI18N
        lblBannerLogin.setMaximumSize(new java.awt.Dimension(380, 100));
        lblBannerLogin.setMinimumSize(new java.awt.Dimension(380, 100));
        lblBannerLogin.setPreferredSize(new java.awt.Dimension(380, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panel1.add(lblBannerLogin, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panel1, gridBagConstraints);

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login System", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panel2.setMinimumSize(new java.awt.Dimension(380, 214));
        panel2.setPreferredSize(new java.awt.Dimension(380, 214));
        panel2.setLayout(new java.awt.GridBagLayout());

        lblUsername.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 5);
        panel2.add(lblUsername, gridBagConstraints);

        lblPassword.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel2.add(lblPassword, gridBagConstraints);

        lblType.setText("Type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel2.add(lblType, gridBagConstraints);

        chbRepass.setBackground(new java.awt.Color(255, 255, 255));
        chbRepass.setText("Remember password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 40, 5, 5);
        panel2.add(chbRepass, gridBagConstraints);

        txtUsername.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 5, 5);
        panel2.add(txtUsername, gridBagConstraints);

        cbxPermission.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 40, 5, 5);
        panel2.add(cbxPermission, gridBagConstraints);

        sepa1.setPreferredSize(new java.awt.Dimension(300, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panel2.add(sepa1, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/button_ok - 16x16.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnLogin.setPreferredSize(new java.awt.Dimension(75, 23));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel3.add(btnLogin);

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReset.setPreferredSize(new java.awt.Dimension(75, 23));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel3.add(btnReset);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panel2.add(jPanel3, gridBagConstraints);

        txtPassword.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 40, 5, 5);
        panel2.add(txtPassword, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtUsername.setText(null);
        txtPassword.setText(null);
        cbxPermission.setSelectedIndex(0);


    }//GEN-LAST:event_btnResetActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        try {
            String username = txtUsername.getText();
            String password = String.valueOf(txtPassword.getPassword());
            Account acc = new Account(username, password, perDao.readByName(cbxPermission.getSelectedItem().toString()).getId());
            AccountDAO accDao = new AccountDAO();
            if (accDao.login(acc)) {
                main.accCur = acc;
                JOptionPane.showMessageDialog(this, accDao.getLastError(), "Login", JOptionPane.INFORMATION_MESSAGE);
                if (chbRepass.isSelected()) {
                    RememberAccount rememberAccount = new RememberAccount();
                    rememberAccount.writeFile(acc);
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, accDao.getLastError(), "Login", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmLogin().setVisible(true);


            }
        });


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox cbxPermission;
    private javax.swing.JCheckBox chbRepass;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBannerLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JSeparator sepa1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
