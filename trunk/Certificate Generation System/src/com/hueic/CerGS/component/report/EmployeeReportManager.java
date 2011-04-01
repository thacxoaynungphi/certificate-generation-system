/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.EmployeeDAO;
import com.hueic.CerGS.entity.Employee;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class EmployeeReportManager extends ReportManager{

    private EmployeeDAO employeeDAO;
    private ArrayList<Employee> listEmp;
    public EmployeeReportManager(){
        employeeDAO = new EmployeeDAO();
        listEmp = employeeDAO.readByAll();

        jasperFileName = "EmployeeList.jasper";
        dataCollection = getJRMapCollectionDataSource(listEmp);
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
            DateFormat dateFormat = DateFormat.getDateInstance();
            row.put("ID", emp.getId());
            row.put("NAME", emp.getFullName());
            row.put("BIRTHDAY", dateFormat.format(emp.getBirthDay()));
            row.put("BEGINWORK", dateFormat.format(emp.getBeginWork()));

            collection.add(row);
        }

        row = new HashMap();

        dataCollection= new JRMapCollectionDataSource(collection);

        return dataCollection;
    }

}
