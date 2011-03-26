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
import javax.swing.table.TableCellEditor;
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
        java.awt.GridBagConstraints gridBagConstraints;

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
        jLinkButton1 = new com.l2fprod.common.swing.JLinkButton();
        jTaskPaneGroup2 = new com.l2fprod.common.swing.JTaskPaneGroup();
        linkBtnFeesReport = new com.l2fprod.common.swing.JLinkButton();
        linkBtnMarkReport = new com.l2fprod.common.swing.JLinkButton();
        jLinkButton2 = new com.l2fprod.common.swing.JLinkButton();
        jLinkButton3 = new com.l2fprod.common.swing.JLinkButton();
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
        mnuIDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIDetailsActionPerformed(evt);
            }
        });
        popupMenuTable.add(mnuIDetails);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Management Employee");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelBanner.setLayout(new java.awt.GridBagLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/BannerStudent.png"))); // NOI18N
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jTaskPaneGroup1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/user1.png"))); // NOI18N
        jTaskPaneGroup1.setTitle("Managment Student");
        jTaskPaneGroup1.setToolTipText("Managment Student");

        linkButtonAddStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        linkButtonAddStudent.setText("Add Student");
        linkButtonAddStudent.setToolTipText("Add Employee");
        jTaskPaneGroup1.getContentPane().add(linkButtonAddStudent);

        linkButtonEditStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/edit.png"))); // NOI18N
        linkButtonEditStudent.setText("Edit Student");
        linkButtonEditStudent.setToolTipText("Edit Employee");
        jTaskPaneGroup1.getContentPane().add(linkButtonEditStudent);

        linkButtonDeleteStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        linkButtonDeleteStudent.setText("Delete Student");
        linkButtonDeleteStudent.setToolTipText("Delete Employee");
        jTaskPaneGroup1.getContentPane().add(linkButtonDeleteStudent);

        jLinkButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/view.png"))); // NOI18N
        jLinkButton1.setText("Search Student");
        jTaskPaneGroup1.getContentPane().add(jLinkButton1);

        jTaskPane1.add(jTaskPaneGroup1);

        jTaskPaneGroup2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        jTaskPaneGroup2.setTitle("Report");
        jTaskPaneGroup2.setToolTipText("Report");

        linkBtnFeesReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow_right_green.png"))); // NOI18N
        linkBtnFeesReport.setText("Fees Report");
        jTaskPaneGroup2.getContentPane().add(linkBtnFeesReport);

        linkBtnMarkReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow_right_green.png"))); // NOI18N
        linkBtnMarkReport.setText("Mark Report");
        jTaskPaneGroup2.getContentPane().add(linkBtnMarkReport);

        jLinkButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow_right_green.png"))); // NOI18N
        jLinkButton2.setText("Student Report");
        jTaskPaneGroup2.getContentPane().add(jLinkButton2);

        jLinkButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/arrow_right_green.png"))); // NOI18N
        jLinkButton3.setText("New Registration Report");
        jTaskPaneGroup2.getContentPane().add(jLinkButton3);

        jTaskPane1.add(jTaskPaneGroup2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(jTaskPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 58;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setMinimumSize(new java.awt.Dimension(600, 550));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 600));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        lblHienthi1.setText("Tổng số sinh viên là : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lblHienthi1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
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
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(btnFilter, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 203;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 200, 5, 5);
        jPanel3.add(filterText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 290;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel2.add(jPanel3, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(600, 893));
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
        gridBagConstraints.ipadx = 869;
        gridBagConstraints.ipady = 446;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel4.add(jScrollPane1, gridBagConstraints);

        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/import1.png"))); // NOI18N
        btnImport.setText("Import");
        btnImport.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnImport.setPreferredSize(new java.awt.Dimension(90, 25));
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 9, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 9, 0);
        jPanel4.add(btnCancel, gridBagConstraints);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/button_ok.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnSave.setPreferredSize(new java.awt.Dimension(90, 25));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 420, 9, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 9, 0);
        jPanel4.add(btnExport, gridBagConstraints);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Close.jpg"))); // NOI18N
        btnExit.setText("Exit");
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
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 9, 0);
        jPanel4.add(btnExit, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel2.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel2, gridBagConstraints);

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
    private javax.swing.JLabel jLabel2;
    private com.l2fprod.common.swing.JLinkButton jLinkButton1;
    private com.l2fprod.common.swing.JLinkButton jLinkButton2;
    private com.l2fprod.common.swing.JLinkButton jLinkButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.l2fprod.common.swing.JTaskPane jTaskPane1;
    private com.l2fprod.common.swing.JTaskPaneGroup jTaskPaneGroup1;
    private com.l2fprod.common.swing.JTaskPaneGroup jTaskPaneGroup2;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblHienthi1;
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
    private javax.swing.JPopupMenu popupMenuTable;
    private javax.swing.JTable tableContent;
    // End of variables declaration//GEN-END:variables
}
