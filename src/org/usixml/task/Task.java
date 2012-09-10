package org.usixml.task;

import java.util.List;
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
    
    @Override
    public Task clone() {
        return new Task(this);
    }

}
