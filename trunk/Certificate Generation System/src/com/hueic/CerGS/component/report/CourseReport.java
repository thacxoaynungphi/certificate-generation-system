/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.entity.Course;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class CourseReport extends ReportManager {
    private ArrayList<Course> listCourse;

    public CourseReport(ArrayList<Course> listCourse) {
        this.listCourse = listCourse;
    }

    private HashMap getParameterMap(){
        parameterMap = new HashMap();

        parameterMap.put("ID", "Course's Code");
        parameterMap.put("NAME", "Course's Name");
        parameterMap.put("FEE", "Total Fees");

        return parameterMap;
    }

    private JRMapCollectionDataSource getJRDataSourse(){
        ArrayList collection = new ArrayList();
        HashMap row = null;

        for(Course course : listCourse){
            row = new HashMap();
            row.put("ID", course.getId());
            row.put("NAME", course.getName());
            row.put("FEE", course.getTotalFees());

            collection.add(row);
        }

        dataCollection = new JRMapCollectionDataSource(collection);

        return dataCollection;
    }
}
