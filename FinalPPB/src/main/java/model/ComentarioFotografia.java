/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "Comentario_Fotografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComentarioFotografia.findAll", query = "SELECT c FROM ComentarioFotografia c"),
    @NamedQuery(name = "ComentarioFotografia.findByIdComentarioPhoto", query = "SELECT c FROM ComentarioFotografia c WHERE c.idComentarioPhoto = :idComentarioPhoto"),
    @NamedQuery(name = "ComentarioFotografia.findByDescripcionComentario", query = "SELECT c FROM ComentarioFotografia c WHERE c.descripcionComentario = :descripcionComentario"),
    @NamedQuery(name = "ComentarioFotografia.findByFechaPublicacionComentario", query = "SELECT c FROM ComentarioFotografia c WHERE c.fechaPublicacionComentario = :fechaPublicacionComentario")})
public class ComentarioFotografia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comentario_photo")
    private Integer idComentarioPhoto;
    @Size(max = 150)
    @Column(name = "descripcion_comentario")
    private String descripcionComentario;
    @Column(name = "fecha_publicacion_comentario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacionComentario;
    @JoinColumn(name = "Usuario_id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private Usuario usuarioiduser;
    @JoinColumn(name = "Fotografia_id_photo", referencedColumnName = "id_photo")
    @ManyToOne(optional = false)
    private Fotografia fotografiaidphoto;
    @JoinColumn(name = "Tipo_Clasificacion_id_tipo_clasificacion", referencedColumnName = "id_tipo_clasificacion")
    @ManyToOne(optional = false)
    private TipoClasificacion tipoClasificacionidtipoclasificacion;

    public ComentarioFotografia() {
    }

    public ComentarioFotografia(Integer idComentarioPhoto) {
        this.idComentarioPhoto = idComentarioPhoto;
    }

    public Integer getIdComentarioPhoto() {
        return idComentarioPhoto;
    }

    public void setIdComentarioPhoto(Integer idComentarioPhoto) {
        this.idComentarioPhoto = idComentarioPhoto;
    }

    public String getDescripcionComentario() {
        return descripcionComentario;
    }

    public void setDescripcionComentario(String descripcionComentario) {
        this.descripcionComentario = descripcionComentario;
    }

    public Date getFechaPublicacionComentario() {
        return fechaPublicacionComentario;
    }

    public void setFechaPublicacionComentario(Date fechaPublicacionComentario) {
        this.fechaPublicacionComentario = fechaPublicacionComentario;
    }

    public Usuario getUsuarioiduser() {
        return usuarioiduser;
    }

    public void setUsuarioiduser(Usuario usuarioiduser) {
        this.usuarioiduser = usuarioiduser;
    }

    public Fotografia getFotografiaidphoto() {
        return fotografiaidphoto;
    }

    public void setFotografiaidphoto(Fotografia fotografiaidphoto) {
        this.fotografiaidphoto = fotografiaidphoto;
    }

    public TipoClasificacion getTipoClasificacionidtipoclasificacion() {
        return tipoClasificacionidtipoclasificacion;
    }

    public void setTipoClasificacionidtipoclasificacion(TipoClasificacion tipoClasificacionidtipoclasificacion) {
        this.tipoClasificacionidtipoclasificacion = tipoClasificacionidtipoclasificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentarioPhoto != null ? idComentarioPhoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioFotografia)) {
            return false;
        }
        ComentarioFotografia other = (ComentarioFotografia) object;
        if ((this.idComentarioPhoto == null && other.idComentarioPhoto != null) || (this.idComentarioPhoto != null && !this.idComentarioPhoto.equals(other.idComentarioPhoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ComentarioFotografia[ idComentarioPhoto=" + idComentarioPhoto + " ]";
    }
    
}
