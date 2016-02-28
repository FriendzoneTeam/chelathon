/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.friendzoneteam.chelathon.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mx.friendzoneteam.chelathon.entity.Party;
import mx.friendzoneteam.chelathon.entity.Venue;

/**
 *
 * @author rk521
 */
public class DB {

    //Fiestas
    static ArrayList<Party> fiestas;
    //Id Party, 
    static HashMap<Long, Venue> lugares;

    public static List<Party> getPartys() {
        if (fiestas == null) {
            fiestas = new ArrayList<>();
        }
        return fiestas;
    }

    public static void addParty(Party curr) {
        if (fiestas == null) {
            fiestas = new ArrayList<>();
        }
        curr.setId(System.currentTimeMillis());
        fiestas.add(curr);
    }

    public static List<Party> getVenue() {
        if (fiestas == null) {
            fiestas = new ArrayList<>();
        }
        return fiestas;
    }

    public static void addVenue(Venue venue, long party_id) {
        if (lugares == null) {
            lugares = new HashMap<>();
        }

        if (lugares.containsKey(party_id)) {
            //Si la fiesta ya tiene lugar
        } else {
            lugares.put(party_id, venue);
        }
    }

    public static void updateParty(long id_party, Party p) {
        for (Party fiesta : fiestas) {
            if(fiesta.getId()==id_party)
            {
                if(p.getCover()!=0.0)
                    fiesta.setCover(p.getCover());
                if(p.getDate()!=null)
                    fiesta.setDate(p.getDate());
                if(p.getName()!=null)
                    fiesta.setName(p.getName());
                if(p.getVenue()!=null)
                    fiesta.setVenue(p.getVenue());
            }
        }
    }

}

