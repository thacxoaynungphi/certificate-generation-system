
/*
 * pnlCertificate.java
 *
 * Created on Apr 2, 2011, 3:41:08 AM
 */
package com.hueic.CerGS.ui.report;

import com.hueic.CerGS.component.report.CertificateReportManager;
import javax.swing.JOptionPane;

/**
 *
 * @author nhchung
 */
public class pnlCertificateReport extends javax.swing.JPanel {

    private CertificateReportManager cerReportManager;
    /** Creates new form pnlCertificate */
    public boolean status = true;

    public pnlCertificateReport(String studentId) {
        initComponents();
        // setLayout(new BorderLayout());
        cerReportManager = new CertificateReportManager(studentId);
        if (cerReportManager.status == false) {
            status = false;
            return;
        }
        try {
            this.add(cerReportManager.getPanelViewer(true));
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
