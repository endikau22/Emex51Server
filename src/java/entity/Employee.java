/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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
@DiscriminatorValue(value="Empleado")
public class Employee extends User implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /**
     * Wage of the employee.
     */
    private float Salario;
    /**
     * Position of the employee.
     */
    private String puesto;
    /**
     * List of {@link Sector} where the employee works.
     */
    @OneToMany
    private Set <Sector> sectors;
    /**
     * List of {@link Visitor} the employee manages.
     */
    @OneToMany(mappedBy = "empleado", fetch=EAGER)
    private Set <Visitor> visitantes;
    /**
     * The Boss of the employee.
     */
    @ManyToOne
    private Boss jefe;
    /**
     * Class constructor.
     */
    public Employee() {
    }

    /**
     * Gets the wages of the employee.
     * @return The wage value.
     */
    public float getSalario() {
        return Salario;
    }

    /**
     * Sets the wages of the employee.
     * @param Salario The wage value.
     */
    public void setSalario(float Salario) {
        this.Salario = Salario;
    }

    /**
     * Gets the position of the employee.
     * @return The position value.
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Sets the position of the employee.
     * @param puesto The position value.
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    /**
     * Gets a list of {@link Sector} managed by the employee.
     * @return The list Sector value.
     */
    @XmlTransient
    public Set<Sector> getSectors() {
        return sectors;
    }

    /**
     * Sets a list of {@link Sector} managed by the employee.
     * @param sector The list {@link Sector} value.
     */
    public void setSectors(Set<Sector> sectors) {
        this.sectors = sectors;
    }

    /**
     * Gets a list of {@link Visitor} managed by  the employee.
     * @return The list {@link Visitor} value.
     */
    public Set<Visitor> getVisitantes() {
        return visitantes;
    }

    /**
     * Sets a list of {@link Visitor} managed by  the employee.
     * @param visitante The list {@link Visitor} value.
     */
    public void setVisitantes(Set<Visitor> visitantes) {
        this.visitantes = visitantes;
    }

    /**
     * Gets the {@link Boss} of the employee.
     * @return The {@link Boss} value.
     */
    public Boss getJefe() {
        return jefe;
    }

    /**
     * Sets the {@link Boss} of the employee.
     * @param jefe The {@link Boss} value.
     */
    public void setJefe(Boss jefe) {
        this.jefe = jefe;
    }
}
