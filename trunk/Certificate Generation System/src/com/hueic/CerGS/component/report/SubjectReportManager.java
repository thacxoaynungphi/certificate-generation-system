/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.entity.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class SubjectReportManager extends ReportManager {
    
    private CourseDAO courseDAO;

    public SubjectReportManager(ArrayList<Subject> listSub) {
        courseDAO = new CourseDAO();
        jasperFileName = "Subject.jasper";
        parameterMap = getParameterMap();
        dataCollection = getJRDataSourse(listSub);
    }

    private HashMap getParameterMap() {
        parameterMap = new HashMap();

        parameterMap.put("ID", "Subject's Code");
        parameterMap.put("NAME", "Subject Name");
        parameterMap.put("COEFFICIENT", "Subject's Coefficient");
        parameterMap.put("COURSE", "Course");

        return parameterMap;
    }

    private JRMapCollectionDataSource getJRDataSourse(ArrayList<Subject> listSub){

        ArrayList reportRows = new ArrayList();
        HashMap rowMap = null;
        for (Subject sub : listSub) {
            rowMap = new HashMap();
            rowMap.put("ID", sub.getId());
            rowMap.put("NAME", sub.getName());
            rowMap.put("COURSE", courseDAO.readById(sub.getCourseID()).getName());
            rowMap.put("COEFFICIENT", sub.getCoefficient());
            reportRows.add(rowMap);
        }
        rowMap = new HashMap();

        dataCollection = new JRMapCollectionDataSource(reportRows);
        return dataCollection;
    }
}
