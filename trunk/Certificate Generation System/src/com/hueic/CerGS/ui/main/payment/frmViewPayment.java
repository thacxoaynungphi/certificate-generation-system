/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmViewPayment.java
 *
 * Created on Mar 26, 2011, 2:31:53 PM
 */
package com.hueic.CerGS.ui.main.payment;

import com.hueic.CerGS.component.IconSystem;
import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.PaymentDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Payment;
import com.hueic.CerGS.entity.Register;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author qhvic
 */
public class frmViewPayment extends javax.swing.JFrame {

    /** Creates new form frmViewPayment */
    private int currentId;
    private ArrayList<Payment> listPayments = new ArrayList<Payment>();
    private PaymentDAO paymentDao;
    TableRowSorter<TableModel> sorter;
    private CourseDAO courseDao;
    private RegisterDAO registerDao;
    public ArrayList<Course> listCourse;
    public ArrayList<Register> listRegister;

    public frmViewPayment() {
        initComponents();
        new IconSystem(this);
        setLocationRelativeTo(null);
        paymentDao = new PaymentDAO();
        courseDao = new CourseDAO();
        registerDao = new RegisterDAO();
        listPayments = paymentDao.readByAll();
        loadData(listPayments);
        loadDataCBXCourse();
        loadDataCBXStudent();
    }

    public void loadData(ArrayList<Payment> listPayments) {
        String[] columns = {"Id", "StudentId", "StudentName", "Money", "Payday"};
        Object[][] rows = new Object[listPayments.size()][5];
        int index = 0;
        for (int i = 0; i < listPayments.size(); i++) {
            Payment payment = listPayments.get(i);
            String id = new RegisterDAO().readByStudentId(payment.getStudentId()).getId();

            rows[index][0] = payment.getId();
            rows[index][1] = payment.getStudentId();
            rows[index][2] = new StudentDAO().readByID(id).getFullName();
            rows[index][3] = payment.getMoney();
            rows[index][4] = payment.getPayday();
            index++;
        }
        TableModel model = new DefaultTableModel(rows, columns) {

            public Class getColumnClass(int column) {
                Class returnValue;
                if ((column >= 0) && (column < getColumnCount())) {
                    returnValue = getValueAt(0, column).getClass();
                } else {
                    returnValue = Object.class;
                }
                return returnValue;
            }
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int row, int column) {
                return canEdit[column];
            }
        };
        tableContent = new JTable(model);
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContentMouseClicked(evt);
            }
        });
        sorter = new TableRowSorter<TableModel>(model);
        tableContent.setRowSorter(sorter);
        tableContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JViewport viewPort = new JViewport();
        viewPort.setView(tableContent);
        viewPort.setPreferredSize(tableContent.getMaximumSize());
        srcPanelPayment.setRowHeader(viewPort);
        srcPanelPayment.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, tableContent.getTableHeader());
    }

    public void load(ArrayList<Payment> listPayments, String courseId, String studentid) {

        listPayments = paymentDao.readByStudentId(studentid);
        if (listPayments != null) {
            loadData(listPayments);
            lblTotalTheDeposit.setText(String.valueOf(totalPayment(courseId) - totalDiposit()));
            lblAmountRemaining.setText(String.valueOf(totalDiposit()));
        }
    }

    public void loadDataCBXCourse() {
        cbxCourseID.removeAllItems();
        listCourse = courseDao.readByAll();
        if (listCourse != null) {
            for (int i = 0; i < listCourse.size(); i++) {
                cbxCourseID.addItem(listCourse.get(i).getId());
            }
        }
    }

    public void loadDataCBXStudent() {
        cbxStudentID.removeAllItems();
        listRegister = registerDao.readByAll();
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

        panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        lblCourseID = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        cbxCourseID = new javax.swing.JComboBox();
        cbxStudentID = new javax.swing.JComboBox();
        srcPanelPayment = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        panel3 = new javax.swing.JPanel();
        btnReport = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblTitleTotal = new javax.swing.JLabel();
        lblTitleAmount = new javax.swing.JLabel();
        lblTotalTheDeposit = new javax.swing.JLabel();
        lblAmountRemaining = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Payment - Certificate Generation System");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/ViewPayment.png"))); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panel1, gridBagConstraints);

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panel2.setPreferredSize(new java.awt.Dimension(832, 310));
        panel2.setLayout(new java.awt.GridBagLayout());

        lblCourseID.setText("Choose Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel2.add(lblCourseID, gridBagConstraints);

        lblStudentID.setText("Choose Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel2.add(lblStudentID, gridBagConstraints);

        cbxCourseID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCourseID.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel2.add(cbxCourseID, gridBagConstraints);

        cbxStudentID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxStudentID.setPreferredSize(new java.awt.Dimension(200, 20));
        cbxStudentID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxStudentIDItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel2.add(cbxStudentID, gridBagConstraints);

        srcPanelPayment.setPreferredSize(new java.awt.Dimension(800, 150));

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
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel2.add(srcPanelPayment, gridBagConstraints);

        panel3.setBackground(new java.awt.Color(255, 255, 255));
        panel3.setPreferredSize(new java.awt.Dimension(160, 30));

        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        btnReport.setText("Report");
        btnReport.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReport.setPreferredSize(new java.awt.Dimension(75, 23));
        panel3.add(btnReport);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        panel3.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panel2.add(panel3, gridBagConstraints);

        lblTitleTotal.setText("Total the deposit:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel2.add(lblTitleTotal, gridBagConstraints);

        lblTitleAmount.setText("Amount remaining:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel2.add(lblTitleAmount, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        panel2.add(lblTotalTheDeposit, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        panel2.add(lblAmountRemaining, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(panel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableContentMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cbxStudentIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxStudentIDItemStateChanged
        // TODO add your handling code here:
        if (cbxStudentID.getItemCount() != 0) {
            String studentid = cbxStudentID.getSelectedItem().toString();
            String courseid = cbxCourseID.getSelectedItem().toString();
            load(listPayments, courseid, studentid);
        }
    }//GEN-LAST:event_cbxStudentIDItemStateChanged

    public float totalPayment(String value) {
        for (Course course : listCourse) {
            if (course.getId().equals(value)) {
                return course.getTotalFees();
            }
        }
        return 0;
    }

    public float totalDiposit() {
        float total = 0;
        for (Payment payment : listPayments) {
            total += payment.getMoney();
        }
        return total;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmViewPayment().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReport;
    private javax.swing.JComboBox cbxCourseID;
    private javax.swing.JComboBox cbxStudentID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAmountRemaining;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblTitleAmount;
    private javax.swing.JLabel lblTitleTotal;
    private javax.swing.JLabel lblTotalTheDeposit;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JScrollPane srcPanelPayment;
    private javax.swing.JTable tableContent;
    // End of variables declaration//GEN-END:variables
}
