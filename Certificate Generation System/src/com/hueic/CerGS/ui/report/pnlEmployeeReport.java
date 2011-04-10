
/*
 * pnlEmployeeReport.java
 *
 * Created on Apr 2, 2011, 3:43:43 AM
 */
package com.hueic.CerGS.ui.report;

import com.hueic.CerGS.component.report.EmployeeReportManager;
import com.hueic.CerGS.entity.Employee;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nhchung
 */
public class pnlEmployeeReport extends javax.swing.JPanel {

    /** Creates new form pnlEmployeeReport */
    public pnlEmployeeReport(ArrayList<Employee> listEmp) {
        initComponents();
        EmployeeReportManager empreport = new EmployeeReportManager(listEmp);
        try {
            this.add(empreport.getPanelViewer(true));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Report Message", JOptionPane.ERROR_MESSAGE);
        }
        this.setSize(860, 580);
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
