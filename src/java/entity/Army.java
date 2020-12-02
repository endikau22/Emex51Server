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
public class Army implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Identificativo unico para el armamento
     */
    @Id
    private Integer idArmamento;
    /**
     * El nombre del armamento 
     */
    private String nombre;
    /**
     * El sector donde esta el armamento 
     */
    private Sector sector;
    /**
     * Fecha en la que llega el armamento 
     */
    private LocalDateTime fechaLlegada;
    /**
     * 
     * @return id
     */
    /**
     * Constructor vacio
     */
    public Army() {
    }
    /**
     * 
     * @param id
     * @param idArmamento
     * @param nombre
     * @param sector
     * @param fechaLlegada 
     */
    public Army(Long id, Integer idArmamento, String nombre, Sector sector, LocalDateTime fechaLlegada) {
        this.idArmamento = idArmamento;
        this.nombre = nombre;
        this.sector = sector;
        this.fechaLlegada = fechaLlegada;
    }
    /**
     * 
     * @return Id del armamento
     */
    public Integer getIdArmamento() {
        return idArmamento;
    }
    /**
     * 
     * @param idArmamento 
     */
    public void setIdArmamento(Integer idArmamento) {
        this.idArmamento = idArmamento;
    }
    /**
     * 
     * @return el nombre del armamento
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return el sector donde esta el armamento
     */
    public Sector getSector() {
        return sector;
    }
    /**
     * 
     * @param sector 
     */
    public void setSector(Sector sector) {
        this.sector = sector;
    }
    /**
     * 
     * @return fecha que llega el armamento 
     */
    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }
    /**
     * 
     * @param fechaLlegada 
     */
    public void setFechaLlegada(LocalDateTime fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    /**
     * 
     * @return representación entera para instanciar armamento
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArmamento != null ? idArmamento.hashCode() : 0);
        return hash;
    }
    /**
     * Sirve para coparar dos armamentos diferentes. 
     * @param object
     * @return 
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
     * obtiene el string de armamento 
     * @return 
     */
    @Override
    public String toString() {
        return "army.Army[ idArmamento=" + idArmamento + " ]";
    }
}
