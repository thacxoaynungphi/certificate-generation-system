/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class pnlAccount extends javax.swing.JPanel {

    /** Creates new form frmAcc */
    private ArrayList<Account> listAccounts = new ArrayList<Account>();
    private AccountDAO accDao;
    TableRowSorter<TableModel> sorter;
    boolean isAdd = false;
    private PermissionDAO permissionDao;
    private PersonDAO personDao;
    private ObjectTableModel tableModel;
    private JTable headerTable;
    frmMain frm;

    public pnlAccount() {
        initComponents();
        accDao = new AccountDAO();
        permissionDao = new PermissionDAO();
        personDao = new PersonDAO();
        listAccounts = accDao.readByAll();
        loadDataCBXUsername();
        loadData(listAccounts);
        if (listAccounts.size() != 0) {
            loadDetails(listAccounts.get(0));
        }
    }

    public pnlAccount(frmMain frm) {
        initComponents();
        this.frm = frm;
        accDao = new AccountDAO();
        permissionDao = new PermissionDAO();
        personDao = new PersonDAO();
        listAccounts = accDao.readByAll();
        loadDataCBXUsername();
        loadData(listAccounts);
        if (listAccounts.size() != 0) {
            loadDetails(listAccounts.get(0));
        }
    }

    public void loadDataCBXUsername() {
        cbxUsername.removeAllItems();
        ArrayList<Person> listPerson = personDao.readByAllNotAcc();
        for (int i = 0; i < listPerson.size(); i++) {
            cbxUsername.addItem(listPerson.get(i).getId());
        }
    }

    public void loadData(ArrayList<Account> listAccounts) {

        ColumnData[] columns = {
            new ColumnData("Username", 135, SwingConstants.LEFT, 1),
            new ColumnData("Password", 100, SwingConstants.LEFT, 2),
            new ColumnData("Permission", 140, SwingConstants.LEFT, 3),};
        tableModel = new ObjectTableModel(tableContent, columns, listAccounts);
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelRight = new javax.swing.JPanel();
        srcPanelAccount = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        tpAccount = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        sepaAccount = new javax.swing.JSeparator();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblConfirmPass = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        lblType = new javax.swing.JLabel();
        cbxUsername = new javax.swing.JComboBox();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtType = new javax.swing.JTextField();
        pnlSearch = new javax.swing.JPanel();
        panel3 = new javax.swing.JPanel();
        lblTitle1 = new javax.swing.JLabel();
        sepaAccount1 = new javax.swing.JSeparator();
        lblUsername1 = new javax.swing.JLabel();
        lblPassword1 = new javax.swing.JLabel();
        lblConfirmPass1 = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        btnAdd1 = new javax.swing.JButton();
        txtUsername1 = new javax.swing.JTextField();
        lblType1 = new javax.swing.JLabel();
        cbxUsername1 = new javax.swing.JComboBox();
        txtPassword1 = new javax.swing.JPasswordField();
        txtConfirmPassword1 = new javax.swing.JPasswordField();
        jButton8 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.GridBagLayout());

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Account", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelRight.setMinimumSize(new java.awt.Dimension(800, 400));
        panelRight.setPreferredSize(new java.awt.Dimension(800, 400));
        panelRight.setLayout(new java.awt.GridBagLayout());

        srcPanelAccount.setMinimumSize(new java.awt.Dimension(800, 200));
        srcPanelAccount.setPreferredSize(new java.awt.Dimension(800, 200));

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
        tableContent.setPreferredSize(new java.awt.Dimension(350, 222));
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContentMouseClicked(evt);
            }
        });
        srcPanelAccount.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(srcPanelAccount, gridBagConstraints);

        filterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filterTextKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 132;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 550, 5, 5);
        panelRight.add(filterText, gridBagConstraints);

        btnFilter.setText("Filter");
        btnFilter.setMaximumSize(new java.awt.Dimension(57, 20));
        btnFilter.setMinimumSize(new java.awt.Dimension(57, 20));
        btnFilter.setPreferredSize(new java.awt.Dimension(90, 20));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(btnFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelRight, gridBagConstraints);

        tpAccount.setMinimumSize(new java.awt.Dimension(800, 200));

        pnlEdit.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlEdit.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlEdit.setLayout(new java.awt.GridBagLayout());

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setMinimumSize(new java.awt.Dimension(800, 200));
        panel1.setPreferredSize(new java.awt.Dimension(800, 200));
        panel1.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Account");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panel1.add(lblTitle, gridBagConstraints);

        sepaAccount.setMinimumSize(new java.awt.Dimension(650, 10));
        sepaAccount.setPreferredSize(new java.awt.Dimension(650, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panel1.add(sepaAccount, gridBagConstraints);

        lblUsername.setForeground(new java.awt.Color(3, 3, 3));
        lblUsername.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panel1.add(lblUsername, gridBagConstraints);

        lblPassword.setForeground(new java.awt.Color(3, 3, 3));
        lblPassword.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panel1.add(lblPassword, gridBagConstraints);

        lblConfirmPass.setForeground(new java.awt.Color(3, 3, 3));
        lblConfirmPass.setText("Confirm password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panel1.add(lblConfirmPass, gridBagConstraints);

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

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
        panel2.add(btnAdd);

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
        panel2.add(btnUpdate);

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
        panel2.add(btnDelete);

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
        panel2.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        panel1.add(panel2, gridBagConstraints);

        txtUsername.setEnabled(false);
        txtUsername.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel1.add(txtUsername, gridBagConstraints);

        lblType.setForeground(new java.awt.Color(3, 3, 3));
        lblType.setText("Type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panel1.add(lblType, gridBagConstraints);

        cbxUsername.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxUsername.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel1.add(cbxUsername, gridBagConstraints);

        txtPassword.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel1.add(txtPassword, gridBagConstraints);

        txtConfirmPassword.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel1.add(txtConfirmPassword, gridBagConstraints);

        jButton1.setText("jButton1");
        jButton1.setMaximumSize(new java.awt.Dimension(23, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(23, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(23, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel1.add(jButton1, gridBagConstraints);

        jButton4.setText("jButton4");
        jButton4.setMaximumSize(new java.awt.Dimension(23, 23));
        jButton4.setMinimumSize(new java.awt.Dimension(23, 23));
        jButton4.setPreferredSize(new java.awt.Dimension(23, 20));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel1.add(jButton4, gridBagConstraints);

        txtType.setMinimumSize(new java.awt.Dimension(200, 20));
        txtType.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel1.add(txtType, gridBagConstraints);

        pnlEdit.add(panel1, new java.awt.GridBagConstraints());

        tpAccount.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlSearch.setLayout(new java.awt.GridBagLayout());

        panel3.setBackground(new java.awt.Color(255, 255, 255));
        panel3.setMinimumSize(new java.awt.Dimension(800, 200));
        panel3.setPreferredSize(new java.awt.Dimension(800, 200));
        panel3.setLayout(new java.awt.GridBagLayout());

        lblTitle1.setFont(new java.awt.Font("Tahoma", 1, 13));
        lblTitle1.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle1.setText("Information Account");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        panel3.add(lblTitle1, gridBagConstraints);

        sepaAccount1.setPreferredSize(new java.awt.Dimension(350, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 10, 0);
        panel3.add(sepaAccount1, gridBagConstraints);

        lblUsername1.setForeground(new java.awt.Color(3, 3, 3));
        lblUsername1.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panel3.add(lblUsername1, gridBagConstraints);

        lblPassword1.setForeground(new java.awt.Color(3, 3, 3));
        lblPassword1.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panel3.add(lblPassword1, gridBagConstraints);

        lblConfirmPass1.setForeground(new java.awt.Color(3, 3, 3));
        lblConfirmPass1.setText("Confirm password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panel3.add(lblConfirmPass1, gridBagConstraints);

        panel4.setBackground(new java.awt.Color(255, 255, 255));
        panel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/update.jpg"))); // NOI18N
        btnAdd1.setText("Reset");
        btnAdd1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAdd1.setMaximumSize(new java.awt.Dimension(80, 23));
        btnAdd1.setMinimumSize(new java.awt.Dimension(80, 23));
        btnAdd1.setPreferredSize(new java.awt.Dimension(80, 23));
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        panel4.add(btnAdd1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 10, 0);
        panel3.add(panel4, gridBagConstraints);

        txtUsername1.setEnabled(false);
        txtUsername1.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel3.add(txtUsername1, gridBagConstraints);

        lblType1.setForeground(new java.awt.Color(3, 3, 3));
        lblType1.setText("Type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panel3.add(lblType1, gridBagConstraints);

        cbxUsername1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxUsername1.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel3.add(cbxUsername1, gridBagConstraints);

        txtPassword1.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel3.add(txtPassword1, gridBagConstraints);

        txtConfirmPassword1.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel3.add(txtConfirmPassword1, gridBagConstraints);

        jButton8.setText("jButton4");
        jButton8.setMaximumSize(new java.awt.Dimension(23, 23));
        jButton8.setMinimumSize(new java.awt.Dimension(23, 23));
        jButton8.setPreferredSize(new java.awt.Dimension(23, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel3.add(jButton8, gridBagConstraints);

        jTextField2.setMinimumSize(new java.awt.Dimension(200, 20));
        jTextField2.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel3.add(jTextField2, gridBagConstraints);

        pnlSearch.add(panel3, new java.awt.GridBagConstraints());

        tpAccount.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpAccount, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        try {
            // TODO add your handling code here:
            int index = tableContent.getSelectedRow();
            if (index != -1) {
                String value = tableContent.getValueAt(index, 0).toString();
                Account acc = find(value);
                if (acc != null) {
                    loadDetails(acc);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_tableContentMouseClicked

    public void searchStart() {
        if (listAccounts.size() != 0) {
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
    private void filterTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTextKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            searchStart();
        }
}//GEN-LAST:event_filterTextKeyPressed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        searchStart();
}//GEN-LAST:event_btnFilterActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            if (!isAdd) {
                isAdd = true;
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
                txtUsername.setVisible(false);
                cbxUsername.setVisible(true);
                txtPassword.setText(null);
                txtConfirmPassword.setText(null);
                txtType.setText(null);
            } else {
                String username = cbxUsername.getSelectedItem().toString();
                String password = String.valueOf(txtPassword.getPassword());
                String confirmPass = String.valueOf(txtConfirmPassword.getPassword());
                int permission = Integer.parseInt(txtType.getText());
                if (password.equals(confirmPass) && password.length() != 0) {
                    Account acc = new Account(username, password, permission);
                    AccountDAO accDao = new AccountDAO();
                    if (accDao.create(acc)) {
                        JOptionPane.showMessageDialog(this, accDao.getLastError(), "Create Account", JOptionPane.INFORMATION_MESSAGE);
                        listAccounts.add(acc);
                        loadData(listAccounts);
                        loadDetails(acc);
                        isAdd = false;
                        btnUpdate.setEnabled(true);
                        btnDelete.setEnabled(true);
                        txtUsername.setVisible(true);
                        cbxUsername.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(this, accDao.getLastError(), "Create Account", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Password not match", "Create Account", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, toString(), "Create Account", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            String username = txtUsername.getText();
            String password = String.valueOf(txtPassword.getPassword());
            String confirmPass = String.valueOf(txtConfirmPassword.getPassword());
            int permission = Integer.parseInt(txtType.getText());
            if (password.equals(confirmPass) && password.length() != 0) {
                Account acc = new Account(username, password, permission);
                AccountDAO accDao = new AccountDAO();
                if (accDao.update(acc)) {
                    JOptionPane.showMessageDialog(this, accDao.getLastError(), "Update Account", JOptionPane.INFORMATION_MESSAGE);
                    //listAccounts.remove(find(acc.getUsername()));
                    listAccounts.set(listAccounts.indexOf(find(acc.getUsername())), acc);
                    loadData(listAccounts);
                    loadDetails(acc);
                } else {
                    JOptionPane.showMessageDialog(this, accDao.getLastError(), "Update Account", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Password not match", "Create Account", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            String username = txtUsername.getText();
            if (accDao.delete(username)) {
                JOptionPane.showMessageDialog(this, accDao.getLastError(), "Delete Account", JOptionPane.INFORMATION_MESSAGE, null);
                listAccounts.remove(find(username));
                loadData(listAccounts);
                if (listAccounts.size() != 0) {
                    loadDataCBXUsername();
                    loadDetails(listAccounts.get(0));
                }
            } else {
                JOptionPane.showMessageDialog(this, accDao.getLastError(), "Delete Account", JOptionPane.ERROR_MESSAGE, null);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        if (isAdd) {
            isAdd = false;
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            txtUsername.setVisible(true);
            cbxUsername.setVisible(false);
        } else {
            loadDetails(listAccounts.get(0));
        }
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnAdd1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtType, true, 11);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbxUsername;
    private javax.swing.JComboBox cbxUsername1;
    private javax.swing.JTextField filterText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblConfirmPass;
    private javax.swing.JLabel lblConfirmPass1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblType1;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsername1;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel pnlEdit;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JSeparator sepaAccount;
    private javax.swing.JSeparator sepaAccount1;
    private javax.swing.JScrollPane srcPanelAccount;
    private javax.swing.JTable tableContent;
    public javax.swing.JTabbedPane tpAccount;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JPasswordField txtConfirmPassword1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPassword1;
    private javax.swing.JTextField txtType;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsername1;
    // End of variables declaration//GEN-END:variables
}
