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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 2dam
 */
@Entity
@Table(name="creature",schema="emex51db")
@XmlRootElement
public class Creature implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identificativo unico para criatura
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCreature;
    /**
     * El name de la criatura
     */
    private String name;
    /**
     * El sector en el que esta la criatura
     */
    @ManyToOne
    private Sector sector;
    /**
     * Fecha en la que llega la criatura
     */
    private LocalDateTime arrivalDate;
    /**
     * Constructor vacio
     */
    public Creature() {
    }

    public Integer getidCreature() {
        return idCreature;
    }

    public void setidCreature(Integer idCreature) {
        this.idCreature = idCreature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    /**
     * 
     * @return representación entera para instanciar criatura
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCreature != null ? idCreature.hashCode() : 0);
        return hash;
    }
    /**
     * Sirve para comparar dos criaturas
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creature)) {
            return false;
        }
        Creature other = (Creature) object;
        if ((this.idCreature == null && other.idCreature != null) || (this.idCreature != null && !this.idCreature.equals(other.idCreature))) {
            return false;
        }
        return true;
    }
    /**
     * obtiene el string de la criatura
     * @return 
     */
    @Override
    public String toString() {
        return "creature.Creature[ idCriatura=" + idCreature + " ]";
    }
}
