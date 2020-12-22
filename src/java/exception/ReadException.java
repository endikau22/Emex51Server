/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 * This class represents any exception produced during Area 51 data reading in application storage.
 * @author Xabier Carnero, Markel Lopez de Uralde, Endika Ubierna
 */
public class ReadException extends Exception{
    /**
     * Class constructor. Creates a new instance <code>ReadException</code>.
     */
    public ReadException(){
        
    }
    /**
     * Class constructor. Creates a new instance <code>ReadException</code>.
     * @param message A String with the message of the exception.
     */
    public ReadException(String message){
        super(message);
    }
}
