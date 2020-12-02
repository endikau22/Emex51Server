/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 2dam
 */
@Entity
@Table(name="sector",schema="emex51db")
@XmlRootElement
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @Id
    private Integer idSector;
    /**
     * 
     */
    @ManyToMany(fetch=EAGER)//cascade = MERGE???
    @JoinTable(schema="emex51db", name="visitor_sector")
    private ArrayList <Visitor> visitante;
    /**
     * 
     */
    @ManyToMany(fetch=EAGER)//cascade = MERGE???
    @JoinTable(schema="emex51db", name="employee_sector")
    private ArrayList <Employee> empleado;
    /**
     * 
     */
    private SectorTipo tipo;
    
}
