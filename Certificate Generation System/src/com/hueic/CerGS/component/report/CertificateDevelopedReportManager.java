/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Certificate;
import com.hueic.CerGS.entity.Student;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author Wind
 */
public class CertificateDevelopedReportManager extends ReportManager{

    public CertificateDevelopedReportManager(ArrayList<Certificate> cerList) {
        jasperFileName = "CertificateList.jasper";
        dataSource = getJRMapCollectionDataSource(cerList);
    }

    @Override
    public HashMap getParameterReport() {
        parameter = new HashMap();

        parameter.put("ID", "Student Code");
        parameter.put("NAME", "Student Name");
        parameter.put("COURSE", "COURSE");
        parameter.put("FINALMARK", "FINAL MARK");
        parameter.put("GRADE", "GRADE");

        return parameter;
    }

    private String getNameStudent(String StudentId){
        String stId = new RegisterDAO().readByStudentId(StudentId).getId();
        Student student = new StudentDAO().readByID(stId);
        
        String fullName = student.getFirstName() + " " + student.getLastName();
        
        return fullName;
    }

    private String getCourseName(String StudentId){
        String courseId = new RegisterDAO().readByStudentId(StudentId).getCourseId();
        return new CourseDAO().readById(courseId).getName();
    }
    public JRDataSource getJRMapCollectionDataSource(ArrayList<Certificate> cerList){
        ArrayList collection = new ArrayList();
        HashMap row = null;

        for(Certificate cer : cerList){
            row.put("ID", cer.getStudentID());
            row.put("NAME", getNameStudent(cer.getStudentID()));
            row.put("COURSE", getCourseName(cer.getStudentID()));
            row.put("FINALMARK", cer.getMark());

            String grade = "";
            if(cer.getMark() >= 7.5) grade = "DISTINSTION";
            else if(cer.getMark() > 50) grade = "B";
            else if(cer.getMark() > 40) grade = "C";
            else grade = "Unpass";

            row.put("GRADE", grade);

            collection.add(row);
        }

        return dataSource;
    }

}
