
/*
 * ConfigurationDB.java
 *
 * Created on Apr 2, 2011, 10:19:37 PM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ConfigureDB;
import com.hueic.CerGS.entity.Configure;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author nhchung
 */
public class dlgConfigurationDB extends javax.swing.JDialog {

    /** Creates new form ConfigurationDB */
    ConfigureDB configureDB;

    public dlgConfigurationDB(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        configureDB = new ConfigureDB();
        Configure config = new Configure();
        config = configureDB.getInfo();
        if (config != null) {
            loadData(config);
        }
    }

    public void loadData(Configure config) {
        txtDatabase.setText(config.getDatabase());
        txtServername.setText(config.getSever());
        txtPort.setText(config.getPort());
        txtUsername.setText(config.getUsername());
        txtPassword.setText(config.getPassword());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlContent = new javax.swing.JPanel();
        lblDatabase = new javax.swing.JLabel();
        lblServername = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtDatabase = new javax.swing.JTextField();
        txtServername = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        sepaServer = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuration DB");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Server Config", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        pnlContent.setPreferredSize(new java.awt.Dimension(350, 230));
        pnlContent.setLayout(new java.awt.GridBagLayout());

        lblDatabase.setText("Database:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(lblDatabase, gridBagConstraints);

        lblServername.setText("Server name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(lblServername, gridBagConstraints);

        lblPort.setText("Port:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(lblPort, gridBagConstraints);

        lblUsername.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(lblUsername, gridBagConstraints);

        lblPassword.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(lblPassword, gridBagConstraints);

        txtDatabase.setPreferredSize(new java.awt.Dimension(223, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(txtDatabase, gridBagConstraints);

        txtServername.setPreferredSize(new java.awt.Dimension(120, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(txtServername, gridBagConstraints);

        txtPort.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(txtPort, gridBagConstraints);

        txtUsername.setPreferredSize(new java.awt.Dimension(223, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(txtUsername, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/button_ok - 16x16.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnSave.setMaximumSize(new java.awt.Dimension(75, 25));
        btnSave.setMinimumSize(new java.awt.Dimension(75, 25));
        btnSave.setPreferredSize(new java.awt.Dimension(75, 25));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);

        btnTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnTest.setText("Test");
        btnTest.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnTest.setMaximumSize(new java.awt.Dimension(75, 25));
        btnTest.setMinimumSize(new java.awt.Dimension(75, 25));
        btnTest.setPreferredSize(new java.awt.Dimension(75, 25));
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });
        jPanel2.add(btnTest);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(jPanel2, gridBagConstraints);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle.setForeground(new java.awt.Color(153, 0, 153));
        lblTitle.setText("Information Server");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlContent.add(lblTitle, gridBagConstraints);

        sepaServer.setPreferredSize(new java.awt.Dimension(320, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlContent.add(sepaServer, gridBagConstraints);

        txtPassword.setPreferredSize(new java.awt.Dimension(223, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(txtPassword, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(pnlContent, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Connection con = Test();
        if (con == null) {
            JOptionPane.showMessageDialog(this, "Change Config Database unsuccsufully", "ConfigurationDB", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            Configure config = new Configure();
            config.setDatabase(txtDatabase.getText());
            config.setSever(txtServername.getText());
            config.setPort(txtPort.getText());
            config.setUsername(txtUsername.getText());
            config.setPassword(String.valueOf(txtPassword.getPassword()));
            if (configureDB.writeFile(config)) {
                JOptionPane.showMessageDialog(this, "Configuration DB succsufully", "ConfigurationDB", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Configuration DB unsuccsufully", "ConfigurationDB", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    public Connection Test() {
        Connection con = null;
        String url = "jdbc:sqlserver://" + txtServername.getText() + ":" + txtPort.getText() + ";databaseName=" + txtDatabase.getText() + "";
        String user = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = java.sql.DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
        return null;
    }
    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed

        Connection con = Test();
        if (con == null) {
            JOptionPane.showMessageDialog(this, "Test unsuccsufully", "ConfigurationDB", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Test succsufully", "ConfigurationDB", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnTestActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTest;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDatabase;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblServername;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JSeparator sepaServer;
    private javax.swing.JTextField txtDatabase;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtServername;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
