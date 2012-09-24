package usixmlpatterns;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.usixml.UsiXMLElement;
import org.usixml.aui.AbstractUIModel;
import org.usixml.domain.Association;
import org.usixml.domain.Attribute;
import org.usixml.domain.DomainElement;
import org.usixml.domain.DomainModel;
import org.usixml.domain.Generalization;
import org.usixml.domain.VisibilitySetting;
import org.usixml.task.TaskModel;
import usixmlpatterns.Exceptions.ActionNotSupportedException;
import usixmlpatterns.Exceptions.IsNotAnInstantiationOfThePatternException;

/**
 *
 * @author André Barbosa
 */
public class UsiXMLPatterns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ActionNotSupportedException {
        
        JFrame frame = new mainWindow();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }    
}
