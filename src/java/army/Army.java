/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package army;

import java.io.Serializable;
import java.time.LocalDateTime;
import sector.Sector;

/**
 * Esta clase es para guardar los datos de un Army
 *
 * @author Xabier Carnero
 */
public class Army implements Serializable {

    private Integer idArmamento;
    private String nombre;
    private Sector sector;
    private LocalDateTime fechaLlegada;

    public Army() {
    }

    public Army(Integer id_armamento, String nombre, Sector sector, LocalDateTime fechaLlegada) {
        this.idArmamento = id_armamento;
        this.nombre = nombre;
        this.sector = sector;
        this.fechaLlegada = fechaLlegada;
    }

    public Integer getId_armamento() {
        return idArmamento;
    }

    public void setId_armamento(Integer id_armamento) {
        this.idArmamento = id_armamento;
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
        return "Army{" + "idArmamento=" + idArmamento + ", nombre=" + nombre + ", sector=" + sector + ", fechaLlegada=" + fechaLlegada + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Army)) {
            return false;
        }
        Army other = (Army) obj;
        if ((this.idArmamento == null && other.idArmamento != null) || (this.idArmamento != null && !this.idArmamento.equals(other.idArmamento))) {
            return false;
        }
        return true;
    }
}
