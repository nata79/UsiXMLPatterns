package org.usixml.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import org.usixml.UsiXMLElement;
import org.usixml.UsiXMLElementList;
import org.usixml.UsiXMLModel;

/**
 *
 * @author André Barbosa
 */
public class TaskModel extends UsiXMLModel {

    public TaskModel() {
        super();
    }

    public TaskModel(List<? extends TaskElement> elements) {
        super(elements);
    }

    public TaskModel(TaskModel u) {
        super(u);
    }

    public Map<Integer, Task> getTasks(){
        Map<Integer, Task> tmp = new HashMap<Integer, Task>();
        
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
        
        return tmp;
    }
    
    @Override
    protected void parseChildren(UsiXMLElementList unit, Element element) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TaskModel clone() {
        return new TaskModel(this);
    }
}
