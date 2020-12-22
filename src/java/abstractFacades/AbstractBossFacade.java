/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFacades;

import security.Hashing;
import exception.CreateException;
import exception.ReadException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import entity.Boss;
import entity.User;
import exception.EmailExistException;
import exception.LoginExistException;

/**
 *
 * @author xabig
 */
public abstract class AbstractBossFacade extends AbstractFacade<Boss> {

    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(AbstractBossFacade.class.getName());

    public AbstractBossFacade(Class<Boss> entityClass) {
        super(entityClass);
    }

    @Override
    protected abstract EntityManager getEntityManager();

    public List<Boss> getAllBosses() throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findAllBosses").getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all Bosses");
        }
    }

    public List<Boss> getBossesByName(String name) throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findBossesByName")
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get Bosses by name");
        }
    }

    public void createBoss(Boss boss) throws CreateException, LoginExistException, EmailExistException {
        LOGGER.log(Level.INFO, "Metodo create de la clase AbstractBossFacade");
        try {
            boss.setPassword(Hashing.cifrarTexto(boss.getPassword()));
            super.checkLoginAndEmailNotExist(boss.getLogin(), boss.getEmail());
            super.create(boss);
        } catch (ReadException e) {
            throw new CreateException("Error when trying to create " + boss.toString());
        }
    }
    
    
        public Boss getUserByLogin (String login){
            return null;
        }

}
