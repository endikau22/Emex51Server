/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 * Esta clase es para determinar el tipo de sector que es
 * @author Xabier Carnero
 */
public enum SectorTipo implements Serializable{
    
   ARMAMENTO, //Para especificar que el sector es armamento
   CRIATURA; //Para especificar que el sector es criatura
    
}
