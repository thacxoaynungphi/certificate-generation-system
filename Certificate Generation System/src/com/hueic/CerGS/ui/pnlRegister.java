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
    ArrayList<Register> filter = null;

    /** Creates new form pnlRegister */
    public pnlRegister() {
        initComponents();
        txtId.setRequestFocusEnabled(false);
        regisDAO = new RegisterDAO();
        courseDAO = new CourseDAO();
        studentDAO = new StudentDAO();
        subjectDAO = new SubjectDAO();
        regisList = regisDAO.readByAll();
        studentList = studentDAO.readByAll();
        courseIdList = courseDAO.readByAll();
        btnCancelEdit.setVisible(false);
        if (!regisList.isEmpty()) {
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
            loadData(regisList);
            loadDetails(regisList.get(0));
        }
    }

    public void loadData(ArrayList<Register> regisList) {
        filter = new ArrayList<Register>();
        for (Register sub : regisList) {
            if (sub.getStudentId().toLowerCase().matches(".*" + txtIdSearch.getText().trim().toLowerCase() + ".*")
                    && sub.getId().toLowerCase().matches(".*" + txtStudentIdSearch.getText().trim().toLowerCase() + ".*")
                    && sub.getCourseId().toLowerCase().matches(".*" + txtCourseIDSearch.getText().trim().toLowerCase() + ".*") //&& String.valueOf(sub.getCoefficient()).toLowerCase().matches(".*" + txtCoefficientSearch.getText().trim().toLowerCase() + ".*")
                    //&& sub.getCourseID().toLowerCase().matches(".*" + txtCoureIDSearch.getText().trim().toLowerCase() + ".*")
                    //Chua xet ngay bat dau va ket thuc
                    ) {
                filter.add(sub);
            }
        }
        if (!filter.isEmpty()) {
            loadDetails(filter.get(0));
        }

        ColumnData[] columns = {
            new ColumnData("Student ID", 135, SwingConstants.LEFT, 5),
            new ColumnData("ID", 150, SwingConstants.LEFT, 1),
            new ColumnData("Course ID", 140, SwingConstants.LEFT, 2),
            new ColumnData("Fees Structe", 170, SwingConstants.LEFT, 3),
            new ColumnData("Registration Date", 100, SwingConstants.LEFT, 4)
        };
        tableModel = new ObjectTableModel(tableContent, columns, filter);
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

    public void resetDetails(){
        txtId.setText("");
        txtCourseID.setText("");
        txtStudentId.setText("");
        cbxFeeStructe.setSelectedIndex(0);
        dateChRegistrationDate.setDate(null);
    }
    public void loadDetails(Register register) {
        txtId.setText(register.getStudentId());
        cbxFeeStructe.setSelectedIndex(register.getFeesStructe());
        dateChRegistrationDate.setDate(register.getRegisDate());
        txtCourseID.setText(register.getCourseId());
        txtStudentId.setText(register.getId());
    }

    public int findByStudentId(String studentId) {
        for (int i = 0; i < regisList.size(); i++) {
            if (regisList.get(i).getStudentId().compareTo(studentId) == 0) {
                return i;
            }
        }
        return -1;
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
        cbxFeeStructe = new javax.swing.JComboBox();
        lblFeesStructe = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        lblRegistrationDate = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        dateChRegistrationDate = new com.toedter.calendar.JDateChooser();
        panelButon = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancelEdit = new javax.swing.JButton();
        txtCourseID = new javax.swing.JTextField();
        txtStudentId = new javax.swing.JTextField();
        btnChooseCourseId = new javax.swing.JButton();
        btnChooseStudentId = new javax.swing.JButton();
        pnlSearch = new javax.swing.JPanel();
        panelRight1Search = new javax.swing.JPanel();
        lblTitleSearch = new javax.swing.JLabel();
        sepa2Search = new javax.swing.JSeparator();
        lblIDSearch = new javax.swing.JLabel();
        lblCourseIDSearch = new javax.swing.JLabel();
        lblFeesStructeSearch = new javax.swing.JLabel();
        lblStudentIDSearch = new javax.swing.JLabel();
        lblRegistrationDateSearch = new javax.swing.JLabel();
        txtIdSearch = new javax.swing.JTextField();
        txtFeesStructeSearch = new javax.swing.JTextField();
        dateChRegistrationDateSearch = new com.toedter.calendar.JDateChooser();
        panelButonSearch = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        txtCourseIDSearch = new javax.swing.JTextField();
        txtStudentIdSearch = new javax.swing.JTextField();
        btnChooseCourseIDSearch = new javax.swing.JButton();
        btnChooseStudentIDSearch = new javax.swing.JButton();
        panelLeft = new javax.swing.JPanel();
        lblEnterNameStudent = new javax.swing.JLabel();
        filterText = new javax.swing.JTextField();
        srcPanelRegister = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        btnFilter = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnReport = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        tpRegister.setMinimumSize(new java.awt.Dimension(860, 240));
        tpRegister.setPreferredSize(new java.awt.Dimension(860, 240));

        pnlEdit.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlEdit.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlEdit.setLayout(new java.awt.GridBagLayout());

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setMinimumSize(new java.awt.Dimension(860, 200));
        panelRight.setPreferredSize(new java.awt.Dimension(860, 200));
        panelRight.setRequestFocusEnabled(false);
        panelRight.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Register Students");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(lblTitle, gridBagConstraints);

        sepa1.setMinimumSize(new java.awt.Dimension(780, 10));
        sepa1.setPreferredSize(new java.awt.Dimension(780, 10));
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

        cbxFeeStructe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Full Payment", "Installment Payment" }));
        cbxFeeStructe.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(cbxFeeStructe, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelRight.add(lblStudentID, gridBagConstraints);

        lblRegistrationDate.setForeground(new java.awt.Color(3, 3, 3));
        lblRegistrationDate.setText("Registration Date:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelRight.add(lblRegistrationDate, gridBagConstraints);

        txtId.setPreferredSize(new java.awt.Dimension(200, 20));
        txtId.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtIdCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtId, gridBagConstraints);

        dateChRegistrationDate.setDateFormatString("MM/dd/yyyy");
        dateChRegistrationDate.setMaximumSize(new java.awt.Dimension(200, 20));
        dateChRegistrationDate.setMinimumSize(new java.awt.Dimension(200, 20));
        dateChRegistrationDate.setPreferredSize(new java.awt.Dimension(200, 20));
        dateChRegistrationDate.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                dateChRegistrationDateCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(dateChRegistrationDate, gridBagConstraints);

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

        btnCancelEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancelEdit.setText("Cancel");
        btnCancelEdit.setPreferredSize(new java.awt.Dimension(85, 23));
        btnCancelEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEditActionPerformed(evt);
            }
        });
        panelButon.add(btnCancelEdit);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 5, 5);
        panelRight.add(panelButon, gridBagConstraints);

        txtCourseID.setMinimumSize(new java.awt.Dimension(200, 20));
        txtCourseID.setPreferredSize(new java.awt.Dimension(200, 20));
        txtCourseID.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCourseIDCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtCourseID, gridBagConstraints);

        txtStudentId.setMinimumSize(new java.awt.Dimension(180, 20));
        txtStudentId.setPreferredSize(new java.awt.Dimension(200, 20));
        txtStudentId.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtStudentIdCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtStudentId, gridBagConstraints);

        btnChooseCourseId.setText("jButton3");
        btnChooseCourseId.setMaximumSize(new java.awt.Dimension(23, 23));
        btnChooseCourseId.setMinimumSize(new java.awt.Dimension(23, 23));
        btnChooseCourseId.setPreferredSize(new java.awt.Dimension(23, 20));
        btnChooseCourseId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseCourseIdActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(btnChooseCourseId, gridBagConstraints);

        btnChooseStudentId.setText("jButton4");
        btnChooseStudentId.setMaximumSize(new java.awt.Dimension(23, 23));
        btnChooseStudentId.setMinimumSize(new java.awt.Dimension(23, 23));
        btnChooseStudentId.setPreferredSize(new java.awt.Dimension(23, 20));
        btnChooseStudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseStudentIdActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(btnChooseStudentId, gridBagConstraints);

        pnlEdit.add(panelRight, new java.awt.GridBagConstraints());

        tpRegister.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlSearch.setLayout(new java.awt.GridBagLayout());

        panelRight1Search.setBackground(new java.awt.Color(255, 255, 255));
        panelRight1Search.setMinimumSize(new java.awt.Dimension(860, 200));
        panelRight1Search.setPreferredSize(new java.awt.Dimension(860, 200));
        panelRight1Search.setRequestFocusEnabled(false);
        panelRight1Search.setLayout(new java.awt.GridBagLayout());

        lblTitleSearch.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitleSearch.setForeground(new java.awt.Color(102, 0, 102));
        lblTitleSearch.setText("Register Students");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight1Search.add(lblTitleSearch, gridBagConstraints);

        sepa2Search.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelRight1Search.add(sepa2Search, gridBagConstraints);

        lblIDSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblIDSearch.setText("Student Coures ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1Search.add(lblIDSearch, gridBagConstraints);

        lblCourseIDSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblCourseIDSearch.setText("Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1Search.add(lblCourseIDSearch, gridBagConstraints);

        lblFeesStructeSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblFeesStructeSearch.setText("Fees Structe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1Search.add(lblFeesStructeSearch, gridBagConstraints);

        lblStudentIDSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentIDSearch.setText("Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelRight1Search.add(lblStudentIDSearch, gridBagConstraints);

        lblRegistrationDateSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblRegistrationDateSearch.setText("Registration Date:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelRight1Search.add(lblRegistrationDateSearch, gridBagConstraints);

        txtIdSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtIdSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtIdSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1Search.add(txtIdSearch, gridBagConstraints);

        txtFeesStructeSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtFeesStructeSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFeesStructeSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1Search.add(txtFeesStructeSearch, gridBagConstraints);

        dateChRegistrationDateSearch.setDateFormatString("MM/dd/yyyy");
        dateChRegistrationDateSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        dateChRegistrationDateSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                dateChRegistrationDateSearchCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 5);
        panelRight1Search.add(dateChRegistrationDateSearch, gridBagConstraints);

        panelButonSearch.setBackground(new java.awt.Color(255, 255, 255));
        panelButonSearch.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReset.setPreferredSize(new java.awt.Dimension(75, 23));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        panelButonSearch.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 5, 5);
        panelRight1Search.add(panelButonSearch, gridBagConstraints);

        txtCourseIDSearch.setMinimumSize(new java.awt.Dimension(180, 20));
        txtCourseIDSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtCourseIDSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCourseIDSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1Search.add(txtCourseIDSearch, gridBagConstraints);

        txtStudentIdSearch.setMinimumSize(new java.awt.Dimension(180, 20));
        txtStudentIdSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtStudentIdSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtStudentIdSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1Search.add(txtStudentIdSearch, gridBagConstraints);

        btnChooseCourseIDSearch.setText("jButton1");
        btnChooseCourseIDSearch.setMaximumSize(new java.awt.Dimension(23, 23));
        btnChooseCourseIDSearch.setMinimumSize(new java.awt.Dimension(23, 23));
        btnChooseCourseIDSearch.setPreferredSize(new java.awt.Dimension(23, 20));
        btnChooseCourseIDSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseCourseIDSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1Search.add(btnChooseCourseIDSearch, gridBagConstraints);

        btnChooseStudentIDSearch.setText("jButton2");
        btnChooseStudentIDSearch.setMaximumSize(new java.awt.Dimension(23, 23));
        btnChooseStudentIDSearch.setMinimumSize(new java.awt.Dimension(23, 23));
        btnChooseStudentIDSearch.setPreferredSize(new java.awt.Dimension(23, 20));
        btnChooseStudentIDSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseStudentIDSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1Search.add(btnChooseStudentIDSearch, gridBagConstraints);

        pnlSearch.add(panelRight1Search, new java.awt.GridBagConstraints());

        tpRegister.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpRegister, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Register", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelLeft.setMinimumSize(new java.awt.Dimension(860, 370));
        panelLeft.setPreferredSize(new java.awt.Dimension(860, 370));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        lblEnterNameStudent.setForeground(new java.awt.Color(3, 3, 3));
        lblEnterNameStudent.setText("Enter Filter:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 480, 5, 5);
        panelLeft.add(lblEnterNameStudent, gridBagConstraints);

        filterText.setMinimumSize(new java.awt.Dimension(200, 20));
        filterText.setPreferredSize(new java.awt.Dimension(200, 20));
        filterText.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                filterTextCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(filterText, gridBagConstraints);

        srcPanelRegister.setAutoscrolls(true);
        srcPanelRegister.setMinimumSize(new java.awt.Dimension(840, 250));
        srcPanelRegister.setPreferredSize(new java.awt.Dimension(840, 250));

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
        tableContent.setMinimumSize(new java.awt.Dimension(770, 290));
        tableContent.setPreferredSize(new java.awt.Dimension(770, 290));
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableContentMouseReleased(evt);
            }
        });
        srcPanelRegister.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
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
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(btnFilter, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        btnReport.setText("Report");
        btnReport.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReport.setMaximumSize(new java.awt.Dimension(75, 23));
        btnReport.setMinimumSize(new java.awt.Dimension(75, 23));
        btnReport.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel2.add(btnReport);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        panelLeft.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelLeft, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        searchStart();
}//GEN-LAST:event_btnFilterActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            if (!isAdd) {
                isAdd = true;
                txtId.setRequestFocusEnabled(true);
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
                btnCancelEdit.setVisible(true);
                resetDetails();
            } else {
                isAdd = false;
                txtId.setRequestFocusEnabled(false);
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
                btnCancelEdit.setVisible(false);
                String Id = txtStudentId.getText();
                String studentId = txtId.getText();
                int feesStructe = cbxFeeStructe.getSelectedIndex();
                Date regDate = new java.sql.Date(dateChRegistrationDate.getDate().getTime());
                String courseId = txtCourseID.getText();
                Register register = new Register(Id, courseId, feesStructe, (java.sql.Date) regDate, studentId);
                if (regisDAO.create(register)) {
                    JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Create Register", JOptionPane.INFORMATION_MESSAGE);
                    regisList.add(register);
                    loadData(regisList);
                    loadDetails(register);
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

            String id = txtStudentId.getText();
            String studentId = txtId.getText();
            int feesStructe = cbxFeeStructe.getSelectedIndex();
            Date regDate = new java.sql.Date(dateChRegistrationDate.getDate().getTime());
            String courseId = txtCourseID.getText();
            Register register = new Register(id, courseId, feesStructe, (java.sql.Date) regDate, studentId);
            if (regisDAO.update(register)) {
                JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Update Subject", JOptionPane.INFORMATION_MESSAGE);
                int index = findByStudentId(studentId);
                if(index != -1) {
                    regisList.remove(index);
                    regisList.add(register);
                } else {
                    JOptionPane.showMessageDialog(this, "not found Student has Id is " + studentId, "Register Update", JOptionPane.ERROR_MESSAGE);
                }
                
                loadData(regisList);
                loadDetails(register);
//                txtCourseID.setVisible(true);
//                txtStudentId.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Update Subject", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Update Subject", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String studentid = txtId.getText();
        if (regisDAO.delete(studentid)) {
            regisList.remove(findByStudentId(studentid));
            loadData(regisList);
            if (!regisList.isEmpty()) {
                loadDetails(regisList.get(0));
            }
            JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Delete Register", JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            JOptionPane.showMessageDialog(this, regisDAO.getLastError(), "Delete Register", JOptionPane.ERROR_MESSAGE, null);
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtIdSearch.setText(null);
        txtStudentIdSearch.setText(null);
        txtCourseIDSearch.setText(null);
        txtFeesStructeSearch.setText(null);
        dateChRegistrationDateSearch.setDate(null);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnChooseCourseIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseCourseIdActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtCourseID, true, 7);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnChooseCourseIdActionPerformed

    private void btnChooseStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseStudentIdActionPerformed

        dlgChoose dlg = new dlgChoose(frm, txtStudentId, true, 13);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_btnChooseStudentIdActionPerformed

    private void btnChooseCourseIDSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseCourseIDSearchActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtCourseIDSearch, true, 7);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnChooseCourseIDSearchActionPerformed

    private void btnChooseStudentIDSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseStudentIDSearchActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtStudentIdSearch, true, 13);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_btnChooseStudentIDSearchActionPerformed

    private void filterTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_filterTextCaretUpdate
        // TODO add your handling code here:
        searchStart();
    }//GEN-LAST:event_filterTextCaretUpdate

    private void tableContentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseReleased
        // TODO add your handling code here:
        if (!regisList.isEmpty()) {
            int tableIndex = tableContent.getSelectedRow();
            if (tableIndex != -1) {
                String studentId = tableContent.getValueAt(tableIndex, 0).toString();
                int listIndex = findByStudentId(studentId);
                if (listIndex != -1) {
                    loadDetails(regisList.get(listIndex));
                }
            }
        }
    }//GEN-LAST:event_tableContentMouseReleased

    private void txtIdCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtIdCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCaretUpdate

    private void txtCourseIDCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCourseIDCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseIDCaretUpdate

    private void txtStudentIdCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtStudentIdCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIdCaretUpdate

    private void dateChRegistrationDateCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dateChRegistrationDateCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_dateChRegistrationDateCaretPositionChanged

    private void txtIdSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtIdSearchCaretUpdate
        // TODO add your handling code here:
        loadData(regisList);
    }//GEN-LAST:event_txtIdSearchCaretUpdate

    private void txtCourseIDSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCourseIDSearchCaretUpdate
        // TODO add your handling code here:
        loadData(regisList);
    }//GEN-LAST:event_txtCourseIDSearchCaretUpdate

    private void txtFeesStructeSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFeesStructeSearchCaretUpdate
        // TODO add your handling code here:
        loadData(regisList);
    }//GEN-LAST:event_txtFeesStructeSearchCaretUpdate

    private void txtStudentIdSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtStudentIdSearchCaretUpdate
        // TODO add your handling code here:
        loadData(regisList);
    }//GEN-LAST:event_txtStudentIdSearchCaretUpdate

    private void dateChRegistrationDateSearchCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dateChRegistrationDateSearchCaretPositionChanged
        // TODO add your handling code here:
        loadData(regisList);
    }//GEN-LAST:event_dateChRegistrationDateSearchCaretPositionChanged

    private void btnCancelEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEditActionPerformed
        // TODO add your handling code here:
        if (isAdd) {
            isAdd = false;
            txtId.setRequestFocusEnabled(false);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnCancelEdit.setVisible(false);
        }
    }//GEN-LAST:event_btnCancelEditActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelEdit;
    private javax.swing.JButton btnChooseCourseIDSearch;
    private javax.swing.JButton btnChooseCourseId;
    private javax.swing.JButton btnChooseStudentIDSearch;
    private javax.swing.JButton btnChooseStudentId;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbxFeeStructe;
    private com.toedter.calendar.JDateChooser dateChRegistrationDate;
    private com.toedter.calendar.JDateChooser dateChRegistrationDateSearch;
    private javax.swing.JTextField filterText;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblCourseIDSearch;
    private javax.swing.JLabel lblEnterNameStudent;
    private javax.swing.JLabel lblFeesStructe;
    private javax.swing.JLabel lblFeesStructeSearch;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIDSearch;
    private javax.swing.JLabel lblRegistrationDate;
    private javax.swing.JLabel lblRegistrationDateSearch;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentIDSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleSearch;
    private javax.swing.JPanel panelButon;
    private javax.swing.JPanel panelButonSearch;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelRight1Search;
    public javax.swing.JPanel pnlEdit;
    public javax.swing.JPanel pnlSearch;
    private javax.swing.JSeparator sepa1;
    private javax.swing.JSeparator sepa2Search;
    private javax.swing.JScrollPane srcPanelRegister;
    private javax.swing.JTable tableContent;
    public javax.swing.JTabbedPane tpRegister;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtCourseIDSearch;
    private javax.swing.JTextField txtFeesStructeSearch;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdSearch;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtStudentIdSearch;
    // End of variables declaration//GEN-END:variables

    String getSelectedCode() {
        try {
            // TODO add your handling code here:
            int index = tableContent.getSelectedRow();
            if (index != -1) {
                return tableContent.getValueAt(index, 0).toString();
            }
        } catch (Exception ex) {
        }
        return null;
    }
}
