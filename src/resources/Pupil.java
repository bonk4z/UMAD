package resources;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author daniel
 */
public class Pupil implements Serializable{
    private String name;
    private int katNum;
    private String matrikelNr;

    public Pupil(String name, int katNum, String matrikelNr) {
        this.name = name;
        this.katNum = katNum;
        this.matrikelNr = matrikelNr;
    }

    public String getMatrikelNr() {
        return matrikelNr;
    }

    public void setMatrikelNr(String matrikelNr) {
        this.matrikelNr = matrikelNr;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getKatNum(){
        return this.katNum;
    }
    
    public void setKatNum(int katNum){
        this.katNum = katNum;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return this.matrikelNr.hashCode();
    }
    
    
}
