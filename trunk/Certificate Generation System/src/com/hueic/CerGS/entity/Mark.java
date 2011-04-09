package com.hueic.CerGS.entity;

import com.hueic.CerGS.component.PropertyIndex;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Huu Bien
 * Version 1.0
 *
 * Lop Scores mo ta danh sach diem cua moi sinh vien trong lop hoc va mon hoc tuong ung
 */
public class Mark implements PropertyIndex {

    private int id;
    private String studentId;
    private String subjectId;
    private float mark;

    public Mark() {
        id = 0;
        studentId = null;
        subjectId = null;
        mark = 0;
    }

    public Mark(int id, String studentId, String subjectId, float mark) throws Exception {
        setId(id);
        setStudentId(studentId);
        setSubjectId(subjectId);
        setMark(mark);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) throws Exception {
        if (id < 0) {
            throw new Exception("Id invalidation");
        } else {
            this.id = id;
        }
    }

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) throws Exception {
        if (studentId.length() <= 0 || studentId.length() > 20) {
            throw new Exception("Student id invalidation");
        } else {
            this.studentId = studentId;
        }
    }

    /**
     * @return the subjectId
     */
    public String getSubjectId() {
        return subjectId;
    }

    /**
     * @param subjectId the subjectId to set
     */
    public void setSubjectId(String subjectId) throws Exception {
        if (subjectId.length() <= 0 || subjectId.length() > 10) {
            throw new Exception("Subject id invalidation");
        } else {
            this.subjectId = subjectId;
        }
    }

    /**
     * @return the score
     */
    public float getMark() {
        return mark;
    }

    /**
     * @param score the score to set
     */
    public void setMark(float mark) throws Exception {
        if (mark < 0 || mark > 100) {
            throw new Exception("Mark must be between 0 to 100");
        } else {
            this.mark = mark;
        }

    }

    public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = String.valueOf(this.getId());
                break;
            case 2:
                value = String.valueOf(this.getStudentId());
                break;
            case 3:
                value = String.valueOf(this.getSubjectId());
                break;
            case 4:
                value = String.valueOf(this.getMark());
                break;
        }
        return value;
    }

    public void setPropertyValue(int index, Object value) {
    }

    public Class getPropertyClass(int index) {
        return String.class;
    }
}
