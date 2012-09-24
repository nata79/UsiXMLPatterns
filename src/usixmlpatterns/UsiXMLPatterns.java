package usixmlpatterns;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.usixml.UsiXMLElement;
import org.usixml.aui.AbstractUIModel;
import org.usixml.domain.Association;
import org.usixml.domain.Attribute;
import org.usixml.domain.DomainElement;
import org.usixml.domain.DomainModel;
import org.usixml.domain.Generalization;
import org.usixml.domain.VisibilitySetting;
import org.usixml.task.TaskModel;
import usixmlpatterns.Exceptions.ActionNotSupportedException;
import usixmlpatterns.Exceptions.IsNotAnInstantiationOfThePatternException;

/**
 *
 * @author André Barbosa
 */
public class UsiXMLPatterns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ActionNotSupportedException {
        
        AbstractUIModel aui = new AbstractUIModel();
        aui.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/default.aui");        
        
        TaskModel task = new TaskModel();
        task.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/create_document.task");
        
        DomainModel domain = new DomainModel();
        domain.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/document.domain");
        
        Pattern documentPattern = new Pattern(domain, task, aui);
        
        TaskModel taskModel = new TaskModel();
        taskModel.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/invoice/invoice.task");
        
        AbstractUIModel expected = new AbstractUIModel();
        expected.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/invoice/invoice.aui");        
        
        boolean nice = false;
        try {
            AbstractUIModel generated = documentPattern.buildAbstractUIModel(taskModel);
            nice = generated.equals(expected);
          } catch (IsNotAnInstantiationOfThePatternException | InstantiationException | IllegalAccessException | ActionNotSupportedException ex) {
            Logger.getLogger(UsiXMLPatterns.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            expected.toFile("/Users/albmail88/Desktop/test.xml");
        } catch (IOException ex) {
            Logger.getLogger(UsiXMLPatterns.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
