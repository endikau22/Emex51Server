/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
public class Boss extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * el salario que gana el jefe
     */
    private float salario;
    /**
     * arraylist de los empleados que esta al cargo del jefe
     */
    private ArrayList <Employee> empleado;
    /**
     * 
     * @return id unico del jefe
     */
    
    /**
     * constructor vacio del jefe
     */
    public Boss() {
    }
    /**
     * 
     * @param id
     * @param salario
     * @param empleado 
     */
    public Boss(float salario, ArrayList<Employee> empleado) {
        
        this.salario = salario;
        this.empleado = empleado;
    }
    /**
     * 
     * @return el salario del jefe
     */
    public float getSalario() {
        return salario;
    }
    /**
     * 
     * @param salario 
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }
    /**
     * 
     * @return lista de empleados 
     */
    public ArrayList<Employee> getEmpleado() {
        return empleado;
    }
    /**
     * 
     * @param empleado 
     */
    public void setEmpleado(ArrayList<Employee> empleado) {
        this.empleado = empleado;
    }
    
}
