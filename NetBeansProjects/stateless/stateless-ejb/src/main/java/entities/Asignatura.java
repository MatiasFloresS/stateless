/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author matias
 */
@Entity
@Table(name = "asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a"),
    @NamedQuery(name = "Asignatura.findByIdAsignatura", query = "SELECT a FROM Asignatura a WHERE a.idAsignatura = :idAsignatura"),
    @NamedQuery(name = "Asignatura.findByNombreAsignatura", query = "SELECT a FROM Asignatura a WHERE a.nombreAsignatura = :nombreAsignatura"),
    @NamedQuery(name = "Asignatura.findBySctAsignatura", query = "SELECT a FROM Asignatura a WHERE a.sctAsignatura = :sctAsignatura"),
    @NamedQuery(name = "Asignatura.findByNivelAsignatura", query = "SELECT a FROM Asignatura a WHERE a.nivelAsignatura = :nivelAsignatura"),
    @NamedQuery(name = "Asignatura.findByCodigoAsignatura", query = "SELECT a FROM Asignatura a WHERE a.codigoAsignatura = :codigoAsignatura"),
    @NamedQuery(name = "Asignatura.findByHorasTeoria", query = "SELECT a FROM Asignatura a WHERE a.horasTeoria = :horasTeoria"),
    @NamedQuery(name = "Asignatura.findByHorasEjercicio", query = "SELECT a FROM Asignatura a WHERE a.horasEjercicio = :horasEjercicio"),
    @NamedQuery(name = "Asignatura.findByHorasLaboratorio", query = "SELECT a FROM Asignatura a WHERE a.horasLaboratorio = :horasLaboratorio"),
    @NamedQuery(name = "Asignatura.findByResumenAsignatura", query = "SELECT a FROM Asignatura a WHERE a.resumenAsignatura = :resumenAsignatura")})
public class Asignatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ASIGNATURA")
    private Integer idAsignatura;
    @Size(max = 128)
    @Column(name = "NOMBRE_ASIGNATURA")
    private String nombreAsignatura;
    @Column(name = "SCT_ASIGNATURA")
    private Integer sctAsignatura;
    @Column(name = "NIVEL_ASIGNATURA")
    private Integer nivelAsignatura;
    @Size(max = 16)
    @Column(name = "CODIGO_ASIGNATURA")
    private String codigoAsignatura;
    @Column(name = "HORAS_TEORIA")
    private Integer horasTeoria;
    @Column(name = "HORAS_EJERCICIO")
    private Integer horasEjercicio;
    @Column(name = "HORAS_LABORATORIO")
    private Integer horasLaboratorio;
    @Size(max = 1024)
    @Column(name = "RESUMEN_ASIGNATURA")
    private String resumenAsignatura;
    @JoinTable(name = "asignatura_intermedia", joinColumns = {
        @JoinColumn(name = "ID_ASIGNATURA", referencedColumnName = "ID_ASIGNATURA")}, inverseJoinColumns = {
        @JoinColumn(name = "ASI_ID_ASIGNATURA", referencedColumnName = "ID_ASIGNATURA")})
    @ManyToMany
    private Collection<Asignatura> asignaturaCollection;
    @ManyToMany(mappedBy = "asignaturaCollection")
    private Collection<Asignatura> asignaturaCollection1;
    @ManyToMany(mappedBy = "asignaturaCollection")
    private Collection<Profesor> profesorCollection;
    @ManyToMany(mappedBy = "asignaturaCollection")
    private Collection<Habilidad> habilidadCollection;
    @JoinColumn(name = "ID_PLAN", referencedColumnName = "ID_PLAN")
    @ManyToOne
    private Plan idPlan;
    @OneToMany(mappedBy = "idAsignatura")
    private Collection<ProgramaAsignatura> programaAsignaturaCollection;

    public Asignatura() {
    }

    public Asignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public Integer getSctAsignatura() {
        return sctAsignatura;
    }

    public void setSctAsignatura(Integer sctAsignatura) {
        this.sctAsignatura = sctAsignatura;
    }

    public Integer getNivelAsignatura() {
        return nivelAsignatura;
    }

    public void setNivelAsignatura(Integer nivelAsignatura) {
        this.nivelAsignatura = nivelAsignatura;
    }

    public String getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public void setCodigoAsignatura(String codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }

    public Integer getHorasTeoria() {
        return horasTeoria;
    }

    public void setHorasTeoria(Integer horasTeoria) {
        this.horasTeoria = horasTeoria;
    }

    public Integer getHorasEjercicio() {
        return horasEjercicio;
    }

    public void setHorasEjercicio(Integer horasEjercicio) {
        this.horasEjercicio = horasEjercicio;
    }

    public Integer getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(Integer horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    public String getResumenAsignatura() {
        return resumenAsignatura;
    }

    public void setResumenAsignatura(String resumenAsignatura) {
        this.resumenAsignatura = resumenAsignatura;
    }

    @XmlTransient
    public Collection<Asignatura> getAsignaturaCollection() {
        return asignaturaCollection;
    }

    public void setAsignaturaCollection(Collection<Asignatura> asignaturaCollection) {
        this.asignaturaCollection = asignaturaCollection;
    }

    @XmlTransient
    public Collection<Asignatura> getAsignaturaCollection1() {
        return asignaturaCollection1;
    }

    public void setAsignaturaCollection1(Collection<Asignatura> asignaturaCollection1) {
        this.asignaturaCollection1 = asignaturaCollection1;
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }

    @XmlTransient
    public Collection<Habilidad> getHabilidadCollection() {
        return habilidadCollection;
    }

    public void setHabilidadCollection(Collection<Habilidad> habilidadCollection) {
        this.habilidadCollection = habilidadCollection;
    }

    public Plan getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Plan idPlan) {
        this.idPlan = idPlan;
    }

    @XmlTransient
    public Collection<ProgramaAsignatura> getProgramaAsignaturaCollection() {
        return programaAsignaturaCollection;
    }

    public void setProgramaAsignaturaCollection(Collection<ProgramaAsignatura> programaAsignaturaCollection) {
        this.programaAsignaturaCollection = programaAsignaturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignatura != null ? idAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.idAsignatura == null && other.idAsignatura != null) || (this.idAsignatura != null && !this.idAsignatura.equals(other.idAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Asignatura[ idAsignatura=" + idAsignatura + " ]";
    }
    
}
