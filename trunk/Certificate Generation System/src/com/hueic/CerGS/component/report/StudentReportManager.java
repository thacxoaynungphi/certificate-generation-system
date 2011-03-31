/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.entity.Student;
import com.jidesoft.utils.Base64.InputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Wind
 */
public class StudentReportManager{

    private String course;
    private RegisterDAO registerDAO;

    public StudentReportManager(String course) {
        this.course = course;
    }

    public JPanel getEnumerationViewer(ArrayList<Student> arr, boolean isEnumeration) {
        JPanel viewer = null;
        DateFormat dateFormat = DateFormat.getInstance();
        try {
            //THONG TIN PARAMETER
            HashMap parameterMap = new HashMap();

            parameterMap.put("COURSE",course);
            parameterMap.put("ID", "Student Code");
            parameterMap.put("NAME", "Student Name");
            parameterMap.put("BIRTHDAY", "Birthday");
            parameterMap.put("REGISDATE", "REGISTRATION DATE");

            ArrayList reportRows = new ArrayList();
            HashMap rowMap = null;
            for (Student st : arr) {
                rowMap = new HashMap();
                rowMap.put("ID", st.getId());
                rowMap.put("NAME", st.getFullName());
                rowMap.put("BIRTHDAY", dateFormat.format(new Date(st.getBirthDay().getTime())));
                Date regisDate = registerDAO.readById(st.getId(), course).getRegisDate();
                rowMap.put("REGISDATE", dateFormat.format(new Date(regisDate.getTime())));
                reportRows.add(rowMap);
            }
            rowMap = new HashMap();
            // TODO: ngang ni van loi
            JasperPrint jasperPrint = JasperFillManager.fillReport(getInputStream("StudentInCourse.jasper"),
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
            input = (InputStream) url.openStream();
            return input;
        } catch (IOException ex) {
            return null;
        }

    }
}
