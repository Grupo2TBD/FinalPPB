/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author ian
 */
@Stateless
public class RecurrentesEJB implements RecurrentesEJBLocal{
    public RecurrentesEJB() {
    }
    
    @Override
    public Date FechaAngularToJava(String strFecha) throws ParseException{
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {

            fecha = formatoDelTexto.parse(strFecha);
            strFecha=formatoDeFecha.format(fecha);
        } catch (ParseException ex) {

            ex.printStackTrace();

        } 
        fecha=formatoDeFecha.parse(strFecha);
        return fecha;
    }
    
    @Override
    public Date fechaActual(){
        java.util.Date fecha=new Date();
        return fecha;
    }
   }