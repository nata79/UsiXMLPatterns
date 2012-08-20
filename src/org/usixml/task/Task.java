package org.usixml.task;

import java.util.List;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public class Task extends TaskElement {

    public Task() {
        super();
    }

    public Task(int id, String label, List<? extends UsiXMLElement> elements) {
        super(id, label, elements);
    }

    public Task(Task e) {
        super(e);
    }

    @Override
    public Task clone() {
        return new Task(this);
    }
    
}
