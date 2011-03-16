/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

import com.hueic.CerGS.component.PropertyIndex;

/**
 *
 * @author HuuBien
 * Version 1.0
 * Mo ta qua trinh thanh toan tien cua sinh vien
 * date 13/3/11
 *
 */
public class Payment implements PropertyIndex {

    private int id;
    private String studentId;
    private float money;
    private String payday;

    public Payment() {
        setId(0);
        setStudentId(null);
        setMoney(0);
        setPayday(null);
    }

    public Payment(int id, String studentId, float money, String payday) {
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
     * @return the money
     */
    public float getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(float money) {
        this.money = money;
    }

    /**
     * @return the payday
     */
    public String getPayday() {
        return payday;
    }

    /**
     * @param payday the payday to set
     */
    public void setPayday(String payday) {
        this.payday = payday;
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
                value = String.valueOf(this.getMoney());
                break;
            case 4:
                value = this.getPayday();
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
