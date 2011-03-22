/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Wind
 */
public abstract class ReportManager {

    protected String jasperFileName;
    protected HashMap parameter;
    protected JRDataSource dataSource;
    protected InputStream input;

    public abstract HashMap getParameterReport();
    
    public JasperPrint getJasperPrint(){
        JasperPrint jasperPrint = null;

        input = getInputStream();
        parameter = getParameterReport();
        
        try {
            jasperPrint = JasperFillManager.fillReport(input, parameter, dataSource);
        } catch (JRException ex) {
            Logger.getLogger(ReportManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jasperPrint;
    }

    public JPanel getJPanelViewer(String filename, ArrayList list){
        return new JRViewer(getJasperPrint());
    }

    public void exportToPdfFile(String pdfFileName) throws JRException{
        JasperExportManager.exportReportToPdfFile(getJasperPrint(), pdfFileName);
    }

    public InputStream getInputStream(){
        URL url = getClass().getResource("../../report/" + jasperFileName);
        try {
            input = url.openStream();
        } catch (IOException ex) {
            Logger.getLogger(ReportManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return input;
        }
    }

}
