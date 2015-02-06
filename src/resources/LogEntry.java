/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author tobias
 */
public class LogEntry implements Serializable {
        
    public enum Tag{
        CONNECTION, CONNECTION_LOST, SCREENSHOT, WARNING;
    }
    
    
    private String msg;
    Pupil pupil;
    private byte[] img = null;
    private Date timeStamp;
    private Tag tag;

    public LogEntry(Pupil pupil, Tag tag, String msg) {
        this.tag = tag;
        this.msg = msg;
        this.pupil = pupil;
        this.timeStamp = new Date();
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public boolean hasImgAttached(){
        return img != null;
    }
    
    public Pupil getPupil() {
        return pupil;
    }

    public void setPupil(Pupil pupil) {
        this.pupil = pupil;
    }

    
    
    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
    
    
    
}
