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
public class Pool {
	private long id_user;
	private long id_party;
	private Float cuota;

	public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public long getId_party() {
    	return id_party;
    }

    public void setId_party(long id_party) {
        this.id_party = id_party;
    }

    public void setCuota(Float cuota) {
    	this.cuota = cuota;
    }

    public Float getCuota() {
    	return cuota;
    }
 
}