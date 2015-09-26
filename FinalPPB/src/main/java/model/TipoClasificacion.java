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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "Tipo_Clasificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoClasificacion.findAll", query = "SELECT t FROM TipoClasificacion t"),
    @NamedQuery(name = "TipoClasificacion.findByIdTipoClasificacion", query = "SELECT t FROM TipoClasificacion t WHERE t.idTipoClasificacion = :idTipoClasificacion"),
    @NamedQuery(name = "TipoClasificacion.findByTipoClasificacion", query = "SELECT t FROM TipoClasificacion t WHERE t.tipoClasificacion = :tipoClasificacion")})
public class TipoClasificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_clasificacion")
    private Integer idTipoClasificacion;
    @Size(max = 45)
    @Column(name = "tipo_clasificacion")
    private String tipoClasificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoClasificacionidtipoclasificacion")
    private Collection<ComentarioFotografia> comentarioFotografiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoClasificacionidtipoclasificacion")
    private Collection<Fotografia> fotografiaCollection;

    public TipoClasificacion() {
    }

    public TipoClasificacion(Integer idTipoClasificacion) {
        this.idTipoClasificacion = idTipoClasificacion;
    }

    public Integer getIdTipoClasificacion() {
        return idTipoClasificacion;
    }

    public void setIdTipoClasificacion(Integer idTipoClasificacion) {
        this.idTipoClasificacion = idTipoClasificacion;
    }

    public String getTipoClasificacion() {
        return tipoClasificacion;
    }

    public void setTipoClasificacion(String tipoClasificacion) {
        this.tipoClasificacion = tipoClasificacion;
    }

    @XmlTransient
    public Collection<ComentarioFotografia> getComentarioFotografiaCollection() {
        return comentarioFotografiaCollection;
    }

    public void setComentarioFotografiaCollection(Collection<ComentarioFotografia> comentarioFotografiaCollection) {
        this.comentarioFotografiaCollection = comentarioFotografiaCollection;
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
        hash += (idTipoClasificacion != null ? idTipoClasificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoClasificacion)) {
            return false;
        }
        TipoClasificacion other = (TipoClasificacion) object;
        if ((this.idTipoClasificacion == null && other.idTipoClasificacion != null) || (this.idTipoClasificacion != null && !this.idTipoClasificacion.equals(other.idTipoClasificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TipoClasificacion[ idTipoClasificacion=" + idTipoClasificacion + " ]";
    }
    
}
