/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.MarkDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.dao.SubjectDAO;
import com.hueic.CerGS.entity.Mark;
import com.hueic.CerGS.entity.Register;
import com.hueic.CerGS.entity.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class StudentMarkReportManager extends ReportManager {

    private String studentId;
    private RegisterDAO registerDAO;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private MarkDAO markDAO;
    private SubjectDAO subjectDAO;

    public StudentMarkReportManager(String studentId) {
        this.studentId = studentId;
        jasperFileName = "StudentMarkReport.jasper";
        registerDAO = new RegisterDAO();
        studentDAO = new StudentDAO();
        courseDAO = new CourseDAO();
        markDAO = new MarkDAO();
        subjectDAO = new SubjectDAO();

        parameterMap = getParameterMap();
        dataCollection = getDataCollection();
    }

    private HashMap getParameterMap() {
        parameterMap = new HashMap();
        Register regis = registerDAO.readByStudentCourseId(studentId);

        parameterMap.put("ID", studentId);
        parameterMap.put("NAME", studentDAO.readByID(regis.getStudentId()).getFullName());
        parameterMap.put("COURSE", courseDAO.readById(regis.getCourseId()).getName());
        parameterMap.put("SUBJECTID", "Subject Code");
        parameterMap.put("SUBJECTNAME", "Subject Name");
        parameterMap.put("COEFFICIENT", "Coefficient");
        parameterMap.put("MARK", "Final Mark");

        return parameterMap;
    }

    private JRMapCollectionDataSource getDataCollection() {
        ArrayList reportRows = new ArrayList();
        HashMap row = null;

        ArrayList<Mark> listMark = markDAO.readByStudentID(studentId);

        for (Mark mark : listMark) {
            row = new HashMap();
            Subject sub = subjectDAO.readByID(mark.getSubjectId());
            row.put("SUBJECTID", mark.getSubjectId());
            row.put("SUBJECTNAME", sub.getName());
            row.put("COEFFICIENT", sub.getCoefficient());
            row.put("MARK", mark.getMark());
            reportRows.add(row);
        }
        dataCollection = new JRMapCollectionDataSource(reportRows);
        return dataCollection;
    }
}
