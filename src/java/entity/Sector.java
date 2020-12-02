/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2dam
 */
@Entity
@Table(name = "sector", schema = "emex51db")
@XmlRootElement
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Guarda el identificativo unico de sector
     */
    @Id
    private Integer idSector;
    /**
     * Guarda los visitantes que van a visitar el sector
     */
    @ManyToMany(fetch = EAGER)//cascade = MERGE???
    @JoinTable(schema = "emex51db", name = "visitor_sector")
    private ArrayList<Visitor> visitante;
    /**
     * Guarda los empleados que trabajan en ese sector
     */
    @ManyToMany(fetch = EAGER)//cascade = MERGE???
    @JoinTable(schema = "emex51db", name = "employee_sector")
    private ArrayList<Employee> empleado;
    /**
     * Guarda el tipo de sector que es. Puede ser
     * o armamento o criatura
     */
    @Enumerated(EnumType.ORDINAL)
    private SectorTipo tipo;

    /**
     * Constructor vacio
     */
    public Sector() {
    }

    /**
     * Contructor lleno
     *
     * @param idSector
     * @param visitante
     * @param empleado
     * @param tipo
     */
    public Sector(Integer idSector, ArrayList<Visitor> visitante, ArrayList<Employee> empleado, SectorTipo tipo) {
        this.idSector = idSector;
        this.visitante = visitante;
        this.empleado = empleado;
        this.tipo = tipo;
    }

    public Integer getIdSector() {
        return idSector;
    }

    public void setIdSector(Integer idSector) {
        this.idSector = idSector;
    }

    @XmlTransient
    public ArrayList<Visitor> getVisitante() {
        return visitante;
    }

    public void setVisitante(ArrayList<Visitor> visitante) {
        this.visitante = visitante;
    }

    @XmlTransient
    public ArrayList<Employee> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(ArrayList<Employee> empleado) {
        this.empleado = empleado;
    }

    public SectorTipo getTipo() {
        return tipo;
    }

    public void setTipo(SectorTipo tipo) {
        this.tipo = tipo;
    }
    /**
     * 
     * @return representación entera para instanciar sector
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSector != null ? idSector.hashCode() : 0);
        return hash;
    }
    /**
     * Sirve para coparar dos sectores 
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.idSector == null && other.idSector != null) || (this.idSector != null && !this.idSector.equals(other.idSector))) {
            return false;
        }
        return true;
    }
    /**
     * obtiene el string de sector 
     * @return 
     */
    @Override
    public String toString() {
        return "Sector{" + "idSector=" + idSector + '}';
    }
}
