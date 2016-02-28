/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.friendzoneteam.chelathon;

import java.util.HashMap;
import java.util.List;
import mx.friendzoneteam.chelathon.util.JsonTransformer;
import mx.friendzoneteam.chelathon.dao.PartysDAO;
import mx.friendzoneteam.chelathon.entity.Party;
import static spark.Spark.get;
import static spark.Spark.post;


/**
 *
 * @author rk521
 */
public class Rutas {

    public static void main(String[] args) {
        
        //get("/",(req,res)-> "Index");
        //get("/partys",(req,res)-> "Indeex");
        
        //Agrega una party
        post("/partys", (req, res) -> {
            
            Party p=PartysDAO.addParty("Chema");
                        
            return p;
        },new JsonTransformer());
        
        get("/partys",(req,res) -> {
            List<Party> lista= PartysDAO.allPartys();
            return lista;
        },new JsonTransformer());
        
    }

}
