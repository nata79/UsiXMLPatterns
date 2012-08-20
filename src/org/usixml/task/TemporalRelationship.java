package org.usixml.task;

import java.util.List;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public class TemporalRelationship extends TaskElement {
    
    private TaskDecoration pred;
    private TaskDecoration succ;
    private TemporalRelationshipType type;

    public TemporalRelationship() {
        super();
    }

    public TemporalRelationship(TaskDecoration pred, TaskDecoration succ, TemporalRelationshipType type, int id, String label, List<? extends TaskElement> elements) {
        super(id, label, elements);
        this.pred = pred;
        this.succ = succ;
        this.type = type;
    }

    public TemporalRelationship(TemporalRelationship e) {
        super(e);
        this.pred = e.getPred();
        this.succ = e.getSucc();
        this.type = e.getType();
    }
    
    public TaskDecoration getPred() {
        return pred.clone();
    }

    public void setPred(TaskDecoration pred) {
        this.pred = pred.clone();
    }

    public TaskDecoration getSucc() {
        return succ.clone();
    }
    
    public void setSucc(TaskDecoration succ) {
        this.succ = succ.clone();
    }
    
    public TemporalRelationshipType getType() {
        return type;
    }

    public void setType(TemporalRelationshipType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        
        if(o == null || o.getClass() != this.getClass()) {
            return false;
        }
        
        if(o == this) {
            return true;
        }
        
        TemporalRelationship t = (TemporalRelationship)o;
        
        return this.succ.equals(t.getSucc()) &&
                this.pred.equals(t.getPred()) &&
                this.type.equals(t.getType()) &&
                super.equals(o);
    }    
    
    @Override
    public TemporalRelationship clone() {
        return new TemporalRelationship(this);
    }
    
}
