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
public abstract class ReportManager {

    protected String jrxmlFileName;
    protected String jrxmlFolderName = "src\\hueic\\CerGS\\report";
    protected HashMap parameter;
    protected JRDataSource dataSource;
    protected JasperReport jasperReport;
    protected InputStream input;

    protected abstract HashMap getParameterReport();

    protected JasperReport getReport(String filename) throws JRException {
        if (System.getProperty("DEBUG") != null) {
            System.out.println("JasperReportUtils-> Checking report: " + filename);
        }

        String jasperFilename = filename;
        if (filename.indexOf(".xml") > -1) {
            jasperFilename = filename.substring(
                    0, filename.lastIndexOf(".xml"));
        }
        if (filename.indexOf(".jrxml") > -1) {
            jasperFilename = filename.substring(
                    0, filename.lastIndexOf(".jrxml"));
        }
        File jasperFile = new File(jasperFilename + ".jasper");
        if (!jasperFile.exists()) {
            //The XML should exist so compile that
            File xmlFile = new File(filename);
            if (!xmlFile.exists()) {
                return null;
            }
            JasperCompileManager.compileReportToFile(
                    xmlFile.getPath(), jasperFile.getPath());
        }
        if (!jasperFile.exists()) {
            return null;
        }
        //Load and return the report
        return (JasperReport) JRLoader.loadObject(jasperFile.getPath());
    }

    private JasperPrint getJasperPrint() {
        JasperPrint jasperPrint = null;
        try {
            input = getInputStream();
            parameter = getParameterReport();
            jasperReport = getReport(jrxmlFolderName + "\\" + jrxmlFileName);

            if(jasperReport != null) System.out.println(jasperReport.getColumnCount());
            else System.out.println("123");

            jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, dataSource);
        } catch (JRException ex) {
            Logger.getLogger(ReportManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jasperPrint;
    }

    public JPanel getJPanelViewer() {
        return new JRViewer(getJasperPrint());
    }

    public void exportToPdfFile(String pdfFileName) throws JRException {
        JasperExportManager.exportReportToPdfFile(getJasperPrint(), pdfFileName);
    }

    private InputStream getInputStream() {
        URL url = getClass().getResource("../../report/" + jrxmlFileName);
        try {
            input = url.openStream();
        } catch (IOException ex) {
            Logger.getLogger(ReportManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return input;
        }
    }
}
