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
import static spark.Spark.put;


/**
 *
 * @author rk521
 */
public class Rutas {

    public static void main(String[] args) {
        
        //get("/",(req,res)-> "Index");
        //get("/partys",(req,res)-> "Indeex");
        
        //Agrega una party
        post("/parties", (req, res) -> {
            //System.out.println(req.queryParams("name"));
            String name=req.queryParams("name");
            Party p=PartysDAO.addParty(name);
            
            return p;
        },new JsonTransformer());
        
        put("/parties/:id", (req, res) -> {
            //System.out.println(req.queryParams("name"));
            String name=req.queryParams("name");
            long id_party=Long.parseLong(req.params(":id"));
            Party p=new Party();
            p.setName(name);
            PartysDAO.updateParty(id_party,p);
            return p;
        },new JsonTransformer());
        
        //Obtener lista de parties
        get("/parties",(req,res) -> {
            List<Party> lista= PartysDAO.allPartys();
            HashMap<String,Object> respuesta = new HashMap<>();
            respuesta.put("parties", lista);
            res.type("application/json");
            return respuesta;
        },new JsonTransformer());
        
        //Post venue
        
        //GET Venue //Lista de Lugares
        
        //POST /party/venue
        
    }

}
