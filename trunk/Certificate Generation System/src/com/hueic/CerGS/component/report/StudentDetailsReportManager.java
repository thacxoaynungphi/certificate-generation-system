/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Student;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class StudentDetailsReportManager extends ReportManager{
    private Student student;

    public StudentDetailsReportManager(Student student){
        this.student = student;
        jasperFileName = "StudentDetail.jasper";

        parameterMap = getParameterMap();
        dataCollection = getJRDataSourse();
    }

    private HashMap getParameterMap(){
        parameterMap = new HashMap();

        return parameterMap;
    }

    private JRMapCollectionDataSource getJRDataSourse(){
        ArrayList collection = new ArrayList();
        HashMap row = new HashMap();

        row.put("STUDENTID", student.getId());
        row.put("STUDENTNAME", student.getFullName());

        if(student.getGender() == 0) row.put("GENDER", "MALE");
        else row.put("GENDER", "FEMALE");

        row.put("BIRTHDAY", DateFormat.getInstance().format(student.getBirthDay()));
        row.put("ADDRESS", student.getAddress());
        row.put("PHONE", student.getPhone());
        row.put("EMAIL", student.getEmail());

        collection.add(row);
        dataCollection = new JRMapCollectionDataSource(collection);

        return dataCollection;
    }
}
