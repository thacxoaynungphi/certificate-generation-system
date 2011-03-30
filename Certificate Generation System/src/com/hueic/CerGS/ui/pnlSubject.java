
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
    CourseDAO courseDAO = new CourseDAO();
    SubjectDAO subjectDao = new SubjectDAO();
    ArrayList<Subject> listSubject = new ArrayList<Subject>();
    ArrayList<Course> listCourses = new ArrayList<Course>();
    TableRowSorter<TableModel> sorter;
    private boolean isUpdate = false;
    private ObjectTableModel tableModel;
    private JTable headerTable;

    /** Creates new form pnlSubject */
    public pnlSubject() {
        initComponents();
        listCourses = courseDAO.readByAll();
        listSubject = subjectDao.readByAll();
        loadDataCBXCouseId();
        loadDataCBXCouse();
        loadData(listSubject);
        if (listSubject.size() != 0) {
            loadDetails(listSubject.get(0));
        }
    }

    public void loadDataCBXCouseId() {
        cbxCourseID.removeAllItems();

        for (int i = 0; i < listCourses.size(); i++) {
            cbxCourseID.addItem(listCourses.get(i).getId());
        }
    }

    public void loadDataCBXCouse() {
        cbxCourse.removeAllItems();

        for (int i = 0; i < listCourses.size(); i++) {
            cbxCourse.addItem(listCourses.get(i).getId());
        }
    }

    public void loadData(ArrayList<Subject> listSubjects) {

        ColumnData[] columns = {
            new ColumnData("Student ID", 135, SwingConstants.LEFT, 5),
            new ColumnData("ID", 100, SwingConstants.LEFT, 1),
            new ColumnData("Course ID", 140, SwingConstants.LEFT, 2),
            new ColumnData("Fees Structe", 170, SwingConstants.LEFT, 3),
            new ColumnData("Registration Date", 260, SwingConstants.LEFT, 4)
        };
        tableModel = new ObjectTableModel(tableContent, columns, listSubjects);
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
        srcPanelSubject.setRowHeader(viewport);
        srcPanelSubject.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    public void loadDetails(Subject subject) {
        txtSubjectId.setText(subject.getId().trim());
        txtName.setText(subject.getName().trim());
        txtCoefficient.setText(String.valueOf(subject.getCoefficient()).trim());
        String courseName = find(subject.getCourseID()).getName();
        txtCoureID.setText(subject.getCourseID().trim());
        if (courseName != null) {
            for (int i = 0; i < cbxCourseID.getItemCount(); i++) {
                if (cbxCourseID.getItemAt(i).toString().equals(courseName)) {
                    cbxCourseID.setSelectedIndex(i);
                }
            }
        }
    }

    public Course findByName(String name) {
        for (int i = 0; i < listCourses.size(); i++) {
            if (listCourses.get(i).getName().equalsIgnoreCase(name)) {
                return listCourses.get(i);
            }
        }
        return null;
    }

    public Course find(String id) {
        for (int i = 0; i < listCourses.size(); i++) {
            if (listCourses.get(i).getId().equalsIgnoreCase(id)) {
                return listCourses.get(i);
            }
        }
        return null;
    }

    public Subject findSubject(String id) {
        for (int i = 0; i < listSubject.size(); i++) {
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

        tpAccount = new javax.swing.JTabbedPane();
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
        cbxCourseID = new javax.swing.JComboBox();
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
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        panelLeft = new javax.swing.JPanel();
        lblCourse = new javax.swing.JLabel();
        cbxCourse = new javax.swing.JComboBox();
        filterText = new javax.swing.JTextField();
        srcPanelSubject = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        btnFilter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        tpAccount.setMinimumSize(new java.awt.Dimension(800, 200));

        pnlEdit.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlEdit.setPreferredSize(new java.awt.Dimension(810, 200));

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14)), "Management Subject", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelRight.setForeground(new java.awt.Color(3, 3, 3));
        panelRight.setMinimumSize(new java.awt.Dimension(800, 200));
        panelRight.setPreferredSize(new java.awt.Dimension(800, 200));
        panelRight.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitle.setForeground(new java.awt.Color(102, 0, 102));
        lblTitle.setText("Information Subject");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
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
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblCoefficient, gridBagConstraints);

        lblCourseID.setForeground(new java.awt.Color(3, 3, 3));
        lblCourseID.setText("Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblCourseID, gridBagConstraints);

        panelButton.setBackground(new java.awt.Color(255, 255, 255));
        panelButton.setPreferredSize(new java.awt.Dimension(265, 33));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnAdd.setMaximumSize(new java.awt.Dimension(70, 23));
        btnAdd.setMinimumSize(new java.awt.Dimension(70, 23));
        btnAdd.setPreferredSize(new java.awt.Dimension(72, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        panelButton.add(btnAdd);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/switch.jpg"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnUpdate.setMaximumSize(new java.awt.Dimension(80, 23));
        btnUpdate.setMinimumSize(new java.awt.Dimension(80, 23));
        btnUpdate.setPreferredSize(new java.awt.Dimension(80, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panelButton.add(btnUpdate);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnDelete.setMaximumSize(new java.awt.Dimension(70, 23));
        btnDelete.setMinimumSize(new java.awt.Dimension(70, 23));
        btnDelete.setPreferredSize(new java.awt.Dimension(72, 23));
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
        btnCancel.setMinimumSize(new java.awt.Dimension(70, 23));
        btnCancel.setPreferredSize(new java.awt.Dimension(72, 23));
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
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        panelRight.add(panelButton, gridBagConstraints);

        txtName.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 5);
        panelRight.add(txtName, gridBagConstraints);

        txtCoefficient.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
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

        txtSubjectId.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 9, 5, 5);
        panelRight.add(txtSubjectId, gridBagConstraints);

        sepa1.setPreferredSize(new java.awt.Dimension(330, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panelRight.add(sepa1, gridBagConstraints);

        txtCoureID.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 5);
        panelRight.add(txtCoureID, gridBagConstraints);

        cbxCourseID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCourseID.setPreferredSize(new java.awt.Dimension(230, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 5);
        panelRight.add(cbxCourseID, gridBagConstraints);

        pnlEdit.add(panelRight);

        tpAccount.addTab("Edit", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Edit_16.png")), pnlEdit); // NOI18N

        pnlSearch.setMinimumSize(new java.awt.Dimension(810, 200));
        pnlSearch.setPreferredSize(new java.awt.Dimension(810, 200));

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

        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
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

        jButton5.setText("jButton1");
        jButton5.setMaximumSize(new java.awt.Dimension(23, 23));
        jButton5.setMinimumSize(new java.awt.Dimension(23, 23));
        jButton5.setPreferredSize(new java.awt.Dimension(23, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panel3.add(jButton5, gridBagConstraints);

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

        pnlSearch.add(panel3);

        tpAccount.addTab("Search", new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/Search-32.png")), pnlSearch); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(tpAccount, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Subject", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 3, 3))); // NOI18N
        panelLeft.setMinimumSize(new java.awt.Dimension(800, 400));
        panelLeft.setPreferredSize(new java.awt.Dimension(800, 400));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        lblCourse.setForeground(new java.awt.Color(3, 3, 3));
        lblCourse.setText("Choose Course ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 5);
        panelLeft.add(lblCourse, gridBagConstraints);

        cbxCourse.setPreferredSize(new java.awt.Dimension(180, 20));
        cbxCourse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCourseItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 5);
        panelLeft.add(cbxCourse, gridBagConstraints);

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

        srcPanelSubject.setMinimumSize(new java.awt.Dimension(400, 150));
        srcPanelSubject.setPreferredSize(new java.awt.Dimension(400, 150));

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
        tableContent.setPreferredSize(new java.awt.Dimension(250, 64));
        tableContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContentMouseClicked(evt);
            }
        });
        srcPanelSubject.setViewportView(tableContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(srcPanelSubject, gridBagConstraints);

        btnFilter.setText("Filter");
        btnFilter.setPreferredSize(new java.awt.Dimension(90, 23));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelLeft.add(btnFilter, gridBagConstraints);

        jLabel1.setForeground(new java.awt.Color(3, 3, 3));
        jLabel1.setText("Enter Filter:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 5);
        panelLeft.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelLeft, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnAdd1ActionPerformed

    private void cbxCourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCourseItemStateChanged
        // TODO add your handling code here:
        String courseId = cbxCourse.getSelectedItem().toString();
        if (courseId != null) {
            listSubject = subjectDao.readByCourseId(courseId);
            loadData(listSubject);
            if (listSubject.size() != 0) {
                loadDetails(listSubject.get(0));
            }
        }
}//GEN-LAST:event_cbxCourseItemStateChanged

    private void filterTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTextKeyPressed
        // TODO add your handling code here:
        searchStart();
}//GEN-LAST:event_filterTextKeyPressed

    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        // TODO add your handling code here:
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
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
                txtCoureID.setVisible(false);
                cbxCourseID.setVisible(true);
                txtSubjectId.setText(null);
                txtName.setText(null);
                txtCoefficient.setText(null);
            } else {
                String subjectId = txtSubjectId.getText();
                String subjectName = txtName.getText();
                int coefficient = Integer.parseInt(txtCoefficient.getText());
                String courseId = cbxCourseID.getSelectedItem().toString();
                Subject subject = new Subject(subjectId, subjectName, coefficient, courseId);
                if (subjectDao.create(subject)) {
                    JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Create Subject", JOptionPane.INFORMATION_MESSAGE);
                    listSubject.add(subject);
                    loadData(listSubject);
                    loadDetails(subject);
                    isAdd = false;
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                    txtCoureID.setVisible(true);
                    cbxCourseID.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Create Subject", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Create Subject", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            if (!isUpdate) {
                cbxCourseID.setVisible(true);
                txtCoureID.setVisible(false);
                isUpdate = true;
            } else {
                isUpdate = false;
                String subjectId = txtSubjectId.getText();
                String subjectName = txtName.getText();
                int coefficient = Integer.parseInt(txtCoefficient.getText());
                String courseId = cbxCourseID.getSelectedItem().toString();
                Subject subject = new Subject(subjectId, subjectName, coefficient, courseId);
                if (subjectDao.update(subject)) {
                    JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Update Subject", JOptionPane.INFORMATION_MESSAGE);
                    listSubject.remove(findSubject(subjectId));
                    listSubject.add(subject);
                    loadData(listSubject);
                    loadDetails(subject);
                } else {
                    JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Update Subject", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
}//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String subjectid = txtSubjectId.getText();
        if (subjectDao.delete(subjectid)) {
            listSubject.remove(findSubject(subjectid));
            loadData(listSubject);
            if (listSubject.size() != 0) {
                loadDetails(listSubject.get(0));
            }
            JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Delete Subject", JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            JOptionPane.showMessageDialog(this, subjectDao.getLastError(), "Delete Subject", JOptionPane.ERROR_MESSAGE, null);
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        if (isAdd) {
            isAdd = false;
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            txtCoureID.setVisible(true);
            cbxCourseID.setVisible(false);
        } else if (isUpdate) {
            isUpdate = false;
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            txtCoureID.setVisible(true);
            cbxCourseID.setVisible(false);
            loadDetails(findSubject(txtSubjectId.getText()));
        } else {
            loadDetails(listSubject.get(0));
        }
}//GEN-LAST:event_btnCancelActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbxCourse;
    private javax.swing.JComboBox cbxCourseID;
    private javax.swing.JComboBox cbxUsername1;
    private javax.swing.JTextField filterText;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblCoefficient;
    private javax.swing.JLabel lblConfirmPass1;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblNameSub;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblSubjectID;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblType1;
    private javax.swing.JLabel lblUsername1;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel pnlEdit;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JSeparator sepa1;
    private javax.swing.JSeparator sepaAccount1;
    private javax.swing.JScrollPane srcPanelSubject;
    private javax.swing.JTable tableContent;
    private javax.swing.JTabbedPane tpAccount;
    private javax.swing.JTextField txtCoefficient;
    private javax.swing.JPasswordField txtConfirmPassword1;
    private javax.swing.JTextField txtCoureID;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword1;
    private javax.swing.JTextField txtSubjectId;
    private javax.swing.JTextField txtUsername1;
    // End of variables declaration//GEN-END:variables
}
