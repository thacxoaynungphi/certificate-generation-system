/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MarkFrm.java
 *
 * Created on Mar 25, 2011, 12:04:09 AM
 */
package com.hueic.CerGS.ui.main.register;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.dao.SubjectDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Register;
import com.hueic.CerGS.entity.Student;
import java.sql.Date;
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
public class frmRegister extends javax.swing.JFrame {

    private ArrayList<Register> regisList;
    ArrayList<Student> studentList;
    ArrayList<Course> courseIdList;
    private CourseDAO courseDAO;
    private RegisterDAO regisDAO;
    private StudentDAO studentDAO;
    private TableRowSorter<TableModel> sorter;
    private SubjectDAO subjectDAO;
    private boolean isUpdate = false;
    private boolean isAdd = false;
    String studentIdtemp = null;

    /** Creates new form MarkFrm */
    public frmRegister() {
        initComponents();
        setLocationRelativeTo(null);
        regisDAO = new RegisterDAO();
        courseDAO = new CourseDAO();
        studentDAO = new StudentDAO();
        subjectDAO = new SubjectDAO();
        regisList = regisDAO.readByAll();
        studentList = studentDAO.readByAll();
        courseIdList = courseDAO.readByAll();


        cbxStudentID.setVisible(false);
        cbxCourseID.setVisible(false);
        if (regisList.size() != 0) {
            loadCourse();
            loadCourseID();
            loadStudentId();
            loadData(regisList);
            loadDetails(regisList.get(0));
        }
    }

    public void loadCourse() {
        if (courseIdList.size() != 0) {
            cbxCourseChoose.removeAllItems();
            cbxCourseChoose.addItem("All");
            for (Course course : courseIdList) {
                cbxCourseChoose.addItem(course.getId());
            }
        }
    }

    public void loadCourseID() {
        if (courseIdList.size() != 0) {
            cbxCourseID.removeAllItems();
            for (Course course : courseIdList) {
                cbxCourseID.addItem(course.getId());
            }
        }
    }

    public void loadStudentId() {
        if (studentList.size() != 0) {
            cbxStudentID.removeAllItems();
            for (Student student : studentList) {
                cbxStudentID.addItem(student.getId());
            }
        }
    }

    public void loadData(ArrayList<Register> regisList) {
        String[] columns = {"StudentId", "Id", "CourseId", "FeesStructe", "Registration Date"};
        Object[][] rows = new Object[regisList.size()][5];
        int index = 0;
        for (int i = 0; i < regisList.size(); i++) {
            Register regis = regisList.get(i);

            rows[index][1] = regis.getId();
            rows[index][0] = regis.getStudentId();
            rows[index][2] = regis.getCourseId();
            rows[index][3] = regis.getFeesStructe();
            rows[index][4] = regis.getRegisDate();
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
        srcPanelRegister.setRowHeader(viewPort);
        srcPanelRegister.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, tableContent.getTableHeader());
    }

    public void loadDetails(Register register) {
        txtId.setText(register.getStudentId());
        txtFeesStructe.setText(String.valueOf(register.getFeesStructe()));
        DateChRegistrationDate.setDate(register.getRegisDate());
        txtCourseID.setText(register.getCourseId());
        txtStudentId.setText(register.getStudentId());
        for (int i = 0; i < cbxCourseID.getItemCount(); i++) {
            if (cbxCourseID.getItemAt(i).toString().equals(register.getCourseId())) {
                cbxCourseID.setSelectedIndex(i);

            }
        }

        for (int i = 0; i < cbxStudentID.getItemCount(); i++) {
            if (cbxStudentID.getItemAt(i).toString().equals(register.getId())) {
                cbxStudentID.setSelectedIndex(i);

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
        panelLeft = new javax.swing.JPanel();
        lblChooseCourse = new javax.swing.JLabel();
        lblEnterNameStudent = new javax.swing.JLabel();
        cbxCourseChoose = new javax.swing.JComboBox();
        filterText = new javax.swing.JTextField();
        srcPanelRegister = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        btnFilter = new javax.swing.JButton();
        panelRight = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        sepa1 = new javax.swing.JSeparator();
        lblID = new javax.swing.JLabel();
        lblCourseID = new javax.swing.JLabel();
        lblFeesStructe = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        lblRegistrationDate = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        cbxCourseID = new javax.swing.JComboBox();
        txtFeesStructe = new javax.swing.JTextField();
        cbxStudentID = new javax.swing.JComboBox();
        DateChRegistrationDate = new com.toedter.calendar.JDateChooser();
        panelButon = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtCourseID = new javax.swing.JTextField();
        txtStudentId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Management Mark");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Register.png"))); // NOI18N

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo)
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelLogo, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Register", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelLeft.setMinimumSize(new java.awt.Dimension(450, 320));
        panelLeft.setPreferredSize(new java.awt.Dimension(450, 320));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        lblChooseCourse.setForeground(new java.awt.Color(3, 3, 3));
        lblChooseCourse.setText("Choose course:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(lblChooseCourse, gridBagConstraints);

        lblEnterNameStudent.setForeground(new java.awt.Color(3, 3, 3));
        lblEnterNameStudent.setText("Enter Filter:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(lblEnterNameStudent, gridBagConstraints);

        cbxCourseChoose.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCourseChoose.setPreferredSize(new java.awt.Dimension(150, 20));
        cbxCourseChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCourseChooseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(cbxCourseChoose, gridBagConstraints);

        filterText.setPreferredSize(new java.awt.Dimension(150, 20));
        filterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filterTextKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(filterText, gridBagConstraints);

        srcPanelRegister.setPreferredSize(new java.awt.Dimension(400, 200));

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
        srcPanelRegister.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelLeft.add(srcPanelRegister, gridBagConstraints);

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
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        panelLeft.add(btnFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(panelLeft, gridBagConstraints);

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Management Register", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelRight.setMinimumSize(new java.awt.Dimension(380, 320));
        panelRight.setPreferredSize(new java.awt.Dimension(380, 320));
        panelRight.setRequestFocusEnabled(false);
        panelRight.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Register Students");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelRight.add(lblTitle, gridBagConstraints);

        sepa1.setPreferredSize(new java.awt.Dimension(300, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panelRight.add(sepa1, gridBagConstraints);

        lblID.setForeground(new java.awt.Color(3, 3, 3));
        lblID.setText("Student Coures ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblID, gridBagConstraints);

        lblCourseID.setForeground(new java.awt.Color(3, 3, 3));
        lblCourseID.setText("Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblCourseID, gridBagConstraints);

        lblFeesStructe.setForeground(new java.awt.Color(3, 3, 3));
        lblFeesStructe.setText("Fees Structe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblFeesStructe, gridBagConstraints);

        lblStudentID.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentID.setText("Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblStudentID, gridBagConstraints);

        lblRegistrationDate.setForeground(new java.awt.Color(3, 3, 3));
        lblRegistrationDate.setText("Registration Date:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 5);
        panelRight.add(lblRegistrationDate, gridBagConstraints);

        txtId.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtId, gridBagConstraints);

        cbxCourseID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCourseID.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(cbxCourseID, gridBagConstraints);

        txtFeesStructe.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtFeesStructe, gridBagConstraints);

        cbxStudentID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxStudentID.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(cbxStudentID, gridBagConstraints);

        DateChRegistrationDate.setDateFormatString("MM/dd/yyyy");
        DateChRegistrationDate.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 5);
        panelRight.add(DateChRegistrationDate, gridBagConstraints);

        panelButon.setBackground(new java.awt.Color(255, 255, 255));
        panelButon.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnAdd.setPreferredSize(new java.awt.Dimension(75, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        panelButon.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnUpdate.setPreferredSize(new java.awt.Dimension(75, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panelButon.add(btnUpdate);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panelButon.add(btnDelete);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        panelButon.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(panelButon, gridBagConstraints);

        txtCourseID.setMinimumSize(new java.awt.Dimension(180, 20));
        txtCourseID.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtCourseID, gridBagConstraints);

        txtStudentId.setMinimumSize(new java.awt.Dimension(180, 20));
        txtStudentId.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtStudentId, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        getContentPane().add(panelRight, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCourseChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCourseChooseActionPerformed
        // TODO add your handling code here:
        if (cbxCourseChoose.getItemCount() - 1 == courseIdList.size()) {
            String courseId = cbxCourseChoose.getSelectedItem().toString();
            regisList.clear();
            if (courseId.equals("All")) {
                regisList = regisDAO.readByAll();
            } else {
                regisList.addAll(regisDAO.readByCourseId(courseId));
            }


            loadData(regisList);
        }
    }//GEN-LAST:event_cbxCourseChooseActionPerformed

    private void cbxStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxStudentIDActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            if (!isAdd) {
                isAdd = true;
                cbxCourseID.setVisible(true);
                txtCourseID.setVisible(false);
                txtStudentId.setVisible(false);
                cbxStudentID.setVisible(true);
                txtId.setText(null);
                txtFeesStructe.setText(null);
            } else {
                String Id = cbxStudentID.getSelectedItem().toString();
                String studentId = txtId.getText();
                int feesStructe = Integer.parseInt(txtFeesStructe.getText());
                Date regDate = new java.sql.Date(DateChRegistrationDate.getDate().getTime());
                String courseId = cbxCourseID.getSelectedItem().toString();
                Register register = new Register(Id, courseId, feesStructe, regDate, studentId);
                if (regisDAO.create(register)) {
                    JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Create Register", JOptionPane.INFORMATION_MESSAGE);
                    regisList.add(register);
                    loadData(regisList);
                    loadDetails(register);
                    isAdd = false;
                    cbxCourseID.setVisible(false);
                    txtCourseID.setVisible(true);
                    txtStudentId.setVisible(true);
                    cbxStudentID.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Create Register", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Create Register", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtId.setText("");
        txtFeesStructe.setText("");
        cbxCourseID.setSelectedIndex(-1);
        cbxStudentID.setSelectedIndex(-1);
        DateChRegistrationDate.setDate(null);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        if (isAdd) {
            isAdd = false;
            cbxCourseID.setVisible(false);
            txtCourseID.setVisible(true);
            txtStudentId.setVisible(true);
            cbxStudentID.setVisible(false);
        } else if (isUpdate) {
            isUpdate = false;
            cbxCourseID.setVisible(false);
            txtCourseID.setVisible(true);
            txtStudentId.setVisible(true);
            cbxStudentID.setVisible(false);
            loadDetails(findByStudentId(txtId.getText()));
        } else {
            loadDetails(regisList.get(0));
        }
    }//GEN-LAST:event_btnCancelActionPerformed

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

    public Register findByStudentId(String studentId) {
        for (int i = 0; i < regisList.size(); i++) {
            if (regisList.get(i).getStudentId().equals(studentId)) {
                return regisList.get(i);
            }
        }
        return null;
    }
    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        // TODO add your handling code here:
        if (regisList.size() != 0) {
            int index = tableContent.getSelectedRow();
            if (index != -1) {
                String studentId = tableContent.getValueAt(index, 0).toString();
                Register reg = findByStudentId(studentId);
                if (reg != null) {
                    loadDetails(reg);
                }
            }
        }
    }//GEN-LAST:event_tableContentMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String studentid = txtId.getText();
        if (regisDAO.delete(studentid)) {
            regisList.remove(findByStudentId(studentid));
            loadData(regisList);
            if (regisList.size() != 0) {
                loadDetails(regisList.get(0));
            }
            JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Delete Register", JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Delete Register", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        //TODO: chua xu ly viec cap nhap khoa se bi anh huong den cac bang khac
        try {
            if (!isUpdate) {
                cbxCourseID.setVisible(true);
                txtCourseID.setVisible(false);
                txtStudentId.setVisible(false);
                cbxStudentID.setVisible(true);
                isUpdate = true;
                studentIdtemp = txtId.getText();
            } else {
                isUpdate = false;
                String Id = cbxStudentID.getSelectedItem().toString();
                String studentId = txtId.getText();
                int feesStructe = Integer.parseInt(txtFeesStructe.getText());
                Date regDate = new java.sql.Date(DateChRegistrationDate.getDate().getTime());
                String courseId = cbxCourseID.getSelectedItem().toString();
                Register register = new Register(Id, courseId, feesStructe, regDate, studentId);
                if (regisDAO.update(register)) {
                    JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Update Subject", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(studentIdtemp);
                    regisList.remove(findByStudentId(studentIdtemp));
                    regisList.add(register);
                    loadData(regisList);
                    loadDetails(register);
                    cbxCourseID.setVisible(false);
                    txtCourseID.setVisible(true);
                    txtStudentId.setVisible(true);
                    cbxStudentID.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Update Subject", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    public void searchStart() {
        if (regisList.size() != 0) {
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
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmRegister().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChRegistrationDate;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbxCourseChoose;
    private javax.swing.JComboBox cbxCourseID;
    private javax.swing.JComboBox cbxStudentID;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel lblChooseCourse;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblEnterNameStudent;
    private javax.swing.JLabel lblFeesStructe;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRegistrationDate;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelButon;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JPanel panelRight;
    private javax.swing.JSeparator sepa1;
    private javax.swing.JScrollPane srcPanelRegister;
    private javax.swing.JTable tableContent;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtFeesStructe;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtStudentId;
    // End of variables declaration//GEN-END:variables
}
