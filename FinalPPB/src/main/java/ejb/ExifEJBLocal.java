/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;

/**
 *
 * @author ian
 */
@Local
public interface ExifEJBLocal {
    void insertDataExif(int idFoto, int idCamara, String apertura, int largoFoco, int flash);
}
