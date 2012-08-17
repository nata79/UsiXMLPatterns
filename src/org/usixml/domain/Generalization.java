package org.usixml.domain;

import java.util.List;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public class Generalization extends Relationship {

    public Generalization() {
        super();
    }

    public Generalization(Class source, Class target, int id, String label, List<? extends UsiXMLElement> elements) {
        super(source, target, id, label, elements);        
    }

    public Generalization(Generalization e) {
        super(e);
    }

    @Override
    public Generalization clone() {
        return new Generalization(this);
    }
    
}
