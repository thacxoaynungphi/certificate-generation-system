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
import java.util.regex.PatternSyntaxException;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
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
        listCourse = courseDao.readByAll();
        listRegister = registerDao.readByAll();
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
        if (studentid.equals("------")) {
            listPayments = paymentDao.readByAll();
        } else {
            listPayments = paymentDao.readByStudentId(studentid);
        }
        if (listPayments != null) {
            loadData(listPayments);
            float money = paymentDao.totalDiposit(studentid);
            if (studentid.equals("------")) {
                lblTitleAmount.setVisible(false);
                lblTitleTotal.setVisible(false);
            } else {
                lblTotalTheDeposit.setText(String.valueOf(courseDao.readById(registerDao.readByStudentId(studentid).getCourseId()).getTotalFees() - money));
                lblAmountRemaining.setText(String.valueOf(money));
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

        panelLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        panelContent = new javax.swing.JPanel();
        lblCourseID = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        cbxCourseID = new javax.swing.JComboBox();
        cbxStudentID = new javax.swing.JComboBox();
        srcPanelPayment = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        panelButton = new javax.swing.JPanel();
        btnReport = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblTitleTotal = new javax.swing.JLabel();
        lblTitleAmount = new javax.swing.JLabel();
        lblTotalTheDeposit = new javax.swing.JLabel();
        lblAmountRemaining = new javax.swing.JLabel();
        lblFilter = new javax.swing.JLabel();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Payment - Certificate Generation System");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/ViewPayment.png"))); // NOI18N

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelLogo, gridBagConstraints);

        panelContent.setBackground(new java.awt.Color(255, 255, 255));
        panelContent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelContent.setPreferredSize(new java.awt.Dimension(832, 310));
        panelContent.setLayout(new java.awt.GridBagLayout());

        lblCourseID.setForeground(new java.awt.Color(3, 3, 3));
        lblCourseID.setText("Choose Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblCourseID, gridBagConstraints);

        lblStudentID.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentID.setText("Choose Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblStudentID, gridBagConstraints);

        cbxCourseID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCourseID.setPreferredSize(new java.awt.Dimension(200, 20));
        cbxCourseID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCourseIDItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(cbxCourseID, gridBagConstraints);

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
        panelContent.add(cbxStudentID, gridBagConstraints);

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
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(srcPanelPayment, gridBagConstraints);

        panelButton.setBackground(new java.awt.Color(255, 255, 255));
        panelButton.setPreferredSize(new java.awt.Dimension(160, 30));

        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        btnReport.setText("Report");
        btnReport.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReport.setPreferredSize(new java.awt.Dimension(75, 23));
        panelButton.add(btnReport);

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
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 5);
        panelContent.add(panelButton, gridBagConstraints);

        lblTitleTotal.setForeground(new java.awt.Color(3, 3, 3));
        lblTitleTotal.setText("Total the deposit:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelContent.add(lblTitleTotal, gridBagConstraints);

        lblTitleAmount.setForeground(new java.awt.Color(3, 3, 3));
        lblTitleAmount.setText("Amount remaining:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
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
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 150, 5, 5);
        panelContent.add(lblFilter, gridBagConstraints);

        filterText.setMinimumSize(new java.awt.Dimension(150, 20));
        filterText.setPreferredSize(new java.awt.Dimension(150, 20));
        filterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filterTextKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        panelContent.add(filterText, gridBagConstraints);

        btnFilter.setText("Filter");
        btnFilter.setMaximumSize(new java.awt.Dimension(90, 23));
        btnFilter.setMinimumSize(new java.awt.Dimension(90, 23));
        btnFilter.setPreferredSize(new java.awt.Dimension(90, 23));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        panelContent.add(btnFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(panelContent, gridBagConstraints);

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
        if (cbxStudentID.getItemCount() - 1 == listRegister.size()) {
            String courseid = cbxCourseID.getSelectedItem().toString();
            String studentid = cbxStudentID.getSelectedItem().toString();
            load(listPayments, courseid, studentid);
        }
    }//GEN-LAST:event_cbxStudentIDItemStateChanged

private void cbxCourseIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCourseIDItemStateChanged
    // TODO add your handling code here:
    if (cbxCourseID.getItemCount() - 1 == listCourse.size()) {
        String coursid = cbxCourseID.getSelectedItem().toString();
        if (coursid.equals("-- All --")) {
            listRegister = registerDao.readByAll();
            loadDataCBXStudent();
        } else {
            listRegister = registerDao.readByCourseId(coursid);
            loadDataCBXStudent();
        }
    }
}//GEN-LAST:event_cbxCourseIDItemStateChanged

    public void searchStart() {
        if (!listPayments.isEmpty()) {
            String text = filterText.getText();
            System.out.println("Text :" + text);
            if (text.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                try {
                    sorter.setRowFilter(RowFilter.regexFilter(text));
                } catch (PatternSyntaxException pse) {
                    System.err.println("Bad regex pattern");
                }
            }
        }
    }

private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
    // TODO add your handling code here:
    searchStart();
}//GEN-LAST:event_btnFilterActionPerformed

private void filterTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTextKeyPressed
    // TODO add your handling code here:
    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
        searchStart();
    }
}//GEN-LAST:event_filterTextKeyPressed

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
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReport;
    private javax.swing.JComboBox cbxCourseID;
    private javax.swing.JComboBox cbxStudentID;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel lblAmountRemaining;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblTitleAmount;
    private javax.swing.JLabel lblTitleTotal;
    private javax.swing.JLabel lblTotalTheDeposit;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JScrollPane srcPanelPayment;
    private javax.swing.JTable tableContent;
    // End of variables declaration//GEN-END:variables
}
