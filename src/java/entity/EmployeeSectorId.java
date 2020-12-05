/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * {@link Embeddable} Class that contains the primary keys of the entities {@link Employee} and {@link Sector}
 * @author Endika Ubierna, Markel Uralde, Xabier Carnero
 * @version 1.0
 * @since 01/12/2020
 */
//Esta clase contiene las claves primaria de empleado y sector. Es parte de lo que hay que hacer en una relación N:M con atributos
//Da igual el nombre de los atributos lo importante es que el tipo en este caso integer sea igual que el de la pk de empleado y sector.
//Esta clase será luego embebida por employeesectormanagement
@Embeddable
public class EmployeeSectorId implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * Id field of the {@link Employee} entity.
     */
    private Integer employeeId;
    /**
     * Id field of the {@link Sector} entity.
     */
    private Integer sectorId;

    /**
     * Gets the {@link Employee} id.
     * @return The id value.
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the {@link Employee} id.
     * @param employeeId The id value.
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the {@link  Sector} id.
     * @return The id value.
     */
    public Integer getSectorId() {
        return sectorId;
    }

    /**
     * Sets the {@link Sector} id.
     * @param sectorId The id value.
     */
    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }
}
