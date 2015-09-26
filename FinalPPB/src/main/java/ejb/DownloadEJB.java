/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.FotografiaEJBFacade;
import java.io.File;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

/**
 *
 * @author ian
 */
@Stateless
public class DownloadEJB implements DownloadEJBLocal{
    
    @EJB
    FotografiaEJBFacade photoFacade;
    
    
    @Override
    public Response DownloadPhoto(String id){
        File file = new File(GlobalVariables.photoPath+id);

        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition",
                "attachment; filename=image_from_server.png");
        return response.build();
    }
    
    
}
