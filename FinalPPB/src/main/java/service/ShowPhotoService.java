/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.DownloadEJBLocal;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author ian
 */
@Path("/Photo")
public class ShowPhotoService {
    @EJB
    DownloadEJBLocal downloadEJB;
    
   
    @GET
    @Path("/Download")
    @Produces("image/png")
    public Response download(){
        String id="oli.png";
        return downloadEJB.DownloadPhoto(id);
    }
    
}
