package org.usixml.aui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
