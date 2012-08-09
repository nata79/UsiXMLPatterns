package org.usixml.aui;

import java.util.List;
import org.usixml.UsiXMLElement;
import org.usixml.UsiXMLModel;

/**
 *
 * @author André Barbosa
 */
public class AbstractUIModel extends UsiXMLModel {

    public AbstractUIModel() {
        super();
    }

    public AbstractUIModel(List<? extends UsiXMLElement> elements) {
        super(elements);
    }

    public AbstractUIModel(AbstractUIModel u) {
        super(u);
    }

    @Override
    public UsiXMLModel clone() {
        return new AbstractUIModel(this);
    }
    
}
