/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFacades;

import exception.ReadException;
import java.util.List;
import javax.persistence.EntityManager;
import entity.User;
import exception.EmailNotExistException;
import exception.LoginNotExistException;
import exception.UpdateException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.persistence.NoResultException;
import mail.MailService;
import mail.RandomMailPasswordGenerator;
import security.Hashing;
import security.PrivateKeyServer;

/**
 * Restful service for <code>User</code>. Inherits from AbstractFacade. Contains
 * createNamadQuerys from entity User in Area51 application.
 *
 * @author Xabier Carnero.
 */
public abstract class AbstractUserFacade extends AbstractFacade<User> {
    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(AbstractUserFacade.class.getName());
    /**
     * Class constructor. Call to the super class {@link AbstractFacade}.
     * @param entityClass <code>User</code>.
     */
    public AbstractUserFacade(Class<User> entityClass) {
        super(entityClass);
    }
    /**
     * Gets an {@link EntityManager} instance from one restful service from the
     * entities of the Area 51 project.
     * @return An {@link EntityManager} instance.
     */
    @Override
    protected abstract EntityManager getEntityManager();
     /**
     * This method finds all Area51 users.
     * @return A list containing the users.
     * @throws ReadException Thrown when any error produced during the read operation. 
     */
    public List<User> getAllUsers() throws ReadException {
        LOGGER.log(Level.INFO, "Metodo getAllUsers de la clase AbstractUserFacade");
        List <User> users;
        try {
            //Antes de devolver vamos a vaciar las passwords
            users = getEntityManager().createNamedQuery("findAllUsers").getResultList();
            for(User u:users){
                getEntityManager().detach(u);
                u.setPassword("");
            }
                
            return users;
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all Users");
        }
    }
    /**
     * This method finds a <code>User</code> in the database to check if the login is already recorded in the database.
     * @param login A String.
     * @return An User instance.
     * @throws ReadException Thrown when any error produced during the read operation.
     */    
    public User getUserByLogin(String login) throws ReadException, LoginNotExistException {
        LOGGER.log(Level.INFO, "Metodo getUserByLogin de la clase AbstractUserFacade");
        User user = null;
        User newUser= null;
        try{         
            user = (User) getEntityManager().createNamedQuery("findUserByLogin").setParameter("login",login).getSingleResult();
            newUser = new User();
            newUser.setPrivilege(user.getPrivilege());
        }catch(NoResultException e){
            LOGGER.log(Level.SEVERE, e.getMessage());
            throw new LoginNotExistException();
        }catch(RuntimeException e){
            LOGGER.log(Level.SEVERE, e.getMessage());
            throw new ReadException("Impossible to show Users by login at the moment.");
        }
        return newUser;
    }
    /**
     * Edits the user. Assigns a new random password to the user.
     * @param email The user email.
     */
    public void editForgotPassword(User usersMail) throws UpdateException,EmailNotExistException{
        LOGGER.log(Level.INFO, "Metodo editForgotPassword de la clase AbstractUserFacade");
        User user = null;
        try {
            user = (User) getEntityManager().createNamedQuery("findUserByEmail").setParameter("email",usersMail.getEmail()).getSingleResult();
            //El usuario está. Crear una contraseña aleatoria.
            user.setPassword(RandomMailPasswordGenerator.createRandomPassword());
                //mandar mail al usuario de la nueva contraseña que se le envia
            MailService.sendRecoveryMail(user.getEmail(),user.getPassword());
                //hashear la contraseña antes de editar en la base de datos
            user.setPassword(Hashing.cifrarTexto(user.getPassword())); 
            super.edit(user);
        }catch(NoResultException e){
            throw new EmailNotExistException();
        }catch(RuntimeException e){
            throw new UpdateException("Something happen, at the moment we can´t reset the password.");
        } catch (MessagingException ex) {
            Logger.getLogger(AbstractUserFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new UpdateException("Something happen, at the moment we can´t reset the password.");
        }
    }
    /**
     * Edit (Update) the user. Registers the new user password.
     * @param entity The user object in xml format.
     */
    public void editChangePassword(String oldPass,String newPass,User userMail) throws UpdateException,EmailNotExistException {
        LOGGER.log(Level.INFO, "Metodo editChagePassword de la clase UserFacade");
        //Vamos a hacer una chapucilla como no hace bien el edit parece vamos a buscar el user en la bbdd y lo editamos aqui
        User user = null;
        try {
            //Descifrar contrasenia
            oldPass = new String(PrivateKeyServer.descifrarTexto(oldPass));
            //Hashear la contraseña vieja y comparar con la del user
            //No se si el user cuando entra en la aplicacion vuele con la password hasheada sino no hashear la old
            oldPass = Hashing.cifrarTexto(oldPass);
            //Buscamos un user
            user = (User) getEntityManager().createNamedQuery("findUserByEmail")
                    .setParameter("email",userMail.getEmail()).getSingleResult();
            if(oldPass.equalsIgnoreCase(user.getPassword())){
                //Mandar email al usuario
                MailService.sendPasswordChangedMail(userMail.getEmail(),new String(PrivateKeyServer.descifrarTexto(newPass)));
                //Hashear la nueva contraseña y actualizar el user
                String contraseniaNueva = new String(PrivateKeyServer.descifrarTexto(newPass));
                user.setPassword(Hashing.cifrarTexto(contraseniaNueva));
                super.edit(user);
            }else
                //Si el mail no coincide enviar error de mail incorrecto
                throw new EmailNotExistException();
            //El método de sendMail de la clase MailService lanza este error es justo el escalón inferior de exception
        } catch (UpdateException ex) {
            LOGGER.severe(ex.getMessage());
            throw new UpdateException("Couldn´t update the new password");
        } catch (MessagingException ex) {
            Logger.getLogger(AbstractUserFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new UpdateException("Something happen, at the moment we can´t reset the password.");
        }
    }
    /**
     * This method checks a login operation. Compares the user attributes login and password if they are stored in the database.
     * If thats the case the user goes through if not an error is thrown and a message is shown informing the user.
     * @param user An User instance.
     * @return An user.
     * @throws LoginNotExistException Thrown when the credentials of the user are not existant in the database.
     */
    public User loginUser(String login, String password) throws LoginNotExistException,ReadException, IOException{
        LOGGER.log(Level.INFO, "Metodo findLoginUser de la clase AbstractUserFacade");
        User user = null;
        try {
            //Primero descifrar la password
            password = new String(PrivateKeyServer.descifrarTexto(password));
            //Hashear la password porque en la base de datos está hasheada
            password = Hashing.cifrarTexto(password);
            user = (User) getEntityManager().createNamedQuery("findLoginExists").setParameter("login",login)
                    .setParameter("password",password).getSingleResult();
            return user;
        }catch(NoResultException e){
                throw new LoginNotExistException(); 
        }catch (RuntimeException ex) {
            LOGGER.severe(ex.getMessage());
            throw new ReadException("Error during the operation");
        }
    }
    /**
     * This method is used to clean the password values of the users before they are sent to the client.
     * @param users
     * @return 
     */
  /*  private List<User> cleanPasswords(List<User> users){
        for(User u:users)
            u.setPassword("");
        return users;
    }*/
}
