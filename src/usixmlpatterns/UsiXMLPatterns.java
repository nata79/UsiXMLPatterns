package usixmlpatterns;

import java.util.Map;
import org.usixml.aui.AbstractCompoundIU;
import org.usixml.aui.AbstractUIModel;
import org.usixml.domain.DomainModel;
import org.usixml.task.Task;
import org.usixml.task.TaskModel;
import utils.Words;

/**
 *
 * @author André Barbosa
 */
public class UsiXMLPatterns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AbstractUIModel aui = new AbstractUIModel();
        aui.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/default.aui");        
        
        TaskModel task = new TaskModel();
        task.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/create_document.task");
        
        DomainModel domain = new DomainModel();
        domain.fromFile("/Users/albmail88/Documents/partilhaVB/document_pattern/document.domain");
        
        Pattern document_pattern = new Pattern(domain, task, aui);
    }    
}
