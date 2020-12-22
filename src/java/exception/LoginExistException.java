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
public class LoginExistException extends Exception{
    public LoginExistException(){
        super("Login already exists");
    }
}
