/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

/**
 *
 * @author ian
 */


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Album;

@Stateless
public class AlbumEJBFacade extends AbstractFacade<Album>{

    @PersistenceContext(unitName = "ian")
    private EntityManager em;
    public AlbumEJBFacade() {
        super(Album.class);
    }
    
    
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}