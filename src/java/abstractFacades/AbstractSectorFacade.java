/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFacades;

import entity.Sector;
import exception.CreateException;
import exception.ReadException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 * Restful service for {@link Sector}. Inherits from AbstractFacade. Contains createNamedQuerys from entity <code>Sector</code> in 
 * Area51 application.
 * @author Xabier Carnero.
 */
public abstract class AbstractSectorFacade extends AbstractFacade<Sector> {
    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(AbstractSectorFacade.class.getName());
    /**
     * Class constructor. Call to the super class {@link AbstractFacade}.
     * @param entityClass <code>Sector</code>.
     */
    public AbstractSectorFacade(Class<Sector> entityClass) {
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
     * insert operation against a MySQL database.
     * @param sector An instance of {@link Sector} entity class.
     */
    public void createSector(Sector sector) throws CreateException {
        LOGGER.log(Level.INFO, "Metodo create de la clase AbstractBossFacade");
        List <Sector> sectores;
        try {
             sectores = getEntityManager().createNamedQuery("findSectorByName").
                setParameter("name",sector.getName()).getResultList();
            if (!sectores.isEmpty())
                throw new CreateException("Incorrect sector name. "+sector.getName()+" is already recorded.");
            else
                    getEntityManager().persist(sector);
        }catch (RuntimeException e) {
            throw new CreateException("Error trying to create the sector.");
        }
    }      
    /**
     * This method finds all Area51 sectors.
     * @return A list containing the sectors.
     * @throws ReadException Thrown when any error produced during the read operation. 
     */
    public List<Sector> getAllSectors() throws ReadException {
        LOGGER.log(Level.INFO, "Metodo getAllSectors de la clase AbstractSectorFacade");
        try {
            return getEntityManager().createNamedQuery("findAllSectors").getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all sectors");
        }
    }
    /**
     * This method finds a <code>Sector</code> in the database to check if the name is already recorded in the database.
     * @param name A String.
     * @return A list of <code>Sector</code>.
     * @throws ReadException Thrown when any error produced during the read operation.
     */
    public List<Sector> getSectorsByName(String name) throws ReadException {
        LOGGER.log(Level.INFO, "Metodo getSectorsByName de la clase AbstractSectorFacade");
        try {
            return getEntityManager().createNamedQuery("findSectorByName")
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get sectors by name");
        }
    }

}
