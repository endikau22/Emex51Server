/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFacades;

import exception.ReadException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author xabig
 */
public abstract class AbstractUserFacade<User> extends AbstractFacade<User> {

    public AbstractUserFacade(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    protected abstract EntityManager getEntityManager();

    public List<User> getAllUsers() throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findAllUsers").getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all Users");
        }
    }

    public User getUserByLogin(String login) throws ReadException {
        try {
            return (User) getEntityManager().createNamedQuery("findUsersByLogin").setParameter("login", login).getSingleResult();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get User by login");
        }
    }

    public User getUserByEmail(String email) throws ReadException {
        try {
            return (User) getEntityManager().createNamedQuery("findUserByEmail").setParameter("email", email).getSingleResult();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get User by login");
        }
    }

}
