package com.hueic.CerGS.component.report;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.hueic.CerGS.dao.RegisterDAO;
import com.hueic.CerGS.dao.StudentDAO;
import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.entity.Student;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;

public class ReportManager {

    RegisterDAO registerDAO;
    String course;

    public ReportManager() {
        registerDAO = new RegisterDAO();
    }

    public ReportManager(String course) {
        this.registerDAO = new RegisterDAO();
        this.course = course;
    }



    @SuppressWarnings(value = "unchecked")
    public JPanel getEnumerationViewer(ArrayList<Student> arr, boolean isEnumeration) {
        JPanel viewer = null;
        try {
            //THONG TIN PARAMETER
            HashMap parameterMap = new HashMap();

            parameterMap.put("COURSE", course);
            parameterMap.put("ID", "ID");
            parameterMap.put("NAME", "FULL NAME");
            parameterMap.put("BIRTHDAY", "BIRTHDAY");
            parameterMap.put("REGISDATE", "REGISTRATION DATE");

            ArrayList reportRows = new ArrayList();
            //THONG TIN HOC VIEN
            HashMap rowMap = null;
            for (Student st : arr) {
                rowMap = new HashMap();
                rowMap.put("ID", "ID");
                rowMap.put("NAME", st.getFullName());
                java.util.Date regisDate = null;
                java.util.Date birthday = new java.util.Date(st.getBirthDay().getTime());
                
                try{
                    regisDate = registerDAO.readById(st.getId(), course).getRegisDate();
                    System.out.println(st.getId());
                }catch(Exception ex){
                    continue;
                }
                rowMap.put("BIRTHDAY", DateFormat.getInstance().format(birthday));
                rowMap.put("REGISDATE", DateFormat.getInstance().format(regisDate));

                reportRows.add(rowMap);
            }
            rowMap = new HashMap();
            InputStream input = getInputStream("StudentInCourse.jasper");
            JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(reportRows);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(input, parameterMap,dataSource) ;

            if(jasperPrint == null) System.out.println("123");
            viewer = new JRViewer(jasperPrint);

        }
        catch (JRException ex) {
            Logger.getLogger(ReportManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return viewer;
    }

    private InputStream getInputStream(String reportName) {
        URL url = getClass().getResource("../../report/" + reportName);
        InputStream input = null;

        try {
            input = url.openStream();
            System.out.println(url.getPath());
            return input;
        } catch (IOException ex) {
            return null;
        }
    }
}
