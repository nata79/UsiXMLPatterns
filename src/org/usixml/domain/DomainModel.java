package org.usixml.domain;

import java.util.List;
import org.dom4j.Element;
import org.usixml.UsiXMLElement;
import org.usixml.UsiXMLElementList;
import org.usixml.UsiXMLModel;

/**
 *
 * @author André Barbosa
 */
public class DomainModel extends UsiXMLModel {

    public DomainModel() {
        super();
    }

    public DomainModel(List<? extends DomainElement> elements) {
        super(elements);
    }

    public DomainModel(DomainModel u) {
        super(u);
    }

    
    @Override
    public DomainModel clone() {
        return new DomainModel(this);
    }

    @Override
    protected void parseChildren(UsiXMLElementList unit, Element element) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
