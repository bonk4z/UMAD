/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallsisserver;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import resources.LogEntry;

/**
 *
 * @author Viktor
 */
public class Server implements Runnable, Observer {
    
    boolean firstTry = true;
    List<LogEntry> list = new LinkedList<>();int i=0;
    
    
    
    public Server(){
        LogEntryRepository.getInstance().addObserver(this);
        System.out.println(LogEntry.Tag.CONNECTION.name());
    }

    @Override
    public void run() {
      try
        {
            ServerSocket ser = new ServerSocket(50555);
            
            while(true){
                Socket sock = ser.accept();
                
                new Thread(new Logger(sock)).start();
                System.out.println("Logger started");
                
            }
        }
        catch(Exception ex)
        {
        }
   
}
    
    @Override
    public void update(Observable o, Object arg) {

        System.out.println("update called");
                DateFormat df = new SimpleDateFormat("HH:mm:ss");


        LogEntry latest = LogEntryRepository.getInstance().getLastLogEntry();

        list.add(latest);

        MyUtils.printLogEntry(latest);
        if(latest.hasImgAttached()){
        try{
            BufferedImage bi = ImageIO.read(new ByteArrayInputStream(latest.getImg()));
            ImageIO.write(bi, "jpg", new File(MyUtils.getAbsJpgPath("/Users/Desktop/tobias/Desktop", latest)));


        }catch(Exception e){e.getMessage();}
        }


        System.out.println("printed size " + list.size());
        System.out.println("actual size " + LogEntryRepository.getInstance().getAllLogEntries().size());

    }
    
}
