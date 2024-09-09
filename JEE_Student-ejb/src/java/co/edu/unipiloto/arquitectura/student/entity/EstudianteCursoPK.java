/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.student.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Michael
 */
@Embeddable
public class EstudianteCursoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTUDIANTE_ID")
    private int estudianteId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CURSO_ID")
    private String cursoId;

    public EstudianteCursoPK() {
    }

    public EstudianteCursoPK(Integer estudianteId, String cursoId) {
        this.estudianteId = estudianteId;
        this.cursoId = cursoId;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) estudianteId;
        hash += (cursoId != null ? cursoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteCursoPK)) {
            return false;
        }
        EstudianteCursoPK other = (EstudianteCursoPK) object;
        if (this.estudianteId != other.estudianteId) {
            return false;
        }
        if ((this.cursoId == null && other.cursoId != null) || (this.cursoId != null && !this.cursoId.equals(other.cursoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectura.student.entity.EstudianteCursoPK[ estudianteId=" + estudianteId + ", cursoId=" + cursoId + " ]";
    }
    
}
