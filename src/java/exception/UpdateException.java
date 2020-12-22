/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 * This class represents any exception produced during Area 51 object update in application storage.
 * @author Xabier Carnero, Markel Lopez de Uralde, Endika Ubierna
 */
public class UpdateException extends Exception{
    /**
     * Class constructor. Creates a new instance <code>UpdateException</code>.
     */
    public UpdateException(){
        
    }
    /**
     * Class constructor. Creates a new instance <code>UpdateException</code>.
     * @param message A String with the message of the exception.
     */
    public UpdateException(String message){
        super(message);
    }
}
