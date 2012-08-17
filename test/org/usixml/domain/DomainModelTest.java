/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usixml.domain;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.usixml.UsiXMLElement;

/**
 *
 * @author albmail88
 */
public class DomainModelTest {
    
    public DomainModelTest() {
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


    @Test
    public void testBuild() {
        DomainModel domain = buildInvoiceModel();
        assertSame(domain.getElements().size(), 22);
        assertSame(domain.getElements().get(9).getElements().size(), 2);
        assertSame(domain.getElements().get(10).getElements().size(), 2);
        assertSame(domain.getElements().get(11).getElements().size(), 2);        
    }
    
    public static DomainModel buildInvoiceModel(){
        
        Class c0 = new Class(0, "Object", new ArrayList<UsiXMLElement>());
        Class c1 = new Class(1, "String", new ArrayList<UsiXMLElement>());
        Class c2 = new Class(2, "Number", new ArrayList<UsiXMLElement>());
        Class c3 = new Class(3, "Integer", new ArrayList<UsiXMLElement>());
        Class c4 = new Class(4, "Long", new ArrayList<UsiXMLElement>());
        Class c5 = new Class(5, "Float", new ArrayList<UsiXMLElement>());
        Class c6 = new Class(6, "Double", new ArrayList<UsiXMLElement>());
        Class c7 = new Class(7, "DateTime", new ArrayList<UsiXMLElement>());
        Class c8 = new Class(8, "Invoice", new ArrayList<UsiXMLElement>());
        
        Attribute a0 = new Attribute(VisibilitySetting.Private, c1, 0, "CompanyName", new ArrayList<UsiXMLElement>());
        Attribute a1 = new Attribute(VisibilitySetting.Private, c1, 0, "ClientName", new ArrayList<UsiXMLElement>());                
        ArrayList<UsiXMLElement> c9_atts = new ArrayList<UsiXMLElement>();
        c9_atts.add(a0);
        c9_atts.add(a1);
        Class c9 = new Class(9, "InvoiceFooter", c9_atts);
        
        Attribute a2 = new Attribute(VisibilitySetting.Private, c5, 0, "Discount", new ArrayList<UsiXMLElement>());
        Attribute a3 = new Attribute(VisibilitySetting.Private, c1, 0, "Total", new ArrayList<UsiXMLElement>());                
        ArrayList<UsiXMLElement> c10_atts = new ArrayList<UsiXMLElement>();
        c10_atts.add(a2);
        c10_atts.add(a3);
        Class c10 = new Class(10, "InvoiceFooter", c10_atts);
        
        Attribute a4 = new Attribute(VisibilitySetting.Private, c1, 0, "ProductName", new ArrayList<UsiXMLElement>());
        Attribute a5 = new Attribute(VisibilitySetting.Private, c5, 0, "Price", new ArrayList<UsiXMLElement>());                
        ArrayList<UsiXMLElement> c11_atts = new ArrayList<UsiXMLElement>();
        c11_atts.add(a4);
        c11_atts.add(a5);
        Class c11 = new Class(10, "InvoiceLine", c11_atts);
        
        Generalization g0 = new Generalization(c1, c0, 0, null, new ArrayList<UsiXMLElement>());
        Generalization g1 = new Generalization(c2, c2, 0, null, new ArrayList<UsiXMLElement>());
        Generalization g2 = new Generalization(c3, c2, 0, null, new ArrayList<UsiXMLElement>());
        Generalization g3 = new Generalization(c4, c2, 0, null, new ArrayList<UsiXMLElement>());
        Generalization g4 = new Generalization(c5, c2, 0, null, new ArrayList<UsiXMLElement>());
        Generalization g5 = new Generalization(c6, c2, 0, null, new ArrayList<UsiXMLElement>());
        Generalization g6 = new Generalization(c7, c4, 0, null, new ArrayList<UsiXMLElement>());
        
        Association ass0 = new Association("source", "1", "1", "Composite", "target", "1", "1", null, c8, c10, 0, null, new ArrayList<UsiXMLElement>());
        Association ass1 = new Association("source", "1", "1", "Composite", "target", "0", "*", null, c8, c11, 0, null, new ArrayList<UsiXMLElement>());
        Association ass2 = new Association("source", "1", "1", "Composite", "target", "1", "1", null, c8, c9, 0, null, new ArrayList<UsiXMLElement>());
        
        ArrayList<DomainElement> domain_elems = new ArrayList<DomainElement>();
        domain_elems.add(c0);
        domain_elems.add(c1);
        domain_elems.add(c2);
        domain_elems.add(c3);
        domain_elems.add(c4);
        domain_elems.add(c5);
        domain_elems.add(c6);
        domain_elems.add(c7);
        domain_elems.add(c8);
        domain_elems.add(c9);
        domain_elems.add(c10);
        domain_elems.add(c11);
        domain_elems.add(g0);
        domain_elems.add(g1);
        domain_elems.add(g2);
        domain_elems.add(g3);
        domain_elems.add(g4);
        domain_elems.add(g5);
        domain_elems.add(g6);
        domain_elems.add(ass0);
        domain_elems.add(ass1);
        domain_elems.add(ass2);
        
        DomainModel domain = new DomainModel(domain_elems);        
        return domain;
    }

}
