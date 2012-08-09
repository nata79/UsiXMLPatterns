package org.usixml;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author André Barbosa
 */
public abstract class UsiXMLModel {
    private HashSet<UsiXMLElement> elements;

    public UsiXMLModel() {
        this.elements = new HashSet<UsiXMLElement>();
    }

    public UsiXMLModel(Set<? extends UsiXMLElement> elements) {
        this.setElements(elements);
    }
    
    public UsiXMLModel(UsiXMLModel u) {
        this.setElements(u.getElements());
    }

    public Set<UsiXMLElement> getElements() {
        Set<UsiXMLElement> tmp = new HashSet<UsiXMLElement>();
        for(UsiXMLElement element : this.elements){
            tmp.add(element.clone());
        }
        return tmp;
    }

    public void setElements(Set<? extends UsiXMLElement> elements) {
        this.elements = new HashSet<UsiXMLElement>();
        for(UsiXMLElement element : elements){
            this.elements.add(element.clone());
        }
    }

    public void addElement(UsiXMLElement element){
        this.elements.add(element);
    }
    
    public void removeElement(UsiXMLElement element){
        this.elements.remove(element);
    }
    
    @Override
    public abstract UsiXMLModel clone();
    
}
