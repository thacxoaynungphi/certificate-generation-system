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
import java.text.DateFormat;
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
        jrxmlFileName = "Certificate.jrxml";
        dataSource = null;
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

    @Override
    protected HashMap getParameterReport() {
        parameter = new HashMap();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(degreeDate);

        parameter.put("NAME", studentName);
        parameter.put("COURSE", courseName);
        parameter.put("CURRENTDATE", currentDate);
        parameter.put("DAY", calendar.get(Calendar.DAY_OF_MONTH));
        parameter.put("MONTH", calendar.get(Calendar.MONTH + 1));
        parameter.put("YEAR", calendar.get(Calendar.YEAR));
        parameter.put("GRADE", grade);

        return parameter;
    }


}
