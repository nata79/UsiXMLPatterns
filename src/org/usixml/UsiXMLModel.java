package org.usixml;

import java.util.List;

/**
 *
 * @author André Barbosa
 */
public abstract class UsiXMLModel extends UsiXMLElementList {

    public UsiXMLModel() {
        super();
    }

    public UsiXMLModel(List<? extends UsiXMLElement> elements) {
        super(elements);
    }

    public UsiXMLModel(UsiXMLModel u) {
        super(u);
    }
}
