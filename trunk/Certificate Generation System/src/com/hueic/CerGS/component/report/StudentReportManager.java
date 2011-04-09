/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Register;
import com.hueic.CerGS.entity.Student;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
//TODO can lam lai
public class StudentReportManager extends ReportManager {

    private StudentDAO studentDAO;
    private ArrayList<Register> listRegis;
    private RegisterDAO registerDAO;
    private CourseDAO courseDAO;

    public StudentReportManager(ArrayList<Student> listStudent) {
        studentDAO = new StudentDAO();
        registerDAO = new RegisterDAO();
        courseDAO = new CourseDAO();
        listRegis = new ArrayList<Register>();
        ArrayList<Register> temp = null;

        for(Student student : listStudent){
            temp = registerDAO.readByStudentIdOfPerson(student.getId());
            if(!temp.isEmpty())
                listRegis.addAll(temp);
        }
        jasperFileName = "StudentList.jasper";

        parameterMap = getParameter();
        dataCollection = getDataCollection();
    }

    private HashMap getParameter() {
        parameterMap = new HashMap();

        parameterMap.put("COURSE", "Course");
        parameterMap.put("ID", "Student Code");
        parameterMap.put("NAME", "Student Name");
        parameterMap.put("BIRTHDAY", "Birthday");
        parameterMap.put("REGISDATE", "REGISTRATION DATE");

        return parameterMap;
    }

    private JRMapCollectionDataSource getDataCollection() {
        ArrayList reportRows = new ArrayList();
        DateFormat dateFormat = DateFormat.getInstance();
        HashMap rowMap = null;
        for (Register reg : listRegis) {
            Student st = studentDAO.readByID(reg.getPersonId());
            rowMap = new HashMap();
            rowMap.put("ID", st.getId());
            rowMap.put("NAME", st.getFullName());
            rowMap.put("BIRTHDAY", dateFormat.format(new Date(st.getBirthDay().getTime())));
            Date regisDate = reg.getRegisDate();
            rowMap.put("REGISDATE", dateFormat.format(new Date(regisDate.getTime())));
            rowMap.put("COURSE", courseDAO.readById(reg.getCourseId()).getName());

            reportRows.add(rowMap);
        }
        rowMap = new HashMap();
        dataCollection = new JRMapCollectionDataSource(reportRows);

        return dataCollection;
    }
}
