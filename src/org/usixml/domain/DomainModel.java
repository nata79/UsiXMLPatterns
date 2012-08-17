package org.usixml.domain;

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
import org.usixml.aui.AbstractCompoundIU;
import org.usixml.aui.AbstractUIModel;

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

    public ArrayList<Class> getClassifiers(){
        ArrayList<Class> tmp = new ArrayList<Class>();
        
        for(UsiXMLElement elem : this.getElements()){
            if(elem.getClass().getName().equals("org.usixml.domain.Class")){
                tmp.add((Class)elem);
            }
        }
        
        return tmp;
    }
    
    
    @Override
    public DomainModel clone() {
        return new DomainModel(this);
    }

    @Override
    public void fromFile(String path){
        InputStream is = null;
        try {
            
            // Read the file
            SAXReader reader = new SAXReader();
            is = new FileInputStream(path);
            Document document = reader.read(is);
            
            // Get the root element
            Element root = (Element) document.getRootElement();
            
            // Get classifiers
            this.parseClassfiers(this, root);
            
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
    
    protected void parseClassfiers(UsiXMLElementList unit, Element element) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        for(Element child : element.elements()){
            if(child.getName().equals("classifiers")){
                UsiXMLElement uelem = this.objectFromElement(child);
                unit.addElement(uelem);
                this.parseClassfiers(uelem, child);
            }
            else if(child.getName().equals("attributes")){
                UsiXMLElement uelem = this.objectFromElement(child);
                unit.addElement(uelem);
            }
        }
    }
    
    @Override
    protected void parseChildren(UsiXMLElementList unit, Element element) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        for(Element child : element.elements()){
            if(child.getName().equals("relationships")){
                UsiXMLElement uelem = this.objectFromElement(child);
                unit.addElement(uelem);
            }
        }
    }
    
    private UsiXMLElement objectFromElement(Element element) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        // Fetch name and attributes
        String name = element.getName();
        String type = element.attributeValue("type");
        String label = element.attributeValue("name");
        int id = 0;
        try{
            if(name.equals("classifiers")){
                id = this.getClassifiers().size();
            }
            else{
                id = Integer.parseInt(element.attributeValue("id"));   
            }            
        } catch(java.lang.NumberFormatException ex){
            
        }
        
        // If is a compoundIUs build AbstractCompoundIU
        if(name.equals("attributes")){            
            return new Attribute(VisibilitySetting.valueOf(element.attributeValue("visibility")), this.typeToClass(type), 0, label, new ArrayList<UsiXMLElement>());
        }
        
        // Instantiate through type
        UsiXMLElement uelem = (UsiXMLElement) java.lang.Class.forName(type.replace(":", ".")).newInstance();
        if(uelem.getClass().getName().equals("org.usixml.domain.Generalization")){
            Generalization g = (Generalization)uelem;
            g.setSource(this.typeToClass(element.attributeValue("source")));
            g.setTarget(this.typeToClass(element.attributeValue("target")));
        }
        else if(uelem.getClass().getName().equals("org.usixml.domain.Association")){
            Association a = (Association)uelem;
            a.setSource(this.typeToClass(element.attributeValue("source")));
            a.setTarget(this.typeToClass(element.attributeValue("target")));
            
            a.setSourceEndAggregation(element.elements().get(0).attributeValue("aggregation"));
            a.setSourceEndLower(element.elements().get(0).attributeValue("lower") != null ? element.elements().get(0).attributeValue("lower") : "0" );
            a.setSourceEndName(element.elements().get(0).attributeValue("name"));
            a.setSourceEndUpper(element.elements().get(0).attributeValue("upper") != null ? element.elements().get(0).attributeValue("upper") : "*");
            
            a.setTargetEndAggregation(element.elements().get(1).attributeValue("aggregation"));
            a.setTargetEndLower(element.elements().get(1).attributeValue("lower") != null ? element.elements().get(1).attributeValue("lower") : "0");
            a.setTargetEndName(element.elements().get(1).attributeValue("name"));
            a.setTargetEndUpper(element.elements().get(1).attributeValue("upper") != null ? element.elements().get(1).attributeValue("upper"): "*" );
        }
        else{
            uelem.setId(id);
            uelem.setLabel(label);   
        }
        
        return uelem;
    }
    
    private Class typeToClass(String type){
        int index = Integer.parseInt(type.split("\\.")[1]);
        return this.getClassifiers().get(index);
    }
    
}
