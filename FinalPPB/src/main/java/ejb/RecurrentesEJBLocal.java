/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

/**
 *
 * @author ian
 */

import java.text.ParseException;
import java.util.Date;
import javax.ejb.Local;

@Local
public interface RecurrentesEJBLocal {
    Date FechaAngularToJava(String strFecha)throws ParseException;
    Date fechaActual();
}