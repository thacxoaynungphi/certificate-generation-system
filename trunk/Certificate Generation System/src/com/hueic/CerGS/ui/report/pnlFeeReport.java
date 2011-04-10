
/*
 * pnlStudentFeeReport.java
 *
 * Created on Apr 2, 2011, 3:44:38 AM
 */
package com.hueic.CerGS.ui.report;

import com.hueic.CerGS.component.report.FeeReportManager;
import com.hueic.CerGS.entity.Payment;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nhchung
 */
public class pnlFeeReport extends javax.swing.JPanel {

    /** Creates new form pnlStudentFeeReport */
    public pnlFeeReport(ArrayList<Payment> listPayment) {
        initComponents();
        FeeReportManager studentFee = new FeeReportManager(listPayment);
        try {
            this.add(studentFee.getPanelViewer(true));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Report Message", JOptionPane.ERROR_MESSAGE);
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
