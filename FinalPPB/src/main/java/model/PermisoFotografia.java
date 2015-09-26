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
@Table(name = "Permiso_Fotografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermisoFotografia.findAll", query = "SELECT p FROM PermisoFotografia p"),
    @NamedQuery(name = "PermisoFotografia.findByIdPermisoFotografia", query = "SELECT p FROM PermisoFotografia p WHERE p.idPermisoFotografia = :idPermisoFotografia"),
    @NamedQuery(name = "PermisoFotografia.findByCancommentphoto", query = "SELECT p FROM PermisoFotografia p WHERE p.cancommentphoto = :cancommentphoto"),
    @NamedQuery(name = "PermisoFotografia.findByCandownloadphoto", query = "SELECT p FROM PermisoFotografia p WHERE p.candownloadphoto = :candownloadphoto"),
    @NamedQuery(name = "PermisoFotografia.findByCanfavoritephoto", query = "SELECT p FROM PermisoFotografia p WHERE p.canfavoritephoto = :canfavoritephoto")})
public class PermisoFotografia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_permiso_fotografia")
    private Integer idPermisoFotografia;
    @Column(name = "cancommentphoto")
    private Boolean cancommentphoto;
    @Column(name = "candownloadphoto")
    private Boolean candownloadphoto;
    @Column(name = "canfavoritephoto")
    private Boolean canfavoritephoto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permisoFotografiaidpermisofotografia")
    private Collection<Fotografia> fotografiaCollection;

    public PermisoFotografia() {
    }

    public PermisoFotografia(Integer idPermisoFotografia) {
        this.idPermisoFotografia = idPermisoFotografia;
    }

    public Integer getIdPermisoFotografia() {
        return idPermisoFotografia;
    }

    public void setIdPermisoFotografia(Integer idPermisoFotografia) {
        this.idPermisoFotografia = idPermisoFotografia;
    }

    public Boolean getCancommentphoto() {
        return cancommentphoto;
    }

    public void setCancommentphoto(Boolean cancommentphoto) {
        this.cancommentphoto = cancommentphoto;
    }

    public Boolean getCandownloadphoto() {
        return candownloadphoto;
    }

    public void setCandownloadphoto(Boolean candownloadphoto) {
        this.candownloadphoto = candownloadphoto;
    }

    public Boolean getCanfavoritephoto() {
        return canfavoritephoto;
    }

    public void setCanfavoritephoto(Boolean canfavoritephoto) {
        this.canfavoritephoto = canfavoritephoto;
    }

    @XmlTransient
    public Collection<Fotografia> getFotografiaCollection() {
        return fotografiaCollection;
    }

    public void setFotografiaCollection(Collection<Fotografia> fotografiaCollection) {
        this.fotografiaCollection = fotografiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermisoFotografia != null ? idPermisoFotografia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisoFotografia)) {
            return false;
        }
        PermisoFotografia other = (PermisoFotografia) object;
        if ((this.idPermisoFotografia == null && other.idPermisoFotografia != null) || (this.idPermisoFotografia != null && !this.idPermisoFotografia.equals(other.idPermisoFotografia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PermisoFotografia[ idPermisoFotografia=" + idPermisoFotografia + " ]";
    }
    
}
