
/*
 * frmAcc.java
 *
 * Created on Mar 31, 2011, 2:46:44 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.AccountDAO;
import com.hueic.CerGS.dao.PermissionDAO;
import com.hueic.CerGS.dao.PersonDAO;
import com.hueic.CerGS.entity.Account;
import com.hueic.CerGS.entity.Permission;
import com.hueic.CerGS.entity.Person;
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
public class pnlAccount extends javax.swing.JPanel {

    /** Creates new form frmAcc */
    private ArrayList<Account> listAccounts = new ArrayList<Account>();
    private ArrayList<Person> listPersons = new ArrayList<Person>();
    private AccountDAO accDao;
    boolean isAdd = false;
    private PersonDAO personDao;
    private ObjectTableModel tableModel;
    private JTable headerTable;
    frmMain frm;
    ArrayList<Account> filter = null;

    public pnlAccount() {
        initComponents();
        accDao = new AccountDAO();
        personDao = new PersonDAO();
        btnCancel.setVisible(false);
        getData();

    }

    public void getData() {
        listPersons = personDao.readByAllNotAcc();
        listAccounts = accDao.readByAll();
        if (!listAccounts.isEmpty()) {
            loadData();
            binddingPerson();
            loadDetails(listAccounts.get(0));
            isAdd = false;
            cbxUsername.setVisible(false);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnCancel.setVisible(false);
            txtUsername.setVisible(true);
        }
    }

    public void binddingPerson() {
        if (cbxUsername.getItemCount() != 0) {
            cbxUsername.removeAllItems();
        }
        for (Person person : listPersons) {
            cbxUsername.addItem(person.getId());
        }
    }

    public pnlAccount(frmMain frm) {
        initComponents();
        this.frm = frm;
        accDao = new AccountDAO();
        personDao = new PersonDAO();
        btnCancel.setVisible(false);
        getData();
    }

    public void loadData() {
        try {
            filter = new ArrayList<Account>();
            for (Account acc : listAccounts) {
                if (acc.getUsername().toLowerCase().matches(".*" + txtUsernameSearch.getText().trim().toLowerCase() + ".*")
                        && String.valueOf(acc.getPermission()).toLowerCase().matches(".*" + txtPermissionSearch.getText().trim().toLowerCase() + ".*")) {
                    filter.add(acc);
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
            filter = new ArrayList<Account>();
            for (Account acc : listAccounts) {
                if (acc.getUsername().toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")
                        || String.valueOf(acc.getPermission()).toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")) {
                    filter.add(acc);
                }
            }
            if (!filter.isEmpty()) {
                loadDetails(filter.get(0));
            }
            loadTable(filter);
        } catch (Exception ex) {
        }
    }

    public void loadTable(ArrayList<Account> filter) {
        ColumnData[] columns = {
            new ColumnData("Username", 135, SwingConstants.CENTER, 1),
            new ColumnData("Permission", 140, SwingConstants.CENTER, 3),};
        tableModel = new ObjectTableModel(tableContent, columns, filter);
        headerTable = tableModel.getHeaderTable();
        headerTable.createDefaultColumnsFromModel();
        tableContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JViewport viewport = new JViewport();
        viewport.setView(headerTable);
        viewport.setPreferredSize(headerTable.getMaximumSize());
        srcPanelAccount.setRowHeader(viewport);
        srcPanelAccount.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    public void loadDetails(Account acc) {
        txtUsername.setText(acc.getUsername().trim());
        txtPassword.setText(acc.getPassword().trim());
        txtConfirmPassword.setText(acc.getPassword().trim());
        txtType.setText(String.valueOf(acc.getPermission()));
    }

    public String getNamePermission(int id) {
        PermissionDAO permissionDAO = new PermissionDAO();
        Permission per = permissionDAO.readByID(id);
        if (per != null) {
            return per.getName();
        } else {
            return null;
        }
    }

    public Account find(String value) {
        for (int i = 0; i < listAccounts.size(); i++) {
            if (listAccounts.get(i).getUsername().equalsIgnoreCase(value)) {
                return listAccounts.get(i);
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlDown = new javax.swing.JPanel();
        srcPanelAccount = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        lblEnterFilter = new javax.swing.JLabel();
        tpAccount = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        pnlTop1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        sepaAccount = new javax.swing.JSeparator();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblConfirmPass = new javax.swing.JLabel();
        pnllButtonEdit = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        lblType = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        btnChoosePermission = new javax.swing.JButton();
        txtType = new javax.swing.JTextField();
        cbxUsername = new javax.swing.JComboBox();
        pnlSearch = new javax.swing.JPanel();
        pnlTop2 = new javax.swing.JPanel();
        lblTitleSearch = new javax.swing.JLabel();
        sepaAccountSearch = new javax.swing.JSeparator();
        lblUsernameSearch = new javax.swing.JLabel();
        pnlButtonSearch = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        txtUsernameSearch = new javax.swing.JTextField();
        lblTypeSearch = new javax.swing.JLabel();
        btnChoosePerSearch = new javax.swing.JButton();
        txtPermissionSearch = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(860, 600));
        setMinimumSize(new java.awt.Dimension(860, 600));
        setPreferredSize(new java.awt.Dimension(860, 600));
        setLayout(new java.awt.GridBagLayout());

        pnlDown.setBackground(new java.awt.Color(255, 255, 255));
        pnlDown.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Account", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        pnlDown.setMinimumSize(new java.awt.Dimension(860, 400));
        pnlDown.setPreferredSize(new java.awt.Dimension(860, 400));
        pnlDown.setLayout(new java.awt.GridBagLayout());

        srcPanelAccount.setAutoscrolls(true);
        srcPanelAccount.setMinimumSize(new java.awt.Dimension(840, 340));
        srcPanelAccount.setPreferredSize(new java.awt.Dimension(840, 340));

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
        srcPanelAccount.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlDown.add(srcPanelAccount, gridBagConstraints);

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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 490, 5, 5);
        pnlDown.add(lblEnterFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(pnlDown, gridBagConstraints);

        tpAccount.setMinimumSize(new java.awt.Dimension(860, 200));
        tpAccount.setPreferredSize(new java.awt.Dimension(860, 200));

        pnlEdit.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlEdit.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlEdit.setLayout(new java.awt.GridBagLayout());

        pnlTop1.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop1.setMinimumSize(new java.awt.Dimension(860, 200));
        pnlTop1.setPreferredSize(new java.awt.Dimension(860, 200));
        pnlTop1.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Account");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlTop1.add(lblTitle, gridBagConstraints);

        sepaAccount.setMinimumSize(new java.awt.Dimension(700, 10));
        sepaAccount.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlTop1.add(sepaAccount, gridBagConstraints);

        lblUsername.setForeground(new java.awt.Color(3, 3, 3));
        lblUsername.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        pnlTop1.add(lblUsername, gridBagConstraints);

        lblPassword.setForeground(new java.awt.Color(3, 3, 3));
        lblPassword.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        pnlTop1.add(lblPassword, gridBagConstraints);

        lblConfirmPass.setForeground(new java.awt.Color(3, 3, 3));
        lblConfirmPass.setText("Confirm password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop1.add(lblConfirmPass, gridBagConstraints);

        pnllButtonEdit.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAdd.setMaximumSize(new java.awt.Dimension(80, 23));
        btnAdd.setMinimumSize(new java.awt.Dimension(80, 23));
        btnAdd.setPreferredSize(new java.awt.Dimension(80, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnllButtonEdit.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnUpdate.setMaximumSize(new java.awt.Dimension(80, 23));
        btnUpdate.setMinimumSize(new java.awt.Dimension(80, 23));
        btnUpdate.setPreferredSize(new java.awt.Dimension(80, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnllButtonEdit.add(btnUpdate);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnDelete.setMaximumSize(new java.awt.Dimension(80, 23));
        btnDelete.setMinimumSize(new java.awt.Dimension(80, 23));
        btnDelete.setPreferredSize(new java.awt.Dimension(80, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnllButtonEdit.add(btnDelete);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnCancel.setMaximumSize(new java.awt.Dimension(70, 23));
        btnCancel.setMinimumSize(new java.awt.Dimension(70, 23));
        btnCancel.setPreferredSize(new java.awt.Dimension(70, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnllButtonEdit.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 5, 0);
        pnlTop1.add(pnllButtonEdit, gridBagConstraints);

        txtUsername.setEnabled(false);
        txtUsername.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtUsername, gridBagConstraints);

        lblType.setForeground(new java.awt.Color(3, 3, 3));
        lblType.setText("Type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop1.add(lblType, gridBagConstraints);

        txtPassword.setMinimumSize(new java.awt.Dimension(200, 20));
        txtPassword.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtPassword, gridBagConstraints);

        txtConfirmPassword.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtConfirmPassword, gridBagConstraints);

        btnChoosePermission.setText("jButton4");
        btnChoosePermission.setMaximumSize(new java.awt.Dimension(23, 23));
        btnChoosePermission.setMinimumSize(new java.awt.Dimension(23, 23));
        btnChoosePermission.setPreferredSize(new java.awt.Dimension(23, 20));
        btnChoosePermission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoosePermissionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(btnChoosePermission, gridBagConstraints);

        txtType.setMinimumSize(new java.awt.Dimension(200, 20));
        txtType.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtType, gridBagConstraints);

        cbxUsername.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxUsername.setMaximumSize(new java.awt.Dimension(200, 20));
        cbxUsername.setMinimumSize(new java.awt.Dimension(200, 20));
        cbxUsername.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        pnlTop1.add(cbxUsername, gridBagConstraints);

        pnlEdit.add(pnlTop1, new java.awt.GridBagConstraints());

        tpAccount.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlSearch.setLayout(new java.awt.GridBagLayout());

        pnlTop2.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop2.setMinimumSize(new java.awt.Dimension(860, 200));
        pnlTop2.setPreferredSize(new java.awt.Dimension(860, 200));
        pnlTop2.setLayout(new java.awt.GridBagLayout());

        lblTitleSearch.setFont(new java.awt.Font("Tahoma", 1, 13));
        lblTitleSearch.setForeground(new java.awt.Color(102, 0, 102));
        lblTitleSearch.setText("Information Account");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlTop2.add(lblTitleSearch, gridBagConstraints);

        sepaAccountSearch.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlTop2.add(sepaAccountSearch, gridBagConstraints);

        lblUsernameSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblUsernameSearch.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        pnlTop2.add(lblUsernameSearch, gridBagConstraints);

        pnlButtonSearch.setBackground(new java.awt.Color(255, 255, 255));
        pnlButtonSearch.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnReset.setMaximumSize(new java.awt.Dimension(80, 23));
        btnReset.setMinimumSize(new java.awt.Dimension(80, 23));
        btnReset.setPreferredSize(new java.awt.Dimension(80, 23));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        pnlButtonSearch.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 10, 0);
        pnlTop2.add(pnlButtonSearch, gridBagConstraints);

        txtUsernameSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtUsernameSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtUsernameSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(txtUsernameSearch, gridBagConstraints);

        lblTypeSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblTypeSearch.setText("Type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop2.add(lblTypeSearch, gridBagConstraints);

        btnChoosePerSearch.setText("jButton4");
        btnChoosePerSearch.setMaximumSize(new java.awt.Dimension(23, 23));
        btnChoosePerSearch.setMinimumSize(new java.awt.Dimension(23, 23));
        btnChoosePerSearch.setPreferredSize(new java.awt.Dimension(23, 20));
        btnChoosePerSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoosePerSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(btnChoosePerSearch, gridBagConstraints);

        txtPermissionSearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtPermissionSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtPermissionSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPermissionSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(txtPermissionSearch, gridBagConstraints);

        pnlSearch.add(pnlTop2, new java.awt.GridBagConstraints());

        tpAccount.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpAccount, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed

        loadFiter(filterText.getText());
}//GEN-LAST:event_btnFilterActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        try {
            if (!isAdd) {
                isAdd = true;
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
                btnCancel.setVisible(true);
                txtUsername.setEnabled(false);
                txtPassword.setText(null);
                txtConfirmPassword.setText(null);
                txtType.setText(null);
                cbxUsername.setVisible(true);
                txtUsername.setVisible(false);
            } else {
                if (cbxUsername.getSelectedItem().toString().length() != 0
                        && String.valueOf(txtConfirmPassword.getPassword()).length() != 0
                        && String.valueOf(txtPassword.getPassword()).length() != 0
                        && txtType.getText().length() != 0) {
                    String username = cbxUsername.getSelectedItem().toString();
                    String password = String.valueOf(txtPassword.getPassword());
                    String confirmPass = String.valueOf(txtConfirmPassword.getPassword());
                    int permission = Integer.parseInt(txtType.getText());
                    Account acc = null;
                    try {
                        acc = new Account(username, password, permission);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Account Create", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (password.equals(confirmPass) && password.length() != 0) {
                        if (accDao.create(acc)) {
                            JOptionPane.showMessageDialog(this, accDao.getLastError(), "Account Create", JOptionPane.INFORMATION_MESSAGE);
                            listAccounts.add(acc);
                            loadData();
                            loadDetails(acc);
                            isAdd = false;
                            btnUpdate.setEnabled(true);
                            btnDelete.setEnabled(true);
                            txtUsername.setVisible(true);
                            btnCancel.setVisible(false);
                            cbxUsername.setVisible(false);
                            txtUsername.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, accDao.getLastError(), "Account Create", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Password not match", "Account Create", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Enter full information, please", "Account Create", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, toString(), "Account Create", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        try {
            if (cbxUsername.getSelectedItem().toString().length() != 0
                    && String.valueOf(txtConfirmPassword.getPassword()).length() != 0
                    && String.valueOf(txtPassword.getPassword()).length() != 0
                    && txtType.getText().length() != 0) {
                String username = txtUsername.getText();
                String password = String.valueOf(txtPassword.getPassword());
                String confirmPass = String.valueOf(txtConfirmPassword.getPassword());
                int permission = Integer.parseInt(txtType.getText());
                if (password.equals(confirmPass) && password.length() != 0) {
                    Account acc = null;
                    try {
                        acc = new Account(username, password, permission);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Account Update", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (accDao.update(acc)) {
                        JOptionPane.showMessageDialog(this, accDao.getLastError(), "Account Update", JOptionPane.INFORMATION_MESSAGE);
                        listAccounts.set(listAccounts.indexOf(find(acc.getUsername())), acc);
                        loadData();
                        loadDetails(acc);
                    } else {
                        JOptionPane.showMessageDialog(this, accDao.getLastError(), "Account Update", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Password not match", "Account Update", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Enter full information, please", "Account Update", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Account Update", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            String username = txtUsername.getText();
            if (username.length() != 0) {
                if (accDao.delete(username)) {
                    JOptionPane.showMessageDialog(this, accDao.getLastError(), "Account Delete", JOptionPane.INFORMATION_MESSAGE, null);
                    listAccounts.remove(find(username));
                    loadData();
                    if (!listAccounts.isEmpty()) {
                        loadDetails(listAccounts.get(0));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, accDao.getLastError(), "Account Delete", JOptionPane.ERROR_MESSAGE, null);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Enter full information, please", "Account Delete", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error! check again, please", "Account Delete", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        if (isAdd) {
            isAdd = false;
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            txtUsername.setEnabled(false);
            btnCancel.setVisible(false);
            cbxUsername.setVisible(false);
            txtUsername.setVisible(true);
            loadDetails(listAccounts.get(0));
        }
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        txtUsernameSearch.setText(null);
        txtPermissionSearch.setText(null);
}//GEN-LAST:event_btnResetActionPerformed

    private void btnChoosePermissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoosePermissionActionPerformed

        dlgChoose dlg = new dlgChoose(frm, txtType, true, 11);
        dlg.setTitle("Browse Permission");
        dlg.setSize(868, 600);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnChoosePermissionActionPerformed

    private void tableContentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseReleased

        try {

            int index = tableContent.getSelectedRow();
            if (index != -1) {
                String value = tableContent.getValueAt(index, 0).toString();
                Account acc = find(value);
                if (acc != null) {
                    loadDetails(acc);
                }
                if (isAdd) {
                    isAdd = false;
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                    btnCancel.setVisible(false);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tableContentMouseReleased

    private void filterTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_filterTextCaretUpdate

        loadFiter(filterText.getText());
    }//GEN-LAST:event_filterTextCaretUpdate

    private void txtUsernameSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtUsernameSearchCaretUpdate

        loadData();
    }//GEN-LAST:event_txtUsernameSearchCaretUpdate

    private void txtPermissionSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPermissionSearchCaretUpdate

        loadData();
    }//GEN-LAST:event_txtPermissionSearchCaretUpdate

    private void btnChoosePerSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoosePerSearchActionPerformed

        dlgChoose dlg = new dlgChoose(frm, txtPermissionSearch, true, 11);
        dlg.setTitle("Browse Permission");
        dlg.setSize(868, 580);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnChoosePerSearchActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChoosePerSearch;
    private javax.swing.JButton btnChoosePermission;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbxUsername;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel lblConfirmPass;
    private javax.swing.JLabel lblEnterFilter;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleSearch;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblTypeSearch;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsernameSearch;
    private javax.swing.JPanel pnlButtonSearch;
    private javax.swing.JPanel pnlDown;
    private javax.swing.JPanel pnlEdit;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlTop1;
    private javax.swing.JPanel pnlTop2;
    private javax.swing.JPanel pnllButtonEdit;
    private javax.swing.JSeparator sepaAccount;
    private javax.swing.JSeparator sepaAccountSearch;
    private javax.swing.JScrollPane srcPanelAccount;
    private javax.swing.JTable tableContent;
    public javax.swing.JTabbedPane tpAccount;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPermissionSearch;
    private javax.swing.JTextField txtType;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsernameSearch;
    // End of variables declaration//GEN-END:variables
}
