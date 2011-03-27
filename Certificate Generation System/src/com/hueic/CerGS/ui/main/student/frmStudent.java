/*
 * To change this tstudentlate, choose Tools | Tstudentlates
 * and open the tstudentlate in the editor.
 */

/*
 * StudentFrm.java
 *
 * Created on Mar 13, 2011, 5:38:22 PM
 */
package com.hueic.CerGS.ui.main.student;

import com.hueic.CerGS.component.IconSystem;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Student;
import java.awt.AWTEvent;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.swing.CellEditor;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author nhchung
 */
public class frmStudent extends javax.swing.JFrame {

    /** Creates new form StudentFrm */
    private ArrayList<Student> liststudent = new ArrayList<Student>();
    private ArrayList<Student> liststudentTemp = new ArrayList<Student>();
    private ArrayList<Student> liststudentSearch = new ArrayList<Student>();
    private StudentDAO studentDao = new StudentDAO();
    TableRowSorter<TableModel> sorter;

    public frmStudent() {
        initComponents();
        new IconSystem(this);
        setLocationRelativeTo(null);
        liststudent = studentDao.readByAll();
        loadTable(liststudent);
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        tableContent.addMouseListener(new MouseAdapter() {

            private void maybeShowPopup(MouseEvent e) {
                if (e.isPopupTrigger() && tableContent.isEnabled()) {
                    Point p = new Point(e.getX(), e.getY());
                    int col = tableContent.columnAtPoint(p);
                    int row = tableContent.rowAtPoint(p);
// translate table index to model index
                    int mcol = tableContent.getColumn(
                            tableContent.getColumnName(col)).getModelIndex();
                    if (row >= 0 && row < tableContent.getRowCount()) {
                        cancelCellEditing();
                        if (popupMenuTable != null
                                && popupMenuTable.getComponentCount() > 0) {
                            popupMenuTable.show(tableContent, p.x, p.y);
                        }
                    }
                }
            }

            public void mousePressed(MouseEvent e) {
                maybeShowPopup(e);
            }

            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e);
            }
        });
        
    }

    public void loadTable(ArrayList<Student> liststudent) {
        lblCount.setText(String.valueOf(liststudent.size()));
        String[] columns = {"ID", "First Name", "Last Name", "Birthday", "Gender", "Phone"};
        Object[][] rows = new Object[liststudent.size()][6];
        int index = 0;
        for (int i = 0; i < liststudent.size(); i++) {
            Student student = liststudent.get(i);
            rows[index][0] = student.getId();
            rows[index][1] = student.getFirstName();
            rows[index][2] = student.getLastName();
            rows[index][3] = student.getBirthDay();
            rows[index][4] = student.getGender();
            rows[index][5] = student.getPhone();
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
                false, false, false, false, false, false
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
        srcPanelContent.setRowHeader(viewPort);
        srcPanelContent.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, tableContent.getTableHeader());
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

        popupMenuTable = new javax.swing.JPopupMenu();
        menuIAdd = new javax.swing.JMenuItem();
        menuIEdit = new javax.swing.JMenuItem();
        menuIDelete = new javax.swing.JMenuItem();
        mnuISearch = new javax.swing.JMenuItem();
        mnuIDetails = new javax.swing.JMenuItem();
        panelBanner = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        panelMenuRight = new javax.swing.JPanel();
        taskPanelMenu = new com.l2fprod.common.swing.JTaskPane();
        jTaskPaneGroupManagementStudent = new com.l2fprod.common.swing.JTaskPaneGroup();
        linkButtonAddStudent = new com.l2fprod.common.swing.JLinkButton();
        linkButtonEditStudent = new com.l2fprod.common.swing.JLinkButton();
        linkButtonDeleteStudent = new com.l2fprod.common.swing.JLinkButton();
        jLinkButton1 = new com.l2fprod.common.swing.JLinkButton();
        jTaskPaneGroupReport = new com.l2fprod.common.swing.JTaskPaneGroup();
        linkBtnFeesReport = new com.l2fprod.common.swing.JLinkButton();
        linkBtnMarkReport = new com.l2fprod.common.swing.JLinkButton();
        jLinkButton2 = new com.l2fprod.common.swing.JLinkButton();
        jLinkButton3 = new com.l2fprod.common.swing.JLinkButton();
        panelContent = new javax.swing.JPanel();
        panelTop = new javax.swing.JPanel();
        lblHienthi1 = new javax.swing.JLabel();
        lblCount = new javax.swing.JLabel();
        btnFilter = new javax.swing.JButton();
        filterText = new javax.swing.JTextField();
        panelTable = new javax.swing.JPanel();
        srcPanelContent = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        btnImport = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        menuIAdd.setText("Add ");
        menuIAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIAddActionPerformed(evt);
            }
        });
        popupMenuTable.add(menuIAdd);

        menuIEdit.setText("Edit ");
        menuIEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIEditActionPerformed(evt);
            }
        });
        popupMenuTable.add(menuIEdit);

        menuIDelete.setText("Delete ");
        popupMenuTable.add(menuIDelete);

        mnuISearch.setText("Search");
        popupMenuTable.add(mnuISearch);

        mnuIDetails.setText("Details");
        mnuIDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIDetailsActionPerformed(evt);
            }
        });
        popupMenuTable.add(mnuIDetails);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Management Employee");
        setMinimumSize(new java.awt.Dimension(1100, 600));
        setName("frmStudent"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelBanner.setLayout(new java.awt.GridBagLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/BannerStudent.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelBanner.add(lblLogo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelBanner, gridBagConstraints);

        panelMenuRight.setBackground(new java.awt.Color(255, 255, 255));
        panelMenuRight.setMinimumSize(new java.awt.Dimension(230, 500));
        panelMenuRight.setPreferredSize(new java.awt.Dimension(230, 500));
        panelMenuRight.setLayout(new java.awt.GridBagLayout());

        taskPanelMenu.setMinimumSize(new java.awt.Dimension(210, 500));
        taskPanelMenu.setPreferredSize(new java.awt.Dimension(210, 500));

        jTaskPaneGroupManagementStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/user1.png"))); // NOI18N
        jTaskPaneGroupManagementStudent.setTitle("Management Student");
        jTaskPaneGroupManagementStudent.setToolTipText("Management Student");

        linkButtonAddStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        linkButtonAddStudent.setText("Add Student");
        linkButtonAddStudent.setToolTipText("Add Employee");
        jTaskPaneGroupManagementStudent.getContentPane().add(linkButtonAddStudent);

        linkButtonEditStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/edit.png"))); // NOI18N
        linkButtonEditStudent.setText("Edit Student");
        linkButtonEditStudent.setToolTipText("Edit Employee");
        jTaskPaneGroupManagementStudent.getContentPane().add(linkButtonEditStudent);

        linkButtonDeleteStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        linkButtonDeleteStudent.setText("Delete Student");
        linkButtonDeleteStudent.setToolTipText("Delete Employee");
        jTaskPaneGroupManagementStudent.getContentPane().add(linkButtonDeleteStudent);

        jLinkButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/view.png"))); // NOI18N
        jLinkButton1.setText("Search Student");
        jTaskPaneGroupManagementStudent.getContentPane().add(jLinkButton1);

        taskPanelMenu.add(jTaskPaneGroupManagementStudent);

        jTaskPaneGroupReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        jTaskPaneGroupReport.setTitle("Report");
        jTaskPaneGroupReport.setToolTipText("Report");

        linkBtnFeesReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow_right_green.png"))); // NOI18N
        linkBtnFeesReport.setText("Fees Report");
        jTaskPaneGroupReport.getContentPane().add(linkBtnFeesReport);

        linkBtnMarkReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow_right_green.png"))); // NOI18N
        linkBtnMarkReport.setText("Mark Report");
        jTaskPaneGroupReport.getContentPane().add(linkBtnMarkReport);

        jLinkButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow_right_green.png"))); // NOI18N
        jLinkButton2.setText("Student Report");
        jTaskPaneGroupReport.getContentPane().add(jLinkButton2);

        jLinkButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow_right_green.png"))); // NOI18N
        jLinkButton3.setText("New Registration Report");
        jTaskPaneGroupReport.getContentPane().add(jLinkButton3);

        taskPanelMenu.add(jTaskPaneGroupReport);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panelMenuRight.add(taskPanelMenu, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelMenuRight, gridBagConstraints);

        panelContent.setMinimumSize(new java.awt.Dimension(870, 500));
        panelContent.setPreferredSize(new java.awt.Dimension(870, 500));
        panelContent.setLayout(new java.awt.GridBagLayout());

        panelTop.setBackground(new java.awt.Color(255, 255, 255));
        panelTop.setMinimumSize(new java.awt.Dimension(870, 30));
        panelTop.setPreferredSize(new java.awt.Dimension(870, 30));
        panelTop.setLayout(new java.awt.GridBagLayout());

        lblHienthi1.setForeground(new java.awt.Color(3, 3, 3));
        lblHienthi1.setText("Tổng số sinh viên là : ");
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
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelTop.add(lblCount, gridBagConstraints);

        btnFilter.setText("Filter");
        btnFilter.setMaximumSize(new java.awt.Dimension(80, 20));
        btnFilter.setMinimumSize(new java.awt.Dimension(80, 20));
        btnFilter.setPreferredSize(new java.awt.Dimension(80, 20));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelTop.add(btnFilter, gridBagConstraints);

        filterText.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 400, 5, 5);
        panelTop.add(filterText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelContent.add(panelTop, gridBagConstraints);

        panelTable.setBackground(new java.awt.Color(255, 255, 255));
        panelTable.setMinimumSize(new java.awt.Dimension(870, 470));
        panelTable.setPreferredSize(new java.awt.Dimension(870, 470));
        panelTable.setRequestFocusEnabled(false);
        panelTable.setLayout(new java.awt.GridBagLayout());

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
        srcPanelContent.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panelTable.add(srcPanelContent, gridBagConstraints);

        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/import1.png"))); // NOI18N
        btnImport.setText("Import");
        btnImport.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnImport.setMaximumSize(new java.awt.Dimension(90, 25));
        btnImport.setMinimumSize(new java.awt.Dimension(90, 25));
        btnImport.setPreferredSize(new java.awt.Dimension(90, 25));
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        panelTable.add(btnImport, gridBagConstraints);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel.setMaximumSize(new java.awt.Dimension(90, 25));
        btnCancel.setMinimumSize(new java.awt.Dimension(90, 25));
        btnCancel.setPreferredSize(new java.awt.Dimension(90, 25));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 6, 5, 0);
        panelTable.add(btnCancel, gridBagConstraints);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/button_ok.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnSave.setMaximumSize(new java.awt.Dimension(65, 25));
        btnSave.setMinimumSize(new java.awt.Dimension(65, 25));
        btnSave.setPreferredSize(new java.awt.Dimension(90, 25));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 390, 5, 0);
        panelTable.add(btnSave, gridBagConstraints);

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/export1.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnExport.setMaximumSize(new java.awt.Dimension(90, 25));
        btnExport.setMinimumSize(new java.awt.Dimension(90, 25));
        btnExport.setPreferredSize(new java.awt.Dimension(90, 25));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 6, 5, 0);
        panelTable.add(btnExport, gridBagConstraints);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Close.jpg"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnExit.setMaximumSize(new java.awt.Dimension(90, 25));
        btnExit.setMinimumSize(new java.awt.Dimension(90, 25));
        btnExit.setPreferredSize(new java.awt.Dimension(90, 25));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 6, 5, 10);
        panelTable.add(btnExit, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelContent.add(panelTable, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelContent, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuIEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIEditActionPerformed
        // TODO add your handling co\de here:
        int index = tableContent.getSelectedRow();
        if (index != -1) {
            Student student = liststudent.get(index);
            frmEditStudent editStudent = new frmEditStudent(student);
            editStudent.setVisible(true);
        }
    }//GEN-LAST:event_menuIEditActionPerformed

    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableContentMouseClicked

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        FileOutputStream fos = null;
        try {
            // TODO add your handling code here:
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("Student Sheet");
            HSSFRow rowHead = sheet.createRow(0);
            rowHead.createCell(0).setCellValue("Id");
            rowHead.createCell(1).setCellValue("First Name");
            rowHead.createCell(2).setCellValue("Last Name");
            rowHead.createCell(3).setCellValue("Birthday");
            rowHead.createCell(4).setCellValue("Gender");
            rowHead.createCell(5).setCellValue("Phone");
            rowHead.createCell(6).setCellValue("Email");
            rowHead.createCell(7).setCellValue("Address");
            rowHead.createCell(8).setCellValue("Images");
            rowHead.createCell(9).setCellValue("Status");
            rowHead.createCell(10).setCellValue("Begin Work");
            int index = 1;
            for (int i = 0; i < liststudent.size(); i++) {
                Student student = liststudent.get(i);
                HSSFRow row = sheet.createRow(index);
                row.createCell(0).setCellValue(student.getId());
                row.createCell(1).setCellValue(student.getFirstName());
                row.createCell(2).setCellValue(student.getLastName());
                row.createCell(3).setCellValue(student.getBirthDay());
                row.createCell(4).setCellValue(student.getGender());
                row.createCell(5).setCellValue(student.getPhone());
                row.createCell(6).setCellValue(student.getEmail());
                row.createCell(7).setCellValue(student.getAddress());
                row.createCell(8).setCellValue(student.getImage());
                row.createCell(9).setCellValue(student.getStatus());
                index++;
            }
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
            fileChooser.showSaveDialog(this);
            String path = null;
            try {
                path = fileChooser.getSelectedFile().getPath();
            } catch (Exception ex) {
                return;
            }
            if (path != null) {
                fos = new FileOutputStream(path);
                wb.write(fos);
            }
        } catch (IOException ex) {
            Logger.getLogger(frmStudent.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(frmStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        fileChooser.showOpenDialog(this);
        String path = null;
        try {
            path = fileChooser.getSelectedFile().getPath();
        } catch (Exception ex) {
            return;
        }
        FileInputStream fis = null;
        try {
            // TODO add your handling code here:
            File file = new File(path);
            if (file.exists()) {
                fis = new FileInputStream(file);
                HSSFWorkbook wb = new HSSFWorkbook(fis);
                HSSFSheet sheet = wb.getSheet("Student Sheet");
                int index = 1;
                do {
                    HSSFRow row = sheet.getRow(index);
                    Student student = new Student();
                    if (row == null) {
                        break;
                    }
                    student.setId(row.getCell(0).toString());
                    student.setFirstName(row.getCell(1).toString());
                    student.setLastName(row.getCell(2).toString());
                    student.setBirthDay(row.getCell(3).getDateCellValue());
                    student.setGender((int) Float.parseFloat(row.getCell(4).toString()));
                    student.setPhone(row.getCell(5).toString());
                    student.setEmail(row.getCell(6).toString());
                    student.setAddress(row.getCell(7).toString());
                    student.setImage(row.getCell(8).toString());
                    student.setStatus((int) Float.parseFloat(row.getCell(9).toString()));
                    if (isExist(student)) {
                        liststudent.add(student);
                        liststudentTemp.add(student);
                    }
                    index++;
                    //TODO: doc du lieu tu file excel vo trong JTable
                } while (true);
                loadTable(liststudent);
            }
        } catch (Exception ex) {
            Logger.getLogger(frmStudent.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(frmStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        if (liststudentTemp.size() != 0) {
            int result = JOptionPane.showOptionDialog(this, "Save Data", "Question", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (result == JOptionPane.OK_OPTION) {
            } else if (result == JOptionPane.CANCEL_OPTION) {
                this.dispose();
            } else {
            }
        }
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        liststudentTemp.clear();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (liststudentTemp.size() != 0) {
            for (int i = 0; i < liststudentTemp.size(); i++) {
                Student student = new Student();
                studentDao.create(student);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void menuIAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIAddActionPerformed
        // TODO add your handling code here:
        frmAddStudent addStudent = new frmAddStudent();
        addStudent.setVisible(true);
    }//GEN-LAST:event_menuIAddActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        if (liststudent.size() != 0) {
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

    public Student find(String id)
    {
        for(int i = 0;i<liststudent.size();i++)
        {
            if(liststudent.get(i).getId().equals(id))
                return liststudent.get(i);
        }
        return null;
    }
    private void mnuIDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIDetailsActionPerformed
        // TODO add your handling code here:
        int index = tableContent.getSelectedRow();
        if(index !=- 1)
        {
            String id = String.valueOf(tableContent.getValueAt(index, 0));
            Student student = find(id);
            frmDetailsStudent detailsStudent = new frmDetailsStudent(student);
            detailsStudent.setVisible(true);
        }
        
    }//GEN-LAST:event_mnuIDetailsActionPerformed

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmStudent().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField filterText;
    private com.l2fprod.common.swing.JLinkButton jLinkButton1;
    private com.l2fprod.common.swing.JLinkButton jLinkButton2;
    private com.l2fprod.common.swing.JLinkButton jLinkButton3;
    private com.l2fprod.common.swing.JTaskPaneGroup jTaskPaneGroupManagementStudent;
    private com.l2fprod.common.swing.JTaskPaneGroup jTaskPaneGroupReport;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblHienthi1;
    private javax.swing.JLabel lblLogo;
    private com.l2fprod.common.swing.JLinkButton linkBtnFeesReport;
    private com.l2fprod.common.swing.JLinkButton linkBtnMarkReport;
    private com.l2fprod.common.swing.JLinkButton linkButtonAddStudent;
    private com.l2fprod.common.swing.JLinkButton linkButtonDeleteStudent;
    private com.l2fprod.common.swing.JLinkButton linkButtonEditStudent;
    private javax.swing.JMenuItem menuIAdd;
    private javax.swing.JMenuItem menuIDelete;
    private javax.swing.JMenuItem menuIEdit;
    private javax.swing.JMenuItem mnuIDetails;
    private javax.swing.JMenuItem mnuISearch;
    private javax.swing.JPanel panelBanner;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelMenuRight;
    private javax.swing.JPanel panelTable;
    private javax.swing.JPanel panelTop;
    private javax.swing.JPopupMenu popupMenuTable;
    private javax.swing.JScrollPane srcPanelContent;
    private javax.swing.JTable tableContent;
    private com.l2fprod.common.swing.JTaskPane taskPanelMenu;
    // End of variables declaration//GEN-END:variables
}
