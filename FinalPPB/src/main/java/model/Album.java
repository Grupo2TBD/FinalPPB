/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "Album")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByIdAlbum", query = "SELECT a FROM Album a WHERE a.idAlbum = :idAlbum"),
    @NamedQuery(name = "Album.findByNombreAlbum", query = "SELECT a FROM Album a WHERE a.nombreAlbum = :nombreAlbum"),
    @NamedQuery(name = "Album.findByFechaCreacionAlbum", query = "SELECT a FROM Album a WHERE a.fechaCreacionAlbum = :fechaCreacionAlbum"),
    @NamedQuery(name = "Album.findByDescripcionAlbum", query = "SELECT a FROM Album a WHERE a.descripcionAlbum = :descripcionAlbum"),
    @NamedQuery(name = "Album.findByDireccionFotoPortadaAlbum", query = "SELECT a FROM Album a WHERE a.direccionFotoPortadaAlbum = :direccionFotoPortadaAlbum"),
    @NamedQuery(name = "Album.findByCantidadFotografiasAlbum", query = "SELECT a FROM Album a WHERE a.cantidadFotografiasAlbum = :cantidadFotografiasAlbum"),
    @NamedQuery(name = "Album.findByCantidadFavoritos", query = "SELECT a FROM Album a WHERE a.cantidadFavoritos = :cantidadFavoritos"),
    @NamedQuery(name = "Album.findByUltimaActualizacionAlbum", query = "SELECT a FROM Album a WHERE a.ultimaActualizacionAlbum = :ultimaActualizacionAlbum")})
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_album")
    private Integer idAlbum;
    @Size(max = 45)
    @Column(name = "nombre_album")
    private String nombreAlbum;
    @Column(name = "fecha_creacion_album")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionAlbum;
    @Size(max = 45)
    @Column(name = "descripcion_album")
    private String descripcionAlbum;
    @Size(max = 45)
    @Column(name = "direccion_foto_portada_album")
    private String direccionFotoPortadaAlbum;
    @Column(name = "cantidad_fotografias_album")
    private Integer cantidadFotografiasAlbum;
    @Column(name = "cantidad_favoritos")
    private Integer cantidadFavoritos;
    @Column(name = "ultima_actualizacion_album")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaActualizacionAlbum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private Collection<AlbumFotografia> albumFotografiaCollection;
    @JoinColumn(name = "Usuario_id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private Usuario usuarioiduser;
    @JoinColumn(name = "Permiso_Album_id_permiso_album", referencedColumnName = "id_permiso_album")
    @ManyToOne(optional = false)
    private PermisoAlbum permisoAlbumidpermisoalbum;
    @JoinColumn(name = "Privacidad_id_privacidad", referencedColumnName = "id_privacidad")
    @ManyToOne(optional = false)
    private Privacidad privacidadidprivacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private Collection<FavoritoAlbum> favoritoAlbumCollection;

    public Album() {
    }

    public Album(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public Date getFechaCreacionAlbum() {
        return fechaCreacionAlbum;
    }

    public void setFechaCreacionAlbum(Date fechaCreacionAlbum) {
        this.fechaCreacionAlbum = fechaCreacionAlbum;
    }

    public String getDescripcionAlbum() {
        return descripcionAlbum;
    }

    public void setDescripcionAlbum(String descripcionAlbum) {
        this.descripcionAlbum = descripcionAlbum;
    }

    public String getDireccionFotoPortadaAlbum() {
        return direccionFotoPortadaAlbum;
    }

    public void setDireccionFotoPortadaAlbum(String direccionFotoPortadaAlbum) {
        this.direccionFotoPortadaAlbum = direccionFotoPortadaAlbum;
    }

    public Integer getCantidadFotografiasAlbum() {
        return cantidadFotografiasAlbum;
    }

    public void setCantidadFotografiasAlbum(Integer cantidadFotografiasAlbum) {
        this.cantidadFotografiasAlbum = cantidadFotografiasAlbum;
    }

    public Integer getCantidadFavoritos() {
        return cantidadFavoritos;
    }

    public void setCantidadFavoritos(Integer cantidadFavoritos) {
        this.cantidadFavoritos = cantidadFavoritos;
    }

    public Date getUltimaActualizacionAlbum() {
        return ultimaActualizacionAlbum;
    }

    public void setUltimaActualizacionAlbum(Date ultimaActualizacionAlbum) {
        this.ultimaActualizacionAlbum = ultimaActualizacionAlbum;
    }

    @XmlTransient
    public Collection<AlbumFotografia> getAlbumFotografiaCollection() {
        return albumFotografiaCollection;
    }

    public void setAlbumFotografiaCollection(Collection<AlbumFotografia> albumFotografiaCollection) {
        this.albumFotografiaCollection = albumFotografiaCollection;
    }

    public Usuario getUsuarioiduser() {
        return usuarioiduser;
    }

    public void setUsuarioiduser(Usuario usuarioiduser) {
        this.usuarioiduser = usuarioiduser;
    }

    public PermisoAlbum getPermisoAlbumidpermisoalbum() {
        return permisoAlbumidpermisoalbum;
    }

    public void setPermisoAlbumidpermisoalbum(PermisoAlbum permisoAlbumidpermisoalbum) {
        this.permisoAlbumidpermisoalbum = permisoAlbumidpermisoalbum;
    }

    public Privacidad getPrivacidadidprivacidad() {
        return privacidadidprivacidad;
    }

    public void setPrivacidadidprivacidad(Privacidad privacidadidprivacidad) {
        this.privacidadidprivacidad = privacidadidprivacidad;
    }

    @XmlTransient
    public Collection<FavoritoAlbum> getFavoritoAlbumCollection() {
        return favoritoAlbumCollection;
    }

    public void setFavoritoAlbumCollection(Collection<FavoritoAlbum> favoritoAlbumCollection) {
        this.favoritoAlbumCollection = favoritoAlbumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlbum != null ? idAlbum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.idAlbum == null && other.idAlbum != null) || (this.idAlbum != null && !this.idAlbum.equals(other.idAlbum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Album[ idAlbum=" + idAlbum + " ]";
    }
    
}
