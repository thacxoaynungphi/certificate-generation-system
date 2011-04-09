/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.entity.Employee;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class EmployeeDetailReportManager extends ReportManager {

    public EmployeeDetailReportManager(Employee emp) {
        jasperFileName = "EmployeeDetail.jasper";

        parameterMap = getParameterMap();
        dataCollection = getJRDataSourse(emp);
    }

    private HashMap getParameterMap() {
        parameterMap = new HashMap();

        return parameterMap;
    }

    private JRMapCollectionDataSource getJRDataSourse(Employee employee) {
        ArrayList collection = new ArrayList();
        HashMap row = new HashMap();
        DateFormat dateFormat = DateFormat.getDateInstance();

        row.put("EMPID", employee.getId());
        row.put("NAME", employee.getFullName());

        if (employee.getGender() == 0) {
            row.put("GENDER", "MALE");
        } else {
            row.put("GENDER", "FEMALE");
        }

        row.put("BIRTHDAY", dateFormat.format(employee.getBirthDay()));
        row.put("ADDRESS", employee.getAddress());
        row.put("PHONE", employee.getPhone());
        row.put("EMAIL", employee.getEmail());
        row.put("BEGINWORK", dateFormat.format(employee.getBeginWork()));
        collection.add(row);
        dataCollection = new JRMapCollectionDataSource(collection);

        return dataCollection;
    }
}
