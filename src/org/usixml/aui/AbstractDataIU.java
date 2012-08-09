package org.usixml.aui;

import java.util.Set;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public class AbstractDataIU extends UsiXMLElement {

    public AbstractDataIU() {
        super();
    }

    public AbstractDataIU(int id, String label, Set<? extends UsiXMLElement> elements) {
        super(id, label, elements);
    }

    public AbstractDataIU(AbstractDataIU e) {
        super(e);
    }
    
    @Override
    public UsiXMLElement clone() {
        return new AbstractDataIU(this);
    }

}
