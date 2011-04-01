/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CertificateDAO;
import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Certificate;
import com.hueic.CerGS.entity.Register;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class CertificateDevelopedReportManager extends ReportManager {

    private ArrayList<Certificate> listCertificate;
    private CertificateDAO certificateDAO;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private RegisterDAO registerDAO;

    public CertificateDevelopedReportManager() {
        jasperFileName = "CertificateDeveloped.jasper";
        certificateDAO = new CertificateDAO();
        studentDAO = new StudentDAO();
        courseDAO = new CourseDAO();
        registerDAO = new RegisterDAO();

        listCertificate = certificateDAO.readByAll();

        parameterMap = getParameterReport();
        dataCollection = getJRMapCollectionDataSource();
    }

    private HashMap getParameterReport() {
        parameterMap = new HashMap();

        parameterMap.put("CERNUMBER", "Certificate Code");
        parameterMap.put("STUDENTID", "Student Code");
        parameterMap.put("STUDENTNAME", "Student Name");
        parameterMap.put("COURSENAME", "Course Name");
        parameterMap.put("DEGREEDATE", "Degree Date");
        parameterMap.put("GRADE", "Grade");

        return parameterMap;
    }

    private JRMapCollectionDataSource getJRMapCollectionDataSource() {
        ArrayList collection = new ArrayList();
        HashMap row = null;

        for (Certificate cer : listCertificate) {
            row = new HashMap();
            row.put("CERNUMBER", cer.getId());
            
            Register reg = registerDAO.readByStudentId(cer.getStudentID());

            row.put("STUDENTID", cer.getStudentID());
            row.put("STUDENTNAME", studentDAO.readByID(reg.getId()).getFullName());
            row.put("COURSENAME", courseDAO.readById(reg.getCourseId()).getName());
            row.put("DEGREEDATE", DateFormat.getInstance().format(cer.getDegreeDay()));

            String grade = "";
            if (cer.getMark() >= 7.5) {
                grade = "DISTINSTION";
            } else if (cer.getMark() > 50) {
                grade = "B";
            } else if (cer.getMark() > 40) {
                grade = "C";
            } else {
                grade = "Unpass";
            }

            row.put("GRADE", grade);

            collection.add(row);
        }
        dataCollection = new JRMapCollectionDataSource(collection);
        return dataCollection;
    }
}
