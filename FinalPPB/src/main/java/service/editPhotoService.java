/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.FotografiaEJBLocal;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


/**
 *
 * @author ian
 */
@Path("/editarFoto")
public class editPhotoService {
    @EJB
    FotografiaEJBLocal edit;
    
    
  /*  @GET
    public void uploadService() {
        edit.editPhoto(2, 1, 1, "otro título", "nueva descripcion");
        
    }
    */
}