/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ian
 */
@Entity
@Table(name = "Mapa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mapa.findAll", query = "SELECT m FROM Mapa m"),
    @NamedQuery(name = "Mapa.findByIdMapa", query = "SELECT m FROM Mapa m WHERE m.idMapa = :idMapa"),
    @NamedQuery(name = "Mapa.findByNombrePais", query = "SELECT m FROM Mapa m WHERE m.nombrePais = :nombrePais"),
    @NamedQuery(name = "Mapa.findByCoordenadas", query = "SELECT m FROM Mapa m WHERE m.coordenadas = :coordenadas")})
public class Mapa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mapa")
    private Integer idMapa;
    @Size(max = 45)
    @Column(name = "nombre_pais")
    private String nombrePais;
    @Size(max = 8000)
    @Column(name = "coordenadas")
    private String coordenadas;

    public Mapa() {
    }

    public Mapa(Integer idMapa) {
        this.idMapa = idMapa;
    }

    public Integer getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(Integer idMapa) {
        this.idMapa = idMapa;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMapa != null ? idMapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mapa)) {
            return false;
        }
        Mapa other = (Mapa) object;
        if ((this.idMapa == null && other.idMapa != null) || (this.idMapa != null && !this.idMapa.equals(other.idMapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mapa[ idMapa=" + idMapa + " ]";
    }
    
}
