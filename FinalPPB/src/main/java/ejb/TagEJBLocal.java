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
public interface TagEJBLocal {
    boolean insertTag(String tag);
    void insertDataTag(String tag, String idUser);
}
