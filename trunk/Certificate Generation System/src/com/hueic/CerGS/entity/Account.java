/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.entity;

/**
 *
 * @author nhchung
 * Date : 13/03/2011
 * Version 1.0
 */
public class Account {

    //field
    private String username;
    private String password;
    private int permission;

     //contruction
    public Account()
    {
        username = null;
        password = null;
        permission = 0;
    }

    public Account(String username,String password,int permission)
    {
        setUsername(username);
        setPassword(password);
        setPermission(permission);
    }
    //method get-set
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the permission
     */
    public int getPermission() {
        return permission;
    }

    /**
     * @param permission the permission to set
     */
    public void setPermission(int permission) {
        this.permission = permission;
    }
}
