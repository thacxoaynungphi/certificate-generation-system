package com.hueic.CerGS.entity;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wind
 * Version 1.0
 *
 * Lop Scores mo ta danh sach diem cua moi sinh vien trong lop hoc va mon hoc tuong ung
 */
public class Scores {

    private int id;
    private String studentId;
    private String subjectId;
    private float sL1;
    private float sL2;
    private float sT1;
    private float sT2;

    public Scores(){

    }

    public Scores(int id, String studentId, String subjectId){
        setId(id);
        setStudentId(studentId);
        setSubjectId(subjectId);
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
     * @return the sL1
     * tra ve diem ly thuyet lan 1
     */
    public float getsL1() {
        return sL1;
    }

    /**
     * @param sL1 the sL1 to set
     * ghi vao diem ly thuyet lan 1
     */
    public void setsL1(float sL1) {
        this.sL1 = sL1;
    }

    /**
     * @return the sL2
     * tra ve diem ly thuyet lan 2
     */
    public float getsL2() {
        return sL2;
    }

    /**
     * @param sL2 the sL2 to set
     * ghi vao diem ly thuyet lan 2
     */
    public void setsL2(float sL2) {
        this.sL2 = sL2;
    }

    /**
     * @return the sT1
     * tra ve diem thuc hanh lan 1
     */
    public float getsT1() {
        return sT1;
    }

    /**
     * @param sT1 the sT1 to set
     * ghi vao diem thuc hanh lan 1
     */
    public void setsT1(float sT1) {
        this.sT1 = sT1;
    }

    /**
     * @return the sT2
     * tra ve diem thuc hanh lan 2
     */
    public float getsT2() {
        return sT2;
    }

    /**
     * @param sT2 the sT2 to set
     * ghi vao diem thuc hanh lan 2
     */
    public void setsT2(float sT2) {
        this.sT2 = sT2;
    }

    
}
