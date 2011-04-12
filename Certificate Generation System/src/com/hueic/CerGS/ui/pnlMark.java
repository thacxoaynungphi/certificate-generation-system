
/*
 * pnlMark.java
 *
 * Created on Mar 31, 2011, 4:45:03 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.MarkDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.SubjectDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Mark;
import com.hueic.CerGS.entity.Register;
import com.hueic.CerGS.entity.Subject;
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
public class pnlMark extends javax.swing.JPanel {

    /** Creates new form pnlMark */
    private ArrayList<Mark> listMark = new ArrayList<Mark>();
    private ArrayList<Register> resList = new ArrayList<Register>();
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private ArrayList<Subject> listSubject = new ArrayList<Subject>();
    ArrayList<Mark> filter = null;
    private RegisterDAO resDAO;
    private MarkDAO markDAO;
    private SubjectDAO subjectDAO;
    private CourseDAO courseDAO;
    boolean isAdd = false;
    private ObjectTableModel tableModel;
    private JTable headerTable;
    frmMain frm;

    public pnlMark() {
        initComponents();
        resDAO = new RegisterDAO();
        markDAO = new MarkDAO();
        subjectDAO = new SubjectDAO();
        courseDAO = new CourseDAO();
        getData();
        btnCancel.setVisible(false);
    }

    public pnlMark(frmMain frm) {
        initComponents();
        this.frm = frm;
        resDAO = new RegisterDAO();
        markDAO = new MarkDAO();
        subjectDAO = new SubjectDAO();
        courseDAO = new CourseDAO();
        getData();
        btnCancel.setVisible(false);
    }

    public void getData() {
        resList = resDAO.readByAll();
        listMark = markDAO.readByAll();
        courseList = courseDAO.readByAll();
        listSubject = subjectDAO.readByAll();
        if (listMark != null) {
            loadData();
            loadDetails(listMark.get(0));
            isAdd = false;
            btnDelete.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnCancel.setVisible(false);
        }
    }

    public void loadData() {
        try {
            filter = new ArrayList<Mark>();
            for (Mark mark : listMark) {
                if (mark.getStudentId().toLowerCase().matches(".*" + txtStudentIdSearch.getText().trim().toLowerCase() + ".*")
                        && String.valueOf(mark.getMark()).toLowerCase().matches(".*" + txtMarkSearch.getText().trim().toLowerCase() + ".*")
                        && mark.getSubjectId().toLowerCase().matches(".*" + txtSubjectIDSearch.getText().trim().toLowerCase() + ".*")) {
                    filter.add(mark);
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
            filter = new ArrayList<Mark>();
            for (Mark mark : listMark) {
                if (mark.getStudentId().toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")
                        || String.valueOf(mark.getMark()).toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")
                        || mark.getSubjectId().toLowerCase().matches(".*" + text.trim().toLowerCase() + ".*")) {
                    filter.add(mark);
                }
            }
            if (!filter.isEmpty()) {
                loadDetails(filter.get(0));
            }
            loadTable(filter);
        } catch (Exception ex) {
        }
    }

    public void loadTable(ArrayList<Mark> filter) {
        ColumnData[] columns = {
            new ColumnData("ID", 140, SwingConstants.LEFT, 1),
            new ColumnData("Student ID", 170, SwingConstants.LEFT, 2),
            new ColumnData("Subject ID", 170, SwingConstants.LEFT, 3),
            new ColumnData("Mark", 150, SwingConstants.LEFT, 4)
        };
        tableModel = new ObjectTableModel(tableContent, columns, filter);
        headerTable = tableModel.getHeaderTable();
        headerTable.createDefaultColumnsFromModel();
        tableContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JViewport viewport = new JViewport();
        viewport.setView(headerTable);
        viewport.setPreferredSize(headerTable.getMaximumSize());
        srcPanelMark.setRowHeader(viewport);
        srcPanelMark.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    public void resetDetails() {
        txtMarkId.setText(null);
        txtStudentId.setText(null);
        txtSubjectID.setText(null);
        txtMark.setText(null);
    }

    public void loadDetails(Mark mark) {
        txtMarkId.setText(String.valueOf(mark.getId()).trim());
        txtMark.setText(String.valueOf((mark.getMark())).trim());
        txtStudentId.setText(mark.getStudentId().trim());
        txtSubjectID.setText(mark.getSubjectId().trim());
    }

    public Mark getMarkById(int id) {
        for (Mark mark : listMark) {
            if (mark.getId() == id) {
                return mark;
            }
        }
        return null;
    }

    public int findIndexOfMark(String studentId, String subjectId) {
        for (int i = 0; i < listMark.size(); i++) {
            if (listMark.get(i).getStudentId().equalsIgnoreCase(studentId) && listMark.get(i).getSubjectId().equalsIgnoreCase(subjectId)) {
                return i;
            }
        }
        return -1;
    }

    public Mark getPaymentFromForm() throws Exception {
        Mark mark = new Mark();
        String id = txtMarkId.getText();
        if (!id.isEmpty()) {
            mark.setId(Integer.parseInt(id));
        }
        String ma = txtMark.getText();
        if (!ma.isEmpty()) {
            mark.setMark(Float.parseFloat(ma));
        }
        mark.setSubjectId(txtSubjectID.getText());
        mark.setStudentId(txtStudentId.getText());
        return mark;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tpMark = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        pnlTop1 = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        seqarator1 = new javax.swing.JSeparator();
        lblMarkID = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        lblSubjectName = new javax.swing.JLabel();
        lblMark = new javax.swing.JLabel();
        txtMarkId = new javax.swing.JTextField();
        txtSubjectID = new javax.swing.JTextField();
        txtMark = new javax.swing.JTextField();
        pnlButtonEdit = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtStudentId = new javax.swing.JTextField();
        btnChooseStudentId = new javax.swing.JButton();
        btnChooseSubjectId = new javax.swing.JButton();
        pnlSearch = new javax.swing.JPanel();
        pnlTop2 = new javax.swing.JPanel();
        lblInfoSearch = new javax.swing.JLabel();
        seqaratorSearch = new javax.swing.JSeparator();
        lblMarkIDSearch = new javax.swing.JLabel();
        lblStudentIDSearch = new javax.swing.JLabel();
        lblSubjectNameSearch = new javax.swing.JLabel();
        lblMarkSearch = new javax.swing.JLabel();
        txtMarkIdSearch = new javax.swing.JTextField();
        txtSubjectIDSearch = new javax.swing.JTextField();
        txtMarkSearch = new javax.swing.JTextField();
        pnlButtonSearch = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        txtStudentIdSearch = new javax.swing.JTextField();
        btnChooseStudentIdSearch = new javax.swing.JButton();
        btnChooseSubjectIdSearch = new javax.swing.JButton();
        pnlDown = new javax.swing.JPanel();
        lblEnterFilter = new javax.swing.JLabel();
        filterText = new javax.swing.JTextField();
        srcPanelMark = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        btnFilter = new javax.swing.JButton();
        pnlButtonReport = new javax.swing.JPanel();
        btnReport = new javax.swing.JButton();

        setEnabled(false);
        setLayout(new java.awt.GridBagLayout());

        tpMark.setMinimumSize(new java.awt.Dimension(860, 200));
        tpMark.setPreferredSize(new java.awt.Dimension(860, 200));

        pnlEdit.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlEdit.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlEdit.setLayout(new java.awt.GridBagLayout());

        pnlTop1.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop1.setMinimumSize(new java.awt.Dimension(860, 200));
        pnlTop1.setPreferredSize(new java.awt.Dimension(860, 200));
        pnlTop1.setLayout(new java.awt.GridBagLayout());

        lblInfo.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblInfo.setForeground(new java.awt.Color(102, 0, 102));
        lblInfo.setText("Information Mark");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlTop1.add(lblInfo, gridBagConstraints);

        seqarator1.setMinimumSize(new java.awt.Dimension(670, 10));
        seqarator1.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlTop1.add(seqarator1, gridBagConstraints);

        lblMarkID.setForeground(new java.awt.Color(3, 3, 3));
        lblMarkID.setText("Mark ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblMarkID, gridBagConstraints);

        lblStudentID.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentID.setText("Student Id:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(lblStudentID, gridBagConstraints);

        lblSubjectName.setForeground(new java.awt.Color(3, 3, 3));
        lblSubjectName.setText("Subject ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop1.add(lblSubjectName, gridBagConstraints);

        lblMark.setForeground(new java.awt.Color(3, 3, 3));
        lblMark.setText("Mark:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop1.add(lblMark, gridBagConstraints);

        txtMarkId.setEnabled(false);
        txtMarkId.setMinimumSize(new java.awt.Dimension(200, 20));
        txtMarkId.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtMarkId, gridBagConstraints);

        txtSubjectID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSubjectID.setEnabled(false);
        txtSubjectID.setMinimumSize(new java.awt.Dimension(200, 20));
        txtSubjectID.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtSubjectID, gridBagConstraints);

        txtMark.setMinimumSize(new java.awt.Dimension(200, 20));
        txtMark.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtMark, gridBagConstraints);

        pnlButtonEdit.setBackground(new java.awt.Color(255, 255, 255));

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
        pnlButtonEdit.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnUpdate.setMaximumSize(new java.awt.Dimension(77, 23));
        btnUpdate.setMinimumSize(new java.awt.Dimension(77, 23));
        btnUpdate.setPreferredSize(new java.awt.Dimension(77, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnlButtonEdit.add(btnUpdate);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMargin(new java.awt.Insets(2, 5, 2, 5));
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
        btnCancel.setMinimumSize(new java.awt.Dimension(75, 23));
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
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 5, 5);
        pnlTop1.add(pnlButtonEdit, gridBagConstraints);

        txtStudentId.setEnabled(false);
        txtStudentId.setMinimumSize(new java.awt.Dimension(200, 20));
        txtStudentId.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(txtStudentId, gridBagConstraints);

        btnChooseStudentId.setText("jButton3");
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(btnChooseStudentId, gridBagConstraints);

        btnChooseSubjectId.setText("jButton4");
        btnChooseSubjectId.setEnabled(false);
        btnChooseSubjectId.setMaximumSize(new java.awt.Dimension(23, 23));
        btnChooseSubjectId.setMinimumSize(new java.awt.Dimension(23, 23));
        btnChooseSubjectId.setPreferredSize(new java.awt.Dimension(23, 20));
        btnChooseSubjectId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseSubjectIdActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop1.add(btnChooseSubjectId, gridBagConstraints);

        pnlEdit.add(pnlTop1, new java.awt.GridBagConstraints());

        tpMark.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlSearch.setLayout(new java.awt.GridBagLayout());

        pnlTop2.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop2.setMinimumSize(new java.awt.Dimension(860, 200));
        pnlTop2.setPreferredSize(new java.awt.Dimension(860, 200));
        pnlTop2.setLayout(new java.awt.GridBagLayout());

        lblInfoSearch.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblInfoSearch.setForeground(new java.awt.Color(102, 0, 102));
        lblInfoSearch.setText("Information Mark");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlTop2.add(lblInfoSearch, gridBagConstraints);

        seqaratorSearch.setMinimumSize(new java.awt.Dimension(750, 10));
        seqaratorSearch.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlTop2.add(seqaratorSearch, gridBagConstraints);

        lblMarkIDSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblMarkIDSearch.setText("Mark ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(lblMarkIDSearch, gridBagConstraints);

        lblStudentIDSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentIDSearch.setText("Student Id:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(lblStudentIDSearch, gridBagConstraints);

        lblSubjectNameSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblSubjectNameSearch.setText("Subject ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop2.add(lblSubjectNameSearch, gridBagConstraints);

        lblMarkSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblMarkSearch.setText("Mark:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        pnlTop2.add(lblMarkSearch, gridBagConstraints);

        txtMarkIdSearch.setEnabled(false);
        txtMarkIdSearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtMarkIdSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtMarkIdSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMarkIdSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(txtMarkIdSearch, gridBagConstraints);

        txtSubjectIDSearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtSubjectIDSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtSubjectIDSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSubjectIDSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(txtSubjectIDSearch, gridBagConstraints);

        txtMarkSearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtMarkSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtMarkSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMarkSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(txtMarkSearch, gridBagConstraints);

        pnlButtonSearch.setBackground(new java.awt.Color(255, 255, 255));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReset.setMinimumSize(new java.awt.Dimension(75, 23));
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
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 5, 5);
        pnlTop2.add(pnlButtonSearch, gridBagConstraints);

        txtStudentIdSearch.setMinimumSize(new java.awt.Dimension(180, 20));
        txtStudentIdSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtStudentIdSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtStudentIdSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTop2.add(txtStudentIdSearch, gridBagConstraints);

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
        pnlTop2.add(btnChooseStudentIdSearch, gridBagConstraints);

        btnChooseSubjectIdSearch.setText("jButton2");
        btnChooseSubjectIdSearch.setMaximumSize(new java.awt.Dimension(23, 23));
        btnChooseSubjectIdSearch.setMinimumSize(new java.awt.Dimension(23, 23));
        btnChooseSubjectIdSearch.setPreferredSize(new java.awt.Dimension(23, 20));
        btnChooseSubjectIdSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseSubjectIdSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlTop2.add(btnChooseSubjectIdSearch, gridBagConstraints);

        pnlSearch.add(pnlTop2, new java.awt.GridBagConstraints());

        tpMark.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpMark, gridBagConstraints);

        pnlDown.setBackground(new java.awt.Color(255, 255, 255));
        pnlDown.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mark", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        pnlDown.setForeground(new java.awt.Color(3, 3, 3));
        pnlDown.setMinimumSize(new java.awt.Dimension(860, 400));
        pnlDown.setPreferredSize(new java.awt.Dimension(860, 400));
        pnlDown.setLayout(new java.awt.GridBagLayout());

        lblEnterFilter.setBackground(new java.awt.Color(255, 255, 255));
        lblEnterFilter.setForeground(new java.awt.Color(3, 3, 3));
        lblEnterFilter.setText("Enter Filter:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 510, 5, 5);
        pnlDown.add(lblEnterFilter, gridBagConstraints);

        filterText.setMinimumSize(new java.awt.Dimension(180, 20));
        filterText.setPreferredSize(new java.awt.Dimension(180, 20));
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

        srcPanelMark.setAutoscrolls(true);
        srcPanelMark.setMinimumSize(new java.awt.Dimension(840, 320));
        srcPanelMark.setPreferredSize(new java.awt.Dimension(840, 320));

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
        srcPanelMark.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        pnlDown.add(srcPanelMark, gridBagConstraints);

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

        pnlButtonReport.setBackground(new java.awt.Color(255, 255, 255));

        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/reports-icon.png"))); // NOI18N
        btnReport.setText("Report");
        btnReport.setMargin(new java.awt.Insets(2, 5, 2, 5));
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

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed

        loadFiter(filterText.getText());
}//GEN-LAST:event_btnFilterActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        try {
            if (!isAdd) {
                isAdd = true;

                txtStudentId.setEnabled(true);
                txtSubjectID.setEnabled(true);
                btnChooseStudentId.setEnabled(true);
                btnChooseSubjectId.setEnabled(true);

                btnCancel.setVisible(true);
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
                resetDetails();
            } else {
                if (txtStudentId.getText().length() != 0 && txtSubjectID.getText().length() != 0
                        && txtMark.getText().length() != 0) {
                    Mark mark = null;
                    try {
                        mark = getPaymentFromForm();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Mark Add", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (findIndexOfMark(mark.getStudentId(), mark.getSubjectId()) != -1) {
                        JOptionPane.showMessageDialog(this, "Student " + mark.getStudentId() + " has Mark of " + mark.getSubjectId(), "Mark Add", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (markDAO.create(mark)) {
                        JOptionPane.showMessageDialog(this, markDAO.getLastError(), "Mark Add", JOptionPane.INFORMATION_MESSAGE);
                        listMark = markDAO.readByAll();
                        loadData();
                        loadDetails(listMark.get(0));

                        isAdd = false;
                        btnUpdate.setEnabled(true);
                        btnDelete.setEnabled(true);
                        btnCancel.setVisible(false);
                        txtStudentId.setEnabled(false);
                        txtSubjectID.setEnabled(false);
                        btnChooseStudentId.setEnabled(false);
                        btnChooseSubjectId.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(this, markDAO.getLastError(), "Mark Add", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Enter full information, please", "Mark Add", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, markDAO.getLastError(), "Mark Add", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        try {
            if (txtStudentId.getText().length() != 0
                    && txtSubjectID.getText().length() != 0
                    && txtMark.getText().length() != 0
                    && txtMarkId.getText().length() != 0) {
                Mark mark = null;
                try {
                    mark = getPaymentFromForm();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Mark Update", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (markDAO.update(mark)) {
                    JOptionPane.showMessageDialog(this, markDAO.getLastError(), "Mark Update", JOptionPane.INFORMATION_MESSAGE);
                    listMark = markDAO.readByAll();
                    loadData();
                    loadDetails(listMark.get(0));
                } else {
                    JOptionPane.showMessageDialog(this, markDAO.getLastError(), "Mark Update", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Enter full information, please", "Mark Update", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error! Check again, Please", "Error!", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            if (txtMarkId.getText().length() != 0) {
                int id = Integer.parseInt(txtMarkId.getText());
                if (markDAO.delete(id)) {
                    listMark.remove(getMarkById(id));
                    loadData();
                    JOptionPane.showMessageDialog(this, markDAO.getLastError(), "Mark Delete", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, markDAO.getLastError(), "Mark Delete", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Enter full information, please", "Mark Delete", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error! Check again, Please", "Error!", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        try {
            if (isAdd) {
                isAdd = false;
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
                btnCancel.setVisible(false);
                txtStudentId.setEnabled(false);
                txtSubjectID.setEnabled(false);
                btnChooseStudentId.setEnabled(false);
                btnChooseSubjectId.setEnabled(false);
            }
            loadDetails(listMark.get(0));
        } catch (Exception ex) {
        }
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        txtMarkIdSearch.setText(null);
        txtStudentIdSearch.setText(null);
        txtStudentIdSearch.setText(null);
        txtMarkSearch.setText(null);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnChooseSubjectIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseSubjectIdActionPerformed
        try {
            dlgChoose dlg = new dlgChoose(frm, txtSubjectID, true, 14);
            dlg.setTitle("Browse Subject");
            dlg.setSize(868, 580);
            dlg.setLocationRelativeTo(null);
            dlg.setVisible(true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btnChooseSubjectIdActionPerformed

    private void btnChooseStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseStudentIdActionPerformed
        try {
            dlgChoose dlg = new dlgChoose(frm, txtStudentId, true, 12);
            dlg.setTitle("Browse Student");
            dlg.setSize(868, 580);
            dlg.setLocationRelativeTo(null);
            dlg.setVisible(true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btnChooseStudentIdActionPerformed

    private void btnChooseStudentIdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseStudentIdSearchActionPerformed
        try {
            dlgChoose dlg = new dlgChoose(frm, txtStudentIdSearch, true, 12);
            dlg.setTitle("Browse Student");
            dlg.setSize(868, 580);
            dlg.setLocationRelativeTo(null);
            dlg.setVisible(true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btnChooseStudentIdSearchActionPerformed

    private void btnChooseSubjectIdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseSubjectIdSearchActionPerformed
        try {
            dlgChoose dlg = new dlgChoose(frm, txtSubjectIDSearch, true, 14);
            dlg.setTitle("Browse Subject");
            dlg.setSize(868, 580);
            dlg.setLocationRelativeTo(null);
            dlg.setVisible(true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btnChooseSubjectIdSearchActionPerformed
    private void tableContentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseReleased
        try {
            int index = tableContent.getSelectedRow();
            if (index != -1) {
                int id = Integer.parseInt(String.valueOf(tableContent.getValueAt(index, 0)));
                Mark mark = getMarkById(id);
                loadDetails(mark);
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
    private void txtMarkIdSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMarkIdSearchCaretUpdate

        loadData();
    }//GEN-LAST:event_txtMarkIdSearchCaretUpdate
    private void txtStudentIdSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtStudentIdSearchCaretUpdate

        loadData();
    }//GEN-LAST:event_txtStudentIdSearchCaretUpdate
    private void txtSubjectIDSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSubjectIDSearchCaretUpdate

        loadData();
    }//GEN-LAST:event_txtSubjectIDSearchCaretUpdate
    private void txtMarkSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMarkSearchCaretUpdate

        loadData();
    }//GEN-LAST:event_txtMarkSearchCaretUpdate

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        try {
            if (!filter.isEmpty()) {
                frm.pnlReport.removeAll();
                dlgChooseReport report = new dlgChooseReport(frm, this);
                report.getMarkAllReport(filter);
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
    private javax.swing.JButton btnChooseSubjectId;
    private javax.swing.JButton btnChooseSubjectIdSearch;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel lblEnterFilter;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblInfoSearch;
    private javax.swing.JLabel lblMark;
    private javax.swing.JLabel lblMarkID;
    private javax.swing.JLabel lblMarkIDSearch;
    private javax.swing.JLabel lblMarkSearch;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentIDSearch;
    private javax.swing.JLabel lblSubjectName;
    private javax.swing.JLabel lblSubjectNameSearch;
    private javax.swing.JPanel pnlButtonEdit;
    private javax.swing.JPanel pnlButtonReport;
    private javax.swing.JPanel pnlButtonSearch;
    private javax.swing.JPanel pnlDown;
    public javax.swing.JPanel pnlEdit;
    public javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlTop1;
    private javax.swing.JPanel pnlTop2;
    private javax.swing.JSeparator seqarator1;
    private javax.swing.JSeparator seqaratorSearch;
    private javax.swing.JScrollPane srcPanelMark;
    private javax.swing.JTable tableContent;
    public javax.swing.JTabbedPane tpMark;
    private javax.swing.JTextField txtMark;
    private javax.swing.JTextField txtMarkId;
    private javax.swing.JTextField txtMarkIdSearch;
    private javax.swing.JTextField txtMarkSearch;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtStudentIdSearch;
    private javax.swing.JTextField txtSubjectID;
    private javax.swing.JTextField txtSubjectIDSearch;
    // End of variables declaration//GEN-END:variables

    String getSelectedName() {
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
