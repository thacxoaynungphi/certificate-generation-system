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
    public Account() {
        username = null;
        password = null;
        permission = 0;
    }

    public Account(String username, String password, int permission) throws Exception {
        setUsername(username);
        setPassword(password);
        setPermission(permission);
    }

    public Account(String username, String oldPassword) throws Exception {
        setUsername(username);
        setPassword(password);
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
    public void setUsername(String username) throws Exception {
        if (username.length() > 20 || username.length() <= 0) {
            throw new Exception("Username invalidation");
        } else {
            this.username = username;
        }
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
    public void setPassword(String password) throws Exception {
        if (password.length() > 100 || password.length() <= 0) {
            throw new Exception("Password invalidation");
        } else {
            this.password = password;
        }
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
        if (permission < 0) {
            System.out.println("Permission invalidation");
        } else {
            this.permission = permission;
        }
    }
}
