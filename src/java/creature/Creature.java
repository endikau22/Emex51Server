/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creature;

import java.io.Serializable;
import java.time.LocalDateTime;
import sector.Sector;

/**
 * Esta clase es para guardar los datos de una Creature
 * @author Xabier Carnero
 */
public class Creature implements Serializable{
    
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
    public String toString() {
        return "Criatura{" + "idCriatura=" + idCriatura + ", nombre=" + nombre + ", sector=" + sector + ", fechaLlegada=" + fechaLlegada + '}';
    }

        @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Creature)){
            return false;
        }
        Creature other = (Creature) obj;
        if((this.idCriatura == null && other.idCriatura != null) || (this.idCriatura != null && !this.idCriatura.equals(other.idCriatura))){
            return false;
        }
        return true;
    }
}
