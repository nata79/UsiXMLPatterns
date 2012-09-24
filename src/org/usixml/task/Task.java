package org.usixml.task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public class Task extends TaskElement {

    private Integer patternId;
    
    public Task() {
        super();
        patternId = null;
    }

    public Task(int id, String label, List<? extends UsiXMLElement> elements, Integer patternId) {
        super(id, label, elements);
        this.patternId = patternId;
    }

    public Task(Task e) {
        super(e);
        patternId = e.getPatternId();
    }

    public Integer getPatternId() {
        return patternId;
    }

    public void setPatternId(Integer patternId) {
        this.patternId = patternId;
    }
    
    public List<TemporalRelationship> getTemporalRelationships(){
        List<TemporalRelationship> tmp = new ArrayList<>();
        
        for(UsiXMLElement e : getElements()){
            if(e instanceof TemporalRelationship){
                tmp.add((TemporalRelationship)e);
            }
        }
        
        return tmp;
    }
    
    public List<Task> getSubTasks(){
        List<Task> tmp = new ArrayList<>();
        
        for(TemporalRelationship tr : getTemporalRelationships()){
            Task pred = tr.getPred().getTarget();
            Task succ = tr.getSucc().getTarget();
            if(!tmp.contains(pred)) tmp.add(pred);
            if(!tmp.contains(succ)) tmp.add(succ);
        }
        
        return tmp;
    }
    
    @Override
    public Task clone() {
        return new Task(this);
    }

}
