/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.UsuarioEJBLocal;
import facade.UsuarioEJBFacade;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import model.Usuario;

/**
 *
 * @author ian
 */
@Path("/editProfile")
public class editProfileService {
    @EJB
    UsuarioEJBLocal userEJB;
    
    @EJB
    UsuarioEJBFacade userEJBFacade;
    
    
    @GET
    @Path("/actualInfo")
    @Produces({"application/json"})
    public Usuario showActualInfo(Usuario user) {
        
        return this.userEJBFacade.find(user.getIdUser());
    }
    
    @PUT
    @Path("/newInfo")
    @Consumes({"application/json"})
    public Response insertNewInfo(Usuario user){
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add( "message", userEJB.editarPerfil(user) );
 
        JsonObject jsonObj = jsonObjBuilder.build();
 
        return Response.status( Response.Status.ACCEPTED).entity(jsonObj).build();
    }
    
}