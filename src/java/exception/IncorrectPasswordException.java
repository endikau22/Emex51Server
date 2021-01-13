/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 * Exception thrown when a User tries to signIn in the application, but with a incorrect password.
 * @version 1.0
 * @since 23/12/2020
 * @author Xabier Carnero, Endika Ubierna, Markel Lopez de Uralde.
 */
public class IncorrectPasswordException extends Exception{
    public IncorrectPasswordException(){
        super("Incorrect password");
    }
}
