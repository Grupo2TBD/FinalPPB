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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "Fotografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fotografia.findAll", query = "SELECT f FROM Fotografia f"),
    @NamedQuery(name = "Fotografia.findByIdPhoto", query = "SELECT f FROM Fotografia f WHERE f.idPhoto = :idPhoto"),
    @NamedQuery(name = "Fotografia.findByFechaSubidaPhoto", query = "SELECT f FROM Fotografia f WHERE f.fechaSubidaPhoto = :fechaSubidaPhoto"),
    @NamedQuery(name = "Fotografia.findByFechaTomadaPhoto", query = "SELECT f FROM Fotografia f WHERE f.fechaTomadaPhoto = :fechaTomadaPhoto"),
    @NamedQuery(name = "Fotografia.findByCantidadVisitasPhoto", query = "SELECT f FROM Fotografia f WHERE f.cantidadVisitasPhoto = :cantidadVisitasPhoto"),
    @NamedQuery(name = "Fotografia.findByTituloPhoto", query = "SELECT f FROM Fotografia f WHERE f.tituloPhoto = :tituloPhoto"),
    @NamedQuery(name = "Fotografia.findByDescripcionPhoto", query = "SELECT f FROM Fotografia f WHERE f.descripcionPhoto = :descripcionPhoto"),
    @NamedQuery(name = "Fotografia.findByCantidadFavoritosPhoto", query = "SELECT f FROM Fotografia f WHERE f.cantidadFavoritosPhoto = :cantidadFavoritosPhoto"),
    @NamedQuery(name = "Fotografia.findByFormatoPhoto", query = "SELECT f FROM Fotografia f WHERE f.formatoPhoto = :formatoPhoto"),
    @NamedQuery(name = "Fotografia.findByDireccionFisicaPhoto", query = "SELECT f FROM Fotografia f WHERE f.direccionFisicaPhoto = :direccionFisicaPhoto"),
    @NamedQuery(name = "Fotografia.findByUltimaActualizacionPhoto", query = "SELECT f FROM Fotografia f WHERE f.ultimaActualizacionPhoto = :ultimaActualizacionPhoto"),
    @NamedQuery(name = "Fotografia.findByCantidadDescargas", query = "SELECT f FROM Fotografia f WHERE f.cantidadDescargas = :cantidadDescargas"),
    @NamedQuery(name = "Fotografia.findByCantidadComentarios", query = "SELECT f FROM Fotografia f WHERE f.cantidadComentarios = :cantidadComentarios"),
    @NamedQuery(name = "Fotografia.findByCantidadComentariosPositivos", query = "SELECT f FROM Fotografia f WHERE f.cantidadComentariosPositivos = :cantidadComentariosPositivos"),
    @NamedQuery(name = "Fotografia.findByCantidadComentariosNegativos", query = "SELECT f FROM Fotografia f WHERE f.cantidadComentariosNegativos = :cantidadComentariosNegativos"),
    @NamedQuery(name = "Fotografia.findByCantidadComentariosNeutros", query = "SELECT f FROM Fotografia f WHERE f.cantidadComentariosNeutros = :cantidadComentariosNeutros"),
    @NamedQuery(name = "Fotografia.findByPunto", query = "SELECT f FROM Fotografia f WHERE f.punto = :punto")})
public class Fotografia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_photo")
    private Integer idPhoto;
    @Column(name = "fecha_subida_photo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSubidaPhoto;
    @Column(name = "fecha_tomada_photo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTomadaPhoto;
    @Column(name = "cantidad_visitas_photo")
    private Integer cantidadVisitasPhoto;
    @Size(max = 45)
    @Column(name = "titulo_photo")
    private String tituloPhoto;
    @Size(max = 45)
    @Column(name = "descripcion_photo")
    private String descripcionPhoto;
    @Column(name = "cantidad_favoritos_photo")
    private Integer cantidadFavoritosPhoto;
    @Size(max = 45)
    @Column(name = "formato_photo")
    private String formatoPhoto;
    @Size(max = 45)
    @Column(name = "direccion_fisica_photo")
    private String direccionFisicaPhoto;
    @Column(name = "ultima_actualizacion_photo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaActualizacionPhoto;
    @Column(name = "cantidad_descargas")
    private Integer cantidadDescargas;
    @Column(name = "cantidad_comentarios")
    private Integer cantidadComentarios;
    @Column(name = "cantidad_comentarios_positivos")
    private Integer cantidadComentariosPositivos;
    @Column(name = "cantidad_comentarios_negativos")
    private Integer cantidadComentariosNegativos;
    @Column(name = "cantidad_comentarios_neutros")
    private Integer cantidadComentariosNeutros;
    @Size(max = 50)
    @Column(name = "punto")
    private String punto;
    @JoinTable(name = "Fotografia_Tag", joinColumns = {
        @JoinColumn(name = "Fotografia_id_photo", referencedColumnName = "id_photo")}, inverseJoinColumns = {
        @JoinColumn(name = "Tag_id_tag", referencedColumnName = "id_tag")})
    @ManyToMany
    private Collection<Tag> tagCollection;
    @JoinTable(name = "Etiqueta_Usuario", joinColumns = {
        @JoinColumn(name = "Fotografia_id_photo", referencedColumnName = "id_photo")}, inverseJoinColumns = {
        @JoinColumn(name = "Usuario_id_user", referencedColumnName = "id_user")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fotografia")
    private Collection<AlbumFotografia> albumFotografiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fotografiaidphoto")
    private Collection<ComentarioFotografia> comentarioFotografiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fotografia")
    private Collection<FavoritoFotografia> favoritoFotografiaCollection;
    @JoinColumn(name = "Exif_id_exif", referencedColumnName = "id_exif")
    @ManyToOne(optional = false)
    private Exif exifidexif;
    @JoinColumn(name = "Camara_id_camara", referencedColumnName = "id_camara")
    @ManyToOne(optional = false)
    private Camara camaraidcamara;
    @JoinColumn(name = "Usuario_id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private Usuario usuarioiduser;
    @JoinColumn(name = "Privacidad_id_privacidad", referencedColumnName = "id_privacidad")
    @ManyToOne(optional = false)
    private Privacidad privacidadidprivacidad;
    @JoinColumn(name = "Permiso_Fotografia_id_permiso_fotografia", referencedColumnName = "id_permiso_fotografia")
    @ManyToOne(optional = false)
    private PermisoFotografia permisoFotografiaidpermisofotografia;
    @JoinColumn(name = "Tipo_Clasificacion_id_tipo_clasificacion", referencedColumnName = "id_tipo_clasificacion")
    @ManyToOne(optional = false)
    private TipoClasificacion tipoClasificacionidtipoclasificacion;

    public Fotografia() {
    }

    public Fotografia(Integer idPhoto) {
        this.idPhoto = idPhoto;
    }

    public Integer getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(Integer idPhoto) {
        this.idPhoto = idPhoto;
    }

    public Date getFechaSubidaPhoto() {
        return fechaSubidaPhoto;
    }

    public void setFechaSubidaPhoto(Date fechaSubidaPhoto) {
        this.fechaSubidaPhoto = fechaSubidaPhoto;
    }

    public Date getFechaTomadaPhoto() {
        return fechaTomadaPhoto;
    }

    public void setFechaTomadaPhoto(Date fechaTomadaPhoto) {
        this.fechaTomadaPhoto = fechaTomadaPhoto;
    }

    public Integer getCantidadVisitasPhoto() {
        return cantidadVisitasPhoto;
    }

    public void setCantidadVisitasPhoto(Integer cantidadVisitasPhoto) {
        this.cantidadVisitasPhoto = cantidadVisitasPhoto;
    }

    public String getTituloPhoto() {
        return tituloPhoto;
    }

    public void setTituloPhoto(String tituloPhoto) {
        this.tituloPhoto = tituloPhoto;
    }

    public String getDescripcionPhoto() {
        return descripcionPhoto;
    }

    public void setDescripcionPhoto(String descripcionPhoto) {
        this.descripcionPhoto = descripcionPhoto;
    }

    public Integer getCantidadFavoritosPhoto() {
        return cantidadFavoritosPhoto;
    }

    public void setCantidadFavoritosPhoto(Integer cantidadFavoritosPhoto) {
        this.cantidadFavoritosPhoto = cantidadFavoritosPhoto;
    }

    public String getFormatoPhoto() {
        return formatoPhoto;
    }

    public void setFormatoPhoto(String formatoPhoto) {
        this.formatoPhoto = formatoPhoto;
    }

    public String getDireccionFisicaPhoto() {
        return direccionFisicaPhoto;
    }

    public void setDireccionFisicaPhoto(String direccionFisicaPhoto) {
        this.direccionFisicaPhoto = direccionFisicaPhoto;
    }

    public Date getUltimaActualizacionPhoto() {
        return ultimaActualizacionPhoto;
    }

    public void setUltimaActualizacionPhoto(Date ultimaActualizacionPhoto) {
        this.ultimaActualizacionPhoto = ultimaActualizacionPhoto;
    }

    public Integer getCantidadDescargas() {
        return cantidadDescargas;
    }

    public void setCantidadDescargas(Integer cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }

    public Integer getCantidadComentarios() {
        return cantidadComentarios;
    }

    public void setCantidadComentarios(Integer cantidadComentarios) {
        this.cantidadComentarios = cantidadComentarios;
    }

    public Integer getCantidadComentariosPositivos() {
        return cantidadComentariosPositivos;
    }

    public void setCantidadComentariosPositivos(Integer cantidadComentariosPositivos) {
        this.cantidadComentariosPositivos = cantidadComentariosPositivos;
    }

    public Integer getCantidadComentariosNegativos() {
        return cantidadComentariosNegativos;
    }

    public void setCantidadComentariosNegativos(Integer cantidadComentariosNegativos) {
        this.cantidadComentariosNegativos = cantidadComentariosNegativos;
    }

    public Integer getCantidadComentariosNeutros() {
        return cantidadComentariosNeutros;
    }

    public void setCantidadComentariosNeutros(Integer cantidadComentariosNeutros) {
        this.cantidadComentariosNeutros = cantidadComentariosNeutros;
    }

    public String getPunto() {
        return punto;
    }

    public void setPunto(String punto) {
        this.punto = punto;
    }

    @XmlTransient
    public Collection<Tag> getTagCollection() {
        return tagCollection;
    }

    public void setTagCollection(Collection<Tag> tagCollection) {
        this.tagCollection = tagCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<AlbumFotografia> getAlbumFotografiaCollection() {
        return albumFotografiaCollection;
    }

    public void setAlbumFotografiaCollection(Collection<AlbumFotografia> albumFotografiaCollection) {
        this.albumFotografiaCollection = albumFotografiaCollection;
    }

    @XmlTransient
    public Collection<ComentarioFotografia> getComentarioFotografiaCollection() {
        return comentarioFotografiaCollection;
    }

    public void setComentarioFotografiaCollection(Collection<ComentarioFotografia> comentarioFotografiaCollection) {
        this.comentarioFotografiaCollection = comentarioFotografiaCollection;
    }

    @XmlTransient
    public Collection<FavoritoFotografia> getFavoritoFotografiaCollection() {
        return favoritoFotografiaCollection;
    }

    public void setFavoritoFotografiaCollection(Collection<FavoritoFotografia> favoritoFotografiaCollection) {
        this.favoritoFotografiaCollection = favoritoFotografiaCollection;
    }

    public Exif getExifidexif() {
        return exifidexif;
    }

    public void setExifidexif(Exif exifidexif) {
        this.exifidexif = exifidexif;
    }

    public Camara getCamaraidcamara() {
        return camaraidcamara;
    }

    public void setCamaraidcamara(Camara camaraidcamara) {
        this.camaraidcamara = camaraidcamara;
    }

    public Usuario getUsuarioiduser() {
        return usuarioiduser;
    }

    public void setUsuarioiduser(Usuario usuarioiduser) {
        this.usuarioiduser = usuarioiduser;
    }

    public Privacidad getPrivacidadidprivacidad() {
        return privacidadidprivacidad;
    }

    public void setPrivacidadidprivacidad(Privacidad privacidadidprivacidad) {
        this.privacidadidprivacidad = privacidadidprivacidad;
    }

    public PermisoFotografia getPermisoFotografiaidpermisofotografia() {
        return permisoFotografiaidpermisofotografia;
    }

    public void setPermisoFotografiaidpermisofotografia(PermisoFotografia permisoFotografiaidpermisofotografia) {
        this.permisoFotografiaidpermisofotografia = permisoFotografiaidpermisofotografia;
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
        hash += (idPhoto != null ? idPhoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fotografia)) {
            return false;
        }
        Fotografia other = (Fotografia) object;
        if ((this.idPhoto == null && other.idPhoto != null) || (this.idPhoto != null && !this.idPhoto.equals(other.idPhoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fotografia[ idPhoto=" + idPhoto + " ]";
    }
    
}
