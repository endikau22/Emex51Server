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
import exception.LoginNotExistException;

/**
 *
 * @author xabig
 */
public abstract class AbstractUserFacade extends AbstractFacade<User> {

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
    
    public User getUserByLogin(String login) throws ReadException, LoginNotExistException {
        try{
            List <User> users = getEntityManager().createNamedQuery("findAllUsers").getResultList();
            for(int i=0;i<users.size();i++){
               if(users.get(i).getLogin().compareToIgnoreCase(login)==0){
                   return users.get(i);
               }
            }
            throw new LoginNotExistException();
        } catch (Exception e){
            throw new ReadException("Error when trying to get all Users");
        }
    }
}
