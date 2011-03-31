/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Wind
 */
public abstract class ReportManager1 {

    protected String jasperFileName;
    protected String jasperFolderName = "src\\hueic\\CerGS\\report";
    protected HashMap parameter;
    protected JRDataSource dataSource;
    protected JasperReport jasperReport;
    protected InputStream input;

    protected abstract HashMap getParameterReport();


    private JasperPrint getJasperPrint() {
        JasperPrint jasperPrint = null;
        try {
            input = getInputStream(jasperFileName);
            parameter = getParameterReport();
           // jasperReport = getReport(jrxmlFolderName + "\\" + jrxmlFileName);

            jasperPrint = JasperFillManager.fillReport(input, parameter, dataSource);
        } catch (JRException ex) {
            Logger.getLogger(ReportManager1.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jasperPrint;
    }

    public JPanel getJPanelViewer() {
        return new JRViewer(getJasperPrint());
    }

    public void exportToPdfFile(String pdfFileName) throws JRException {
        JasperExportManager.exportReportToPdfFile(getJasperPrint(), pdfFileName);
    }

    private InputStream getInputStream(String reportName) {
        URL url = getClass().getResource("../../report/" + reportName);
        InputStream input = null;

        try {
            input = url.openStream();
            System.out.println(url.getPath());
            return input;
        } catch (IOException ex) {
            return null;
        }
    }
}
