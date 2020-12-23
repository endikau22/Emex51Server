/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author xabig
 */
public class EmailNotExistException extends Exception{
    public EmailNotExistException(){
        super("Email does not exist");
    }
}
