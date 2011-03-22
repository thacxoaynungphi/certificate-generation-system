/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.entity.Payment;
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

    public JRDataSource getJRMapCollectionDataSource(ArrayList<Payment> payList) {

        ArrayList collection = new ArrayList();

        HashMap row = null;

        for(Payment pay : payList){
            row = new HashMap();

            row.put("ID", pay.)
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
