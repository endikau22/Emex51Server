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
 * Restful service for <code>Visitor</code>. Inherits from AbstractFacade. Contains createNamadQuerys from entity Visitor in 
 * Area51 application.
 * @author Xabier Carnero.
 */
public abstract class AbstractVisitorFacade extends AbstractFacade<Visitor> {
    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(AbstractVisitorFacade.class.getName());
    /**
     * Class constructor. Call to the super class {@link AbstractFacade}.
     * @param entityClass <code>Visitor</code>.
     */    
    public AbstractVisitorFacade(Class<Visitor> entityClass) {
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
     * This method finds all Area51 visitors.
     * @return A list containing visitors.
     * @throws ReadException Thrown when any error produced during the read operation.
     */  
    public List<Visitor> getAllVisitors() throws ReadException {
        LOGGER.log(Level.INFO, "Metodo getAllVisitors de la clase AbstractVisitorFacade");
        try {
            return getEntityManager().createNamedQuery("findAllVisitors").getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all visitors");
        }
    }
    /**
     * Create method. Creates a new {@link Employee} instance using Hibernate. The latter executes an
     * insert operation against a MySQL database.
     * @param visitor An instance of {@link Visitor} entity class.
     */
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
    /**
     * This method finds a <code>Visitor</code> by the class attribute name.
     * @param name The class attribure name.
     * @return A list of <code>Visitor</code>.
     * @throws ReadException Thrown when any error produced during the read operation.
     */
    public List<Visitor> getVisitorsByName(String name) throws ReadException {
        LOGGER.log(Level.INFO, "Metodo getVisitorsByName de la clase AbstractVisitorFacade");
        try {
            return getEntityManager().createNamedQuery("findVisitorsByName")
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get visitors by name");
        }
    }
}
