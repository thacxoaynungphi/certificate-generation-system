/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pnlPayment.java
 *
 * Created on Mar 31, 2011, 4:53:05 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.PaymentDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Payment;
import com.hueic.CerGS.entity.Register;
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
public class pnlPayment extends javax.swing.JPanel {

    private int currentId;
    private ArrayList<Payment> listPayments = new ArrayList<Payment>();
    ArrayList<Course> listCourse = new ArrayList<Course>();
    ArrayList<Register> listRegister = new ArrayList<Register>();
    private PaymentDAO paymentDao;
    TableRowSorter<TableModel> sorter;
    RegisterDAO registerDAO;
    StudentDAO studentDAO;
    CourseDAO courseDao;
    private boolean isUpdate = false;
    private boolean isAdd = false;
    private ObjectTableModel tableModel;
    private JTable headerTable;
    frmMain frm;

    /** Creates new form pnlPayment */
    public pnlPayment() {
        initComponents();
        registerDAO = new RegisterDAO();
        studentDAO = new StudentDAO();
        courseDao = new CourseDAO();

        paymentDao = new PaymentDAO();
        listPayments = paymentDao.readByAll();
        listCourse = courseDao.readByAll();
        //TODO: chua kiem tra xem sinh vien do da nop tien chua
        listRegister = registerDAO.readByAll();
        if (listPayments.size() != 0) {
            loadData(listPayments);
            loadDetails(listPayments.get(0));
        }
    }

    public pnlPayment(frmMain frm) {
        initComponents();
        this.frm = frm;
        registerDAO = new RegisterDAO();
        studentDAO = new StudentDAO();
        courseDao = new CourseDAO();

        paymentDao = new PaymentDAO();
        listPayments = paymentDao.readByAll();
        listCourse = courseDao.readByAll();
        //TODO: chua kiem tra xem sinh vien do da nop tien chua
        listRegister = registerDAO.readByAll();
        if (listPayments.size() != 0) {
            loadData(listPayments);
            loadDetails(listPayments.get(0));
        }
    }

    public void loadData(ArrayList<Payment> listPayments) {

        ColumnData[] columns = {
            new ColumnData("ID", 100, SwingConstants.LEFT, 1),
            new ColumnData("Student ID", 140, SwingConstants.LEFT, 2),
            new ColumnData("Money", 170, SwingConstants.LEFT, 3),
            new ColumnData("Pay Day", 260, SwingConstants.LEFT, 4)
        };
        tableModel = new ObjectTableModel(tableContent, columns, listPayments);
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
        srcPanelPayment.setRowHeader(viewport);
        srcPanelPayment.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    public void loadDetails(Payment payment) {
        currentId = payment.getId();
        txtMoney.setText(String.valueOf(payment.getMoney()).trim());
        dateChPayDay.setDate(payment.getPayday());
        txtCourseId.setText(registerDAO.readByStudentId(payment.getStudentId()).getCourseId());
        txtStudentId.setText(payment.getStudentId());
    }

    public Payment getPaymentById(int id) {
        for (int i = 0; i < listPayments.size(); i++) {
            if (listPayments.get(i).getId() == id) {
                return listPayments.get(i);
            }
        }
        return null;
    }

    public int getIndexOfPaymentInList(int id) {
        for (int i = 0; i < listPayments.size(); i++) {
            if (listPayments.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void searchStart() {
        if (!listPayments.isEmpty()) {
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tpPayment = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        panelRight = new javax.swing.JPanel();
        lblCourse = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        lblMoney = new javax.swing.JLabel();
        lblPayDay = new javax.swing.JLabel();
        txtMoney = new javax.swing.JTextField();
        panelButton = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        dateChPayDay = new com.toedter.calendar.JDateChooser();
        txtCourseId = new javax.swing.JTextField();
        txtStudentId = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnlSearch = new javax.swing.JPanel();
        panelRight1 = new javax.swing.JPanel();
        lblCourse1 = new javax.swing.JLabel();
        lblStudentID1 = new javax.swing.JLabel();
        lblMoney1 = new javax.swing.JLabel();
        lblPayDay1 = new javax.swing.JLabel();
        txtMoney1 = new javax.swing.JTextField();
        panelButton1 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        lblTitle1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        dateChPayDay1 = new com.toedter.calendar.JDateChooser();
        txtCourseId1 = new javax.swing.JTextField();
        txtStudentId1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelLeft = new javax.swing.JPanel();
        srcPanelPayment = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        tpPayment.setMinimumSize(new java.awt.Dimension(800, 200));

        pnlEdit.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlEdit.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlEdit.setLayout(new java.awt.GridBagLayout());

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setMinimumSize(new java.awt.Dimension(800, 200));
        panelRight.setPreferredSize(new java.awt.Dimension(800, 200));
        panelRight.setLayout(new java.awt.GridBagLayout());

        lblCourse.setForeground(new java.awt.Color(3, 3, 3));
        lblCourse.setText("Course:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblCourse, gridBagConstraints);

        lblStudentID.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentID.setText("Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblStudentID, gridBagConstraints);

        lblMoney.setForeground(new java.awt.Color(3, 3, 3));
        lblMoney.setText("Money:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelRight.add(lblMoney, gridBagConstraints);

        lblPayDay.setForeground(new java.awt.Color(3, 3, 3));
        lblPayDay.setText("Pay day:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelRight.add(lblPayDay, gridBagConstraints);

        txtMoney.setMinimumSize(new java.awt.Dimension(200, 20));
        txtMoney.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtMoney, gridBagConstraints);

        panelButton.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnAdd.setPreferredSize(new java.awt.Dimension(75, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        panelButton.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnUpdate.setPreferredSize(new java.awt.Dimension(75, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panelButton.add(btnUpdate);

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
        panelButton.add(btnDelete);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Cancel-2-16x16.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        panelButton.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(panelButton, gridBagConstraints);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Payment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(lblTitle, gridBagConstraints);

        jSeparator1.setMinimumSize(new java.awt.Dimension(650, 10));
        jSeparator1.setPreferredSize(new java.awt.Dimension(650, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelRight.add(jSeparator1, gridBagConstraints);

        dateChPayDay.setMinimumSize(new java.awt.Dimension(200, 20));
        dateChPayDay.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(dateChPayDay, gridBagConstraints);

        txtCourseId.setMinimumSize(new java.awt.Dimension(200, 20));
        txtCourseId.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtCourseId, gridBagConstraints);

        txtStudentId.setMinimumSize(new java.awt.Dimension(200, 20));
        txtStudentId.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtStudentId, gridBagConstraints);

        jButton3.setText("jButton1");
        jButton3.setMaximumSize(new java.awt.Dimension(23, 23));
        jButton3.setMinimumSize(new java.awt.Dimension(23, 23));
        jButton3.setPreferredSize(new java.awt.Dimension(23, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        panelRight.add(jButton3, gridBagConstraints);

        jButton4.setText("jButton2");
        jButton4.setMaximumSize(new java.awt.Dimension(23, 23));
        jButton4.setMinimumSize(new java.awt.Dimension(23, 23));
        jButton4.setPreferredSize(new java.awt.Dimension(23, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        panelRight.add(jButton4, gridBagConstraints);

        pnlEdit.add(panelRight, new java.awt.GridBagConstraints());

        tpPayment.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlSearch.setLayout(new java.awt.GridBagLayout());

        panelRight1.setBackground(new java.awt.Color(255, 255, 255));
        panelRight1.setMinimumSize(new java.awt.Dimension(800, 200));
        panelRight1.setPreferredSize(new java.awt.Dimension(800, 200));
        panelRight1.setLayout(new java.awt.GridBagLayout());

        lblCourse1.setForeground(new java.awt.Color(3, 3, 3));
        lblCourse1.setText("Course:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(lblCourse1, gridBagConstraints);

        lblStudentID1.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentID1.setText("Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(lblStudentID1, gridBagConstraints);

        lblMoney1.setForeground(new java.awt.Color(3, 3, 3));
        lblMoney1.setText("Money:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(lblMoney1, gridBagConstraints);

        lblPayDay1.setForeground(new java.awt.Color(3, 3, 3));
        lblPayDay1.setText("Pay day:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(lblPayDay1, gridBagConstraints);

        txtMoney1.setMinimumSize(new java.awt.Dimension(200, 20));
        txtMoney1.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(txtMoney1, gridBagConstraints);

        panelButton1.setBackground(new java.awt.Color(255, 255, 255));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReset.setPreferredSize(new java.awt.Dimension(75, 23));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        panelButton1.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        panelRight1.add(panelButton1, gridBagConstraints);

        lblTitle1.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle1.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle1.setText("Information Payment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelRight1.add(lblTitle1, gridBagConstraints);

        jSeparator2.setPreferredSize(new java.awt.Dimension(320, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panelRight1.add(jSeparator2, gridBagConstraints);

        dateChPayDay1.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(dateChPayDay1, gridBagConstraints);

        txtCourseId1.setMinimumSize(new java.awt.Dimension(200, 20));
        txtCourseId1.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(txtCourseId1, gridBagConstraints);

        txtStudentId1.setMinimumSize(new java.awt.Dimension(200, 20));
        txtStudentId1.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(txtStudentId1, gridBagConstraints);

        jButton1.setText("jButton1");
        jButton1.setMaximumSize(new java.awt.Dimension(23, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(23, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(23, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        panelRight1.add(jButton1, gridBagConstraints);

        jButton2.setText("jButton2");
        jButton2.setMaximumSize(new java.awt.Dimension(23, 23));
        jButton2.setMinimumSize(new java.awt.Dimension(23, 23));
        jButton2.setPreferredSize(new java.awt.Dimension(23, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        panelRight1.add(jButton2, gridBagConstraints);

        pnlSearch.add(panelRight1, new java.awt.GridBagConstraints());

        tpPayment.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpPayment, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelLeft.setMinimumSize(new java.awt.Dimension(800, 400));
        panelLeft.setPreferredSize(new java.awt.Dimension(800, 400));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        srcPanelPayment.setPreferredSize(new java.awt.Dimension(750, 300));

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
        tableContent.setPreferredSize(new java.awt.Dimension(300, 100));
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContentMouseClicked(evt);
            }
        });
        srcPanelPayment.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(srcPanelPayment, gridBagConstraints);

        filterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filterTextKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 193;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 450, 5, 5);
        panelLeft.add(filterText, gridBagConstraints);

        btnFilter.setText("Filter");
        btnFilter.setMaximumSize(new java.awt.Dimension(73, 23));
        btnFilter.setMinimumSize(new java.awt.Dimension(73, 23));
        btnFilter.setPreferredSize(new java.awt.Dimension(73, 23));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(btnFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelLeft, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        // TODO add your handling code here:
        int index = tableContent.getSelectedRow();
        if (index != -1) {
            int currentId = Integer.parseInt(String.valueOf(tableContent.getValueAt(index, 0)));
            Payment payment = getPaymentById(currentId);
            loadDetails(payment);
        }
}//GEN-LAST:event_tableContentMouseClicked

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

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnResetActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        if (isAdd) {
            isAdd = false;
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            txtCourseId.setVisible(true);
            txtStudentId.setVisible(true);
        } else if (isUpdate) {
            isUpdate = false;
            txtCourseId.setVisible(true);
            txtStudentId.setVisible(true);
            loadDetails(getPaymentById(currentId));
        } else {
            loadDetails(listPayments.get(0));
        }
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (paymentDao.delete(currentId)) {
            listPayments.remove(getPaymentById(currentId));
            loadData(listPayments);
            if (listPayments.size() != 0) {
                loadDetails(listPayments.get(0));
            }
            JOptionPane.showMessageDialog(this, paymentDao.getLastError(), "Delete payment", JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            JOptionPane.showMessageDialog(this, paymentDao.getLastError(), "Delete payment", JOptionPane.ERROR_MESSAGE, null);
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (!isUpdate) {
                txtCourseId.setVisible(true);
                txtStudentId.setVisible(true);
                isUpdate = true;
            } else {
                isUpdate = false;
                Payment pay = getPaymentById(currentId);
                pay.setMoney(Float.parseFloat(txtMoney.getText()));
                pay.setPayday(new java.sql.Date(dateChPayDay.getDate().getTime()));
                if (paymentDao.update(pay)) {
                    JOptionPane.showMessageDialog(this, paymentDao.getLastError(), "Update Payment", JOptionPane.INFORMATION_MESSAGE);
                    loadData(listPayments);
                    loadDetails(pay);
                } else {
                    JOptionPane.showMessageDialog(this, paymentDao.getLastError(), "Update Payment", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, paymentDao.getLastError(), "Update Payment", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            if (!isAdd) {
                isAdd = true;
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
                txtCourseId.setVisible(true);
                txtStudentId.setVisible(true);
            } else {
                //TODO: chua lay duoc chi so tu tang cua ban ghi moi dua vo
                Payment payment = new Payment();
                payment.setMoney(Float.parseFloat(txtMoney.getText()));
                payment.setPayday(new java.sql.Date(dateChPayDay.getDate().getTime()));
                payment.setStudentId((String) txtStudentId.getText());
                if (paymentDao.create(payment)) {
                    JOptionPane.showMessageDialog(this, paymentDao.getLastError(), "Create Payment", JOptionPane.INFORMATION_MESSAGE);
                    listPayments.add(payment);
                    loadData(listPayments);
                    loadDetails(payment);
                    isAdd = false;
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                    txtCourseId.setVisible(true);
                    txtStudentId.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, paymentDao.getLastError(), "Create Payment", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Create Payment", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnAddActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtStudentId1, true, 12);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtCourseId1, true, 7);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtCourseId, true, 7);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtStudentId, true, 12);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser dateChPayDay;
    private com.toedter.calendar.JDateChooser dateChPayDay1;
    private javax.swing.JTextField filterText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblCourse1;
    private javax.swing.JLabel lblMoney;
    private javax.swing.JLabel lblMoney1;
    private javax.swing.JLabel lblPayDay;
    private javax.swing.JLabel lblPayDay1;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentID1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelButton1;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelRight1;
    public javax.swing.JPanel pnlEdit;
    public javax.swing.JPanel pnlSearch;
    private javax.swing.JScrollPane srcPanelPayment;
    private javax.swing.JTable tableContent;
    public javax.swing.JTabbedPane tpPayment;
    private javax.swing.JTextField txtCourseId;
    private javax.swing.JTextField txtCourseId1;
    private javax.swing.JTextField txtMoney;
    private javax.swing.JTextField txtMoney1;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtStudentId1;
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
