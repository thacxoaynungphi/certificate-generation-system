/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmViewMark.java
 *
 * Created on Mar 26, 2011, 1:48:50 PM
 */
package com.hueic.CerGS.ui.main.mark;

import com.hueic.CerGS.component.IconSystem;
import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.MarkDAO;
import com.hueic.CerGS.dao.PaymentDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Mark;
import com.hueic.CerGS.entity.Register;
import java.awt.event.MouseEvent;
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
public class frmViewMark extends javax.swing.JFrame {

    /** Creates new form frmViewMark */
    private ArrayList<Mark> listMarks = new ArrayList<Mark>();
    private MarkDAO markDAO;
    TableRowSorter<TableModel> sorter;
    private CourseDAO courseDao;
    private RegisterDAO registerDao;
    public ArrayList<Course> listCourse;
    public ArrayList<Register> listRegister;

    public frmViewMark() {
        initComponents();
        new IconSystem(this);
        setLocationRelativeTo(null);
        markDAO = new MarkDAO();
        courseDao = new CourseDAO();
        registerDao = new RegisterDAO();
        listMarks = markDAO.readByAll();
        listCourse = courseDao.readByAll();
        listRegister = registerDao.readByAll();
        loadData(listMarks);
        loadDataCBXCourse();
        loadDataCBXStudent();
    }

    public void loadData(ArrayList<Mark> listMarks) {
        String[] columns = {"Id", "StudentId", "StudentName", "SubjectId", "Mark"};
        Object[][] rows = new Object[listMarks.size()][5];
        int index = 0;
        for (int i = 0; i < listMarks.size(); i++) {
            Mark mark = listMarks.get(i);
            String id = new RegisterDAO().readByStudentId(mark.getStudentId()).getId();
            rows[index][0] = mark.getId();
            rows[index][1] = mark.getStudentId();
            rows[index][2] = new StudentDAO().readByID(id).getFullName();
            rows[index][3] = mark.getSubjectId();
            rows[index][4] = mark.getMark();
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
        srcPanelViewMark.setRowHeader(viewPort);
        srcPanelViewMark.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        srcPanelViewMark.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        srcPanelViewMark.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, tableContent.getTableHeader());
    }

    public void load(ArrayList<Mark> listMarks, String courseId, String studentid) {

        if (studentid.equals("------")) {
            listMarks = markDAO.readByAll();
        } else {
            listMarks = markDAO.readByStudentID(studentid);
        }
        if (listMarks != null) {
            loadData(listMarks);
        }

    }

    private void tableContentMouseClicked(MouseEvent evt) {
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
        lblBanner = new javax.swing.JLabel();
        panelContent = new javax.swing.JPanel();
        lblCourseID = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        cbxCourseID = new javax.swing.JComboBox();
        cbxStudentID = new javax.swing.JComboBox();
        srcPanelViewMark = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        panel3 = new javax.swing.JPanel();
        btnReport = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Mark Student - Certificate Generation System");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblBanner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/ViewMark.png"))); // NOI18N

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBanner)
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelLogo, gridBagConstraints);

        panelContent.setBackground(new java.awt.Color(255, 255, 255));
        panelContent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Mark", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panelContent.setPreferredSize(new java.awt.Dimension(832, 310));
        panelContent.setLayout(new java.awt.GridBagLayout());

        lblCourseID.setText("Choose Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(lblCourseID, gridBagConstraints);

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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(cbxStudentID, gridBagConstraints);

        srcPanelViewMark.setPreferredSize(new java.awt.Dimension(800, 150));

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
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(srcPanelViewMark, gridBagConstraints);

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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelContent.add(panel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(panelContent, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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

    private void cbxStudentIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxStudentIDItemStateChanged
        // TODO add your handling code here:
        if (cbxStudentID.getItemCount() - 1 == listRegister.size()) {
            String courseid = cbxCourseID.getSelectedItem().toString();
            String studentid = cbxStudentID.getSelectedItem().toString();
            load(listMarks, courseid, studentid);
        }
    }//GEN-LAST:event_cbxStudentIDItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmViewMark().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReport;
    private javax.swing.JComboBox cbxCourseID;
    private javax.swing.JComboBox cbxStudentID;
    private javax.swing.JLabel lblBanner;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JScrollPane srcPanelViewMark;
    private javax.swing.JTable tableContent;
    // End of variables declaration//GEN-END:variables
}
