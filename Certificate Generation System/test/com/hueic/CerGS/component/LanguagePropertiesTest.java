/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component;

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
public class LanguagePropertiesTest {

    public LanguagePropertiesTest() {
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
    public void testGetValueLanguage() {
        System.out.println("getValueLanguage");
        String value = "Ngon_ngu";
        LanguageProperties instance = new LanguageProperties();
        String expResult = "";
        String result = instance.getValueLanguage(value);
        System.out.println(result);
        assertEquals(expResult, result);
        
    }

}