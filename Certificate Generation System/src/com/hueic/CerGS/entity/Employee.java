
package com.hueic.CerGS.entity;

import com.hueic.CerGS.component.PropertyIndex;
import java.sql.Date;

/**
 *
 * @author nhchung
 * Date: 13/03/2011
 * Version: 1.0
 */
public class Employee extends Person implements PropertyIndex {

    private Date beginWork;
    //contruction

    public Employee() {
        super();
        beginWork = null;
    }

    public Employee(String id, String firstName, String lastName, Date birthDay, int gender, String phone, String email, String address, String image, Date beginWork) throws Exception {
        super(id, firstName, lastName, birthDay, gender, phone, email, address, image);
        setBeginWork(beginWork);
    }
    //method get-set    

    /**
     * @return the beginWork
     */
    public Date getBeginWork() {
        return beginWork;
    }

    /**
     * @param beginWork the beginWork to set
     */
    //khi nhap beginwork thi se dua vao Commbobox de nhap
    public void setBeginWork(Date beginWork) throws Exception {
        if (beginWork == null) {
            throw new Exception("Beginwork invalidation");
        } else {
            this.beginWork = beginWork;
        }
    }

    public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = String.valueOf(this.getId());
                break;
            case 2:
                value = String.valueOf(this.getFirstName());
                break;
            case 3:
                value = String.valueOf(this.getLastName());
                break;
            case 4:
                value = String.valueOf(this.getBirthDay());
                break;
            case 5:
                if (this.getGender() == 1) {
                    value = "Female";
                } else {
                    value = "Male";
                }
                break;
            case 6:
                value = String.valueOf(this.getPhone());
                break;
            case 7:
                value = String.valueOf(this.getEmail());
                break;
            case 8:
                value = String.valueOf(this.getAddress());
                break;
            case 9:
                value = String.valueOf(this.getImage());
                break;
            case 10:
                value = String.valueOf(this.getStatus());
                break;
            case 11:
                value = String.valueOf(this.getBeginWork());
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
