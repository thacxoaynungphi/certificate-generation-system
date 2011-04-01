/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class CertificateDevelopedReportManager extends ReportManager {

    public CertificateDevelopedReportManager(ArrayList<Certificate> cerList) {
        jasperFileName = "CertificateList.jrxml";
        dataCollection = getJRMapCollectionDataSource(cerList);
    }

    protected HashMap getParameterReport() {
        parameterMap = new HashMap();

        parameterMap.put("ID", "Student Code");
        parameterMap.put("NAME", "Student Name");
        parameterMap.put("COURSE", "COURSE");
        parameterMap.put("FINALMARK", "FINAL MARK");
        parameterMap.put("GRADE", "GRADE");

        return parameterMap;
    }

    private String getNameStudent(String StudentId) {
        String stId = new RegisterDAO().readByStudentId(StudentId).getId();

        return new StudentDAO().readByID(stId).getFullName();
    }

    private String getCourseName(String StudentId) {
        String courseId = new RegisterDAO().readByStudentId(StudentId).getCourseId();
        return new CourseDAO().readById(courseId).getName();
    }

    private JRMapCollectionDataSource getJRMapCollectionDataSource(ArrayList<Certificate> cerList) {
        ArrayList collection = new ArrayList();
        HashMap row = null;

        for (Certificate cer : cerList) {
            row.put("ID", cer.getStudentID());
            row.put("NAME", getNameStudent(cer.getStudentID()));
            row.put("COURSE", getCourseName(cer.getStudentID()));
            row.put("FINALMARK", cer.getMark());

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
