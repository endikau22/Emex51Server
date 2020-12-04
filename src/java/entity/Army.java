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
 * Entity JPA class for Army data. The properties of this class are idArmamento , 
 * name, arrivalDate. It also contains relational fields for getting the sector 
 * where the army are storaged.
 * @author Endika Ubierna, Markel Uralde, Xabier Carnero
 * @version 1.0
 * @since 01/12/2020
 */
@Entity
@Table(name="army",schema="emex51db")
@NamedQueries ({
    @NamedQuery(name="findAllArms",query = "SELECT a FROM Army a ORDER BY a.nombre DESC"),
    @NamedQuery(name="findArmById",query = "SELECT a FROM Army a WHERE a.idArmamento = :idArmamento")
})
public class Army implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Id field of the Army Entity. It is also the id value of the army.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idArmamento;
    /**
     * Name of the army.
     */
    private String nombre;
    /**
     * {@link Sector} where the army is stored.  
     */
    @ManyToOne
    private Sector sector;
    /**
     * Arrival Date of the army to the facilities.
     */
    private LocalDateTime fechaLlegada;
    /**
     * Class constructor.
     */
    public Army() {
    }
    /**
     * Gets id value for army.
     * @return The id value.
     */
    public Integer getIdArmamento() {
        return idArmamento;
    }
    /**
     * Sets id value for army.
     * @param id_armamento  The id value.
     */
    public void setIdArmamento(Integer idArmamento) {
        this.idArmamento = idArmamento;
    }
    /**
     * Gets name value for army.
     * @return The name value.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Sets name value for army. 
     * @param nombre  The name value.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Gets Sector value for army.
     * @return The sector value.
     */
    public Sector getSector() {
        return sector;
    }
    /**
     * Sets Sector value for army.
     * @param sector The sector value
     */
    public void setSector(Sector sector) {
        this.sector = sector;
    }
    /**
     * Gets arrival date value for army.
     * @return The  arrival date value.
     */
    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }
    /**
     * Sets arrival date value for army.
     * @param fechaLlegada  The  arrival date value.
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
        hash += (idArmamento != null ? idArmamento.hashCode() : 0);
        return hash;
    }
    /**
     * This method compares two army entities for equality. This implementation
     * compare id field value for equality.
     * @param obj The object to compare to.
     * @return True if objects are equals, otherwise false.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Army)) {
            return false;
        }
        Army other = (Army) object;
        if ((this.idArmamento == null && other.idArmamento != null) || (this.idArmamento != null && !this.idArmamento.equals(other.idArmamento))) {
            return false;
        }
        return true;
    }
    /**
     * This method returns a String representation for an army entity instance.
     * @return The String representation for the Army object. 
     */
    @Override
    public String toString() {
        return "army.Army[ idArmamento=" + idArmamento + " ]";
    }
}
