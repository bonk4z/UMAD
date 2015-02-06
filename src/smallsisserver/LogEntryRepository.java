/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallsisserver;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import resources.LogEntry;
import resources.Pupil;

/**
 *
 * @author tobias
 */
public class LogEntryRepository extends Observable{
    List<LogEntry> logEntries = new LinkedList<>();
    private static LogEntryRepository instance;
    
    
    private LogEntryRepository(){}
    
    public static LogEntryRepository getInstance(){
        if(instance == null)
            instance = new LogEntryRepository();
        return instance;
    }
    
    public synchronized void insert(LogEntry le){
        logEntries.add(le);
        setChanged();
        notifyObservers();
        
    }
    
    public List<LogEntry> getAllLogEntries(){        
        return new LinkedList<>(logEntries);
    }
    
    public List<LogEntry> getByTag(String tag){
        List<LogEntry> les = new LinkedList<>();
        for (LogEntry logEntry : logEntries) {
            if(logEntry.getTag().equals(tag))
                les.add(logEntry);
        }
        return les;
    }
    
    public synchronized LogEntry getLastLogEntry(){
        return logEntries.get(logEntries.size()-1);
    }
    
    
}
