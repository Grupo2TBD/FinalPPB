/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.FotografiaEJBFacade;
import facade.PermisoFotografiaEJBFacade;
import facade.PrivacidadEJBFacade;
import facade.TipoClasificacionEJBFacade;
import facade.UsuarioEJBFacade;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Fotografia;
import model.Usuario;

/**
 *
 * @author ian
 */
@Stateless
public class FotografiaEJB implements FotografiaEJBLocal{
    @EJB
    FotografiaEJBFacade photoFacade;
    
    @EJB
    RecurrentesEJBLocal fecha;
    
    @EJB
    AlbumEJBLocal albumEJB;
    
    @EJB
    PrivacidadEJBFacade privacyFacade;
    
    @EJB
    UsuarioEJBFacade userFacade;
    
    @EJB
    TipoClasificacionEJBFacade clasificacionFacade;
    
    @EJB
    PermisoFotografiaEJBFacade permisoFotoFacade;
    
    @Override
    public void insertPhotoInfo(String dateFrom, String title, String description, String format,Fotografia foto,int idUser) {
        //Fotografia foto=new Fotografia();
        Usuario usuario = this.userFacade.find(idUser);
        foto.setFechaSubidaPhoto(fecha.fechaActual());
        try {
            foto.setFechaTomadaPhoto(fecha.FechaAngularToJava(dateFrom));
        } catch (ParseException ex) {
            Logger.getLogger(FotografiaEJB.class.getName()).log(Level.SEVERE, null, ex);
        }
        foto.setCantidadVisitasPhoto(0);
        foto.setTituloPhoto(title);
        foto.setDescripcionPhoto(description);
        foto.setCantidadFavoritosPhoto(0);
        foto.setFormatoPhoto(format);
        foto.setUltimaActualizacionPhoto(fecha.fechaActual());
        foto.setCantidadComentariosPositivos(0);
        foto.setCantidadComentariosNegativos(0);
        foto.setCantidadComentariosNeutros(0);
        this.photoFacade.create(foto);
        albumEJB.buscaAlbum(usuario, foto);
    }
    
    @Override
    public void uploadPhoto(Usuario user, Fotografia photo){
        
        this.photoFacade.create(photo);
        //albumEJB.buscaAlbum(user, photo);
        
    }
    
    @Override
    public void editPhoto(int idPhoto, int idPrivacidad,int idPermiso, String titulo, String descripcion){
        Object id=idPhoto;
        Fotografia photo = this.photoFacade.find(idPhoto);
        photo.setTituloPhoto(titulo);
        photo.setDescripcionPhoto(descripcion);
        photo.setUltimaActualizacionPhoto(fecha.fechaActual());
        this.photoFacade.edit(photo);
    }
}
