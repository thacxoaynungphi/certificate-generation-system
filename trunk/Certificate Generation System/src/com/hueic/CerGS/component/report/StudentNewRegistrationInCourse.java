/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.MarkDAO;
import com.hueic.CerGS.dao.RegisterDAO;
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
public class StudentNewRegistrationInCourse extends ReportManager{
    private String courseId;
    private ArrayList<Register> listRegis;
    private RegisterDAO registerDAO;
    private StudentDAO studentDAO;
    private MarkDAO markDAO;

    public StudentNewRegistrationInCourse(String courseId) {
        this.courseId = courseId;
        registerDAO = new RegisterDAO();
        studentDAO = new StudentDAO();
        markDAO = new MarkDAO();
        jasperFileName = "StudentNewRegistrationInCourse.jasper";

        listRegis = registerDAO.readByCourseId(this.courseId);

        getParameterMap();
        getDataCollection();

    }

    private HashMap getParameterMap() {
        parameterMap = new HashMap();

        parameterMap.put("ID", "Student Code");
        parameterMap.put("NAME", "Student Name");
        parameterMap.put("BIRTHDAY", "Birthday");
        parameterMap.put("REGISDATE", "Date of Registration");
        parameterMap.put("COURSE", new CourseDAO().readById(courseId).getName());

        return parameterMap;
    }

    private JRDataSource getDataCollection(){
        ArrayList collection = new ArrayList();
        HashMap row = new HashMap();

        for(Register res : listRegis){
            if(!markDAO.readByStudentID(res.getId()).isEmpty()){
                row = new HashMap();
                
                row.put("ID", res.getId());
                row.put("NAME", new StudentDAO().readByID(res.getId()).getFullName());
                row.put("BIRTHDAY", DateFormat.getInstance().format(studentDAO.readByID(res.getId()).getBirthDay()));
                row.put("REGISDATE", DateFormat.getInstance().format(res.getRegisDate()));

                collection.add(row);
            }else continue;
        }
        row = new HashMap();
        dataCollection = new JRMapCollectionDataSource(collection);

        return dataCollection;
    }



}
