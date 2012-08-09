package org.usixml.aui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
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

    public AbstractUIModel(List<? extends UsiXMLElement> elements) {
        super(elements);
    }

    public AbstractUIModel(AbstractUIModel u) {
        super(u);
    }
    
    public void fromFile(String path){
        AbstractUIModel aui = new AbstractUIModel();
        
        InputStream is = null;
        try {
            
            // Read the file
            SAXReader reader = new SAXReader();
            is = new FileInputStream(path);
            Document document = reader.read(is);
            
            // Get the root element
            Element root = (Element) document.getRootElement();
            
            this.parseChildren(this, root);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbstractUIModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AbstractUIModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractUIModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AbstractUIModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(AbstractUIModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(AbstractUIModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    private void parseChildren(UsiXMLElementList unit, Element element) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
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
    public UsiXMLElementList clone() {
        return new AbstractUIModel(this);
    }
    
}
