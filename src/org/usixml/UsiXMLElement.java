package org.usixml;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author André Barbosa
 */
public abstract class UsiXMLElement extends UsiXMLElementList {
    private int id;
    private String label;

    public UsiXMLElement() {
        super();
    }

    public UsiXMLElement(int id, String label, List<? extends UsiXMLElement> elements) {
        super(elements);
        this.id = id;
        this.label = label;
    }    
    
    public UsiXMLElement(UsiXMLElement e) {
        super(e.getElements());
        this.id = e.getId();
        this.label = e.getLabel();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }    
    
    @Override
    public boolean equals(Object o) {
        
        if(o == null || o.getClass() != this.getClass()) {
            return false;
        }
        
        if(o == this) {
            return true;
        }
        
        UsiXMLElement uie = (UsiXMLElement)o;
        
        if(uie.getId() != getId()){
            return false;
        }
        
        return super.equals(o);
    }

    @Override
    public abstract UsiXMLElement clone();
    
}
