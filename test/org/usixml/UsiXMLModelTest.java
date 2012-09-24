/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usixml;

import org.dom4j.Element;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.usixml.aui.AbstractUIModel;

/**
 *
 * @author albmail88
 */
public class UsiXMLModelTest {
    
    public UsiXMLModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of getMaxId method, of class UsiXMLModel.
     */
    @Test
    public void testGetMaxId() {
        UsiXMLModel instance = new AbstractUIModel();
        instance.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/invoice/invoice.aui");
        int expResult = 15;
        int result = instance.getMaxId();
        assertEquals(expResult, result);        
    }
}
