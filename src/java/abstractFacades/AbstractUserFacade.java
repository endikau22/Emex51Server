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
import java.util.logging.Level;
import java.util.logging.Logger;
import security.MailService;
import security.PasswordGenerator;

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
     *
     * @param entityClass <code>User</code>.
     */
    public AbstractUserFacade(Class<User> entityClass) {
        super(entityClass);
    }

    /**
     * Gets an {@link EntityManager} instance from one restful service from the
     * entities of the Area 51 project.
     *
     * @return An {@link EntityManager} instance.
     */
    @Override
    protected abstract EntityManager getEntityManager();

    /**
     * This method finds all Area51 users.
     *
     * @return A list containing the users.
     * @throws ReadException Thrown when any error produced during the read
     * operation.
     */
    public List<User> getAllUsers() throws ReadException {
        LOGGER.log(Level.INFO, "Metodo getAllUsers de la clase AbstractUserFacade");
        try {
            return getEntityManager().createNamedQuery("findAllUsers").getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all Users");
        }
    }

    /**
     * This method finds a <code>User</code> in the database to check if the
     * login is already recorded in the database.
     *
     * @param login A String.
     * @return An User instance.
     * @throws ReadException Thrown when any error produced during the read
     * operation.
     */
    public User getUserByLogin(String login) throws ReadException, LoginNotExistException {
        LOGGER.log(Level.INFO, "Metodo getUserByLogin de la clase AbstractUserFacade");
        try {
            List<User> users = getEntityManager().createNamedQuery("findAllUsers").getResultList();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getLogin().compareToIgnoreCase(login) == 0) {
                    return users.get(i);
                }
            }
            throw new LoginNotExistException();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all Users");
        }
    }

    public void temporalPassword(List<User> users, String email) throws UpdateException, EmailNotExistException {
        LOGGER.log(Level.INFO, "Temporal Password method from AbstractUSerFacade");
        boolean existe = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().compareToIgnoreCase(email) == 0) {
                existe = true;
                String newPassword = makePassword();
                MailService.sendRecoveryMail(email, newPassword);
                users.get(i).setPassword(newPassword);
                super.edit(users.get(i));
                break;
            }
        }
        if (!existe) {
            throw new EmailNotExistException();
        }
    }

    private String makePassword() {
        String newPassword = PasswordGenerator.getPassword(
                PasswordGenerator.MINUSCULAS
                + PasswordGenerator.MAYUSCULAS
                + PasswordGenerator.ESPECIALES, 10);
        return newPassword;
    }
}
