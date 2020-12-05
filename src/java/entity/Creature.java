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

/**
 * Entity JPA class for Creature data. This class inherits from de class Existence.
 * The property of this class is species.
 * @author Xabier Carnero, Endika Ubierna, Markel Uralde.
 * @version 1.0
 * @since 01/12/2020
 */
@Entity
@NamedQueries ({
    @NamedQuery(name="findAllCriatures",query = "SELECT c FROM Creature c ORDER BY c.name DESC"),
    @NamedQuery(name="findCriatureById",query = "SELECT c FROM Creature c WHERE c.id = :id")
})
@DiscriminatorValue(value="Creature")
public class Creature extends Existence implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String species;

    /**
     * Class constructor.
     */
    public Creature() {
        super();
    }

    /**
     * Gets the species of the creature
     * @return The species value.
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Sets the species of the creature
     * @param species The species value.
     */
    public void setSpecies(String species) {
        this.species = species;
    }
}
