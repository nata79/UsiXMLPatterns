package org.usixml.domain;

import java.util.List;
import org.usixml.UsiXMLElement;


/**
 *
 * @author André Barbosa
 */
public class Attribute extends DomainElement {

    private VisibilitySetting visibility;
    private Class type;
    
    public Attribute() {
        super();
    }

    public Attribute(VisibilitySetting visibility, Class type, int id, String label, List<? extends UsiXMLElement> elements) {
        super(id, label, elements);
        this.visibility = visibility;
        this.type = type;
    }    

    public Attribute(Attribute e) {
        super(e);
        this.visibility = e.getVisibility();
        this.type = e.getType();
    }    

    public VisibilitySetting getVisibility() {
        return visibility;
    }

    public void setVisibility(VisibilitySetting visibility) {
        this.visibility = visibility;
    }

    public Class getType() {
        return type.clone();
    }

    public void setType(Class type) {
        this.type = type.clone();
    }
    
    @Override
    public Attribute clone() {
        return new Attribute(this);
    }

}