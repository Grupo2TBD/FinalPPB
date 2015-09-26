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
import javax.persistence.ManyToMany;
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
@Table(name = "Usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUser", query = "SELECT u FROM Usuario u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "Usuario.findByPassUser", query = "SELECT u FROM Usuario u WHERE u.passUser = :passUser"),
    @NamedQuery(name = "Usuario.findByFechaCreacionCuenta", query = "SELECT u FROM Usuario u WHERE u.fechaCreacionCuenta = :fechaCreacionCuenta"),
    @NamedQuery(name = "Usuario.findByAliasUser", query = "SELECT u FROM Usuario u WHERE u.aliasUser = :aliasUser"),
    @NamedQuery(name = "Usuario.findByNombreRealUser", query = "SELECT u FROM Usuario u WHERE u.nombreRealUser = :nombreRealUser"),
    @NamedQuery(name = "Usuario.findByDireccionFotoPerfilUser", query = "SELECT u FROM Usuario u WHERE u.direccionFotoPerfilUser = :direccionFotoPerfilUser"),
    @NamedQuery(name = "Usuario.findByApellidoUser", query = "SELECT u FROM Usuario u WHERE u.apellidoUser = :apellidoUser"),
    @NamedQuery(name = "Usuario.findBySexoUser", query = "SELECT u FROM Usuario u WHERE u.sexoUser = :sexoUser"),
    @NamedQuery(name = "Usuario.findByDireccionFotoPortadaUser", query = "SELECT u FROM Usuario u WHERE u.direccionFotoPortadaUser = :direccionFotoPortadaUser"),
    @NamedQuery(name = "Usuario.findByFechaCumplea\u00f1osUser", query = "SELECT u FROM Usuario u WHERE u.fechaCumplea\u00f1osUser = :fechaCumplea\u00f1osUser"),
    @NamedQuery(name = "Usuario.findByEmailUser", query = "SELECT u FROM Usuario u WHERE u.emailUser = :emailUser"),
    @NamedQuery(name = "Usuario.findByFechaUltimaActualizacion", query = "SELECT u FROM Usuario u WHERE u.fechaUltimaActualizacion = :fechaUltimaActualizacion"),
    @NamedQuery(name = "Usuario.findByCantidadFotografiasSubidas", query = "SELECT u FROM Usuario u WHERE u.cantidadFotografiasSubidas = :cantidadFotografiasSubidas"),
    @NamedQuery(name = "Usuario.findByCantidadAlbumesCreados", query = "SELECT u FROM Usuario u WHERE u.cantidadAlbumesCreados = :cantidadAlbumesCreados"),
    @NamedQuery(name = "Usuario.findByCantidadSeguidores", query = "SELECT u FROM Usuario u WHERE u.cantidadSeguidores = :cantidadSeguidores"),
    @NamedQuery(name = "Usuario.findByCantidadSeguidos", query = "SELECT u FROM Usuario u WHERE u.cantidadSeguidos = :cantidadSeguidos")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer idUser;
    @Size(max = 45)
    @Column(name = "pass_user")
    private String passUser;
    @Column(name = "fecha_creacion_cuenta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionCuenta;
    @Size(max = 45)
    @Column(name = "alias_user")
    private String aliasUser;
    @Size(max = 45)
    @Column(name = "nombre_real_user")
    private String nombreRealUser;
    @Size(max = 50)
    @Column(name = "direccion_foto_perfil_user")
    private String direccionFotoPerfilUser;
    @Size(max = 45)
    @Column(name = "apellido_user")
    private String apellidoUser;
    @Size(max = 10)
    @Column(name = "sexo_user")
    private String sexoUser;
    @Size(max = 45)
    @Column(name = "direccion_foto_portada_user")
    private String direccionFotoPortadaUser;
    @Column(name = "fecha_cumplea\u00f1os_user")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCumpleañosUser;
    @Size(max = 45)
    @Column(name = "email_user")
    private String emailUser;
    @Column(name = "fecha_ultima_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaActualizacion;
    @Column(name = "cantidad_fotografias_subidas")
    private Integer cantidadFotografiasSubidas;
    @Column(name = "cantidad_albumes_creados")
    private Integer cantidadAlbumesCreados;
    @Column(name = "cantidad_seguidores")
    private Integer cantidadSeguidores;
    @Column(name = "cantidad_seguidos")
    private Integer cantidadSeguidos;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Fotografia> fotografiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Seguidor> seguidorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario1")
    private Collection<Seguidor> seguidorCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioiduser")
    private Collection<ComentarioFotografia> comentarioFotografiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioiduser")
    private Collection<Album> albumCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<FavoritoFotografia> favoritoFotografiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<FavoritoAlbum> favoritoAlbumCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioiduser")
    private Collection<Fotografia> fotografiaCollection1;

    public Usuario() {
    }

    public Usuario(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public Date getFechaCreacionCuenta() {
        return fechaCreacionCuenta;
    }

    public void setFechaCreacionCuenta(Date fechaCreacionCuenta) {
        this.fechaCreacionCuenta = fechaCreacionCuenta;
    }

    public String getAliasUser() {
        return aliasUser;
    }

    public void setAliasUser(String aliasUser) {
        this.aliasUser = aliasUser;
    }

    public String getNombreRealUser() {
        return nombreRealUser;
    }

    public void setNombreRealUser(String nombreRealUser) {
        this.nombreRealUser = nombreRealUser;
    }

    public String getDireccionFotoPerfilUser() {
        return direccionFotoPerfilUser;
    }

    public void setDireccionFotoPerfilUser(String direccionFotoPerfilUser) {
        this.direccionFotoPerfilUser = direccionFotoPerfilUser;
    }

    public String getApellidoUser() {
        return apellidoUser;
    }

    public void setApellidoUser(String apellidoUser) {
        this.apellidoUser = apellidoUser;
    }

    public String getSexoUser() {
        return sexoUser;
    }

    public void setSexoUser(String sexoUser) {
        this.sexoUser = sexoUser;
    }

    public String getDireccionFotoPortadaUser() {
        return direccionFotoPortadaUser;
    }

    public void setDireccionFotoPortadaUser(String direccionFotoPortadaUser) {
        this.direccionFotoPortadaUser = direccionFotoPortadaUser;
    }

    public Date getFechaCumpleañosUser() {
        return fechaCumpleañosUser;
    }

    public void setFechaCumpleañosUser(Date fechaCumpleañosUser) {
        this.fechaCumpleañosUser = fechaCumpleañosUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Date getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public Integer getCantidadFotografiasSubidas() {
        return cantidadFotografiasSubidas;
    }

    public void setCantidadFotografiasSubidas(Integer cantidadFotografiasSubidas) {
        this.cantidadFotografiasSubidas = cantidadFotografiasSubidas;
    }

    public Integer getCantidadAlbumesCreados() {
        return cantidadAlbumesCreados;
    }

    public void setCantidadAlbumesCreados(Integer cantidadAlbumesCreados) {
        this.cantidadAlbumesCreados = cantidadAlbumesCreados;
    }

    public Integer getCantidadSeguidores() {
        return cantidadSeguidores;
    }

    public void setCantidadSeguidores(Integer cantidadSeguidores) {
        this.cantidadSeguidores = cantidadSeguidores;
    }

    public Integer getCantidadSeguidos() {
        return cantidadSeguidos;
    }

    public void setCantidadSeguidos(Integer cantidadSeguidos) {
        this.cantidadSeguidos = cantidadSeguidos;
    }

    @XmlTransient
    public Collection<Fotografia> getFotografiaCollection() {
        return fotografiaCollection;
    }

    public void setFotografiaCollection(Collection<Fotografia> fotografiaCollection) {
        this.fotografiaCollection = fotografiaCollection;
    }

    @XmlTransient
    public Collection<Seguidor> getSeguidorCollection() {
        return seguidorCollection;
    }

    public void setSeguidorCollection(Collection<Seguidor> seguidorCollection) {
        this.seguidorCollection = seguidorCollection;
    }

    @XmlTransient
    public Collection<Seguidor> getSeguidorCollection1() {
        return seguidorCollection1;
    }

    public void setSeguidorCollection1(Collection<Seguidor> seguidorCollection1) {
        this.seguidorCollection1 = seguidorCollection1;
    }

    @XmlTransient
    public Collection<ComentarioFotografia> getComentarioFotografiaCollection() {
        return comentarioFotografiaCollection;
    }

    public void setComentarioFotografiaCollection(Collection<ComentarioFotografia> comentarioFotografiaCollection) {
        this.comentarioFotografiaCollection = comentarioFotografiaCollection;
    }

    @XmlTransient
    public Collection<Album> getAlbumCollection() {
        return albumCollection;
    }

    public void setAlbumCollection(Collection<Album> albumCollection) {
        this.albumCollection = albumCollection;
    }

    @XmlTransient
    public Collection<FavoritoFotografia> getFavoritoFotografiaCollection() {
        return favoritoFotografiaCollection;
    }

    public void setFavoritoFotografiaCollection(Collection<FavoritoFotografia> favoritoFotografiaCollection) {
        this.favoritoFotografiaCollection = favoritoFotografiaCollection;
    }

    @XmlTransient
    public Collection<FavoritoAlbum> getFavoritoAlbumCollection() {
        return favoritoAlbumCollection;
    }

    public void setFavoritoAlbumCollection(Collection<FavoritoAlbum> favoritoAlbumCollection) {
        this.favoritoAlbumCollection = favoritoAlbumCollection;
    }

    @XmlTransient
    public Collection<Fotografia> getFotografiaCollection1() {
        return fotografiaCollection1;
    }

    public void setFotografiaCollection1(Collection<Fotografia> fotografiaCollection1) {
        this.fotografiaCollection1 = fotografiaCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Usuario[ idUser=" + idUser + " ]";
    }
    
}
