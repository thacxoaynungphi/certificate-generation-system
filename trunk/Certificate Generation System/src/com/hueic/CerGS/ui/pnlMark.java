/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
import java.util.regex.PatternSyntaxException;
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
public class pnlMark extends javax.swing.JPanel {

    /** Creates new form pnlMark */
    private ArrayList<Mark> listMark = new ArrayList<Mark>();
    private ArrayList<Register> resList = new ArrayList<Register>();
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private ArrayList<Subject> listSubject = new ArrayList<Subject>();
    private String courseId;
    private TableRowSorter<TableModel> sorter;
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
        resList = resDAO.readByAll();
        listMark = markDAO.readByAll();
        courseList = courseDAO.readByAll();
        listSubject = subjectDAO.readByAll();
        if (listMark != null) {
            loadData(listMark);
            loadDetails(listMark.get(0));
        }
    }

    public pnlMark(frmMain frm) {
        initComponents();
        this.frm = frm;
        resDAO = new RegisterDAO();
        markDAO = new MarkDAO();
        subjectDAO = new SubjectDAO();
        courseDAO = new CourseDAO();
        resList = resDAO.readByAll();
        listMark = markDAO.readByAll();
        courseList = courseDAO.readByAll();
        listSubject = subjectDAO.readByAll();
        if (listMark != null) {
            loadData(listMark);
            loadDetails(listMark.get(0));
        }
    }

    public void loadData(ArrayList<Mark> listMark) {

        ColumnData[] columns = {
            new ColumnData("ID", 100, SwingConstants.LEFT, 1),
            new ColumnData("Student ID", 140, SwingConstants.LEFT, 2),
            new ColumnData("Subject ID", 170, SwingConstants.LEFT, 3),
            new ColumnData("Mark", 260, SwingConstants.LEFT, 4)
        };
        tableModel = new ObjectTableModel(tableContent, columns, listMark);
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
        srcPanelMark.setRowHeader(viewport);
        srcPanelMark.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
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

    public void searchStart() {
        if (!listMark.isEmpty()) {
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tpMark = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        panelRight = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        seqarator1 = new javax.swing.JSeparator();
        lblMarkID = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        lblSubjectName = new javax.swing.JLabel();
        lblMark = new javax.swing.JLabel();
        txtMarkId = new javax.swing.JTextField();
        txtSubjectID = new javax.swing.JTextField();
        txtMark = new javax.swing.JTextField();
        panelButton = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtStudentId = new javax.swing.JTextField();
        btnChooseStudentId = new javax.swing.JButton();
        btnChooseSubjectId = new javax.swing.JButton();
        pnlSearch = new javax.swing.JPanel();
        panelRightSearch = new javax.swing.JPanel();
        lblInfoSearch = new javax.swing.JLabel();
        seqaratorSearch = new javax.swing.JSeparator();
        lblMarkIDSearch = new javax.swing.JLabel();
        lblStudentIDSearch = new javax.swing.JLabel();
        lblSubjectNameSearch = new javax.swing.JLabel();
        lblMarkSearch = new javax.swing.JLabel();
        txtMarkIdSearch = new javax.swing.JTextField();
        txtSubjectNameSearch = new javax.swing.JTextField();
        txtMarkSearch = new javax.swing.JTextField();
        panelButtonSearch = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        txtStudentIdSearch = new javax.swing.JTextField();
        btnChooseStudentIdSearch = new javax.swing.JButton();
        btnChooseSubjectIdSearch = new javax.swing.JButton();
        panelLeft = new javax.swing.JPanel();
        lblEnterNameStudent = new javax.swing.JLabel();
        filterText = new javax.swing.JTextField();
        srcPanelMark = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        btnFilter = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        tpMark.setMinimumSize(new java.awt.Dimension(800, 200));

        pnlEdit.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlEdit.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlEdit.setLayout(new java.awt.GridBagLayout());

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setMinimumSize(new java.awt.Dimension(800, 200));
        panelRight.setPreferredSize(new java.awt.Dimension(800, 200));
        panelRight.setLayout(new java.awt.GridBagLayout());

        lblInfo.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblInfo.setForeground(new java.awt.Color(102, 0, 102));
        lblInfo.setText("Information Mark");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(lblInfo, gridBagConstraints);

        seqarator1.setMinimumSize(new java.awt.Dimension(650, 10));
        seqarator1.setPreferredSize(new java.awt.Dimension(650, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelRight.add(seqarator1, gridBagConstraints);

        lblMarkID.setForeground(new java.awt.Color(3, 3, 3));
        lblMarkID.setText("Mark ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblMarkID, gridBagConstraints);

        lblStudentID.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentID.setText("Student Id:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblStudentID, gridBagConstraints);

        lblSubjectName.setForeground(new java.awt.Color(3, 3, 3));
        lblSubjectName.setText("Subject ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelRight.add(lblSubjectName, gridBagConstraints);

        lblMark.setForeground(new java.awt.Color(3, 3, 3));
        lblMark.setText("Mark:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelRight.add(lblMark, gridBagConstraints);

        txtMarkId.setEnabled(false);
        txtMarkId.setMinimumSize(new java.awt.Dimension(200, 20));
        txtMarkId.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtMarkId, gridBagConstraints);

        txtSubjectID.setMinimumSize(new java.awt.Dimension(200, 20));
        txtSubjectID.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtSubjectID, gridBagConstraints);

        txtMark.setMinimumSize(new java.awt.Dimension(200, 20));
        txtMark.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtMark, gridBagConstraints);

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
        btnUpdate.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnUpdate.setMaximumSize(new java.awt.Dimension(77, 23));
        btnUpdate.setMinimumSize(new java.awt.Dimension(77, 23));
        btnUpdate.setPreferredSize(new java.awt.Dimension(77, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panelButton.add(btnUpdate);

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
        panelButton.add(btnDelete);

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
        panelButton.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(panelButton, gridBagConstraints);

        txtStudentId.setMinimumSize(new java.awt.Dimension(200, 20));
        txtStudentId.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtStudentId, gridBagConstraints);

        btnChooseStudentId.setText("jButton3");
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
        panelRight.add(btnChooseStudentId, gridBagConstraints);

        btnChooseSubjectId.setText("jButton4");
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
        panelRight.add(btnChooseSubjectId, gridBagConstraints);

        pnlEdit.add(panelRight, new java.awt.GridBagConstraints());

        tpMark.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlSearch.setLayout(new java.awt.GridBagLayout());

        panelRightSearch.setBackground(new java.awt.Color(255, 255, 255));
        panelRightSearch.setMinimumSize(new java.awt.Dimension(800, 200));
        panelRightSearch.setPreferredSize(new java.awt.Dimension(800, 200));
        panelRightSearch.setLayout(new java.awt.GridBagLayout());

        lblInfoSearch.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblInfoSearch.setForeground(new java.awt.Color(102, 0, 102));
        lblInfoSearch.setText("Information Mark");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRightSearch.add(lblInfoSearch, gridBagConstraints);

        seqaratorSearch.setMinimumSize(new java.awt.Dimension(650, 10));
        seqaratorSearch.setPreferredSize(new java.awt.Dimension(650, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelRightSearch.add(seqaratorSearch, gridBagConstraints);

        lblMarkIDSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblMarkIDSearch.setText("Mark ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(lblMarkIDSearch, gridBagConstraints);

        lblStudentIDSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblStudentIDSearch.setText("Student Id:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(lblStudentIDSearch, gridBagConstraints);

        lblSubjectNameSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblSubjectNameSearch.setText("Subject ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelRightSearch.add(lblSubjectNameSearch, gridBagConstraints);

        lblMarkSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblMarkSearch.setText("Mark:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 5);
        panelRightSearch.add(lblMarkSearch, gridBagConstraints);

        txtMarkIdSearch.setEnabled(false);
        txtMarkIdSearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtMarkIdSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(txtMarkIdSearch, gridBagConstraints);

        txtSubjectNameSearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtSubjectNameSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(txtSubjectNameSearch, gridBagConstraints);

        txtMarkSearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtMarkSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(txtMarkSearch, gridBagConstraints);

        panelButtonSearch.setBackground(new java.awt.Color(255, 255, 255));

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
        panelButtonSearch.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(panelButtonSearch, gridBagConstraints);

        txtStudentIdSearch.setMinimumSize(new java.awt.Dimension(180, 20));
        txtStudentIdSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(txtStudentIdSearch, gridBagConstraints);

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
        panelRightSearch.add(btnChooseStudentIdSearch, gridBagConstraints);

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
        panelRightSearch.add(btnChooseSubjectIdSearch, gridBagConstraints);

        pnlSearch.add(panelRightSearch, new java.awt.GridBagConstraints());

        tpMark.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpMark, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mark", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelLeft.setForeground(new java.awt.Color(3, 3, 3));
        panelLeft.setMinimumSize(new java.awt.Dimension(800, 400));
        panelLeft.setPreferredSize(new java.awt.Dimension(800, 400));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        lblEnterNameStudent.setBackground(new java.awt.Color(255, 255, 255));
        lblEnterNameStudent.setForeground(new java.awt.Color(3, 3, 3));
        lblEnterNameStudent.setText("Enter Filter:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(lblEnterNameStudent, gridBagConstraints);

        filterText.setPreferredSize(new java.awt.Dimension(180, 20));
        filterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filterTextKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(filterText, gridBagConstraints);

        srcPanelMark.setMinimumSize(new java.awt.Dimension(750, 300));
        srcPanelMark.setPreferredSize(new java.awt.Dimension(750, 300));
        srcPanelMark.setRequestFocusEnabled(false);

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContentMouseClicked(evt);
            }
        });
        srcPanelMark.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelLeft.add(srcPanelMark, gridBagConstraints);

        btnFilter.setText("Filter");
        btnFilter.setMaximumSize(new java.awt.Dimension(80, 23));
        btnFilter.setMinimumSize(new java.awt.Dimension(80, 23));
        btnFilter.setPreferredSize(new java.awt.Dimension(75, 23));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelLeft.add(btnFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelLeft, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void filterTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTextKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            searchStart();
        }
}//GEN-LAST:event_filterTextKeyPressed

    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        // TODO add your handling code here:
        int index = tableContent.getSelectedRow();
        if (index != -1) {
            int id = Integer.parseInt(String.valueOf(tableContent.getValueAt(index, 0)));
            Mark mark = getMarkById(id);
            loadDetails(mark);
        }
}//GEN-LAST:event_tableContentMouseClicked

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        searchStart();
}//GEN-LAST:event_btnFilterActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            if (!isAdd) {
                isAdd = true;
                txtStudentId.setVisible(false);
                txtSubjectID.setVisible(false);
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
            } else {
                Mark mark = new Mark();
                mark.setStudentId(txtStudentId.getText());
                mark.setMark(Float.parseFloat(txtMark.getText()));
                mark.setSubjectId(txtStudentId.getText());
                if (markDAO.create(mark)) {
                    isAdd = false;
                    txtStudentId.setVisible(true);
                    txtSubjectID.setVisible(true);
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                    listMark.add(mark);
                    loadData(listMark);
                }
            }
        } catch (Exception ex) {
        }
}//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            Mark mark = getMarkById(Integer.parseInt(txtMarkId.getText()));
            if (mark != null) {
                mark.setMark(Float.parseFloat(txtMark.getText()));
                if (markDAO.update(mark)) {
                    loadData(listMark);
                }
            }
        } catch (Exception ex) {
        }
}//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            Mark mark = getMarkById(Integer.parseInt(txtMarkId.getText()));
            if (mark != null) {
                if (markDAO.delete(mark)) {
                    listMark.remove(mark);
                    loadData(listMark);
                }
            }
        } catch (Exception ex) {
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnChooseSubjectIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseSubjectIdActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtSubjectID, true, 14);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnChooseSubjectIdActionPerformed

    private void btnChooseStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseStudentIdActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtSubjectID, true, 12);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnChooseStudentIdActionPerformed

    private void btnChooseStudentIdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseStudentIdSearchActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtStudentIdSearch, true, 12);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnChooseStudentIdSearchActionPerformed

    private void btnChooseSubjectIdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseSubjectIdSearchActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtSubjectNameSearch, true, 14);
        dlg.setTitle("Browse Order");
        dlg.setSize(868, 616);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnChooseSubjectIdSearchActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChooseStudentId;
    private javax.swing.JButton btnChooseStudentIdSearch;
    private javax.swing.JButton btnChooseSubjectId;
    private javax.swing.JButton btnChooseSubjectIdSearch;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel lblEnterNameStudent;
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
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelButtonSearch;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelRightSearch;
    public javax.swing.JPanel pnlEdit;
    public javax.swing.JPanel pnlSearch;
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
    private javax.swing.JTextField txtSubjectNameSearch;
    // End of variables declaration//GEN-END:variables

    String getSelectedName() {
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
