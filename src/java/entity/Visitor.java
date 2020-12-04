/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import static javax.persistence.CascadeType.MERGE;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity JPA class for visitor data. This class inherits of the superclass User.
 * The property of this class is dni,requested visit, visited, visit date.
 * It also contains relational fields for getting the {@link Employee} and the {@link Sector}.
 * @since 23/11/2020
 * @version 1.0
 * @author Xabier Carnero, Endika Ubierna, Markel Uralde.
 */
@Entity
@Table(name="visitor",schema="emex51db")
public class Visitor extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The DNI of the visitor.
     */
    private String dni;
    /**
     * The request date of the visit.
     */
    private LocalDateTime visitaSolicitada;
    /**
     * The response. True or false. 
     */
    private Boolean visitaRespuesta;
    /**
     * Visited value. True or false.
     */
    private Boolean visitado;
    /**
     * The date of the visitors visit.
     */
    private LocalDateTime fechaVisita;
    /**
     * The {@link Employee} who manage the visitors visit.
     */
    @ManyToOne
    private Employee empleado;
    /**
     * The Set of {@link Sector} visited by the visitor.
     */
    @ManyToMany(fetch = EAGER,cascade = MERGE)
    @JoinTable(schema = "emex51db", name = "visited_sector")
    private Set <Sector> sectoresvisitados;
    
    /**
     * Class constructor.
     */
    public Visitor() {
    }

    /**
     * Gets the dni of the visitor.
     * @return The dni value.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Sets the dni of the visitor.
     * @param dni The dni value.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Gets the date of the requested visit.
     * @return The date of the requested visit value.
     */
    public LocalDateTime getVisitaSolicitada() {
        return visitaSolicitada;
    }

    /**
     * Sets the date of the requested visit.
     * @param visitaSolicitada The date of the requested visit value.
     */
    public void setVisitaSolicitada(LocalDateTime visitaSolicitada) {
        this.visitaSolicitada = visitaSolicitada;
    }

    /**
     * Gets the boolean value of the response to the visit date request.
     * @return The visit response value. True or false.
     */
    public boolean isVisitaRespuesta() {
        return visitaRespuesta;
    }

    /**
     * Sets the boolean value of the response to the visit date request.
     * @param visitaRespuesta The visit response value. True or false.
     */
    public void setVisitaRespuesta(boolean visitaRespuesta) {
        this.visitaRespuesta = visitaRespuesta;
    }

    /**
     * Gets the visited value
     * @return The visited value. True or false.
     */
    public boolean isVisitado() {
        return visitado;
    }

    /**
     * Sets the visited value.
     * @param visitado The visited value. 
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    /**
     * Gets the date of the visit.
     * @return The date of the visit value.
     */
    public LocalDateTime getFechaVisita() {
        return fechaVisita;
    }

    /**
     * Sets the date of the visit.
     * @param fechaVisita The date of the visit value.
     */
    public void setFechaVisita(LocalDateTime fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    /**
     * Gets the {@link Employee} who manage the visit.
     * @return The {@link Employee} who manage the visit value.
     */
    public Employee getEmpleado() {
        return empleado;
    }

    /**
     * Sets the {@link Employee} who manage the visit.
     * @param empleado The {@link Employee} who manage the visit value.
     */
    public void setEmpleado(Employee empleado) {
        this.empleado = empleado;
    }
   
    /**
     * Gets the {@link Sector} visited by the visitor.
     * @return The {@link Sector} value.
     */
    @XmlTransient
    public Set<Sector> getSectores() {
        return sectoresvisitados;
    }

    /**
     * Sets the {@link Sector} visited by the visitor. 
     * @param sectores The {@link Sector} value.
     */
    public void setSectores(Set<Sector> sectores) {
        this.sectoresvisitados = sectores;
    } 
}
