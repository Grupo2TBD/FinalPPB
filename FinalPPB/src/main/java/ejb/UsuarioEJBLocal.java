/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Usuario;

/**
 *
 * @author ian
 */
@Local
public interface UsuarioEJBLocal {
    String Login(Usuario user);
    Usuario sendInfo(Usuario user);
    boolean editarPerfil(Usuario user);
    List<Usuario> usuarios();
    boolean verifica(Usuario user);
    void insertData(Usuario user);
    Usuario findByAlias(String alias);
}
