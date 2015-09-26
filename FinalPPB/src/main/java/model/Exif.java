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
@Table(name = "Exif")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exif.findAll", query = "SELECT e FROM Exif e"),
    @NamedQuery(name = "Exif.findByIdExif", query = "SELECT e FROM Exif e WHERE e.idExif = :idExif"),
    @NamedQuery(name = "Exif.findByAperturaExif", query = "SELECT e FROM Exif e WHERE e.aperturaExif = :aperturaExif"),
    @NamedQuery(name = "Exif.findByLargoFoco", query = "SELECT e FROM Exif e WHERE e.largoFoco = :largoFoco"),
    @NamedQuery(name = "Exif.findByFlashExif", query = "SELECT e FROM Exif e WHERE e.flashExif = :flashExif")})
public class Exif implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_exif")
    private Integer idExif;
    @Size(max = 20)
    @Column(name = "apertura_exif")
    private String aperturaExif;
    @Size(max = 20)
    @Column(name = "largo_foco")
    private String largoFoco;
    @Column(name = "flash_exif")
    private Boolean flashExif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exifidexif")
    private Collection<Fotografia> fotografiaCollection;

    public Exif() {
    }

    public Exif(Integer idExif) {
        this.idExif = idExif;
    }

    public Integer getIdExif() {
        return idExif;
    }

    public void setIdExif(Integer idExif) {
        this.idExif = idExif;
    }

    public String getAperturaExif() {
        return aperturaExif;
    }

    public void setAperturaExif(String aperturaExif) {
        this.aperturaExif = aperturaExif;
    }

    public String getLargoFoco() {
        return largoFoco;
    }

    public void setLargoFoco(String largoFoco) {
        this.largoFoco = largoFoco;
    }

    public Boolean getFlashExif() {
        return flashExif;
    }

    public void setFlashExif(Boolean flashExif) {
        this.flashExif = flashExif;
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
        hash += (idExif != null ? idExif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exif)) {
            return false;
        }
        Exif other = (Exif) object;
        if ((this.idExif == null && other.idExif != null) || (this.idExif != null && !this.idExif.equals(other.idExif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Exif[ idExif=" + idExif + " ]";
    }
    
}
