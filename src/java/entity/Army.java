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
    @NamedQuery(name="findAllArms",query = "SELECT a FROM Army a ORDER BY a.name DESC"),
    @NamedQuery(name="findArmById",query = "SELECT a FROM Army a WHERE a.idArmy = :idArmy")
})
public class Army implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Identificativo unico para el armamento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idArmamento;
    /**
     * El nombre del armamento 
     */
    private String nombre;
    /**
     * El sector donde esta el armamento 
     */
    @ManyToOne
    private Sector sector;
    /**
     * Fecha en la que llega el armamento 
     */
    private LocalDateTime fechaLlegada;
    /**
     * Constructor vacio
     */
    
    public Army() {
    }
    /**
     * Constructor lleno
     * @param idArmamento
     * @param nombre
     * @param sector
     * @param fechaLlegada 
     */
    public Army(Integer idArmamento, String nombre, Sector sector, LocalDateTime fechaLlegada) {
        this.idArmamento = idArmamento;
        this.nombre = nombre;
        this.sector = sector;
        this.fechaLlegada = fechaLlegada;
    }
    
    public Integer getIdArmamento() {
        return idArmamento;
    }
    
    public void setIdArmamento(Integer idArmamento) {
        this.idArmamento = idArmamento;
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
