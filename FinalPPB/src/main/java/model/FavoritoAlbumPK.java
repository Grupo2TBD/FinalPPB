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
public class FavoritoAlbumPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_id_user")
    private int usuarioiduser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Album_id_album")
    private int albumidalbum;

    public FavoritoAlbumPK() {
    }

    public FavoritoAlbumPK(int usuarioiduser, int albumidalbum) {
        this.usuarioiduser = usuarioiduser;
        this.albumidalbum = albumidalbum;
    }

    public int getUsuarioiduser() {
        return usuarioiduser;
    }

    public void setUsuarioiduser(int usuarioiduser) {
        this.usuarioiduser = usuarioiduser;
    }

    public int getAlbumidalbum() {
        return albumidalbum;
    }

    public void setAlbumidalbum(int albumidalbum) {
        this.albumidalbum = albumidalbum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioiduser;
        hash += (int) albumidalbum;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavoritoAlbumPK)) {
            return false;
        }
        FavoritoAlbumPK other = (FavoritoAlbumPK) object;
        if (this.usuarioiduser != other.usuarioiduser) {
            return false;
        }
        if (this.albumidalbum != other.albumidalbum) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FavoritoAlbumPK[ usuarioiduser=" + usuarioiduser + ", albumidalbum=" + albumidalbum + " ]";
    }
    
}
