/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.PersonDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Payment;
import com.hueic.CerGS.entity.Register;
import com.hueic.CerGS.entity.Student;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author Wind
 */
public class StudentFeeReportManager extends ReportManager {

    public StudentFeeReportManager() {
    }

    public JRDataSource getJRMapCollectionDataSource(ArrayList<Payment> payList, ArrayList<Register> regisList) {

        ArrayList collection = new ArrayList();

        HashMap row = null;

        for(Register regis : regisList){
            row = new HashMap();

            Student student = new StudentDAO().readByID(regis.getId());
            Course course = new CourseDAO().readById(regis.getCourseId());

            row.put("ID", regis.getId());
            row.put("NAME",student.getFirstName() + " " + student.getLastName());
            row.put("COURSE", course.getName());
        }

        return dataSource;
    }

    @Override
    public HashMap getParameterReport() {
        parameter = new HashMap();

        parameter.put("ID", "Student Code");
        parameter.put("NAME", "Student Name");
        parameter.put("COURSE", "Course");
        parameter.put("FEE", "FEE");
        parameter.put("ARREARS", "ARREARS");

        return parameter;
    }
}
