/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.entity.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class SubjectInCourseReportManager extends ReportManager {

    private String courseId;

    public SubjectInCourseReportManager() {
    }

    public SubjectInCourseReportManager(String courseId, ArrayList<Subject> subList) {
        jrxmlFileName = "SubjectList.jrxml";
        this.courseId = courseId;
        dataSource = getJRMapCollectionDataSourse(subList);
    }



    @Override
    protected HashMap getParameterReport() {
        parameter = new HashMap();

        parameter.put("COURSE", new CourseDAO().readById(courseId).getName());
        parameter.put("ID", "Subject Code");
        parameter.put("SUBJECTNAME", "Subject Name");
        parameter.put("COEFFICIENT", "Subject's Fee");

        return parameter;
    }

    private JRDataSource getJRMapCollectionDataSourse(ArrayList<Subject> subList) {
        ArrayList collection = new ArrayList();
        HashMap row = null;

        for (Subject sub : subList) {
            if (sub.getCourseID().compareTo(courseId) == 0) {
                row = new HashMap();

                row.put("ID", sub.getId());
                row.put("SUBJECTNAME", sub.getName());
                row.put("COEFFICIENT", sub.getCoefficient());

                collection.add(row);
            }
        }

        dataSource = new JRMapCollectionDataSource(collection);

        return dataSource;
    }
}
