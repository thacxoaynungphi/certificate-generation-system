
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pnlSubject.java
 *
 * Created on Mar 31, 2011, 5:43:22 AM
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.ColumnData;
import com.hueic.CerGS.component.ObjectTableModel;
import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.SubjectDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Subject;
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
public class pnlSubject extends javax.swing.JPanel {

    private boolean isAdd = false;
    CourseDAO courseDAO;
    SubjectDAO subjectDao;
    ArrayList<Subject> listSubject = null;
    ArrayList<Subject> filter = null;
    ArrayList<Course> listCourses = new ArrayList<Course>();
    TableRowSorter<TableModel> sorter;
    private boolean isUpdate = false;
    private ObjectTableModel tableModel;
    private JTable headerTable;
    frmMain frm;

    /** Creates new form pnlSubject */
    public pnlSubject() {
        initComponents();
        subjectDao = new SubjectDAO();
        courseDAO = new CourseDAO();
        listCourses = courseDAO.readByAll();
        listSubject = new ArrayList<Subject>();
        listSubject = subjectDao.readByAll();
        loadData();
        if (listSubject.size() != 0) {
            loadDetails(listSubject.get(0));
        }
        btnCancel.setVisible(false);
    }

    public pnlSubject(frmMain frm) {
        initComponents();
        this.frm = frm;
        subjectDao = new SubjectDAO();
        courseDAO = new CourseDAO();
        listCourses = courseDAO.readByAll();
        listSubject = new ArrayList<Subject>();
        listSubject = subjectDao.readByAll();
        loadData();
        if (listSubject.size() != 0) {
            loadDetails(listSubject.get(0));
        }
        btnCancel.setVisible(false);
    }

    public void loadData() {
        filter = new ArrayList<Subject>();
        filter.clear();
        for (Subject sub : listSubject) {
            if (sub.getId().toLowerCase().matches(".*" + txtSubjectIdSearch.getText().trim().toLowerCase() + ".*")
                    && sub.getName().toLowerCase().matches(".*" + txtNameSearch.getText().trim().toLowerCase() + ".*")
                    && String.valueOf(sub.getCoefficient()).toLowerCase().matches(".*" + txtCoefficientSearch.getText().trim().toLowerCase() + ".*")
                    && sub.getCourseID().toLowerCase().matches(".*" + txtCoureIDSearch.getText().trim().toLowerCase() + ".*")) {
                filter.add(sub);
            }
        }
        if (filter.size() != 0) {
            loadDetails(filter.get(0));
        }

        ColumnData[] columns = {
            new ColumnData("ID", 135, SwingConstants.LEFT, 1),
            new ColumnData("Name", 200, SwingConstants.LEFT, 2),
            new ColumnData("Course ID", 140, SwingConstants.LEFT, 3),
            new ColumnData("Coefficient", 100, SwingConstants.LEFT, 4),
            new ColumnData("Status", 100, SwingConstants.LEFT, 5)
        };
        tableModel = new ObjectTableModel(tableContent, columns, filter);

        if (filter.size() != 0) {
            sorter = new TableRowSorter<TableModel>(tableModel);
            tableContent.setRowSorter(sorter);
        }

        headerTable = tableModel.getHeaderTable();
        // Create numbering column
        headerTable.createDefaultColumnsFromModel();
        tableContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Put it in a viewport that we can control a bit
        JViewport viewport = new JViewport();
        // Display numbering column
        viewport.setView(headerTable);
        viewport.setPreferredSize(headerTable.getMaximumSize());
        srcPanelSubject.setRowHeader(viewport);
        srcPanelSubject.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    public void loadDetails(Subject subject) {
        txtSubjectId.setText(subject.getId().trim());
        txtName.setText(subject.getName().trim());
        txtCoefficient.setText(String.valueOf(subject.getCoefficient()).trim());
        txtCoureID.setText(subject.getCourseID().trim());
    }

    public Course findByName(String name) {
        for (int i = 0; i
                < listCourses.size(); i++) {
            if (listCourses.get(i).getName().equalsIgnoreCase(name)) {
                return listCourses.get(i);
            }
        }
        return null;
    }

    public Course find(String id) {
        for (int i = 0; i
                < listCourses.size(); i++) {
            if (listCourses.get(i).getId().equalsIgnoreCase(id)) {
                return listCourses.get(i);
            }
        }
        return null;
    }

    public Subject findSubject(String id) {
        for (int i = 0; i
                < listSubject.size(); i++) {
            if (listSubject.get(i).getId().equalsIgnoreCase(id)) {
                return listSubject.get(i);


            }
        }
        return null;
    }

    public void searchStart() {
        if (listSubject.size() != 0) {
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

        tpSubject = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        panelRight = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblNameSub = new javax.swing.JLabel();
        lblCoefficient = new javax.swing.JLabel();
        lblCourseID = new javax.swing.JLabel();
        panelButton = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtCoefficient = new javax.swing.JTextField();
        lblSubjectID = new javax.swing.JLabel();
        txtSubjectId = new javax.swing.JTextField();
        sepa1 = new javax.swing.JSeparator();
        txtCoureID = new javax.swing.JTextField();
        btnChooseCourID = new javax.swing.JButton();
        pnlSearch = new javax.swing.JPanel();
        panelRightSearch = new javax.swing.JPanel();
        lblTitleSearch = new javax.swing.JLabel();
        lblNameSubSearch = new javax.swing.JLabel();
        lblCoefficientSearch = new javax.swing.JLabel();
        lblCourseIDSearch = new javax.swing.JLabel();
        panelButtonSearch = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        txtNameSearch = new javax.swing.JTextField();
        txtCoefficientSearch = new javax.swing.JTextField();
        lblSubjectIDSearch = new javax.swing.JLabel();
        txtSubjectIdSearch = new javax.swing.JTextField();
        sepa2Search = new javax.swing.JSeparator();
        txtCoureIDSearch = new javax.swing.JTextField();
        btnChooseCourIDSearch = new javax.swing.JButton();
        panelLeft = new javax.swing.JPanel();
        filterText = new javax.swing.JTextField();
        srcPanelSubject = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        btnFilter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnReport = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        tpSubject.setMinimumSize(new java.awt.Dimension(860, 200));
        tpSubject.setPreferredSize(new java.awt.Dimension(860, 200));

        pnlEdit.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlEdit.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlEdit.setLayout(new java.awt.GridBagLayout());

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setForeground(new java.awt.Color(3, 3, 3));
        panelRight.setMinimumSize(new java.awt.Dimension(860, 200));
        panelRight.setPreferredSize(new java.awt.Dimension(860, 200));
        panelRight.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Subject");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelRight.add(lblTitle, gridBagConstraints);

        lblNameSub.setForeground(new java.awt.Color(3, 3, 3));
        lblNameSub.setText("Name subject:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblNameSub, gridBagConstraints);

        lblCoefficient.setForeground(new java.awt.Color(3, 3, 3));
        lblCoefficient.setText("Coefficient:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelRight.add(lblCoefficient, gridBagConstraints);

        lblCourseID.setForeground(new java.awt.Color(3, 3, 3));
        lblCourseID.setText("Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelRight.add(lblCourseID, gridBagConstraints);

        panelButton.setBackground(new java.awt.Color(255, 255, 255));
        panelButton.setPreferredSize(new java.awt.Dimension(403, 33));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnAdd.setMaximumSize(new java.awt.Dimension(75, 23));
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
        btnUpdate.setMaximumSize(new java.awt.Dimension(75, 23));
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
        btnDelete.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnDelete.setMaximumSize(new java.awt.Dimension(75, 23));
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
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        panelRight.add(panelButton, gridBagConstraints);

        txtName.setMinimumSize(new java.awt.Dimension(200, 20));
        txtName.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 5);
        panelRight.add(txtName, gridBagConstraints);

        txtCoefficient.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 5);
        panelRight.add(txtCoefficient, gridBagConstraints);

        lblSubjectID.setForeground(new java.awt.Color(3, 3, 3));
        lblSubjectID.setText("Subject ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblSubjectID, gridBagConstraints);

        txtSubjectId.setMinimumSize(new java.awt.Dimension(200, 20));
        txtSubjectId.setPreferredSize(new java.awt.Dimension(200, 20));
        txtSubjectId.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 9, 5, 5);
        panelRight.add(txtSubjectId, gridBagConstraints);

        sepa1.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelRight.add(sepa1, gridBagConstraints);

        txtCoureID.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 5);
        panelRight.add(txtCoureID, gridBagConstraints);

        btnChooseCourID.setText("jButton1");
        btnChooseCourID.setMaximumSize(new java.awt.Dimension(23, 23));
        btnChooseCourID.setMinimumSize(new java.awt.Dimension(23, 23));
        btnChooseCourID.setPreferredSize(new java.awt.Dimension(23, 20));
        btnChooseCourID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseCourIDActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(btnChooseCourID, gridBagConstraints);

        pnlEdit.add(panelRight, new java.awt.GridBagConstraints());

        tpSubject.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));
        pnlSearch.setLayout(new java.awt.GridBagLayout());

        panelRightSearch.setBackground(new java.awt.Color(255, 255, 255));
        panelRightSearch.setForeground(new java.awt.Color(3, 3, 3));
        panelRightSearch.setMinimumSize(new java.awt.Dimension(860, 200));
        panelRightSearch.setPreferredSize(new java.awt.Dimension(860, 200));
        panelRightSearch.setLayout(new java.awt.GridBagLayout());

        lblTitleSearch.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitleSearch.setForeground(new java.awt.Color(102, 0, 102));
        lblTitleSearch.setText("Information Subject");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelRightSearch.add(lblTitleSearch, gridBagConstraints);

        lblNameSubSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblNameSubSearch.setText("Name subject:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(lblNameSubSearch, gridBagConstraints);

        lblCoefficientSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblCoefficientSearch.setText("Coefficient:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelRightSearch.add(lblCoefficientSearch, gridBagConstraints);

        lblCourseIDSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblCourseIDSearch.setText("Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 5);
        panelRightSearch.add(lblCourseIDSearch, gridBagConstraints);

        panelButtonSearch.setBackground(new java.awt.Color(255, 255, 255));
        panelButtonSearch.setPreferredSize(new java.awt.Dimension(265, 33));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnReset.setMaximumSize(new java.awt.Dimension(75, 23));
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
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 20, 5);
        panelRightSearch.add(panelButtonSearch, gridBagConstraints);

        txtNameSearch.setPreferredSize(new java.awt.Dimension(180, 20));
        txtNameSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNameSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 5);
        panelRightSearch.add(txtNameSearch, gridBagConstraints);

        txtCoefficientSearch.setMinimumSize(new java.awt.Dimension(200, 20));
        txtCoefficientSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtCoefficientSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCoefficientSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 5);
        panelRightSearch.add(txtCoefficientSearch, gridBagConstraints);

        lblSubjectIDSearch.setForeground(new java.awt.Color(3, 3, 3));
        lblSubjectIDSearch.setText("Subject ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(lblSubjectIDSearch, gridBagConstraints);

        txtSubjectIdSearch.setPreferredSize(new java.awt.Dimension(180, 20));
        txtSubjectIdSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSubjectIdSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 9, 5, 5);
        panelRightSearch.add(txtSubjectIdSearch, gridBagConstraints);

        sepa2Search.setPreferredSize(new java.awt.Dimension(750, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelRightSearch.add(sepa2Search, gridBagConstraints);

        txtCoureIDSearch.setPreferredSize(new java.awt.Dimension(200, 20));
        txtCoureIDSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCoureIDSearchCaretUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 5);
        panelRightSearch.add(txtCoureIDSearch, gridBagConstraints);

        btnChooseCourIDSearch.setText("jButton2");
        btnChooseCourIDSearch.setMaximumSize(new java.awt.Dimension(23, 23));
        btnChooseCourIDSearch.setMinimumSize(new java.awt.Dimension(23, 23));
        btnChooseCourIDSearch.setPreferredSize(new java.awt.Dimension(23, 20));
        btnChooseCourIDSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseCourIDSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRightSearch.add(btnChooseCourIDSearch, gridBagConstraints);

        pnlSearch.add(panelRightSearch, new java.awt.GridBagConstraints());

        tpSubject.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpSubject, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Subject", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelLeft.setMinimumSize(new java.awt.Dimension(860, 400));
        panelLeft.setPreferredSize(new java.awt.Dimension(860, 400));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        filterText.setMinimumSize(new java.awt.Dimension(180, 20));
        filterText.setPreferredSize(new java.awt.Dimension(180, 20));
        filterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filterTextKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(filterText, gridBagConstraints);

        srcPanelSubject.setMinimumSize(new java.awt.Dimension(840, 300));
        srcPanelSubject.setPreferredSize(new java.awt.Dimension(840, 300));
        srcPanelSubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                srcPanelSubjectMouseReleased(evt);
            }
        });

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
        tableContent.setMinimumSize(new java.awt.Dimension(770, 327));
        tableContent.setPreferredSize(new java.awt.Dimension(770, 327));
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContentMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableContentMouseReleased(evt);
            }
        });
        srcPanelSubject.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(srcPanelSubject, gridBagConstraints);

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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(btnFilter, gridBagConstraints);

        jLabel1.setForeground(new java.awt.Color(3, 3, 3));
        jLabel1.setText("Enter Filter:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 500, 5, 5);
        panelLeft.add(jLabel1, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        jPanel1.add(btnReport);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelLeft, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void filterTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTextKeyPressed
        // TODO add your handling code here:
        searchStart();
}//GEN-LAST:event_filterTextKeyPressed
    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_tableContentMouseClicked

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        searchStart();
}//GEN-LAST:event_btnFilterActionPerformed

    private void tableContentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseReleased
        // TODO add your handling code here:
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        try {
            // TODO add your handling code here:
            int index = tableContent.getSelectedRow();
            if (index != -1) {
                String value = tableContent.getValueAt(index, 0).toString();
                Subject subject = findSubject(value);
                if (subject != null) {
                    loadDetails(subject);
                }
            }
        } catch (Exception ex) {
            //TODO: chua xu ly
        }

    }//GEN-LAST:event_tableContentMouseReleased

    private void srcPanelSubjectMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_srcPanelSubjectMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_srcPanelSubjectMouseReleased

    private void btnChooseCourIDSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseCourIDSearchActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtCoureIDSearch, true, 7);
        dlg.setTitle("Browse Course");
        dlg.setSize(868, 580);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
}//GEN-LAST:event_btnChooseCourIDSearchActionPerformed

    private void txtCoureIDSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCoureIDSearchCaretUpdate
        // TODO add your handling code here:
        loadData();
}//GEN-LAST:event_txtCoureIDSearchCaretUpdate

    private void txtSubjectIdSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSubjectIdSearchCaretUpdate
        // TODO add your handling code here:
        loadData();
}//GEN-LAST:event_txtSubjectIdSearchCaretUpdate

    private void txtCoefficientSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCoefficientSearchCaretUpdate
        // TODO add your handling code here:
        loadData();
}//GEN-LAST:event_txtCoefficientSearchCaretUpdate

    private void txtNameSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNameSearchCaretUpdate
        // TODO add your handling code here:
        loadData();
}//GEN-LAST:event_txtNameSearchCaretUpdate

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtSubjectIdSearch.setText(null);
        txtNameSearch.setText(null);
        txtCoefficientSearch.setText(null);
        txtCoureIDSearch.setText(null);
}//GEN-LAST:event_btnResetActionPerformed

    private void btnChooseCourIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseCourIDActionPerformed
        // TODO add your handling code here:
        dlgChoose dlg = new dlgChoose(frm, txtCoureID, true, 7);
        dlg.setTitle("Browse Course");
        dlg.setSize(868, 580);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
}//GEN-LAST:event_btnChooseCourIDActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        if (isAdd) {
            isAdd = false;
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnCancel.setVisible(false);
            txtSubjectId.setRequestFocusEnabled(false);
        } else {
            loadDetails(listSubject.get(0));
        }
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String subjectid = txtSubjectId.getText();
        if (subjectDao.delete(subjectid)) {
            listSubject.remove(findSubject(subjectid));
            loadData();
            if (listSubject.size() != 0) {
                loadDetails(listSubject.get(0));
            }
            JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Delete Subject", JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Delete Subject", JOptionPane.ERROR_MESSAGE, null);
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            String subjectId = txtSubjectId.getText();
            String subjectName = txtName.getText();

            int coefficient = Integer.parseInt(txtCoefficient.getText());
            String courseId = txtCoureID.getText();
            Subject subject = new Subject(subjectId, subjectName, coefficient, courseId);

            if (subjectDao.update(subject)) {
                JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Update Subject", JOptionPane.INFORMATION_MESSAGE);
                listSubject.remove(findSubject(subjectId));
                listSubject.add(subject);
                loadData();
                loadDetails(subject);
            } else {
                JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Update Subject", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
}//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            if (!isAdd) {
                isAdd = true;
                btnCancel.setVisible(true);
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
                txtCoureID.setText(null);
                txtSubjectId.setText(null);
                txtSubjectId.setRequestFocusEnabled(true);
                txtName.setText(null);
                txtCoefficient.setText(null);

            } else {
                isAdd = false;
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
                btnCancel.setVisible(false);
                txtSubjectId.setRequestFocusEnabled(false);

                String subjectId = txtSubjectId.getText();
                String subjectName = txtName.getText();
                int coefficient = Integer.parseInt(txtCoefficient.getText());
                String courseId = txtCoureID.getText();
                Subject subject = new Subject(subjectId, subjectName, coefficient, courseId);


                if (subjectDao.create(subject)) {
                    JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Create Subject", JOptionPane.INFORMATION_MESSAGE);
                    listSubject.add(subject);
                    loadData();
                    loadDetails(subject);

                } else {
                    JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Create Subject", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Create Subject", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnAddActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
        frm.pnlReport.removeAll();
        dlgChooseReport report = new dlgChooseReport(frm, this);
        report.getSubjectReport(filter);
        report.setVisible(true);
        report.setSize(860, 600);
        frm.pnlReport.add(report);
        frm.tpnBusiness.setSelectedComponent(frm.pnlReport);
    }//GEN-LAST:event_btnReportActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChooseCourID;
    private javax.swing.JButton btnChooseCourIDSearch;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCoefficient;
    private javax.swing.JLabel lblCoefficientSearch;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblCourseIDSearch;
    private javax.swing.JLabel lblNameSub;
    private javax.swing.JLabel lblNameSubSearch;
    private javax.swing.JLabel lblSubjectID;
    private javax.swing.JLabel lblSubjectIDSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleSearch;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelButtonSearch;
    private javax.swing.JPanel panelLeft;
    public javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelRightSearch;
    public javax.swing.JPanel pnlEdit;
    public javax.swing.JPanel pnlSearch;
    private javax.swing.JSeparator sepa1;
    private javax.swing.JSeparator sepa2Search;
    private javax.swing.JScrollPane srcPanelSubject;
    private javax.swing.JTable tableContent;
    public javax.swing.JTabbedPane tpSubject;
    private javax.swing.JTextField txtCoefficient;
    private javax.swing.JTextField txtCoefficientSearch;
    private javax.swing.JTextField txtCoureID;
    private javax.swing.JTextField txtCoureIDSearch;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameSearch;
    private javax.swing.JTextField txtSubjectId;
    private javax.swing.JTextField txtSubjectIdSearch;
    // End of variables declaration//GEN-END:variables

    String getSelectedCode() {
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
