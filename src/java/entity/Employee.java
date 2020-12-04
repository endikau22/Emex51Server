/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity JPA class for Employee data. This class inherits of the superclass User.
 * The properties of this class are salary, position , sector, visitor and boss.
 * It also contains relational fields for getting the {@link Sector} management and the {@link Visit} management.
 * @since 23/11/2020
 * @version 1.0
 * @author Xabier Carnero, Endika Ubierna, Markel Uralde.
 */
@Entity
@Table(name="usuario",schema="emex51db")
@NamedQueries({
    @NamedQuery(name="findAllEmployees",
            query="SELECT e FROM Employee e ORDER BY e.fullName DESC"
    ),
    @NamedQuery(name="findEmployeeBylogin",
            query="SELECT e FROM Employee e WHERE e.login = :login"
    )
})
//Vamos a tener un campo en la tabla que nos indica que tipo de usuario es
@DiscriminatorValue(value="Employee")
public class Employee extends User implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /**
     * Wage of the employee.
     */
    private float wage;
    /**
     * Position of the employee.
     */
    private String workstation;
    /**
     * List of {@link Sector} where the employee works.
     */
    @OneToMany(mappedBy = "employees",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set <EmployeeSectorManagement> sectorsManaged;
    /**
     * List of {@link Visitor} the employee manages.
     */
    @OneToMany(mappedBy = "employee", fetch=EAGER, cascade = CascadeType.MERGE)
    private Set <Visitor> visitors;
    /**
     * The Boss of the employee.
     */
    @ManyToOne
    private Boss boss;
    /**
     * Class constructor.
     */
    public Employee() {
    }
    
    /**
     * Gets the wages of the employee.
     * @return The wage value.
     */
    public float getWage() {
        return wage;
    }

    /**
     * Sets the wages of the employee.
     * @param wage
     */
    public void setWage(float wage) {
        this.wage = wage;
    }

    /**
     * Gets the position of the employee.
     * @return The position value.
     */
    public String getWorkstation() {
        return workstation;
    }

    /**
     * Sets the position of the employee.
     * @param workstation The position value.
     */
    public void setWorkstation(String workstation) {
        this.workstation = workstation;
    }
    
    /**
     * Gets a list of {@link Sector} managed by the employee.
     * @return The list Sector value.
     */
    @XmlTransient
    public Set<EmployeeSectorManagement> getSectors() {
        return sectorsManaged;
    }

    /**
     * Sets a list of {@link Sector} managed by the employee.
     * @param sectors
     */
    public void setSectors(Set<EmployeeSectorManagement> sectors) {
        this.sectorsManaged = sectors;
    }

    /**
     * Gets a list of {@link Visitor} managed by  the employee.
     * @return The list {@link Visitor} value.
     */
    public Set<Visitor> getVisitors() {
        return visitors;
    }

    /**
     * Sets a list of {@link Visitor} managed by  the employee.
     * @param visitors
     */
    public void setVisitors(Set<Visitor> visitors) {
        this.visitors = visitors;
    }

    /**
     * Gets the {@link Boss} of the employee.
     * @return The {@link Boss} value.
     */
    public Boss getBoss() {
        return boss;
    }

    /**
     * Sets the {@link Boss} of the employee.
     * @param boss The {@link Boss} value.
     */
    public void setBoss(Boss boss) {
        this.boss = boss;
    }
}
