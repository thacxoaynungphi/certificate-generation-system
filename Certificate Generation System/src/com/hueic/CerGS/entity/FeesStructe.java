/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

/**
 *
 * @author Huu Bien
 * Version 1.0
 *
 * Lop FeesStructe mo ta cac hinh thuc dong hoc phi
 */
public class FeesStructe {

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
}
