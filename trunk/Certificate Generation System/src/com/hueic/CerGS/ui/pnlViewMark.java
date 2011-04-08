/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pnlViewMark.java
 *
 * Created on Apr 2, 2011, 9:30:44 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.MarkDAO;
import com.hueic.CerGS.dao.PermissionDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Mark;
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
public class pnlViewMark extends javax.swing.JPanel {

    /** Creates new form pnlViewMark */
    private ArrayList<Mark> listMarks = new ArrayList<Mark>();
    private MarkDAO markDAO;
    private CourseDAO courseDao;
    private RegisterDAO registerDao;
    public ArrayList<Course> listCourse;
    public ArrayList<Register> listRegister;
    private ObjectTableModel tableModel;
    private JTable headerTable;
    frmMain frm;
    public boolean isStudent = false;
    private ArrayList<Mark> filter;

    public pnlViewMark() {
        initComponents();
        markDAO = new MarkDAO();
        courseDao = new CourseDAO();
        registerDao = new RegisterDAO();
        getData();
    }

    public void getData() {
        listMarks = markDAO.readByAll();
        listCourse = courseDao.readByAll();
        listRegister = registerDao.readByAll();
        loadData(listMarks);
        loadDataCBXCourse();
        loadDataCBXStudent();
    }

    public pnlViewMark(frmMain frm) {
        initComponents();
        this.frm = frm;
        markDAO = new MarkDAO();
        courseDao = new CourseDAO();
        registerDao = new RegisterDAO();
        PermissionDAO perDao = new PermissionDAO();
        if (perDao.readByID(frm.accCur.getPermission()).getName().equals("Student")) {
            listMarks = markDAO.readByStudentIDOfPerson(frm.accCur.getUsername(), "");
            listCourse = courseDao.readCourseRegisterByStudentIdOfPerson(frm.accCur.getUsername());
            loadData(listMarks);
            loadDataCBXCourse();
            isStudent = true;
            cbxStudentID.setVisible(false);
            lblStudentID.setVisible(false);
        } else {
            getData();
        }

    }

    public void loadFiter(String text, ArrayList<Mark> listMark) {
        filter = new ArrayList<Mark>();
        for (Mark mark : listMark) {
            if (mark.getStudentId().toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")
                    || String.valueOf(mark.getMark()).toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")
                    || mark.getSubjectId().toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")) {
                filter.add(mark);
            }
        }
        loadData(filter);
    }

    public void loadData(ArrayList<Mark> listMarks) {
        ColumnData[] columns = {
            new ColumnData("ID", 135, SwingConstants.LEFT, 1),
            new ColumnData("Student ID", 100, SwingConstants.LEFT, 2),
            new ColumnData("Subject", 140, SwingConstants.LEFT, 3),
            new ColumnData("Mark", 170, SwingConstants.LEFT, 4),};
        tableModel = new ObjectTableModel(tableContent, columns, listMarks);
        headerTable = tableModel.getHeaderTable();
        // Create numbering column
        headerTable.createDefaultColumnsFromModel();
        tableContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Put it in a viewport that we can control a bit
        JViewport viewport = new JViewport();
        // Display numbering column
        viewport.setView(headerTable);
        viewport.setPreferredSize(headerTable.getMaximumSize());
        srcPanelViewMark.setRowHeader(viewport);
        srcPanelViewMark.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    public void load(ArrayList<Mark> listMarks, String courseId, String studentid) {

        if (studentid.equals("------")) {
            if (courseId.equals("-- All --")) {
                listMarks = markDAO.readByAll();
            } else {
                listMarks = markDAO.readBYCourseID(courseId);
            }
        } else {
            listMarks = markDAO.readByStudentID(studentid);
        }
        if (listMarks != null) {
            loadData(listMarks);
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
                cbxStudentID.addItem(listRegister.get(i).getStudentCourseId());
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
        srcPanelViewMark = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        panel3 = new javax.swing.JPanel();
        btnReport = new javax.swing.JButton();
        lblFilter = new javax.swing.JLabel();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(860, 600));
        setPreferredSize(new java.awt.Dimension(860, 600));
        setLayout(new java.awt.GridBagLayout());

        panelContent.setBackground(new java.awt.Color(255, 255, 255));
        panelContent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Mark", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelContent.setForeground(new java.awt.Color(3, 3, 3));
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
        tableContent.setMaximumSize(new java.awt.Dimension(0, 0));
        tableContent.setMinimumSize(new java.awt.Dimension(0, 0));
        tableContent.setPreferredSize(new java.awt.Dimension(0, 0));
        srcPanelViewMark.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(srcPanelViewMark, gridBagConstraints);

        panel3.setBackground(new java.awt.Color(255, 255, 255));
        panel3.setMinimumSize(new java.awt.Dimension(160, 35));
        panel3.setPreferredSize(new java.awt.Dimension(160, 35));
        panel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        btnReport.setText("Report");
        btnReport.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReport.setPreferredSize(new java.awt.Dimension(75, 23));
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });
        panel3.add(btnReport);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(panel3, gridBagConstraints);

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
                    listMarks = markDAO.readByAll();
                    loadData(listMarks);
                    listRegister = registerDao.readByAll();
                    loadDataCBXStudent();
                } else {
                    listMarks = markDAO.readByStudentIDOfPerson(frm.accCur.getUsername(), "");
                    loadData(listMarks);
                }
            } else {
                if (isStudent == false) {
                    listMarks = markDAO.readBYCourseID(coursid);
                    loadData(listMarks);
                    listRegister = registerDao.readByCourseId(coursid);
                    loadDataCBXStudent();
                } else {
                    listMarks = markDAO.readByStudentIDOfPerson(frm.accCur.getUsername(), coursid);
                    loadData(listMarks);
                }
            }
        }
}//GEN-LAST:event_cbxCourseIDItemStateChanged

    private void cbxStudentIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxStudentIDItemStateChanged
        // TODO add your handling code here:
        if (cbxStudentID.getItemCount() - 1 == listRegister.size()) {
            String courseid = cbxCourseID.getSelectedItem().toString();
            String studentid = cbxStudentID.getSelectedItem().toString();
            load(listMarks, courseid, studentid);
        }
}//GEN-LAST:event_cbxStudentIDItemStateChanged

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        loadFiter(filterText.getText(), listMarks);
}//GEN-LAST:event_btnFilterActionPerformed

    private void filterTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_filterTextCaretUpdate
        // TODO add your handling code here:
        loadFiter(filterText.getText(), listMarks);
    }//GEN-LAST:event_filterTextCaretUpdate

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
        PermissionDAO perDao = new PermissionDAO();
        if (perDao.readByID(frm.accCur.getPermission()).getName().equals("Student")) {
            if (!cbxCourseID.getSelectedItem().toString().equals("-- All --")) {
                frm.pnlReport.removeAll();
                dlgChooseReport report = new dlgChooseReport(frm, frm.pnlViewMarkTab);
                report.getStudentMarkReport(registerDao.readById(this.frm.accCur.getUsername(), cbxCourseID.getSelectedItem().toString()).getStudentCourseId());
                report.setVisible(true);
                report.setSize(860, 600);
                frm.pnlReport.add(report);
                frm.tpnBusiness.setSelectedComponent(frm.pnlReport);
            } else {
                JOptionPane.showMessageDialog(this, "You are choose course!", "Report mark for student", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            if (!this.cbxStudentID.getSelectedItem().toString().equals("------")) {
                frm.pnlReport.removeAll();
                dlgChooseReport report = new dlgChooseReport(frm, frm.pnlViewMarkTab);
                report.getStudentMarkReport(this.cbxStudentID.getSelectedItem().toString());
                report.setVisible(true);
                report.setSize(860, 600);
                frm.pnlReport.add(report);
                frm.tpnBusiness.setSelectedComponent(frm.pnlReport);
            } else {
                JOptionPane.showMessageDialog(this, "You are choose student!", "Report mark for student", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnReportActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReport;
    private javax.swing.JComboBox cbxCourseID;
    private javax.swing.JComboBox cbxStudentID;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panelContent;
    private javax.swing.JScrollPane srcPanelViewMark;
    private javax.swing.JTable tableContent;
    // End of variables declaration//GEN-END:variables
}
