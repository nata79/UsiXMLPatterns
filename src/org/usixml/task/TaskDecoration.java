package org.usixml.task;

import java.util.List;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public class TaskDecoration extends TaskElement {

    private Task target;
    private NatureSetting nature;

    public TaskDecoration() {
        super();
    }

    public TaskDecoration(Task target, NatureSetting nature, int id, String label, List<? extends UsiXMLElement> elements) {
        super(id, label, elements);
        this.target = target;
        this.nature = nature;
    }

    public TaskDecoration(TaskDecoration e) {
        super(e);
        this.nature = e.getNature();
        this.target = e.getTarget();
    }

    public NatureSetting getNature() {
        return nature;
    }

    public void setNature(NatureSetting nature) {
        this.nature = nature;
    }

    public Task getTarget() {
        return target.clone();
    }

    public void setTarget(Task target) {
        this.target = target.clone();
    }

    @Override
    public boolean equals(Object o) {
        
        if(o == null || o.getClass() != this.getClass()) {
            return false;
        }
        
        if(o == this) {
            return true;
        }
        
        TaskDecoration d = (TaskDecoration)o;
        
        return this.target.equals(d.getTarget()) && 
                this.nature == d.getNature() &&
                super.equals(o);
    }
    
    @Override
    public TaskDecoration clone() {
        return new TaskDecoration(this);
    }
    
}
