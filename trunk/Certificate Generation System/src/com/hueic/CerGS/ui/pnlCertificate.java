/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pnlCertificate.java
 *
 * Created on Mar 31, 2011, 4:26:38 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.CertificateDAO;
import com.hueic.CerGS.dao.MarkDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.entity.Certificate;
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
public class pnlCertificate extends javax.swing.JPanel {

    private ArrayList<Certificate> listCertificate = new ArrayList<Certificate>();
    private CertificateDAO certificateDao;
    private MarkDAO markDAO;
    TableRowSorter<TableModel> sorter;
    RegisterDAO registerDAO = new RegisterDAO();
    private ObjectTableModel tableModel;
    private JTable headerTable;
    ArrayList<Certificate> filter = null;
    frmMain frm;

    /** Creates new form pnlCertificate */
    public pnlCertificate() {
        initComponents();
        certificateDao = new CertificateDAO();
        markDAO = new MarkDAO();
        listCertificate = certificateDao.readByAll();
        loadData(listCertificate);
        loadDetails(listCertificate.get(0));
    }

    public pnlCertificate(frmMain frm) {
        initComponents();
        this.frm = frm;
        certificateDao = new CertificateDAO();
        markDAO = new MarkDAO();
        listCertificate = certificateDao.readByAll();
        loadData(listCertificate);
        loadDetails(listCertificate.get(0));
    }

    public void loadData(ArrayList<Certificate> listCertificate) {
        filter = new ArrayList<Certificate>();
        for (Certificate cer : listCertificate) {
            if (cer.getStudentID().toLowerCase().matches(".*" + txtStudentIDSearch.getText().trim().toLowerCase() + ".*") //                    && cer..getName().toLowerCase().matches(".*" + txtNameSearch.getText().trim().toLowerCase() + ".*")
                    //                    && String.valueOf(sub.getCoefficient()).toLowerCase().matches(".*" + txtCoefficientSearch.getText().trim().toLowerCase() + ".*")
                    //                    && sub.getCourseID().toLowerCase().matches(".*" + txtCoureIDSearch.getText().trim().toLowerCase() + ".*")
                    //chua xet diem va ngay thang
                    ) {
                filter.add(cer);
            }
        }
        if (filter.size() != 0) {
            loadDetails(filter.get(0));
        }
        ColumnData[] columns = {
            new ColumnData("ID", 135, SwingConstants.LEFT, 1),
            new ColumnData("Student ID", 100, SwingConstants.LEFT, 2),
            new ColumnData("Mark", 140, SwingConstants.LEFT, 3),
            new ColumnData("Degree Day", 170, SwingConstants.LEFT, 4),};
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
        srcPanelCertificate.setRowHeader(viewport);
        srcPanelCertificate.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    public void loadDetails(Certificate cer) {
        txtID.setText(String.valueOf(cer.getId()).trim());
        txtScore.setText(String.valueOf(cer.getMark()).trim());
        dateChooseDegreeDay.setDate(cer.getDegreeDay());
        txtStudentID.setText(cer.getStudentID());
    }

    public int getIndexCertificateInListById(int id) {
        for (int i = 0; i < listCertificate.size(); i++) {
            if (listCertificate.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexCertificateInListByStudentId(String studentId) {
        for (int i = 0; i < listCertificate.size(); i++) {
            if (listCertificate.get(i).getStudentID().compareTo(studentId) == 0) {
                return i;
            }
        }
        return -1;
    }

    public Certificate find(int value) {
        for (int i = 0; i < listCertificate.size(); i++) {
            if (listCertificate.get(i).getId() == value) {
                return listCertificate.get(i);
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

        tpCertificate = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        pnlTop1 = new javax.swing.JPanel();
        lblStudentID = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblDegreeDay = new javax.swing.JLabel();
        txtScore = new javax.swing.JTextField();
        pnlButtonEdit = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        sepaCertificate = new javax.swing.JSeparator();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        dateChooseDegreeDay = new com.toedter.calendar.JDateChooser();
        btnChooseStudentId = new javax.swing.JButton();
        txtStudentID = new javax.swing.JTextField();
        pnlSearch = new javax.swing.JPanel();
        pnlTop2 = new javax.swing.JPanel();
        lblStudentIDSearch = new javax.swing.JLabel();
        lblScoreSearch = new javax.swing.JLabel();
        lblDegreeDaySearch = new javax.swing.JLabel();
        txtScoreSearch = new javax.swing.JTextField();
        pnlButtonSearch = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        lblTitleSearch = new javax.swing.JLabel();
        sepaCertificateSearch = new javax.swing.JSeparator();
        lblIDSearch = new javax.swing.JLabel();
        txtIDSearch = new javax.swing.JTextField();
        dateChooseDegreeDaySearch = new com.toedter.calendar.JDateChooser();
        btnChooseStudentIdSearch = new javax.swing.JButton();
        txtStudentIDSearch = new javax.swing.JTextField();
        pnlDown = new javax.swing.JPanel();
        srcPanelCertificate = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        lblEnterFilter = new javax.swing.JLabel();
        pnlButtonReport = new javax.swing.JPanel();
        btnReport = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        tpCertificate.setMinimumSize(new java.awt.Dimension(860, 200));
        tpCertificate.setPreferredSize(new java.awt.Dimension(860, 200));

        pnlEdit.setMinimumSize(new java.awt.Dimension(800, 200));
        pnlEdit.setPreferredSize(new java.awt.Dimension(800, 200));
        pnlEdit.setLayout(new java.awt.GridBagLayout());

        pnlTop1.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop1.setMinimumSize(new java.awt.Dimension(860, 200));
        pnlTop1.setPreferredSize(new java.awt.Dimension(860, 200));
        pnlTop1.setLayout(new java.awt.GridBagLayout());

        lblStudentID.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentID.setText("Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblStudentID, gridBagConstraints);

        lblScore.setForeground(new java.awt.Color(3, 3, 3));
        lblScore.setText("Score:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop1.add(lblScore, gridBagConstraints);

        lblDegreeDay.setForeground(new java.awt.Color(3, 3, 3));
        lblDegreeDay.setText("Degree Day:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop1.add(lblDegreeDay, gridBagConstraints);

        txtScore.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtScore, gridBagConstraints);

        pnlButtonEdit.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnAdd.setMinimumSize(new java.awt.Dimension(53, 23));
        btnAdd.setPreferredSize(new java.awt.Dimension(75, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnlButtonEdit.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnUpdate.setPreferredSize(new java.awt.Dimension(75, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnlButtonEdit.add(btnUpdate);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnDelete.setMaximumSize(new java.awt.Dimension(75, 25));
        btnDelete.setMinimumSize(new java.awt.Dimension(75, 23));
        btnDelete.setPreferredSize(new java.awt.Dimension(75, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnlButtonEdit.add(btnDelete);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel.setMinimumSize(new java.awt.Dimension(67, 23));
        btnCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnlButtonEdit.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 5, 5);
        pnlTop1.add(pnlButtonEdit, gridBagConstraints);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Certificate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlTop1.add(lblTitle, gridBagConstraints);

        sepaCertificate.setMinimumSize(new java.awt.Dimension(750, 10));
        sepaCertificate.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlTop1.add(sepaCertificate, gridBagConstraints);

        lblID.setForeground(new java.awt.Color(3, 3, 3));
        lblID.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblID, gridBagConstraints);

        txtID.setMinimumSize(new java.awt.Dimension(200, 20));
        txtID.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtID, gridBagConstraints);

        dateChooseDegreeDay.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(dateChooseDegreeDay, gridBagConstraints);

        btnChooseStudentId.setText("jButton1");
        btnChooseStudentId.setMaximumSize(new java.awt.Dimension(23, 23));
        btnChooseStudentId.setMinimumSize(new java.awt.Dimension(23, 23));
        btnChooseStudentId.setPreferredSize(new java.awt.Dimension(23, 20));
        btnChooseStudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseStudentIdActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(btnChooseStudentId, gridBagConstraints);

        txtStudentID.setMinimumSize(new java.awt.Dimension(200, 20));
        txtStudentID.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtStudentID, gridBagConstraints);

        pnlEdit.add(pnlTop1, new java.awt.GridBagConstraints());

        tpCertificate.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlSearch.setLayout(new java.awt.GridBagLayout());

        pnlTop2.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop2.setMinimumSize(new java.awt.Dimension(860, 200));
        pnlTop2.setPreferredSize(new java.awt.Dimension(860, 200));
        pnlTop2.setLayout(new java.awt.GridBagLayout());

        lblStudentIDSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentIDSearch.setText("Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(lblStudentIDSearch, gridBagConstraints);

        lblScoreSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblScoreSearch.setText("Score:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop2.add(lblScoreSearch, gridBagConstraints);

        lblDegreeDaySearch.setForeground(new java.awt.Color(3, 3, 3));
        lblDegreeDaySearch.setText("Degree Day:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop2.add(lblDegreeDaySearch, gridBagConstraints);

        txtScoreSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtScoreSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtScoreSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(txtScoreSearch, gridBagConstraints);

        pnlButtonSearch.setBackground(new java.awt.Color(255, 255, 255));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReset.setMinimumSize(new java.awt.Dimension(53, 23));
        btnReset.setPreferredSize(new java.awt.Dimension(75, 23));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        pnlButtonSearch.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 5, 0);
        pnlTop2.add(pnlButtonSearch, gridBagConstraints);

        lblTitleSearch.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitleSearch.setForeground(new java.awt.Color(102, 0, 102));
        lblTitleSearch.setText("Information Certificate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlTop2.add(lblTitleSearch, gridBagConstraints);

        sepaCertificateSearch.setMinimumSize(new java.awt.Dimension(750, 10));
        sepaCertificateSearch.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlTop2.add(sepaCertificateSearch, gridBagConstraints);

        lblIDSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblIDSearch.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(lblIDSearch, gridBagConstraints);

        txtIDSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtIDSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtIDSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(txtIDSearch, gridBagConstraints);

        dateChooseDegreeDaySearch.setMaxSelectableDate(new java.util.Date(253370743317000L));
        dateChooseDegreeDaySearch.setMaximumSize(new java.awt.Dimension(200, 20));
        dateChooseDegreeDaySearch.setMinimumSize(new java.awt.Dimension(200, 20));
        dateChooseDegreeDaySearch.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(dateChooseDegreeDaySearch, gridBagConstraints);

        btnChooseStudentIdSearch.setText("jButton1");
        btnChooseStudentIdSearch.setMaximumSize(new java.awt.Dimension(23, 23));
        btnChooseStudentIdSearch.setMinimumSize(new java.awt.Dimension(23, 23));
        btnChooseStudentIdSearch.setPreferredSize(new java.awt.Dimension(23, 20));
        btnChooseStudentIdSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseStudentIdSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(btnChooseStudentIdSearch, gridBagConstraints);

        txtStudentIDSearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtStudentIDSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtStudentIDSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtStudentIDSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(txtStudentIDSearch, gridBagConstraints);

        pnlSearch.add(pnlTop2, new java.awt.GridBagConstraints());

        tpCertificate.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpCertificate, gridBagConstraints);

        pnlDown.setBackground(new java.awt.Color(255, 255, 255));
        pnlDown.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Certificate", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        pnlDown.setMinimumSize(new java.awt.Dimension(860, 400));
        pnlDown.setPreferredSize(new java.awt.Dimension(860, 400));
        pnlDown.setLayout(new java.awt.GridBagLayout());

        srcPanelCertificate.setMinimumSize(new java.awt.Dimension(840, 300));
        srcPanelCertificate.setPreferredSize(new java.awt.Dimension(840, 300));

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
        tableContent.setMinimumSize(new java.awt.Dimension(770, 300));
        tableContent.setPreferredSize(new java.awt.Dimension(770, 300));
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableContentMouseReleased(evt);
            }
        });
        srcPanelCertificate.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlDown.add(srcPanelCertificate, gridBagConstraints);

        filterText.setMinimumSize(new java.awt.Dimension(200, 20));
        filterText.setPreferredSize(new java.awt.Dimension(200, 20));
        filterText.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                filterTextCaretUpdate(evt);
            }
        });
        filterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filterTextKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlDown.add(filterText, gridBagConstraints);

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
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlDown.add(btnFilter, gridBagConstraints);

        lblEnterFilter.setText("Enter filter:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 490, 5, 5);
        pnlDown.add(lblEnterFilter, gridBagConstraints);

        pnlButtonReport.setBackground(new java.awt.Color(255, 255, 255));

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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        pnlDown.add(pnlButtonReport, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(pnlDown, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:

        Certificate certificate = new Certificate();
        try {
            if (!txtID.getText().equals("")) {
                certificate.setId(Integer.parseInt(txtID.getText().trim()));
            } else {
                JOptionPane.showMessageDialog(this, "you must be enter Id of Cetificate", "Certificate Enter Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (txtStudentID.getText().length() != 0) {
                certificate.setMark(markDAO.getStudentMark((String) txtStudentID.getText()));
                certificate.setStudentID((String) txtStudentID.getText());
            } else {
                JOptionPane.showMessageDialog(this, "you must be Select Student Id of Cetificate", "Certificate Enter Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (dateChooseDegreeDay.getDate() != null) {
                certificate.setDegreeDay(new java.sql.Date(dateChooseDegreeDay.getDate().getTime()));
            } else {
                JOptionPane.showMessageDialog(this, "you must be select a degree date of Cetificate", "Certificate Enter Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (certificateDao.create(certificate)) {
                listCertificate.add(certificate);
                loadData(listCertificate);
            } else {
                JOptionPane.showMessageDialog(this, certificateDao.getLastError(), "Certificate Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Certificate Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int i1 = getIndexCertificateInListById(Integer.parseInt(txtID.getText()));
        int i2 = getIndexCertificateInListByStudentId((String) txtStudentID.getText());
        if (i1 == i2) {
            try {
                Certificate cer = listCertificate.get(i2);
                cer.setMark(Float.parseFloat(txtScore.getText()));
                cer.setDegreeDay(new java.sql.Date(dateChooseDegreeDay.getDate().getTime()));
                if (certificateDao.update(cer)) {
                    listCertificate.set(i2, cer);
                    loadData(listCertificate);
                    JOptionPane.showMessageDialog(this, certificateDao.getLastError(), "Certificate Message", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, certificateDao.getLastError(), "Certificate Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "data not valid", "Certificate Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Can't update", "Certificate Error", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(txtID.getText());
        int index = getIndexCertificateInListById(id);
        if (certificateDao.delete(id)) {
            listCertificate.remove(index);
            loadData(listCertificate);
            JOptionPane.showMessageDialog(this, certificateDao.getLastError(), "Delete Certificate", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, certificateDao.getLastError(), "Delete Certificate", JOptionPane.INFORMATION_MESSAGE);
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnCancelActionPerformed

    private void filterTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTextKeyPressed
        // TODO add your handling code here:
}//GEN-LAST:event_filterTextKeyPressed

    public void startFiter() {
        if (!listCertificate.isEmpty()) {
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
    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        startFiter();
}//GEN-LAST:event_btnFilterActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnChooseStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseStudentIdActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtStudentID, true, 12);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnChooseStudentIdActionPerformed

    private void btnChooseStudentIdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseStudentIdSearchActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtStudentIDSearch, true, 12);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnChooseStudentIdSearchActionPerformed

    private void filterTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_filterTextCaretUpdate

        startFiter();
    }//GEN-LAST:event_filterTextCaretUpdate

    private void txtIDSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtIDSearchCaretUpdate
        // TODO add your handling code here:
        loadData(listCertificate);
    }//GEN-LAST:event_txtIDSearchCaretUpdate

    private void txtStudentIDSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtStudentIDSearchCaretUpdate
        // TODO add your handling code here:
        loadData(listCertificate);
    }//GEN-LAST:event_txtStudentIDSearchCaretUpdate

    private void txtScoreSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtScoreSearchCaretUpdate
        // TODO add your handling code here:
        loadData(listCertificate);
    }//GEN-LAST:event_txtScoreSearchCaretUpdate

    private void tableContentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int index = tableContent.getSelectedRow();
            if (index != -1) {
                int value = Integer.parseInt(tableContent.getValueAt(index, 0).toString());
                Certificate cer = find(value);
                if (cer != null) {
                    loadDetails(cer);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tableContentMouseReleased

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
        frm.pnlReport.removeAll();
        dlgChooseReport report = new dlgChooseReport(frm, this);
        report.getCertificateDevelopedReport(filter);
        report.setVisible(true);
        report.setSize(860, 600);
        frm.pnlReport.add(report);
        frm.tpnBusiness.setSelectedComponent(frm.pnlReport);
    }//GEN-LAST:event_btnReportActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChooseStudentId;
    private javax.swing.JButton btnChooseStudentIdSearch;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser dateChooseDegreeDay;
    private com.toedter.calendar.JDateChooser dateChooseDegreeDaySearch;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel lblDegreeDay;
    private javax.swing.JLabel lblDegreeDaySearch;
    private javax.swing.JLabel lblEnterFilter;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIDSearch;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblScoreSearch;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentIDSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleSearch;
    private javax.swing.JPanel pnlButtonEdit;
    private javax.swing.JPanel pnlButtonReport;
    private javax.swing.JPanel pnlButtonSearch;
    private javax.swing.JPanel pnlDown;
    public javax.swing.JPanel pnlEdit;
    public javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlTop1;
    private javax.swing.JPanel pnlTop2;
    private javax.swing.JSeparator sepaCertificate;
    private javax.swing.JSeparator sepaCertificateSearch;
    private javax.swing.JScrollPane srcPanelCertificate;
    private javax.swing.JTable tableContent;
    public javax.swing.JTabbedPane tpCertificate;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDSearch;
    private javax.swing.JTextField txtScore;
    private javax.swing.JTextField txtScoreSearch;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtStudentIDSearch;
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
