/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity JPA class for Army data. This class inherits from de class SectorContent.
 The properties of this class is the ammunition. 
 * @author Endika Ubierna, Markel Uralde, Xabier Carnero
 * @version 1.0
 * @since 01/12/2020
 */
@Entity
@DiscriminatorValue(value="army")
@NamedQueries({
    @NamedQuery(name = "findAllArmy",
            query = "SELECT sc FROM SectorContent sc WHERE Type = 'army'"),
    @NamedQuery(name = "findArmyById",
            query = "SELECT sc FROM SectorContent sc WHERE sc.id = :id AND Type = 'army'"),
    @NamedQuery(name = "findArmyByName",
            query = "SELECT sc FROM SectorContent sc WHERE sc.name = :name AND Type = 'army'"),
})
@XmlRootElement
public class Army extends SectorContent implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer ammunition;

    /**
     * Class constructor.
     */
    public Army() {
    }

    /**
     * Gets the quantity of ammunition of the army.
     * @return The ammunition value.
     */
    public int getAmmunition() {
        return ammunition;
    }

    /**
     * Sets the quantity of ammunition of the army.
     * @param ammunition The ammunition value.
     */
    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }
    
    
}
