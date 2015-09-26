/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.CamaraEJBFacade;
import facade.ExifEJBFacade;
import facade.FotografiaEJBFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Exif;

/**
 *
 * @author ian
 */
@Stateless
public class ExifEJB implements ExifEJBLocal{
    @EJB
    ExifEJBFacade exifFacade;
    
    @EJB
    CamaraEJBFacade camaraEJB;
    
    @EJB
    FotografiaEJBFacade fotografiaFacade;
    
    
    @Override
    public void insertDataExif(int idFoto, int idCamara, String apertura, int largoFoco, int flash){
        Exif exif = new Exif();
        exif.setAperturaExif(apertura);
        exif.setFlashExif(Boolean.TRUE);
        this.exifFacade.create(exif);
                
       
    }
}
