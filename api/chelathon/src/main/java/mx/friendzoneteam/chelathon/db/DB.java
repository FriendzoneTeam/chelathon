/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.friendzoneteam.chelathon.db;

import java.util.ArrayList;
import java.util.List;
import mx.friendzoneteam.chelathon.entity.Party;

/**
 *
 * @author rk521
 */
public class DB {

    static ArrayList<Party> fiestas;
    
    public static List<Party> getPartys() {
        if(fiestas==null)
            fiestas = new ArrayList<>();
        return fiestas;
    }

    public static void addParty(Party curr) {
        if(fiestas==null)
            fiestas = new ArrayList<>();
        curr.setId(System.currentTimeMillis());
        fiestas.add(curr);
    }
    
}
