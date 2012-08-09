package org.usixml.aui;

import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.usixml.UsiXMLElement;
import org.usixml.UsiXMLModel;

/**
 *
 * @author André Barbosa
 */
public class AbstractUIModelTest {
    
    public AbstractUIModelTest() {
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
     * Test of clone method, of class AbstractUIModel.
     */
    @Test
    public void testClone() {
        AbstractUIModel aui = this.buildInvoiceModel();
        
        assertTrue(true);
    }
    
    private AbstractUIModel buildInvoiceModel(){
        AbstractUIModel aui = new AbstractUIModel();
        
        AbstractDataIU elem7 = new AbstractDataIU(7, "EstablishmentName", new HashSet<UsiXMLElement>());
        AbstractDataIU elem8 = new AbstractDataIU(8, "ClientName", new HashSet<UsiXMLElement>());
        
        HashSet<UsiXMLElement> elem2_elems = new HashSet<UsiXMLElement>();
        elem2_elems.add(elem7);
        elem2_elems.add(elem8);
        AbstractCompoundIU elem2 = new AbstractCompoundIU(2, "InvoiceHeader", elem2_elems);
        
        AbstractSelectionIU elem5 = new AbstractSelectionIU(5, "New InvoiceLine", new HashSet<UsiXMLElement>());
        
        AbstractDataIU elem9 = new AbstractDataIU(9, "Discount", new HashSet<UsiXMLElement>());
        AbstractDataIU elem10 = new AbstractDataIU(10, "Total", new HashSet<UsiXMLElement>());
        
        HashSet<UsiXMLElement> elem6_elems = new HashSet<UsiXMLElement>();
        elem6_elems.add(elem9);
        elem6_elems.add(elem10);
        AbstractCompoundIU elem6 = new AbstractCompoundIU(6, "InvoiceFooter", elem6_elems);
        
        HashSet<UsiXMLElement> elem1_elems = new HashSet<UsiXMLElement>();
        elem1_elems.add(elem2);
        elem1_elems.add(elem5);
        elem1_elems.add(elem6);
        AbstractCompoundIU elem1 = new AbstractCompoundIU(1, "New Invoice", elem1_elems);
        
        AbstractDataIU elem11 = new AbstractDataIU(11, "ProductDescription", new HashSet<UsiXMLElement>());
        AbstractDataIU elem12 = new AbstractDataIU(12, "Quantity", new HashSet<UsiXMLElement>());
        AbstractDataIU elem13 = new AbstractDataIU(13, "Price", new HashSet<UsiXMLElement>());
        
        HashSet<UsiXMLElement> elem4_elems = new HashSet<UsiXMLElement>();
        elem4_elems.add(elem11);
        elem4_elems.add(elem12);
        elem4_elems.add(elem13);
        AbstractCompoundIU elem4 = new AbstractCompoundIU(4, "New InvoiceLine Form", elem4_elems);
        
        aui.addElement(elem1);
        aui.addElement(elem4);
        
        return aui;
    }
}
