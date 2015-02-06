/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallsisserver;

import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import resources.Pupil;

/**
 *
 * @author tobias
 */
public class PupilRepository {
    HashMap<Pupil, Socket> pupils = new HashMap<>();
    private static PupilRepository instance;
    
    
    private PupilRepository() { }
    
    public static PupilRepository getInstance(){
        if(instance == null)
            instance = new PupilRepository();
        return instance;
    }
    
    public void insert(Pupil p, Socket s){
        pupils.put(p, s);
    }
    
    public HashMap<Pupil, Socket> getAllPupils(){        
        return new HashMap<Pupil, Socket>(pupils);
    }
}
