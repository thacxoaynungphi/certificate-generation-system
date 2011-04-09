/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
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
public class StudentMarkAllReportManager extends ReportManager {
    private SubjectDAO subjectDAO;
    private RegisterDAO registerDAO;
    private CourseDAO courseDAO;
    private StudentDAO studentDAO;

    public StudentMarkAllReportManager(ArrayList<Mark> listMark) {
        jasperFileName = "StudentMarkAll.jasper";
        subjectDAO = new SubjectDAO();
        courseDAO = new CourseDAO();
        studentDAO = new StudentDAO();
        registerDAO = new RegisterDAO();

        parameterMap = getParameterMap();
        dataCollection = getJRDataSource(listMark);
    }

    private HashMap getParameterMap(){
        parameterMap = new HashMap();

        parameterMap.put("ID", "Number");
        parameterMap.put("STUDENTID", "Student Code");
        parameterMap.put("STUDENTNAME", "Student Name");
        parameterMap.put("SUBJECT", "Subject's Name");
        parameterMap.put("COURSE", "Course's Name");
        parameterMap.put("MARK", "Mark");

        return parameterMap;
    }

    private JRMapCollectionDataSource getJRDataSource(ArrayList<Mark> listMark){
        ArrayList reportRows = new ArrayList();
        HashMap row = null;


        for (Mark mark : listMark) {
            row = new HashMap();
            Register reg = registerDAO.readByStudentCourseId(mark.getStudentId());
            Subject sub = subjectDAO.readByID(mark.getSubjectId());

            row.put("ID", mark.getId());
            row.put("STUDENTID", mark.getStudentId());
            row.put("STUDENTNAME", studentDAO.readByID(reg.getPersonId()).getFullName());
            row.put("COURSE", courseDAO.readById(sub.getCourseID()).getName());
            row.put("SUBJECT", sub.getName());
            row.put("MARK", mark.getMark());
            
            reportRows.add(row);
        }
        dataCollection = new JRMapCollectionDataSource(reportRows);
        return dataCollection;
    }
}
