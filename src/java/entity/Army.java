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
 * The property of this class is the ammunition. 
 * @author Endika Ubierna, Markel Uralde, Xabier Carnero
 * @version 1.0
 * @since 01/12/2020
 */
@Entity
@DiscriminatorValue(value="ARMY")
@NamedQueries({
    @NamedQuery(name = "findAllArmy",
            query = "SELECT a FROM Army a"),
    @NamedQuery(name = "findArmyByName",
            query = "SELECT a FROM Army a WHERE a.name = :name"),
    @NamedQuery(name = "findArmyBySector",
            query = "SELECT a FROM Army a WHERE a.sector = :sector"),
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
