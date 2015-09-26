/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "Permiso_Album")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermisoAlbum.findAll", query = "SELECT p FROM PermisoAlbum p"),
    @NamedQuery(name = "PermisoAlbum.findByIdPermisoAlbum", query = "SELECT p FROM PermisoAlbum p WHERE p.idPermisoAlbum = :idPermisoAlbum"),
    @NamedQuery(name = "PermisoAlbum.findByCancommentalbum", query = "SELECT p FROM PermisoAlbum p WHERE p.cancommentalbum = :cancommentalbum"),
    @NamedQuery(name = "PermisoAlbum.findByCanfavoritealbum", query = "SELECT p FROM PermisoAlbum p WHERE p.canfavoritealbum = :canfavoritealbum")})
public class PermisoAlbum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_permiso_album")
    private Integer idPermisoAlbum;
    @Column(name = "cancommentalbum")
    private Boolean cancommentalbum;
    @Column(name = "canfavoritealbum")
    private Boolean canfavoritealbum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permisoAlbumidpermisoalbum")
    private Collection<Album> albumCollection;

    public PermisoAlbum() {
    }

    public PermisoAlbum(Integer idPermisoAlbum) {
        this.idPermisoAlbum = idPermisoAlbum;
    }

    public Integer getIdPermisoAlbum() {
        return idPermisoAlbum;
    }

    public void setIdPermisoAlbum(Integer idPermisoAlbum) {
        this.idPermisoAlbum = idPermisoAlbum;
    }

    public Boolean getCancommentalbum() {
        return cancommentalbum;
    }

    public void setCancommentalbum(Boolean cancommentalbum) {
        this.cancommentalbum = cancommentalbum;
    }

    public Boolean getCanfavoritealbum() {
        return canfavoritealbum;
    }

    public void setCanfavoritealbum(Boolean canfavoritealbum) {
        this.canfavoritealbum = canfavoritealbum;
    }

    @XmlTransient
    public Collection<Album> getAlbumCollection() {
        return albumCollection;
    }

    public void setAlbumCollection(Collection<Album> albumCollection) {
        this.albumCollection = albumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermisoAlbum != null ? idPermisoAlbum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisoAlbum)) {
            return false;
        }
        PermisoAlbum other = (PermisoAlbum) object;
        if ((this.idPermisoAlbum == null && other.idPermisoAlbum != null) || (this.idPermisoAlbum != null && !this.idPermisoAlbum.equals(other.idPermisoAlbum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PermisoAlbum[ idPermisoAlbum=" + idPermisoAlbum + " ]";
    }
    
}
