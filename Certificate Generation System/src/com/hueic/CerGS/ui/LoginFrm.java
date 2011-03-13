package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.GUIProperties;
import com.hueic.CerGS.component.LanguageProperties;
import com.hueic.CerGS.dao.AccountDAO;
import com.hueic.CerGS.dao.GUIDAO;
import com.hueic.CerGS.dao.PermissionDAO;
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
public class LoginFrm extends javax.swing.JFrame {

    /** Creates new form LoginFrm */
    PermissionDAO perDao = new PermissionDAO();
    LanguageProperties langProperties = new LanguageProperties();
    
    public LoginFrm() {
        initComponents();
        bindingData();
        bindingLang();
        GUIDAO guidao = new GUIDAO();
        GUIProperties guip = new GUIProperties();
        guidao.setGUI(guip.PLAF_SMART);
    }

    public void bindingLang()
    {
        btnLogin.setText(langProperties.getValueLanguage("LOGIN"));
        btnCancel.setText(langProperties.getValueLanguage("CANCEL"));
        lblUsername.setText(langProperties.getValueLanguage("USERNAME"));
        lblPassword.setText(langProperties.getValueLanguage("PASSWORD"));
        lblPermission.setText(langProperties.getValueLanguage("PERMISSION"));
        chbRepass.setText(langProperties.getValueLanguage("REMEMBER_PASSWORD"));
    }

    public void bindingData() {
        cbxPermission.removeAllItems();

        ArrayList<Permission> list = perDao.ReadByAll();
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
        txtPassword = new javax.swing.JPasswordField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblPermission = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        cbxPermission = new javax.swing.JComboBox();
        chbRepass = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        txtPassword.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 20);
        getContentPane().add(txtPassword, gridBagConstraints);

        lblUsername.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 5);
        getContentPane().add(lblUsername, gridBagConstraints);

        lblPassword.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 5);
        getContentPane().add(lblPassword, gridBagConstraints);

        lblPermission.setText("Permission:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 5);
        getContentPane().add(lblPermission, gridBagConstraints);

        txtUsername.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 20);
        getContentPane().add(txtUsername, gridBagConstraints);

        cbxPermission.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 20);
        getContentPane().add(cbxPermission, gridBagConstraints);

        chbRepass.setText("Remember password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 76;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 5, 20);
        getContentPane().add(chbRepass, gridBagConstraints);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnLogin.setText("Login");
        btnLogin.setPreferredSize(new java.awt.Dimension(85, 23));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin);

        btnCancel.setText("Cancel");
        btnCancel.setPreferredSize(new java.awt.Dimension(85, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 10);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 100));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        getContentPane().add(jPanel2, gridBagConstraints);

        jSeparator1.setPreferredSize(new java.awt.Dimension(400, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(jSeparator1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        AboutFrm about = new AboutFrm();
        about.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String username = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());
        Account acc = new Account(username, password, perDao.ReadByName(cbxPermission.getSelectedItem().toString()).getId());
        AccountDAO accDao = new AccountDAO();
        if (accDao.Login(acc)) {
            JOptionPane.showMessageDialog(this, accDao.getLastError(), "Login", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, accDao.getLastError(), "Login", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LoginFrm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox cbxPermission;
    private javax.swing.JCheckBox chbRepass;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPermission;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
