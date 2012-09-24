package org.usixml.aui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public abstract class AbstractUIElement extends UsiXMLElement {

    public AbstractUIElement() {
        super();
    }

    public AbstractUIElement(int id, String label, List<? extends UsiXMLElement> elements) {
        super(id, label, elements);
    }

    public AbstractUIElement(AbstractUIElement e) {
        super(e);
    }
    
    protected void toFileHelper(Element parent){
        Element xmlElement = new DefaultElement("interactionUnits");
        xmlElement.addAttribute("xsi:type", "org.usixml.aui:" + getClass().getSimpleName());
        xmlElement.addAttribute("id", new Integer(getId()).toString());
        xmlElement.addAttribute("label", getLabel());

        for(UsiXMLElement child : getElements()){
            if(child instanceof AbstractUIElement){
                AbstractUIElement childAuiElement = (AbstractUIElement)child;
                childAuiElement.toFileHelper(xmlElement);
            }
        }

        parent.add(xmlElement);
    }
    
    protected void getCompounds(Map<Integer, AbstractCompoundIU> tmp){
        for(UsiXMLElement e : super.getElements()){
            if(e instanceof AbstractCompoundIU){
                tmp.put(e.getId(), (AbstractCompoundIU)e);
            }
            
            if(e instanceof AbstractUIElement){
                ((AbstractUIElement)e).getCompounds(tmp);
            }
        }
    }

    @Override
    public abstract AbstractUIElement clone();
}
