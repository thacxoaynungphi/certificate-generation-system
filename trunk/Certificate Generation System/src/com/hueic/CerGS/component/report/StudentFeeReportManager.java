/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import java.util.HashMap;

/**
 *
 * @author Wind
 */
public class StudentFeeReportManager extends ReportManager {

    public StudentFeeReportManager() {

    }

     public JRDataSource getJRMapCollectionDataSource();

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
