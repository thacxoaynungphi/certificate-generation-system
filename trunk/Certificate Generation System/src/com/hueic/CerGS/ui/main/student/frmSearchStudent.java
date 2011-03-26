/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmSearchStudent.java
 *
 * Created on Mar 26, 2011, 1:45:05 PM
 */
package com.hueic.CerGS.ui.main.student;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Register;
import com.hueic.CerGS.entity.Student;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author nhchung
 */
public class frmSearchStudent extends javax.swing.JFrame {

    private CourseDAO courseDAO;
    private StudentDAO studentDAO;
    private RegisterDAO registerDAO;
    private ArrayList<Register> listRegister;
    private TableRowSorter<TableModel> sorter;
    private ArrayList<Student> listStudent;

    /** Creates new form frmSearchStudent */
    public frmSearchStudent() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void loadCourseId() {
        cbxCourse.removeAllItems();
        ArrayList<Course> lisrCourse = courseDAO.readByAll();

        for (Course course : lisrCourse) {
            cbxCourse.addItem(course.getId());
        }
    }

    public void loadStudentId(ArrayList<Register> listRegis) {
        cbxStudent.removeAllItems();
        for (Register regis : listRegis) {
            cbxStudent.addItem(regis.getStudentId());
        }
    }

    public void loadData(ArrayList<Register> listRegis) {
        String[] column = {"Student Id", "Student Name", "Birthday", "Gender", "Course Name", "Phone", "Email", "Address"};
        Object[][] rows = new Object[listRegis.size()][8];

        int index = 0;
        for (int i = 0; i < listRegis.size(); i++) {
            String studentId = listRegis.get(i).getId();
            Student studentInfo = studentDAO.readByID(studentId);

            rows[index][0] = listRegis.get(i).getId();
            rows[index][1] = studentInfo.getFullName();
            rows[index][2] = studentInfo.getBirthDay();
            rows[index][3] = studentInfo.getGender();
            rows[index][4] = courseDAO.readById(listRegis.get(i).getCourseId()).getName();
            rows[index][5] = studentInfo.getPhone();
            rows[index][6] = studentInfo.getEmail();
            rows[index][7] = studentInfo.getAddress();

        }

        TableModel model = new DefaultTableModel(rows, column) {

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
                false, false, false, false, false, false, false, false
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
        srcPanelAccount.setRowHeader(viewPort);
        srcPanelAccount.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, tableContent.getTableHeader());

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
        jHelp1 = new javax.help.JHelp();
        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        panelInfo = new javax.swing.JPanel();
        lblCourse = new javax.swing.JLabel();
        cbxCourse = new javax.swing.JComboBox();
        cbxStudent = new javax.swing.JComboBox();
        lblStudentId = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblBirthday = new javax.swing.JLabel();
        dateChooserDateStart = new com.toedter.calendar.JDateChooser();
        dateChooserDateEnd = new com.toedter.calendar.JDateChooser();
        lblGender = new javax.swing.JLabel();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        lblTitle = new javax.swing.JLabel();
        sepaCourse = new javax.swing.JSeparator();
        btnSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        srcPanelAccount = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/SearchStudent.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(lblLogo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        panelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Student", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelInfo.setMinimumSize(new java.awt.Dimension(250, 435));
        panelInfo.setPreferredSize(new java.awt.Dimension(250, 435));
        panelInfo.setLayout(new java.awt.GridBagLayout());

        lblCourse.setText("Course ID: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblCourse, gridBagConstraints);

        cbxCourse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCourse.setMinimumSize(new java.awt.Dimension(150, 20));
        cbxCourse.setOpaque(false);
        cbxCourse.setPreferredSize(new java.awt.Dimension(150, 20));
        cbxCourse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCourseItemStateChanged(evt);
            }
        });
        cbxCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCourseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(cbxCourse, gridBagConstraints);

        cbxStudent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxStudent.setMinimumSize(new java.awt.Dimension(150, 20));
        cbxStudent.setPreferredSize(new java.awt.Dimension(150, 20));
        cbxStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxStudentActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(cbxStudent, gridBagConstraints);

        lblStudentId.setText("Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblStudentId, gridBagConstraints);

        lblFirstName.setText("First Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblFirstName, gridBagConstraints);

        txtFirstName.setMinimumSize(new java.awt.Dimension(150, 20));
        txtFirstName.setPreferredSize(new java.awt.Dimension(150, 20));
        txtFirstName.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(txtFirstName, gridBagConstraints);

        lblLastName.setText("Last Name: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblLastName, gridBagConstraints);

        txtLastName.setMinimumSize(new java.awt.Dimension(150, 20));
        txtLastName.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(txtLastName, gridBagConstraints);

        lblBirthday.setText("Birthday: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblBirthday, gridBagConstraints);

        dateChooserDateStart.setMinimumSize(new java.awt.Dimension(150, 20));
        dateChooserDateStart.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(dateChooserDateStart, gridBagConstraints);

        dateChooserDateEnd.setMinimumSize(new java.awt.Dimension(150, 20));
        dateChooserDateEnd.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(dateChooserDateEnd, gridBagConstraints);

        lblGender.setText("Gender:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblGender, gridBagConstraints);

        buttonGroupGender.add(radioMale);
        radioMale.setText("Male");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(radioMale, gridBagConstraints);

        buttonGroupGender.add(radioFemale);
        radioFemale.setText("FeMale");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(radioFemale, gridBagConstraints);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Info Course");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblTitle, gridBagConstraints);

        sepaCourse.setMinimumSize(new java.awt.Dimension(150, 10));
        sepaCourse.setPreferredSize(new java.awt.Dimension(150, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(sepaCourse, gridBagConstraints);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 34, 0, 5);
        panelInfo.add(btnSearch, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelInfo, gridBagConstraints);

        jPanel3.setMinimumSize(new java.awt.Dimension(840, 430));
        jPanel3.setPreferredSize(new java.awt.Dimension(840, 430));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        srcPanelAccount.setMinimumSize(new java.awt.Dimension(830, 380));
        srcPanelAccount.setPreferredSize(new java.awt.Dimension(830, 380));

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
        srcPanelAccount.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(srcPanelAccount, gridBagConstraints);

        btnClose.setText("Close");
        btnClose.setMaximumSize(new java.awt.Dimension(90, 23));
        btnClose.setMinimumSize(new java.awt.Dimension(90, 23));
        btnClose.setPreferredSize(new java.awt.Dimension(90, 23));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(btnClose, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCourseActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbxCourseActionPerformed

    private void cbxStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxStudentActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbxStudentActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        Date startDate = dateChooserDateStart.getDate();
        Date endDate = dateChooserDateEnd.getDate();
        int gender = 0;
        if (radioFemale.isSelected()) {
            gender = 0;
        }

        listRegister.clear();
        listStudent = studentDAO.readByCommand(firstName, lastName, startDate, endDate, gender);

        if (!listStudent.isEmpty()) {
            for (Student student : listStudent) {
                ArrayList<Register> listregis = registerDAO.readByStudentIdOfPerson(student.getId());
                listRegister.addAll(listregis);
            }
        }

        loadData(listRegister);

    }//GEN-LAST:event_btnSearchActionPerformed

    private void cbxCourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCourseItemStateChanged
        // TODO add your handling code here:
        String courseId = (String) cbxCourse.getSelectedItem();
        listRegister.clear();
        listRegister.addAll(registerDAO.readByCourseId(courseId));

        loadData(listRegister);
        loadStudentId(listRegister);
    }//GEN-LAST:event_cbxCourseItemStateChanged

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmSearchStudent().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.JComboBox cbxCourse;
    private javax.swing.JComboBox cbxStudent;
    private com.toedter.calendar.JDateChooser dateChooserDateEnd;
    private com.toedter.calendar.JDateChooser dateChooserDateStart;
    private javax.help.JHelp jHelp1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblStudentId;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JSeparator sepaCourse;
    private javax.swing.JScrollPane srcPanelAccount;
    private javax.swing.JTable tableContent;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables
}
