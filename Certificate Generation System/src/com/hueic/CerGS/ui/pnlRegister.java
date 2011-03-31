/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pnlRegister.java
 *
 * Created on Mar 31, 2011, 5:00:33 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.dao.SubjectDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Register;
import com.hueic.CerGS.entity.Student;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author nhchung
 */
public class pnlRegister extends javax.swing.JPanel {

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
    private ObjectTableModel tableModel;
    private JTable headerTable;
    frmMain frm;

    /** Creates new form pnlRegister */
    public pnlRegister() {
        initComponents();
        regisDAO = new RegisterDAO();
        courseDAO = new CourseDAO();
        studentDAO = new StudentDAO();
        subjectDAO = new SubjectDAO();
        regisList = regisDAO.readByAll();
        studentList = studentDAO.readByAll();
        courseIdList = courseDAO.readByAll();
        if (regisList.size() != 0) {
            loadCourse();
            loadData(regisList);
            loadDetails(regisList.get(0));
        }
    }

    public pnlRegister(frmMain frm) {
        initComponents();
        this.frm = frm;
        regisDAO = new RegisterDAO();
        courseDAO = new CourseDAO();
        studentDAO = new StudentDAO();
        subjectDAO = new SubjectDAO();
        regisList = regisDAO.readByAll();
        studentList = studentDAO.readByAll();
        courseIdList = courseDAO.readByAll();
        if (regisList.size() != 0) {
            loadCourse();
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

    public void loadData(ArrayList<Register> regisList) {

        ColumnData[] columns = {
            new ColumnData("Student ID", 135, SwingConstants.LEFT, 5),
            new ColumnData("ID", 100, SwingConstants.LEFT, 1),
            new ColumnData("Course ID", 140, SwingConstants.LEFT, 2),
            new ColumnData("Fees Structe", 170, SwingConstants.LEFT, 3),
            new ColumnData("Registration Date", 260, SwingConstants.LEFT, 4)
        };
        tableModel = new ObjectTableModel(tableContent, columns, regisList);
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContentMouseClicked(evt);
            }
        });
        sorter = new TableRowSorter<TableModel>(tableModel);
        tableContent.setRowSorter(sorter);
        headerTable = tableModel.getHeaderTable();
        // Create numbering column
        headerTable.createDefaultColumnsFromModel();
        tableContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Put it in a viewport that we can control a bit
        JViewport viewport = new JViewport();
        // Display numbering column
        viewport.setView(headerTable);
        viewport.setPreferredSize(headerTable.getMaximumSize());
        srcPanelRegister.setRowHeader(viewport);
        srcPanelRegister.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    public void loadDetails(Register register) {
        txtId.setText(register.getStudentId());
        txtFeesStructe.setText(String.valueOf(register.getFeesStructe()));
        DateChRegistrationDate.setDate(register.getRegisDate());
        txtCourseID.setText(register.getCourseId());
        txtStudentId.setText(register.getId());
    }

    public Register findByStudentId(String studentId) {
        for (int i = 0; i < regisList.size(); i++) {
            if (regisList.get(i).getStudentId().equals(studentId)) {
                return regisList.get(i);
            }
        }
        return null;
    }

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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tpRegister = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        panelRight = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        sepa1 = new javax.swing.JSeparator();
        lblID = new javax.swing.JLabel();
        lblCourseID = new javax.swing.JLabel();
        lblFeesStructe = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        lblRegistrationDate = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtFeesStructe = new javax.swing.JTextField();
        DateChRegistrationDate = new com.toedter.calendar.JDateChooser();
        panelButon = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtCourseID = new javax.swing.JTextField();
        txtStudentId = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnlSearch = new javax.swing.JPanel();
        panelRight1 = new javax.swing.JPanel();
        lblTitle1 = new javax.swing.JLabel();
        sepa2 = new javax.swing.JSeparator();
        lblID1 = new javax.swing.JLabel();
        lblCourseID1 = new javax.swing.JLabel();
        lblFeesStructe1 = new javax.swing.JLabel();
        lblStudentID1 = new javax.swing.JLabel();
        lblRegistrationDate1 = new javax.swing.JLabel();
        txtId1 = new javax.swing.JTextField();
        txtFeesStructe1 = new javax.swing.JTextField();
        DateChRegistrationDate1 = new com.toedter.calendar.JDateChooser();
        panelButon1 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        txtCourseID1 = new javax.swing.JTextField();
        txtStudentId1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelLeft = new javax.swing.JPanel();
        lblChooseCourse = new javax.swing.JLabel();
        lblEnterNameStudent = new javax.swing.JLabel();
        cbxCourseChoose = new javax.swing.JComboBox();
        filterText = new javax.swing.JTextField();
        srcPanelRegister = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        btnFilter = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        tpRegister.setMinimumSize(new java.awt.Dimension(800, 240));
        tpRegister.setPreferredSize(new java.awt.Dimension(800, 240));

        pnlEdit.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlEdit.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlEdit.setLayout(new java.awt.GridBagLayout());

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setMinimumSize(new java.awt.Dimension(800, 200));
        panelRight.setPreferredSize(new java.awt.Dimension(800, 200));
        panelRight.setRequestFocusEnabled(false);
        panelRight.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Register Students");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(lblTitle, gridBagConstraints);

        sepa1.setPreferredSize(new java.awt.Dimension(700, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
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
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelRight.add(lblStudentID, gridBagConstraints);

        lblRegistrationDate.setForeground(new java.awt.Color(3, 3, 3));
        lblRegistrationDate.setText("Registration Date:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelRight.add(lblRegistrationDate, gridBagConstraints);

        txtId.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtId, gridBagConstraints);

        txtFeesStructe.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtFeesStructe, gridBagConstraints);

        DateChRegistrationDate.setDateFormatString("MM/dd/yyyy");
        DateChRegistrationDate.setMaximumSize(new java.awt.Dimension(200, 20));
        DateChRegistrationDate.setMinimumSize(new java.awt.Dimension(200, 20));
        DateChRegistrationDate.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(DateChRegistrationDate, gridBagConstraints);

        panelButon.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnAdd.setMaximumSize(new java.awt.Dimension(75, 23));
        btnAdd.setMinimumSize(new java.awt.Dimension(75, 23));
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
        btnUpdate.setMaximumSize(new java.awt.Dimension(80, 23));
        btnUpdate.setMinimumSize(new java.awt.Dimension(75, 23));
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
        btnDelete.setMaximumSize(new java.awt.Dimension(75, 23));
        btnDelete.setMinimumSize(new java.awt.Dimension(75, 23));
        btnDelete.setPreferredSize(new java.awt.Dimension(75, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panelButon.add(btnDelete);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel.setMaximumSize(new java.awt.Dimension(75, 23));
        btnCancel.setMinimumSize(new java.awt.Dimension(75, 23));
        btnCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        panelButon.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(panelButon, gridBagConstraints);

        txtCourseID.setMinimumSize(new java.awt.Dimension(200, 20));
        txtCourseID.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtCourseID, gridBagConstraints);

        txtStudentId.setMinimumSize(new java.awt.Dimension(180, 20));
        txtStudentId.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtStudentId, gridBagConstraints);

        jButton3.setText("jButton3");
        jButton3.setMaximumSize(new java.awt.Dimension(23, 23));
        jButton3.setMinimumSize(new java.awt.Dimension(23, 23));
        jButton3.setPreferredSize(new java.awt.Dimension(23, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        panelRight.add(jButton3, gridBagConstraints);

        jButton4.setText("jButton4");
        jButton4.setMaximumSize(new java.awt.Dimension(23, 23));
        jButton4.setMinimumSize(new java.awt.Dimension(23, 23));
        jButton4.setPreferredSize(new java.awt.Dimension(23, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        panelRight.add(jButton4, gridBagConstraints);

        pnlEdit.add(panelRight, new java.awt.GridBagConstraints());

        tpRegister.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlSearch.setLayout(new java.awt.GridBagLayout());

        panelRight1.setBackground(new java.awt.Color(255, 255, 255));
        panelRight1.setMinimumSize(new java.awt.Dimension(800, 200));
        panelRight1.setPreferredSize(new java.awt.Dimension(800, 200));
        panelRight1.setRequestFocusEnabled(false);
        panelRight1.setLayout(new java.awt.GridBagLayout());

        lblTitle1.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle1.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle1.setText("Register Students");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight1.add(lblTitle1, gridBagConstraints);

        sepa2.setPreferredSize(new java.awt.Dimension(300, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panelRight1.add(sepa2, gridBagConstraints);

        lblID1.setForeground(new java.awt.Color(3, 3, 3));
        lblID1.setText("Student Coures ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(lblID1, gridBagConstraints);

        lblCourseID1.setForeground(new java.awt.Color(3, 3, 3));
        lblCourseID1.setText("Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(lblCourseID1, gridBagConstraints);

        lblFeesStructe1.setForeground(new java.awt.Color(3, 3, 3));
        lblFeesStructe1.setText("Fees Structe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(lblFeesStructe1, gridBagConstraints);

        lblStudentID1.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentID1.setText("Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(lblStudentID1, gridBagConstraints);

        lblRegistrationDate1.setForeground(new java.awt.Color(3, 3, 3));
        lblRegistrationDate1.setText("Registration Date:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 5);
        panelRight1.add(lblRegistrationDate1, gridBagConstraints);

        txtId1.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(txtId1, gridBagConstraints);

        txtFeesStructe1.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(txtFeesStructe1, gridBagConstraints);

        DateChRegistrationDate1.setDateFormatString("MM/dd/yyyy");
        DateChRegistrationDate1.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 5);
        panelRight1.add(DateChRegistrationDate1, gridBagConstraints);

        panelButon1.setBackground(new java.awt.Color(255, 255, 255));
        panelButon1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReset.setPreferredSize(new java.awt.Dimension(75, 23));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        panelButon1.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelRight1.add(panelButon1, gridBagConstraints);

        txtCourseID1.setMinimumSize(new java.awt.Dimension(180, 20));
        txtCourseID1.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(txtCourseID1, gridBagConstraints);

        txtStudentId1.setMinimumSize(new java.awt.Dimension(180, 20));
        txtStudentId1.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(txtStudentId1, gridBagConstraints);

        jButton1.setText("jButton1");
        jButton1.setMaximumSize(new java.awt.Dimension(23, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(23, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(23, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        panelRight1.add(jButton1, gridBagConstraints);

        jButton2.setText("jButton2");
        jButton2.setMaximumSize(new java.awt.Dimension(23, 23));
        jButton2.setMinimumSize(new java.awt.Dimension(23, 23));
        jButton2.setPreferredSize(new java.awt.Dimension(23, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        panelRight1.add(jButton2, gridBagConstraints);

        pnlSearch.add(panelRight1, new java.awt.GridBagConstraints());

        tpRegister.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpRegister, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Register", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelLeft.setMinimumSize(new java.awt.Dimension(800, 370));
        panelLeft.setPreferredSize(new java.awt.Dimension(800, 370));
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

        srcPanelRegister.setAutoscrolls(true);
        srcPanelRegister.setMinimumSize(new java.awt.Dimension(750, 250));
        srcPanelRegister.setPreferredSize(new java.awt.Dimension(750, 250));

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
        tableContent.setDragEnabled(true);
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
        btnFilter.setMinimumSize(new java.awt.Dimension(75, 23));
        btnFilter.setPreferredSize(new java.awt.Dimension(75, 23));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(btnFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelLeft, gridBagConstraints);
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

    private void filterTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTextKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            searchStart();
        }
}//GEN-LAST:event_filterTextKeyPressed

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

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        searchStart();
}//GEN-LAST:event_btnFilterActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            if (!isAdd) {
                isAdd = true;
                txtCourseID.setVisible(false);
                txtStudentId.setVisible(false);
                txtId.setText(null);
                txtFeesStructe.setText(null);
            } else {
                String Id = txtStudentId.toString();
                String studentId = txtId.getText();
                int feesStructe = Integer.parseInt(txtFeesStructe.getText());
                Date regDate = new java.sql.Date(DateChRegistrationDate.getDate().getTime());
                String courseId = txtCourseID.getText();
                Register register = new Register(Id, courseId, feesStructe, (java.sql.Date) regDate, studentId);
                if (regisDAO.create(register)) {
                    JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Create Register", JOptionPane.INFORMATION_MESSAGE);
                    regisList.add(register);
                    loadData(regisList);
                    loadDetails(register);
                    isAdd = false;
                    txtCourseID.setVisible(true);
                    txtStudentId.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Create Register", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Create Register", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        //TODO: chua xu ly viec cap nhap khoa se bi anh huong den cac bang khac
        try {
            if (!isUpdate) {
                txtCourseID.setVisible(false);
                txtStudentId.setVisible(false);
                isUpdate = true;
                studentIdtemp = txtId.getText();
            } else {
                isUpdate = false;
                String Id = txtStudentId.toString();
                String studentId = txtId.getText();
                int feesStructe = Integer.parseInt(txtFeesStructe.getText());
                Date regDate = new java.sql.Date(DateChRegistrationDate.getDate().getTime());
                String courseId = txtCourseID.getText();
                Register register = new Register(Id, courseId, feesStructe, (java.sql.Date) regDate, studentId);
                if (regisDAO.update(register)) {
                    JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Update Subject", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(studentIdtemp);
                    regisList.remove(findByStudentId(studentIdtemp));
                    regisList.add(register);
                    loadData(regisList);
                    loadDetails(register);
                    txtCourseID.setVisible(true);
                    txtStudentId.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Update Subject", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
}//GEN-LAST:event_btnUpdateActionPerformed

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

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        if (isAdd) {
            isAdd = false;
            txtCourseID.setVisible(true);
            txtStudentId.setVisible(true);
        } else if (isUpdate) {
            isUpdate = false;
            txtCourseID.setVisible(true);
            txtStudentId.setVisible(true);
            loadDetails(findByStudentId(txtId.getText()));
        } else {
            loadDetails(regisList.get(0));
        }
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtCourseID, true, 7);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        dlgChoose dlg = new dlgChoose(frm, txtStudentId, true, 13);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtCourseID1, true, 7);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtStudentId1, true, 13);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChRegistrationDate;
    private com.toedter.calendar.JDateChooser DateChRegistrationDate1;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbxCourseChoose;
    private javax.swing.JTextField filterText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel lblChooseCourse;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblCourseID1;
    private javax.swing.JLabel lblEnterNameStudent;
    private javax.swing.JLabel lblFeesStructe;
    private javax.swing.JLabel lblFeesStructe1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblID1;
    private javax.swing.JLabel lblRegistrationDate;
    private javax.swing.JLabel lblRegistrationDate1;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentID1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel panelButon;
    private javax.swing.JPanel panelButon1;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelRight1;
    public javax.swing.JPanel pnlEdit;
    public javax.swing.JPanel pnlSearch;
    private javax.swing.JSeparator sepa1;
    private javax.swing.JSeparator sepa2;
    private javax.swing.JScrollPane srcPanelRegister;
    private javax.swing.JTable tableContent;
    public javax.swing.JTabbedPane tpRegister;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtCourseID1;
    private javax.swing.JTextField txtFeesStructe;
    private javax.swing.JTextField txtFeesStructe1;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtId1;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtStudentId1;
    // End of variables declaration//GEN-END:variables

    int getSelectedCode() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
