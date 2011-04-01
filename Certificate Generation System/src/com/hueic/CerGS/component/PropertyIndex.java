package com.hueic.CerGS.component;


public interface PropertyIndex {
    /**
     * This method used to get the right value for the table column
     * @param index index of the table column
     * @return the value
     */
    Object getPropertyValue(int index);
    /**
     * This method used to get the right value for the table column
     * @param index index of the table column
     * @return the value
     */
    void setPropertyValue(int index,Object value);
    /**
     * This method used to get the right value for the table column
     * @param index index of the table column
     * @return the value
     */
    Class getPropertyClass(int index);
}
