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
    private Venue venue;
    private float cover;
    private Date date;

    public Party(String nombre) {
        this.name = nombre;
        this.date = Calendar.getInstance().getTime();
        //this.location = new Location();

    }

    public Party() {
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getCover() {
        return cover;
    }

    public void setCover(float cover) {
        this.cover = cover;
    }


    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

