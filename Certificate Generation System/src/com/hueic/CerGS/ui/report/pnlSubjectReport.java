
/*
 * pnllSubjectReport.java
 *
 * Created on Apr 3, 2011, 8:35:33 AM
 */
package com.hueic.CerGS.ui.report;

import com.hueic.CerGS.component.report.SubjectReportManager;
import com.hueic.CerGS.entity.Subject;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nhchung
 */
public class pnlSubjectReport extends javax.swing.JPanel {

    /** Creates new form pnllSubjectReport */
    public pnlSubjectReport(ArrayList<Subject> listSubject) {
        initComponents();
        SubjectReportManager subjectReport = new SubjectReportManager(listSubject);
        //JPanel panel = studentReport.getEnumerationViewer(studentList, true);
        if (subjectReport != null) {
            try {
                this.add(subjectReport.getPanelViewer(true));
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
