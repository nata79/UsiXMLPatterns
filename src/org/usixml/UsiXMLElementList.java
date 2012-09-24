package org.usixml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author André Barbosa
 */
public abstract class UsiXMLElementList {
    private ArrayList<UsiXMLElement> elements;

    public UsiXMLElementList() {
        this.elements = new ArrayList<>();
    }

    public UsiXMLElementList(List<? extends UsiXMLElement> elements) {
        this.setElements(elements);
    }
    
    public UsiXMLElementList(UsiXMLElementList u) {
        this.setElements(u.getElements());
    }

    public List<UsiXMLElement> getElements() {
        List<UsiXMLElement> tmp = new ArrayList<>();
        for(UsiXMLElement element : this.elements){
            tmp.add(element.clone());
        }
        return tmp;
    }

    public final void setElements(List<? extends UsiXMLElement> elements) {
        this.elements = new ArrayList<>();
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
    public abstract UsiXMLElementList clone();
    
    @Override
    public boolean equals(Object o) {
        
        if(o == null || o.getClass() != this.getClass()) {
            return false;
        }
        
        if(o == this) {
            return true;
        }
        
        UsiXMLElementList uie = (UsiXMLElementList)o;
        
        List<UsiXMLElement> uie_elements = uie.getElements();
        List<UsiXMLElement> my_elements = this.getElements();
        
        if(uie_elements.size() != my_elements.size()){
            return false;
        }
        
        Iterator<UsiXMLElement> uie_elements_it = uie_elements.iterator();
        Iterator<UsiXMLElement> my_elements_it = my_elements.iterator();
        
        while(my_elements_it.hasNext()){
            if(!my_elements_it.next().equals(uie_elements_it.next())){
                return false;
            }
        }
        
        return true;
    }
}
