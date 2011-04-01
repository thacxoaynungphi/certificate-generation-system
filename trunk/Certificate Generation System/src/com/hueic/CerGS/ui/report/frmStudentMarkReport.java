/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmStudentScoreReport.java
 *
 * Created on Mar 22, 2011, 9:25:20 PM
 */

package com.hueic.CerGS.ui.report;

import com.hueic.CerGS.component.report.StudentMarkReportManager;

/**
 *
 * @author Wind
 */
public class frmStudentMarkReport extends javax.swing.JFrame {

    /** Creates new form frmStudentScoreReport */
    public frmStudentMarkReport(String studentId) {
        initComponents();
        StudentMarkReportManager report = new StudentMarkReportManager(studentId);
        this.add(report.getPanelViewer(true));
        this.setSize(1000, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmStudentMarkReport("CPISM9").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
