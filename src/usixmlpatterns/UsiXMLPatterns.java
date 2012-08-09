package usixmlpatterns;

import org.usixml.aui.AbstractUIModel;

/**
 *
 * @author André Barbosa
 */
public class UsiXMLPatterns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AbstractUIModel aui = new AbstractUIModel();
        aui.fromFile("/Users/albmail88/Documents/partilhaVB/invoice.aui");
    }
}
