package usixmlpatterns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.usixml.UsiXMLElement;
import org.usixml.UsiXMLModel;
import org.usixml.aui.AbstractCompoundIU;
import org.usixml.aui.AbstractDataIU;
import org.usixml.aui.AbstractSelectionIU;
import org.usixml.aui.AbstractUIElement;
import org.usixml.aui.AbstractUIModel;
import org.usixml.domain.DomainModel;
import org.usixml.task.Task;
import org.usixml.task.TaskModel;
import usixmlpatterns.Exceptions.ActionNotSupportedException;
import usixmlpatterns.Exceptions.IsNotAnInstantiationOfThePatternException;
import utils.Words;

/**
 *
 * @author André Barbosa
 */
public class Pattern {
    
    private DomainModel domain;
    private TaskModel task;
    
    private AbstractUIModel template;

    public Pattern() {
    }

    public Pattern(DomainModel domain, TaskModel task, AbstractUIModel template) {
        this.domain = domain;
        this.task = task;
        this.template = template;
    }

    public Pattern(Pattern t) {
        this.domain = t.getDomain();
        this.task = t.getTask();
        this.template = t.getTemplate();
    }
    
    public DomainModel getDomain() {
        return domain.clone();
    }

    public void setDomain(DomainModel domain) {
        this.domain = domain.clone();
    }

    public TaskModel getTask() {
        return task.clone();
    }

    public void setTask(TaskModel task) {
        this.task = task.clone();
    }

    public AbstractUIModel getTemplate() {
        return template.clone();
    }

    public void setTemplate(AbstractUIModel template) {
        this.template = template.clone();
    }

    public Map<AbstractUIElement, Task> matchCompoundAndTask(){
        Map<AbstractUIElement, Task> tmp = new HashMap<>();
        
        Map<Integer, AbstractCompoundIU> compounds = this.template.getCompounds();
        
        for(Task t : task.getTasks().values()){                
            String nameWithoutAction = Words.removeFirstWordFromCamelCaseString(t.getName());

            Stack<UsiXMLElement> stack = new Stack<>();            
            stack.addAll(template.getElements());
            AbstractUIElement correspondingCompound = null;
            while(!stack.isEmpty() && correspondingCompound == null){
                UsiXMLElement elem = stack.pop();
                
                if(elem.getLabel().equals(nameWithoutAction) && elem instanceof AbstractUIElement){
                    correspondingCompound = (AbstractUIElement)elem;
                }
                
                stack.addAll(elem.getElements());
            }
            
            if(correspondingCompound != null) {
                tmp.put(correspondingCompound, t);
            }

        }
        
        return tmp;
    }
    
    public Map<Task, Task> matchPatternTaskAndModelTask(TaskModel model) throws IsNotAnInstantiationOfThePatternException{
        Map<Task, Task> tmp = new HashMap<>();
        
        Map<Integer, Task> patterTasks = task.getTasks();
        for(Task t : model.getTasks().values()){
            if(t.getPatternId() != null){
                Task patternTask = patterTasks.get(t.getPatternId());
                if(patternTask != null){
                    tmp.put(patternTask, t);
                }
                else{
                    throw new IsNotAnInstantiationOfThePatternException("Pattern id: " + t.getPatternId() + " is not valid.");
                }
            }
        }
        
        if(tmp.size() != patterTasks.size()){
            throw new IsNotAnInstantiationOfThePatternException("One or more pattern tasks weren't redifined.");
        }
        
        return tmp;
    }
    
    public AbstractUIModel buildAbstractUIModel(TaskModel model) 
            throws IsNotAnInstantiationOfThePatternException, 
            InstantiationException, IllegalAccessException, ActionNotSupportedException{
        
        // AUX
        Map<AbstractUIElement, Task> taskAui = matchCompoundAndTask();
        Map<Task, Task> patternModel = matchPatternTaskAndModelTask(model);
        Map<AbstractUIElement, Task> taskAuiModel = new HashMap<>();
        
        AbstractUIModel tmp = new AbstractUIModel();
        tmp.setNextId(template.getMaxId());
        ArrayList<UsiXMLElement> elements = new ArrayList<>();        
        
        for(UsiXMLElement e : template.getElements()){
            if(e instanceof AbstractUIElement){
                AbstractUIElement auiElement = (AbstractUIElement)e;
                Task patternTask = taskAui.get(auiElement);
                Task modelTask = patternModel.get(patternTask);

                UsiXMLElement newElement = auxBuildAbstractUIModel(tmp, 
                        auiElement, 
                        taskAui.get(auiElement), modelTask,
                        taskAui, patternModel, taskAuiModel);
                
                elements.add(newElement);
            }
        }
        
        tmp.setElements(elements);
        
        return tmp;
    }
    
    private AbstractUIElement auxBuildAbstractUIModel(AbstractUIModel model, 
            AbstractUIElement current, 
            Task patternTask, Task modelTask, 
            Map<AbstractUIElement, Task> taskAui, 
            Map<Task, Task> patternModel, 
            Map<AbstractUIElement, Task> taskAuiModel) 
            throws InstantiationException, IllegalAccessException, ActionNotSupportedException{
        
        AbstractUIElement tmp = current.getClass().newInstance();
        tmp.setId(current.getId());
        tmp.setLabel(Words.removeFirstWordFromCamelCaseString(modelTask.getLabel()));        
        
        ArrayList<UsiXMLElement> elements = new ArrayList<>();
        
        for(UsiXMLElement e : current.getElements()){
            if(e instanceof AbstractUIElement){
                AbstractUIElement auiElement = (AbstractUIElement)e;
                Task currentPatternTask = taskAui.get(auiElement);
                Task currentModelTask = patternModel.get(currentPatternTask);
                
                UsiXMLElement newElement = auxBuildAbstractUIModel(model, 
                        auiElement, 
                        currentPatternTask, currentModelTask,
                        taskAui, patternModel, taskAuiModel);
                
                elements.add(newElement);
            }
        }
        
        tmp.setElements(elements);
        
        completeAbstractUIElement(model, tmp, patternModel.values(), modelTask);
        
        return tmp;
    }
    
    private void completeAbstractUIElement(UsiXMLModel model, 
            UsiXMLElement element, Collection<Task> syncTasks, 
            Task modelTask) throws ActionNotSupportedException{
        
        for(Task t : modelTask.getSubTasks()){
            String nameWithoutAction = Words.removeFirstWordFromCamelCaseString(t.getName());
            String actionName = Words.getFirstWordFromCamelCaseString(t.getName());
            
            if(Words.getFirstWordFromCamelCaseString(t.getName()).equals("Show")){                
                // Check if it's the current AbstractUIElement.
            }
            else{
                if(!syncTasks.contains(t)){
                    switch(actionName){
                        case "Click":
                            element.addElement(new AbstractSelectionIU(model.getNextId(), nameWithoutAction, new ArrayList<UsiXMLElement>()));
                            break;
                        case "Fill":
                            element.addElement(new AbstractDataIU(model.getNextId(), nameWithoutAction, new ArrayList<UsiXMLElement>()));
                            break;
                        default:
                            throw new ActionNotSupportedException(actionName + " "
                                    + "is not supported. Supported actions "
                                    + "are: \"Show\", \"Click\" and \"Fill\"");
                    }
                }               
            }
        }
        
    }
    
    @Override
    public Pattern clone() throws CloneNotSupportedException {
        return new Pattern(this);
    }    
}
