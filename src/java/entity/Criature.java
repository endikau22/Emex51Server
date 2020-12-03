/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity JPA class for Criature data. The properties of this class are idCriature , 
 * name, arrivalDate. It also contains relational fields for getting the sector 
 * where the criature is storaged.
 * @author Xabier Carnero, Endika Ubierna, Markel Uralde.
 * @version 1.0
 * @since 01/12/2020
 */
@Entity
@Table(name="criature",schema="emex51db")
@NamedQueries ({
    @NamedQuery(name="findAllCriatures",query = "SELECT c FROM Criature c ORDER BY c.nombre DESC"),
    @NamedQuery(name="findCriatureById",query = "SELECT c FROM Criature c WHERE c.idCriatura = :idCriatura")
})
public class Criature implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Id field of the Criature Entity. It is also the id value of the criature.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCriatura;
    /**
     * Name of the criature.
     */
    private String nombre;
    /**
     * {@link Sector} of the criature
     */
    @ManyToOne
    private Sector sector;
    /**
     * Arrival Date of the criature.
     */
    private LocalDateTime fechaLlegada;
    /**
     * Class constructor.
     */
    public Criature() {
    }

    /**
     * Gets id value for criature.
     * @return The id value.
     */
    public Integer getIdCriatura() {
        return idCriatura;
    }

    /**
     * Sets id value for criature.
     * @param idCriatura The id value.
     */
    public void setIdCriatura(Integer idCriatura) {
        this.idCriatura = idCriatura;
    }

    /**
     * Gets name value for criature.
     * @return The name value.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets name value for criature. 
     * @param nombre  The name value.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets Sector value for criature.
     * @return The sector value.
     */
    public Sector getSector() {
        return sector;
    }

    /**
     * Sets Sector value for criature.
     * @param sector The sector value
     */
    public void setSector(Sector sector) {
        this.sector = sector;
    }

    /**
     * Gets arrival date value for criature.
     * @return The  arrival date value.
     */
    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     * Sets arrival date value for criature.
     * @param fechaLlegada   The  arrival date value.
     */
    public void setFechaLlegada(LocalDateTime fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    
    /**
     * HashCode method implementation for the entity.
     * @return An integer value as hashcode for the object. 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCriatura != null ? idCriatura.hashCode() : 0);
        return hash;
    }
    
    /**
     * This method compares two criature entities for equality. This implementation
     * compare id field value for equality.
     * @param obj The object to compare to.
     * @return True if objects are equals, otherwise false.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criature)) {
            return false;
        }
        Criature other = (Criature) object;
        if ((this.idCriatura == null && other.idCriatura != null) || (this.idCriatura != null && !this.idCriatura.equals(other.idCriatura))) {
            return false;
        }
        return true;
    }
    
    /**
     * This method returns a String representation for a criature entity instance.
     * @return The String representation for the Criature object. 
     */
    @Override
    public String toString() {
        return "creature.Creature[ idCriatura=" + idCriatura + " ]";
    }
    
}
