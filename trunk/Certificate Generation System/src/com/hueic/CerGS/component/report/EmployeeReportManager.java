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
public class EmployeeReportManager extends ReportManager {

    public EmployeeReportManager(ArrayList<Employee> listEmp) {
        jasperFileName = "EmployeeList.jasper";
        dataCollection = getJRMapCollectionDataSource(listEmp);
        parameterMap = getParameterReport();
    }

    private HashMap getParameterReport() {
        parameterMap = new HashMap();

        parameterMap.put("ID", "Id");
        parameterMap.put("NAME", "Full Name");
        parameterMap.put("BIRTHDAY", "Date Ò Birth");
        parameterMap.put("BEGINWORK", "The Begin Work");

        return parameterMap;
    }

    private JRMapCollectionDataSource getJRMapCollectionDataSource(ArrayList<Employee> empList) {
        HashMap row = null;
        ArrayList collection = new ArrayList();

        DateFormat dateFormat = DateFormat.getDateInstance();
        for (Employee emp : empList) {
            row = new HashMap();
            row.put("ID", emp.getId());
            row.put("NAME", emp.getFullName());
            row.put("BIRTHDAY", dateFormat.format(emp.getBirthDay()));
            row.put("BEGINWORK", dateFormat.format(emp.getBeginWork()));

            collection.add(row);
        }
        row = new HashMap();
        dataCollection = new JRMapCollectionDataSource(collection);
        return dataCollection;
    }
}
