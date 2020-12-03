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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity JPA class for Boss data. This class inherits from de class User.
 * The property of this class is the boss wage.It also contains relational field 
 * a set of {@link Employee} who the Boss manages.
 * @since 23/11/2020
 * @version 1.0
 * @author Xabier Carnero, Endika Ubierna, Markel Uralde.
 */
@Entity
@Table(name="usuario",schema="emex51db")
@NamedQueries({
    @NamedQuery(name="findAllBosses",
            query="SELECT b FROM Boss b ORDER BY b.fullName DESC"
    ),
    @NamedQuery(name="findBossBylogin",
            query="SELECT b FROM Boss b WHERE b.login = :login"
    )
})
//Vamos a tener un campo en la tabla que nos indica que tipo de usuario es
@DiscriminatorValue(value="Jefe")
public class Boss extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The wage of the boss.
     */
    private float salario;
    /**
     * The list of {@link Employee} of the boss.
     */ 
    @OneToMany(mappedBy="jefe", fetch=EAGER) 
    private Set <Employee> empleado;
    /**
     * Class constructor.
     */
    public Boss() {
    }

    /**
     * Gets the wages of the boss.
     * @return The wage value.
     */
    public float getSalario() {
        return salario;
    }
  
    /**
     * Sets the wages of the boss.
     * @param salario The wage value.
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }
 
    /**
     * Gets the list of {@link Employee} of the boss.
     * @return The Set of {@link Employee} value.
     */
    public Set<Employee> getEmpleado() {
        return empleado;
    }
   
    /**
     * Sets the list of {@link Employee} of the boss.
     * @param empleado The Set of {@link Employee} value.
     */
    public void setEmpleado(Set<Employee> empleado) {
        this.empleado = empleado;
    }
}
