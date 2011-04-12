
/*
 * pnlCertificate.java
 *
 * Created on Mar 31, 2011, 4:26:38 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.CertificateDAO;
import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.MarkDAO;
import com.hueic.CerGS.dao.PaymentDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.entity.Certificate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

/**
 *
 * @author nhchung
 */
public class pnlCertificate extends javax.swing.JPanel {

    private ArrayList<Certificate> listCertificate = new ArrayList<Certificate>();
    private CertificateDAO certificateDao;
    private MarkDAO markDAO;
    RegisterDAO registerDAO = new RegisterDAO();
    private ObjectTableModel tableModel;
    private JTable headerTable;
    ArrayList<Certificate> filter = null;
    private boolean isAdd;
    frmMain frm;

    /** Creates new form pnlCertificate */
    public pnlCertificate() {
        initComponents();
        certificateDao = new CertificateDAO();
        markDAO = new MarkDAO();
        btnCancel.setVisible(false);
        isAdd = false;
        getData();
        if (listCertificate.size() != 0) {
            loadData();
            if (!isAdd) {
                loadDetails(listCertificate.get(0));
            }
        }
    }

    public pnlCertificate(frmMain frm) {
        initComponents();
        this.frm = frm;
        certificateDao = new CertificateDAO();
        markDAO = new MarkDAO();
        btnCancel.setVisible(false);
        isAdd = false;
        getData();
    }

    public void getData() {
        listCertificate = certificateDao.readByAll();
        if (listCertificate.size() != 0) {
            loadData();
            loadDetails(listCertificate.get(0));
            isAdd = false;
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnCancel.setVisible(false);
        }
    }

    public void loadData() {
        try {
            filter = new ArrayList<Certificate>();
            for (Certificate cer : listCertificate) {
                if (cer.getStudentID().toLowerCase().matches(".*" + txtStudentIDSearch.getText().trim().toLowerCase() + ".*") //                    && cer..getName().toLowerCase().matches(".*" + txtNameSearch.getText().trim().toLowerCase() + ".*")
                        && String.valueOf(cer.getId()).toLowerCase().matches(".*" + txtIDSearch.getText().trim().toLowerCase() + ".*")) {
                    filter.add(cer);
                }
            }
            if (!filter.isEmpty()) {
                loadDetails(filter.get(0));
            }
            loadTable(filter);
        } catch (Exception ex) {
        }
    }

    public void loadFiter(String text) {
        try {
            filter = new ArrayList<Certificate>();
            for (Certificate cer : listCertificate) {
                if (cer.getStudentID().toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*") //                    && cer..getName().toLowerCase().matches(".*" + txtNameSearch.getText().trim().toLowerCase() + ".*")
                        || String.valueOf(cer.getId()).toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")
                        || String.valueOf(cer.getMark()).toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")
                        || cer.getDegreeDay().toString().toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")) {
                    filter.add(cer);
                }
            }
            if (!filter.isEmpty()) {
                loadDetails(filter.get(0));
            }
            loadTable(filter);
        } catch (Exception ex) {
        }
    }

    public void loadTable(ArrayList<Certificate> filter) {
        ColumnData[] columns = {
            new ColumnData("ID", 135, SwingConstants.LEFT, 1),
            new ColumnData("Student ID", 100, SwingConstants.LEFT, 2),
            new ColumnData("Mark", 140, SwingConstants.LEFT, 3),
            new ColumnData("Degree Day", 170, SwingConstants.LEFT, 4),};
        tableModel = new ObjectTableModel(tableContent, columns, filter);
        headerTable = tableModel.getHeaderTable();
        headerTable.createDefaultColumnsFromModel();
        tableContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JViewport viewport = new JViewport();
        viewport.setView(headerTable);
        viewport.setPreferredSize(headerTable.getMaximumSize());
        srcPanelCertificate.setRowHeader(viewport);
        srcPanelCertificate.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    public void loadDetails(Certificate cer) {
        txtID.setText(String.valueOf(cer.getId()).trim());
        txtMark.setText(String.valueOf(cer.getMark()).trim());
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
        txtMark = new javax.swing.JTextField();
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
        pnlButtonSearch = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        lblTitleSearch = new javax.swing.JLabel();
        sepaCertificateSearch = new javax.swing.JSeparator();
        lblIDSearch = new javax.swing.JLabel();
        txtIDSearch = new javax.swing.JTextField();
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
        lblScore.setText("Mark : ");
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

        txtMark.setEnabled(false);
        txtMark.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtMark, gridBagConstraints);

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

        txtID.setEnabled(false);
        txtID.setMinimumSize(new java.awt.Dimension(200, 20));
        txtID.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtID, gridBagConstraints);

        dateChooseDegreeDay.setDateFormatString("MM/dd/yyyy");
        dateChooseDegreeDay.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(dateChooseDegreeDay, gridBagConstraints);

        btnChooseStudentId.setText("jButton1");
        btnChooseStudentId.setEnabled(false);
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

        txtStudentID.setEnabled(false);
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
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop2.add(lblStudentIDSearch, gridBagConstraints);

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
        gridBagConstraints.gridy = 3;
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
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
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
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
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

        srcPanelCertificate.setAutoscrolls(true);
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

        if (!isAdd) {
            isAdd = true;
            btnCancel.setVisible(true);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            txtStudentID.setEnabled(true);
            btnChooseStudentId.setEnabled(true);

            txtID.setText(null);
            txtStudentID.setText(null);
            txtMark.setText(null);
            dateChooseDegreeDay.setDate(null);
            return;
        } else {
            if (txtStudentID.getText().length() != 0
                    && txtMark.getText().length() != 0
                    && dateChooseDegreeDay.getDate() != null) {
                Certificate certificate = new Certificate();
                try {
                    String id = txtStudentID.getText();
                    if (getIndexCertificateInListByStudentId(id) == -1) {
                        if (txtStudentID.getText().length() != 0) {
                            float mark = markDAO.avgMark(id);
                            if (mark < 40) {
                                JOptionPane.showMessageDialog(this, "This student has not completed the course or does not pass the exam", "Certificate Add", JOptionPane.ERROR_MESSAGE);
                                return;
                            } else if (mark < 50) {
                                JOptionPane.showMessageDialog(this, "Your grade in this Course is C \n You will receive a transcript instead of a certificate", "Certificate Add", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }
                            try {
                                certificate.setMark(mark);
                                certificate.setStudentID(id);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(this, ex.getMessage(), "Certificate Add", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "you must be Select Student Id of Cetificate", "Certificate Add", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (dateChooseDegreeDay.getDate() != null) {
                            certificate.setDegreeDay(new java.sql.Date(dateChooseDegreeDay.getDate().getTime()));
                        } else {
                            JOptionPane.showMessageDialog(this, "you must be select a degree date of Cetificate", "Certificate Add", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        PaymentDAO payDao = new PaymentDAO();
                        CourseDAO courseDao = new CourseDAO();
                        if (payDao.getTotalDiposit(certificate.getStudentID()) == courseDao.readById(registerDAO.readByStudentCourseId(certificate.getStudentID()).getCourseId()).getTotalFees()) {
                            if (certificateDao.create(certificate)) {
                                JOptionPane.showMessageDialog(this, certificateDao.getLastError(), "Certificate Add", JOptionPane.INFORMATION_MESSAGE);
                                certificate.setId(certificateDao.readIdentity("Certificate"));
                                listCertificate.add(certificate);
                                loadData();
                                isAdd = false;
                                btnCancel.setVisible(false);
                                btnUpdate.setEnabled(true);
                                btnDelete.setEnabled(true);
                                txtStudentID.setEnabled(true);
                                btnChooseStudentId.setEnabled(true);
                            } else {
                                JOptionPane.showMessageDialog(this, certificateDao.getLastError(), "Certificate Add", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Student have not fully paid", "Certificate Add", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "This Student has been developed Certificate", "Certificate Add", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Certificate Add", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Enter full information, please", "Certificate Add", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (txtStudentID.getText().length() != 0
                    && txtMark.getText().length() != 0
                    && dateChooseDegreeDay.getDate() != null
                    && txtID.getText().length() != 0) {
                int i = getIndexCertificateInListByStudentId((String) txtStudentID.getText());
                try {
                    Certificate cer = listCertificate.get(i);
                    try {
                        cer.setMark(Float.parseFloat(txtMark.getText()));
                        cer.setDegreeDay(new java.sql.Date(dateChooseDegreeDay.getDate().getTime()));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Certificate Update", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (certificateDao.update(cer)) {
                        listCertificate.set(i, cer);
                        loadData();
                        JOptionPane.showMessageDialog(this, certificateDao.getLastError(), "Certificate Update", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, certificateDao.getLastError(), "Certificate Update", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "data not valid", "Certificate Update", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Enter full information, please", "Certificate Update", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
        }
}//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (txtID.getText().length() != 0) {
                try {
                    int id = Integer.parseInt(txtID.getText());
                    int index = getIndexCertificateInListById(id);
                    if (certificateDao.delete(id)) {
                        listCertificate.remove(index);
                        loadData();
                        JOptionPane.showMessageDialog(this, certificateDao.getLastError(), "Certificate Delete", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, certificateDao.getLastError(), "Certificate Delete", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error! Check again, please.", "Certificate Delete", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Enter full information, please", "Certificate Delete", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        try {
            if (isAdd) {
                isAdd = false;
                btnCancel.setVisible(false);
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
                txtStudentID.setEnabled(false);
                btnChooseStudentId.setEnabled(false);
                loadDetails(listCertificate.get(0));
            }
        } catch (Exception ex) {
        }
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed

        loadFiter(filterText.getText());
}//GEN-LAST:event_btnFilterActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        txtIDSearch.setText(null);
        txtStudentIDSearch.setText(null);

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnChooseStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseStudentIdActionPerformed
        try {
            dlgChoose dlg = new dlgChoose(frm, txtStudentID, true, 12);
            dlg.setTitle("Browse Student");
            dlg.setSize(868, 580);
            dlg.setLocationRelativeTo(null);
            dlg.setVisible(true);
            if (txtStudentID.getText().length() != 0) {
                float mark = markDAO.avgMark(txtStudentID.getText());
                txtMark.setText(String.valueOf(mark));
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btnChooseStudentIdActionPerformed

    private void btnChooseStudentIdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseStudentIdSearchActionPerformed
        try {
            dlgChoose dlg = new dlgChoose(frm, txtStudentIDSearch, true, 12);
            dlg.setTitle("Browse Student");
            dlg.setSize(868, 580);
            dlg.setLocationRelativeTo(null);
            dlg.setVisible(true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btnChooseStudentIdSearchActionPerformed

    private void filterTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_filterTextCaretUpdate

        loadFiter(filterText.getText());
    }//GEN-LAST:event_filterTextCaretUpdate

    private void txtIDSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtIDSearchCaretUpdate

        loadData();
    }//GEN-LAST:event_txtIDSearchCaretUpdate

    private void txtStudentIDSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtStudentIDSearchCaretUpdate

        loadData();
    }//GEN-LAST:event_txtStudentIDSearchCaretUpdate

    private void tableContentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseReleased

        try {
            int index = tableContent.getSelectedRow();
            if (index != -1) {
                int value = Integer.parseInt(tableContent.getValueAt(index, 0).toString());
                Certificate cer = find(value);
                if (cer != null) {
                    loadDetails(cer);
                }
                if (isAdd) {
                    isAdd = false;
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                    btnCancel.setVisible(false);
                }

            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_tableContentMouseReleased

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        try {
            if (!filter.isEmpty()) {
                frm.pnlReport.removeAll();
                dlgChooseReport report = new dlgChooseReport(frm, this);
                report.getCertificateDevelopedReport(filter);
                report.setVisible(true);
                report.setSize(860, 600);
                frm.pnlReport.add(report);
                frm.tpnBusiness.setSelectedComponent(frm.pnlReport);
            } else {
                JOptionPane.showMessageDialog(this, "No data!", "Report Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
        }
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
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel lblDegreeDay;
    private javax.swing.JLabel lblEnterFilter;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIDSearch;
    private javax.swing.JLabel lblScore;
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
    private javax.swing.JTextField txtMark;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtStudentIDSearch;
    // End of variables declaration//GEN-END:variables

    String getSelectedType() {
        try {
            int index = tableContent.getSelectedRow();
            if (index != -1) {
                return tableContent.getValueAt(index, 0).toString();
            }
        } catch (Exception ex) {
        }
        return null;
    }
}
