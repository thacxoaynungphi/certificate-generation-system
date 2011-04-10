
/*
 * pnlCertificateDevelopedReport.java
 *
 * Created on Apr 2, 2011, 3:47:10 AM
 */
package com.hueic.CerGS.ui.report;

import com.hueic.CerGS.component.report.CertificateDevelopedReportManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nhchung
 */
public class pnlCertificateDevelopedReport extends javax.swing.JPanel {

    /** Creates new form pnlCertificateDevelopedReport */
    public pnlCertificateDevelopedReport(ArrayList listCer) {
        initComponents();
        CertificateDevelopedReportManager cerDeveloped = new CertificateDevelopedReportManager(listCer);
        try {
            this.add(cerDeveloped.getPanelViewer(true));
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
