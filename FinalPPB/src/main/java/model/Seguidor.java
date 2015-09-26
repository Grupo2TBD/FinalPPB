/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "Seguidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguidor.findAll", query = "SELECT s FROM Seguidor s"),
    @NamedQuery(name = "Seguidor.findByUsuarioiduser", query = "SELECT s FROM Seguidor s WHERE s.seguidorPK.usuarioiduser = :usuarioiduser"),
    @NamedQuery(name = "Seguidor.findByUsuarioiduser1", query = "SELECT s FROM Seguidor s WHERE s.seguidorPK.usuarioiduser1 = :usuarioiduser1"),
    @NamedQuery(name = "Seguidor.findByFechaFollow", query = "SELECT s FROM Seguidor s WHERE s.fechaFollow = :fechaFollow")})
public class Seguidor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SeguidorPK seguidorPK;
    @Column(name = "fecha_follow")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFollow;
    @JoinColumn(name = "Usuario_id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "Usuario_id_user1", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public Seguidor() {
    }

    public Seguidor(SeguidorPK seguidorPK) {
        this.seguidorPK = seguidorPK;
    }

    public Seguidor(int usuarioiduser, int usuarioiduser1) {
        this.seguidorPK = new SeguidorPK(usuarioiduser, usuarioiduser1);
    }

    public SeguidorPK getSeguidorPK() {
        return seguidorPK;
    }

    public void setSeguidorPK(SeguidorPK seguidorPK) {
        this.seguidorPK = seguidorPK;
    }

    public Date getFechaFollow() {
        return fechaFollow;
    }

    public void setFechaFollow(Date fechaFollow) {
        this.fechaFollow = fechaFollow;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seguidorPK != null ? seguidorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguidor)) {
            return false;
        }
        Seguidor other = (Seguidor) object;
        if ((this.seguidorPK == null && other.seguidorPK != null) || (this.seguidorPK != null && !this.seguidorPK.equals(other.seguidorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Seguidor[ seguidorPK=" + seguidorPK + " ]";
    }
    
}
