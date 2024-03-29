
/*
 * pnlDevelopDegree.java
 *
 * Created on Apr 2, 2011, 9:06:01 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.CertificateDAO;
import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.MarkDAO;
import com.hueic.CerGS.dao.PermissionDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.entity.Certificate;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Mark;
import com.hueic.CerGS.entity.Register;
import java.sql.Date;
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
public class pnlDevelopDegree extends javax.swing.JPanel {

    private CourseDAO courseDAO;
    private RegisterDAO registerDAO;
    private MarkDAO markDAO;
    private ArrayList<Course> listCourse;
    private ArrayList<Register> listRegister;
    private ArrayList<Mark> listMark;
    private ObjectTableModel tableModel;
    private JTable headerTable;
    frmMain frm;
    private ArrayList<Mark> filter;

    public pnlDevelopDegree(frmMain main) {
        initComponents();
        this.frm = main;
        courseDAO = new CourseDAO();
        registerDAO = new RegisterDAO();
        markDAO = new MarkDAO();
        getData();
    }

    public void getData() {
        listCourse = courseDAO.readByAll();
        listRegister = registerDAO.readByAll();
        listMark = markDAO.readByAll();
        loadData(listMark);
        loadCBXCourse();
        loadCBXStudent();
    }

    public void loadCBXCourse() {
        if (!listCourse.isEmpty()) {
            if (cbxCourseID.getItemCount() != 0) {
                cbxCourseID.removeAllItems();
            }
            cbxCourseID.addItem("----All----");
            cbxCourseID.setSelectedIndex(0);
            for (int i = 0; i < listCourse.size(); i++) {
                cbxCourseID.addItem(listCourse.get(i).getId());
            }
        }

    }

    public void loadCBXStudent() {
        if (!listRegister.isEmpty()) {
            if (cbxStudentID.getItemCount() != 0) {
                cbxStudentID.removeAllItems();
            }
            cbxStudentID.addItem("----All----");
            cbxStudentID.setSelectedIndex(0);
            for (int i = 0; i < listRegister.size(); i++) {
                cbxStudentID.addItem(listRegister.get(i).getStudentId());
            }
        }
    }

    public void loadFiter(String text, ArrayList<Mark> listMark) {
        try {
            filter = new ArrayList<Mark>();
            for (Mark mark : listMark) {
                if (mark.getStudentId().toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")
                        || String.valueOf(mark.getMark()).toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")
                        || mark.getSubjectId().toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")) {
                    filter.add(mark);
                }
            }
            loadData(filter);
        } catch (Exception ex) {
        }
    }

    public void loadData(ArrayList<Mark> listMark) {
        ColumnData[] columns = {
            new ColumnData("ID", 135, SwingConstants.LEFT, 1),
            new ColumnData("Student ID", 100, SwingConstants.LEFT, 2),
            new ColumnData("Subject Id", 140, SwingConstants.LEFT, 3),
            new ColumnData("Mark", 170, SwingConstants.LEFT, 4),};
        tableModel = new ObjectTableModel(tableContent, columns, listMark);
        headerTable = tableModel.getHeaderTable();
        headerTable.createDefaultColumnsFromModel();
        tableContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JViewport viewport = new JViewport();
        viewport.setView(headerTable);
        viewport.setPreferredSize(headerTable.getMaximumSize());
        srcPanelViewMark.setRowHeader(viewport);
        srcPanelViewMark.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlContent = new javax.swing.JPanel();
        lblCourseID = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        cbxCourseID = new javax.swing.JComboBox();
        cbxStudentID = new javax.swing.JComboBox();
        srcPanelViewMark = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        pnlButton = new javax.swing.JPanel();
        btnCreate = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        lblTitleAverageMark = new javax.swing.JLabel();
        lblTitleGrade = new javax.swing.JLabel();
        lblTotalMark = new javax.swing.JLabel();
        lblGrade = new javax.swing.JLabel();
        lblFilter = new javax.swing.JLabel();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(860, 600));
        setPreferredSize(new java.awt.Dimension(860, 600));
        setLayout(new java.awt.GridBagLayout());

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Develop Degree", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        pnlContent.setMinimumSize(new java.awt.Dimension(860, 600));
        pnlContent.setPreferredSize(new java.awt.Dimension(860, 600));
        pnlContent.setLayout(new java.awt.GridBagLayout());

        lblCourseID.setForeground(new java.awt.Color(3, 3, 3));
        lblCourseID.setText("Choose Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        pnlContent.add(lblCourseID, gridBagConstraints);

        lblStudentID.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentID.setText("Choose Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        pnlContent.add(lblStudentID, gridBagConstraints);

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
        pnlContent.add(cbxCourseID, gridBagConstraints);

        cbxStudentID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxStudentID.setMinimumSize(new java.awt.Dimension(200, 20));
        cbxStudentID.setPreferredSize(new java.awt.Dimension(200, 20));
        cbxStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxStudentIDActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(cbxStudentID, gridBagConstraints);

        srcPanelViewMark.setAutoscrolls(true);
        srcPanelViewMark.setMinimumSize(new java.awt.Dimension(840, 450));
        srcPanelViewMark.setPreferredSize(new java.awt.Dimension(840, 450));

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
        srcPanelViewMark.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(srcPanelViewMark, gridBagConstraints);

        pnlButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlButton.setMinimumSize(new java.awt.Dimension(220, 30));
        pnlButton.setPreferredSize(new java.awt.Dimension(220, 30));
        pnlButton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        btnCreate.setText("Create");
        btnCreate.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCreate.setPreferredSize(new java.awt.Dimension(75, 23));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        pnlButton.add(btnCreate);

        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        btnReport.setText("Report Mark");
        btnReport.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReport.setPreferredSize(new java.awt.Dimension(100, 23));
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });
        pnlButton.add(btnReport);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(pnlButton, gridBagConstraints);

        lblTitleAverageMark.setForeground(new java.awt.Color(3, 3, 3));
        lblTitleAverageMark.setText("Average Mark:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(lblTitleAverageMark, gridBagConstraints);

        lblTitleGrade.setForeground(new java.awt.Color(3, 3, 3));
        lblTitleGrade.setText("Grade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlContent.add(lblTitleGrade, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        pnlContent.add(lblTotalMark, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        pnlContent.add(lblGrade, gridBagConstraints);

        lblFilter.setForeground(new java.awt.Color(3, 3, 3));
        lblFilter.setText("Enter Filter:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 215, 5, 5);
        pnlContent.add(lblFilter, gridBagConstraints);

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
        pnlContent.add(filterText, gridBagConstraints);

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
        pnlContent.add(btnFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(pnlContent, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCourseIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCourseIDItemStateChanged
        try {
            if (cbxCourseID.getItemCount() - 1 == listCourse.size()) {
                String courseid = cbxCourseID.getSelectedItem().toString();
                if (courseid != null && !courseid.equals("----All----")) {
                    listRegister = registerDAO.readByCourseId(courseid);
                    listMark = markDAO.readBYCourseID(courseid);
                    loadData(listMark);
                    if (listRegister.size() != 0) {
                        loadCBXStudent();
                    }
                } else {
                    listRegister = registerDAO.readByAll();
                    listMark = markDAO.readByAll();
                    loadData(listMark);
                    if (listRegister.size() != 0) {
                        loadCBXStudent();
                    }
                }
                lblTotalMark.setText("NA");
                lblGrade.setText("NA");
            }
        } catch (Exception ex) {
        }
}//GEN-LAST:event_cbxCourseIDItemStateChanged

    private void cbxStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxStudentIDActionPerformed
        try {
            if (cbxStudentID.getItemCount() - 1 == listRegister.size()) {
                String studentId = cbxStudentID.getSelectedItem().toString();
                if (studentId != null && !studentId.equals("----All----")) {
                    listMark = markDAO.readByStudentID(studentId);
                    loadData(listMark);
                    if (markDAO.isCompleteCourse(registerDAO.readByStudentCourseId(studentId).getCourseId(), studentId)) {
                        float mark = markDAO.avgMark(studentId);
                        lblTotalMark.setText(String.valueOf(mark));
                        lblGrade.setText(markDAO.getGrades(mark));
                        btnCreate.setVisible(true);
                    } else {
                        btnCreate.setVisible(false);
                        lblTotalMark.setText("NA");
                        lblGrade.setText("NA");
                    }
                } else {
                    String courseId = cbxCourseID.getSelectedItem().toString();
                    if (courseId != null && !courseId.equals("----All----")) {
                        listMark = markDAO.readBYCourseID(courseId);
                    } else {
                        listMark = markDAO.readByAll();
                    }
                    loadData(listMark);
                }
            }
        } catch (Exception ex) {
        }
}//GEN-LAST:event_cbxStudentIDActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed

        loadFiter(filterText.getText(), listMark);
}//GEN-LAST:event_btnFilterActionPerformed

    private void filterTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_filterTextCaretUpdate

        loadFiter(filterText.getText(), listMark);
    }//GEN-LAST:event_filterTextCaretUpdate

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        try {
            if (!this.cbxStudentID.getSelectedItem().toString().equals("----All----")) {
                try {
                    if (new PermissionDAO().readByID(frm.accCur.getPermission()).getName().equals("Admin")) {
                        Certificate cer = new Certificate();
                        cer.setStudentID(cbxStudentID.getSelectedItem().toString());
                        cer.setDegreeDay(new Date(System.currentTimeMillis()));
                        cer.setMark(new MarkDAO().avgMark(cbxStudentID.getSelectedItem().toString()));
                        CertificateDAO certificateDAO = new CertificateDAO();
                        if (!certificateDAO.create(cer)) {
                        }
                    }
                    frm.pnlReport.removeAll();
                    dlgChooseReport report = new dlgChooseReport(frm, this);
                    report.getCertificateReport(this.cbxStudentID.getSelectedItem().toString());
                    report.setVisible(true);
                    report.setSize(860, 600);
                    if (report.status == true) {
                        frm.pnlReport.add(report);
                        frm.tpnBusiness.setSelectedComponent(frm.pnlReport);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error! Check again, please.", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "You are choose student!", "Develop Degree", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        try {
            if (!this.cbxStudentID.getSelectedItem().toString().equals("----All----")) {
                frm.pnlReport.removeAll();
                dlgChooseReport report = new dlgChooseReport(frm, this);
                report.getMarkOfStudent(cbxStudentID.getSelectedItem().toString());
                report.setVisible(true);
                report.setSize(860, 600);
                frm.pnlReport.add(report);
                frm.tpnBusiness.setSelectedComponent(frm.pnlReport);
            } else {
                JOptionPane.showMessageDialog(this, "No data!", "Report Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btnReportActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReport;
    private javax.swing.JComboBox cbxCourseID;
    private javax.swing.JComboBox cbxStudentID;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblGrade;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblTitleAverageMark;
    private javax.swing.JLabel lblTitleGrade;
    private javax.swing.JLabel lblTotalMark;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JScrollPane srcPanelViewMark;
    private javax.swing.JTable tableContent;
    // End of variables declaration//GEN-END:variables
}
