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
    ArrayList<Payment> filter = null;
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
        filter = new ArrayList<Payment>();
        for (Payment pay : listPayments) {
            if (pay.getStudentId().toLowerCase().matches(".*" + txtStudentIdSearch.getText().trim().toLowerCase() + ".*")
                    && registerDAO.readByStudentId(pay.getStudentId()).getCourseId().toLowerCase().matches(".*" + txtCourseIdSearch.getText().trim().toLowerCase() + ".*")
                    && String.valueOf(pay.getMoney()).toLowerCase().matches(".*" + txtMoneySearch.getText().trim().toLowerCase() + ".*") //&& sub.getCourseID().toLowerCase().matches(".*" + txtCoureIDSearch.getText().trim().toLowerCase() + ".*")
                    //TODO: chua xet duoc ngay nop tien
                    ) {
                filter.add(pay);
            }
        }
        if (filter.size() != 0) {
            loadDetails(filter.get(0));
        }
        ColumnData[] columns = {
            new ColumnData("ID", 100, SwingConstants.LEFT, 1),
            new ColumnData("Student ID", 140, SwingConstants.LEFT, 2),
            new ColumnData("Money", 170, SwingConstants.LEFT, 3),
            new ColumnData("Pay Day", 260, SwingConstants.LEFT, 4)
        };
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
        btnChooseCourseId = new javax.swing.JButton();
        btnChooseStudentId = new javax.swing.JButton();
        pnlSearch = new javax.swing.JPanel();
        panelRight1 = new javax.swing.JPanel();
        lblCourseSearch = new javax.swing.JLabel();
        lblStudentIDSearch = new javax.swing.JLabel();
        lblMoneySearch = new javax.swing.JLabel();
        lblPayDaySearch = new javax.swing.JLabel();
        txtMoneySearch = new javax.swing.JTextField();
        panelButtonSearch = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        lblTitleSearch = new javax.swing.JLabel();
        jSeparatorSearch = new javax.swing.JSeparator();
        dateChPayDaySearch = new com.toedter.calendar.JDateChooser();
        txtCourseIdSearch = new javax.swing.JTextField();
        txtStudentIdSearch = new javax.swing.JTextField();
        btnChooseCourseSearch = new javax.swing.JButton();
        btnChooseStudentIdSearch = new javax.swing.JButton();
        panelLeft = new javax.swing.JPanel();
        srcPanelPayment = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        filterText = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnReport = new javax.swing.JButton();
        lblEnterNameStudent = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        tpPayment.setMinimumSize(new java.awt.Dimension(860, 200));
        tpPayment.setPreferredSize(new java.awt.Dimension(860, 200));

        pnlEdit.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlEdit.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlEdit.setLayout(new java.awt.GridBagLayout());

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setMinimumSize(new java.awt.Dimension(860, 200));
        panelRight.setPreferredSize(new java.awt.Dimension(860, 200));
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
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelRight.add(lblMoney, gridBagConstraints);

        lblPayDay.setForeground(new java.awt.Color(3, 3, 3));
        lblPayDay.setText("Pay day:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
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
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 5, 5);
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

        jSeparator1.setMinimumSize(new java.awt.Dimension(750, 10));
        jSeparator1.setPreferredSize(new java.awt.Dimension(750, 10));
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

        btnChooseCourseId.setText("jButton1");
        btnChooseCourseId.setMaximumSize(new java.awt.Dimension(23, 23));
        btnChooseCourseId.setMinimumSize(new java.awt.Dimension(23, 23));
        btnChooseCourseId.setPreferredSize(new java.awt.Dimension(23, 20));
        btnChooseCourseId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseCourseIdActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(btnChooseCourseId, gridBagConstraints);

        btnChooseStudentId.setText("jButton2");
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
        panelRight.add(btnChooseStudentId, gridBagConstraints);

        pnlEdit.add(panelRight, new java.awt.GridBagConstraints());

        tpPayment.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlSearch.setLayout(new java.awt.GridBagLayout());

        panelRight1.setBackground(new java.awt.Color(255, 255, 255));
        panelRight1.setMinimumSize(new java.awt.Dimension(860, 200));
        panelRight1.setPreferredSize(new java.awt.Dimension(860, 200));
        panelRight1.setLayout(new java.awt.GridBagLayout());

        lblCourseSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblCourseSearch.setText("Course:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(lblCourseSearch, gridBagConstraints);

        lblStudentIDSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentIDSearch.setText("Student ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(lblStudentIDSearch, gridBagConstraints);

        lblMoneySearch.setForeground(new java.awt.Color(3, 3, 3));
        lblMoneySearch.setText("Money:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelRight1.add(lblMoneySearch, gridBagConstraints);

        lblPayDaySearch.setForeground(new java.awt.Color(3, 3, 3));
        lblPayDaySearch.setText("Pay day:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelRight1.add(lblPayDaySearch, gridBagConstraints);

        txtMoneySearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtMoneySearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtMoneySearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMoneySearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(txtMoneySearch, gridBagConstraints);

        panelButtonSearch.setBackground(new java.awt.Color(255, 255, 255));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReset.setPreferredSize(new java.awt.Dimension(75, 23));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        panelButtonSearch.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 5, 5);
        panelRight1.add(panelButtonSearch, gridBagConstraints);

        lblTitleSearch.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitleSearch.setForeground(new java.awt.Color(102, 0, 102));
        lblTitleSearch.setText("Information Payment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight1.add(lblTitleSearch, gridBagConstraints);

        jSeparatorSearch.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelRight1.add(jSeparatorSearch, gridBagConstraints);

        dateChPayDaySearch.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(dateChPayDaySearch, gridBagConstraints);

        txtCourseIdSearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtCourseIdSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtCourseIdSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCourseIdSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(txtCourseIdSearch, gridBagConstraints);

        txtStudentIdSearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtStudentIdSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtStudentIdSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtStudentIdSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(txtStudentIdSearch, gridBagConstraints);

        btnChooseCourseSearch.setText("jButton1");
        btnChooseCourseSearch.setMaximumSize(new java.awt.Dimension(23, 23));
        btnChooseCourseSearch.setMinimumSize(new java.awt.Dimension(23, 23));
        btnChooseCourseSearch.setPreferredSize(new java.awt.Dimension(23, 20));
        btnChooseCourseSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseCourseSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight1.add(btnChooseCourseSearch, gridBagConstraints);

        btnChooseStudentIdSearch.setText("jButton2");
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
        panelRight1.add(btnChooseStudentIdSearch, gridBagConstraints);

        pnlSearch.add(panelRight1, new java.awt.GridBagConstraints());

        tpPayment.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpPayment, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelLeft.setMinimumSize(new java.awt.Dimension(860, 400));
        panelLeft.setPreferredSize(new java.awt.Dimension(860, 400));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        srcPanelPayment.setMinimumSize(new java.awt.Dimension(840, 300));
        srcPanelPayment.setPreferredSize(new java.awt.Dimension(840, 300));

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
        tableContent.setMinimumSize(new java.awt.Dimension(770, 340));
        tableContent.setPreferredSize(new java.awt.Dimension(770, 340));
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableContentMouseReleased(evt);
            }
        });
        srcPanelPayment.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(srcPanelPayment, gridBagConstraints);

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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
        jPanel2.add(btnReport);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        panelLeft.add(jPanel2, gridBagConstraints);

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
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelLeft, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        searchStart();
}//GEN-LAST:event_btnFilterActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtCourseIdSearch.setText(null);
        txtStudentIdSearch.setText(null);
        txtMoneySearch.setText(null);
        dateChPayDaySearch.setDate(null);
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

    private void btnChooseStudentIdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseStudentIdSearchActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtStudentIdSearch, true, 12);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnChooseStudentIdSearchActionPerformed

    private void btnChooseCourseSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseCourseSearchActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtCourseIdSearch, true, 7);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnChooseCourseSearchActionPerformed

    private void btnChooseCourseIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseCourseIdActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtCourseId, true, 7);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnChooseCourseIdActionPerformed

    private void btnChooseStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseStudentIdActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtStudentId, true, 12);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnChooseStudentIdActionPerformed

    private void filterTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_filterTextCaretUpdate
        // TODO add your handling code here:
        searchStart();
    }//GEN-LAST:event_filterTextCaretUpdate

    private void tableContentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseReleased
        // TODO add your handling code here:
        int index = tableContent.getSelectedRow();
        if (index != -1) {
            int currentId = Integer.parseInt(String.valueOf(tableContent.getValueAt(index, 0)));
            Payment payment = getPaymentById(currentId);
            loadDetails(payment);
        }
    }//GEN-LAST:event_tableContentMouseReleased

    private void txtCourseIdSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCourseIdSearchCaretUpdate
        // TODO add your handling code here:
        loadData(listPayments);
    }//GEN-LAST:event_txtCourseIdSearchCaretUpdate

    private void txtStudentIdSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtStudentIdSearchCaretUpdate
        // TODO add your handling code here:
        loadData(listPayments);
    }//GEN-LAST:event_txtStudentIdSearchCaretUpdate

    private void txtMoneySearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMoneySearchCaretUpdate
        // TODO add your handling code here:
        loadData(listPayments);
    }//GEN-LAST:event_txtMoneySearchCaretUpdate

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
        frm.pnlReport.removeAll();
        dlgChooseReport report = new dlgChooseReport(frm, this);
        report.getFeesReport(filter);
        report.setVisible(true);
        report.setSize(860, 600);
        frm.pnlReport.add(report);
        frm.tpnBusiness.setSelectedComponent(frm.pnlReport);
    }//GEN-LAST:event_btnReportActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChooseCourseId;
    private javax.swing.JButton btnChooseCourseSearch;
    private javax.swing.JButton btnChooseStudentId;
    private javax.swing.JButton btnChooseStudentIdSearch;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser dateChPayDay;
    private com.toedter.calendar.JDateChooser dateChPayDaySearch;
    private javax.swing.JTextField filterText;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparatorSearch;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblCourseSearch;
    private javax.swing.JLabel lblEnterNameStudent;
    private javax.swing.JLabel lblMoney;
    private javax.swing.JLabel lblMoneySearch;
    private javax.swing.JLabel lblPayDay;
    private javax.swing.JLabel lblPayDaySearch;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentIDSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleSearch;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelButtonSearch;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelRight1;
    public javax.swing.JPanel pnlEdit;
    public javax.swing.JPanel pnlSearch;
    private javax.swing.JScrollPane srcPanelPayment;
    private javax.swing.JTable tableContent;
    public javax.swing.JTabbedPane tpPayment;
    private javax.swing.JTextField txtCourseId;
    private javax.swing.JTextField txtCourseIdSearch;
    private javax.swing.JTextField txtMoney;
    private javax.swing.JTextField txtMoneySearch;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtStudentIdSearch;
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
