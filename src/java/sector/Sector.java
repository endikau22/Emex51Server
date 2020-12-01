/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sector;

import employee.Employee;
import java.io.Serializable;
import java.util.ArrayList;
import visitor.Visitor;

/**
 * Esta clase es para guardar los datos de un Sector
 * @author Xabier Carnero
 */
public class Sector implements Serializable{
    
    private Integer idSector;
    private ArrayList <Visitor> visitante;
    private ArrayList <Employee> empleado;
    private Tipo tipo;

    public Sector() {
    }

    public Sector(Integer id_sector, ArrayList<Visitor> visitante, ArrayList<Employee> empleado, Tipo tipo) {
        this.idSector = id_sector;
        this.visitante = visitante;
        this.empleado = empleado;
        this.tipo = tipo;
    }

    public Integer getId_sector() {
        return idSector;
    }

    public void setId_sector(Integer id_sector) {
        this.idSector = id_sector;
    }

    public ArrayList<Visitor> getVisitante() {
        return visitante;
    }

    public void setVisitante(ArrayList<Visitor> visitante) {
        this.visitante = visitante;
    }

    public ArrayList<Employee> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(ArrayList<Employee> empleado) {
        this.empleado = empleado;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Sector{" + "idSector=" + idSector + ", visitante=" + visitante + ", empleado=" + empleado + ", tipo=" + tipo + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Sector)){
            return false;
        }
        Sector other = (Sector) obj;
        if((this.idSector == null && other.idSector != null) || (this.idSector != null && !this.idSector.equals(other.idSector))){
            return false;
        }
        return true;
    }
}
