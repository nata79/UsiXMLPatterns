package org.usixml.aui;

import java.util.ArrayList;
import java.util.List;
import org.dom4j.Element;
import org.usixml.UsiXMLElement;
import org.usixml.UsiXMLElementList;
import org.usixml.UsiXMLModel;

/**
 *
 * @author André Barbosa
 */
public class AbstractUIModel extends UsiXMLModel {

    public AbstractUIModel() {
        super();
    }

    public AbstractUIModel(List<? extends UsiXMLElement> elements) {
        super(elements);
    }

    public AbstractUIModel(AbstractUIModel u) {
        super(u);
    }    
    
    @Override
    protected void parseChildren(UsiXMLElementList unit, Element element) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        for(Element child : element.elements()){
            UsiXMLElement uelem = this.objectFromElement(child);
            unit.addElement(uelem);
            this.parseChildren(uelem, child);
        }
    }
    
    private UsiXMLElement objectFromElement(Element element) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        // Fetch name and attributes
        String name = element.getName();
        String type = element.attributeValue("type");
        String label = element.attributeValue("label");
        int id = 0;
        try{
            id = Integer.parseInt(element.attributeValue("id"));
        } catch(java.lang.NumberFormatException ex){
            
        }
        
        // If is a compoundIUs build AbstractCompoundIU
        if(name.equals("compoundIUs")){
            return new AbstractCompoundIU(id, label, new ArrayList<UsiXMLElement>());
        }
        
        // Instantiate through type
        UsiXMLElement uelem = (UsiXMLElement) Class.forName(type.replace(":", ".")).newInstance();
        uelem.setId(id);
        uelem.setLabel(label);
        
        return uelem;
    }

    @Override
    public UsiXMLElementList clone() {
        return new AbstractUIModel(this);
    }
    
}
