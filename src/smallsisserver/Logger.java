/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallsisserver;

import java.io.ObjectInputStream;
import java.net.Socket;
import resources.LogEntry;
import resources.Pupil;

/**
 *
 * @author tobias
 */
public class Logger implements Runnable {

    Socket socket;
    boolean firstTry;
    Pupil p;
    
    public Logger(Socket socket){
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try{

            ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
            System.out.println("connected");

            p = (Pupil) reader.readObject();
            //System.out.println("new Pupil connected: " + p.getName());
            LogEntry lex = new LogEntry(p, LogEntry.Tag.CONNECTION, "A User has connected");
            LogEntryRepository.getInstance().insert(lex);
            PupilRepository.getInstance().insert(p,socket);


            while(true){
                LogEntry le = (LogEntry) reader.readObject();
                LogEntryRepository.getInstance().insert(le);
                //MyUtils.printLogEntry(le);
            }


        } catch(Exception e){
            System.out.println(e.getMessage());
            LogEntry le = new LogEntry(p, LogEntry.Tag.CONNECTION_LOST, "A pupil has lost connection");

            LogEntryRepository.getInstance().insert(le);
            //System.out.println(LogEntryRepository.getInstance().getAllLogEntries().get(LogEntryRepository.getInstance().getAllLogEntries().size()-1).getPupil().getName());
            //MyUtils.printLogEntry(LogEntryRepository.getInstance().getByTag("CONNECTION_LOST").get(0));
        }
    }
    
}
