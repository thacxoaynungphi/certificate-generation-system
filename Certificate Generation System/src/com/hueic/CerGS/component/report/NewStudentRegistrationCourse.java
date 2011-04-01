/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.MarkDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Register;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class NewStudentRegistrationCourse extends ReportManager{
    private String courseId;

    public NewStudentRegistrationCourse() {
    }

    public NewStudentRegistrationCourse(String courseId) {
        this.courseId = courseId;
    }

    protected HashMap getParameterMap() {
        parameterMap = new HashMap();

        parameterMap.put("ID", "Student Code");
        parameterMap.put("NAME", "Student Name");
        parameterMap.put("BIRTHDAY", "Birthday");
        parameterMap.put("REGISTRATIONDATE", "Date of Registration");
        parameterMap.put("COURSE", new CourseDAO().readById(courseId).getName());

        return parameterMap;
    }

    private JRDataSource getDataCollection(ArrayList<Register> regisList){
        ArrayList collection = new ArrayList();
        HashMap row = new HashMap();

        for(Register res : regisList){
            if(new MarkDAO().getStudentMark(res.getStudentId()) == -1){
                row = new HashMap();
                
                row.put("ID", res.getId());
                row.put("NAME", new StudentDAO().readByID(res.getId()).getFullName());
                row.put("BIRTHDAY", DateFormat.getInstance().format(new StudentDAO().readByID(res.getId()).getBirthDay()));
                row.put("REGISTRATIONDATE", DateFormat.getInstance().format(res.getRegisDate()));

                collection.add(row);
            }else continue;
        }

        row = new HashMap();

        dataCollection = new JRMapCollectionDataSource(collection);

        return dataCollection;
    }



}
