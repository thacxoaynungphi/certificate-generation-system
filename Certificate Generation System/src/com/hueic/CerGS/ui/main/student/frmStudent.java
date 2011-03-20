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
        setSize(1100, 700);
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
        jScrollPane1.setRowHeader(viewPort);
        jScrollPane1.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, tableContent.getTableHeader());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenuTable = new javax.swing.JPopupMenu();
        menuIAdd = new javax.swing.JMenuItem();
        menuIEdit = new javax.swing.JMenuItem();
        menuIDelete = new javax.swing.JMenuItem();
        mnuISearch = new javax.swing.JMenuItem();
        mnuIDetails = new javax.swing.JMenuItem();
        panelBanner = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTaskPane1 = new com.l2fprod.common.swing.JTaskPane();
        jTaskPaneGroup1 = new com.l2fprod.common.swing.JTaskPaneGroup();
        linkButtonAddStudent = new com.l2fprod.common.swing.JLinkButton();
        linkButtonEditStudent = new com.l2fprod.common.swing.JLinkButton();
        linkButtonDeleteStudent = new com.l2fprod.common.swing.JLinkButton();
        linkButtonSearchStudent = new com.l2fprod.common.swing.JLinkButton();
        linkButtonDetails = new com.l2fprod.common.swing.JLinkButton();
        jTaskPaneGroup2 = new com.l2fprod.common.swing.JTaskPaneGroup();
        jTaskPaneGroup3 = new com.l2fprod.common.swing.JTaskPaneGroup();
        linkButtonImport = new com.l2fprod.common.swing.JLinkButton();
        linkButtonExport = new com.l2fprod.common.swing.JLinkButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblHienthi1 = new javax.swing.JLabel();
        lblCount = new javax.swing.JLabel();
        btnFilter = new javax.swing.JButton();
        filterText = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
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
        popupMenuTable.add(mnuIDetails);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Management Employee");
        setResizable(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/banner copy.png"))); // NOI18N

        javax.swing.GroupLayout panelBannerLayout = new javax.swing.GroupLayout(panelBanner);
        panelBanner.setLayout(panelBannerLayout);
        panelBannerLayout.setHorizontalGroup(
            panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBannerLayout.setVerticalGroup(
            panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        com.l2fprod.common.swing.PercentLayout percentLayout1 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout1.setGap(14);
        percentLayout1.setOrientation(1);
        jTaskPane1.setLayout(percentLayout1);

        jTaskPaneGroup1.setTitle("Managment Student");
        jTaskPaneGroup1.setToolTipText("Managment Student");
        com.l2fprod.common.swing.PercentLayout percentLayout2 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout2.setGap(2);
        percentLayout2.setOrientation(1);
        jTaskPaneGroup1.getContentPane().setLayout(percentLayout2);

        linkButtonAddStudent.setText("Add Student");
        linkButtonAddStudent.setToolTipText("Add Employee");
        jTaskPaneGroup1.getContentPane().add(linkButtonAddStudent);

        linkButtonEditStudent.setText("Edit Student");
        linkButtonEditStudent.setToolTipText("Edit Employee");
        jTaskPaneGroup1.getContentPane().add(linkButtonEditStudent);

        linkButtonDeleteStudent.setText("Delete Student");
        linkButtonDeleteStudent.setToolTipText("Delete Employee");
        jTaskPaneGroup1.getContentPane().add(linkButtonDeleteStudent);

        linkButtonSearchStudent.setText("Search Student");
        linkButtonSearchStudent.setToolTipText("Search Employee");
        jTaskPaneGroup1.getContentPane().add(linkButtonSearchStudent);

        linkButtonDetails.setText("Details Student");
        jTaskPaneGroup1.getContentPane().add(linkButtonDetails);

        jTaskPane1.add(jTaskPaneGroup1);

        jTaskPaneGroup2.setTitle("Report");
        jTaskPaneGroup2.setToolTipText("Report");
        com.l2fprod.common.swing.PercentLayout percentLayout3 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout3.setGap(2);
        percentLayout3.setOrientation(1);
        jTaskPaneGroup2.getContentPane().setLayout(percentLayout3);
        jTaskPane1.add(jTaskPaneGroup2);

        jTaskPaneGroup3.setTitle("Managment Data");
        jTaskPaneGroup3.setToolTipText("Managment Data");
        com.l2fprod.common.swing.PercentLayout percentLayout4 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout4.setGap(2);
        percentLayout4.setOrientation(1);
        jTaskPaneGroup3.getContentPane().setLayout(percentLayout4);

        linkButtonImport.setText("Import Data");
        jTaskPaneGroup3.getContentPane().add(linkButtonImport);

        linkButtonExport.setText("Export Data");
        jTaskPaneGroup3.getContentPane().add(linkButtonExport);

        jTaskPane1.add(jTaskPaneGroup3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTaskPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTaskPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );

        lblHienthi1.setText("Tổng số sinh viên là : ");

        btnFilter.setText("Filter");
        btnFilter.setMaximumSize(new java.awt.Dimension(57, 20));
        btnFilter.setMinimumSize(new java.awt.Dimension(57, 20));
        btnFilter.setPreferredSize(new java.awt.Dimension(57, 20));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHienthi1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 467, Short.MAX_VALUE)
                .addComponent(filterText, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHienthi1)
                    .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

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
        jScrollPane1.setViewportView(tableContent);

        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/import1.png"))); // NOI18N
        btnImport.setText("Import");
        btnImport.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnImport.setPreferredSize(new java.awt.Dimension(90, 25));
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel.setPreferredSize(new java.awt.Dimension(90, 25));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/button_ok.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnSave.setPreferredSize(new java.awt.Dimension(90, 25));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/export1.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnExport.setPreferredSize(new java.awt.Dimension(90, 25));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Close.jpg"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnExit.setPreferredSize(new java.awt.Dimension(90, 25));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.l2fprod.common.swing.JTaskPane jTaskPane1;
    private com.l2fprod.common.swing.JTaskPaneGroup jTaskPaneGroup1;
    private com.l2fprod.common.swing.JTaskPaneGroup jTaskPaneGroup2;
    private com.l2fprod.common.swing.JTaskPaneGroup jTaskPaneGroup3;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblHienthi1;
    private com.l2fprod.common.swing.JLinkButton linkButtonAddStudent;
    private com.l2fprod.common.swing.JLinkButton linkButtonDeleteStudent;
    private com.l2fprod.common.swing.JLinkButton linkButtonDetails;
    private com.l2fprod.common.swing.JLinkButton linkButtonEditStudent;
    private com.l2fprod.common.swing.JLinkButton linkButtonExport;
    private com.l2fprod.common.swing.JLinkButton linkButtonImport;
    private com.l2fprod.common.swing.JLinkButton linkButtonSearchStudent;
    private javax.swing.JMenuItem menuIAdd;
    private javax.swing.JMenuItem menuIDelete;
    private javax.swing.JMenuItem menuIEdit;
    private javax.swing.JMenuItem mnuIDetails;
    private javax.swing.JMenuItem mnuISearch;
    private javax.swing.JPanel panelBanner;
    private javax.swing.JPopupMenu popupMenuTable;
    private javax.swing.JTable tableContent;
    // End of variables declaration//GEN-END:variables
}
