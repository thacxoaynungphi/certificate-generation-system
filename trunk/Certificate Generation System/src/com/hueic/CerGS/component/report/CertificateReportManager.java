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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class CertificateReportManager extends ReportManager {

    private String studentName;
    private String courseName;
    private Date degreeDate;
    private String grade;
    private CertificateDAO certificateDAO;
    private RegisterDAO registerDAO;
    private CourseDAO courseDAO;
    private StudentDAO studentDAO;
    private int cerNumber;
    public boolean status = true;

    public CertificateReportManager(String studentId) {
        jasperFileName = "Certificate.jasper";
        registerDAO = new RegisterDAO();
        certificateDAO = new CertificateDAO();
        courseDAO = new CourseDAO();
        studentDAO = new StudentDAO();
        Register regis = registerDAO.readByStudentId(studentId);
        Certificate cer = certificateDAO.readByStudentId(studentId);
        if (cer == null) {
            JOptionPane.showMessageDialog(null, "Degree is not developed", "Develop Degree", JOptionPane.ERROR_MESSAGE);
            status = false;
            return;
        }
        this.cerNumber = cer.getId();
        this.studentName = studentDAO.readByID(regis.getId()).getFullName();
        this.courseName = courseDAO.readById(regis.getCourseId()).getName();
        this.degreeDate = cer.getDegreeDay();
        this.grade = cer.getGrade();
        parameterMap = getParameterReport();
        dataCollection = getDataSource();
    }

    private HashMap getParameterReport() {
        parameterMap = new HashMap();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(degreeDate);

        parameterMap.put("CERNUMBER", cerNumber);
        parameterMap.put("COURSE", courseName);

        return parameterMap;
    }

    private JRMapCollectionDataSource getDataSource() {
        ArrayList collection = new ArrayList();
        HashMap row = new HashMap();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(degreeDate);

        row.put("NAME", studentName);
        row.put("DAY", calendar.get(Calendar.DAY_OF_MONTH));
        row.put("MONTH", calendar.get(Calendar.MONTH));
        row.put("YEAR", calendar.get(Calendar.YEAR));
        row.put("COURSE", courseName);
        row.put("GRADE", grade);
        collection.add(row);

        dataCollection = new JRMapCollectionDataSource(collection);

        return dataCollection;
    }
}
