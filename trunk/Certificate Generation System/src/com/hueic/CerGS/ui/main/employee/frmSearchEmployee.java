/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmSearchStudent.java
 *
 * Created on Mar 26, 2011, 1:45:05 PM
 */
package com.hueic.CerGS.ui.main.employee;

import com.hueic.CerGS.dao.EmployeeDAO;
import com.hueic.CerGS.entity.Employee;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.PatternSyntaxException;
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
public class frmSearchEmployee extends javax.swing.JFrame {

    private ArrayList<Employee> listEmp;
    private ArrayList<Employee> listEmpTemp;
    private TableRowSorter<TableModel> sorter;
    private EmployeeDAO employeeDAO;

    /** Creates new form frmSearchStudent */
    public frmSearchEmployee() {
        initComponents();
        setLocationRelativeTo(null);
        employeeDAO = new EmployeeDAO();
        listEmp = employeeDAO.readByAll();
        listEmpTemp = new ArrayList<Employee>();

        if (!listEmp.isEmpty()) {
            loadEmployeeId();
            loadData(listEmp);

        }
    }

    public void loadEmployeeId() {
        cbxEmployeeId.removeAllItems();
        for (int i = 0; i < listEmp.size(); i++) {
            cbxEmployeeId.addItem(listEmp.get(i).getId());
        }
    }

    public void loadData(ArrayList<Employee> listEmp) {
        String[] column = {"Employee Id", "Employee Name", "Birthday", "Gender", "Phone", "Email", "Address"};
        Object[][] rows = new Object[listEmp.size()][7];

        int index = 0;
        for (int i = 0; i < listEmp.size(); i++) {

            rows[index][0] = listEmp.get(i).getId();
            rows[index][1] = listEmp.get(i).getFullName();
            rows[index][2] = listEmp.get(i).getBirthDay();
            rows[index][3] = listEmp.get(i).getGender();
            rows[index][4] = listEmp.get(i).getPhone();
            rows[index][5] = listEmp.get(i).getEmail();
            rows[index][6] = listEmp.get(i).getAddress();
            index++;
        }

        TableModel model = new DefaultTableModel(rows, column) {

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
                false, false, false, false, false, false, false, false
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

            private void tableContentMouseClicked(MouseEvent evt) {
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroupGender = new javax.swing.ButtonGroup();
        jHelp1 = new javax.help.JHelp();
        panelLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        panelInfo = new javax.swing.JPanel();
        cbxEmployeeId = new javax.swing.JComboBox();
        lblStudentId = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblBirthday = new javax.swing.JLabel();
        dateChooserDateStart = new com.toedter.calendar.JDateChooser();
        dateChooserDateEnd = new com.toedter.calendar.JDateChooser();
        lblGender = new javax.swing.JLabel();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        lblTitle = new javax.swing.JLabel();
        sepaCourse = new javax.swing.JSeparator();
        btnSearch = new javax.swing.JButton();
        pannelContent = new javax.swing.JPanel();
        srcPanelAccount = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        lblFilter = new javax.swing.JLabel();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Employee");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelLogo.setLayout(new java.awt.GridBagLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/SearchEmployee.png"))); // NOI18N
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

        panelInfo.setBackground(new java.awt.Color(255, 255, 255));
        panelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Employee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(3, 3, 3))); // NOI18N
        panelInfo.setMinimumSize(new java.awt.Dimension(250, 435));
        panelInfo.setPreferredSize(new java.awt.Dimension(250, 435));
        panelInfo.setLayout(new java.awt.GridBagLayout());

        cbxEmployeeId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxEmployeeId.setMinimumSize(new java.awt.Dimension(150, 20));
        cbxEmployeeId.setPreferredSize(new java.awt.Dimension(150, 20));
        cbxEmployeeId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEmployeeIdItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(cbxEmployeeId, gridBagConstraints);

        lblStudentId.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentId.setText("Employee ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblStudentId, gridBagConstraints);

        lblFirstName.setForeground(new java.awt.Color(3, 3, 3));
        lblFirstName.setText("First Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblFirstName, gridBagConstraints);

        txtFirstName.setMinimumSize(new java.awt.Dimension(150, 20));
        txtFirstName.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(txtFirstName, gridBagConstraints);

        lblLastName.setForeground(new java.awt.Color(3, 3, 3));
        lblLastName.setText("Last Name: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblLastName, gridBagConstraints);

        txtLastName.setMinimumSize(new java.awt.Dimension(150, 20));
        txtLastName.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(txtLastName, gridBagConstraints);

        lblBirthday.setForeground(new java.awt.Color(3, 3, 3));
        lblBirthday.setText("Birthday: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblBirthday, gridBagConstraints);

        dateChooserDateStart.setMinimumSize(new java.awt.Dimension(150, 20));
        dateChooserDateStart.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(dateChooserDateStart, gridBagConstraints);

        dateChooserDateEnd.setMinimumSize(new java.awt.Dimension(150, 20));
        dateChooserDateEnd.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(dateChooserDateEnd, gridBagConstraints);

        lblGender.setForeground(new java.awt.Color(3, 3, 3));
        lblGender.setText("Gender:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblGender, gridBagConstraints);

        radioMale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupGender.add(radioMale);
        radioMale.setForeground(new java.awt.Color(3, 3, 3));
        radioMale.setText("Male");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(radioMale, gridBagConstraints);

        radioFemale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupGender.add(radioFemale);
        radioFemale.setForeground(new java.awt.Color(3, 3, 3));
        radioFemale.setText("FeMale");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(radioFemale, gridBagConstraints);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Employee");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(lblTitle, gridBagConstraints);

        sepaCourse.setMinimumSize(new java.awt.Dimension(150, 10));
        sepaCourse.setPreferredSize(new java.awt.Dimension(150, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelInfo.add(sepaCourse, gridBagConstraints);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 34, 0, 5);
        panelInfo.add(btnSearch, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelInfo, gridBagConstraints);

        pannelContent.setBackground(new java.awt.Color(255, 255, 255));
        pannelContent.setMinimumSize(new java.awt.Dimension(850, 435));
        pannelContent.setPreferredSize(new java.awt.Dimension(850, 435));
        pannelContent.setLayout(new java.awt.GridBagLayout());

        srcPanelAccount.setMinimumSize(new java.awt.Dimension(830, 350));
        srcPanelAccount.setPreferredSize(new java.awt.Dimension(830, 350));

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
        srcPanelAccount.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pannelContent.add(srcPanelAccount, gridBagConstraints);

        btnClose.setText("Close");
        btnClose.setMaximumSize(new java.awt.Dimension(90, 23));
        btnClose.setMinimumSize(new java.awt.Dimension(90, 23));
        btnClose.setPreferredSize(new java.awt.Dimension(90, 23));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pannelContent.add(btnClose, gridBagConstraints);

        lblFilter.setText("Enter Filter:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 520, 5, 5);
        pannelContent.add(lblFilter, gridBagConstraints);

        filterText.setMinimumSize(new java.awt.Dimension(150, 20));
        filterText.setPreferredSize(new java.awt.Dimension(150, 20));
        filterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filterTextKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        pannelContent.add(filterText, gridBagConstraints);

        btnFilter.setText("Filter");
        btnFilter.setMaximumSize(new java.awt.Dimension(90, 23));
        btnFilter.setMinimumSize(new java.awt.Dimension(90, 23));
        btnFilter.setPreferredSize(new java.awt.Dimension(90, 23));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        pannelContent.add(btnFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(pannelContent, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxEmployeeIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEmployeeIdItemStateChanged
        // TODO add your handling code here:
        String empId = (String) cbxEmployeeId.getSelectedItem();
        Employee emp = employeeDAO.readByID(empId);

        if (emp != null) {
            listEmpTemp.clear();
            listEmpTemp.add(emp);

            loadData(listEmpTemp);
        }
    }//GEN-LAST:event_cbxEmployeeIdItemStateChanged

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        Date startDate = dateChooserDateStart.getDate();
        Date endDate = dateChooserDateEnd.getDate();
        int gender = -1;
        if (radioFemale.isSelected()) {
            gender = 0;
        } else if (radioMale.isSelected()) {
            gender = 1;
        }


        listEmp.clear();
        listEmp = employeeDAO.readByCommand(firstName, lastName, startDate, endDate, gender);

        loadData(listEmp);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    public void searchStart() {
        if (!listEmp.isEmpty()) {
            String text = filterText.getText();
            System.out.println("Text :" + text);
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
                new frmSearchEmployee().setVisible(true);


            }
        });


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.JComboBox cbxEmployeeId;
    private com.toedter.calendar.JDateChooser dateChooserDateEnd;
    private com.toedter.calendar.JDateChooser dateChooserDateStart;
    private javax.swing.JTextField filterText;
    private javax.help.JHelp jHelp1;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblStudentId;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JPanel pannelContent;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JSeparator sepaCourse;
    private javax.swing.JScrollPane srcPanelAccount;
    private javax.swing.JTable tableContent;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables
}
