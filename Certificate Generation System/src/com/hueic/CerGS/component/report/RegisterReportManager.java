/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Register;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class RegisterReportManager extends ReportManager {

    private StudentDAO studentDAO;
    private CourseDAO courseDAO;

    public RegisterReportManager(ArrayList<Register> listRegis) {
        studentDAO = new StudentDAO();
        courseDAO = new CourseDAO();
        jasperFileName = "Register.jasper";
        parameterMap = getParameterMap();
        dataCollection = getJRDataSource(listRegis);
    }

    private HashMap getParameterMap() {
        parameterMap = new HashMap();

        parameterMap.put("STUDENTID", "Student Code");
        parameterMap.put("STUDENTNAME", "Student Name");
        parameterMap.put("COURSENAME", "Course Name");
        parameterMap.put("REGISDATE", "Registration Date");
        parameterMap.put("FEESTRUCTE", "Fee Structe");

        return parameterMap;
    }

    private JRMapCollectionDataSource getJRDataSource(ArrayList<Register> listRegis) {
        ArrayList collection = new ArrayList();
        HashMap row = null;

        for (Register regis : listRegis) {
            row = new HashMap();

            row.put("STUDENTID", regis.getStudentId());
            row.put("STUDENTNAME", studentDAO.readByID(regis.getId()).getFullName());
            row.put("COURSENAME", courseDAO.readById(regis.getCourseId()).getName());
            row.put("REGISDATE", DateFormat.getInstance().format(regis.getRegisDate()));
            if (regis.getFeesStructe() == 0) {
                row.put("FEESTRUCTE", "Full Payment");
            } else {
                row.put("FEESTRUCTE", "Installment Payment");
            }

            collection.add(row);
        }

        dataCollection = new JRMapCollectionDataSource(collection);
        return dataCollection;
    }
}
