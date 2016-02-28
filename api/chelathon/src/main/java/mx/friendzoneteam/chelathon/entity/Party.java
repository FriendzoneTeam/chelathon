/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.friendzoneteam.chelathon.entity;

import java.util.Date;

/**
 *
 * @author rk521
 */
public class Party {
    private long id;
    private long latitud;
    private long longitud;
    private float cover;
    private Date fecha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLatitud() {
        return latitud;
    }

    public void setLatitud(long latitud) {
        this.latitud = latitud;
    }

    public long getLongitud() {
        return longitud;
    }

    public void setLongitud(long longitud) {
        this.longitud = longitud;
    }

    public float getCover() {
        return cover;
    }

    public void setCover(float cover) {
        this.cover = cover;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
