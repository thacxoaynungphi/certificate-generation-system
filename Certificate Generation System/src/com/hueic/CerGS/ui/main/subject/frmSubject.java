/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SubjectFrm.java
 *
 * Created on Mar 19, 2011, 8:53:19 AM
 */
package com.hueic.CerGS.ui.main.subject;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.SubjectDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Subject;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
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
public class frmSubject extends javax.swing.JFrame {

    private boolean isAdd;
    CourseDAO courseDAO = new CourseDAO();
    SubjectDAO subjectDao = new SubjectDAO();
    ArrayList<Subject> listSubject = new ArrayList<Subject>();
    ArrayList<Course> listCourses = new ArrayList<Course>();
    TableRowSorter<TableModel> sorter;

    /** Creates new form SubjectFrm */
    public frmSubject() {
        initComponents();
        setLocationRelativeTo(null);
        listCourses = courseDAO.readByAll();
        listSubject = subjectDao.readByAll();
        loadDataCBXCouseId();
        loadData(listSubject);
        if (listSubject.size() != 0) {
            loadDetails(listSubject.get(0));
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
        lblCourse = new javax.swing.JLabel();
        cbxCourse = new javax.swing.JComboBox();
        filterText = new javax.swing.JTextField();
        srcPanelSubject = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        btnFilter = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblNameSub = new javax.swing.JLabel();
        lblCoefficient = new javax.swing.JLabel();
        lblCourseID = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtCoefficient = new javax.swing.JTextField();
        lblSubjectID = new javax.swing.JLabel();
        txtSubjectId = new javax.swing.JTextField();
        sepa1 = new javax.swing.JSeparator();
        txtCoureID = new javax.swing.JTextField();
        cbxCourseID = new javax.swing.JComboBox();
        panel4 = new javax.swing.JPanel();
        lblBanner = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Subject");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(832, 375));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Subject", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panel1.setPreferredSize(new java.awt.Dimension(150, 150));
        panel1.setLayout(new java.awt.GridBagLayout());

        lblCourse.setText("Choose Subject ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 5);
        panel1.add(lblCourse, gridBagConstraints);

        cbxCourse.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 5);
        panel1.add(cbxCourse, gridBagConstraints);

        filterText.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel1.add(filterText, gridBagConstraints);

        srcPanelSubject.setMinimumSize(new java.awt.Dimension(400, 150));
        srcPanelSubject.setPreferredSize(new java.awt.Dimension(400, 150));

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
        tableContent.setPreferredSize(new java.awt.Dimension(250, 64));
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContentMouseClicked(evt);
            }
        });
        srcPanelSubject.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel1.add(srcPanelSubject, gridBagConstraints);

        btnFilter.setText("Filter");
        btnFilter.setPreferredSize(new java.awt.Dimension(90, 23));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panel1.add(btnFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.ipady = 110;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panel1, gridBagConstraints);

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14)), "Management Subject", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panel2.setPreferredSize(new java.awt.Dimension(235, 233));
        panel2.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Subject");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panel2.add(lblTitle, gridBagConstraints);

        lblNameSub.setText("Name subject:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel2.add(lblNameSub, gridBagConstraints);

        lblCoefficient.setText("Coefficient:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel2.add(lblCoefficient, gridBagConstraints);

        lblCourseID.setText("Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel2.add(lblCourseID, gridBagConstraints);

        panel3.setBackground(new java.awt.Color(255, 255, 255));
        panel3.setPreferredSize(new java.awt.Dimension(265, 33));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnAdd.setPreferredSize(new java.awt.Dimension(75, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        panel3.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panel3.add(btnUpdate);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnDelete.setPreferredSize(new java.awt.Dimension(75, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panel3.add(btnDelete);

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
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        panel2.add(panel3, gridBagConstraints);

        txtName.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 5);
        panel2.add(txtName, gridBagConstraints);

        txtCoefficient.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 5);
        panel2.add(txtCoefficient, gridBagConstraints);

        lblSubjectID.setText("Subject ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel2.add(lblSubjectID, gridBagConstraints);

        txtSubjectId.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 9, 5, 5);
        panel2.add(txtSubjectId, gridBagConstraints);

        sepa1.setPreferredSize(new java.awt.Dimension(280, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 44, 10, 0);
        panel2.add(sepa1, gridBagConstraints);

        txtCoureID.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 5);
        panel2.add(txtCoureID, gridBagConstraints);

        cbxCourseID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCourseID.setPreferredSize(new java.awt.Dimension(230, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 5);
        panel2.add(cbxCourseID, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panel2, gridBagConstraints);

        panel4.setBackground(new java.awt.Color(255, 255, 255));
        panel4.setLayout(new java.awt.GridBagLayout());

        lblBanner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/BannerSubject.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panel4.add(lblBanner, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panel4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void loadDataCBXCouseId() {
        cbxCourseID.removeAllItems();

        for (int i = 0; i < listCourses.size(); i++) {
            cbxCourseID.addItem(listCourses.get(i).getId());
        }
    }

    public void loadData(ArrayList<Subject> listSubjects) {
        String[] columns = {"ID", "Name", "Coefficient", "Course"};
        Object[][] rows = new Object[listSubjects.size()][4];
        int index = 0;
        for (int i = 0; i < listSubjects.size(); i++) {
            Subject subject = listSubjects.get(i);
            rows[index][0] = subject.getId();
            rows[index][1] = subject.getName();
            rows[index][2] = subject.getCoefficient();
            rows[index][3] = find(subject.getCourseID()).getName();
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
                false, false
            };

            @Override
            public boolean isCellEditable(int row, int column) {
                return canEdit[column];
            }
        };
        tableContent = new JTable(model);
        tableContent.getTableHeader().setReorderingAllowed(false);
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContentMouseClicked(evt);
            }

            private void tableContentMouseClicked(MouseEvent evt) {
                throw new UnsupportedOperationException("Not yet implemented");
            }
        });
        sorter = new TableRowSorter<TableModel>(model);
        tableContent.setRowSorter(sorter);
        tableContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JViewport viewPort = new JViewport();
        viewPort.setView(tableContent);
        viewPort.setPreferredSize(tableContent.getMaximumSize());
        srcPanelSubject.setRowHeader(viewPort);
        srcPanelSubject.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, tableContent.getTableHeader());
    }

    public void loadDetails(Subject subject) {
        txtSubjectId.setText(subject.getId());
        txtName.setText(subject.getName());
        txtCoefficient.setText(String.valueOf(subject.getCoefficient()));
        String courseName = find(subject.getId()).getName();
        if (courseName != null) {
            for (int i = 0; i < cbxCourseID.getItemCount(); i++) {
                if (cbxCourseID.getItemAt(i).toString().equals(courseName)) {
                    cbxCourseID.setSelectedIndex(i);

                }
            }
        }
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            if (!isAdd) {
                isAdd = true;
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
                txtCoureID.setVisible(false);
                cbxCourseID.setVisible(true);
            } else {
                String subjectId = txtSubjectId.getText();
                String subjectName = txtName.getName();
                int coefficient = Integer.parseInt(txtCoefficient.getText());
                String courseName = cbxCourse.getSelectedItem().toString();
                String id = findByName(courseName).getId();
                Subject subject = new Subject(subjectId, subjectName, coefficient, id);
                if (subjectDao.create(subject)) {
                    JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Create Subject", JOptionPane.INFORMATION_MESSAGE);
                    listSubject.add(subject);
                    loadData(listSubject);
                    loadDetails(subject);
                    isAdd = false;
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                    txtCoureID.setVisible(true);
                    cbxCourseID.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Create Subject", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Create Subject", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnAddActionPerformed

    public Course findByName(String name) {
        for (int i = 0; i < listCourses.size(); i++) {
            if (listCourses.get(i).getName().equalsIgnoreCase(name)) {
                return listCourses.get(i);
            }
        }
        return null;
    }

    public Course find(String id) {
        for (int i = 0; i < listCourses.size(); i++) {
            if (listCourses.get(i).getId().equalsIgnoreCase(id)) {
                return listCourses.get(i);
            }
        }
        return null;
    }

    public Subject findSubject(String id) {
        for (int i = 0; i < listSubject.size(); i++) {
            if (listSubject.get(i).getId().equalsIgnoreCase(id)) {
                return listSubject.get(i);
            }
        }
        return null;
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String username = txtSubjectId.getText();
        if (subjectDao.delete(username)) {
            JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Delete Subject", JOptionPane.INFORMATION_MESSAGE, null);
            listSubject.remove(find(username));
            loadData(listSubject);
            if (listSubject.size() != 0) {
                loadDetails(listSubject.get(0));
            }
        } else {
            JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Delete Subject", JOptionPane.ERROR_MESSAGE, null);
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        if (isAdd) {
            isAdd = false;
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            txtCoureID.setVisible(true);
            cbxCourseID.setVisible(false);
        } else {
            loadDetails(listSubject.get(0));
        }
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            String subjectId = txtSubjectId.getText();
            String subjectName = txtName.getName();
            int coefficient = Integer.parseInt(txtCoefficient.getText());
            String courseName = cbxCourse.getSelectedItem().toString();
            String id = findByName(courseName).getId();
            Subject subject = new Subject(subjectId, subjectName, coefficient, id);
            if (subjectDao.update(subject)) {
                JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Update Subject", JOptionPane.INFORMATION_MESSAGE);
                listSubject.add(subject);
                loadData(listSubject);
                loadDetails(subject);
            } else {
                JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Update Subject", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        if (listSubject.size() != 0) {
            String text = filterText.getText();
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
    }//GEN-LAST:event_btnFilterActionPerformed

    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int index = tableContent.getSelectedRow();

            if (index != -1) {
                String value = tableContent.getValueAt(index, 0).toString();
                Subject subject = findSubject(value);
                if (subject != null) {
                    loadDetails(subject);
                }
            }
        } catch (Exception ex) {
            //TODO: chua xu ly
        }
    }//GEN-LAST:event_tableContentMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmSubject().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbxCourse;
    private javax.swing.JComboBox cbxCourseID;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel lblBanner;
    private javax.swing.JLabel lblCoefficient;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblNameSub;
    private javax.swing.JLabel lblSubjectID;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JSeparator sepa1;
    private javax.swing.JScrollPane srcPanelSubject;
    private javax.swing.JTable tableContent;
    private javax.swing.JTextField txtCoefficient;
    private javax.swing.JTextField txtCoureID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSubjectId;
    // End of variables declaration//GEN-END:variables
}