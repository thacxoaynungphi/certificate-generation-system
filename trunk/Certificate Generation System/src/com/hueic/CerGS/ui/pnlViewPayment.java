/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pnlViewPayment.java
 *
 * Created on Apr 2, 2011, 9:42:44 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.PaymentDAO;
import com.hueic.CerGS.dao.PermissionDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Payment;
import com.hueic.CerGS.entity.Register;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

/**
 *
 * @author qhvic
 */
public class pnlViewPayment extends javax.swing.JPanel {

    public boolean isStudent = false;
    /** Creates new form pnlViewPayment */
    private ArrayList<Payment> listPayments = new ArrayList<Payment>();
    private PaymentDAO paymentDao;
    private CourseDAO courseDao;
    private RegisterDAO registerDao;
    public ArrayList<Course> listCourse;
    public ArrayList<Register> listRegister;
    private ObjectTableModel tableModel;
    private JTable headerTable;
    frmMain frm;
    private ArrayList<Payment> filter;

    public pnlViewPayment() {
        initComponents();
        paymentDao = new PaymentDAO();
        courseDao = new CourseDAO();
        registerDao = new RegisterDAO();
        getData();
    }

    public void getData() {
        listPayments = paymentDao.readByAll();
        listCourse = courseDao.readByAll();
        listRegister = registerDao.readByAll();
        loadData(listPayments);
        loadDataCBXCourse();
        loadDataCBXStudent();
    }

    public pnlViewPayment(frmMain frm) {
        initComponents();
        this.frm = frm;
        paymentDao = new PaymentDAO();
        courseDao = new CourseDAO();
        registerDao = new RegisterDAO();
        PermissionDAO perDao = new PermissionDAO();
        if (perDao.readByID(frm.accCur.getPermission()).getName().equals("Student")) {
            listPayments = paymentDao.readByStudentIdOfPerson(frm.accCur.getUsername(), "");
            listCourse = courseDao.readCourseRegisterByStudentIdOfPerson(frm.accCur.getUsername());
            loadData(listPayments);
            loadDataCBXCourse();
            isStudent = true;
            cbxStudentID.setVisible(false);
            lblStudentID.setVisible(false);
        } else {
            getData();
        }
    }

    public void loadFiter(String text, ArrayList<Payment> listPayments) {
        filter = new ArrayList<Payment>();
        for (Payment pay : listPayments) {
            if (pay.getStudentId().toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")
                    || String.valueOf(pay.getMoney()).toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")) {
                filter.add(pay);
            }
        }
        loadData(filter);
    }

    public void loadData(ArrayList<Payment> listPayments) {
        ColumnData[] columns = {
            new ColumnData("ID", 135, SwingConstants.LEFT, 1),
            new ColumnData("Student ID", 100, SwingConstants.LEFT, 2),
            new ColumnData("Money", 140, SwingConstants.LEFT, 3),
            new ColumnData("Payday", 170, SwingConstants.LEFT, 4),};
        tableModel = new ObjectTableModel(tableContent, columns, listPayments);
        headerTable = tableModel.getHeaderTable();
        // Create numbering column
        headerTable.createDefaultColumnsFromModel();
        tableContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Put it in a viewport that we can control a bit
        JViewport viewport = new JViewport();
        // Display numbering column
        viewport.setView(headerTable);
        viewport.setPreferredSize(headerTable.getMaximumSize());
        srcPanelPayment.setRowHeader(viewport);
        srcPanelPayment.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    public void load(ArrayList<Payment> listPayments, String courseId, String studentid) {
        if (studentid.equals("------")) {
            listPayments = paymentDao.readByAll();
        } else {
            listPayments = paymentDao.readByStudentId(studentid);
        }
        if (listPayments != null) {
            loadData(listPayments);
            float money = paymentDao.getTotalDiposit(studentid);
            if (studentid.equals("------")) {
                lblTitleAmount.setVisible(false);
                lblTitleTotal.setVisible(false);
            } else {
                lblTotalTheDeposit.setText(String.valueOf(money));
                lblAmountRemaining.setText(String.valueOf(courseDao.readById(registerDao.readByStudentId(studentid).getCourseId()).getTotalFees() - money));
            }
        }
    }

    public void loadDataCBXCourse() {

        if (cbxCourseID.getItemCount() != 0) {
            cbxCourseID.removeAllItems();
        }
        cbxCourseID.addItem("-- All --");
        cbxCourseID.setSelectedIndex(0);
        if (listCourse != null) {
            for (int i = 0; i < listCourse.size(); i++) {
                cbxCourseID.addItem(listCourse.get(i).getId());
            }
        }
    }

    public void loadDataCBXStudent() {
        if (cbxStudentID.getItemCount() != 0) {
            cbxStudentID.removeAllItems();
        }
        cbxStudentID.addItem("------");
        cbxStudentID.setSelectedIndex(0);
        if (listRegister != null) {
            for (int i = 0; i < listRegister.size(); i++) {
                cbxStudentID.addItem(listRegister.get(i).getStudentId());
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

        panelContent = new javax.swing.JPanel();
        lblCourseID = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        cbxCourseID = new javax.swing.JComboBox();
        cbxStudentID = new javax.swing.JComboBox();
        srcPanelPayment = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        panelButton = new javax.swing.JPanel();
        btnReport = new javax.swing.JButton();
        lblTitleTotal = new javax.swing.JLabel();
        lblTitleAmount = new javax.swing.JLabel();
        lblTotalTheDeposit = new javax.swing.JLabel();
        lblAmountRemaining = new javax.swing.JLabel();
        lblFilter = new javax.swing.JLabel();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(860, 600));
        setPreferredSize(new java.awt.Dimension(860, 600));
        setLayout(new java.awt.GridBagLayout());

        panelContent.setBackground(new java.awt.Color(255, 255, 255));
        panelContent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelContent.setMinimumSize(new java.awt.Dimension(860, 600));
        panelContent.setPreferredSize(new java.awt.Dimension(860, 600));
        panelContent.setLayout(new java.awt.GridBagLayout());

        lblCourseID.setForeground(new java.awt.Color(3, 3, 3));
        lblCourseID.setText("Choose Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelContent.add(lblCourseID, gridBagConstraints);

        lblStudentID.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentID.setText("Choose Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelContent.add(lblStudentID, gridBagConstraints);

        cbxCourseID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCourseID.setMinimumSize(new java.awt.Dimension(200, 20));
        cbxCourseID.setPreferredSize(new java.awt.Dimension(200, 20));
        cbxCourseID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCourseIDItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(cbxCourseID, gridBagConstraints);

        cbxStudentID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxStudentID.setMinimumSize(new java.awt.Dimension(200, 20));
        cbxStudentID.setPreferredSize(new java.awt.Dimension(200, 20));
        cbxStudentID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxStudentIDItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(cbxStudentID, gridBagConstraints);

        srcPanelPayment.setMinimumSize(new java.awt.Dimension(840, 450));
        srcPanelPayment.setPreferredSize(new java.awt.Dimension(840, 450));

        tableContent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContentMouseClicked(evt);
            }
        });
        srcPanelPayment.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(srcPanelPayment, gridBagConstraints);

        panelButton.setBackground(new java.awt.Color(255, 255, 255));
        panelButton.setMinimumSize(new java.awt.Dimension(90, 30));
        panelButton.setPreferredSize(new java.awt.Dimension(90, 30));

        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        btnReport.setText("Report");
        btnReport.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReport.setPreferredSize(new java.awt.Dimension(75, 23));
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });
        panelButton.add(btnReport);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(panelButton, gridBagConstraints);

        lblTitleTotal.setForeground(new java.awt.Color(3, 3, 3));
        lblTitleTotal.setText("Total the deposit:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblTitleTotal, gridBagConstraints);

        lblTitleAmount.setForeground(new java.awt.Color(3, 3, 3));
        lblTitleAmount.setText("Amount remaining:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblTitleAmount, gridBagConstraints);

        lblTotalTheDeposit.setForeground(new java.awt.Color(3, 3, 3));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        panelContent.add(lblTotalTheDeposit, gridBagConstraints);

        lblAmountRemaining.setForeground(new java.awt.Color(3, 3, 3));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        panelContent.add(lblAmountRemaining, gridBagConstraints);

        lblFilter.setForeground(new java.awt.Color(3, 3, 3));
        lblFilter.setText("Enter Filter:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 215, 5, 5);
        panelContent.add(lblFilter, gridBagConstraints);

        filterText.setMinimumSize(new java.awt.Dimension(150, 20));
        filterText.setPreferredSize(new java.awt.Dimension(150, 20));
        filterText.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                filterTextCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(filterText, gridBagConstraints);

        btnFilter.setText("Filter");
        btnFilter.setMaximumSize(new java.awt.Dimension(90, 23));
        btnFilter.setMinimumSize(new java.awt.Dimension(75, 23));
        btnFilter.setPreferredSize(new java.awt.Dimension(75, 23));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(btnFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(panelContent, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCourseIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCourseIDItemStateChanged
        // TODO add your handling code here:
        if (cbxCourseID.getItemCount() - 1 == listCourse.size()) {
            String coursid = cbxCourseID.getSelectedItem().toString();
            if (coursid.equals("-- All --")) {
                if (isStudent == false) {
                    listRegister = registerDao.readByAll();
                    loadDataCBXStudent();
                } else {
                    listPayments = paymentDao.readByStudentIdOfPerson(frm.accCur.getUsername(), "");
                    loadData(listPayments);
                }
            } else {
                if (isStudent == false) {
                    listRegister = registerDao.readByCourseId(coursid);
                    loadDataCBXStudent();
                } else {

                    listPayments = paymentDao.readByStudentIdOfPerson(frm.accCur.getUsername(), coursid);
                    float money = paymentDao.getTotalDiposit(registerDao.readById(frm.accCur.getUsername(), coursid).getStudentId());
                    lblTotalTheDeposit.setText(String.valueOf(money));
                    lblAmountRemaining.setText(String.valueOf(courseDao.readById(coursid).getTotalFees() - money));
                    loadData(listPayments);
                }
            }
        }
}//GEN-LAST:event_cbxCourseIDItemStateChanged

    private void cbxStudentIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxStudentIDItemStateChanged
        // TODO add your handling code here:
        if (cbxStudentID.getItemCount() - 1 == listRegister.size()) {
            String courseid = cbxCourseID.getSelectedItem().toString();
            String studentid = cbxStudentID.getSelectedItem().toString();
            load(listPayments, courseid, studentid);
        }
}//GEN-LAST:event_cbxStudentIDItemStateChanged

    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_tableContentMouseClicked

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        loadFiter(filterText.getText(), listPayments);
}//GEN-LAST:event_btnFilterActionPerformed

    private void filterTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_filterTextCaretUpdate
        // TODO add your handling code here:
        loadFiter(filterText.getText(), listPayments);
    }//GEN-LAST:event_filterTextCaretUpdate

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
        PermissionDAO perDao = new PermissionDAO();
        if (perDao.readByID(frm.accCur.getPermission()).getName().equals("Student")) {
            if (!cbxCourseID.getSelectedItem().toString().equals("-- All --")) {
                frm.pnlReport.removeAll();
                dlgChooseReport report = new dlgChooseReport(frm, frm.pnlViewPaymentTab);
                report.getStudentFeeReport(registerDao.readById(this.frm.accCur.getUsername(), cbxCourseID.getSelectedItem().toString()).getStudentId());
                report.setVisible(true);
                report.setSize(860, 600);
                frm.pnlReport.add(report);
                frm.tpnBusiness.setSelectedComponent(frm.pnlReport);
            } else {
                JOptionPane.showMessageDialog(this, "You are choose course!", "Report payment student", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            if (!this.cbxStudentID.getSelectedItem().equals("------")) {
                frm.pnlReport.removeAll();
                dlgChooseReport report = new dlgChooseReport(frm, frm.pnlViewPaymentTab);
                report.getStudentFeeReport(this.cbxStudentID.getSelectedItem().toString());
                report.setVisible(true);
                report.setSize(860, 600);
                frm.pnlReport.add(report);
                frm.tpnBusiness.setSelectedComponent(frm.pnlReport);
            } else {
                JOptionPane.showMessageDialog(this, "You are choose student!", "Report payment student", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnReportActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReport;
    private javax.swing.JComboBox cbxCourseID;
    private javax.swing.JComboBox cbxStudentID;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel lblAmountRemaining;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblTitleAmount;
    private javax.swing.JLabel lblTitleTotal;
    private javax.swing.JLabel lblTotalTheDeposit;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelContent;
    private javax.swing.JScrollPane srcPanelPayment;
    private javax.swing.JTable tableContent;
    // End of variables declaration//GEN-END:variables
}
