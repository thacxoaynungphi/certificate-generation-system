/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Person;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nhchung
 */
public class PersonDAOTest {

    public PersonDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testReadByAll() {
        System.out.println("ReadByAll");
        PersonDAO instance = new PersonDAO();
        ArrayList expResult = null;
        ArrayList result = instance.ReadByAll();
        if(result != null)
            System.out.println("Thanh cong");

        for(int i = 0;i< result.size();i++)
        {
            Person person = (Person) result.get(i);
            System.out.println(person.getFirstName());
        }
        assertEquals(expResult, result);
        
    }

//    @Test
//    public void testReadByID() {
//        System.out.println("ReadByID");
//        String id = "";
//        PersonDAO instance = new PersonDAO();
//        Person expResult = null;
//        Person result = instance.ReadByID(id);
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void testCreate() {
//        System.out.println("Create");
//        Person person = null;
//        PersonDAO instance = new PersonDAO();
//        boolean expResult = false;
//        boolean result = instance.Create(person);
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void testUpdate() {
//        System.out.println("Update");
//        Person person = null;
//        PersonDAO instance = new PersonDAO();
//        boolean expResult = false;
//        boolean result = instance.Update(person);
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void testDelete() {
//        System.out.println("Delete");
//        String Id = "";
//        PersonDAO instance = new PersonDAO();
//        boolean expResult = false;
//        boolean result = instance.Delete(Id);
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void testGetLastError() {
//        System.out.println("getLastError");
//        PersonDAO instance = new PersonDAO();
//        String expResult = "";
//        String result = instance.getLastError();
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void testSetLastError() {
//        System.out.println("setLastError");
//        String lastError = "";
//        PersonDAO instance = new PersonDAO();
//        instance.setLastError(lastError);
//
//    }

}