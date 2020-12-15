/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class contains the relation between the class {@link Employee} and the class {@link Sector}.
 * @author Endika Ubierna, Markel Uralde, Xabier Carnero
 * @version 1.0
 * @since 01/12/2020
 */
@Entity
@Table(name="EMPLOYEE_SECTOR",schema="emex51db")
@XmlRootElement
//Esta clase es la clase relacional que se forma en la relación N:M con atributos. La clave primaria son las dos tanto la
//de sector como empleado embebidas en EmployeeeSectorId. 
//Lo que hace esta clase es divide el N:M entre las entidades Empleado y Sector y las convierte en dos 1:N. De Empleado a esta y de Sector a esta clase. 
public class EmployeeSectorManagement implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * Id field of the EmployeeSectorManagement class. It is build with the id values of the class
     * {@link Employee} and the class {@link Sector}
     */
    @EmbeddedId
    private EmployeeSectorId id;
    /**
     * The {@link Employee} who manage the {@link Sector}.
     */
    @MapsId("employeeId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;
    /**
     * The {@link Sector} managed by {@link Employee}.
     */
    @MapsId("sectorId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Sector sector;
    /**
     * Registers the date where the {@link Employee} managed the {@link Sector}.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date workDate;

    /**
     * Gets the id of the class.
     * @return The id value.
     */
    public EmployeeSectorId getId() {
        return id;
    }

    /**
     * Sets the id of the class.
     * @param id The id value.
     */
    public void setId(EmployeeSectorId id) {
        this.id = id;
    }

    /**
     * Gets the {@link Employee}. 
     * @return The {@link Employee} value.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets the {@link Employee}.
     * @param employee The {@link Employee} value.
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Gets the {@link Sector}.
     * @return The {@link Sector} value.
     */
    public Sector getSector() {
        return sector;
    }

    /**
     * Sets the {@link Sector}
     * @param sector The {@link Sector} value.
     */
    public void setSector(Sector sector) {
        this.sector = sector;
    }

    /**
     * Gets the date.
     * @return The date value
     */
    public Date getFecha() {
        return workDate;
    }

    /**
     * Sets the date.
     * @param fecha The date value
     */
    public void setFecha(Date fecha) {
        this.workDate = fecha;
    }

    /**
     * HashCode method implementation for the entity.
     * @return An integer value as hashcode for the object. 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        //Si idArmamento es nulo devuelve 0 sino devuelve su valor numérico.
        hash += (id!= null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * This method compares two employeeSectorManagement entities for equality. This implementation
     * compare id field value for equality.
     * @param obj The object to compare to.
     * @return True if objects are equals, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        //Comprobar que el objeto recibido como parámetro es una instancia de arma
        if (!(obj instanceof EmployeeSectorManagement)) {
            return false;
        }
        EmployeeSectorManagement other = (EmployeeSectorManagement) obj;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }   
}
