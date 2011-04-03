package com.hueic.CerGS.component.report;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.view.JRViewer;

public class ReportManager {

    protected String jasperFileName;
    protected HashMap parameterMap;
    protected JRMapCollectionDataSource dataCollection;
    protected JasperPrint jasperPrint;

    protected JasperPrint getJasperPrint() throws Exception {
        JasperPrint jasperPrint = null;

        try {
            //THONG TIN PARAMETER
//            if(!dataCollection.next()) {
//                throw  new Exception("satisfy element not found ");
//            }
            jasperPrint = JasperFillManager.fillReport((InputStream) getInputStream(jasperFileName),
                    parameterMap, dataCollection);
        } catch (Exception ex) {
            throw ex;
        }
        return jasperPrint;
    }

    protected InputStream getInputStream(String reportName) {
        URL url = getClass().getResource("/com/hueic/CerGS/report/" + reportName);
        InputStream input = null;

        try {
            input = url.openStream();
            return input;
        } catch (IOException ex) {
            return null;
        }
    }

    public JPanel getPanelViewer(boolean isEnumeration) throws Exception {
        JPanel viewer = null;
        viewer = new JRViewer(getJasperPrint());
        return viewer;
    }
}
