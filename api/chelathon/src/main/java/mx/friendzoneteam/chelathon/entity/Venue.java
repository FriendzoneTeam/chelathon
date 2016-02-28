/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.friendzoneteam.chelathon.entity;

/**
 *
 * @author kiramishima
 */
public class Venue {
	private long lng;
	private long lat;
	private long id_owner;
    private long id_party;

	public long getLng() {
        return lng;
    }

    public void setLng(long lng) {
        this.lng = lng;
    }

    public long getLat() {
    	return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public void setId_owner(long id_owner) {
    	this.id_owner = id_owner;
    }

    public long getId_owner() {
    	return id_owner;
    }   

    public long getId_party() {
        return id_party;
    }

    public void setId_party(long id_party) {
        this.id_party = id_party;
    }
 
}