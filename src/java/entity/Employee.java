/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2dam
 */
@Entity
@Table(name="employee",schema="emex51db")
@XmlRootElement
public class Employee extends User implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /**
     * Guarda el salario que cobra el empleado
     */
    private float Salario;
    /**
     * Guarda el puesto en el que trabaja el empleado
     */
    private String puesto;
    /**
     * Guarda los sectores de los que se encarga el empleado
     */
    @ManyToMany(fetch=EAGER)//cascade = MERGE???
    @JoinTable(schema="emex51db", name="employee_sector")
    private ArrayList <Sector> sectors;
    /**
     * Guarda los visitantes de los que se hace cargo el empleado
     */
    @OneToMany(mappedBy = "emloyee", fetch=EAGER)
    private ArrayList <Visitor> visitantes;
    /**
     * Guarda el jefe del empleado
     */
    @ManyToOne
    private Boss jefe;
    /**
     * Constructor vacio
     */
    public Employee() {
    }
    /**
     * Constructor lleno
     * @param Salario
     * @param puesto
     * @param sectors
     * @param visitantes
     * @param jefe
     * @param login
     * @param email
     * @param fullName
     * @param password 
     */
    public Employee(float Salario, String puesto, ArrayList<Sector> sectors, ArrayList<Visitor> visitantes, Boss jefe, String login, String email, String fullName, String password) {
        super(login, email, fullName, password);
        this.Salario = Salario;
        this.puesto = puesto;
        this.sectors = sectors;
        this.visitantes = visitantes;
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
    @XmlTransient
    public ArrayList<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(ArrayList<Sector> sectors) {
        this.sectors = sectors;
    }

    public ArrayList<Visitor> getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(ArrayList<Visitor> visitantes) {
        this.visitantes = visitantes;
    }

    public Boss getJefe() {
        return jefe;
    }

    public void setJefe(Boss jefe) {
        this.jefe = jefe;
    }
}
