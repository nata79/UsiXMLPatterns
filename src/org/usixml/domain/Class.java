package org.usixml.domain;

import java.util.List;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public class Class extends DomainElement {

    public Class() {
        super();
    }

    public Class(int id, String label, List<? extends UsiXMLElement> elements) {
        super(id, label, elements);
    }

    public Class(Class e) {
        super(e);
    }

    @Override
    public Class clone() {
        return new Class(this);
    }    
    
}
