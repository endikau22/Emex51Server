/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Employee;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 2dam
 */
@Entity
public class Visitor extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    
    private String dni;
    private LocalDateTime visitaSolicitada; //Cambiar???
    private boolean visitaRespuesta;
    private boolean visitado;
    private LocalDateTime fechaVisita;
    private Employee empleado;
    private ArrayList <Sector> sectores;

    public Visitor() {
    }

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

    public ArrayList<Sector> getSectores() {
        return sectores;
    }

    public void setSectores(ArrayList<Sector> sectores) {
        this.sectores = sectores;
    }
    
}
