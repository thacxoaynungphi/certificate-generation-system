/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.PaymentDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Payment;
import com.hueic.CerGS.entity.Register;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import org.apache.commons.collections.FastHashMap;

/**
 *
 * @author Wind
 */
public class StudentFeeReportManager extends ReportManager {

    private String courseId;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private RegisterDAO registerDAO;
    private ArrayList<Payment> listPayment;

    public StudentFeeReportManager(ArrayList<Payment> listPayment){
        studentDAO = new StudentDAO();
        courseDAO = new CourseDAO();
        registerDAO = new RegisterDAO();

        this.listPayment = listPayment;
        jasperFileName = "StudentFees.jasper";
        getDataSourse();
        getParameterMap();
    }

    private HashMap getParameterMap(){
        parameterMap = new HashMap();

        parameterMap.put("COURSE", "COURSE");
        parameterMap.put("ID", "Student's Code");
        parameterMap.put("NAME", "Student's Name");
        parameterMap.put("PAYMENT", "PAID");
        parameterMap.put("ARREARS", "Arrears");

        return parameterMap;
    }

    private JRMapCollectionDataSource getDataSourse(){
        ArrayList reportRows = new ArrayList();
        HashMap row = null;

        for(Payment pay : listPayment){
            row = new HashMap();
            Register reg = registerDAO.readByStudentId(pay.getStudentId());
            Course course = courseDAO.readById(reg.getCourseId());

            row.put("ID", pay.getStudentId());
            row.put("NAME", studentDAO.readByID(reg.getId()).getFullName());
            row.put("COURSE", course.getName());
            row.put("PAYMENT", pay.getMoney());
            row.put("ARREARS", courseDAO.readById(courseId).getTotalFees() - pay.getMoney());

            reportRows.add(row);
        }
        row = new HashMap();

        dataCollection = new JRMapCollectionDataSource(reportRows);

        return dataCollection;
    }
}
