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
public class frmEmployee extends javax.swing.JFrame {

    /** Creates new form EmployeeFrm */
    private ArrayList<Employee> listEmp = new ArrayList<Employee>();
    private ArrayList<Employee> listEmpTemp = new ArrayList<Employee>();
    private ArrayList<Employee> listEmpSearch = new ArrayList<Employee>();
    private EmployeeDAO empDao = new EmployeeDAO();
    TableRowSorter<TableModel> sorter;

    public frmEmployee() {
        initComponents();
        setSize(1100, 700);
        setLocationRelativeTo(null);
        listEmp = empDao.readByAll();
        loadTable(listEmp);
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

    public void loadTable(ArrayList<Employee> listEmp) {
        lblCount.setText(String.valueOf(listEmp.size()));
        String[] columns = {"ID", "First Name", "Last Name", "Birthday", "Gender", "Phone"};
        Object[][] rows = new Object[listEmp.size()][6];
        int index = 0;
        for (int i = 0; i < listEmp.size(); i++) {
            Employee emp = listEmp.get(i);
            rows[index][0] = emp.getId();
            rows[index][1] = emp.getFirstName();
            rows[index][2] = emp.getLastName();
            rows[index][3] = emp.getBirthDay().toString();
            rows[index][4] = emp.getGender();
            rows[index][5] = emp.getPhone();
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
        java.awt.GridBagConstraints gridBagConstraints;

        popupMenuTable = new javax.swing.JPopupMenu();
        menuIAdd = new javax.swing.JMenuItem();
        menuIEdit = new javax.swing.JMenuItem();
        menuIDelete = new javax.swing.JMenuItem();
        mnuIDetails = new javax.swing.JMenuItem();
        mnuISearch = new javax.swing.JMenuItem();
        panelBanner = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelLeft = new javax.swing.JPanel();
        jTaskPane1 = new com.l2fprod.common.swing.JTaskPane();
        jTaskPaneGroup1 = new com.l2fprod.common.swing.JTaskPaneGroup();
        linkButtonAddEmp = new com.l2fprod.common.swing.JLinkButton();
        linkButtonEditEmp = new com.l2fprod.common.swing.JLinkButton();
        linkButtonDeleteEmp = new com.l2fprod.common.swing.JLinkButton();
        linkButtonSearchEmp = new com.l2fprod.common.swing.JLinkButton();
        jTaskPaneGroup2 = new com.l2fprod.common.swing.JTaskPaneGroup();
        panelRight = new javax.swing.JPanel();
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

        mnuIDetails.setText("Details");
        mnuIDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIDetailsActionPerformed(evt);
            }
        });
        popupMenuTable.add(mnuIDetails);

        mnuISearch.setText("Search");
        mnuISearch.setToolTipText("");
        popupMenuTable.add(mnuISearch);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Management Employee");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelBanner.setBackground(new java.awt.Color(255, 255, 255));
        panelBanner.setLayout(new java.awt.GridBagLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/BannerEmployee.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelBanner.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelBanner, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        jTaskPane1.setBackground(new java.awt.Color(153, 153, 255));
        jTaskPane1.setLayout(new java.awt.GridBagLayout());

        jTaskPaneGroup1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/users1.png"))); // NOI18N
        jTaskPaneGroup1.setTitle("Managment Employee");
        jTaskPaneGroup1.setToolTipText("Managment Employee");

        linkButtonAddEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        linkButtonAddEmp.setText("Add Employee");
        linkButtonAddEmp.setToolTipText("Add Employee");
        linkButtonAddEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkButtonAddEmpActionPerformed(evt);
            }
        });
        jTaskPaneGroup1.getContentPane().add(linkButtonAddEmp);

        linkButtonEditEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/edit.png"))); // NOI18N
        linkButtonEditEmp.setText("Edit Employee");
        linkButtonEditEmp.setToolTipText("Edit Employee");
        linkButtonEditEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkButtonEditEmpActionPerformed(evt);
            }
        });
        jTaskPaneGroup1.getContentPane().add(linkButtonEditEmp);

        linkButtonDeleteEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        linkButtonDeleteEmp.setText("Delete Employee");
        linkButtonDeleteEmp.setToolTipText("Delete Employee");
        jTaskPaneGroup1.getContentPane().add(linkButtonDeleteEmp);

        linkButtonSearchEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/view.png"))); // NOI18N
        linkButtonSearchEmp.setText("Search Employee");
        linkButtonSearchEmp.setToolTipText("Search Employee");
        jTaskPaneGroup1.getContentPane().add(linkButtonSearchEmp);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jTaskPane1.add(jTaskPaneGroup1, gridBagConstraints);

        jTaskPaneGroup2.setTitle("Report");
        jTaskPaneGroup2.setToolTipText("Report");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jTaskPane1.add(jTaskPaneGroup2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(jTaskPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 160;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelLeft, gridBagConstraints);

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        lblHienthi1.setText("Tổng số nhân viên là : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel3.add(lblHienthi1, gridBagConstraints);

        lblCount.setBackground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 6, 5, 0);
        jPanel3.add(lblCount, gridBagConstraints);

        btnFilter.setText("Filter");
        btnFilter.setMaximumSize(new java.awt.Dimension(57, 20));
        btnFilter.setMinimumSize(new java.awt.Dimension(57, 20));
        btnFilter.setPreferredSize(new java.awt.Dimension(57, 20));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 6, 5, 10);
        jPanel3.add(btnFilter, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 172;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 200, 5, 0);
        jPanel3.add(filterText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelRight.add(jPanel3, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridBagLayout());

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 446;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel4.add(jScrollPane1, gridBagConstraints);

        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/export1.png"))); // NOI18N
        btnImport.setText("Import");
        btnImport.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnImport.setPreferredSize(new java.awt.Dimension(90, 25));
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 7, 0);
        jPanel4.add(btnImport, gridBagConstraints);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel.setPreferredSize(new java.awt.Dimension(90, 25));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 7, 0);
        jPanel4.add(btnCancel, gridBagConstraints);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/button_ok.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(90, 25));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 369, 7, 0);
        jPanel4.add(btnSave, gridBagConstraints);

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/export1.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnExport.setPreferredSize(new java.awt.Dimension(90, 25));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 7, 0);
        jPanel4.add(btnExport, gridBagConstraints);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Close.jpg"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnExit.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnExit.setPreferredSize(new java.awt.Dimension(90, 25));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 7, 0);
        jPanel4.add(btnExit, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 5);
        panelRight.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelRight, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuIEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIEditActionPerformed
        // TODO add your handling co\de here:
        int index = tableContent.getSelectedRow();
        if (index != -1) {
            Employee emp = listEmp.get(index);
            frmEditEmployee editEmployee = new frmEditEmployee(emp);
            editEmployee.setVisible(true);
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

    private void mnuIDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIDetailsActionPerformed
        // TODO add your handling code here:
        int index = tableContent.getSelectedRow();
        if (index != -1) {
            frmDetailsEmployee detailsEmployee = new frmDetailsEmployee(listEmp.get(index));
            detailsEmployee.setVisible(true);
        }
    }//GEN-LAST:event_mnuIDetailsActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_btnFilterActionPerformed

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
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.l2fprod.common.swing.JTaskPane jTaskPane1;
    private com.l2fprod.common.swing.JTaskPaneGroup jTaskPaneGroup1;
    private com.l2fprod.common.swing.JTaskPaneGroup jTaskPaneGroup2;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblHienthi1;
    private com.l2fprod.common.swing.JLinkButton linkButtonAddEmp;
    private com.l2fprod.common.swing.JLinkButton linkButtonDeleteEmp;
    private com.l2fprod.common.swing.JLinkButton linkButtonEditEmp;
    private com.l2fprod.common.swing.JLinkButton linkButtonSearchEmp;
    private javax.swing.JMenuItem menuIAdd;
    private javax.swing.JMenuItem menuIDelete;
    private javax.swing.JMenuItem menuIEdit;
    private javax.swing.JMenuItem mnuIDetails;
    private javax.swing.JMenuItem mnuISearch;
    private javax.swing.JPanel panelBanner;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPopupMenu popupMenuTable;
    private javax.swing.JTable tableContent;
    // End of variables declaration//GEN-END:variables
}
