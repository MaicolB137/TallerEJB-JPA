/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.student.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Michael
 */
@Entity
@Table(name = "CURSOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c"),
    @NamedQuery(name = "Cursos.findByCodigoCurso", query = "SELECT c FROM Cursos c WHERE c.codigoCurso = :codigoCurso"),
    @NamedQuery(name = "Cursos.findByNombreCurso", query = "SELECT c FROM Cursos c WHERE c.nombreCurso = :nombreCurso"),
    @NamedQuery(name = "Cursos.findByNumeroCreditos", query = "SELECT c FROM Cursos c WHERE c.numeroCreditos = :numeroCreditos"),
    @NamedQuery(name = "Cursos.findBySemestre", query = "SELECT c FROM Cursos c WHERE c.semestre = :semestre"),
    @NamedQuery(name = "Cursos.findByNumeroEstudiantesAdmitidos", query = "SELECT c FROM Cursos c WHERE c.numeroEstudiantesAdmitidos = :numeroEstudiantesAdmitidos")})
public class Cursos implements Serializable {

    @JoinTable(name = "ESTUDIANTE_CURSO", joinColumns = {
        @JoinColumn(name = "CURSO_ID", referencedColumnName = "CODIGO_CURSO")}, inverseJoinColumns = {
        @JoinColumn(name = "ESTUDIANTE_ID", referencedColumnName = "STUDENTID")})
    @ManyToMany
    private Collection<Student> studentCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CODIGO_CURSO")
    private String codigoCurso;
    @Size(max = 100)
    @Column(name = "NOMBRE_CURSO")
    private String nombreCurso;
    @Column(name = "NUMERO_CREDITOS")
    private Integer numeroCreditos;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Column(name = "NUMERO_ESTUDIANTES_ADMITIDOS")
    private Integer numeroEstudiantesAdmitidos;
//    @ManyToMany(mappedBy = "cursosCollection")
//    private Collection<Student> studentCollection;

    public Cursos() {
    }

    public Cursos(String codigoCurso, String nombreCurso, Integer numeroCreditos, Integer semestre, Integer numeroEstudiantesAdmitidos) {
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.numeroCreditos = numeroCreditos;
        this.semestre = semestre;
        this.numeroEstudiantesAdmitidos = numeroEstudiantesAdmitidos;
        
    }

    public Cursos(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getNumeroEstudiantesAdmitidos() {
        return numeroEstudiantesAdmitidos;
    }

    public void setNumeroEstudiantesAdmitidos(Integer numeroEstudiantesAdmitidos) {
        this.numeroEstudiantesAdmitidos = numeroEstudiantesAdmitidos;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCurso != null ? codigoCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.codigoCurso == null && other.codigoCurso != null) || (this.codigoCurso != null && !this.codigoCurso.equals(other.codigoCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectura.student.entity.Cursos[ codigoCurso=" + codigoCurso + " ]";
    }

    
}
