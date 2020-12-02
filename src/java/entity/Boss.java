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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 2dam
 */
@Entity
@Table(name="boss",schema="emex51db")
@XmlRootElement
public class Boss extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * el salario que gana el jefe
     */
    private float salario;
    /**
     * arraylist de los empleados que esta al cargo del jefe
     */
    @OneToMany(mappedBy="boss", fetch=EAGER) 
    private ArrayList <Employee> empleado;
    /**
     * constructor vacio del jefe
     */
    public Boss() {
    }
    /**
     * @param salario
     * @param empleado 
     */
    public Boss(float salario, ArrayList<Employee> empleado) {
        
        this.salario = salario;
        this.empleado = empleado;
    }
    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }
    public ArrayList<Employee> getEmpleado() {
        return empleado;
    }
    public void setEmpleado(ArrayList<Employee> empleado) {
        this.empleado = empleado;
    }
}
