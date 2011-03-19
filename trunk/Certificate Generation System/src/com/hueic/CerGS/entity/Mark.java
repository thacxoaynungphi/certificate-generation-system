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
    }

    public Mark(int id, String studentId, String subjectId, float mark) {
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
    public void setId(int id) {
        this.id = id;
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
    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
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
    public void setMark(float mark) {
        this.mark = mark;
    }

    public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = String.valueOf(this.getId());
                break;
            case 2:
                value = this.getStudentId();
                break;
            case 3:
                value = this.getSubjectId();
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
