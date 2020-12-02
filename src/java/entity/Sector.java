/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Employee;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import entity.Visitor;

/**
 *
 * @author 2dam
 */
@Entity
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer idSector;
    private ArrayList <Visitor> visitante;
    private ArrayList <Employee> empleado;
    private SectorTipo tipo;

    
}
