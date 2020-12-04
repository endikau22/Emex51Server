/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import static javax.persistence.CascadeType.MERGE;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity JPA class for visitor data. This class inherits of the superclass User.
 * The property of this class is dni,requested visit, visited, visit date.
 * It also contains relational fields for getting the {@link Employee} and the {@link Sector}.
 * @since 23/11/2020
 * @version 1.0
 * @author Xabier Carnero, Endika Ubierna, Markel Uralde.
 */
@Entity
@Table(name="visitor",schema="emex51db")
@NamedQueries({
    @NamedQuery(name="findAllVisitors",
            query="SELECT v FROM Visitor v ORDER BY v.fullName DESC"
    ),
    @NamedQuery(name="findVisitorsBylogin",
            query="SELECT v FROM Visitor v WHERE v.login = :login"
    )
})
@DiscriminatorValue(value="Visitor")
public class Visitor extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The DNI of the visitor.
     */
    private String dni;
    /**
     * The request date of the visit.
     */
    private LocalDateTime requestedVisit;
    /**
     * The response. True or false. 
     */
    private Boolean answerVisit;
    /**
     * Visited value. True or false.
     */
    private Boolean visited;
    /**
     * The date of the visitors visit.
     */
    private LocalDateTime visitDate;
    /**
     * The {@link Employee} who manage the visitors visit.
     */
    @ManyToOne
    private Employee employee;
    /**
     * The Set of {@link Sector} visited by the visitor.
     */
    @ManyToMany(fetch = EAGER,cascade = MERGE)
    @JoinTable(schema = "emex51db", name = "visited_sector")
    private Set <Sector> visitedSector;
    
    /**
     * Class constructor.
     */
    public Visitor() {
    }

    /**
     * Gets the dni of the visitor.
     * @return The dni value.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Sets the dni of the visitor.
     * @param dni The dni value.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Gets the date of the requested visit.
     * @return The date of the requested visit value.
     */
    public LocalDateTime getRequestedVisit() {
        return requestedVisit;
    }

    /**
     * Sets the date of the requested visit.
     * @param requestedVisit The date of the requested visit value.
     */
    public void setRequestedVisit(LocalDateTime requestedVisit) {
        this.requestedVisit = requestedVisit;
    }

    /**
     * Gets the boolean value of the response to the visit date request.
     * @return The visit response value. True or false.
     */
    public boolean isVisitaRespuesta() {
        return answerVisit;
    }

    /**
     * Sets the boolean value of the response to the visit date request.
     * @param visitaRespuesta The visit response value. True or false.
     */
    public void setVisitaRespuesta(boolean visitaRespuesta) {
        this.answerVisit = visitaRespuesta;
    }

    /**
     * Gets the visited value
     * @return The visited value. True or false.
     */
    public boolean isVisitado() {
        return visited;
    }

    /**
     * Sets the visited value.
     * @param visitado The visited value. 
     */
    public void setVisitado(boolean visitado) {
        this.visited = visitado;
    }

    /**
     * Gets the date of the visit.
     * @return The date of the visit value.
     */
    public LocalDateTime getVisitDate() {
        return visitDate;
    }

    /**
     * Sets the date of the visit.
     * @param visitDate The date of the visit value.
     */
    public void setVisitDate(LocalDateTime visitDate) {
        this.visitDate = visitDate;
    }

    /**
     * Gets the {@link Employee} who manage the visit.
     * @return The {@link Employee} who manage the visit value.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets the {@link Employee} who manage the visit.
     * @param employee The {@link Employee} who manage the visit value.
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
   
    /**
     * Gets the {@link Sector} visited by the visitor.
     * @return The {@link Sector} value.
     */
    @XmlTransient
    public Set<Sector> getSectores() {
        return visitedSector;
    }

    /**
     * Sets the {@link Sector} visited by the visitor. 
     * @param sectores The {@link Sector} value.
     */
    public void setSectores(Set<Sector> sectores) {
        this.visitedSector = sectores;
    } 
}
