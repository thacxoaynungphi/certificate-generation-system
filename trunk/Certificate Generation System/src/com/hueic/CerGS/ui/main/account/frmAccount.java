/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmAccount.java
 *
 * Created on Mar 16, 2011, 8:16:51 PM
 */
package com.hueic.CerGS.ui.main.account;

import com.hueic.CerGS.component.IconSystem;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author nhchung
 */
public class frmAccount extends javax.swing.JFrame {

    /** Creates new form frmAccount */
    private ArrayList<Account> listAccounts = new ArrayList<Account>();
    private AccountDAO accDao;
    TableRowSorter<TableModel> sorter;
    boolean isAdd = false;
    private PermissionDAO permissionDao;
    private PersonDAO personDao;

    public frmAccount() {
        initComponents();
        new IconSystem(this);
        setLocationRelativeTo(null);
        accDao = new AccountDAO();
        permissionDao = new PermissionDAO();
        personDao = new PersonDAO();
        listAccounts = accDao.readByAll();
        loadDataCBXPermission();
        loadDataCBXUsername();
        loadData(listAccounts);
        if (listAccounts.size() != 0) {
            loadDetails(listAccounts.get(0));
        }
    }

    public void loadDataCBXPermission() {
        cbxType.removeAllItems();
        ArrayList<Permission> listPermission = permissionDao.readByAll();
        for (int i = 0; i < listPermission.size(); i++) {
            cbxType.addItem(listPermission.get(i).getName());
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
        String[] columns = {"Username", "Permisison"};
        Object[][] rows = new Object[listAccounts.size()][3];
        int index = 0;
        for (int i = 0; i < listAccounts.size(); i++) {
            Account acc = listAccounts.get(i);
            rows[index][0] = acc.getUsername();
            rows[index][1] = getNamePermission(acc.getPermission());
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
                false, false
            };

            @Override
            public boolean isCellEditable(int row, int column) {
                return canEdit[column];
            }
        };
        tableContent = new JTable(model);
        tableContent.getTableHeader().setReorderingAllowed(false);
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
        srcPanelAccount.setRowHeader(viewPort);
        srcPanelAccount.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, tableContent.getTableHeader());
    }

    public void loadDetails(Account acc) {
        txtUsername.setText(acc.getUsername());
        txtPassword.setText(acc.getPassword());
        txtConfirmPassword.setText(acc.getPassword());
        String permissionName = getNamePermission(acc.getPermission());
        if (permissionName != null) {
            for (int i = 0; i < cbxType.getItemCount(); i++) {
                if (cbxType.getItemAt(i).toString().equals(permissionName)) {
                    cbxType.setSelectedIndex(i);
                }
            }
        }
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jToggleButton1 = new javax.swing.JToggleButton();
        panelLeft = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        panelRight = new javax.swing.JPanel();
        srcPanelAccount = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
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
        lblcheck1 = new javax.swing.JLabel();
        lblcheck2 = new javax.swing.JLabel();
        lblcheck3 = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        cbxType = new javax.swing.JComboBox();
        cbxUsername = new javax.swing.JComboBox();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Managment Account");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(832, 421));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setPreferredSize(new java.awt.Dimension(832, 100));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        lblLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Account.png"))); // NOI18N
        lblLogo.setPreferredSize(new java.awt.Dimension(831, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelLeft.add(lblLogo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelLeft, gridBagConstraints);

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Account", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelRight.setMinimumSize(new java.awt.Dimension(450, 320));
        panelRight.setPreferredSize(new java.awt.Dimension(450, 320));
        panelRight.setLayout(new java.awt.GridBagLayout());

        srcPanelAccount.setPreferredSize(new java.awt.Dimension(350, 200));

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
        tableContent.getColumnModel().getColumn(2).setResizable(false);

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
        gridBagConstraints.insets = new java.awt.Insets(5, 170, 5, 5);
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelRight, gridBagConstraints);

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Management Account", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panel1.setMinimumSize(new java.awt.Dimension(380, 320));
        panel1.setPreferredSize(new java.awt.Dimension(380, 320));
        panel1.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Account");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        panel1.add(lblTitle, gridBagConstraints);

        sepaAccount.setPreferredSize(new java.awt.Dimension(350, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 10, 0);
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
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panel1.add(lblConfirmPass, gridBagConstraints);

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnAdd.setPreferredSize(new java.awt.Dimension(70, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        panel2.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnUpdate.setPreferredSize(new java.awt.Dimension(70, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panel2.add(btnUpdate);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panel2.add(btnDelete);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel.setMaximumSize(new java.awt.Dimension(70, 23));
        btnCancel.setPreferredSize(new java.awt.Dimension(70, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        panel2.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel1.add(panel2, gridBagConstraints);

        txtUsername.setEnabled(false);
        txtUsername.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel1.add(txtUsername, gridBagConstraints);

        lblcheck1.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        panel1.add(lblcheck1, gridBagConstraints);

        lblcheck2.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        panel1.add(lblcheck2, gridBagConstraints);

        lblcheck3.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        panel1.add(lblcheck3, gridBagConstraints);

        lblType.setForeground(new java.awt.Color(3, 3, 3));
        lblType.setText("Type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panel1.add(lblType, gridBagConstraints);

        cbxType.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel1.add(cbxType, gridBagConstraints);

        cbxUsername.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxUsername.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel1.add(txtConfirmPassword, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Account find(String value) {
        for (int i = 0; i < listAccounts.size(); i++) {
            if (listAccounts.get(i).getUsername().equalsIgnoreCase(value)) {
                return listAccounts.get(i);
            }
        }
        return null;
    }

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

    public void searchStart(){
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
    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        searchStart();
    }//GEN-LAST:event_btnFilterActionPerformed

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
                if (cbxType.getItemCount() != 0) {
                    cbxType.setSelectedIndex(0);
                }
            } else {
                String username = cbxUsername.getSelectedItem().toString();
                String password = String.valueOf(txtPassword.getPassword());
                String confirmPass = String.valueOf(txtConfirmPassword.getPassword());
                String permissionName = cbxType.getSelectedItem().toString();
                if (password.equals(confirmPass) && password.length() != 0) {
                    PermissionDAO permissionDao = new PermissionDAO();
                    Permission per = permissionDao.readByName(permissionName);
                    if (per != null) {
                        Account acc = new Account(username, password, per.getId());
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
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Password not match", "Create Account", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, toString(), "Create Account", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

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

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            String username = txtUsername.getText();
            String password = String.valueOf(txtPassword.getPassword());
            String confirmPass = String.valueOf(txtConfirmPassword.getPassword());
            String permissionName = cbxType.getSelectedItem().toString();
            if (password.equals(confirmPass) && password.length() != 0) {
                //PermissionDAO permissionDao = new PermissionDAO();
                Permission per = permissionDao.readByName(permissionName);
                if (per != null) {
                    Account acc = new Account(username, password, per.getId());
                    AccountDAO accDao = new AccountDAO();
                    if (accDao.update(acc)) {
                        JOptionPane.showMessageDialog(this, accDao.getLastError(), "Update Account", JOptionPane.INFORMATION_MESSAGE);
                        //listAccounts.remove(find(acc.getUsername()));
                        listAccounts.set(listAccounts.indexOf(find(acc.getUsername())),acc);
                        loadData(listAccounts);
                        loadDetails(acc);
                    } else {
                        JOptionPane.showMessageDialog(this, accDao.getLastError(), "Update Account", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Password not match", "Create Account", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void filterTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTextKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            searchStart();
        }
    }//GEN-LAST:event_filterTextKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmAccount().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbxType;
    private javax.swing.JComboBox cbxUsername;
    private javax.swing.JTextField filterText;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblConfirmPass;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblcheck1;
    private javax.swing.JLabel lblcheck2;
    private javax.swing.JLabel lblcheck3;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JSeparator sepaAccount;
    private javax.swing.JScrollPane srcPanelAccount;
    private javax.swing.JTable tableContent;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
