package org.usixml;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author André Barbosa
 */
public abstract class UsiXMLModel {
    private ArrayList<UsiXMLElement> elements;

    public UsiXMLModel() {
        this.elements = new ArrayList<UsiXMLElement>();
    }

    public UsiXMLModel(List<? extends UsiXMLElement> elements) {
        this.setElements(elements);
    }
    
    public UsiXMLModel(UsiXMLModel u) {
        this.setElements(u.getElements());
    }

    public List<UsiXMLElement> getElements() {
        List<UsiXMLElement> tmp = new ArrayList<UsiXMLElement>();
        for(UsiXMLElement element : this.elements){
            tmp.add(element.clone());
        }
        return tmp;
    }

    public void setElements(List<? extends UsiXMLElement> elements) {
        this.elements = new ArrayList<UsiXMLElement>();
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
