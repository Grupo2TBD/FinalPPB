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
@Table(name = "Camara")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camara.findAll", query = "SELECT c FROM Camara c"),
    @NamedQuery(name = "Camara.findByIdCamara", query = "SELECT c FROM Camara c WHERE c.idCamara = :idCamara"),
    @NamedQuery(name = "Camara.findByMegapixelesCamara", query = "SELECT c FROM Camara c WHERE c.megapixelesCamara = :megapixelesCamara"),
    @NamedQuery(name = "Camara.findByZoomCamara", query = "SELECT c FROM Camara c WHERE c.zoomCamara = :zoomCamara"),
    @NamedQuery(name = "Camara.findByTamanoPantallaCamara", query = "SELECT c FROM Camara c WHERE c.tamanoPantallaCamara = :tamanoPantallaCamara"),
    @NamedQuery(name = "Camara.findByNombreCamara", query = "SELECT c FROM Camara c WHERE c.nombreCamara = :nombreCamara"),
    @NamedQuery(name = "Camara.findByPesoCamara", query = "SELECT c FROM Camara c WHERE c.pesoCamara = :pesoCamara"),
    @NamedQuery(name = "Camara.findByCantidadFotografiasCamara", query = "SELECT c FROM Camara c WHERE c.cantidadFotografiasCamara = :cantidadFotografiasCamara"),
    @NamedQuery(name = "Camara.findByMarcaCamara", query = "SELECT c FROM Camara c WHERE c.marcaCamara = :marcaCamara"),
    @NamedQuery(name = "Camara.findByDireccionImagenCamara", query = "SELECT c FROM Camara c WHERE c.direccionImagenCamara = :direccionImagenCamara")})
public class Camara implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_camara")
    private Integer idCamara;
    @Size(max = 20)
    @Column(name = "megapixeles_camara")
    private String megapixelesCamara;
    @Size(max = 20)
    @Column(name = "zoom_camara")
    private String zoomCamara;
    @Size(max = 20)
    @Column(name = "tamano_pantalla_camara")
    private String tamanoPantallaCamara;
    @Size(max = 20)
    @Column(name = "nombre_camara")
    private String nombreCamara;
    @Size(max = 10)
    @Column(name = "peso_camara")
    private String pesoCamara;
    @Column(name = "cantidad_fotografias_camara")
    private Integer cantidadFotografiasCamara;
    @Size(max = 20)
    @Column(name = "marca_camara")
    private String marcaCamara;
    @Size(max = 50)
    @Column(name = "direccion_imagen_camara")
    private String direccionImagenCamara;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camaraidcamara")
    private Collection<Fotografia> fotografiaCollection;

    public Camara() {
    }

    public Camara(Integer idCamara) {
        this.idCamara = idCamara;
    }

    public Integer getIdCamara() {
        return idCamara;
    }

    public void setIdCamara(Integer idCamara) {
        this.idCamara = idCamara;
    }

    public String getMegapixelesCamara() {
        return megapixelesCamara;
    }

    public void setMegapixelesCamara(String megapixelesCamara) {
        this.megapixelesCamara = megapixelesCamara;
    }

    public String getZoomCamara() {
        return zoomCamara;
    }

    public void setZoomCamara(String zoomCamara) {
        this.zoomCamara = zoomCamara;
    }

    public String getTamanoPantallaCamara() {
        return tamanoPantallaCamara;
    }

    public void setTamanoPantallaCamara(String tamanoPantallaCamara) {
        this.tamanoPantallaCamara = tamanoPantallaCamara;
    }

    public String getNombreCamara() {
        return nombreCamara;
    }

    public void setNombreCamara(String nombreCamara) {
        this.nombreCamara = nombreCamara;
    }

    public String getPesoCamara() {
        return pesoCamara;
    }

    public void setPesoCamara(String pesoCamara) {
        this.pesoCamara = pesoCamara;
    }

    public Integer getCantidadFotografiasCamara() {
        return cantidadFotografiasCamara;
    }

    public void setCantidadFotografiasCamara(Integer cantidadFotografiasCamara) {
        this.cantidadFotografiasCamara = cantidadFotografiasCamara;
    }

    public String getMarcaCamara() {
        return marcaCamara;
    }

    public void setMarcaCamara(String marcaCamara) {
        this.marcaCamara = marcaCamara;
    }

    public String getDireccionImagenCamara() {
        return direccionImagenCamara;
    }

    public void setDireccionImagenCamara(String direccionImagenCamara) {
        this.direccionImagenCamara = direccionImagenCamara;
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
        hash += (idCamara != null ? idCamara.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camara)) {
            return false;
        }
        Camara other = (Camara) object;
        if ((this.idCamara == null && other.idCamara != null) || (this.idCamara != null && !this.idCamara.equals(other.idCamara))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Camara[ idCamara=" + idCamara + " ]";
    }
    
}
