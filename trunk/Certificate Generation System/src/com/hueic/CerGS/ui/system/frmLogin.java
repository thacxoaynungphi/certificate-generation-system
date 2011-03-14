package com.hueic.CerGS.ui.system;

import com.hueic.CerGS.component.LanguageProperties;
import com.hueic.CerGS.dao.AccountDAO;
import com.hueic.CerGS.dao.PermissionDAO;
import com.hueic.CerGS.dao.RememberAccount;
import com.hueic.CerGS.entity.Account;
import com.hueic.CerGS.entity.Permission;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginFrm.java
 *
 * Created on Mar 13, 2011, 10:50:08 AM
 */
/**
 *
 * @author qhvic
 */
public class frmLogin extends javax.swing.JDialog {

    /** Creates new form LoginFrm */
    PermissionDAO perDao = new PermissionDAO();
    LanguageProperties langProperties = new LanguageProperties();

    public frmLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        bindingData();
        bindingLang();
        setLocationRelativeTo(null);
        RememberAccount rememberAcc = new RememberAccount();
        Account acc = rememberAcc.getUser();
        if (acc != null) {
            System.out.println(acc.getPassword());
            txtUsername.setText(acc.getUsername().trim());
            txtPassword.setText(acc.getPassword().trim());
        }
    }

    public void bindingLang() {
        btnLogin.setText(langProperties.getValueLanguage("LOGIN"));
        btnExit.setText(langProperties.getValueLanguage("EXIT"));
        btnReset.setText(langProperties.getValueLanguage("RESET"));
        lblUsername.setText(langProperties.getValueLanguage("USERNAME"));
        lblPassword.setText(langProperties.getValueLanguage("PASSWORD"));
        lblPermission.setText(langProperties.getValueLanguage("PERMISSION"));
        chbRepass.setText(langProperties.getValueLanguage("REMEMBER_PASSWORD"));
         panelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(null, langProperties.getValueLanguage("LOGIN_SYSTEM"), javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        
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

        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        panelInput = new javax.swing.JPanel();
        lblPermission = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jSeparator = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        lblPassword = new javax.swing.JLabel();
        cbxPermission = new javax.swing.JComboBox();
        txtUsername = new javax.swing.JTextField();
        chbRepass = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login System");
        setMinimumSize(new java.awt.Dimension(400, 300));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        panelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login System", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        panelInput.setLayout(new java.awt.GridBagLayout());

        lblPermission.setText("Permission:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 0);
        panelInput.add(lblPermission, gridBagConstraints);

        lblUsername.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 0);
        panelInput.add(lblUsername, gridBagConstraints);

        jSeparator.setPreferredSize(new java.awt.Dimension(400, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 401;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelInput.add(jSeparator, gridBagConstraints);

        txtPassword.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 40, 5, 0);
        panelInput.add(txtPassword, gridBagConstraints);

        lblPassword.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 0);
        panelInput.add(lblPassword, gridBagConstraints);

        cbxPermission.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 40, 5, 4);
        panelInput.add(cbxPermission, gridBagConstraints);

        txtUsername.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 40, 5, 0);
        panelInput.add(txtUsername, gridBagConstraints);

        chbRepass.setText("Remember password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 40, 5, 0);
        panelInput.add(chbRepass, gridBagConstraints);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel3.add(btnLogin);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel3.add(btnReset);

        btnExit.setText("Exit");
        btnExit.setPreferredSize(new java.awt.Dimension(85, 23));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel3.add(btnExit);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 10, 0);
        panelInput.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel1.add(panelInput, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/welcome.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String username = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());
        Account acc = new Account(username, password, perDao.readByName(cbxPermission.getSelectedItem().toString()).getId());
        AccountDAO accDao = new AccountDAO();
        if (accDao.login(acc)) {
            JOptionPane.showMessageDialog(this, accDao.getLastError(), "Login", JOptionPane.INFORMATION_MESSAGE);
            if (chbRepass.isSelected()) {
                RememberAccount rememberAccount = new RememberAccount();
                rememberAccount.writeFile(acc);
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, accDao.getLastError(), "Login", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtUsername.setText(null);
        txtPassword.setText(null);
        cbxPermission.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmLogin dialog = new frmLogin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox cbxPermission;
    private javax.swing.JCheckBox chbRepass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPermission;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel panelInput;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}