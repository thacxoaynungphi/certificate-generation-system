package com.hueic.CerGS.component;

/*
 * PropertyIndex.java
 *
 * Created on November 3, 2006, 8:42 AM
 */
/**
 *
 * @author Minh NGUYEN
 * This interface will help the entity determine which field
 * display in the right table column
 *
 */
public interface PropertyIndex {
    /**
     * This method used to get the right value for the table column
     * @param index index of the table column
     * @return Object
     */
    Object getPropertyValue(int index);
    /**
     * This method used to get the right value for the table column
     * @param index index of the table column     * 
     */
    void setPropertyValue(int index,Object value);
    /**
     * This method used to get the right value for the table column
     * @param index index of the table column
     * @return Class
     */
    Class getPropertyClass(int index);
}
