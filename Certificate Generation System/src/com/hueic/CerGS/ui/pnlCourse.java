/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pnlCourse.java
 *
 * Created on Mar 31, 2011, 4:36:53 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.entity.Course;
import java.util.ArrayList;
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
public class pnlCourse extends javax.swing.JPanel {

    private ArrayList<Course> listCourses = new ArrayList<Course>();
    private CourseDAO courseDao;
    TableRowSorter<TableModel> sorter;
    boolean isAdd = false;
    private ObjectTableModel tableModel;
    private JTable headerTable;

    /** Creates new form pnlCourse */
    public pnlCourse() {
        initComponents();
        courseDao = new CourseDAO();
        listCourses = courseDao.readByAll();
        loadData(listCourses);
        if (!listCourses.isEmpty()) {
            loadDetails(listCourses.get(0));
        }
    }

    public void loadData(ArrayList<Course> listCourses) {

        ColumnData[] columns = {
            new ColumnData("ID", 100, SwingConstants.LEFT, 1),
            new ColumnData("Name", 140, SwingConstants.LEFT, 2),
            new ColumnData("Total Fees", 170, SwingConstants.LEFT, 3),
            new ColumnData("Status", 260, SwingConstants.LEFT, 4)
        };
        tableModel = new ObjectTableModel(tableContent, columns, listCourses);
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
        srcPanelCourse.setRowHeader(viewport);
        srcPanelCourse.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    public void loadDetails(Course course) {
        txtID.setText(course.getId().trim());
        txtName.setText(course.getName().trim());
        txtTotalFees.setText(String.valueOf(course.getTotalFees()).trim());
        if (course.getStatus() == 0) {
            radioDisable.setSelected(true);
        } else {
            radioEnable.setSelected(true);
        }
    }

    public Course find(String value) {
        for (int i = 0; i < listCourses.size(); i++) {
            if (listCourses.get(i).getId().equalsIgnoreCase(value)) {
                return listCourses.get(i);
            }
        }
        return null;
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

        btnGStatus1 = new javax.swing.ButtonGroup();
        btnGStatus2 = new javax.swing.ButtonGroup();
        tpCourse = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        panelRight = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        sepaCourse = new javax.swing.JSeparator();
        lblName = new javax.swing.JLabel();
        lblTotalFees = new javax.swing.JLabel();
        txtTotalFees = new javax.swing.JTextField();
        panelButton = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        radioEnable = new javax.swing.JRadioButton();
        radioDisable = new javax.swing.JRadioButton();
        txtName = new javax.swing.JTextField();
        pnlSearch = new javax.swing.JPanel();
        panelRightSearch = new javax.swing.JPanel();
        lblTitleSearch = new javax.swing.JLabel();
        sepaCourseSearch = new javax.swing.JSeparator();
        lblNameSearch = new javax.swing.JLabel();
        lblTotalFeesSearch = new javax.swing.JLabel();
        txtTotalFeesSearch = new javax.swing.JTextField();
        panelButtonSearch = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        lblIDSearch = new javax.swing.JLabel();
        txtIDSearch = new javax.swing.JTextField();
        lblStatusSearch = new javax.swing.JLabel();
        radioEnableSearch = new javax.swing.JRadioButton();
        radioDisableSearch = new javax.swing.JRadioButton();
        txtNameSearch = new javax.swing.JTextField();
        panelLeft = new javax.swing.JPanel();
        srcPanelCourse = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        tpCourse.setMinimumSize(new java.awt.Dimension(860, 200));
        tpCourse.setPreferredSize(new java.awt.Dimension(860, 200));

        pnlEdit.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlEdit.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlEdit.setLayout(new java.awt.GridBagLayout());

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setMinimumSize(new java.awt.Dimension(860, 200));
        panelRight.setPreferredSize(new java.awt.Dimension(860, 200));
        panelRight.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Course");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(lblTitle, gridBagConstraints);

        sepaCourse.setPreferredSize(new java.awt.Dimension(650, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelRight.add(sepaCourse, gridBagConstraints);

        lblName.setForeground(new java.awt.Color(3, 3, 3));
        lblName.setText("Name course:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblName, gridBagConstraints);

        lblTotalFees.setForeground(new java.awt.Color(3, 3, 3));
        lblTotalFees.setText("Total Fees:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelRight.add(lblTotalFees, gridBagConstraints);

        txtTotalFees.setEditable(false);
        txtTotalFees.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtTotalFees, gridBagConstraints);

        panelButton.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnAdd.setMinimumSize(new java.awt.Dimension(75, 23));
        btnAdd.setPreferredSize(new java.awt.Dimension(75, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        panelButton.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnUpdate.setMaximumSize(new java.awt.Dimension(77, 25));
        btnUpdate.setMinimumSize(new java.awt.Dimension(77, 23));
        btnUpdate.setPreferredSize(new java.awt.Dimension(77, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panelButton.add(btnUpdate);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnDelete.setMinimumSize(new java.awt.Dimension(75, 23));
        btnDelete.setPreferredSize(new java.awt.Dimension(75, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panelButton.add(btnDelete);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel.setMinimumSize(new java.awt.Dimension(75, 23));
        btnCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        panelButton.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(panelButton, gridBagConstraints);

        lblID.setForeground(new java.awt.Color(3, 3, 3));
        lblID.setText("Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblID, gridBagConstraints);

        txtID.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtID, gridBagConstraints);

        lblStatus.setForeground(new java.awt.Color(3, 3, 3));
        lblStatus.setText("Status:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelRight.add(lblStatus, gridBagConstraints);

        radioEnable.setBackground(new java.awt.Color(255, 255, 255));
        btnGStatus1.add(radioEnable);
        radioEnable.setForeground(new java.awt.Color(3, 3, 3));
        radioEnable.setText("Enable");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(radioEnable, gridBagConstraints);

        radioDisable.setBackground(new java.awt.Color(255, 255, 255));
        btnGStatus1.add(radioDisable);
        radioDisable.setForeground(new java.awt.Color(3, 3, 3));
        radioDisable.setText("Disable");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(radioDisable, gridBagConstraints);

        txtName.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtName, gridBagConstraints);

        pnlEdit.add(panelRight, new java.awt.GridBagConstraints());

        tpCourse.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlSearch.setLayout(new java.awt.GridBagLayout());

        panelRightSearch.setBackground(new java.awt.Color(255, 255, 255));
        panelRightSearch.setMinimumSize(new java.awt.Dimension(860, 200));
        panelRightSearch.setPreferredSize(new java.awt.Dimension(860, 200));
        panelRightSearch.setLayout(new java.awt.GridBagLayout());

        lblTitleSearch.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitleSearch.setForeground(new java.awt.Color(102, 0, 102));
        lblTitleSearch.setText("Information Course");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRightSearch.add(lblTitleSearch, gridBagConstraints);

        sepaCourseSearch.setPreferredSize(new java.awt.Dimension(650, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelRightSearch.add(sepaCourseSearch, gridBagConstraints);

        lblNameSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblNameSearch.setText("Name course:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(lblNameSearch, gridBagConstraints);

        lblTotalFeesSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblTotalFeesSearch.setText("Total Fees:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelRightSearch.add(lblTotalFeesSearch, gridBagConstraints);

        txtTotalFeesSearch.setEditable(false);
        txtTotalFeesSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(txtTotalFeesSearch, gridBagConstraints);

        panelButtonSearch.setBackground(new java.awt.Color(255, 255, 255));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReset.setPreferredSize(new java.awt.Dimension(75, 23));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        panelButtonSearch.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(panelButtonSearch, gridBagConstraints);

        lblIDSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblIDSearch.setText("Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(lblIDSearch, gridBagConstraints);

        txtIDSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(txtIDSearch, gridBagConstraints);

        lblStatusSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblStatusSearch.setText("Status:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelRightSearch.add(lblStatusSearch, gridBagConstraints);

        radioEnableSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnGStatus2.add(radioEnableSearch);
        radioEnableSearch.setForeground(new java.awt.Color(3, 3, 3));
        radioEnableSearch.setText("Enable");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(radioEnableSearch, gridBagConstraints);

        radioDisableSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnGStatus2.add(radioDisableSearch);
        radioDisableSearch.setForeground(new java.awt.Color(3, 3, 3));
        radioDisableSearch.setText("Disable");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(radioDisableSearch, gridBagConstraints);

        txtNameSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(txtNameSearch, gridBagConstraints);

        pnlSearch.add(panelRightSearch, new java.awt.GridBagConstraints());

        tpCourse.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpCourse, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Course", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelLeft.setMinimumSize(new java.awt.Dimension(860, 400));
        panelLeft.setPreferredSize(new java.awt.Dimension(860, 400));
        panelLeft.setRequestFocusEnabled(false);
        panelLeft.setLayout(new java.awt.GridBagLayout());

        srcPanelCourse.setMinimumSize(new java.awt.Dimension(840, 340));
        srcPanelCourse.setPreferredSize(new java.awt.Dimension(840, 340));

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
        tableContent.setMinimumSize(new java.awt.Dimension(770, 340));
        tableContent.setPreferredSize(new java.awt.Dimension(770, 340));
        tableContent.getTableHeader().setReorderingAllowed(false);
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContentMouseClicked(evt);
            }
        });
        srcPanelCourse.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(srcPanelCourse, gridBagConstraints);

        filterText.setMinimumSize(new java.awt.Dimension(200, 20));
        filterText.setPreferredSize(new java.awt.Dimension(200, 20));
        filterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filterTextKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 540, 5, 5);
        panelLeft.add(filterText, gridBagConstraints);

        btnFilter.setText("Filter");
        btnFilter.setMaximumSize(new java.awt.Dimension(100, 20));
        btnFilter.setMinimumSize(new java.awt.Dimension(75, 23));
        btnFilter.setPreferredSize(new java.awt.Dimension(75, 23));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(btnFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelLeft, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:

        try {
            if (!isAdd) {
                isAdd = true;
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
                txtTotalFees.setEditable(true);

                txtID.setText("");
                txtName.setText("");
                txtTotalFees.setText("");
            } else {
                String id = txtID.getText();
                String name = txtName.getText();
                float totalFees = Float.parseFloat(txtTotalFees.getText());
                int status = 0;
                if (radioEnable.isSelected()) {
                    status = 1;

                } else {
                    status = 0;
                }
                Course course = new Course(id, name, totalFees, status);
                if (courseDao.create(course)) {
                    JOptionPane.showMessageDialog(this, courseDao.getLastError(), "Create Course", JOptionPane.INFORMATION_MESSAGE);
                    listCourses.remove(find(course.getId()));
                    listCourses.add(course);
                    loadData(listCourses);
                    loadDetails(course);
                } else {
                    JOptionPane.showMessageDialog(this, courseDao.getLastError(), "Create Course", JOptionPane.ERROR_MESSAGE);
                }
                isAdd = false;
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
                txtTotalFees.setEditable(false);
            }
        } catch (Exception e) {
        }
}//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            String id = txtID.getText();
            String name = txtName.getText();
            float totalFees = Float.parseFloat(txtTotalFees.getText());
            int status = 0;
            if (radioEnable.isSelected()) {
                status = 1;
            } else {
                status = 0;
            }
            Course course = new Course(id, name, totalFees, status);
            if (courseDao.update(course)) {
                listCourses.remove(find(course.getId()));
                listCourses.add(course);
                loadData(listCourses);
                loadDetails(course);
                JOptionPane.showMessageDialog(this, courseDao.getLastError(), "Update Course", JOptionPane.INFORMATION_MESSAGE);

            } else {
                System.out.println(courseDao.getLastError());
                JOptionPane.showMessageDialog(this, courseDao.getLastError(), "Update Course", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String id = txtID.getText();
        if (courseDao.delete(id)) {
            listCourses.remove(find(id));
            loadData(listCourses);
            if (!listCourses.isEmpty()) {
                loadDetails(listCourses.get(0));
            }
            JOptionPane.showMessageDialog(this, courseDao.getLastError(), "Delete Course", JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            JOptionPane.showMessageDialog(this, courseDao.getLastError(), "Delete Course", JOptionPane.ERROR_MESSAGE, null);
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        if (isAdd) {
            isAdd = false;
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
        } else {
        }
}//GEN-LAST:event_btnCancelActionPerformed

    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        // TODO add your handling code here:
        int index = tableContent.getSelectedRow();
        if (index != -1) {
            String id = tableContent.getValueAt(index, 0).toString();
            Course course = find(id);
            if (course != null) {
                loadDetails(course);
            }
        }
}//GEN-LAST:event_tableContentMouseClicked

    private void filterTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTextKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btnFilterActionPerformed(null);
        }
}//GEN-LAST:event_filterTextKeyPressed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:

        if (!listCourses.isEmpty()) {
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

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.ButtonGroup btnGStatus1;
    private javax.swing.ButtonGroup btnGStatus2;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIDSearch;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameSearch;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatusSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleSearch;
    private javax.swing.JLabel lblTotalFees;
    private javax.swing.JLabel lblTotalFeesSearch;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelButtonSearch;
    private javax.swing.JPanel panelLeft;
    public javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelRightSearch;
    public javax.swing.JPanel pnlEdit;
    public javax.swing.JPanel pnlSearch;
    private javax.swing.JRadioButton radioDisable;
    private javax.swing.JRadioButton radioDisableSearch;
    private javax.swing.JRadioButton radioEnable;
    private javax.swing.JRadioButton radioEnableSearch;
    private javax.swing.JSeparator sepaCourse;
    private javax.swing.JSeparator sepaCourseSearch;
    private javax.swing.JScrollPane srcPanelCourse;
    private javax.swing.JTable tableContent;
    public javax.swing.JTabbedPane tpCourse;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDSearch;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameSearch;
    private javax.swing.JTextField txtTotalFees;
    private javax.swing.JTextField txtTotalFeesSearch;
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
