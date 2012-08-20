package org.usixml.task;

import java.util.List;
import org.dom4j.Element;
import org.usixml.UsiXMLElementList;
import org.usixml.UsiXMLModel;

/**
 *
 * @author André Barbosa
 */
public class TaskModel extends UsiXMLModel {

    public TaskModel() {
        super();
    }

    public TaskModel(List<? extends TaskElement> elements) {
        super(elements);
    }

    public TaskModel(TaskModel u) {
        super(u);
    }

    @Override
    protected void parseChildren(UsiXMLElementList unit, Element element) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TaskModel clone() {
        return new TaskModel(this);
    }
}
