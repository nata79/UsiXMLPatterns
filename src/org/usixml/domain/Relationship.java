package org.usixml.domain;

import java.util.List;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public abstract class Relationship extends DomainElement {
    
    private Class source;
    private Class target;

    public Relationship() {
        super();
    }

    public Relationship(Class source, Class target, int id, String label, List<? extends UsiXMLElement> elements) {
        super(id, label, elements);
        this.source = source;
        this.target = target;
    }

    public Relationship(Relationship e) {
        super(e);
        this.source = e.getSource();
        this.target = e.getTarget();
    }
    
    public Class getSource() {
        return source.clone();
    }

    public void setSource(Class source) {
        this.source = source.clone();
    }

    public Class getTarget() {
        return target.clone();
    }

    public void setTarget(Class target) {
        this.target = target.clone();
    }
    
}
