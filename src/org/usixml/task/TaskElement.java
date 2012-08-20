package org.usixml.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    protected void getTasks(Map<Integer, Task> tmp){        
        
        for(UsiXMLElement element : this.getElements()){
            if(element instanceof Task){
                Task t = (Task)element;
                tmp.put(t.getId(), t);
            }
            if(element instanceof TaskElement){
                TaskElement t = (TaskElement)element;
                t.getTasks(tmp);
            }
        }
    }

}
