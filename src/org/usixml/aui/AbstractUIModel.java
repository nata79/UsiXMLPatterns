package org.usixml.aui;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXWriter;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.DefaultDocument;
import org.dom4j.tree.DefaultElement;
import org.usixml.UsiXMLElement;
import org.usixml.UsiXMLElementList;
import org.usixml.UsiXMLModel;

/**
 *
 * @author André Barbosa
 */
public class AbstractUIModel extends UsiXMLModel {

    public AbstractUIModel() {
        super();
    }

    public AbstractUIModel(List<? extends AbstractUIElement> elements) {
        super(elements);
    }

    public AbstractUIModel(AbstractUIModel u) {
        super(u);
    }
    
    public Map<Integer, AbstractCompoundIU> getCompounds(){
        HashMap<Integer, AbstractCompoundIU> tmp = new HashMap<Integer, AbstractCompoundIU>();
        
        for(UsiXMLElement e : super.getElements()){
            if(e instanceof AbstractCompoundIU){
                tmp.put(e.getId(), (AbstractCompoundIU)e);
            }
            
            if(e instanceof AbstractUIElement){
                ((AbstractUIElement)e).getCompounds(tmp);
            }
        }
        
        return tmp;
    }
    
    public void toFile(String path) throws IOException{
        Element root = new DefaultElement("org.usixml.aui:AbstractUIModel");
        root.addAttribute("xmi:version", "2.0");
        root.addAttribute("xmlns:xmi", "http://www.omg.org/XMI");
        root.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        root.addAttribute("xmlns:org.usixml.aui", "http://org.usixml.aui/2.0");
        
        // Add root coumpoundUI's
        for(UsiXMLElement element : getElements()){
            if(element instanceof AbstractUIElement){
                AbstractUIElement auiElement = (AbstractUIElement)element;
                Element xmlElement = new DefaultElement("compoundIUs");
                xmlElement.addAttribute("id", new Integer(auiElement.getId()).toString());
                xmlElement.addAttribute("label", auiElement.getLabel());
                
                for(UsiXMLElement child : auiElement.getElements()){
                    if(child instanceof AbstractUIElement){
                        AbstractUIElement childAuiElement = (AbstractUIElement)child;
                        childAuiElement.toFileHelper(xmlElement);
                    }
                }
                
                root.add(xmlElement);
            }
        }
        
        
        Document document = new DefaultDocument(root);
        
        XMLWriter writer = new XMLWriter(new FileWriter(path));
        writer.write( document );
        writer.close();
    }
    
    @Override
    protected void parseChildren(UsiXMLElementList unit, Element element) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        for(Element child : element.elements()){
            UsiXMLElement uelem = this.objectFromElement(child);
            unit.addElement(uelem);
            this.parseChildren(uelem, child);
        }
    }
    
    private UsiXMLElement objectFromElement(Element element) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        // Fetch name and attributes
        String name = element.getName();
        String type = element.attributeValue("type");
        String label = element.attributeValue("label");
        int id = 0;
        try{
            id = Integer.parseInt(element.attributeValue("id"));
        } catch(java.lang.NumberFormatException ex){
            
        }
        
        // If is a compoundIUs build AbstractCompoundIU
        if(name.equals("compoundIUs")){
            return new AbstractCompoundIU(id, label, new ArrayList<UsiXMLElement>());
        }
        
        // Instantiate through type
        UsiXMLElement uelem = (UsiXMLElement) Class.forName(type.replace(":", ".")).newInstance();
        uelem.setId(id);
        uelem.setLabel(label);
        
        return uelem;
    }

    @Override
    public AbstractUIModel clone() {
        return new AbstractUIModel(this);
    }
    
}
