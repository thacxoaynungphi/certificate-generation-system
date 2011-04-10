
/*
 * pnlRegisterReport.java
 *
 * Created on Apr 3, 2011, 11:29:22 PM
 */
package com.hueic.CerGS.ui.report;

import com.hueic.CerGS.component.report.RegisterReportManager;
import com.hueic.CerGS.entity.Register;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Wind
 */
public class pnlRegisterReport extends javax.swing.JPanel {

    /** Creates new form pnlRegisterReport */
    public pnlRegisterReport(ArrayList<Register> listRegisters) {
        initComponents();
        RegisterReportManager reportManager = new RegisterReportManager(listRegisters);
        try {
            this.add(reportManager.getPanelViewer(true));
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
