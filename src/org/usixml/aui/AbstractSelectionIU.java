package org.usixml.aui;

import java.util.Set;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public class AbstractSelectionIU extends UsiXMLElement {

    public AbstractSelectionIU() {
        super();
    }

    public AbstractSelectionIU(int id, String label, Set<? extends UsiXMLElement> elements) {
        super(id, label, elements);
    }

    public AbstractSelectionIU(AbstractSelectionIU e) {
        super(e);
    }
    
    @Override
    public UsiXMLElement clone() {
        return new AbstractSelectionIU(this);
    }

}
