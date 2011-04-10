
/*
 * pnlCourseReport.java
 *
 * Created on Apr 3, 2011, 8:38:27 AM
 */
package com.hueic.CerGS.ui.report;

import com.hueic.CerGS.component.report.CourseReportManager;
import com.hueic.CerGS.entity.Course;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nhchung
 */
public class pnlCourseReport extends javax.swing.JPanel {

    /** Creates new form pnlCourseReport */
    public pnlCourseReport(ArrayList<Course> listCourse) {
        initComponents();
        CourseReportManager courseReport = new CourseReportManager(listCourse);
        //JPanel panel = studentReport.getEnumerationViewer(studentList, true);
        if (courseReport != null) {
            try {
                this.add(courseReport.getPanelViewer(true));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString(), "Report Message", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.setSize(860, 550);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
