package org.usixml.task;

import java.util.List;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public abstract class TaskElement extends UsiXMLElement {

    public TaskElement() {
        super();
    }

    public TaskElement(int id, String label, List<? extends UsiXMLElement> elements) {
        super(id, label, elements);
    }
    
    public TaskElement(TaskElement e) {
        super(e);
    }
    
    public String getName(){
        return super.getLabel();
    }

    public void setName(String name){
        super.setLabel(name);
    }

}
