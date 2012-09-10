package usixmlpatterns;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.usixml.aui.AbstractCompoundIU;
import org.usixml.aui.AbstractUIModel;
import org.usixml.domain.DomainModel;
import org.usixml.task.Task;
import org.usixml.task.TaskModel;
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

    public Map<Task, AbstractCompoundIU> matchTasksAndCompound(){
        Map<Task, AbstractCompoundIU> tmp = new HashMap<Task, AbstractCompoundIU>();
        
        Map<Integer, AbstractCompoundIU> compounds = this.template.getCompounds();
        
        for(Task t : task.getTasks().values()){
            String action = Words.getFirstWordFromCamelCaseString(t.getName());
            if(!action.equals("Click") && !action.equals("Submit")){
                
                String nameWithoutAction = Words.removeFirstWordFromCamelCaseString(t.getName());

                Iterator<AbstractCompoundIU> it = compounds.values().iterator();
                AbstractCompoundIU correspondingCompound = null;
                while(it.hasNext() && correspondingCompound == null){
                    AbstractCompoundIU current = it.next();
                    if(current.getLabel().equals(nameWithoutAction)){
                        correspondingCompound = current;
                    }
                }
                if(correspondingCompound != null) {
                    tmp.put(t, correspondingCompound);
                }
            }

        }
        
        return tmp;
    }
    
    public Map<Task, Task> matchPatternTaskAndModelTask(TaskModel model) throws IsNotAnInstantiationOfThePatternException{
        Map<Task, Task> tmp = new HashMap<Task, Task>();
        
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
    
    @Override
    public Pattern clone() throws CloneNotSupportedException {
        return new Pattern(this);
    }    
}
