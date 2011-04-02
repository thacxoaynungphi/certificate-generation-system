/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.SubjectDAO;
import com.hueic.CerGS.entity.Mark;
import com.hueic.CerGS.entity.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class StudentMarkAllReportManager extends ReportManager {
    private ArrayList<Mark> listMark;
    private SubjectDAO subjectDAO;
    private CourseDAO courseDAO;

    public StudentMarkAllReportManager(ArrayList<Mark> listMark) {
        this.listMark = listMark;

        jasperFileName = "StudentMarkAll.jasper";
        subjectDAO = new SubjectDAO();
        courseDAO = new CourseDAO();

        parameterMap = getParameterMap();
        dataCollection = getJRDataSource();
    }

    private HashMap getParameterMap(){
        parameterMap = new HashMap();

        parameterMap.put("ID", "Number");
        parameterMap.put("GRADE", "Grade");
        parameterMap.put("SUBJECT", "Subject's Name");
        parameterMap.put("COURSE", "Course's Name");
        parameterMap.put("MARK", "Mark");

        return parameterMap;
    }

    private JRMapCollectionDataSource getJRDataSource(){
        ArrayList reportRows = new ArrayList();
        HashMap row = null;


        for (Mark mark : listMark) {
            row = new HashMap();

            Subject sub = subjectDAO.readByID(mark.getSubjectId());

            row.put("ID", mark.getId());
            row.put("COURSE", courseDAO.readById(sub.getCourseID()).getName());
            row.put("SUBJECT", sub.getName());
            row.put("MARK", mark.getMark());
            String grade = "";
            if (mark.getMark() >= 7.5) {
                grade = "DISTINSTION";
            } else if (mark.getMark() > 60) {
                grade = "A";
            } else if (mark.getMark() > 50) {
                grade = "B";
            } else if (mark.getMark() > 40) {
                grade = "C";
            } else {
                grade = "Unpass";
            }

            row.put("GRADE", grade);

            reportRows.add(row);
        }
        dataCollection = new JRMapCollectionDataSource(reportRows);
        return dataCollection;
    }
}
