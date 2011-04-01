/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.SubjectDAO;
import com.hueic.CerGS.entity.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class SubjectInCourseReportManager extends ReportManager {

    private String course;
    private ArrayList<Subject> listSubject;
    private SubjectDAO subjectDAO;

    public SubjectInCourseReportManager(String course) {
        this.course = course;
        subjectDAO = new SubjectDAO();
        listSubject = subjectDAO.readByCourseId(course);
    }

    private HashMap getParameterMap() {
        parameterMap = new HashMap();

        parameterMap.put("COURSE", course);
        parameterMap.put("ID", "Subject Code");
        parameterMap.put("NAME", "Subject Name");
        parameterMap.put("COEFFICIENT", "Subject's Coefficient");

        return parameterMap;
    }

    private JRMapCollectionDataSource getDataSource() {

        ArrayList reportRows = new ArrayList();
        HashMap rowMap = null;
        for (Subject sub : listSubject) {
            rowMap = new HashMap();
            rowMap.put("ID", sub.getId());
            rowMap.put("NAME", sub.getName());
            rowMap.put("COEFFICIENT", sub.getCoefficient());
            reportRows.add(rowMap);
        }
        rowMap = new HashMap();

        dataCollection = new JRMapCollectionDataSource(reportRows);
        return dataCollection;
    }
}
