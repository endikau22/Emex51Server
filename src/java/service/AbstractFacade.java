/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Army;
import entity.Creature;
import entity.Sector;
import entity.SectorType;
import exception.CreateException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 * RESTful service for all the EMEX51 project entities.
 *
 * @author Xabier Carnero, Endika Ubierna, Markel Uralde
 * @since 04/12/2020
 * @version 1.0
 */
public abstract class AbstractFacade<T> {

    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(AbstractFacade.class.getName());
    /**
     * Attribute for this class. Able to handle every type of class.
     */
    private Class<T> entityClass;

    /**
     * Class constructor. Receives en entity class which willtake the place of
     * the generic java type <T>
     *
     * @param entityClass An entity class.
     */
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Gets an {@link EntityManager} instance from one restful service from the
     * entities of the Area 51 project.
     *
     * @return An {@link EntityManager} instance.
     */
    protected abstract EntityManager getEntityManager();

    /**
     * Create method. Sends a create order to Hibernate. The latter executes an
     * insert operation against a MySQL database.
     *
     * @param entity An entity class. This Entity replaces the generic Java type
     * <T>.
     */
    public void create(T entity) throws CreateException{
        LOGGER.log(Level.INFO, "Metodo create de la clase AbstractFacade");
        try {
        getEntityManager().persist(entity);    
        } catch (Exception e){
            throw new CreateException("Error when trying to create "+entity.toString());
        }
        
    }

    /**
     * Edit method. Sends a edit order to Hibernate. The latter executes an
     * update operation against a MySQL database.
     *
     * @param entity An entity class. This Entity replaces the generic Java type
     * <T>.
     */
    public void edit(T entity) {
        LOGGER.log(Level.INFO, "Metodo edit de la clase AbstractFacade");
        getEntityManager().merge(entity);
    }

    /**
     * Remove method. Sends a remove order to Hibernate. The latter executes a
     * delete operation against a MySQL database.
     *
     * @param entity An entity class. This Entity replaces the generic Java type
     * <T>.
     */
    public void remove(T entity) {
        LOGGER.log(Level.INFO, "Metodo remove de la clase AbstractFacade");
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Find method. Sends a find order to Hibernate. The latter executes a
     * Select operation against a MySQL database Get HTTP petition.
     *
     * @param id The id value .
     * @return An object.
     */
    public T find(Object id) {
        LOGGER.log(Level.INFO, "Metodo find de la clase AbstractFacade");
        return getEntityManager().find(entityClass, id);
    }

    public List<Army> findById(Integer sectorId) {
        LOGGER.log(Level.INFO, "Find by id method from ArmyFacade");
        return getEntityManager().createNamedQuery("findArmyBySector").
                setParameter("sector", getEntityManager().find(Sector.class, sectorId)).getResultList();
    }

    public List<Army> findArmyByName(String name) {
        LOGGER.log(Level.INFO, "Find by name method from ArmyFacade");
        return getEntityManager().createNamedQuery("findArmyByName").setParameter("name", name).getResultList();
    }

    public List<Creature> findCreatureById(Integer sectorId) {
        LOGGER.log(Level.INFO, "Find by id method from CreatureFacade");
        return getEntityManager().createNamedQuery("findCreatureBySector").
                setParameter("sector", getEntityManager().find(Sector.class, sectorId)).getResultList();
    }

    public List<Creature> findCreatureByName(String name) {
        LOGGER.log(Level.INFO, "Find by name method from CreatureFacade");
        return getEntityManager().createNamedQuery("findCreatureByName").setParameter("name", name).getResultList();
    }

    public Object findSectorById(Integer sectorId) {
        LOGGER.log(Level.INFO, "Find by id method from SectorFacade");
        return getEntityManager().createNamedQuery("findSectorById").setParameter("id", sectorId);
    }

    public List<Sector> findAllSectors() {
        LOGGER.log(Level.INFO, "Find all method from SectorFacade");
        return getEntityManager().createNamedQuery("findAllSectors").getResultList();
    }

    public List<Sector> findSectorsByType(SectorType type) {
        LOGGER.log(Level.INFO, "Find By Type method from SectorFacade");
        return getEntityManager().createNamedQuery("findSectorByType").setParameter("type", type).getResultList();
    }
}
