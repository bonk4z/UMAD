/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallsisserver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import resources.LogEntry;

/**
 *
 * @author tobias
 */
public class MyUtils {
    
    public static DateFormat df = new SimpleDateFormat("HH:mm:ss");

    public static void printLogEntry(LogEntry le){
        
        
        //asdasd
        boolean hasImageAttached;
        
        hasImageAttached = le.getImg() != null;
        //es geht woo
        System.out.println("User: " + le.getPupil().getMatrikelNr() + " " + le.getPupil().getName() + "\tTag: " + le.getTag().name() + "\tMessage: " + le.getMsg() + "\tHasImageAttached: " + hasImageAttached +"\tTimeStamp: " + df.format(le.getTimeStamp()));
        
        
    }
     public static String getAbsJpgPath(String homePath, LogEntry le){
        String res;
        
        res = homePath.concat(File.separator).concat(le.getPupil().getMatrikelNr()).concat(File.separator).concat(df.format(le.getTimeStamp())).concat(".jpg");
        
        return res;
    }
}
