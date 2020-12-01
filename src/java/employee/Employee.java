/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.io.Serializable;
import boss.Boss;
import sector.Sector;
import user.User;
import visitor.Visitor;

/**
 * Esta clase es para guardar los datos de un Employee
 * @author xabig
 */
public class Employee extends User implements Serializable{
    
    private float Salario;
    private String puesto;
    private Sector sector;
    private Visitor visitante;
    private Boss jefe;

    public Employee() {
    }

    public Employee(float Salario, String puesto, Sector sector, Visitor visitante, Boss jefe, String login, String email, String fullName, String password) {
        super(login, email, fullName, password);
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

    @Override
    public String toString() {
        return "Empleado{" + "Salario=" + Salario + ", puesto=" + puesto + ", sector=" + sector + ", visitante=" + visitante + ", jefe=" + jefe + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Employee)){
            return false;
        }
        Employee other = (Employee) obj;
        if((((User)this).getLogin() == null && ((User)other).getLogin() != null) || (((User)this).getLogin() != null && !((User)this).getLogin().equals(((User)other).getLogin()))){
            return false;
        }
        return true;
    }
}
