/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * dlgLogin.java
 *
 * Created on Mar 31, 2011, 5:31:46 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.RememberAccount;
import com.hueic.CerGS.dao.AccountDAO;
import com.hueic.CerGS.dao.PermissionDAO;
import com.hueic.CerGS.entity.Account;
import com.hueic.CerGS.entity.Permission;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author nhchung
 */
public class dlgLogin extends javax.swing.JDialog {

    PermissionDAO perDao = new PermissionDAO();
    frmMain main;

    /** Creates new form dlgLogin */
    public dlgLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.main = (frmMain) parent;
        initComponents();
        setLocationRelativeTo(null);
        bindingData();
        getRemebePassword();
    }

    public dlgLogin(frmMain main) {
        initComponents();
        this.main = main;
        setLocationRelativeTo(null);
        bindingData();
        getRemebePassword();
    }

    public void getRemebePassword() {
        try {
            RememberAccount ra = new RememberAccount();
            Account acc = ra.getUser();
            if (acc != null) {
                txtUsername.setText(acc.getUsername());
                txtPassword.setText(acc.getPassword());
                for (int i = 0; i < cbxPermission.getItemCount(); i++) {
                    if (perDao.readByID(acc.getPermission()).getName().trim().equals(cbxPermission.getItemAt(i).toString().trim())) {
                        cbxPermission.setSelectedIndex(i);
                    }
                }
            }
        } catch (Exception ex) {
        }
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

        panelLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        panelContent = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        chbRepass = new javax.swing.JCheckBox();
        txtUsername = new javax.swing.JTextField();
        cbxPermission = new javax.swing.JComboBox();
        sepa1 = new javax.swing.JSeparator();
        panelButton = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelLogo.setBackground(new java.awt.Color(255, 255, 255));
        panelLogo.setMinimumSize(new java.awt.Dimension(380, 100));
        panelLogo.setRequestFocusEnabled(false);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/LoginFinal.png"))); // NOI18N

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelLogo, gridBagConstraints);

        panelContent.setBackground(new java.awt.Color(255, 255, 255));
        panelContent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login System", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(3, 3, 3))); // NOI18N
        panelContent.setMinimumSize(new java.awt.Dimension(380, 214));
        panelContent.setPreferredSize(new java.awt.Dimension(380, 214));
        panelContent.setLayout(new java.awt.GridBagLayout());

        lblUsername.setForeground(new java.awt.Color(3, 3, 3));
        lblUsername.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 5);
        panelContent.add(lblUsername, gridBagConstraints);

        lblPassword.setForeground(new java.awt.Color(3, 3, 3));
        lblPassword.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblPassword, gridBagConstraints);

        lblType.setForeground(new java.awt.Color(3, 3, 3));
        lblType.setText("Type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblType, gridBagConstraints);

        chbRepass.setBackground(new java.awt.Color(255, 255, 255));
        chbRepass.setForeground(new java.awt.Color(3, 3, 3));
        chbRepass.setText("Remember password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 40, 5, 5);
        panelContent.add(chbRepass, gridBagConstraints);

        txtUsername.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 5, 5);
        panelContent.add(txtUsername, gridBagConstraints);

        cbxPermission.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 40, 5, 5);
        panelContent.add(cbxPermission, gridBagConstraints);

        sepa1.setPreferredSize(new java.awt.Dimension(300, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panelContent.add(sepa1, gridBagConstraints);

        panelButton.setBackground(new java.awt.Color(255, 255, 255));

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/button_ok - 16x16.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnLogin.setPreferredSize(new java.awt.Dimension(75, 23));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });
        panelButton.add(btnLogin);

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReset.setPreferredSize(new java.awt.Dimension(75, 23));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        btnReset.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnResetKeyPressed(evt);
            }
        });
        panelButton.add(btnReset);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        btnCancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelKeyPressed(evt);
            }
        });
        panelButton.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelContent.add(panelButton, gridBagConstraints);

        txtPassword.setPreferredSize(new java.awt.Dimension(200, 20));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 40, 5, 5);
        panelContent.add(txtPassword, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelContent, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        login();
}//GEN-LAST:event_btnLoginActionPerformed

    public void login() {
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
                main.isLogin();
                main.pnlViewPaymentTab.removeAll();

                JPanel panelviewPayment = new pnlViewPayment(main);
                panelviewPayment.setVisible(true);
                panelviewPayment.setSize(860, 600);
                main.viewPayment = (pnlViewPayment) panelviewPayment;
                main.pnlViewPaymentTab.add(panelviewPayment);
                main.pnlViewMarkTab.removeAll();

                JPanel panelviewMark = new pnlViewMark(main);
                panelviewMark.setVisible(true);
                panelviewMark.setSize(860, 600);
                main.viewMark = (pnlViewMark) panelviewMark;
                main.pnlViewMarkTab.add(panelviewMark);
                main.initStatusBar();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, accDao.getLastError(), "Login", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            System.out.println("ex : " + ex.toString());
        }
    }
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtUsername.setText(null);
        txtPassword.setText(null);
        cbxPermission.setSelectedIndex(0);

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_btnLoginKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_formKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void btnResetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnResetKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtUsername.setText(null);
            txtPassword.setText(null);
            cbxPermission.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnResetKeyPressed

    private void btnCancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelKeyPressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelKeyPressed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox cbxPermission;
    private javax.swing.JCheckBox chbRepass;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JSeparator sepa1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
