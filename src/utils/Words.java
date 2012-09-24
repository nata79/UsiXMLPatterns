package utils;

import java.util.Arrays;

/**
 *
 * @author André Barbosa
 */
public class Words {
    
    /**
     * Separates words from a CamelCase string.
     * @param s
     * @return 
     */
    public static String[] splitCamelCase(String s) {
        return s.replaceAll(
           String.format(
              "%s|%s|%s",
              "(?<=[A-Z])(?=[A-Z][a-z])",
              "(?<=[^A-Z])(?=[A-Z])",
              "(?<=[A-Za-z])(?=[^A-Za-z])"
           ),
           " "
        ).split(" ");
    }
    
    /**
     * Converts a list of words into a string.
     * @param list
     * @return 
     */
    public static String wordListToString(String[] list){
        StringBuilder sb = new StringBuilder();
        
        for(String s : list){
            sb.append(s);
        }
        
        return sb.toString();
    }
    
    /**
     * Removes the first word from a CamelCase string.
     * @param s
     * @return 
     */
    public static String removeFirstWordFromCamelCaseString(String s){
        String[] list = splitCamelCase(s);
        return wordListToString(Arrays.copyOfRange(list, 1, list.length));
    }
    
    /**
     * Removes the last word from a CamelCase string.
     * @param s
     * @return 
     */
    public static String removeLastWordFromCamelCaseString(String s){
        String[] list = splitCamelCase(s);
        return wordListToString(Arrays.copyOfRange(list, 0, list.length - 1));
    }
    
    /**
     * Returns the first word of a CamelCase string.
     * @param s
     * @return 
     */
    public static String getFirstWordFromCamelCaseString(String s){
        return splitCamelCase(s)[0];
    }

}
