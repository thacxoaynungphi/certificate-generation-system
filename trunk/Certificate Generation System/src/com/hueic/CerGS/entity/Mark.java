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
public class Mark {

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
            throw new Exception("Mark invalidation");
        } else {
            this.mark = mark;
        }

    }
}
