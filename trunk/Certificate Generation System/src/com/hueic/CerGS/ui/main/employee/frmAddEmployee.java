/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddEmpFrm.java
 *
 * Created on Mar 16, 2011, 2:25:12 PM
 */
package com.hueic.CerGS.ui.main.employee;

import com.hueic.CerGS.component.IconSystem;
import com.hueic.CerGS.dao.EmployeeDAO;
import com.hueic.CerGS.entity.Employee;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author qhvic
 */
public class frmAddEmployee extends javax.swing.JFrame {

    /** Creates new form AddEmpFrm */
    public frmAddEmployee() {
        initComponents();
        new IconSystem(this);
        setLocationRelativeTo(null);
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

        buttonGroupGender = new javax.swing.ButtonGroup();
        panelContent = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        sepaAddStu = new javax.swing.JSeparator();
        lblFirstname = new javax.swing.JLabel();
        lblLastname = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblBirthday = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblImage1 = new javax.swing.JLabel();
        lblImage2 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        txtImage = new javax.swing.JTextField();
        panelButton = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblStart1 = new javax.swing.JLabel();
        lblStart2 = new javax.swing.JLabel();
        lblStart3 = new javax.swing.JLabel();
        lblStart4 = new javax.swing.JLabel();
        lblEmployeeID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblStart6 = new javax.swing.JLabel();
        DateChBirthday = new com.toedter.calendar.JDateChooser();
        lblBeginwork = new javax.swing.JLabel();
        DateChBeginWork = new com.toedter.calendar.JDateChooser();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Employee");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelContent.setBackground(new java.awt.Color(255, 255, 255));
        panelContent.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Add Employee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelContent.setPreferredSize(new java.awt.Dimension(340, 521));
        panelContent.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Employee");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelContent.add(lblTitle, gridBagConstraints);

        sepaAddStu.setPreferredSize(new java.awt.Dimension(320, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panelContent.add(sepaAddStu, gridBagConstraints);

        lblFirstname.setForeground(new java.awt.Color(3, 3, 3));
        lblFirstname.setText("Firstname:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblFirstname, gridBagConstraints);

        lblLastname.setForeground(new java.awt.Color(3, 3, 3));
        lblLastname.setText("Lastname:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblLastname, gridBagConstraints);

        lblGender.setForeground(new java.awt.Color(3, 3, 3));
        lblGender.setText("Gender:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblGender, gridBagConstraints);

        lblBirthday.setForeground(new java.awt.Color(3, 3, 3));
        lblBirthday.setText("Birthday:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblBirthday, gridBagConstraints);

        lblEmail.setForeground(new java.awt.Color(3, 3, 3));
        lblEmail.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblEmail, gridBagConstraints);

        lblAddress.setForeground(new java.awt.Color(3, 3, 3));
        lblAddress.setText("Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblAddress, gridBagConstraints);

        lblImage1.setForeground(new java.awt.Color(3, 3, 3));
        lblImage1.setText("Image:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblImage1, gridBagConstraints);

        lblImage2.setPreferredSize(new java.awt.Dimension(80, 80));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 5);
        panelContent.add(lblImage2, gridBagConstraints);

        txtFirstname.setPreferredSize(new java.awt.Dimension(200, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(txtFirstname, gridBagConstraints);

        txtLastname.setPreferredSize(new java.awt.Dimension(200, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(txtLastname, gridBagConstraints);

        radioMale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupGender.add(radioMale);
        radioMale.setSelected(true);
        radioMale.setText("Male");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelContent.add(radioMale, gridBagConstraints);

        radioFemale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupGender.add(radioFemale);
        radioFemale.setText("Female");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        panelContent.add(radioFemale, gridBagConstraints);

        txtEmail.setPreferredSize(new java.awt.Dimension(200, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(txtEmail, gridBagConstraints);

        txtAddress.setPreferredSize(new java.awt.Dimension(200, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(txtAddress, gridBagConstraints);

        btnBrowse.setText("Browse");
        btnBrowse.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnBrowse.setMaximumSize(new java.awt.Dimension(70, 23));
        btnBrowse.setMinimumSize(new java.awt.Dimension(70, 23));
        btnBrowse.setPreferredSize(new java.awt.Dimension(60, 23));
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        panelContent.add(btnBrowse, gridBagConstraints);

        txtImage.setPreferredSize(new java.awt.Dimension(120, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 5, 3);
        panelContent.add(txtImage, gridBagConstraints);

        panelButton.setBackground(new java.awt.Color(255, 255, 255));
        panelButton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnAdd.setPreferredSize(new java.awt.Dimension(75, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        panelButton.add(btnAdd);

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReset.setPreferredSize(new java.awt.Dimension(75, 23));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
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
        panelButton.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 5;
        panelContent.add(panelButton, gridBagConstraints);

        lblStart1.setForeground(new java.awt.Color(255, 0, 0));
        lblStart1.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblStart1, gridBagConstraints);

        lblStart2.setForeground(new java.awt.Color(255, 0, 0));
        lblStart2.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblStart2, gridBagConstraints);

        lblStart3.setForeground(new java.awt.Color(255, 0, 0));
        lblStart3.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblStart3, gridBagConstraints);

        lblStart4.setForeground(new java.awt.Color(255, 0, 0));
        lblStart4.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblStart4, gridBagConstraints);

        lblEmployeeID.setForeground(new java.awt.Color(3, 3, 3));
        lblEmployeeID.setText("Employee ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblEmployeeID, gridBagConstraints);

        txtID.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(txtID, gridBagConstraints);

        lblStart6.setForeground(new java.awt.Color(255, 0, 0));
        lblStart6.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblStart6, gridBagConstraints);

        DateChBirthday.setDateFormatString("MM\\dd\\yyyy");
        DateChBirthday.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(DateChBirthday, gridBagConstraints);

        lblBeginwork.setForeground(new java.awt.Color(3, 3, 3));
        lblBeginwork.setText("Begin work:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblBeginwork, gridBagConstraints);

        DateChBeginWork.setDateFormatString("MM\\dd\\yyyy");
        DateChBeginWork.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(DateChBeginWork, gridBagConstraints);

        lblPhone.setForeground(new java.awt.Color(3, 3, 3));
        lblPhone.setText("Phone: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblPhone, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(txtPhone, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelContent, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtID.setText(null);
        txtFirstname.setText(null);
        txtLastname.setText(null);
        txtPhone.setText(null);
        txtEmail.setText(null);
        txtAddress.setText(null);
        txtImage.setText(null);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        fileChooser.showOpenDialog(this);
        String path = null;
        try {
            path = fileChooser.getSelectedFile().getPath();
        } catch (Exception ex) {
            return;
        }
        txtImage.setText(path);
        ImageIcon icon = new ImageIcon(path);
        lblImage2.setIcon(icon);
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            // TODO add your handling code here:
            Employee emp = new Employee();
            emp.setId(txtID.getText());
            emp.setFirstName(txtFirstname.getText());
            emp.setLastName(txtLastname.getText());
            emp.setBirthDay(DateChBirthday.getDate());
            if (radioMale.isSelected()) {
                emp.setGender(0);
            } else if (radioFemale.isSelected()) {
                emp.setGender(1);
            }
            emp.setPhone(txtPhone.getText());
            emp.setEmail(txtEmail.getText());
            emp.setAddress(txtAddress.getText());
            emp.setImage(txtImage.getText());
            emp.setStatus(1);
            EmployeeDAO empDao = new EmployeeDAO();
            if (empDao.create(emp)) {
                JOptionPane.showMessageDialog(this, empDao.getLastError(), "Create Employee", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                 JOptionPane.showMessageDialog(this, empDao.getLastError(), "Create Employee", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmAddEmployee().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChBeginWork;
    private com.toedter.calendar.JDateChooser DateChBirthday;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReset;
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBeginwork;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmployeeID;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblImage1;
    private javax.swing.JLabel lblImage2;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblStart1;
    private javax.swing.JLabel lblStart2;
    private javax.swing.JLabel lblStart3;
    private javax.swing.JLabel lblStart4;
    private javax.swing.JLabel lblStart6;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelContent;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JSeparator sepaAddStu;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtImage;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
