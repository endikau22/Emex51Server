/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFacades;

import security.Hashing;
import entity.User;
import entity.UserPrivilege;
import entity.Visitor;
import exception.CreateException;
import exception.EmailExistException;
import exception.LoginExistException;
import exception.ReadException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import security.PrivateKeyServer;

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
        List <Visitor> visitors;
        try {
            visitors = getEntityManager().createNamedQuery("findAllVisitors").getResultList();
            return visitors;
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all visitors");
        }
    }
    /**
     * Create method. Sends a create order to Hibernate. The latter executes an
     * insert operation against a MySQL database. Creates a Visitor of Area51.
     * @param boss An instance of {@link Visitor} entity class.
     */
    public void createVisitor(Visitor visitor) throws CreateException,EmailExistException,LoginExistException{
        LOGGER.log(Level.INFO, "Metodo create de la clase AbstractVisitorFacade");
        List <User> user;
        try {
            //Mirar si el email está registrado
             user = getEntityManager().createNamedQuery("findUserByEmail").
                setParameter("email",visitor.getEmail()).getResultList();
            if (!user.isEmpty())
                throw new EmailExistException();
            else{
                //Mirar si el login ya está registrado
                user = getEntityManager().createNamedQuery("findUserByLogin").
                    setParameter("login",visitor.getLogin()).getResultList();
                if (!user.isEmpty())
                    throw new LoginExistException();
                else{
                    //descifrar la contraseña. Viene cifrada
                    visitor.setPassword(new String(PrivateKeyServer.descifrarTexto(visitor.getPassword())));
                    //Hashear la contraseña antes de guardarla en la base de datos
                    visitor.setPassword(Hashing.cifrarTexto(visitor.getPassword()));
                    visitor.setPrivilege(UserPrivilege.VISITOR);
                    getEntityManager().persist(visitor);
                }
            }
        }catch (RuntimeException e) {
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
