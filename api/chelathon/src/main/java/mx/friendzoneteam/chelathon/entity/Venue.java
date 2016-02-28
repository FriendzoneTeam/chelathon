/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.friendzoneteam.chelathon.entity;
import mx.friendzoneteam.chelathon.entity.Location;

/**
 *
 * @author kiramishima
 */
public class Venue {
    private String dir, dir2, name;
    private Location location;
	private long id_owner;
    private long id_party;

    public Venue(String dir, String dir2, String name, long lng, long lat, long id_owner, long id_party) {
        this.dir = dir;
        this.dir2 = dir2;
        this.name = name;
        this.location.setLatitude(lat);
        this.location.setLongitude(lng);
        this. id_owner = id_owner;
        this.id_party = id_party;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        //this.dir = dir
    }

    public String getDir2() {
        return dir2;
    }

    public void setDir2(String dir2) {
        this.dir2 = dir2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public long getLongitude() {
        return location.getLongitude();
    }

    public void setLongitude(long lng) {
        this.location.setLongitude(lng);
    }

    public long getLatitude() {
    	return location.getLatitude();
    }

    public void setLatitude(long lat) {
        this.location.setLatitude(lat);
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