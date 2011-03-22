/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.entity.Register;
import com.hueic.CerGS.entity.Student;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class StudentReportManager extends ReportManager{

    public static final String JASPERFILE = "Student.jasper";
    private String course;

    public StudentReportManager(String course,ArrayList<Student> stList, ArrayList<Register> regisList) {
        this.course = course;
        jasperFileName = "Student.jasper";
        dataSource = getJRMapCollectionDataSource(stList, regisList);
    }

    @Override
    public HashMap getParameterReport() {
        parameter = new HashMap();

        parameter.put("ID", "STUDENT ID");
        parameter.put("NAME", "FULL NAME");
        parameter.put("BIRTHDAY", "DATE OF BIRTH");
        parameter.put("REGISTRATIONDAY", "REGISTRATION DAY");
        parameter.put("COURSE", course);

        return parameter;
    }

    public Date getRegistrationDateOfStudent(String id, ArrayList<Register> regisList){
        
        for(Register regis : regisList){
            if(regis.getId().compareTo(id) == 0) return regis.getRegisDate();
        }
        return null;
    }

    public JRDataSource getJRMapCollectionDataSource(ArrayList<Student> stList, ArrayList<Register> regisList) {
        ArrayList collection = new ArrayList();

        HashMap row = null;

        for(Student st : stList){
            row = new HashMap();

            row.put("ID", st.getId());
            row.put("NAME", st.getFirstName() + " " + st.getLastName());
            row.put("BIRTHDAY", DateFormat.getInstance().format(st.getBirthDay()));
            row.put("REGISTRATIONDAY",
                    DateFormat.getInstance().format(getRegistrationDateOfStudent(st.getId(), regisList)));
            
            collection.add(row);
        }

        dataSource = new JRMapCollectionDataSource(collection);
        
        return dataSource;
    }

}
