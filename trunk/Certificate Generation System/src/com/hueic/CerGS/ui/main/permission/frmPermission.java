/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmAccount.java
 *
 * Created on Mar 16, 2011, 8:16:51 PM
 */
package com.hueic.CerGS.ui.main.permission;

import com.hueic.CerGS.component.IconSystem;
import com.hueic.CerGS.dao.PermissionDAO;
import com.hueic.CerGS.entity.Permission;
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
public class frmPermission extends javax.swing.JFrame {

    /** Creates new form frmAccount */
    private ArrayList<Permission> listPermssion = new ArrayList<Permission>();
    private PermissionDAO perDao;
    TableRowSorter<TableModel> sorter;
    boolean isAdd = false;

    public frmPermission() {
        initComponents();
        new IconSystem(this);
        setLocationRelativeTo(null);
        perDao = new PermissionDAO();
        listPermssion = perDao.readByAll();
        loadData(listPermssion);
        if (listPermssion.size() != 0) {
            loadDetails(listPermssion.get(0));
        }
    }

    public void loadData(ArrayList<Permission> listPermission) {
        String[] columns = {"ID", "Name"};
        Object[][] rows = new Object[listPermission.size()][2];
        int index = 0;
        for (int i = 0; i < listPermission.size(); i++) {
            Permission per = listPermission.get(i);
            rows[index][0] = per.getId();
            rows[index][1] = per.getName();
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
        srcPanelPermission.setRowHeader(viewPort);
        srcPanelPermission.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, tableContent.getTableHeader());
    }

    public void loadDetails(Permission per) {
        txtId.setText(String.valueOf(per.getId()).trim());
        txtName.setText(per.getName().trim());
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
        panelLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        panelLeft = new javax.swing.JPanel();
        srcPanelPermission = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
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

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Managment Account");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(832, 421));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelLogo.setBackground(new java.awt.Color(255, 255, 255));
        panelLogo.setPreferredSize(new java.awt.Dimension(832, 100));
        panelLogo.setLayout(new java.awt.GridBagLayout());

        lblLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Permission.png"))); // NOI18N
        lblLogo.setPreferredSize(new java.awt.Dimension(831, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelLogo.add(lblLogo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelLogo, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Permission", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(3, 3, 3))); // NOI18N
        panelLeft.setMinimumSize(new java.awt.Dimension(450, 320));
        panelLeft.setPreferredSize(new java.awt.Dimension(450, 320));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        srcPanelPermission.setPreferredSize(new java.awt.Dimension(350, 200));

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
        tableContent.setPreferredSize(new java.awt.Dimension(350, 200));
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContentMouseClicked(evt);
            }
        });
        srcPanelPermission.setViewportView(tableContent);
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
        panelLeft.add(srcPanelPermission, gridBagConstraints);

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
        panelLeft.add(filterText, gridBagConstraints);

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
        panelLeft.add(btnFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelLeft, gridBagConstraints);

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Management Permission", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(3, 3, 3))); // NOI18N
        panelRight.setMinimumSize(new java.awt.Dimension(380, 320));
        panelRight.setPreferredSize(new java.awt.Dimension(380, 320));
        panelRight.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Permission");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        panelRight.add(lblTitle, gridBagConstraints);

        sepaAccount.setPreferredSize(new java.awt.Dimension(300, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 10, 0);
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
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelRight.add(lblPassword, gridBagConstraints);

        panelButton.setBackground(new java.awt.Color(255, 255, 255));
        panelButton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnAdd.setPreferredSize(new java.awt.Dimension(70, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        panelButton.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnUpdate.setPreferredSize(new java.awt.Dimension(70, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panelButton.add(btnUpdate);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panelButton.add(btnDelete);

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
        panelButton.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(panelButton, gridBagConstraints);

        txtId.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtId, gridBagConstraints);

        lblcheck1.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        panelRight.add(lblcheck1, gridBagConstraints);

        lblcheck2.setText("(*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        panelRight.add(lblcheck2, gridBagConstraints);

        txtName.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtName, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelRight, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Permission find(int value) {
        for (int i = 0; i < listPermssion.size(); i++) {
            if (listPermssion.get(i).getId() == value) {
                return listPermssion.get(i);
            }
        }
        return null;
    }

    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        try {
            // TODO add your handling code here:
            int index = tableContent.getSelectedRow();

            if (index != -1) {
                int value = Integer.parseInt(tableContent.getValueAt(index, 0).toString());
                Permission per = find(value);
                if (per != null) {
                    loadDetails(per);
                }
            }
        } catch (Exception ex) {
            //TODO: chua xu ly
        }
    }//GEN-LAST:event_tableContentMouseClicked

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        searchStart();
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(txtId.getText());
        if (perDao.delete(id)) {
            JOptionPane.showMessageDialog(this, perDao.getLastError(), "Delete Permission", JOptionPane.INFORMATION_MESSAGE, null);
            listPermssion.remove(find(id));
            loadData(listPermssion);
            if (listPermssion.size() != 0) {
                loadDetails(listPermssion.get(0));
            }
        } else {
            JOptionPane.showMessageDialog(this, perDao.getLastError(), "Delete Permission", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            if (!isAdd) {
                isAdd = true;
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
                txtId.setVisible(false);
            } else {
                int id = Integer.parseInt(txtId.getText());
                String name = txtName.getText();
                Permission per = new Permission(id, name);
                if (perDao.create(per)) {
                    JOptionPane.showMessageDialog(this, perDao.getLastError(), "Create Permission", JOptionPane.INFORMATION_MESSAGE);
                    listPermssion.add(per);
                    loadData(listPermssion);
                    loadDetails(per);
                    isAdd = false;
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, perDao.getLastError(), "Create Permission", JOptionPane.ERROR_MESSAGE);
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
            txtId.setVisible(true);
        } else {
            loadDetails(listPermssion.get(0));
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            Permission per = new Permission(id, name);
            if (perDao.update(per)) {
                JOptionPane.showMessageDialog(this, perDao.getLastError(), "Update Permission", JOptionPane.INFORMATION_MESSAGE);
                listPermssion.add(per);
                loadData(listPermssion);
                loadDetails(per);
                isAdd = false;
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, perDao.getLastError(), "Update Permission", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    public void searchStart() {
        if (listPermssion.size() != 0) {
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmPermission().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField filterText;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblcheck1;
    private javax.swing.JLabel lblcheck2;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JPanel panelRight;
    private javax.swing.JSeparator sepaAccount;
    private javax.swing.JScrollPane srcPanelPermission;
    private javax.swing.JTable tableContent;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
