package org.usixml.aui;

import java.util.List;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public class AbstractCompoundIU extends UsiXMLElement {

    public AbstractCompoundIU() {
        super();
    }

    public AbstractCompoundIU(int id, String label, List<? extends UsiXMLElement> elements) {
        super(id, label, elements);
    }

    public AbstractCompoundIU(AbstractCompoundIU e) {
        super(e);
    }
    
    @Override
    public UsiXMLElement clone() {
        return new AbstractCompoundIU(this);
    }

}
