/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity JPA class for Sector data. The properties of this class are idSector, name and type.
 * It also contains relational fields for getting the visitors and the employees who manage the sector. 
 * @author Xabier Carnero, Endika Ubierna, Markel Uralde.
 * @version 1.0
 * @since 01/12/2020
 */
@Entity
@Table(name = "sector", schema = "emex51db")
@NamedQueries ({
    @NamedQuery(name="findAllSectors",query = "SELECT s FROM Sector s ORDER BY s.idSector DESC"),
    @NamedQuery(name="findSectorById",query = "SELECT s FROM Sector s WHERE s.idSector = :idSector")
})
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Id field of the Sector Entity. It is also the id value of the sector.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idSector;
    /**
     * List of {@link Visitor} belonging to the sector.
     */
    @ManyToMany(mappedBy="sectoresvisitados",fetch=EAGER)
    private Set<Visitor> visitante;
    /**
     * List of {@link EmployeeSectorManagement} belonging to the Sector.
     */
    @OneToMany(mappedBy = "sectorsManaged",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set <EmployeeSectorManagement> employees;
    /**
     * List of {@link Criature} or {@link Army} belonging to the Sector.
     */
    @OneToMany
    private Set <Object> contenidoSector;

    /**
     * {@link Type} of the sector.
     */
    @Enumerated(EnumType.STRING)
    private SectorTipo tipo;

    /**
     * Class constructor.
    */
    public Sector() {
    }

    /**
     * Gets the id of the sector.
     * @return The id value.
    */ 
    public Integer getIdSector() {
        return idSector;
    }

    /**
     * Sets the id of the sector.
     * @param idSector The id of the sector.
     */
    public void setIdSector(Integer idSector) {
        this.idSector = idSector;
    }

    /**
     * Gets visitors of the sector.
     */
    @XmlTransient
    public Set<Visitor> getVisitante() {
        return visitante;
    }

    /**
     * Sets the visitors of the sector. 
     * @param visitante The visitors collection value.
     */
    public void setVisitante(Set<Visitor> visitante) {
        this.visitante = visitante;
    }

    /**
     * Gets the employees who manage the sector.
     * @return The employee collection value.
     */
    @XmlTransient
    public Set<EmployeeSectorManagement> getEmpleado() {
        return employees;
    }

    /**
     * Sets the employees who manage the sector.
     * @param empleado The employee collection value.
     */
    public void setEmpleado(Set<EmployeeSectorManagement> empleado) {
        this.employees = empleado;
    }

    /**
     * Gets the type of the sector.
     * @return The type of the sector value.
     */
    public SectorTipo getTipo() {
        return tipo;
    }

    /**
     * Sets the type of the sector.
     * @param tipo The type value.
     */
    public void setTipo(SectorTipo tipo) {
        this.tipo = tipo;
    }
    /**
     * Gets a set of {@link Employee} who work in the sector. 
     * @return The set of {@link Employee} value.
     */
    public Set<EmployeeSectorManagement> getEmployees() {
        return employees;
    }

    /**
     * Sets a set of {@link Employee} who work in the sector.
     * @param employees The set of {@link Employee} value.
     */
    public void setEmployees(Set<EmployeeSectorManagement> employees) {
        this.employees = employees;
    }

    /**
     * Gets a set of {@link Criature} or {@link Army} belonging to the sector.
     * @return The set of {@link Criature} or {@link Army} value.
     */
    public Set<Object> getContenidoSector() {
        return contenidoSector;
    }

    /**
     * Sets a set of {@link Criature} or {@link Army} belonging to the sector.
     * @param contenidoSector The set of {@link Criature} or {@link Army} value.
     */
    public void setContenidoSector(Set<Object> contenidoSector) {
        this.contenidoSector = contenidoSector;
    }
    /**
     * HashCode method implementation for the entity.
     * @return An integer value as hashcode for the object. 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSector != null ? idSector.hashCode() : 0);
        return hash;
    }
    
    /**
     * This method compares two sector entities for equality. This implementation
     * compare id field value for equality.
     * @param obj The object to compare to.
     * @return True if objects are equals, otherwise false.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.idSector == null && other.idSector != null) || (this.idSector != null && !this.idSector.equals(other.idSector))) {
            return false;
        }
        return true;
    }
    
    /**
     * This method returns a String representation for a sector entity instance.
     * @return The String representation for the Sector object. 
     */
    @Override
    public String toString() {
        return "Sector{" + "idSector=" + idSector + '}';
    }
}
