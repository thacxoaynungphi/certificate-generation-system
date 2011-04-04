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
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class FeeReportManager extends ReportManager {

    private StudentDAO studentDAO;
    private PaymentDAO paymentDAO;
    private CourseDAO courseDAO;
    private RegisterDAO registerDAO;
    private ArrayList<Payment> listPayment;

    public FeeReportManager(ArrayList<Payment> listPayment) {
        studentDAO = new StudentDAO();
        courseDAO = new CourseDAO();
        registerDAO = new RegisterDAO();
        paymentDAO = new PaymentDAO();

        this.listPayment = listPayment;
        jasperFileName = "StudentFeesInCourse.jasper";
        dataCollection = getDataSourse();
        parameterMap = getParameterMap();
    }

    private HashMap getParameterMap() {
        parameterMap = new HashMap();

        parameterMap.put("PAYDATE", "Pay Day");
        parameterMap.put("ID", "Student's Code");
        parameterMap.put("NAME", "Student's Name");
        parameterMap.put("PAYMENT", "Paid");
        parameterMap.put("ARREARS", "Arrears");

        return parameterMap;
    }

    private JRMapCollectionDataSource getDataSourse() {
        ArrayList reportRows = new ArrayList();
        HashMap row = null;
        DateFormat dateFormat = DateFormat.getDateInstance();
        Register reg = null;
        Course course = null;

        for (Payment pay : listPayment) {
            row = new HashMap();
            reg = registerDAO.readByStudentId(pay.getStudentId());
            course = courseDAO.readById(reg.getCourseId());

            row.put("ID", pay.getStudentId());
            row.put("NAME", studentDAO.readByID(reg.getId()).getFullName());
            row.put("PAYDATE", dateFormat.format(pay.getPayday()));
            row.put("PAYMENT", pay.getMoney());
            row.put("ARREARS", course.getTotalFees() - paymentDAO.getCurrentTotalDiposit(pay));

            reportRows.add(row);
        }
        row = new HashMap();

        dataCollection = new JRMapCollectionDataSource(reportRows);

        return dataCollection;
    }
}
