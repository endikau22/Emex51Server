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

/**
 *
 * @author 2dam
 */
@Entity
public class Creature implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer idCriatura;
    private String nombre;
    private Sector sector;
    private LocalDateTime fechaLlegada;

    public Creature() {
    }

    public Creature(Integer idCriatura, String nombre, Sector sector, LocalDateTime fechaLlegada) {
        this.idCriatura = idCriatura;
        this.nombre = nombre;
        this.sector = sector;
        this.fechaLlegada = fechaLlegada;
    }

    public Integer getIdCriatura() {
        return idCriatura;
    }

    public void setIdCriatura(Integer idCriatura) {
        this.idCriatura = idCriatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDateTime fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCriatura != null ? idCriatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creature)) {
            return false;
        }
        Creature other = (Creature) object;
        if ((this.idCriatura == null && other.idCriatura != null) || (this.idCriatura != null && !this.idCriatura.equals(other.idCriatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "creature.Creature[ idCriatura=" + idCriatura + " ]";
    }
    
}
