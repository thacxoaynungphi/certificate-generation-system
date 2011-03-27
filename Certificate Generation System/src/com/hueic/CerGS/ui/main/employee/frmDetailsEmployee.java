/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ViewEmpFrm.java
 *
 * Created on Mar 16, 2011, 8:31:51 PM
 */
package com.hueic.CerGS.ui.main.employee;

import com.hueic.CerGS.component.IconSystem;
import com.hueic.CerGS.dao.EmployeeDAO;
import com.hueic.CerGS.entity.Employee;

/**
 *
 * @author qhvic
 */
public class frmDetailsEmployee extends javax.swing.JFrame {

    /** Creates new form ViewEmpFrm */
    private Employee emp;

    public frmDetailsEmployee() {
        initComponents();
        new IconSystem(this);
        setLocationRelativeTo(null);
    }

    public frmDetailsEmployee(Employee emp) {
        initComponents();
        new IconSystem(this);
        setLocationRelativeTo(null);
        this.emp = emp;
        loadDetails(emp);
    }

    public void loadDetails(Employee emp) {
        lblEmployeeIDInfo.setText(emp.getId());
        lblFirstnameInfo.setText(emp.getFirstName());
        lblLastnameInfo.setText(emp.getLastName());
        lblBirthdayInfo.setText(emp.getBirthDay().toString());
        lblPhoneInfo.setText(emp.getPhone());
        lblEmailInfo.setText(emp.getEmail());
        lblAddressInfo.setText(emp.getAddress());
        //  lblImageInfo.se
        //TODO: chua set icon cho lblImagesInfo
        lblBeginWorkInfo.setText(emp.getBeginWork().toString());
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

        panelContent = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        separator1 = new javax.swing.JSeparator();
        lblEmployeeID = new javax.swing.JLabel();
        lblFirstname = new javax.swing.JLabel();
        lblLastname = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblBirthday = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblBeginWork = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        lblEmployeeIDInfo = new javax.swing.JLabel();
        lblFirstnameInfo = new javax.swing.JLabel();
        lblLastnameInfo = new javax.swing.JLabel();
        lblGenderInfo = new javax.swing.JLabel();
        lblBirthdayInfo = new javax.swing.JLabel();
        lblEmailInfo = new javax.swing.JLabel();
        lblPhoneInfo = new javax.swing.JLabel();
        lblAddressInfo = new javax.swing.JLabel();
        lblBeginWorkInfo = new javax.swing.JLabel();
        lblImageInfo = new javax.swing.JLabel();
        panelButton = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Details Employee");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelContent.setBackground(new java.awt.Color(255, 255, 255));
        panelContent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details Employee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panelContent.setPreferredSize(new java.awt.Dimension(300, 333));
        panelContent.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Employee");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelContent.add(lblTitle, gridBagConstraints);

        separator1.setPreferredSize(new java.awt.Dimension(560, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panelContent.add(separator1, gridBagConstraints);

        lblEmployeeID.setForeground(new java.awt.Color(3, 3, 3));
        lblEmployeeID.setText("Employee ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 5);
        panelContent.add(lblEmployeeID, gridBagConstraints);

        lblFirstname.setForeground(new java.awt.Color(3, 3, 3));
        lblFirstname.setText("Firstname:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 5);
        panelContent.add(lblFirstname, gridBagConstraints);

        lblLastname.setForeground(new java.awt.Color(3, 3, 3));
        lblLastname.setText("Lastname:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 5);
        panelContent.add(lblLastname, gridBagConstraints);

        lblGender.setForeground(new java.awt.Color(3, 3, 3));
        lblGender.setText("Gender:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 5);
        panelContent.add(lblGender, gridBagConstraints);

        lblBirthday.setForeground(new java.awt.Color(3, 3, 3));
        lblBirthday.setText("Birthday:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 5);
        panelContent.add(lblBirthday, gridBagConstraints);

        lblEmail.setForeground(new java.awt.Color(3, 3, 3));
        lblEmail.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelContent.add(lblEmail, gridBagConstraints);

        lblPhone.setForeground(new java.awt.Color(3, 3, 3));
        lblPhone.setText("Phone:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelContent.add(lblPhone, gridBagConstraints);

        lblAddress.setForeground(new java.awt.Color(3, 3, 3));
        lblAddress.setText("Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelContent.add(lblAddress, gridBagConstraints);

        lblBeginWork.setForeground(new java.awt.Color(3, 3, 3));
        lblBeginWork.setText("Begin work:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelContent.add(lblBeginWork, gridBagConstraints);

        lblImage.setForeground(new java.awt.Color(3, 3, 3));
        lblImage.setText("Image:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelContent.add(lblImage, gridBagConstraints);

        lblEmployeeIDInfo.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblEmployeeIDInfo, gridBagConstraints);

        lblFirstnameInfo.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblFirstnameInfo, gridBagConstraints);

        lblLastnameInfo.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblLastnameInfo, gridBagConstraints);

        lblGenderInfo.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblGenderInfo, gridBagConstraints);

        lblBirthdayInfo.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblBirthdayInfo, gridBagConstraints);

        lblEmailInfo.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 30);
        panelContent.add(lblEmailInfo, gridBagConstraints);

        lblPhoneInfo.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 30);
        panelContent.add(lblPhoneInfo, gridBagConstraints);

        lblAddressInfo.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 30);
        panelContent.add(lblAddressInfo, gridBagConstraints);

        lblBeginWorkInfo.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 30);
        panelContent.add(lblBeginWorkInfo, gridBagConstraints);

        lblImageInfo.setPreferredSize(new java.awt.Dimension(80, 80));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 5);
        panelContent.add(lblImageInfo, gridBagConstraints);

        panelButton.setBackground(new java.awt.Color(255, 255, 255));
        panelButton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setPreferredSize(new java.awt.Dimension(75, 23));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        panelButton.add(btnEdit);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnDelete.setPreferredSize(new java.awt.Dimension(75, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panelButton.add(btnDelete);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        panelButton.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(panelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 349;
        gridBagConstraints.ipady = 102;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelContent, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        frmEditEmployee editEmployee = new frmEditEmployee(emp);
        editEmployee.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        EmployeeDAO empDao = new EmployeeDAO();
        empDao.delete(emp.getId());
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmDetailsEmployee().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressInfo;
    private javax.swing.JLabel lblBeginWork;
    private javax.swing.JLabel lblBeginWorkInfo;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblBirthdayInfo;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailInfo;
    private javax.swing.JLabel lblEmployeeID;
    private javax.swing.JLabel lblEmployeeIDInfo;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblFirstnameInfo;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGenderInfo;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImageInfo;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblLastnameInfo;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhoneInfo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelContent;
    private javax.swing.JSeparator separator1;
    // End of variables declaration//GEN-END:variables
}
