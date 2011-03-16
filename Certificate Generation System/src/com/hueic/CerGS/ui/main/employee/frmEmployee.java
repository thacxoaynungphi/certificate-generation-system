/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EmployeeFrm.java
 *
 * Created on Mar 13, 2011, 5:38:22 PM
 */
package com.hueic.CerGS.ui.main.employee;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.EmployeeDAO;
import com.hueic.CerGS.entity.Employee;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.CellEditor;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author nhchung
 */
public class frmEmployee extends javax.swing.JFrame {

    /** Creates new form EmployeeFrm */
    private ObjectTableModel tableModel;
    private ArrayList<Employee> listEmp = new ArrayList<Employee>();
    private ArrayList<Employee> listEmpTemp = new ArrayList<Employee>();
    private ArrayList<Employee> listEmpSearch = new ArrayList<Employee>();
    private EmployeeDAO empDao = new EmployeeDAO();

    public frmEmployee() {
        initComponents();
        setSize(1100, 700);
        listEmp = empDao.readByAll();
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
        loadTable(listEmp);
    }

    public void loadTable(ArrayList<Employee> listEmp) {
        lblCount.setText(String.valueOf(listEmp.size()));
        ColumnData[] columns = {
            new ColumnData("Id", 20, SwingConstants.LEFT, 1),
            new ColumnData("First Name", 30, SwingConstants.LEFT, 2),
            new ColumnData("Last Name", 20, SwingConstants.LEFT, 3),
            new ColumnData("Birthday", 20, SwingConstants.LEFT, 4),
            new ColumnData("Gender", 20, SwingConstants.LEFT, 5),
            new ColumnData("Phone", 20, SwingConstants.LEFT, 6),};
        tableModel = new ObjectTableModel(tableContent, columns, listEmp);
        JTable headerTable = tableModel.getHeaderTable();
        headerTable.createDefaultColumnsFromModel();
        tableContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JViewport viewPort = new JViewport();
        viewPort.setView(headerTable);
        viewPort.setPreferredSize(headerTable.getMaximumSize());
        jScrollPane1.setRowHeader(viewPort);
        jScrollPane1.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
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
        mnuIDetailsEmployee = new javax.swing.JMenuItem();
        mnuISearchEmp = new javax.swing.JMenuItem();
        panelBanner = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTaskPane1 = new com.l2fprod.common.swing.JTaskPane();
        jTaskPaneGroup1 = new com.l2fprod.common.swing.JTaskPaneGroup();
        linkButtonAddEmp = new com.l2fprod.common.swing.JLinkButton();
        linkButtonEditEmp = new com.l2fprod.common.swing.JLinkButton();
        linkButtonDeleteEmp = new com.l2fprod.common.swing.JLinkButton();
        linkButtonSearchEmp = new com.l2fprod.common.swing.JLinkButton();
        linkButtonDetailsEmp = new com.l2fprod.common.swing.JLinkButton();
        jTaskPaneGroup2 = new com.l2fprod.common.swing.JTaskPaneGroup();
        jTaskPaneGroup3 = new com.l2fprod.common.swing.JTaskPaneGroup();
        linkButtonImport = new com.l2fprod.common.swing.JLinkButton();
        linkButtonExport = new com.l2fprod.common.swing.JLinkButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        comboSearch = new javax.swing.JComboBox();
        txtSearch = new javax.swing.JTextField();
        lblHienthi1 = new javax.swing.JLabel();
        lblCount = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
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

        mnuIDetailsEmployee.setText("Details");
        popupMenuTable.add(mnuIDetailsEmployee);

        mnuISearchEmp.setText("Search");
        mnuISearchEmp.setToolTipText("");
        popupMenuTable.add(mnuISearchEmp);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Management Employee");
        setResizable(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/dispatcher.png"))); // NOI18N

        javax.swing.GroupLayout panelBannerLayout = new javax.swing.GroupLayout(panelBanner);
        panelBanner.setLayout(panelBannerLayout);
        panelBannerLayout.setHorizontalGroup(
            panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1096, Short.MAX_VALUE)
        );
        panelBannerLayout.setVerticalGroup(
            panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        com.l2fprod.common.swing.PercentLayout percentLayout1 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout1.setGap(14);
        percentLayout1.setOrientation(1);
        jTaskPane1.setLayout(percentLayout1);

        jTaskPaneGroup1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/users1.png"))); // NOI18N
        jTaskPaneGroup1.setTitle("Managment Employee");
        jTaskPaneGroup1.setToolTipText("Managment Employee");
        com.l2fprod.common.swing.PercentLayout percentLayout2 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout2.setGap(2);
        percentLayout2.setOrientation(1);
        jTaskPaneGroup1.getContentPane().setLayout(percentLayout2);

        linkButtonAddEmp.setText("Add Employee");
        linkButtonAddEmp.setToolTipText("Add Employee");
        linkButtonAddEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkButtonAddEmpActionPerformed(evt);
            }
        });
        jTaskPaneGroup1.getContentPane().add(linkButtonAddEmp);

        linkButtonEditEmp.setText("Edit Employee");
        linkButtonEditEmp.setToolTipText("Edit Employee");
        linkButtonEditEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkButtonEditEmpActionPerformed(evt);
            }
        });
        jTaskPaneGroup1.getContentPane().add(linkButtonEditEmp);

        linkButtonDeleteEmp.setText("Delete Employee");
        linkButtonDeleteEmp.setToolTipText("Delete Employee");
        jTaskPaneGroup1.getContentPane().add(linkButtonDeleteEmp);

        linkButtonSearchEmp.setText("Search Employee");
        linkButtonSearchEmp.setToolTipText("Search Employee");
        jTaskPaneGroup1.getContentPane().add(linkButtonSearchEmp);

        linkButtonDetailsEmp.setText("Details Employee");
        jTaskPaneGroup1.getContentPane().add(linkButtonDetailsEmp);

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

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Employee", "Employee ID", "First Name", "Last Name", "Birthday", "Gender", "Phone Number" }));
        comboSearch.setToolTipText("Choose type to search");
        comboSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSearchItemStateChanged(evt);
            }
        });

        lblHienthi1.setText("Tổng số nhân viên là : ");

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/view.png"))); // NOI18N
        lblSearch.setToolTipText("Click to search!");
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHienthi1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHienthi1)
                    .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(6, Short.MAX_VALUE))
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

        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
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
                .addComponent(btnImport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 563, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addGap(14, 14, 14))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave)
                        .addComponent(btnCancel)
                        .addComponent(btnExit))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnImport)
                        .addComponent(btnExport)))
                .addContainerGap(9, Short.MAX_VALUE))
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        Employee emp = listEmp.get(index);
        frmEditEmployee editEmployee = new frmEditEmployee(emp);
        editEmployee.setVisible(true);
    }//GEN-LAST:event_menuIEditActionPerformed

    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableContentMouseClicked

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        FileOutputStream fos = null;
        try {
            // TODO add your handling code here:
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("Employee Sheet");
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
            for (int i = 0; i < listEmp.size(); i++) {
                Employee emp = listEmp.get(i);
                HSSFRow row = sheet.createRow(index);
                row.createCell(0).setCellValue(emp.getId());
                row.createCell(1).setCellValue(emp.getFirstName());
                row.createCell(2).setCellValue(emp.getLastName());
                row.createCell(3).setCellValue(emp.getBirthDay());
                row.createCell(4).setCellValue(emp.getGender());
                row.createCell(5).setCellValue(emp.getPhone());
                row.createCell(6).setCellValue(emp.getEmail());
                row.createCell(7).setCellValue(emp.getAddress());
                row.createCell(8).setCellValue(emp.getImage());
                row.createCell(9).setCellValue(emp.getStatus());
                row.createCell(10).setCellValue(emp.getBeginWork());
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
            Logger.getLogger(frmEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(frmEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
                HSSFSheet sheet = wb.getSheet("Employee Sheet");
                int index = 1;
                do {
                    HSSFRow row = sheet.getRow(index);
                    Employee emp = new Employee();
                    if (row == null) {
                        break;
                    }
                    emp.setId(row.getCell(0).toString());
                    emp.setFirstName(row.getCell(1).toString());
                    emp.setLastName(row.getCell(2).toString());
                    emp.setBirthDay(row.getCell(3).getDateCellValue());
                    emp.setGender((int) Float.parseFloat(row.getCell(4).toString()));
                    emp.setPhone(row.getCell(5).toString());
                    emp.setEmail(row.getCell(6).toString());
                    emp.setAddress(row.getCell(7).toString());
                    emp.setImage(row.getCell(8).toString());
                    emp.setStatus((int) Float.parseFloat(row.getCell(9).toString()));
                    emp.setBeginWork(row.getCell(10).getDateCellValue());
                    if (isExist(emp)) {
                        listEmp.add(emp);
                        listEmpTemp.add(emp);
                    }
                    index++;
                    //TODO: doc du lieu tu file excel vo trong JTable
                } while (true);
                loadTable(listEmp);
            }
        } catch (Exception ex) {
            Logger.getLogger(frmEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(frmEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        if (listEmpTemp.size() != 0) {
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
        listEmpTemp.clear();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (listEmpTemp.size() != 0) {
            for (int i = 0; i < listEmpTemp.size(); i++) {
                Employee emp = new Employee();
                empDao.create(emp);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        // TODO add your handling code here:
        String choose = comboSearch.getSelectedItem().toString().trim();
        if (choose.equalsIgnoreCase("All Employee")) {
            loadTable(listEmp);
            return;
        } else if (choose.equalsIgnoreCase("Employee ID")) {
            listEmpSearch.clear();
            for (int i = 0; i < listEmp.size(); i++) {
                if (listEmp.get(i).getId().contentEquals(txtSearch.getText())) {
                    listEmpSearch.add(listEmp.get(i));
                }
            }
        } else if (choose.equalsIgnoreCase("First Name")) {
            listEmpSearch.clear();
            for (int i = 0; i < listEmp.size(); i++) {
                if (listEmp.get(i).getFirstName().contentEquals(txtSearch.getText())) {
                    listEmpSearch.add(listEmp.get(i));
                }
            }
        } else if (choose.equalsIgnoreCase("Last Name")) {
            listEmpSearch.clear();
            for (int i = 0; i < listEmp.size(); i++) {
                if (listEmp.get(i).getLastName().contentEquals(txtSearch.getText())) {
                    listEmpSearch.add(listEmp.get(i));
                }
            }
        } else if (choose.equalsIgnoreCase("Birthday")) {
            String text = txtSearch.getText();
            Pattern pattern = Pattern.compile("{\\d}\\{\\d}\\{\\d}4 - {\\d}\\{\\d}\\{\\d}4");
            Matcher matcher = pattern.matcher(text);
            if (matcher.matches()) {
                System.out.println("Duoc");
            } else {
                System.out.println("Khong duoc");
            }
        } else if (choose.equalsIgnoreCase("Gender")) {
            String text = txtSearch.getText();
            int gender = 0;
            if (text.equalsIgnoreCase("Male")) {
                gender = 0;
            } else if (text.equalsIgnoreCase("FeMale")) {
                gender = 1;
            } else {
                return;
            }
            listEmpSearch.clear();
            for (int i = 0; i < listEmp.size(); i++) {
                if (listEmp.get(i).getGender() == gender) {
                    listEmpSearch.add(listEmp.get(i));
                }
            }
        } else if (choose.equalsIgnoreCase("Phone")) {
            listEmpSearch.clear();
            for (int i = 0; i < listEmp.size(); i++) {
                if (listEmp.get(i).getPhone().contentEquals(txtSearch.getText())) {
                    listEmpSearch.add(listEmp.get(i));
                }
            }
        }
        loadTable(listEmpSearch);
    }//GEN-LAST:event_lblSearchMouseClicked

    private void comboSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSearchItemStateChanged
        // TODO add your handling code here:
        if (comboSearch.getSelectedItem().toString().equalsIgnoreCase("All Employee")) {
            loadTable(listEmp);
        }
    }//GEN-LAST:event_comboSearchItemStateChanged

    private void menuIAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIAddActionPerformed
        // TODO add your handling code here:
        frmAddEmployee addEmployee = new frmAddEmployee();
        addEmployee.setVisible(true);
    }//GEN-LAST:event_menuIAddActionPerformed

    private void linkButtonAddEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkButtonAddEmpActionPerformed
        // TODO add your handling code here:
        frmAddEmployee addEmployee = new frmAddEmployee();
        addEmployee.setVisible(true);
    }//GEN-LAST:event_linkButtonAddEmpActionPerformed

    private void linkButtonEditEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkButtonEditEmpActionPerformed
        // TODO add your handling code here:
        frmEditEmployee editEmployee = new frmEditEmployee();
        editEmployee.setVisible(true);
    }//GEN-LAST:event_linkButtonEditEmpActionPerformed

    public boolean isExist(Employee emp) {
        for (int i = 0; i < listEmp.size(); i++) {
            if (listEmp.get(i).getId().equalsIgnoreCase(emp.getId())) {
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
                new frmEmployee().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox comboSearch;
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
    private javax.swing.JLabel lblSearch;
    private com.l2fprod.common.swing.JLinkButton linkButtonAddEmp;
    private com.l2fprod.common.swing.JLinkButton linkButtonDeleteEmp;
    private com.l2fprod.common.swing.JLinkButton linkButtonDetailsEmp;
    private com.l2fprod.common.swing.JLinkButton linkButtonEditEmp;
    private com.l2fprod.common.swing.JLinkButton linkButtonExport;
    private com.l2fprod.common.swing.JLinkButton linkButtonImport;
    private com.l2fprod.common.swing.JLinkButton linkButtonSearchEmp;
    private javax.swing.JMenuItem menuIAdd;
    private javax.swing.JMenuItem menuIDelete;
    private javax.swing.JMenuItem menuIEdit;
    private javax.swing.JMenuItem mnuIDetailsEmployee;
    private javax.swing.JMenuItem mnuISearchEmp;
    private javax.swing.JPanel panelBanner;
    private javax.swing.JPopupMenu popupMenuTable;
    private javax.swing.JTable tableContent;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}