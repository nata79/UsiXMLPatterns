package org.usixml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.usixml.aui.AbstractUIModel;

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
    
    public void fromFile(String path){
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
    
    protected abstract void parseChildren(UsiXMLElementList unit, Element element) throws ClassNotFoundException, InstantiationException, IllegalAccessException;
}
