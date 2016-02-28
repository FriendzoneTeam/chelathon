/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.friendzoneteam.chelathon.dao;

import mx.friendzoneteam.chelathon.entity.Party;

/**
 *
 * @author rk521
 */
public class PartysDAO {

    public static Party addParty() {
        Party curr=new Party();
        curr.setId(42);
        return curr;
    }
    
    public static Party allPartys() {
        Party curr=new Party();
        curr.setId(42);
        return curr;
    }
    
}
