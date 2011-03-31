/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;

import com.hueic.CerGS.entity.Subject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Wind
 */
public class SubjectInCourseReportManager {
    private String course;

    public SubjectInCourseReportManager(String course) {
        this.course = course;
    }

    public JPanel getEnumerationViewer(ArrayList<Subject> arr, boolean isEnumeration) {
        JPanel viewer = null;
        try {
            //THONG TIN PARAMETER
            HashMap parameterMap = new HashMap();

            parameterMap.put("COURSE",course);
            parameterMap.put("ID", "Subject Code");
            parameterMap.put("NAME", "Subject Name");
            parameterMap.put("COEFFICIENT", "Subject's Coefficient");

            ArrayList reportRows = new ArrayList();
            HashMap rowMap = null;
            for (Subject sub : arr) {
                rowMap = new HashMap();
                rowMap.put("ID", sub.getId());
                rowMap.put("NAME", sub.getName());
                rowMap.put("COEFFICIENT", sub.getCoefficient());
                reportRows.add(rowMap);
            }
            rowMap = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(getInputStream("SubjectInCourse.jasper"),
                    parameterMap, new JRMapCollectionDataSource(reportRows));

            viewer = new JRViewer(jasperPrint);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        return viewer;
    }

    private InputStream getInputStream(String reportName) {
        URL url = getClass().getResource("/com/hueic/CerGS/report/" + reportName);
        InputStream input = null;

        try {
            input = url.openStream();
            return input;
        } catch (IOException ex) {
            return null;
        }

    }
}
