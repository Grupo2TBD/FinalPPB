/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ian
 */
@Embeddable
public class SeguidorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_id_user")
    private int usuarioiduser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_id_user1")
    private int usuarioiduser1;

    public SeguidorPK() {
    }

    public SeguidorPK(int usuarioiduser, int usuarioiduser1) {
        this.usuarioiduser = usuarioiduser;
        this.usuarioiduser1 = usuarioiduser1;
    }

    public int getUsuarioiduser() {
        return usuarioiduser;
    }

    public void setUsuarioiduser(int usuarioiduser) {
        this.usuarioiduser = usuarioiduser;
    }

    public int getUsuarioiduser1() {
        return usuarioiduser1;
    }

    public void setUsuarioiduser1(int usuarioiduser1) {
        this.usuarioiduser1 = usuarioiduser1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioiduser;
        hash += (int) usuarioiduser1;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguidorPK)) {
            return false;
        }
        SeguidorPK other = (SeguidorPK) object;
        if (this.usuarioiduser != other.usuarioiduser) {
            return false;
        }
        if (this.usuarioiduser1 != other.usuarioiduser1) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SeguidorPK[ usuarioiduser=" + usuarioiduser + ", usuarioiduser1=" + usuarioiduser1 + " ]";
    }
    
}
