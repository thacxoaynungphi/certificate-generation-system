/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pnlStudent.java
 *
 * Created on Mar 31, 2011, 6:45:20 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.LoadImage;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Student;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.swing.CellEditor;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author nhchung
 */
public class pnlStudent extends javax.swing.JPanel {

    private ArrayList<Student> liststudent = new ArrayList<Student>();
    ArrayList<Student> filter = null;
    private StudentDAO studentDao = new StudentDAO();
    TableRowSorter<TableModel> sorter;
    private ObjectTableModel tableModel;
    private JTable headerTable;
    private boolean isAdd;
    frmMain frm;

    /** Creates new form pnlStudent */
    public pnlStudent() {
        initComponents();
        txtIDEdit.setEnabled(false);
        isAdd = false;
        liststudent = studentDao.readByAll();
        btnCancelEdit.setVisible(false);
        loadTable(liststudent);
    }

    public pnlStudent(frmMain frm) {
        initComponents();
        this.frm = frm;
        txtIDEdit.setEnabled(false);
        isAdd = false;
        liststudent = studentDao.readByAll();
        btnCancelEdit.setVisible(false);
        loadTable(liststudent);
    }

    public void loadTable(ArrayList<Student> liststudent) {
        System.out.println("Date Start :" + dateChooserDateStartSearch.getDate());
        System.out.println("Date End   :" + dateChooserDateEndSearch.getDate());
        filter = new ArrayList<Student>();
        boolean status = false;
        for (Student student : liststudent) {
            status = false;
            if (student.getId().toLowerCase().matches(".*" + txtStudentIdSearch.getText().trim().toLowerCase() + ".*")
                    && student.getFirstName().toLowerCase().matches(".*" + txtFirstNameSearch.getText().trim().toLowerCase() + ".*")
                    && student.getLastName().toLowerCase().matches(".*" + txtLastNameSearch.getText().trim().toLowerCase() + ".*")) {
                if (dateChooserDateEndSearch.getDate() != null && dateChooserDateStartSearch.getDate() != null) {
                    if (student.getBirthDay().after(dateChooserDateStartSearch.getDate()) && student.getBirthDay().before(dateChooserDateEndSearch.getDate())) {
                        if (radioAll.isSelected()) {
                            filter.add(student);
                            System.out.println("Hi1");
                        } else if (radioMaleSearch.isSelected() && student.getGender() == 0) {
                            filter.add(student);
                            System.out.println("Hi2");
                        } else if (radioFemaleSearch.isSelected() && student.getGender() == 1) {
                            filter.add(student);
                            System.out.println("Hi3");
                        }
                    }
                } else {
                    if (radioAll.isSelected()) {
                        filter.add(student);
                        System.out.println("Hi1");
                    } else if (radioMaleSearch.isSelected() && student.getGender() == 0) {
                        filter.add(student);
                        System.out.println("Hi2");
                    } else if (radioFemaleSearch.isSelected() && student.getGender() == 1) {
                        filter.add(student);
                        System.out.println("Hi3");
                    }
                }
            }
        }
        if (filter.size() != 0) {
            loadDetails(filter.get(0));
        }
        ColumnData[] columns = {
            new ColumnData("ID", 135, SwingConstants.LEFT, 1),
            new ColumnData("First Name", 150, SwingConstants.LEFT, 2),
            new ColumnData("Last Name", 150, SwingConstants.LEFT, 3),
            new ColumnData("Birthday", 170, SwingConstants.LEFT, 4),
            new ColumnData("Gender", 50, SwingConstants.LEFT, 5),
            new ColumnData("Phone", 100, SwingConstants.LEFT, 6)
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
        srcPanelContent.setRowHeader(viewport);
        srcPanelContent.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    public Student find(String id) {
        for (int i = 0; i < liststudent.size(); i++) {
            if (liststudent.get(i).getId().equals(id)) {
                return liststudent.get(i);
            }
        }
        return null;
    }

    public boolean isExist(Student student) {
        for (int i = 0; i < liststudent.size(); i++) {
            if (liststudent.get(i).getId().equalsIgnoreCase(student.getId())) {
                return false;
            }
        }
        return true;
    }

    private void cancelCellEditing() {
        CellEditor ce = tableContent.getCellEditor();
        if (ce != null) {
            ce.cancelCellEditing();
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

        btnGGender1 = new javax.swing.ButtonGroup();
        btnGGender2 = new javax.swing.ButtonGroup();
        tpStudent = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        panelContent1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        sepaAddStu = new javax.swing.JSeparator();
        lblFirstname = new javax.swing.JLabel();
        lblLastname = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblBirthday = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblImage1 = new javax.swing.JLabel();
        lblImage2 = new javax.swing.JLabel();
        txtFirstNameEdit = new javax.swing.JTextField();
        txtLastNameEdit = new javax.swing.JTextField();
        radioMaleEdit = new javax.swing.JRadioButton();
        radioFemaleEdit = new javax.swing.JRadioButton();
        txtEmailEdit = new javax.swing.JTextField();
        txtAddressEdit = new javax.swing.JTextField();
        btnBrowseEdit = new javax.swing.JButton();
        txtImageEdit = new javax.swing.JTextField();
        panelButton = new javax.swing.JPanel();
        btnAddEdit = new javax.swing.JButton();
        btnUpdateEdit = new javax.swing.JButton();
        btnDeleteEdit = new javax.swing.JButton();
        btnCancelEdit = new javax.swing.JButton();
        lblStart1 = new javax.swing.JLabel();
        lblStart2 = new javax.swing.JLabel();
        lblStart3 = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        txtIDEdit = new javax.swing.JTextField();
        lblStart4 = new javax.swing.JLabel();
        dateChBirthdayEdit = new com.toedter.calendar.JDateChooser();
        lblPhone = new javax.swing.JLabel();
        txtPhoneEdit = new javax.swing.JTextField();
        pnlSearch = new javax.swing.JPanel();
        panelInfo = new javax.swing.JPanel();
        lblStudentId = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstNameSearch = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastNameSearch = new javax.swing.JTextField();
        lblBirthday1 = new javax.swing.JLabel();
        dateChooserDateStartSearch = new com.toedter.calendar.JDateChooser();
        dateChooserDateEndSearch = new com.toedter.calendar.JDateChooser();
        lblGender1 = new javax.swing.JLabel();
        radioMaleSearch = new javax.swing.JRadioButton();
        radioFemaleSearch = new javax.swing.JRadioButton();
        lblTitle1 = new javax.swing.JLabel();
        sepaCourse = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        txtStudentIdSearch = new javax.swing.JTextField();
        radioAll = new javax.swing.JRadioButton();
        panelContent = new javax.swing.JPanel();
        panelTop = new javax.swing.JPanel();
        lblHienthi1 = new javax.swing.JLabel();
        lblCount = new javax.swing.JLabel();
        btnFilter = new javax.swing.JButton();
        filterText = new javax.swing.JTextField();
        lblEnterFiter = new javax.swing.JLabel();
        panelTable = new javax.swing.JPanel();
        srcPanelContent = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnReportDetails = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        tpStudent.setMinimumSize(new java.awt.Dimension(860, 320));
        tpStudent.setPreferredSize(new java.awt.Dimension(860, 320));

        pnlEdit.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlEdit.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlEdit.setLayout(new java.awt.GridBagLayout());

        panelContent1.setBackground(new java.awt.Color(255, 255, 255));
        panelContent1.setMinimumSize(new java.awt.Dimension(860, 300));
        panelContent1.setPreferredSize(new java.awt.Dimension(860, 300));
        panelContent1.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Student");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelContent1.add(lblTitle, gridBagConstraints);

        sepaAddStu.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelContent1.add(sepaAddStu, gridBagConstraints);

        lblFirstname.setForeground(new java.awt.Color(3, 3, 3));
        lblFirstname.setText("Firstname:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(lblFirstname, gridBagConstraints);

        lblLastname.setForeground(new java.awt.Color(3, 3, 3));
        lblLastname.setText("Lastname:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(lblLastname, gridBagConstraints);

        lblGender.setForeground(new java.awt.Color(3, 3, 3));
        lblGender.setText("Gender:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(lblGender, gridBagConstraints);

        lblBirthday.setForeground(new java.awt.Color(3, 3, 3));
        lblBirthday.setText("Birthday:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(lblBirthday, gridBagConstraints);

        lblEmail.setForeground(new java.awt.Color(3, 3, 3));
        lblEmail.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelContent1.add(lblEmail, gridBagConstraints);

        lblAddress.setForeground(new java.awt.Color(3, 3, 3));
        lblAddress.setText("Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(lblAddress, gridBagConstraints);

        lblImage1.setForeground(new java.awt.Color(3, 3, 3));
        lblImage1.setText("Image:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelContent1.add(lblImage1, gridBagConstraints);

        lblImage2.setMaximumSize(new java.awt.Dimension(87, 115));
        lblImage2.setMinimumSize(new java.awt.Dimension(87, 115));
        lblImage2.setPreferredSize(new java.awt.Dimension(87, 115));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelContent1.add(lblImage2, gridBagConstraints);

        txtFirstNameEdit.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(txtFirstNameEdit, gridBagConstraints);

        txtLastNameEdit.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(txtLastNameEdit, gridBagConstraints);

        radioMaleEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnGGender1.add(radioMaleEdit);
        radioMaleEdit.setText("Male");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(radioMaleEdit, gridBagConstraints);

        radioFemaleEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnGGender1.add(radioFemaleEdit);
        radioFemaleEdit.setText("Female");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(radioFemaleEdit, gridBagConstraints);

        txtEmailEdit.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(txtEmailEdit, gridBagConstraints);

        txtAddressEdit.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(txtAddressEdit, gridBagConstraints);

        btnBrowseEdit.setText("Browse");
        btnBrowseEdit.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnBrowseEdit.setMaximumSize(new java.awt.Dimension(70, 23));
        btnBrowseEdit.setMinimumSize(new java.awt.Dimension(70, 23));
        btnBrowseEdit.setPreferredSize(new java.awt.Dimension(60, 20));
        btnBrowseEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseEditActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        panelContent1.add(btnBrowseEdit, gridBagConstraints);

        txtImageEdit.setPreferredSize(new java.awt.Dimension(130, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 5, 3);
        panelContent1.add(txtImageEdit, gridBagConstraints);

        panelButton.setBackground(new java.awt.Color(255, 255, 255));
        panelButton.setMinimumSize(new java.awt.Dimension(400, 35));
        panelButton.setPreferredSize(new java.awt.Dimension(400, 35));

        btnAddEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnAddEdit.setText("Add");
        btnAddEdit.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnAddEdit.setPreferredSize(new java.awt.Dimension(75, 23));
        btnAddEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEditActionPerformed(evt);
            }
        });
        panelButton.add(btnAddEdit);

        btnUpdateEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnUpdateEdit.setText("Update");
        btnUpdateEdit.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnUpdateEdit.setMaximumSize(new java.awt.Dimension(75, 23));
        btnUpdateEdit.setMinimumSize(new java.awt.Dimension(75, 23));
        btnUpdateEdit.setPreferredSize(new java.awt.Dimension(75, 23));
        btnUpdateEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateEditActionPerformed(evt);
            }
        });
        panelButton.add(btnUpdateEdit);

        btnDeleteEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        btnDeleteEdit.setText("Delete");
        btnDeleteEdit.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnDeleteEdit.setMaximumSize(new java.awt.Dimension(75, 25));
        btnDeleteEdit.setMinimumSize(new java.awt.Dimension(75, 25));
        btnDeleteEdit.setPreferredSize(new java.awt.Dimension(75, 23));
        btnDeleteEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEditActionPerformed(evt);
            }
        });
        panelButton.add(btnDeleteEdit);

        btnCancelEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancelEdit.setText("Cancel");
        btnCancelEdit.setPreferredSize(new java.awt.Dimension(85, 23));
        btnCancelEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEditActionPerformed(evt);
            }
        });
        panelButton.add(btnCancelEdit);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelContent1.add(panelButton, gridBagConstraints);

        lblStart1.setForeground(new java.awt.Color(255, 0, 0));
        lblStart1.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        panelContent1.add(lblStart1, gridBagConstraints);

        lblStart2.setForeground(new java.awt.Color(255, 0, 0));
        lblStart2.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(lblStart2, gridBagConstraints);

        lblStart3.setForeground(new java.awt.Color(255, 0, 0));
        lblStart3.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(lblStart3, gridBagConstraints);

        lblStudentID.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentID.setText("Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(lblStudentID, gridBagConstraints);

        txtIDEdit.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(txtIDEdit, gridBagConstraints);

        lblStart4.setForeground(new java.awt.Color(255, 0, 0));
        lblStart4.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(lblStart4, gridBagConstraints);

        dateChBirthdayEdit.setDateFormatString("MM/dd/yyyy");
        dateChBirthdayEdit.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(dateChBirthdayEdit, gridBagConstraints);

        lblPhone.setForeground(new java.awt.Color(3, 3, 3));
        lblPhone.setText("Phone: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelContent1.add(lblPhone, gridBagConstraints);

        txtPhoneEdit.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent1.add(txtPhoneEdit, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlEdit.add(panelContent1, gridBagConstraints);

        tpStudent.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlSearch.setLayout(new java.awt.GridBagLayout());

        panelInfo.setBackground(new java.awt.Color(255, 255, 255));
        panelInfo.setMinimumSize(new java.awt.Dimension(860, 300));
        panelInfo.setPreferredSize(new java.awt.Dimension(860, 300));
        panelInfo.setLayout(new java.awt.GridBagLayout());

        lblStudentId.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentId.setText("Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblStudentId, gridBagConstraints);

        lblFirstName.setForeground(new java.awt.Color(3, 3, 3));
        lblFirstName.setText("First Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblFirstName, gridBagConstraints);

        txtFirstNameSearch.setMinimumSize(new java.awt.Dimension(150, 20));
        txtFirstNameSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtFirstNameSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFirstNameSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(txtFirstNameSearch, gridBagConstraints);

        lblLastName.setForeground(new java.awt.Color(3, 3, 3));
        lblLastName.setText("Last Name: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblLastName, gridBagConstraints);

        txtLastNameSearch.setMinimumSize(new java.awt.Dimension(150, 20));
        txtLastNameSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtLastNameSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtLastNameSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(txtLastNameSearch, gridBagConstraints);

        lblBirthday1.setForeground(new java.awt.Color(3, 3, 3));
        lblBirthday1.setText("Birthday: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelInfo.add(lblBirthday1, gridBagConstraints);

        dateChooserDateStartSearch.setDateFormatString("MM/dd/yyyy");
        dateChooserDateStartSearch.setMinimumSize(new java.awt.Dimension(150, 20));
        dateChooserDateStartSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        dateChooserDateStartSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                dateChooserDateStartSearchCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        dateChooserDateStartSearch.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                dateChooserDateStartSearchAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(dateChooserDateStartSearch, gridBagConstraints);

        dateChooserDateEndSearch.setDateFormatString("MM/dd/yyyy");
        dateChooserDateEndSearch.setMinimumSize(new java.awt.Dimension(150, 20));
        dateChooserDateEndSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        dateChooserDateEndSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                dateChooserDateEndSearchCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(dateChooserDateEndSearch, gridBagConstraints);

        lblGender1.setForeground(new java.awt.Color(3, 3, 3));
        lblGender1.setText("Gender:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelInfo.add(lblGender1, gridBagConstraints);

        radioMaleSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnGGender2.add(radioMaleSearch);
        radioMaleSearch.setForeground(new java.awt.Color(3, 3, 3));
        radioMaleSearch.setText("Male");
        radioMaleSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioMaleSearchItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(radioMaleSearch, gridBagConstraints);

        radioFemaleSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnGGender2.add(radioFemaleSearch);
        radioFemaleSearch.setForeground(new java.awt.Color(3, 3, 3));
        radioFemaleSearch.setText("FeMale");
        radioFemaleSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioFemaleSearchItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(radioFemaleSearch, gridBagConstraints);

        lblTitle1.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle1.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle1.setText("Information Student");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelInfo.add(lblTitle1, gridBagConstraints);

        sepaCourse.setMinimumSize(new java.awt.Dimension(650, 10));
        sepaCourse.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panelInfo.add(sepaCourse, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReset.setMaximumSize(new java.awt.Dimension(75, 23));
        btnReset.setMinimumSize(new java.awt.Dimension(75, 23));
        btnReset.setPreferredSize(new java.awt.Dimension(75, 23));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 5, 5);
        panelInfo.add(jPanel1, gridBagConstraints);

        txtStudentIdSearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtStudentIdSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtStudentIdSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtStudentIdSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(txtStudentIdSearch, gridBagConstraints);

        radioAll.setBackground(new java.awt.Color(255, 255, 255));
        btnGGender2.add(radioAll);
        radioAll.setSelected(true);
        radioAll.setText("All");
        radioAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAllActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelInfo.add(radioAll, gridBagConstraints);

        pnlSearch.add(panelInfo, new java.awt.GridBagConstraints());

        tpStudent.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpStudent, gridBagConstraints);

        panelContent.setMinimumSize(new java.awt.Dimension(860, 280));
        panelContent.setPreferredSize(new java.awt.Dimension(860, 280));
        panelContent.setLayout(new java.awt.GridBagLayout());

        panelTop.setBackground(new java.awt.Color(255, 255, 255));
        panelTop.setMinimumSize(new java.awt.Dimension(860, 30));
        panelTop.setPreferredSize(new java.awt.Dimension(860, 30));
        panelTop.setLayout(new java.awt.GridBagLayout());

        lblHienthi1.setForeground(new java.awt.Color(3, 3, 3));
        lblHienthi1.setText("Total Students:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelTop.add(lblHienthi1, gridBagConstraints);

        lblCount.setForeground(new java.awt.Color(3, 3, 3));
        lblCount.setPreferredSize(new java.awt.Dimension(20, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 20);
        panelTop.add(lblCount, gridBagConstraints);

        btnFilter.setText("Filter");
        btnFilter.setMaximumSize(new java.awt.Dimension(75, 23));
        btnFilter.setMinimumSize(new java.awt.Dimension(75, 23));
        btnFilter.setPreferredSize(new java.awt.Dimension(75, 23));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelTop.add(btnFilter, gridBagConstraints);

        filterText.setMinimumSize(new java.awt.Dimension(200, 20));
        filterText.setPreferredSize(new java.awt.Dimension(200, 20));
        filterText.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                filterTextCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelTop.add(filterText, gridBagConstraints);

        lblEnterFiter.setText("Enter fiter: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 380, 5, 5);
        panelTop.add(lblEnterFiter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelContent.add(panelTop, gridBagConstraints);

        panelTable.setBackground(new java.awt.Color(255, 255, 255));
        panelTable.setMinimumSize(new java.awt.Dimension(860, 250));
        panelTable.setPreferredSize(new java.awt.Dimension(860, 250));
        panelTable.setRequestFocusEnabled(false);
        panelTable.setLayout(new java.awt.GridBagLayout());

        srcPanelContent.setMinimumSize(new java.awt.Dimension(840, 220));
        srcPanelContent.setPreferredSize(new java.awt.Dimension(840, 220));

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
        tableContent.setMinimumSize(new java.awt.Dimension(770, 220));
        tableContent.setPreferredSize(new java.awt.Dimension(770, 220));
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableContentMouseReleased(evt);
            }
        });
        srcPanelContent.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelTable.add(srcPanelContent, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnReportDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        btnReportDetails.setText("Report Details");
        btnReportDetails.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReportDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportDetailsActionPerformed(evt);
            }
        });
        jPanel2.add(btnReportDetails);

        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        btnReport.setText("Report");
        btnReport.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReport.setMaximumSize(new java.awt.Dimension(75, 25));
        btnReport.setMinimumSize(new java.awt.Dimension(75, 25));
        btnReport.setPreferredSize(new java.awt.Dimension(75, 25));
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });
        jPanel2.add(btnReport);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelTable.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelContent.add(panelTable, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelContent, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateEditActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Student student = new Student();
            student.setId(txtIDEdit.getText());
            student.setFirstName(txtFirstNameEdit.getText());
            student.setLastName(txtLastNameEdit.getText());
            student.setBirthDay(new java.sql.Date(dateChBirthdayEdit.getDate().getTime()));
            if (radioMaleEdit.isSelected()) {
                student.setGender(0);

            } else if (radioFemaleEdit.isSelected()) {
                student.setGender(1);

            }
            student.setPhone(txtPhoneEdit.getText());
            student.setEmail(txtEmailEdit.getText());
            student.setAddress(txtAddressEdit.getText());
            try {
                File file = new File(txtImageEdit.getText());
                String name = file.getName();
                String extension;
                int dotPos = name.lastIndexOf(".");
                extension = name.substring(dotPos);
                LoadImage.copyImage(file.getPath(), System.getProperty("user.dir") + "/avatar/" + student.getId() + extension);
                student.setImage(student.getId() + extension);
            } catch (Exception ex) {
            }
            student.setStatus(1);
            StudentDAO studentDAO = new StudentDAO();
            if (studentDAO.update(student)) {
                liststudent = studentDAO.readByAll();
                loadTable(liststudent);
                JOptionPane.showMessageDialog(this, studentDAO.getLastError(), "Employee Add", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, studentDAO.getLastError(), "Employee Add", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
        }
}//GEN-LAST:event_btnUpdateEditActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtStudentIdSearch.setText(null);
        txtFirstNameSearch.setText(null);
        txtLastNameSearch.setText(null);
        dateChooserDateEndSearch.setDate(null);
        dateChooserDateStartSearch.setDate(null);
        radioMaleSearch.setSelected(true);
    }//GEN-LAST:event_btnResetActionPerformed

    public void loadDetails(Student student) {
        txtIDEdit.setText(student.getId());
        txtFirstNameEdit.setText(student.getFirstName());
        txtLastNameEdit.setText(student.getLastName());
        try {
            dateChBirthdayEdit.setDate(student.getBirthDay());
        } catch (Exception ex) {
        }
        int gender = student.getGender();
        if (gender == 0) {
            radioMaleEdit.setSelected(true);

        } else {
            radioFemaleEdit.setSelected(true);

        }
        txtPhoneEdit.setText(student.getPhone());
        txtEmailEdit.setText(student.getEmail());
        txtAddressEdit.setText(student.getAddress());
        txtImageEdit.setText(student.getImage());
        System.out.println("Image : " + student.getImage());
        if (student.getImage().length() != 0) {
            lblImage2.setIcon(null);
            lblImage2.setIcon(new ImageIcon(System.getProperty("user.dir") + "/avatar/" + student.getImage()));
        } else {
            //TODO: hien thi anh khi khong co avatar
            lblImage2.setIcon(new ImageIcon(System.getProperty("user.dir") + "/avatar/no images.jpg"));
        }
    }

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        startFilter();
}//GEN-LAST:event_btnFilterActionPerformed

    public void startFilter() {
        if (!liststudent.isEmpty()) {
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

    public void resetEditDetails() {
        txtIDEdit.setText("");
        txtFirstNameEdit.setText("");
        txtLastNameEdit.setText("");
        txtEmailEdit.setText("");
        dateChBirthdayEdit.setDate(null);
        txtPhoneEdit.setText("");
        txtAddressEdit.setText("");
        txtImageEdit.setText("");
        lblImage2.setIcon(null);
    }

    private void btnAddEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEditActionPerformed
        // TODO add your handling code here:
        if (!isAdd) {
            isAdd = true;
            txtIDEdit.setEnabled(true);
            btnUpdateEdit.setEnabled(false);
            btnDeleteEdit.setEnabled(false);
            btnCancelEdit.setVisible(true);
            resetEditDetails();
        } else {
            isAdd = false;
            btnUpdateEdit.setEnabled(true);
            btnDeleteEdit.setEnabled(true);
            btnCancelEdit.setVisible(false);
            txtIDEdit.setEnabled(false);
            try {
                // TODO add your handling code here:
                Student student = new Student();
                student.setId(txtIDEdit.getText());
                student.setFirstName(txtFirstNameEdit.getText());
                student.setLastName(txtLastNameEdit.getText());
                student.setBirthDay(new java.sql.Date(dateChBirthdayEdit.getDate().getTime()));
                if (radioMaleEdit.isSelected()) {
                    student.setGender(0);
                } else if (radioFemaleEdit.isSelected()) {
                    student.setGender(1);
                }
                student.setPhone(txtPhoneEdit.getText());
                student.setEmail(txtEmailEdit.getText());
                student.setAddress(txtAddressEdit.getText());
                File file = new File(txtImageEdit.getText());
                String name = file.getName();
                String extension;
                int dotPos = name.lastIndexOf(".");
                extension = name.substring(dotPos);
                LoadImage.copyImage(file.getPath(), System.getProperty("user.dir") + "/avatar/" + student.getId() + extension);
                student.setImage(student.getId() + extension);
                student.setBirthDay(new java.sql.Date(dateChBirthdayEdit.getDate().getTime()));
                student.setStatus(1);
                StudentDAO studentDao = new StudentDAO();
                if (studentDao.create(student)) {
                    liststudent.add(student);
                    loadTable(liststudent);
                    JOptionPane.showMessageDialog(this, studentDao.getLastError(), "Create Student", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, studentDao.getLastError(), "Create Student", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_btnAddEditActionPerformed

    private void tableContentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseReleased
        // TODO add your handling code here:
        int index = tableContent.getSelectedRow();
        if (index != -1) {
            String value = (String) tableContent.getValueAt(index, 0);
            Student student = find(value);
            if (student != null) {
                loadDetails(student);
            }
        }
    }//GEN-LAST:event_tableContentMouseReleased

    private void txtStudentIdSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtStudentIdSearchCaretUpdate
        // TODO add your handling code here:
        loadTable(liststudent);
    }//GEN-LAST:event_txtStudentIdSearchCaretUpdate

    private void txtFirstNameSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFirstNameSearchCaretUpdate
        // TODO add your handling code here:
        loadTable(liststudent);
    }//GEN-LAST:event_txtFirstNameSearchCaretUpdate

    private void txtLastNameSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtLastNameSearchCaretUpdate
        // TODO add your handling code here:
        loadTable(liststudent);
    }//GEN-LAST:event_txtLastNameSearchCaretUpdate

    private void filterTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_filterTextCaretUpdate
        // TODO add your handling code here:
        startFilter();
    }//GEN-LAST:event_filterTextCaretUpdate

    private void btnDeleteEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEditActionPerformed
        // TODO add your handling code here:
        String id = txtIDEdit.getText();
        if (studentDao.delete(id)) {
            liststudent = studentDao.readByAll();
            loadTable(liststudent);
            JOptionPane.showMessageDialog(this, studentDao.getLastError(), "Student Delete", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, studentDao.getLastError(), "Student Delete", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteEditActionPerformed

    private void btnCancelEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEditActionPerformed
        // TODO add your handling code here:
        if (isAdd) {
            isAdd = false;
            btnUpdateEdit.setEnabled(true);
            btnDeleteEdit.setEnabled(true);
            txtIDEdit.setEnabled(false);
            btnCancelEdit.setVisible(false);
        }
    }//GEN-LAST:event_btnCancelEditActionPerformed

    private void btnReportDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportDetailsActionPerformed
        // TODO add your handling code here:
        int index = this.tableContent.getSelectedRow();
        if (index != -1) {
            Student student = filter.get(index);
            frm.pnlReport.removeAll();
            dlgChooseReport report = new dlgChooseReport(frm, this);
            report.getStudentDetailsReport(student);
            report.setVisible(true);
            report.setSize(860, 600);
            frm.pnlReport.add(report);
            frm.tpnBusiness.setSelectedComponent(frm.pnlReport);
        } else {
            JOptionPane.showMessageDialog(this, "You are choose student!", "Report details student", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnReportDetailsActionPerformed

    //TODO: copy file chua xac dinh duoc duong dan cua file
    private void btnBrowseEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseEditActionPerformed
        // TODO add your handling code here:
        //TODO: chua fix duoc update anh

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG, GIF, & PNG Images", "jpg", "gif", "png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = chooser.getSelectedFile();
                Image image = Image.getInstance(file.getPath());
                if (image.getWidth() <= 85 && image.getWidth() > 0 && image.getHeight() <= 113 && image.getHeight() > 0) {
                    ImageIcon icon = new ImageIcon(file.getPath());
                    lblImage2.setIcon(icon);
                    txtImageEdit.setText(file.getPath());
                } else {
                    JOptionPane.showMessageDialog(this, "No choose file", "Choose Iamge", JOptionPane.ERROR_MESSAGE);
                }
            } catch (BadElementException ex) {
                Logger.getLogger(pnlStudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(pnlStudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnBrowseEditActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
       if (!filter.isEmpty()) {
            frm.pnlReport.removeAll();
            dlgChooseReport report = new dlgChooseReport(frm, this);
            report.getStudentReport(filter);
            report.setVisible(true);
            report.setSize(860, 600);
            frm.pnlReport.add(report);
            frm.tpnBusiness.setSelectedComponent(frm.pnlReport);
        } else {
            JOptionPane.showMessageDialog(this, "No data!", "Report Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnReportActionPerformed

    private void radioMaleSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioMaleSearchItemStateChanged
        // TODO add your handling code here:
        loadTable(liststudent);
    }//GEN-LAST:event_radioMaleSearchItemStateChanged

    private void radioFemaleSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioFemaleSearchItemStateChanged
        // TODO add your handling code here:
        loadTable(liststudent);
    }//GEN-LAST:event_radioFemaleSearchItemStateChanged

    private void dateChooserDateStartSearchAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_dateChooserDateStartSearchAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_dateChooserDateStartSearchAncestorAdded

    private void dateChooserDateStartSearchCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dateChooserDateStartSearchCaretPositionChanged
        // TODO add your handling code here:
        loadTable(liststudent);
    }//GEN-LAST:event_dateChooserDateStartSearchCaretPositionChanged

    private void dateChooserDateEndSearchCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dateChooserDateEndSearchCaretPositionChanged
        // TODO add your handling code here:
        loadTable(liststudent);
    }//GEN-LAST:event_dateChooserDateEndSearchCaretPositionChanged

    private void radioAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAllActionPerformed
        // TODO add your handling code here:
        loadTable(liststudent);
    }//GEN-LAST:event_radioAllActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEdit;
    private javax.swing.JButton btnBrowseEdit;
    private javax.swing.JButton btnCancelEdit;
    private javax.swing.JButton btnDeleteEdit;
    private javax.swing.JButton btnFilter;
    private javax.swing.ButtonGroup btnGGender1;
    private javax.swing.ButtonGroup btnGGender2;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnReportDetails;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdateEdit;
    private com.toedter.calendar.JDateChooser dateChBirthdayEdit;
    private com.toedter.calendar.JDateChooser dateChooserDateEndSearch;
    private com.toedter.calendar.JDateChooser dateChooserDateStartSearch;
    private javax.swing.JTextField filterText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblBirthday1;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEnterFiter;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGender1;
    private javax.swing.JLabel lblHienthi1;
    private javax.swing.JLabel lblImage1;
    private javax.swing.JLabel lblImage2;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblStart1;
    private javax.swing.JLabel lblStart2;
    private javax.swing.JLabel lblStart3;
    private javax.swing.JLabel lblStart4;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentId;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelContent1;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelTable;
    private javax.swing.JPanel panelTop;
    public javax.swing.JPanel pnlEdit;
    public javax.swing.JPanel pnlSearch;
    private javax.swing.JRadioButton radioAll;
    private javax.swing.JRadioButton radioFemaleEdit;
    private javax.swing.JRadioButton radioFemaleSearch;
    private javax.swing.JRadioButton radioMaleEdit;
    private javax.swing.JRadioButton radioMaleSearch;
    private javax.swing.JSeparator sepaAddStu;
    private javax.swing.JSeparator sepaCourse;
    private javax.swing.JScrollPane srcPanelContent;
    private javax.swing.JTable tableContent;
    public javax.swing.JTabbedPane tpStudent;
    private javax.swing.JTextField txtAddressEdit;
    private javax.swing.JTextField txtEmailEdit;
    private javax.swing.JTextField txtFirstNameEdit;
    private javax.swing.JTextField txtFirstNameSearch;
    private javax.swing.JTextField txtIDEdit;
    private javax.swing.JTextField txtImageEdit;
    private javax.swing.JTextField txtLastNameEdit;
    private javax.swing.JTextField txtLastNameSearch;
    private javax.swing.JTextField txtPhoneEdit;
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
