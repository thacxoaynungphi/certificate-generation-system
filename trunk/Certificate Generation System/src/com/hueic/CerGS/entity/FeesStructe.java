/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

import com.hueic.CerGS.component.PropertyIndex;

/**
 *
 * @author Huu Bien
 * Version 1.0
 *
 * Lop FeesStructe mo ta cac hinh thuc dong hoc phi
 */
public class FeesStructe implements PropertyIndex {

    private int id;
    private String name;

    public FeesStructe() {
    }

    public FeesStructe(int id, String name) {
        setId(id);
        setName(name);
    }

    public FeesStructe(int id) {
        setId(id);
        setName(null);
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = String.valueOf(this.getId());
                break;
            case 2:
                value = this.getName();
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
