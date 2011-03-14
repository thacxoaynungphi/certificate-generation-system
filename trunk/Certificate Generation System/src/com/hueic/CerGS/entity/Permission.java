/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

/**
 *
 * @author nhchung
 * Date: 13/03/2011
 * Version 1.0
 */
public class Permission {

    //field
    private int id;
    private String name;

    //contruction
    public Permission() {
        id = 0;
        name = null;
    }

    public Permission(int id, String name) {
        setId(id);
        setName(name);
    }
    //method get-set

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
