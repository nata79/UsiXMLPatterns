package org.usixml.task;

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
 * @author André Barbosa
 */
public class TaskModelTest {
    
    public TaskModelTest() {
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
    public void build() {
        TaskModel tm = buildCreateInvoiceModel();
        assertSame(tm.getElements().size(), 1);
        assertSame(tm.getElements().get(0).getElements().size(), 7);
        assertSame(tm.getElements().get(0).getElements().get(0).getElements().size(), 5);
        assertSame(tm.getElements().get(0).getElements().get(1).getElements().size(), 3);
    }
    
    @Test
    public void testGetTasks() {
        TaskModel tm = buildCreateInvoiceModel();
        
        // CreateInvoiceLine
        
        Task t10 = new Task(10, "ShowInvoiceLineForm", new ArrayList<UsiXMLElement>());
        Task t11 = new Task(11, "FillProductDescription", new ArrayList<UsiXMLElement>());
        Task t12 = new Task(12, "FillQuantity", new ArrayList<UsiXMLElement>());
        Task t13 = new Task(13, "FillPrice", new ArrayList<UsiXMLElement>());
        Task t14 = new Task(14, "SubmitInvoiceLine", new ArrayList<UsiXMLElement>());
        
        TaskDecoration td4 = new TaskDecoration(t10, NatureSetting.SYSTEM, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td5 = new TaskDecoration(t11, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        
        TemporalRelationship tr3 = new TemporalRelationship(td4, td5, TemporalRelationshipType.ENABLING, 0, null, new ArrayList<TaskElement>());     
        
        TaskDecoration td6 = new TaskDecoration(t11, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td7 = new TaskDecoration(t12, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        
        TemporalRelationship tr4 = new TemporalRelationship(td6, td7, TemporalRelationshipType.ORDERINDEPENDENCE, 0, null, new ArrayList<TaskElement>());
        
        TaskDecoration td8 = new TaskDecoration(t12, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td9 = new TaskDecoration(t13, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        
        TemporalRelationship tr5 = new TemporalRelationship(td8, td9, TemporalRelationshipType.ORDERINDEPENDENCE, 0, null, new ArrayList<TaskElement>());
        
        TaskDecoration td10 = new TaskDecoration(t13, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td11 = new TaskDecoration(t14, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        
        TemporalRelationship tr6 = new TemporalRelationship(td10, td11, TemporalRelationshipType.ORDERINDEPENDENCE, 0, null, new ArrayList<TaskElement>());
        
        ArrayList<TaskElement> t9_elems = new ArrayList<TaskElement>();
        t9_elems.add(tr3);
        t9_elems.add(tr4);
        t9_elems.add(tr5);
        t9_elems.add(tr6);
        
        Task t9 = new Task(9, "CreateInvoiceLine", t9_elems);
        
        tm.getTasks().get(9).equals(t9);
    }
    
    @Test
    public void testFromFile() {
        TaskModel tm = new TaskModel();
        tm.fromFile("/Users/albmail88/Documents/partilhaVB/invoice.task");
        TaskModel mem = buildCreateInvoiceModel();
        assertTrue(tm.equals(mem));
    }
    
    public static TaskModel buildCreateInvoiceModel(){
        
        // CreateInvoiceHeader
        
        Task t5 = new Task(5, "ShowInvoiceHeaderForm", new ArrayList<UsiXMLElement>());
        Task t6 = new Task(6, "FillEstablishmentName", new ArrayList<UsiXMLElement>());
        Task t7 = new Task(7, "FillClientName", new ArrayList<UsiXMLElement>());
        
        TaskDecoration td1 = new TaskDecoration(t5, NatureSetting.SYSTEM, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td2 = new TaskDecoration(t6, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td3 = new TaskDecoration(t7, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        
        TemporalRelationship tr1 = new TemporalRelationship(td1, td2, TemporalRelationshipType.ENABLING, 0, null, new ArrayList<TaskElement>());
        TemporalRelationship tr2 = new TemporalRelationship(td2, td3, TemporalRelationshipType.ORDERINDEPENDENCE, 0, null, new ArrayList<TaskElement>());
        
        ArrayList<TaskElement> t2_elems = new ArrayList<TaskElement>();
        t2_elems.add(t5);
        t2_elems.add(t6);
        t2_elems.add(t7);
        t2_elems.add(tr1);
        t2_elems.add(tr2);        
        Task t2 = new Task(2, "CreateInvoiceHeader", t2_elems);
        
        // ClickNewInvoiceLine
        
        Task t8 = new Task(8, "ClickNewInvoiceLine", new ArrayList<UsiXMLElement>());
        
        // CreateInvoiceLine
        
        Task t10 = new Task(10, "ShowInvoiceLineForm", new ArrayList<UsiXMLElement>());
        Task t11 = new Task(11, "FillProductDescription", new ArrayList<UsiXMLElement>());
        Task t12 = new Task(12, "FillQuantity", new ArrayList<UsiXMLElement>());
        Task t13 = new Task(13, "FillPrice", new ArrayList<UsiXMLElement>());
        Task t14 = new Task(14, "SubmitInvoiceLine", new ArrayList<UsiXMLElement>());
        
        TaskDecoration td4 = new TaskDecoration(t10, NatureSetting.SYSTEM, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td5 = new TaskDecoration(t11, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        
        TemporalRelationship tr3 = new TemporalRelationship(td4, td5, TemporalRelationshipType.ENABLING, 0, null, new ArrayList<TaskElement>());     
        
        TaskDecoration td6 = new TaskDecoration(t11, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td7 = new TaskDecoration(t12, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        
        TemporalRelationship tr4 = new TemporalRelationship(td6, td7, TemporalRelationshipType.ORDERINDEPENDENCE, 0, null, new ArrayList<TaskElement>());
        
        TaskDecoration td8 = new TaskDecoration(t12, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td9 = new TaskDecoration(t13, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        
        TemporalRelationship tr5 = new TemporalRelationship(td8, td9, TemporalRelationshipType.ORDERINDEPENDENCE, 0, null, new ArrayList<TaskElement>());
        
        TaskDecoration td10 = new TaskDecoration(t13, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td11 = new TaskDecoration(t14, NatureSetting.INTERACTIVE, 0, null, new ArrayList<UsiXMLElement>());
        
        TemporalRelationship tr6 = new TemporalRelationship(td10, td11, TemporalRelationshipType.ORDERINDEPENDENCE, 0, null, new ArrayList<TaskElement>());
        
        ArrayList<TaskElement> t9_elems = new ArrayList<TaskElement>();
        t9_elems.add(t10);
        t9_elems.add(t11);
        t9_elems.add(t12);
        t9_elems.add(t13);
        t9_elems.add(t14);
        t9_elems.add(tr3);
        t9_elems.add(tr4);
        t9_elems.add(tr5);
        t9_elems.add(tr6);
        
        Task t9 = new Task(9, "CreateInvoiceLine", t9_elems);
        
        // CreateInvoiceLines
        
        TaskDecoration td12 = new TaskDecoration(t8, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td13 = new TaskDecoration(t9, NatureSetting.INTERACTIVE, 0, null, new ArrayList<UsiXMLElement>());
        
        TemporalRelationship tr7 = new TemporalRelationship(td12, td13, TemporalRelationshipType.ENABLING, 0, null, new ArrayList<TaskElement>());
        
        ArrayList<TaskElement> t3_elems = new ArrayList<TaskElement>();
        t3_elems.add(t8);
        t3_elems.add(t9);
        t3_elems.add(tr7);
        
        Task t3 = new Task(3, "CreateInvoiceLines", t3_elems);
        
        // CreateInvoiceFooter
        
        Task t15 = new Task(15, "ShowInvoiceFooterForm", new ArrayList<UsiXMLElement>());
        Task t16 = new Task(16, "FillDiscount", new ArrayList<UsiXMLElement>());
        
        TaskDecoration td14 = new TaskDecoration(t15, NatureSetting.SYSTEM, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td15 = new TaskDecoration(t16, NatureSetting.USER, 0, null, new ArrayList<UsiXMLElement>());
        
        TemporalRelationship tr8 = new TemporalRelationship(td14, td15, TemporalRelationshipType.ENABLING, 0, null, new ArrayList<TaskElement>());
        
        ArrayList<TaskElement> t4_elems = new ArrayList<TaskElement>();
        t4_elems.add(t15);
        t4_elems.add(t16);
        t4_elems.add(tr8);
        
        Task t4 = new Task(4, "CreateInvoiceFooter", t4_elems);
        
        // SubmitInvoice
        
        Task t17 = new Task(17, "SubmitInvoice", new ArrayList<UsiXMLElement>());
        
        // CreateInvoice
        
        TaskDecoration td16 = new TaskDecoration(t2, NatureSetting.INTERACTIVE, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td17 = new TaskDecoration(t3, NatureSetting.INTERACTIVE, 0, null, new ArrayList<UsiXMLElement>());
        
        TemporalRelationship tr9 = new TemporalRelationship(td16, td17, TemporalRelationshipType.ORDERINDEPENDENCE, 0, null, new ArrayList<TaskElement>());
        
        TaskDecoration td18 = new TaskDecoration(t3, NatureSetting.INTERACTIVE, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td19 = new TaskDecoration(t4, NatureSetting.INTERACTIVE, 0, null, new ArrayList<UsiXMLElement>());
        
        TemporalRelationship tr10 = new TemporalRelationship(td18, td19, TemporalRelationshipType.ORDERINDEPENDENCE, 0, null, new ArrayList<TaskElement>());
        
        TaskDecoration td20 = new TaskDecoration(t4, NatureSetting.INTERACTIVE, 0, null, new ArrayList<UsiXMLElement>());
        TaskDecoration td21 = new TaskDecoration(t17, NatureSetting.INTERACTIVE, 0, null, new ArrayList<UsiXMLElement>());
        
        TemporalRelationship tr11 = new TemporalRelationship(td20, td21, TemporalRelationshipType.ENABLING, 0, null, new ArrayList<TaskElement>());
        
        ArrayList<TaskElement> t1_elems = new ArrayList<TaskElement>();
        t1_elems.add(t2);
        t1_elems.add(t3);
        t1_elems.add(t4);
        t1_elems.add(t17);
        t1_elems.add(tr9);
        t1_elems.add(tr10);
        t1_elems.add(tr11);
        Task t1 = new Task(1, "CreateInvoice", t1_elems);
        
        ArrayList<TaskElement> tm_elems = new ArrayList<TaskElement>();
        tm_elems.add(t1);
        
        TaskModel tm = new TaskModel(tm_elems);
        
        return tm;
    }
}
