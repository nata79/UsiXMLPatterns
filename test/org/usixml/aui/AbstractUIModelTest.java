package org.usixml.aui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.usixml.UsiXMLElement;
import org.usixml.UsiXMLElementList;

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
     * Test building object.
     */
    @Test
    public void testBuild() {
        AbstractUIModel aui = AbstractUIModelTest.buildInvoiceModel();
        assertSame(aui.getElements().size(), 2);
        assertSame(aui.getElements().get(0).getElements().size(), 3);
        assertSame(aui.getElements().get(0).getElements().get(0).getElements().size(), 2);
        assertSame(aui.getElements().get(1).getElements().size(), 3);        
    }
    
    @Test
    public void testFromFile() {
        AbstractUIModel aui = new AbstractUIModel();
        aui.fromFile("/Users/albmail88/Documents/partilhaVB/invoice.aui");
        assertTrue(aui.equals(buildInvoiceModel()));
    }
    
    @Test
    public void testToFile() throws IOException {
        AbstractUIModel aui = new AbstractUIModel();
        aui.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/invoice/invoice.aui");
        
        aui.toFile("./temp.aui");
        
        AbstractUIModel other = new AbstractUIModel();
        other.fromFile("./temp.aui");
        
        assertTrue(aui.equals(other));
        
        // Clean
        File f = new File("./temp.aui");
        f.delete();
    }
    
    @Test
    public void testGetCompounds(){
        
        AbstractDataIU elem7 = new AbstractDataIU(7, "EstablishmentName", new ArrayList<UsiXMLElement>());
        AbstractDataIU elem8 = new AbstractDataIU(8, "ClientName", new ArrayList<UsiXMLElement>());
        
        ArrayList<UsiXMLElement> elem2_elems = new ArrayList<UsiXMLElement>();
        elem2_elems.add(elem7);
        elem2_elems.add(elem8);
        AbstractCompoundIU elem2 = new AbstractCompoundIU(2, "InvoiceHeader", elem2_elems);
        
        AbstractUIModel aui = AbstractUIModelTest.buildInvoiceModel();
        assertTrue(aui.getCompounds().get(2).equals(elem2));
    }
    
    public static AbstractUIModel buildInvoiceModel(){
        AbstractUIModel aui = new AbstractUIModel();
        
        AbstractDataIU elem7 = new AbstractDataIU(7, "EstablishmentName", new ArrayList<UsiXMLElement>());
        AbstractDataIU elem8 = new AbstractDataIU(8, "ClientName", new ArrayList<UsiXMLElement>());
        
        ArrayList<UsiXMLElement> elem2_elems = new ArrayList<UsiXMLElement>();
        elem2_elems.add(elem7);
        elem2_elems.add(elem8);
        AbstractCompoundIU elem2 = new AbstractCompoundIU(2, "InvoiceHeader", elem2_elems);
        
        AbstractSelectionIU elem5 = new AbstractSelectionIU(5, "New InvoiceLine", new ArrayList<UsiXMLElement>());
        
        AbstractDataIU elem9 = new AbstractDataIU(9, "Discount", new ArrayList<UsiXMLElement>());
        AbstractDataIU elem10 = new AbstractDataIU(10, "Total", new ArrayList<UsiXMLElement>());
        
        ArrayList<UsiXMLElement> elem6_elems = new ArrayList<UsiXMLElement>();
        elem6_elems.add(elem9);
        elem6_elems.add(elem10);
        AbstractCompoundIU elem6 = new AbstractCompoundIU(6, "InvoiceFooter", elem6_elems);
        
        ArrayList<UsiXMLElement> elem1_elems = new ArrayList<UsiXMLElement>();
        elem1_elems.add(elem2);
        elem1_elems.add(elem5);
        elem1_elems.add(elem6);
        AbstractCompoundIU elem1 = new AbstractCompoundIU(1, "New Invoice", elem1_elems);
        
        AbstractDataIU elem11 = new AbstractDataIU(11, "ProductDescription", new ArrayList<UsiXMLElement>());
        AbstractDataIU elem12 = new AbstractDataIU(12, "Quantity", new ArrayList<UsiXMLElement>());
        AbstractDataIU elem13 = new AbstractDataIU(13, "Price", new ArrayList<UsiXMLElement>());
        
        ArrayList<UsiXMLElement> elem4_elems = new ArrayList<UsiXMLElement>();
        elem4_elems.add(elem11);
        elem4_elems.add(elem12);
        elem4_elems.add(elem13);
        AbstractCompoundIU elem4 = new AbstractCompoundIU(4, "New InvoiceLine Form", elem4_elems);
        
        aui.addElement(elem1);
        aui.addElement(elem4);
        
        return aui;
    }
}
