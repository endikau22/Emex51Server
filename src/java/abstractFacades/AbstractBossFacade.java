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
 * Restful service for {@link Boss}. Inherits from AbstractFacade. Contains createNamedQuerys from entity 
 * <code>Boss</code> in Area51 application.
 * @author Xabier Carnero, Endika Ubierna, Markel Lopez de Uralde.
 */
public abstract class AbstractBossFacade extends AbstractFacade<Boss> {
    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(AbstractBossFacade.class.getName());  
    /**
     * Class constructor. Call to the super class {@link AbstractFacade}.
     * @param entityClass <code>Boss</code>.
     */  
    public AbstractBossFacade(Class<Boss> entityClass) {
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
     * Create method. Sends a create order to Hibernate. The latter executes an
     * insert operation against a MySQL database. Creates a Boss of Area51.
     * @param boss An instance of {@link Boss} entity class.
     */
    public void createBoss(Boss boss) throws CreateException,EmailExistException,LoginExistException{
        LOGGER.log(Level.INFO, "Metodo create de la clase AbstractBossFacade");
        List <User> user;
        try {
            //Mirar si el email está registrado
             user = getEntityManager().createNamedQuery("findUserByEmail").
                setParameter("email",boss.getEmail()).getResultList();
            if (!user.isEmpty())
                throw new EmailExistException();
            else{
                //Mirar si el login ya está registrado
                user = getEntityManager().createNamedQuery("findUserByLogin").
                    setParameter("login",boss.getLogin()).getResultList();
                if (!user.isEmpty())
                    throw new LoginExistException();
                else{
                    //descifrar la contraseña. Viene cifrada
                    //boss.setPassword(RSAClavePublica.getmyRSAClavePublica().descifrarTexto(boss.getPassword().getBytes()));
                    //Hashear la contraseña antes de guardarla en la base de datos
                    boss.setPassword(Hashing.cifrarTexto(boss.getPassword()));
                    getEntityManager().persist(boss);
                }
            }
        }catch (RuntimeException/*|IOException*/ e) {
            throw new CreateException("Error when trying to create " + boss.toString());
        }
    }   
}
