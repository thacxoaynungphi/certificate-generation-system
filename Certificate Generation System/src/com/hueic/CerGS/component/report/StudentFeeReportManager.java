/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.PaymentDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
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
    private PaymentDAO paymentDAO;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private RegisterDAO registerDAO;
    private ArrayList<Register> listRegis;

    public StudentFeeReportManager(String courseId){
        this.courseId = courseId;
        paymentDAO = new PaymentDAO();
        studentDAO = new StudentDAO();
        courseDAO = new CourseDAO();
        registerDAO = new RegisterDAO();

        listRegis = registerDAO.readByCourseId(courseId);
        jasperFileName = "StudentFees.jasper";
        getDataSourse();
        getParameterMap();
    }

    private HashMap getParameterMap(){
        parameterMap = new HashMap();

        parameterMap.put("COURSE", courseDAO.readById(courseId).getName());
        parameterMap.put("ID", "Student's Code");
        parameterMap.put("NAME", "Student's Name");
        parameterMap.put("PAYMENT", "PAID");
        parameterMap.put("ARREARS", "Arrears");

        return parameterMap;
    }

    private JRMapCollectionDataSource getDataSourse(){
        ArrayList reportRows = new ArrayList();
        HashMap row = null;

        for(Register regis : listRegis){
            row = new HashMap();
            float fee = paymentDAO.getTotalDiposit(regis.getStudentId());

            row.put("ID", regis.getStudentId());
            row.put("NAME", studentDAO.readByID(regis.getId()).getFullName());
            row.put("PAYMENT", fee);
            row.put("ARREARS", courseDAO.readById(courseId).getTotalFees() - fee);

            reportRows.add(row);
        }
        row = new HashMap();

        dataCollection = new JRMapCollectionDataSource(reportRows);

        return dataCollection;
    }
}
