/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Wind
 */
public class CertificateReportManager extends ReportManager{
    private String studentName;
    private String courseName;
    private Date degreeDate;
    private Date currentDate;
    private String grade;

    public CertificateReportManager() {
        jasperFileName = "Certificate.jrxml";
        dataCollection = null;
        parameterMap = getParameterReport();
    }

    public CertificateReportManager(String studentId, String courseId, Date degreeDate, String grade) {
        String personId = new RegisterDAO().readByStudentId(studentId).getId();
        String stName = new StudentDAO().readByID(personId).getFullName();

        String courseName = new CourseDAO().readById(courseId).getName();

        this.studentName = stName;
        this.courseName = courseName;
        this.degreeDate = degreeDate;
        this.currentDate = Calendar.getInstance().getTime();
        this.grade = grade;
    }

    private HashMap getParameterReport() {
        parameterMap = new HashMap();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(degreeDate);

        parameterMap.put("NAME", studentName);
        parameterMap.put("COURSE", courseName);
        parameterMap.put("CURRENTDATE", currentDate);
        parameterMap.put("DAY", calendar.get(Calendar.DAY_OF_MONTH));
        parameterMap.put("MONTH", calendar.get(Calendar.MONTH + 1));
        parameterMap.put("YEAR", calendar.get(Calendar.YEAR));
        parameterMap.put("GRADE", grade);

        return parameterMap;
    }


}
