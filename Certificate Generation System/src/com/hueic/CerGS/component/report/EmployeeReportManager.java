/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.entity.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class EmployeeReportManager extends ReportManager{

    public EmployeeReportManager() {
    }

    public EmployeeReportManager(ArrayList<Employee> empList){
        jasperFileName = "EmployeeList.jasper";
        dataSource = getJRMapCollectionDataSource(empList);
    }

    @Override
    protected HashMap getParameterReport() {
        parameter = new HashMap();

        parameter.put("ID", "ID");
        parameter.put("NAME", "FULL NAME");
        parameter.put("BIRTHDAY", "DATE OF BIRTH");
        parameter.put("BEGINWORK", "THE FIRST DAY TO WORKING");

        return parameter;
    }

    private JRDataSource getJRMapCollectionDataSource(ArrayList<Employee> empList) {
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

        dataSource = new JRMapCollectionDataSource(collection);

        return dataSource;
    }

}
