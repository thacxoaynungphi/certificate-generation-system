/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pnlEmployee.java
 *
 * Created on Mar 31, 2011, 7:02:49 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.LoadImage;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.EmployeeDAO;
import com.hueic.CerGS.entity.Employee;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
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
public class pnlEmployee extends javax.swing.JPanel {

    private ArrayList<Employee> listEmp = new ArrayList<Employee>();
    private EmployeeDAO empDao;
    private boolean isAdd;
    private boolean isUpdate;
    ArrayList<Employee> filter = null;
    TableRowSorter<TableModel> sorter;
    private ObjectTableModel tableModel;
    private JTable headerTable;
    frmMain frm;

    /** Creates new form pnlEmployee */
    public pnlEmployee() {
        initComponents();
        isAdd = false;
        btnCancelEdit.setVisible(false);
        empDao = new EmployeeDAO();
        listEmp = empDao.readByAll();
        if (!listEmp.isEmpty()) {
            loadData(listEmp);
            loadDetails(listEmp.get(0));
        }
    }

    public pnlEmployee(frmMain frm) {
        initComponents();
        this.frm = frm;
        isAdd = false;
        btnCancelEdit.setVisible(false);
        empDao = new EmployeeDAO();
        listEmp = empDao.readByAll();
        if (!listEmp.isEmpty()) {
            loadData(listEmp);
            loadDetails(listEmp.get(0));
        }
    }

    public void loadData(ArrayList<Employee> listEmp) {

        filter = new ArrayList<Employee>();
        for (Employee emp : listEmp) {
            if (emp.getId().toLowerCase().matches(".*" + txtEmployeeIdSearch.getText().trim().toLowerCase() + ".*")
                    && emp.getFirstName().toLowerCase().matches(".*" + txtFirstNameSearch.getText().trim().toLowerCase() + ".*")
                    && emp.getLastName().toLowerCase().matches(".*" + txtLastNameSearch.getText().trim().toLowerCase() + ".*")) {
                // if(dateChooserDateEnd.getDate() != null && dateChooserDateStart.getDate() != null)
                //Chua de che do ngay va gender
                filter.add(emp);
            }
        }
        if (!filter.isEmpty()) {
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
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContentMouseClicked(evt);
            }
        });
        sorter = new TableRowSorter<TableModel>(tableModel);
        tableContent.setRowSorter(sorter);
        lblCount.setText(String.valueOf(listEmp.size()));
        headerTable = tableModel.getHeaderTable();
        // Create numbering column
        headerTable.createDefaultColumnsFromModel();
        tableContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Put it in a viewport that we can control a bit
        JViewport viewport = new JViewport();
        // Display numbering column
        viewport.setView(headerTable);
        viewport.setPreferredSize(headerTable.getMaximumSize());
        srcPaneEmployee.setRowHeader(viewport);
        srcPaneEmployee.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    public boolean isExist(Employee emp) {
        for (int i = 0; i < listEmp.size(); i++) {
            if (listEmp.get(i).getId().equalsIgnoreCase(emp.getId())) {
                return false;
            }
        }
        return true;
    }

    public void resetEditDetails() {
        txtID.setText("");
        txtFirstNameEdit.setText("");
        txtLastNameEdit.setText("");
        txtEmailEdit.setText("");
        dateChBirthdayEdit.setDate(null);
        txtPhoneEdit.setText("");
        txtAddressEdit.setText("");
        dateChBeginWorkEdit.setDate(null);
        txtImageEdit.setText("");
        lblImage2.setIcon(null);
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
        tpEmployee = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        pnlTop1 = new javax.swing.JPanel();
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
        pnlButtonEdit = new javax.swing.JPanel();
        btnAddEdit = new javax.swing.JButton();
        btnUpdateEdit = new javax.swing.JButton();
        btnDeleteEdit = new javax.swing.JButton();
        btnCancelEdit = new javax.swing.JButton();
        lblStart1 = new javax.swing.JLabel();
        lblStart2 = new javax.swing.JLabel();
        lblStart3 = new javax.swing.JLabel();
        lblStart4 = new javax.swing.JLabel();
        lblEmployeeID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblStart6 = new javax.swing.JLabel();
        dateChBirthdayEdit = new com.toedter.calendar.JDateChooser();
        lblBeginwork = new javax.swing.JLabel();
        dateChBeginWorkEdit = new com.toedter.calendar.JDateChooser();
        lblPhone = new javax.swing.JLabel();
        txtPhoneEdit = new javax.swing.JTextField();
        pnlSearch = new javax.swing.JPanel();
        pnlTop2 = new javax.swing.JPanel();
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
        pnlButtonSearch = new javax.swing.JPanel();
        btnResetSearch = new javax.swing.JButton();
        txtEmployeeIdSearch = new javax.swing.JTextField();
        pnlDown = new javax.swing.JPanel();
        panelDisplay = new javax.swing.JPanel();
        lblHienthi = new javax.swing.JLabel();
        lblCount = new javax.swing.JLabel();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        lblEnterFilter = new javax.swing.JLabel();
        panelContent = new javax.swing.JPanel();
        srcPaneEmployee = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        pnlButtonReport = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.GridBagLayout());

        tpEmployee.setMinimumSize(new java.awt.Dimension(860, 320));
        tpEmployee.setPreferredSize(new java.awt.Dimension(860, 320));

        pnlEdit.setLayout(new java.awt.GridBagLayout());

        pnlTop1.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop1.setMinimumSize(new java.awt.Dimension(860, 300));
        pnlTop1.setPreferredSize(new java.awt.Dimension(860, 300));
        pnlTop1.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Employee");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlTop1.add(lblTitle, gridBagConstraints);

        sepaAddStu.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlTop1.add(sepaAddStu, gridBagConstraints);

        lblFirstname.setForeground(new java.awt.Color(3, 3, 3));
        lblFirstname.setText("Firstname:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblFirstname, gridBagConstraints);

        lblLastname.setForeground(new java.awt.Color(3, 3, 3));
        lblLastname.setText("Lastname:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblLastname, gridBagConstraints);

        lblGender.setForeground(new java.awt.Color(3, 3, 3));
        lblGender.setText("Gender:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblGender, gridBagConstraints);

        lblBirthday.setForeground(new java.awt.Color(3, 3, 3));
        lblBirthday.setText("Birthday:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblBirthday, gridBagConstraints);

        lblEmail.setForeground(new java.awt.Color(3, 3, 3));
        lblEmail.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblEmail, gridBagConstraints);

        lblAddress.setForeground(new java.awt.Color(3, 3, 3));
        lblAddress.setText("Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop1.add(lblAddress, gridBagConstraints);

        lblImage1.setForeground(new java.awt.Color(3, 3, 3));
        lblImage1.setText("Image:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop1.add(lblImage1, gridBagConstraints);

        lblImage2.setMaximumSize(new java.awt.Dimension(87, 115));
        lblImage2.setMinimumSize(new java.awt.Dimension(87, 115));
        lblImage2.setPreferredSize(new java.awt.Dimension(87, 115));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        pnlTop1.add(lblImage2, gridBagConstraints);

        txtFirstNameEdit.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtFirstNameEdit, gridBagConstraints);

        txtLastNameEdit.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtLastNameEdit, gridBagConstraints);

        radioMaleEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnGGender1.add(radioMaleEdit);
        radioMaleEdit.setForeground(new java.awt.Color(3, 3, 3));
        radioMaleEdit.setSelected(true);
        radioMaleEdit.setText("Male");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(radioMaleEdit, gridBagConstraints);

        radioFemaleEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnGGender1.add(radioFemaleEdit);
        radioFemaleEdit.setForeground(new java.awt.Color(3, 3, 3));
        radioFemaleEdit.setText("Female");
        radioFemaleEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFemaleEditActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(radioFemaleEdit, gridBagConstraints);

        txtEmailEdit.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtEmailEdit, gridBagConstraints);

        txtAddressEdit.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtAddressEdit, gridBagConstraints);

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
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        pnlTop1.add(btnBrowseEdit, gridBagConstraints);

        txtImageEdit.setPreferredSize(new java.awt.Dimension(130, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtImageEdit, gridBagConstraints);

        pnlButtonEdit.setBackground(new java.awt.Color(255, 255, 255));

        btnAddEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnAddEdit.setText("Add");
        btnAddEdit.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnAddEdit.setPreferredSize(new java.awt.Dimension(75, 23));
        btnAddEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEditActionPerformed(evt);
            }
        });
        pnlButtonEdit.add(btnAddEdit);

        btnUpdateEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnUpdateEdit.setText("Update");
        btnUpdateEdit.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnUpdateEdit.setPreferredSize(new java.awt.Dimension(75, 23));
        btnUpdateEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateEditActionPerformed(evt);
            }
        });
        pnlButtonEdit.add(btnUpdateEdit);

        btnDeleteEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        btnDeleteEdit.setText("Delete");
        btnDeleteEdit.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnDeleteEdit.setMaximumSize(new java.awt.Dimension(75, 23));
        btnDeleteEdit.setMinimumSize(new java.awt.Dimension(75, 23));
        btnDeleteEdit.setPreferredSize(new java.awt.Dimension(75, 23));
        btnDeleteEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEditActionPerformed(evt);
            }
        });
        pnlButtonEdit.add(btnDeleteEdit);

        btnCancelEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancelEdit.setText("Cancel");
        btnCancelEdit.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancelEdit.setPreferredSize(new java.awt.Dimension(75, 23));
        btnCancelEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEditActionPerformed(evt);
            }
        });
        pnlButtonEdit.add(btnCancelEdit);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlTop1.add(pnlButtonEdit, gridBagConstraints);

        lblStart1.setForeground(new java.awt.Color(255, 0, 0));
        lblStart1.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblStart1, gridBagConstraints);

        lblStart2.setForeground(new java.awt.Color(255, 0, 0));
        lblStart2.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblStart2, gridBagConstraints);

        lblStart3.setForeground(new java.awt.Color(255, 0, 0));
        lblStart3.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblStart3, gridBagConstraints);

        lblStart4.setForeground(new java.awt.Color(255, 0, 0));
        lblStart4.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblStart4, gridBagConstraints);

        lblEmployeeID.setForeground(new java.awt.Color(3, 3, 3));
        lblEmployeeID.setText("Employee ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblEmployeeID, gridBagConstraints);

        txtID.setEnabled(false);
        txtID.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtID, gridBagConstraints);

        lblStart6.setForeground(new java.awt.Color(255, 0, 0));
        lblStart6.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblStart6, gridBagConstraints);

        dateChBirthdayEdit.setDateFormatString("MM/dd/yyyy");
        dateChBirthdayEdit.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(dateChBirthdayEdit, gridBagConstraints);

        lblBeginwork.setForeground(new java.awt.Color(3, 3, 3));
        lblBeginwork.setText("Begin work:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop1.add(lblBeginwork, gridBagConstraints);

        dateChBeginWorkEdit.setDateFormatString("MM/dd/yyyy");
        dateChBeginWorkEdit.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(dateChBeginWorkEdit, gridBagConstraints);

        lblPhone.setForeground(new java.awt.Color(3, 3, 3));
        lblPhone.setText("Phone: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop1.add(lblPhone, gridBagConstraints);

        txtPhoneEdit.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtPhoneEdit, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlEdit.add(pnlTop1, gridBagConstraints);

        tpEmployee.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlSearch.setLayout(new java.awt.GridBagLayout());

        pnlTop2.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop2.setMinimumSize(new java.awt.Dimension(860, 300));
        pnlTop2.setPreferredSize(new java.awt.Dimension(860, 300));
        pnlTop2.setLayout(new java.awt.GridBagLayout());

        lblStudentId.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentId.setText("Employee ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(lblStudentId, gridBagConstraints);

        lblFirstName.setForeground(new java.awt.Color(3, 3, 3));
        lblFirstName.setText("First Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(lblFirstName, gridBagConstraints);

        txtFirstNameSearch.setMinimumSize(new java.awt.Dimension(200, 20));
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
        pnlTop2.add(txtFirstNameSearch, gridBagConstraints);

        lblLastName.setForeground(new java.awt.Color(3, 3, 3));
        lblLastName.setText("Last Name: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(lblLastName, gridBagConstraints);

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
        pnlTop2.add(txtLastNameSearch, gridBagConstraints);

        lblBirthday1.setForeground(new java.awt.Color(3, 3, 3));
        lblBirthday1.setText("Birthday: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop2.add(lblBirthday1, gridBagConstraints);

        dateChooserDateStartSearch.setDateFormatString("MM/dd/yyyy");
        dateChooserDateStartSearch.setMinimumSize(new java.awt.Dimension(150, 20));
        dateChooserDateStartSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(dateChooserDateStartSearch, gridBagConstraints);

        dateChooserDateEndSearch.setDateFormatString("MM/dd/yyyy");
        dateChooserDateEndSearch.setMinimumSize(new java.awt.Dimension(150, 20));
        dateChooserDateEndSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(dateChooserDateEndSearch, gridBagConstraints);

        lblGender1.setForeground(new java.awt.Color(3, 3, 3));
        lblGender1.setText("Gender:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop2.add(lblGender1, gridBagConstraints);

        radioMaleSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnGGender2.add(radioMaleSearch);
        radioMaleSearch.setForeground(new java.awt.Color(3, 3, 3));
        radioMaleSearch.setText("Male");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(radioMaleSearch, gridBagConstraints);

        radioFemaleSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnGGender2.add(radioFemaleSearch);
        radioFemaleSearch.setForeground(new java.awt.Color(3, 3, 3));
        radioFemaleSearch.setText("FeMale");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(radioFemaleSearch, gridBagConstraints);

        lblTitle1.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle1.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle1.setText("Information Employee");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlTop2.add(lblTitle1, gridBagConstraints);

        sepaCourse.setMinimumSize(new java.awt.Dimension(150, 10));
        sepaCourse.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        pnlTop2.add(sepaCourse, gridBagConstraints);

        pnlButtonSearch.setBackground(new java.awt.Color(255, 255, 255));

        btnResetSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnResetSearch.setText("Reset");
        btnResetSearch.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnResetSearch.setMaximumSize(new java.awt.Dimension(75, 23));
        btnResetSearch.setMinimumSize(new java.awt.Dimension(75, 23));
        btnResetSearch.setPreferredSize(new java.awt.Dimension(75, 23));
        btnResetSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetSearchActionPerformed(evt);
            }
        });
        pnlButtonSearch.add(btnResetSearch);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 5, 5);
        pnlTop2.add(pnlButtonSearch, gridBagConstraints);

        txtEmployeeIdSearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtEmployeeIdSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtEmployeeIdSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEmployeeIdSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(txtEmployeeIdSearch, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlSearch.add(pnlTop2, gridBagConstraints);

        tpEmployee.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpEmployee, gridBagConstraints);

        pnlDown.setBackground(new java.awt.Color(255, 255, 255));
        pnlDown.setMinimumSize(new java.awt.Dimension(860, 280));
        pnlDown.setPreferredSize(new java.awt.Dimension(860, 280));
        pnlDown.setLayout(new java.awt.GridBagLayout());

        panelDisplay.setBackground(new java.awt.Color(255, 255, 255));
        panelDisplay.setMinimumSize(new java.awt.Dimension(860, 30));
        panelDisplay.setPreferredSize(new java.awt.Dimension(860, 30));
        panelDisplay.setLayout(new java.awt.GridBagLayout());

        lblHienthi.setForeground(new java.awt.Color(3, 3, 3));
        lblHienthi.setText("Total employees:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDisplay.add(lblHienthi, gridBagConstraints);

        lblCount.setBackground(new java.awt.Color(255, 255, 255));
        lblCount.setForeground(new java.awt.Color(3, 3, 3));
        lblCount.setMaximumSize(new java.awt.Dimension(20, 14));
        lblCount.setMinimumSize(new java.awt.Dimension(20, 14));
        lblCount.setPreferredSize(new java.awt.Dimension(20, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDisplay.add(lblCount, gridBagConstraints);

        filterText.setMinimumSize(new java.awt.Dimension(200, 20));
        filterText.setPreferredSize(new java.awt.Dimension(200, 20));
        filterText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                filterTextMouseReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDisplay.add(filterText, gridBagConstraints);

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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDisplay.add(btnFilter, gridBagConstraints);

        lblEnterFilter.setText("Enter filter:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 360, 5, 5);
        panelDisplay.add(lblEnterFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDown.add(panelDisplay, gridBagConstraints);

        panelContent.setBackground(new java.awt.Color(255, 255, 255));
        panelContent.setMinimumSize(new java.awt.Dimension(860, 250));
        panelContent.setPreferredSize(new java.awt.Dimension(860, 250));
        panelContent.setLayout(new java.awt.GridBagLayout());

        srcPaneEmployee.setMinimumSize(new java.awt.Dimension(840, 200));
        srcPaneEmployee.setOpaque(false);
        srcPaneEmployee.setPreferredSize(new java.awt.Dimension(840, 200));

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
        tableContent.setMinimumSize(new java.awt.Dimension(770, 200));
        tableContent.setPreferredSize(new java.awt.Dimension(770, 200));
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContentMouseClicked(evt);
            }
        });
        srcPaneEmployee.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelContent.add(srcPaneEmployee, gridBagConstraints);

        pnlButtonReport.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        jButton1.setText("Report Details");
        jButton1.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlButtonReport.add(jButton1);

        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        btnReport.setText("Report");
        btnReport.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReport.setMaximumSize(new java.awt.Dimension(75, 23));
        btnReport.setMinimumSize(new java.awt.Dimension(75, 23));
        btnReport.setPreferredSize(new java.awt.Dimension(75, 23));
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });
        pnlButtonReport.add(btnReport);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelContent.add(pnlButtonReport, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDown.add(panelContent, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(pnlDown, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseEditActionPerformed
        // TODO add your handling code here:
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
                    LoadImage.copyImage(file.getPath(), System.getProperty("user.dir") + "/avatar/" + file.getName());
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

    private void btnAddEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEditActionPerformed
        try {
            // TODO add your handling code here:
            if (!isAdd) {
                isAdd = true;
                txtID.setEnabled(true);
                btnCancelEdit.setVisible(false);
              //  resetEditDetails();
            } else {
                isAdd = false;
                txtID.setEnabled(false);
                btnCancelEdit.setVisible(false);

                Employee emp = new Employee();
                emp.setId(txtID.getText());
                emp.setFirstName(txtFirstNameEdit.getText());
                emp.setLastName(txtLastNameEdit.getText());
                emp.setBirthDay(new java.sql.Date(dateChBirthdayEdit.getDate().getTime()));
                if (radioMaleEdit.isSelected()) {
                    emp.setGender(0);
                } else if (radioFemaleEdit.isSelected()) {
                    emp.setGender(1);
                }
                emp.setPhone(txtPhoneEdit.getText());
                emp.setEmail(txtEmailEdit.getText());
                emp.setAddress(txtAddressEdit.getText());
                File file = new File(txtImageEdit.getText());
                String name = file.getName();
                String extension;
                int dotPos = name.lastIndexOf(".");
                extension = name.substring(dotPos);
                LoadImage.copyImage(file.getPath(), System.getProperty("user.dir") + "/avatar/" + emp.getId() + extension);
                emp.setImage(emp.getId() + extension);
                emp.setBeginWork(new java.sql.Date(dateChBeginWorkEdit.getDate().getTime()));
                emp.setStatus(1);

                EmployeeDAO empDao = new EmployeeDAO();
                if (empDao.create(emp)) {
                    listEmp.add(emp);
                    loadData(listEmp);
                    JOptionPane.showMessageDialog(this, empDao.getLastError(), "Employee Add", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, empDao.getLastError(), "Employee Add", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, ex.toString() + "Bien", "Employee Update", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnAddEditActionPerformed

    private void btnUpdateEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateEditActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Employee emp = new Employee();
            emp.setId(txtID.getText());
            emp.setFirstName(txtFirstNameEdit.getText());
            emp.setLastName(txtLastNameEdit.getText());
            emp.setBirthDay(new java.sql.Date(dateChBirthdayEdit.getDate().getTime()));
            emp.setBeginWork(new java.sql.Date(dateChBeginWorkEdit.getDate().getTime()));
            if (radioMaleEdit.isSelected()) {
                emp.setGender(0);

            } else if (radioFemaleEdit.isSelected()) {
                emp.setGender(1);

            }
            emp.setPhone(txtPhoneEdit.getText());
            emp.setEmail(txtEmailEdit.getText());
            emp.setAddress(txtAddressEdit.getText());
            File file = new File(txtImageEdit.getText());
            String name = file.getName();
            String extension;
            int dotPos = name.lastIndexOf(".");
            extension = name.substring(dotPos);
            LoadImage.copyImage(file.getPath(), System.getProperty("user.dir") + "/avatar/" + emp.getId() + extension);
            emp.setImage(emp.getId() + extension);
            emp.setStatus(1);
            EmployeeDAO empDao = new EmployeeDAO();
            if (empDao.update(emp)) {
                listEmp = empDao.readByAll();
                loadData(listEmp);
                JOptionPane.showMessageDialog(this, empDao.getLastError(), "Employee Add", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, empDao.getLastError(), "Employee Add", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Employee Update", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnUpdateEditActionPerformed

    private void btnCancelEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEditActionPerformed
        // TODO add your handling code here:
        if (isAdd) {
            isAdd = false;
            txtID.setEnabled(false);
            loadDetails(listEmp.get(0));
            btnCancelEdit.setVisible(false);
        }
}//GEN-LAST:event_btnCancelEditActionPerformed

    private void btnResetSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetSearchActionPerformed
        // TODO add your handling code here:

        txtEmployeeIdSearch.setText(null);
        txtFirstNameSearch.setText(null);
        txtLastNameSearch.setText(null);
        dateChooserDateEndSearch.setDate(null);
        dateChooserDateStartSearch.setDate(null);
        radioMaleSearch.setSelected(true);
}//GEN-LAST:event_btnResetSearchActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        startFilter();
}//GEN-LAST:event_btnFilterActionPerformed

    public void startFilter() {
        if (listEmp.size() != 0) {
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

    public Employee find(String value) {
        for (Employee employee : listEmp) {
            if (employee.getId().equals(value)) {
                return employee;
            }
        }
        return null;
    }

    public void loadDetails(Employee emp) {
        txtID.setText(emp.getId());
        txtFirstNameEdit.setText(emp.getFirstName());
        txtLastNameEdit.setText(emp.getLastName());
        try {
            dateChBirthdayEdit.setDate(emp.getBirthDay());
        } catch (Exception ex) {
        }
        int gender = emp.getGender();
        if (gender == 0) {
            radioMaleEdit.setSelected(true);

        } else {
            radioFemaleEdit.setSelected(true);

        }
        txtPhoneEdit.setText(emp.getPhone());
        txtEmailEdit.setText(emp.getEmail());
        txtAddressEdit.setText(emp.getAddress());
        txtImageEdit.setText(emp.getImage());
        if (emp.getImage().length() != 0) {
            lblImage2.setIcon(null);
            lblImage2.setIcon(new ImageIcon(System.getProperty("user.dir") + "/avatar/" + emp.getImage()));
        } else {
            //TODO: hien thi anh khi khong co avatar
            lblImage2.setIcon(new ImageIcon(System.getProperty("user.dir") + "/avatar/no images.jpg"));
        }
        try {
            dateChBeginWorkEdit.setDate(emp.getBeginWork());
        } catch (Exception ex) {
        }
    }

    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        // TODO add your handling code here:
        int index = tableContent.getSelectedRow();
        if (index != -1) {
            String value = (String) tableContent.getValueAt(index, 0);
            Employee emp = find(value);
            if (emp != null) {
                loadDetails(emp);
            }
        }
}//GEN-LAST:event_tableContentMouseClicked

    private void filterTextMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterTextMouseReleased
        // TODO add your handling code here:
        startFilter();
    }//GEN-LAST:event_filterTextMouseReleased

    private void txtEmployeeIdSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEmployeeIdSearchCaretUpdate
        // TODO add your handling code here:
        if(txtEmployeeIdSearch.getText().isEmpty()) loadData(empDao.readByAll());
        else loadData(listEmp);
    }//GEN-LAST:event_txtEmployeeIdSearchCaretUpdate

    private void txtFirstNameSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFirstNameSearchCaretUpdate
        // TODO add your handling code here:
        loadData(listEmp);
    }//GEN-LAST:event_txtFirstNameSearchCaretUpdate

    private void txtLastNameSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtLastNameSearchCaretUpdate
        // TODO add your handling code here:
        loadData(listEmp);
    }//GEN-LAST:event_txtLastNameSearchCaretUpdate

    private void radioFemaleEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFemaleEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioFemaleEditActionPerformed

    private void btnDeleteEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEditActionPerformed
        // TODO add your handling code here:
        String id = txtID.getText();
        if (empDao.delete(id)) {
            listEmp = empDao.readByAll();
            loadData(listEmp);
        }
        JOptionPane.showMessageDialog(this, empDao.getLastError(), "Employee Delete", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnDeleteEditActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
        if (filter.size() != 0) {
            frm.pnlReport.removeAll();
            dlgChooseReport report = new dlgChooseReport(frm, this);
            report.getEmployeeReport(filter);
            report.setVisible(true);
            report.setSize(860, 600);
            frm.pnlReport.add(report);
            frm.tpnBusiness.setSelectedComponent(frm.pnlReport);
        } else {
            JOptionPane.showMessageDialog(this, "No data!", "Report Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnReportActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index = this.tableContent.getSelectedRow();
        if (index != -1) {
            Employee emp = filter.get(index);
            frm.pnlReport.removeAll();
            dlgChooseReport report = new dlgChooseReport(frm, this);
            report.getEmployeeDetailsReport(emp);
            report.setVisible(true);
            report.setSize(860, 600);
            frm.pnlReport.add(report);
            frm.tpnBusiness.setSelectedComponent(frm.pnlReport);
        } else {
            JOptionPane.showMessageDialog(this, "You are choose employee!", "Report details employee", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEdit;
    private javax.swing.JButton btnBrowseEdit;
    private javax.swing.JButton btnCancelEdit;
    private javax.swing.JButton btnDeleteEdit;
    private javax.swing.JButton btnFilter;
    private javax.swing.ButtonGroup btnGGender1;
    private javax.swing.ButtonGroup btnGGender2;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnResetSearch;
    private javax.swing.JButton btnUpdateEdit;
    private com.toedter.calendar.JDateChooser dateChBeginWorkEdit;
    private com.toedter.calendar.JDateChooser dateChBirthdayEdit;
    private com.toedter.calendar.JDateChooser dateChooserDateEndSearch;
    private com.toedter.calendar.JDateChooser dateChooserDateStartSearch;
    private javax.swing.JTextField filterText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBeginwork;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblBirthday1;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmployeeID;
    private javax.swing.JLabel lblEnterFilter;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGender1;
    private javax.swing.JLabel lblHienthi;
    private javax.swing.JLabel lblImage1;
    private javax.swing.JLabel lblImage2;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblStart1;
    private javax.swing.JLabel lblStart2;
    private javax.swing.JLabel lblStart3;
    private javax.swing.JLabel lblStart4;
    private javax.swing.JLabel lblStart6;
    private javax.swing.JLabel lblStudentId;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelDisplay;
    private javax.swing.JPanel pnlButtonEdit;
    private javax.swing.JPanel pnlButtonReport;
    private javax.swing.JPanel pnlButtonSearch;
    private javax.swing.JPanel pnlDown;
    public javax.swing.JPanel pnlEdit;
    public javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlTop1;
    private javax.swing.JPanel pnlTop2;
    private javax.swing.JRadioButton radioFemaleEdit;
    private javax.swing.JRadioButton radioFemaleSearch;
    private javax.swing.JRadioButton radioMaleEdit;
    private javax.swing.JRadioButton radioMaleSearch;
    private javax.swing.JSeparator sepaAddStu;
    private javax.swing.JSeparator sepaCourse;
    private javax.swing.JScrollPane srcPaneEmployee;
    private javax.swing.JTable tableContent;
    public javax.swing.JTabbedPane tpEmployee;
    private javax.swing.JTextField txtAddressEdit;
    private javax.swing.JTextField txtEmailEdit;
    private javax.swing.JTextField txtEmployeeIdSearch;
    private javax.swing.JTextField txtFirstNameEdit;
    private javax.swing.JTextField txtFirstNameSearch;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtImageEdit;
    private javax.swing.JTextField txtLastNameEdit;
    private javax.swing.JTextField txtLastNameSearch;
    private javax.swing.JTextField txtPhoneEdit;
    // End of variables declaration//GEN-END:variables

    String getSelectedType() {
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
