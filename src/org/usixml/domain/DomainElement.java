package org.usixml.domain;

import java.util.List;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public abstract class DomainElement extends UsiXMLElement {

    public DomainElement() {
        super();
    }

    public DomainElement(int id, String label, List<? extends UsiXMLElement> elements) {
        super(id, label, elements);
    }

    public DomainElement(DomainElement e) {
        super(e);
    }
    
    public String getName(){
        return super.getLabel();
    }

    public void setName(String name){
        super.setLabel(name);
    }
    
}
