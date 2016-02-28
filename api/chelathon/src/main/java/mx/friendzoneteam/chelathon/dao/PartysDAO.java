/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.friendzoneteam.chelathon.dao;

import java.util.ArrayList;
import java.util.List;
import mx.friendzoneteam.chelathon.db.DB;
import mx.friendzoneteam.chelathon.entity.Party;

/**
 *
 * @author rk521
 */
public class PartysDAO {

    public static Party addParty(String nombre) {
        Party curr=new Party(nombre);
        DB.addParty(curr);
        return curr;
    }
    
    public static List<Party> allPartys() {
        List<Party> lista=DB.getPartys();        
        return lista;
    }

    
    public static void updateParty(long id_party, Party p) {
        DB.updateParty(id_party,p);
    }
    
}
