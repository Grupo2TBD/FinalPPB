/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.FotografiaEJBFacade;
import facade.TagEJBFacade;
import facade.UsuarioEJBFacade;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Fotografia;
import model.Tag;




/**
 *
 * @author ian
 */
@Stateless
public class TagEJB implements TagEJBLocal{
    
    @EJB
    TagEJBFacade tagFacade;
    
    @EJB
    RecurrentesEJB fecha;
    
    @EJB
    UsuarioEJBFacade usuarioFacade;
    
    @EJB
    FotografiaEJBFacade fotografiaFacade;
  
    @Override
    public boolean insertTag(String tag){
        List<Tag> list =this.tagFacade.findAll();
        
        int largo=list.size();
        int contador=0;
        while(largo!=0){
            if(tag.toLowerCase().equals(list.get(contador).getNombreTag())){
                return false;
            }
            largo--;
            contador++;
        }
        
        return true;
    }
    
    @Override
    public void insertDataTag(String tagName,String idUser){
        if(insertTag(tagName)==true){
            Tag tag=new Tag();
            Collection<Fotografia> collect = this.fotografiaFacade.findAll();
            //collect.add(this.fotografiaFacade.find(3)); 
            tag.setFotografiaCollection(null);
            tag.setNombreTag(tagName.toLowerCase());
            
            this.tagFacade.create(tag);
        }
        
    }
}
