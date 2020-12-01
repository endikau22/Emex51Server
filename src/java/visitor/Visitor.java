/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import employee.Employee;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import sector.Sector;
import user.User;

/**
 * Esta clase es para guardar los datos de un Visitor
 * @author Xabier Carnero
 */
public class Visitor extends User implements Serializable{
    
    private String dni;
    private LocalDateTime visitaSolicitada; //Cambiar???
    private boolean visitaRespuesta;
    private boolean visitado;
    private LocalDateTime fechaVisita;
    private Employee empleado;
    private ArrayList <Sector> sectores;

    public Visitor() {
    }

    public Visitor(String dni, LocalDateTime visitaSolicitada, boolean visitaRespuesta, boolean visitado, LocalDateTime fechaVisita, Employee empleado, ArrayList<Sector> sectores, String login, String email, String fullName, String password) {
        super(login, email, fullName, password);
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

    @Override
    public String toString() {
        return "Visitante{" + "dni=" + dni + ", visitaSolicitada=" + visitaSolicitada + ", visitaRespuesta=" + visitaRespuesta + ", visitado=" + visitado + ", fechaVisita=" + fechaVisita + ", empleado=" + empleado + ", sectores=" + sectores + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Visitor)){
            return false;
        }
        Visitor other = (Visitor) obj;
        if((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))){
            return false;
        }
        return true;
    }
}
