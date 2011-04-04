/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.PaymentDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Payment;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class StudentFeeReportManger extends ReportManager {

    private String studentId;
    private ArrayList<Payment> listPayment;
    private PaymentDAO paymentDAO;
    private StudentDAO studentDAO;
    private RegisterDAO registerDAO;

    public StudentFeeReportManger(String StudentId) {
        this.studentId = StudentId;

        jasperFileName = "StudentFee.jasper";
        paymentDAO = new PaymentDAO();
        listPayment = paymentDAO.readByStudentId(StudentId);
        studentDAO = new StudentDAO();
        registerDAO = new RegisterDAO();

        parameterMap = getparameterMap();
        dataCollection = getJRDateSourse();
    }

    private HashMap getparameterMap() {
        parameterMap = new HashMap();

        parameterMap.put("ID", studentId);
        parameterMap.put("STUDENTNAME", studentDAO.readByID(registerDAO.readByStudentId(studentId).getId()).getFullName());
        parameterMap.put("DATE", "Day");
        parameterMap.put("FEE", "Fee");

        return parameterMap;
    }

    private JRMapCollectionDataSource getJRDateSourse() {
        ArrayList reportRows = new ArrayList();
        HashMap row = null;
        DateFormat dateFormat = DateFormat.getDateInstance();
        for (Payment pay : listPayment) {
            row = new HashMap();
            row.put("DATE", dateFormat.format(pay.getPayday()));
            row.put("FEE", pay.getMoney());

            reportRows.add(row);
        }
        row = new HashMap();

        dataCollection = new JRMapCollectionDataSource(reportRows);

        return dataCollection;
    }
}
