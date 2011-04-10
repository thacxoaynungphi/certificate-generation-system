
/*
 * EmployeeDetailReport.java
 *
 * Created on Apr 3, 2011, 10:26:37 AM
 */

package com.hueic.CerGS.ui.report;

import com.hueic.CerGS.component.report.EmployeeDetailReportManager;
import com.hueic.CerGS.entity.Employee;
import javax.swing.JOptionPane;

/**
 *
 * @author Wind
 */
public class pnlEmployeeDetailReport extends javax.swing.JPanel {

    /** Creates new form EmployeeDetailReport */
    public pnlEmployeeDetailReport(Employee emp) {
        initComponents();
        EmployeeDetailReportManager detailsReportManager = new EmployeeDetailReportManager(emp);
        try {
            this.add(detailsReportManager.getPanelViewer(true));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Report Message", JOptionPane.ERROR_MESSAGE);
        }

        setSize(860, 580);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
