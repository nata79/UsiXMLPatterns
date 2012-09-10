package org.usixml.task;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
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
        ArrayList<Element> stack = new ArrayList<Element>();
        for(Element child : element.elements()){            
            if(child.getName().equals("expressions")){
                stack.add(child);
            }
            else {
                UsiXMLElement uelem = this.objectFromElement(child);
                unit.addElement(uelem);
                parseChildren(uelem, child);
            }
        }
        for(Element child : stack){            
            UsiXMLElement uelem = this.objectFromElement(child);
            unit.addElement(uelem);
        }
    }
    
    private UsiXMLElement objectFromElement(Element element) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        // Fetch name and attributes
        String name = element.getName();
        String type = element.attributeValue("type");
        String label = element.attributeValue("name");
        int id;
        try{
            id = Integer.parseInt(element.attributeValue("id"));   
        } catch(java.lang.NumberFormatException ex){
            id = 0;
        }
        
        if(name.equals("tasks") || name.equals("part")){            
            String patternIdRaw = element.attributeValue("pattern_id");
            Integer patternId = NumberUtils.isNumber(patternIdRaw) ? Integer.valueOf(patternIdRaw) : null;
            return new Task(id, label, new ArrayList<UsiXMLElement>(), patternId);
        }
        
        // Instantiate through type
        UsiXMLElement uelem = (UsiXMLElement) java.lang.Class.forName(type.replace(":", ".")).newInstance();
        if(uelem.getClass().getName().equals("org.usixml.task.TemporalRelationship")){
            TemporalRelationship tr = (TemporalRelationship)uelem;

            // TODO: Get TemporalRelationshipType from specification.
            tr.setType(TemporalRelationshipType.ENABLING);
            
            int target_id;
            
            try{
                target_id = Integer.parseInt(element.elements().get(0).attributeValue("target"));   
            } catch(java.lang.NumberFormatException ex){
                target_id = 0;
            }
            
            TaskDecoration td = new TaskDecoration(this.getTasks().get(target_id), NatureSetting.valueOf(element.elements().get(0).attributeValue("nature")), 0, null, new ArrayList<UsiXMLElement>());
            
            try{
                target_id = Integer.parseInt(element.elements().get(1).attributeValue("target"));   
            } catch(java.lang.NumberFormatException ex){
                target_id = 0;
            }
            
            TaskDecoration td1 = new TaskDecoration(this.getTasks().get(target_id), NatureSetting.valueOf(element.elements().get(1).attributeValue("nature")), 0, null, new ArrayList<UsiXMLElement>());
            
            tr.setPred(td1);
            tr.setSucc(td);
        }
        else{
            uelem.setId(id);
            uelem.setLabel(label);   
        }
        
        return uelem;
    }

    @Override
    public TaskModel clone() {
        return new TaskModel(this);
    }
}
