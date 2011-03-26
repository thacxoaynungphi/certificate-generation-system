package com.hueic.CerGS.entity;

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
public class Mark{

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
}
