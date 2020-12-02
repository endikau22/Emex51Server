/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Boss;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 2dam
 */
@Entity
public class Employee extends User implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private float Salario;
    private String puesto;
    private Sector sector;
    private Visitor visitante;
    private Boss jefe;

    public Employee() {
    }

    public Employee(float Salario, String puesto, Sector sector, Visitor visitante, Boss jefe) {
        this.Salario = Salario;
        this.puesto = puesto;
        this.sector = sector;
        this.visitante = visitante;
        this.jefe = jefe;
    }

    public float getSalario() {
        return Salario;
    }

    public void setSalario(float Salario) {
        this.Salario = Salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Visitor getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitor visitante) {
        this.visitante = visitante;
    }

    public Boss getJefe() {
        return jefe;
    }

    public void setJefe(Boss jefe) {
        this.jefe = jefe;
    }

}
