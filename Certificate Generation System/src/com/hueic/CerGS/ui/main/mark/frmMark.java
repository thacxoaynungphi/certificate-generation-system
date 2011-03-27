/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MarkFrm.java
 *
 * Created on Mar 25, 2011, 12:04:09 AM
 */
package com.hueic.CerGS.ui.main.mark;

import com.hueic.CerGS.component.IconSystem;
import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.MarkDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.dao.SubjectDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Mark;
import com.hueic.CerGS.entity.Register;
import com.hueic.CerGS.entity.Subject;
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
 * @author qhvic
 */
public class frmMark extends javax.swing.JFrame {

    private ArrayList<Mark> listMark = new ArrayList<Mark>();
    ArrayList<Register> resList = new ArrayList<Register>();
    ArrayList<Course> courseList = new ArrayList<Course>();
    private String courseId;
    private TableRowSorter<TableModel> sorter;
    private int currentMark;
    private RegisterDAO resDAO;
    private MarkDAO markDAO;
    private StudentDAO studentDAO;
    private SubjectDAO subjectDAO;
    private CourseDAO courseDAO;

    /** Creates new form MarkFrm */
    public frmMark() {
        initComponents();
        new IconSystem(this);
        setLocationRelativeTo(null);
        resDAO = new RegisterDAO();
        markDAO = new MarkDAO();
        studentDAO = new StudentDAO();
        subjectDAO = new SubjectDAO();
        courseDAO = new CourseDAO();
        resList = resDAO.readByAll();
        listMark = markDAO.readByAll();
        courseList = courseDAO.readByAll();
        if (listMark != null) {
            loadData(listMark);
            loadDetails(listMark.get(0));
        }
        loadStudent();
        loadCourse();
    }

    public void loadData(ArrayList<Mark> listMark) {
        String[] columns = {"Id", "StudentId", "SubjectId", "Mark"};
        Object[][] rows = new Object[listMark.size()][4];
        int index = 0;
        for (int i = 0; i < listMark.size(); i++) {
            Mark mark = listMark.get(i);
            rows[index][0] = mark.getId();
            rows[index][1] = mark.getStudentId();
            rows[index][2] = mark.getSubjectId();
            rows[index][3] = mark.getMark();
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
                false, false, false, false
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
        });
        sorter = new TableRowSorter<TableModel>(model);
        tableContent.setRowSorter(sorter);
        tableContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JViewport viewPort = new JViewport();
        viewPort.setView(tableContent);
        viewPort.setPreferredSize(tableContent.getMaximumSize());
        srcPanelMark.setRowHeader(viewPort);
        srcPanelMark.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, tableContent.getTableHeader());
    }

    public void loadDetails(Mark mark) {
        txtMarkId.setText(String.valueOf(mark.getId()));
        txtMark.setText(String.valueOf((mark.getMark())));

        String stId = resDAO.readByStudentId(mark.getStudentId()).getId();
        cbxStudentId.setSelectedItem(mark.getStudentId());
        txtSubjectName.setText(subjectDAO.readByID(mark.getSubjectId()).getName());
    }

    public void loadStudent() {
        cbxStudentId.removeAllItems();
        if (resList.size() != 0) {
            for (Register res : resList) {
                cbxStudentId.addItem(res.getStudentId());
            }
        }
    }

    public void loadCourse() {
        cbxCourseChooser.removeAllItems();
        cbxCourseChooser.addItem("All");
        cbxCourseChooser.setSelectedIndex(0);
        if (courseList.size() != 0) {
            for (Course course : courseList) {
                cbxCourseChooser.addItem(course.getId());
                System.out.println("hi");
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

        panelLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        panelLeft = new javax.swing.JPanel();
        lblChooseCourse = new javax.swing.JLabel();
        lblEnterNameStudent = new javax.swing.JLabel();
        cbxCourseChooser = new javax.swing.JComboBox();
        filterText = new javax.swing.JTextField();
        srcPanelMark = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        btnFilter = new javax.swing.JButton();
        panelRight = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        seqarator1 = new javax.swing.JSeparator();
        lblMarkID = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        lblSubjectName = new javax.swing.JLabel();
        lblMark = new javax.swing.JLabel();
        txtMarkId = new javax.swing.JTextField();
        cbxStudentId = new javax.swing.JComboBox();
        txtSubjectName = new javax.swing.JTextField();
        txtMark = new javax.swing.JTextField();
        panelButton = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Management Mark");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/BannerMark.png"))); // NOI18N

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo)
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelLogo, gridBagConstraints);

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mark", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panelLeft.setMinimumSize(new java.awt.Dimension(450, 320));
        panelLeft.setPreferredSize(new java.awt.Dimension(450, 320));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        lblChooseCourse.setText("Choose course:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(lblChooseCourse, gridBagConstraints);

        lblEnterNameStudent.setText("Enter Filter:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(lblEnterNameStudent, gridBagConstraints);

        cbxCourseChooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCourseChooser.setPreferredSize(new java.awt.Dimension(180, 20));
        cbxCourseChooser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCourseChooserItemStateChanged(evt);
            }
        });
        cbxCourseChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCourseChooserActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(cbxCourseChooser, gridBagConstraints);

        filterText.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelLeft.add(filterText, gridBagConstraints);

        srcPanelMark.setPreferredSize(new java.awt.Dimension(400, 200));

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
        btnFilter.setMaximumSize(new java.awt.Dimension(70, 23));
        btnFilter.setMinimumSize(new java.awt.Dimension(70, 23));
        btnFilter.setPreferredSize(new java.awt.Dimension(70, 23));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        panelLeft.add(btnFilter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(panelLeft, gridBagConstraints);

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Management Mark", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panelRight.setMinimumSize(new java.awt.Dimension(380, 320));
        panelRight.setPreferredSize(new java.awt.Dimension(380, 320));
        panelRight.setLayout(new java.awt.GridBagLayout());

        lblInfo.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblInfo.setForeground(new java.awt.Color(102, 0, 102));
        lblInfo.setText("Information Mark");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(lblInfo, gridBagConstraints);

        seqarator1.setPreferredSize(new java.awt.Dimension(280, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panelRight.add(seqarator1, gridBagConstraints);

        lblMarkID.setText("Mark ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblMarkID, gridBagConstraints);

        lblStudentID.setText("Student Id:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblStudentID, gridBagConstraints);

        lblSubjectName.setText("Subject Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblSubjectName, gridBagConstraints);

        lblMark.setText("Mark:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(lblMark, gridBagConstraints);

        txtMarkId.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtMarkId, gridBagConstraints);

        cbxStudentId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxStudentId.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(cbxStudentId, gridBagConstraints);

        txtSubjectName.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtSubjectName, gridBagConstraints);

        txtMark.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelRight.add(txtMark, gridBagConstraints);

        panelButton.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hueic/CerGS/images/add - 16.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMargin(new java.awt.Insets(2, 5, 2, 5));
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
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 5);
        panelRight.add(panelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        getContentPane().add(panelRight, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCourseChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCourseChooserActionPerformed
        // TODO add your handling code here:
        String courseId = (String) cbxCourseChooser.getSelectedItem();
        if (courseId != null && !courseId.equals("All")) {
            listMark = markDAO.readBYCourseID(courseId);
            loadData(listMark);
        } else {
            listMark = markDAO.readByAll();
            loadData(listMark);
        }
    }//GEN-LAST:event_cbxCourseChooserActionPerformed

    public Mark getMarkById(int id) {
        for (Mark mark : listMark) {
            if (mark.getId() == id) {
                return mark;
            }
        }
        return null;
    }
    private void tableContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContentMouseClicked
        // TODO add your handling code here:
        int index = tableContent.getSelectedRow();
        if (index != -1) {
            int id = Integer.parseInt(String.valueOf(tableContent.getValueAt(index, 0)));
            Mark mark = getMarkById(id);
            loadDetails(mark);
        }
    }//GEN-LAST:event_tableContentMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        Mark mark = getMarkById(Integer.parseInt(txtMarkId.getText()));
        mark.setMark(Float.parseFloat(txtMark.getText()));
        markDAO.update(mark);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            String subId = "";
            String subName = txtSubjectName.getText();
            ArrayList<Subject> subList = new SubjectDAO().readByAll();
            for (Subject sub : subList) {
                if (subName.compareTo(sub.getName()) == 0) {
                    subId = sub.getId();
                    break;
                }
            }
            if (subId.equals("")) {
                JOptionPane.showMessageDialog(this, "can't find subject hava name is " + subName, "Message", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            Mark mark = new Mark();
            mark.setId(new MarkDAO().readByAll().size() + 1);
            mark.setStudentId((String) cbxStudentId.getSelectedItem());
            mark.setMark(Float.parseFloat(txtMark.getText()));
            mark.setSubjectId(subId);
            markDAO.create(mark);
            listMark.add(mark);
            loadData(listMark);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        Mark mark = getMarkById(currentMark);
        listMark.remove(mark);
        markDAO.delete(mark);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cbxCourseChooserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCourseChooserItemStateChanged
        // TODO add your handling code here:
//        String courseId = (String) cbxCourseChooser.getSelectedItem();
//        if (courseId != null) {
//            ArrayList<Register> resList = resDAO.readByCourseId(courseId);
//
//            listMark.clear();
//            for (Register res : resList) {
//                ArrayList<Mark> marks = markDAO.readByStudentID(res.getStudentId());
//                listMark.addAll(marks);
//            }
//
//            loadData(listMark);
//        }
    }//GEN-LAST:event_cbxCourseChooserItemStateChanged

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_btnFilterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmMark().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbxCourseChooser;
    private javax.swing.JComboBox cbxStudentId;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel lblChooseCourse;
    private javax.swing.JLabel lblEnterNameStudent;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMark;
    private javax.swing.JLabel lblMarkID;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblSubjectName;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JPanel panelRight;
    private javax.swing.JSeparator seqarator1;
    private javax.swing.JScrollPane srcPanelMark;
    private javax.swing.JTable tableContent;
    private javax.swing.JTextField txtMark;
    private javax.swing.JTextField txtMarkId;
    private javax.swing.JTextField txtSubjectName;
    // End of variables declaration//GEN-END:variables
}
