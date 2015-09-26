/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import ejb.UsuarioEJBLocal;
import facade.UsuarioEJBFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import model.Usuario;

/**
 *
 * @author ian
 */
@Path("/login")
//@ApplicationPath("/")
public class LoginService {
    @EJB
    UsuarioEJBLocal userEJB;
    
    @EJB
    UsuarioEJBFacade userFacade;
    
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response login(Usuario user){
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add( "message", userEJB.Login(user));
        
 
        JsonObject jsonObj = jsonObjBuilder.build();
 
        return Response.status( Response.Status.OK ).entity( jsonObj ).build();
    }
    
    @GET
    @Path("/getByAlias/{alias}")
    @Produces({"application/json"})
    public Usuario getByAlias(@PathParam("alias") String nombre){
        return userEJB.findByAlias(nombre);
    }
    
    @GET
    @Path("/getAll")
    @Produces({"application/json"})
    public List<Usuario> getAll(){
        return this.userFacade.findAll();
    }
}
