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
public class AlbumFotografiaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Album_id_album")
    private int albumidalbum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fotografia_id_photo")
    private int fotografiaidphoto;

    public AlbumFotografiaPK() {
    }

    public AlbumFotografiaPK(int albumidalbum, int fotografiaidphoto) {
        this.albumidalbum = albumidalbum;
        this.fotografiaidphoto = fotografiaidphoto;
    }

    public int getAlbumidalbum() {
        return albumidalbum;
    }

    public void setAlbumidalbum(int albumidalbum) {
        this.albumidalbum = albumidalbum;
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
        hash += (int) albumidalbum;
        hash += (int) fotografiaidphoto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlbumFotografiaPK)) {
            return false;
        }
        AlbumFotografiaPK other = (AlbumFotografiaPK) object;
        if (this.albumidalbum != other.albumidalbum) {
            return false;
        }
        if (this.fotografiaidphoto != other.fotografiaidphoto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AlbumFotografiaPK[ albumidalbum=" + albumidalbum + ", fotografiaidphoto=" + fotografiaidphoto + " ]";
    }
    
}
