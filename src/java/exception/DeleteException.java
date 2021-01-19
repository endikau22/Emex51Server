/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 * This class represents any exception produced during Area 51 object remove in application storage.
 * @author Xabier Carnero, Markel Lopez de Uralde, Endika Ubierna
 */
public class DeleteException extends Exception{
    /**
     * Class constructor. Creates a new instance <code>DeleteException</code>.
     */
    public DeleteException(){
        
    }
    /**
     * Class constructor. Creates a new instance <code>DeleteException</code>.
     * @param message A String with the message of the exception.
     */
    public DeleteException(String message){
        super(message);
    }
}
