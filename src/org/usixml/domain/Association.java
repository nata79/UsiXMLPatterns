package org.usixml.domain;

import java.util.List;
import java.util.Objects;
import org.usixml.UsiXMLElement;

/**
 *
 * @author André Barbosa
 */
public class Association extends Relationship {
    
    public String sourceEndName;
    public String sourceEndLower;
    public String sourceEndUpper;
    public String sourceEndAggregation;
    
    public String targetEndName;
    public String targetEndLower;
    public String targetEndUpper;
    public String targetEndAggregation;

    public Association() {
        super();
    }

    public Association(String sourceEndName, String sourceEndLower, 
            String sourceEndUpper, String sourceEndAggregation, 
            String targetEndName, String targetEndLower, String targetEndUpper, 
            String targetEndAggregation, Class source, Class target, int id, 
            String label, List<? extends UsiXMLElement> elements) {
        super(source, target, id, label, elements);
        this.sourceEndName = sourceEndName;
        this.sourceEndLower = sourceEndLower;
        this.sourceEndUpper = sourceEndUpper;
        this.sourceEndAggregation = sourceEndAggregation;
        this.targetEndName = targetEndName;
        this.targetEndLower = targetEndLower;
        this.targetEndUpper = targetEndUpper;
        this.targetEndAggregation = targetEndAggregation;
    }

    public Association(Association e) {
        super(e);
        this.sourceEndName = e.getSourceEndName();
        this.sourceEndLower = e.getSourceEndLower();
        this.sourceEndUpper = e.getSourceEndUpper();
        this.sourceEndAggregation = e.getSourceEndAggregation();
        this.targetEndName = e.getTargetEndName();
        this.targetEndLower = e.getTargetEndLower();
        this.targetEndUpper = e.getTargetEndUpper();
        this.targetEndAggregation = e.getTargetEndAggregation();
    }
    
    public String getSourceEndName() {
        return sourceEndName;
    }

    public void setSourceEndName(String sourceEndName) {
        this.sourceEndName = sourceEndName;
    }

    public String getSourceEndLower() {
        return sourceEndLower;
    }

    public void setSourceEndLower(String sourceEndLower) {
        this.sourceEndLower = sourceEndLower;
    }

    public String getSourceEndUpper() {
        return sourceEndUpper;
    }

    public void setSourceEndUpper(String sourceEndUpper) {
        this.sourceEndUpper = sourceEndUpper;
    }

    public String getSourceEndAggregation() {
        return sourceEndAggregation;
    }

    public void setSourceEndAggregation(String sourceEndAggregation) {
        this.sourceEndAggregation = sourceEndAggregation;
    }

    public String getTargetEndName() {
        return targetEndName;
    }

    public void setTargetEndName(String targetEndName) {
        this.targetEndName = targetEndName;
    }

    public String getTargetEndLower() {
        return targetEndLower;
    }

    public void setTargetEndLower(String targetEndLower) {
        this.targetEndLower = targetEndLower;
    }

    public String getTargetEndUpper() {
        return targetEndUpper;
    }

    public void setTargetEndUpper(String targetEndUpper) {
        this.targetEndUpper = targetEndUpper;
    }

    public String getTargetEndAggregation() {
        return targetEndAggregation;
    }

    public void setTargetEndAggregation(String targetEndAggregation) {
        this.targetEndAggregation = targetEndAggregation;
    }

    @Override
    public Association clone() {
        return new Association(this);
    }

    @Override
    public boolean equals(Object o) {
        
        if(o == null || o.getClass() != this.getClass()) {
            return false;
        }
        
        if(o == this) {
            return true;
        }
        
        Association a = (Association)o;
        return Objects.equals(this.sourceEndAggregation, a.getSourceEndAggregation()) &&
                Objects.equals(this.sourceEndLower, a.getSourceEndLower()) &&
                Objects.equals(this.sourceEndName, a.getSourceEndName()) &&
                Objects.equals(this.sourceEndUpper, a.getSourceEndUpper()) &&
                Objects.equals(this.targetEndAggregation, a.getTargetEndAggregation()) &&
                Objects.equals(this.targetEndLower, a.getTargetEndLower()) &&
                Objects.equals(this.targetEndName, a.getTargetEndName()) &&
                Objects.equals(this.targetEndUpper, a.getTargetEndUpper()) &&
                super.equals(o);
    }
        
}
