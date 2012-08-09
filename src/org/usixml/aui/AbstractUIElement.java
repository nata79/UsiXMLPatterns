package org.usixml.aui;

import java.util.List;
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
    
}
