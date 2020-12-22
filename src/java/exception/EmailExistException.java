/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 * Exception thrown when a User tries to signUp in the application, but the email is already in use.
 * @version 1.0
 * @since 23/12/2020
 * @author Xabier Carnero, Endika Ubierna, Markel Lopez de Uralde.
 */
public class EmailExistException extends Exception{
    public EmailExistException(){
        super("Email already exists");
    }
}
