/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 * This class represents any exception produced during Area 51 object creation in application storage.
 * @author Xabier Carnero, Markel Lopez de Uralde, Endika Ubierna
 */
public class CreateException extends Exception{
    /**
     * Class constructor. Creates a new instance <code>CreateException</code>.
     */
    public CreateException(){
        
    }
    /**
     * Class constructor. Creates a new instance <code>CreateException</code>. 
     * @param msg A String with the message of the exception.
     */
    public CreateException(String message){
       super(message); 
    }
}
