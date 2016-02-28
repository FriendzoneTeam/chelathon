/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.friendzoneteam.chelathon.entity;

import java.util.Calendar;
import java.util.Date;
import mx.friendzoneteam.chelathon.entity.Location;


/**
 *
 * @author rk521
 */
public class Party {
    
    private long id;
    private String name;
    private Location location;
    private float cover;
    private Date date;

    public Party(String nombre) {
        this.name = nombre;
        this.date = Calendar.getInstance().getTime();
        this.location = new Location();
        
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLatitude() {
        return location.getLatitude();
    }

    public void setLatitude(long latitud) {
        this.location.setLatitude(latitud);
    }

    public long getLongitude() {
        return location.getLongitude();
    }

    public void setLongitude(long longitud) {
        this.location.setLongitude(longitud);
    }

    public float getCover() {
        return cover;
    }

    public void setCover(float cover) {
        this.cover = cover;
    }

    
}