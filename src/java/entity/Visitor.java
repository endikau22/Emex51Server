/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2dam
 */
@Entity
@Table(name="visitor",schema="emex51db")
@XmlRootElement
public class Visitor extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Guarda el dni del visitante
     */
    private String dni;
    /**
     * Guarda la fecha de la visita solicitada 
     * por el visitante
     */
    private LocalDateTime visitaSolicitada;
    /**
     * Guarda la respuesta por parte del empleado
     */
    private boolean visitaRespuesta;
    /**
     * Guarda si ha visitado o no anteriormente
     */
    private boolean visitado;
    /**
     * Guarda la fecha de su visita
     */
    private LocalDateTime fechaVisita;
    /**
     * Guarda que empleado esta a su cargo
     */
    @ManyToOne
    private Employee empleado;
    /**
     * Guarda los sectores que va a vistar
     */
    @ManyToMany(fetch = EAGER)//cascade = MERGE???
    @JoinTable(schema = "emex51db", name = "visitor_sector")
    private ArrayList <Sector> sectores;
    /**
     * Contructor vacio
     */
    public Visitor() {
    }
    /**
     * Contructor lleno
     * @param dni
     * @param visitaSolicitada
     * @param visitaRespuesta
     * @param visitado
     * @param fechaVisita
     * @param empleado
     * @param sectores 
     */
    public Visitor(String dni, LocalDateTime visitaSolicitada, boolean visitaRespuesta, boolean visitado, LocalDateTime fechaVisita, Employee empleado, ArrayList<Sector> sectores) {
        this.dni = dni;
        this.visitaSolicitada = visitaSolicitada;
        this.visitaRespuesta = visitaRespuesta;
        this.visitado = visitado;
        this.fechaVisita = fechaVisita;
        this.empleado = empleado;
        this.sectores = sectores;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDateTime getVisitaSolicitada() {
        return visitaSolicitada;
    }

    public void setVisitaSolicitada(LocalDateTime visitaSolicitada) {
        this.visitaSolicitada = visitaSolicitada;
    }

    public boolean isVisitaRespuesta() {
        return visitaRespuesta;
    }

    public void setVisitaRespuesta(boolean visitaRespuesta) {
        this.visitaRespuesta = visitaRespuesta;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public LocalDateTime getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(LocalDateTime fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Employee getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Employee empleado) {
        this.empleado = empleado;
    }
    
    @XmlTransient
    public ArrayList<Sector> getSectores() {
        return sectores;
    }

    public void setSectores(ArrayList<Sector> sectores) {
        this.sectores = sectores;
    } 
}
