/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.CamaraEJBFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Camara;

/**
 *
 * @author ian
 */
@Stateless
public class CamaraEJB implements CamaraEJBLocal{
    @EJB
    CamaraEJBFacade camaraFacade;
    
    @Override
    public Camara insertCamera(String nombre,String megaPx,String zoom, String pantalla, String tipo, String marca, String peso){
        Camara camara = new Camara();
        if(findCamera(nombre)==true){
            camara.setNombreCamara(nombre);
            camara.setMegapixelesCamara(megaPx);
            camara.setZoomCamara(zoom);
            camara.setTamanoPantallaCamara(pantalla);
            camara.setMarcaCamara(marca);
            camara.setPesoCamara(peso);
            this.camaraFacade.create(camara);
            return camara;
        }
        return camara;
    }
    
    @Override
    public boolean findCamera(String nombre){
        List<Camara> list = this.camaraFacade.findAll();
        Camara camara = new Camara();
        int largo=list.size();
        int contador=0;
        while(largo!=0){
            if(list.get(contador).getNombreCamara().equals(nombre)){
                int cantidadFotos=camara.getCantidadFotografiasCamara()+1;
                camara.setCantidadFotografiasCamara(cantidadFotos);
                this.camaraFacade.edit(camara);
                return false;
            }
            largo--;
            contador++;
        }
        
        return true;
    }
}
