/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CertificateDAO;
import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.MarkDAO;
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

    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private RegisterDAO registerDAO;
    private MarkDAO markDao;

    public CertificateDevelopedReportManager(ArrayList<Certificate> listCertificate) {
        jasperFileName = "CertificateDeveloped.jasper";
        studentDAO = new StudentDAO();
        courseDAO = new CourseDAO();
        registerDAO = new RegisterDAO();
        markDao = new MarkDAO();
        parameterMap = getParameterReport();
        dataCollection = getJRMapCollectionDataSource(listCertificate);
    }

    private HashMap getParameterReport() {
        parameterMap = new HashMap();

        parameterMap.put("CERNUMBER", "Certificate Number");
        parameterMap.put("STUDENTID", "Student Code");
        parameterMap.put("STUDENTNAME", "Student Name");
        parameterMap.put("COURSENAME", "Course Name");
        parameterMap.put("DEGREEDATE", "Degree Date");
        parameterMap.put("GRADE", "Grade");
        return parameterMap;
    }

    private JRMapCollectionDataSource getJRMapCollectionDataSource(ArrayList<Certificate> listCertificate) {
        ArrayList collection = new ArrayList();
        HashMap row = null;

        for (Certificate cer : listCertificate) {
            row = new HashMap();
            row.put("CERNUMBER", cer.getId());
            Register reg = registerDAO.readByStudentCourseId(cer.getStudentID());
            row.put("STUDENTID", cer.getStudentID());
            row.put("STUDENTNAME", studentDAO.readByID(reg.getStudentId()).getFullName());
            row.put("COURSENAME", courseDAO.readById(reg.getCourseId()).getName());
            row.put("DEGREEDATE", DateFormat.getInstance().format(cer.getDegreeDay()));
            row.put("GRADE", markDao.getGrades(cer.getMark()));

            collection.add(row);
        }
        dataCollection = new JRMapCollectionDataSource(collection);
        return dataCollection;
    }
}
