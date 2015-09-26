/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;
import model.Fotografia;
import model.Usuario;


/**
 *
 * @author ian
 */
@Local
public interface FotografiaEJBLocal {
    void insertPhotoInfo (String dateFrom, String title, String description, String format,Fotografia foto, int idUser);
    void uploadPhoto(Usuario user, Fotografia photo);
    void editPhoto(int idPhoto, int idPrivacidad,int idPermiso, String titulo, String descripcion);
}
