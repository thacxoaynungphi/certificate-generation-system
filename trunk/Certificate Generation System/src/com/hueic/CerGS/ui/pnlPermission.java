
/*
 * pnlPermission.java
 *
 * Created on Mar 31, 2011, 5:06:20 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.PermissionDAO;
import com.hueic.CerGS.entity.Permission;
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
public class pnlPermission extends javax.swing.JPanel {

    private ArrayList<Permission> listPermssion = new ArrayList<Permission>();
    private PermissionDAO perDao;
    boolean isAdd = false;
    private ObjectTableModel tableModel;
    private JTable headerTable;
    ArrayList<Permission> filter = null;

    /** Creates new form pnlPermission */
    public pnlPermission() {
        initComponents();
        perDao = new PermissionDAO();
        getData();
    }

    public void getData() {
        listPermssion = perDao.readByAll();
        loadData();
        if (!listPermssion.isEmpty()) {
            loadDetails(listPermssion.get(0));
        }
        isAdd = false;
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);
        btnCancel.setVisible(false);
    }

    public void loadData() {
        filter = new ArrayList<Permission>();
        for (Permission per : listPermssion) {
            if (String.valueOf(per.getId()).toLowerCase().matches(".*" + txtIdSearch.getText().trim().toLowerCase() + ".*")
                    && per.getName().toLowerCase().matches(".*" + txtNameSearch.getText().trim().toLowerCase() + ".*")) {
                filter.add(per);
            }
        }
        if (!filter.isEmpty()) {
            loadDetails(filter.get(0));
        }
        loadTable(filter);
    }

    public void loadFiter(String text) {
        filter = new ArrayList<Permission>();
        for (Permission per : listPermssion) {
            if (String.valueOf(per.getId()).toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")
                    || per.getName().toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")) {
                filter.add(per);
            }
        }
        if (!filter.isEmpty()) {
            loadDetails(filter.get(0));
        }
        loadTable(filter);
    }

    public void loadTable(ArrayList<Permission> list) {
        ColumnData[] columns = {
            new ColumnData("ID", 100, SwingConstants.LEFT, 1),
            new ColumnData("Name", 140, SwingConstants.LEFT, 2),};
        tableModel = new ObjectTableModel(tableContent, columns, filter);
        headerTable = tableModel.getHeaderTable();
        headerTable.createDefaultColumnsFromModel();
        tableContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JViewport viewport = new JViewport();
        viewport.setView(headerTable);
        viewport.setPreferredSize(headerTable.getMaximumSize());
        srcPanelPermission.setRowHeader(viewport);
        srcPanelPermission.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    public void loadDetails(Permission per) {
        if (per.getName().equals("Admin") || per.getName().equals("Employee") || per.getName().equals("Student")) {
            btnDelete.setEnabled(false);
            btnUpdate.setEnabled(false);
        } else if (!isAdd) {
            btnDelete.setEnabled(true);
            btnUpdate.setEnabled(true);
        }
        txtId.setText(String.valueOf(per.getId()).trim());
        txtName.setText(per.getName().trim());
    }

    public Permission find(int value) {
        for (int i = 0; i < listPermssion.size(); i++) {
            if (listPermssion.get(i).getId() == value) {
                return listPermssion.get(i);
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tpPermission = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        panelRight = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        sepaAccount = new javax.swing.JSeparator();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        panelButton = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        lblcheck1 = new javax.swing.JLabel();
        lblcheck2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        pnlSearch = new javax.swing.JPanel();
        panelRightSearch = new javax.swing.JPanel();
        lblTitleSearch = new javax.swing.JLabel();
        sepaAccountSearch = new javax.swing.JSeparator();
        lblUsernameSearch = new javax.swing.JLabel();
        lblPasswordSearch = new javax.swing.JLabel();
        panelButtonSearch = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        txtIdSearch = new javax.swing.JTextField();
        lblcheckSearch = new javax.swing.JLabel();
        lblcheck4Search = new javax.swing.JLabel();
        txtNameSearch = new javax.swing.JTextField();
        panelLeft = new javax.swing.JPanel();
        srcPanelPermission = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        lblEnterNameStudent = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(860, 600));
        setLayout(new java.awt.GridBagLayout());

        tpPermission.setMinimumSize(new java.awt.Dimension(860, 200));
        tpPermission.setPreferredSize(new java.awt.Dimension(860, 200));

        pnlEdit.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlEdit.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlEdit.setLayout(new java.awt.GridBagLayout());

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setMinimumSize(new java.awt.Dimension(860, 200));
        panelRight.setPreferredSize(new java.awt.Dimension(860, 200));
        panelRight.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Permission");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(lblTitle, gridBagConstraints);

        sepaAccount.setMinimumSize(new java.awt.Dimension(750, 10));
        sepaAccount.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelRight.add(sepaAccount, gridBagConstraints);

        lblUsername.setForeground(new java.awt.Color(3, 3, 3));
        lblUsername.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelRight.add(lblUsername, gridBagConstraints);

        lblPassword.setForeground(new java.awt.Color(3, 3, 3));
        lblPassword.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelRight.add(lblPassword, gridBagConstraints);

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
        btnUpdate.setEnabled(false);
        btnUpdate.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnUpdate.setMaximumSize(new java.awt.Dimension(80, 25));
        btnUpdate.setMinimumSize(new java.awt.Dimension(75, 23));
        btnUpdate.setPreferredSize(new java.awt.Dimension(75, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panelButton.add(btnUpdate);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
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
        btnCancel.setMaximumSize(new java.awt.Dimension(75, 23));
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
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(30, 5, 5, 5);
        panelRight.add(panelButton, gridBagConstraints);

        txtId.setEnabled(false);
        txtId.setMinimumSize(new java.awt.Dimension(200, 20));
        txtId.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtId, gridBagConstraints);

        lblcheck1.setForeground(new java.awt.Color(255, 0, 51));
        lblcheck1.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblcheck1, gridBagConstraints);

        lblcheck2.setForeground(new java.awt.Color(255, 0, 51));
        lblcheck2.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblcheck2, gridBagConstraints);

        txtName.setMinimumSize(new java.awt.Dimension(200, 20));
        txtName.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtName, gridBagConstraints);

        pnlEdit.add(panelRight, new java.awt.GridBagConstraints());

        tpPermission.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlSearch.setLayout(new java.awt.GridBagLayout());

        panelRightSearch.setBackground(new java.awt.Color(255, 255, 255));
        panelRightSearch.setMinimumSize(new java.awt.Dimension(860, 200));
        panelRightSearch.setPreferredSize(new java.awt.Dimension(860, 200));
        panelRightSearch.setLayout(new java.awt.GridBagLayout());

        lblTitleSearch.setFont(new java.awt.Font("Tahoma", 1, 13));
        lblTitleSearch.setForeground(new java.awt.Color(102, 0, 102));
        lblTitleSearch.setText("Information Permission");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRightSearch.add(lblTitleSearch, gridBagConstraints);

        sepaAccountSearch.setMinimumSize(new java.awt.Dimension(650, 10));
        sepaAccountSearch.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelRightSearch.add(sepaAccountSearch, gridBagConstraints);

        lblUsernameSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblUsernameSearch.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelRightSearch.add(lblUsernameSearch, gridBagConstraints);

        lblPasswordSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblPasswordSearch.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelRightSearch.add(lblPasswordSearch, gridBagConstraints);

        panelButtonSearch.setBackground(new java.awt.Color(255, 255, 255));
        panelButtonSearch.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReset.setPreferredSize(new java.awt.Dimension(70, 23));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        panelButtonSearch.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(30, 5, 5, 5);
        panelRightSearch.add(panelButtonSearch, gridBagConstraints);

        txtIdSearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtIdSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtIdSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtIdSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(txtIdSearch, gridBagConstraints);

        lblcheckSearch.setForeground(new java.awt.Color(255, 0, 51));
        lblcheckSearch.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(lblcheckSearch, gridBagConstraints);

        lblcheck4Search.setForeground(new java.awt.Color(255, 0, 51));
        lblcheck4Search.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(lblcheck4Search, gridBagConstraints);

        txtNameSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtNameSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNameSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(txtNameSearch, gridBagConstraints);

        pnlSearch.add(panelRightSearch, new java.awt.GridBagConstraints());

        tpPermission.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpPermission, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Permission", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelLeft.setMinimumSize(new java.awt.Dimension(860, 400));
        panelLeft.setPreferredSize(new java.awt.Dimension(860, 400));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        srcPanelPermission.setMinimumSize(new java.awt.Dimension(840, 300));
        srcPanelPermission.setPreferredSize(new java.awt.Dimension(840, 300));

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
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableContentMouseReleased(evt);
            }
        });
        srcPanelPermission.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(srcPanelPermission, gridBagConstraints);

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
        panelLeft.add(filterText, gridBagConstraints);

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
        panelLeft.add(btnFilter, gridBagConstraints);

        lblEnterNameStudent.setForeground(new java.awt.Color(3, 3, 3));
        lblEnterNameStudent.setText("Enter Filter:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 490, 5, 5);
        panelLeft.add(lblEnterNameStudent, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelLeft, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed

        loadFiter(filterText.getText());
}//GEN-LAST:event_btnFilterActionPerformed

    private void tableContentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseReleased

        try {
            int index = tableContent.getSelectedRow();
            if (index != -1) {
                int value = Integer.parseInt(tableContent.getValueAt(index, 0).toString());
                Permission per = find(value);
                if (per != null) {
                    loadDetails(per);
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

    private void filterTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_filterTextCaretUpdate

        loadFiter(filterText.getText());
    }//GEN-LAST:event_filterTextCaretUpdate

    private void txtNameSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNameSearchCaretUpdate

        loadData();
}//GEN-LAST:event_txtNameSearchCaretUpdate

    private void txtIdSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtIdSearchCaretUpdate

        loadData();
}//GEN-LAST:event_txtIdSearchCaretUpdate

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        txtIdSearch.setText(null);
        txtNameSearch.setText(null);

}//GEN-LAST:event_btnResetActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        if (isAdd) {
            isAdd = false;
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            txtId.setVisible(true);
            btnCancel.setVisible(false);
        } else {
            loadDetails(listPermssion.get(0));
        }
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            int id = Integer.parseInt(txtId.getText());
            if (perDao.delete(id)) {
                JOptionPane.showMessageDialog(this, perDao.getLastError(), "Delete Permission", JOptionPane.INFORMATION_MESSAGE, null);
                listPermssion.remove(find(id));
                loadData();
                if (!listPermssion.isEmpty()) {
                    loadDetails(listPermssion.get(0));
                }
            } else {
                JOptionPane.showMessageDialog(this, perDao.getLastError(), "Delete Permission", JOptionPane.ERROR_MESSAGE, null);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error! Check again, please.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        try {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            if (name.length() != 0) {
                Permission per = new Permission(id, name);
                if (perDao.update(per)) {
                    JOptionPane.showMessageDialog(this, perDao.getLastError(), "Update Permission", JOptionPane.INFORMATION_MESSAGE);
                    listPermssion.remove(find(id));
                    listPermssion.add(per);
                    loadData();
                    loadDetails(per);
                    isAdd = false;
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, perDao.getLastError(), "Update Permission", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Enter full information, please", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error System", "Error!", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        try {
            if (!isAdd) {
                isAdd = true;
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
                btnCancel.setVisible(true);
                txtId.setText(null);
                txtName.setText(null);
            } else {
                int id = 0;
                String name = txtName.getText();
                if (name.length() != 0) {
                    Permission per = new Permission(id, name);
                    if (perDao.create(per)) {
                        per = perDao.readByName(name);
                        per.setId(perDao.readByName(name).getId());

                        listPermssion.add(per);
                        loadData();
                        loadDetails(per);
                        isAdd = false;
                        btnUpdate.setEnabled(true);
                        btnDelete.setEnabled(true);
                        btnCancel.setVisible(false);
                        JOptionPane.showMessageDialog(this, perDao.getLastError(), "Create Permission", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, perDao.getLastError(), "Create Permission", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Enter full information, please", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Permission", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnAddActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel lblEnterNameStudent;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleSearch;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsernameSearch;
    private javax.swing.JLabel lblcheck1;
    private javax.swing.JLabel lblcheck2;
    private javax.swing.JLabel lblcheck4Search;
    private javax.swing.JLabel lblcheckSearch;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelButtonSearch;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelRightSearch;
    public javax.swing.JPanel pnlEdit;
    public javax.swing.JPanel pnlSearch;
    private javax.swing.JSeparator sepaAccount;
    private javax.swing.JSeparator sepaAccountSearch;
    private javax.swing.JScrollPane srcPanelPermission;
    private javax.swing.JTable tableContent;
    public javax.swing.JTabbedPane tpPermission;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdSearch;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameSearch;
    // End of variables declaration//GEN-END:variables

    String getSelectedCode() {
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
