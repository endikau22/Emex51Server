/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFacades;

import security.Hashing;
import entity.User;
import entity.Visitor;
import exception.CreateException;
import exception.EmailExistException;
import exception.LoginExistException;
import exception.ReadException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import service.BossFacadeREST;

/**
 *
 * @author xabig
 */
public abstract class AbstractVisitorFacade extends AbstractFacade<Visitor> {
    
    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(BossFacadeREST.class.getName());

    public AbstractVisitorFacade(Class<Visitor> entityClass) {
        super(entityClass);
    }

    @Override
    protected abstract EntityManager getEntityManager();

    public List<Visitor> getAllVisitors() throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findAllVisitors").getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all visitors");
        }
    }

    public void createVisitor(Visitor visitor) throws CreateException, LoginExistException, EmailExistException {
        LOGGER.log(Level.INFO, "Metodo create de la clase AbstractBossFacade");
        try {
            visitor.setPassword(Hashing.cifrarTexto(visitor.getPassword()));
            super.checkLoginAndEmailNotExist(visitor.getLogin(), visitor.getEmail());
            super.create(visitor);
        } catch (ReadException e) {
            throw new CreateException("Error when trying to create " + visitor.toString());
        }
    }

    public List<Visitor> getVisitorsByName(String name) throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findVisitorsByName")
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get visitors by name");
        }
    }
}
