/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.UsuarioEJBLocal;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import model.Usuario;

/**
 *
 * @author ian
 */
@Path("/registro")
//@ApplicationPath("/")
public class RegistroService {
    @EJB
    UsuarioEJBLocal usuarioEJB;
    
    
    @POST
    @Path("/create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response exist(Usuario user){
        
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add( "message", usuarioEJB.verifica(user) );
 
        JsonObject jsonObj = jsonObjBuilder.build();
        if(usuarioEJB.verifica(user)){
            usuarioEJB.insertData(user);
        }
 
        return Response.status( Response.Status.OK ).entity( jsonObj ).build();
    }
    
    
}
