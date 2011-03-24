/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component.report;

import com.hueic.CerGS.dao.CourseDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Mark;
import com.hueic.CerGS.entity.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author Wind
 */
public class StudentMarkReportManager extends ReportManager {

    private String studentId;
    private String studentName;
    private String courseId;

    public StudentMarkReportManager() {
        studentId = "";
        courseId = "";

    }

    private StudentMarkReportManager(String studentId,
            String courseId, ArrayList<Mark> markList, ArrayList<Subject> subList) {
        this.studentId = studentId;
        this.courseId = courseId;
        jrxmlFileName = "StudentMark.jrxml";
        dataSource = getJRMapCollectionDataSource(markList, subList);
    }

    

    @Override
    protected  HashMap getParameterReport() {
        parameter = new HashMap();
        
        parameter.put("ID", studentId);
        parameter.put("NAME", new StudentDAO().readByID(studentId).getFullName());
        parameter.put("COURSE", new CourseDAO().readById(courseId).getName());
        parameter.put("SUBJECTID", "Subject Code");
        parameter.put("SUBJECTNAME", "Subject Name");
        parameter.put("MARK", "Final Mark");
        parameter.put("GRADE", "Grade");

        return parameter;
    }

    private String getSubjectName(String subID, ArrayList<Subject> subList){
        for(Subject sub : subList){
            if(sub.getId().compareTo(subID) == 0) return sub.getName();
        }
        return null;
    }
    private JRDataSource getJRMapCollectionDataSource(ArrayList<Mark> markList, ArrayList<Subject> subList) {
        ArrayList collection = new ArrayList();

        HashMap row = null;

        for(Mark mark : markList){
            row = new HashMap();

            row.put("SUBJECTID", mark.getSubjectId());
            row.put("SUBJECTNAME", getSubjectName(mark.getSubjectId(), subList));
            row.put("MARK", mark.getMark());

            String grade = "";
            if(mark.getMark() >= 7.5) grade = "DISTINSTION";
            else if(mark.getMark() > 60) grade = "A";
            else if(mark.getMark() > 50) grade = "B";
            else if(mark.getMark() > 40) grade = "C";
            else grade = "Unpass";

            row.put("GRADE", grade);
            
            collection.add(row);
        }
        row = new HashMap();

        dataSource = new JRMapCollectionDataSource(collection);

        return dataSource;
    }
}
