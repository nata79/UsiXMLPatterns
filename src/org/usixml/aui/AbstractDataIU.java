package org.usixml.aui;

import java.util.List;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public class AbstractDataIU extends AbstractUIElement {

    public AbstractDataIU() {
        super();
    }

    public AbstractDataIU(int id, String label, List<? extends UsiXMLElement> elements) {
        super(id, label, elements);
    }

    public AbstractDataIU(AbstractDataIU e) {
        super(e);
    }
    
    @Override
    public AbstractDataIU clone() {
        return new AbstractDataIU(this);
    }

}
