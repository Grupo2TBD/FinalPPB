/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ian
 */
@Embeddable
public class FavoritoFotografiaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_id_user")
    private int usuarioiduser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fotografia_id_photo")
    private int fotografiaidphoto;

    public FavoritoFotografiaPK() {
    }

    public FavoritoFotografiaPK(int usuarioiduser, int fotografiaidphoto) {
        this.usuarioiduser = usuarioiduser;
        this.fotografiaidphoto = fotografiaidphoto;
    }

    public int getUsuarioiduser() {
        return usuarioiduser;
    }

    public void setUsuarioiduser(int usuarioiduser) {
        this.usuarioiduser = usuarioiduser;
    }

    public int getFotografiaidphoto() {
        return fotografiaidphoto;
    }

    public void setFotografiaidphoto(int fotografiaidphoto) {
        this.fotografiaidphoto = fotografiaidphoto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioiduser;
        hash += (int) fotografiaidphoto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavoritoFotografiaPK)) {
            return false;
        }
        FavoritoFotografiaPK other = (FavoritoFotografiaPK) object;
        if (this.usuarioiduser != other.usuarioiduser) {
            return false;
        }
        if (this.fotografiaidphoto != other.fotografiaidphoto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FavoritoFotografiaPK[ usuarioiduser=" + usuarioiduser + ", fotografiaidphoto=" + fotografiaidphoto + " ]";
    }
    
}
