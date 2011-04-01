/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.entity.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class EmployeeReportManager extends ReportManager{

    public EmployeeReportManager() {
    }

    public EmployeeReportManager(ArrayList<Employee> empList){
        jasperFileName = "EmployeeList.jrxml";
        dataCollection = getJRMapCollectionDataSource(empList);
        parameterMap = getParameterReport();
    }

    private HashMap getParameterReport() {
        parameterMap = new HashMap();

        parameterMap.put("ID", "ID");
        parameterMap.put("NAME", "FULL NAME");
        parameterMap.put("BIRTHDAY", "DATE OF BIRTH");
        parameterMap.put("BEGINWORK", "THE FIRST DAY TO WORKING");

        return parameterMap;
    }

    private JRMapCollectionDataSource getJRMapCollectionDataSource(ArrayList<Employee> empList) {
        HashMap row = null;
        ArrayList collection = new ArrayList();
        
        for(Employee emp : empList){
            row = new HashMap();
            
            row.put("ID", emp.getId());
            row.put("NAME", emp.getFirstName() + " " + emp.getLastName());
            row.put("BIRTHDAY", emp.getBirthDay());
            row.put("BEGINWORK",emp.getBeginWork());

            collection.add(row);
        }

        row = new HashMap();

        dataCollection= new JRMapCollectionDataSource(collection);

        return dataCollection;
    }

}
