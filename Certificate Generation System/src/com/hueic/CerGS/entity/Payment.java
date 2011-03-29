/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

import java.sql.Date;

/**
 *
 * @author HuuBien
 * Version 1.0
 * Mo ta qua trinh thanh toan tien cua sinh vien
 * date 13/3/11
 *
 */
public class Payment {

    private int id;
    private String studentId;
    private float money;
    private Date payday;

    public Payment() {
        id = 0;
        studentId = null;
        money = 0;
        payday = null;
    }

    public Payment(int id, String studentId, float money, Date payday) throws Exception {
        setId(id);
        setStudentId(studentId);
        setMoney(money);
        setPayday(payday);
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
     * @return the money
     */
    public float getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(float money) throws Exception {
        if (money < 0) {
            throw new Exception("Money invalidation");
        } else {
            this.money = money;
        }
    }

    /**
     * @return the payday
     */
    public Date getPayday() {
        return payday;
    }

    /**
     * @param payday the payday to set
     */
    public void setPayday(Date payday) throws Exception {
        if (payday == null) {
            throw new Exception("Payday invalidation");
        } else {
            this.payday = payday;
        }
    }
}
