/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usixmlpatterns;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.usixml.aui.AbstractCompoundIU;
import org.usixml.aui.AbstractUIModel;
import org.usixml.domain.DomainModel;
import org.usixml.task.Task;
import org.usixml.task.TaskModel;
import usixmlpatterns.Exceptions.IsNotAnInstantiationOfThePatternException;

/**
 *
 * @author albmail88
 */
public class PatternTest {
    
    public PatternTest() {
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
     * Test of matchTasksAndCompound method, of class Pattern.
     */
    @Test
    public void testMatchTasksAndCompound() {
        AbstractUIModel aui = new AbstractUIModel();
        aui.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/default.aui");        
        
        TaskModel task = new TaskModel();
        task.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/create_document.task");
        
        DomainModel domain = new DomainModel();
        domain.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/document.domain");
        
        Pattern document_pattern = new Pattern(domain, task, aui);
        
        Map<Integer, Task> tasks = task.getTasks();
        Map<Task,AbstractCompoundIU> match = document_pattern.matchTasksAndCompound();
        
        assertSame(match.get(tasks.get(1)).getId(), 1);
        assertSame(match.get(tasks.get(2)).getId(), 2);
        assertSame(match.get(tasks.get(7)).getId(), 6);
    }
    
    /**
     * Test of matchPatternTaskAndModelTask method, of class Pattern.
     */
    @Test
    public void testMatchPatternTaskAndModelTask() throws IsNotAnInstantiationOfThePatternException{
        AbstractUIModel aui = new AbstractUIModel();
        aui.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/default.aui");        
        
        TaskModel task = new TaskModel();
        task.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/create_document.task");
        
        DomainModel domain = new DomainModel();
        domain.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/document.domain");
        
        Pattern documentPattern = new Pattern(domain, task, aui);
        
        TaskModel invoiceTask = new TaskModel();
        invoiceTask.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/invoice/invoice.task");
        
        assertEquals(task.getTasks().size(), documentPattern.matchPatternTaskAndModelTask(invoiceTask).size());
    }
}
