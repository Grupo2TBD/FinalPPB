/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.FotografiaEJBLocal;
import facade.FotografiaEJBFacade;
import facade.UsuarioEJBFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import model.Fotografia;
import model.Usuario;

/**
 *
 * @author ian
 */
@Path("/upload")
public class UploadService {
    @EJB
    FotografiaEJBLocal fotografiaEJB;
    
    @EJB
    FotografiaEJBFacade fotoFacade;
    
    @EJB
    UsuarioEJBFacade userFacade;
    
    /////////////Pensar en formato 
    /*
    @POST
    @Consumes({"application/json"})
    public void uploadService(Usuario user, Fotografia photo) {
         
        this.fotografiaEJB.uploadPhoto(user, photo);
    }
    */
    
    @GET
    public void upload(){
        Fotografia photo = new Fotografia();
        photo.setTituloPhoto("Vacaciones Sac");
        photo.setFormatoPhoto("png");
        Usuario user = this.userFacade.find(3);
        
    }
    
    @GET
    @Path("/showAll")
    @Produces({"application/json"})
    public List<Fotografia> showAllPhotos(){
        return fotoFacade.findAll();
    }
    
    
}