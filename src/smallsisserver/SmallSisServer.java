/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallsisserver;

/**
 *
 * @author Viktor
 */
public class SmallSisServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        

        
        Server s = new Server();
        
        Thread t = new Thread(s);
        //t.setDaemon(true);
        t.start();
        
        
    }

    
}
