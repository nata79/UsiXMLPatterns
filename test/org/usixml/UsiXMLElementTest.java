/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usixml;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.usixml.aui.AbstractUIModel;
import org.usixml.aui.AbstractUIModelTest;

/**
 *
 * @author albmail88
 */
public class UsiXMLElementTest {
    
    public UsiXMLElementTest() {
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
     * Test of equals method, of class UsiXMLElement.
     */
    @Test
    public void testEquals() {
        AbstractUIModel aui1 = AbstractUIModelTest.buildInvoiceModel();
        AbstractUIModel aui2 = AbstractUIModelTest.buildInvoiceModel();
        
        assertTrue(aui1.equals(aui2));
    }    

}
