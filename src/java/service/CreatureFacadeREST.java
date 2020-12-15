/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Army;
import entity.Creature;
import entity.Sector;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * RESTful service for Creature entity. Includes CRUD operations.
 * @author Xabier Carnero, Endika Ubierna, Markel Uralde
 * @since 04/12/2020
 * @version 1.0
 */
@Stateless
@Path("creature")
public class CreatureFacadeREST extends AbstractFacade<Creature> {
    /**
     * Logger for this class.
     */
    private static final Logger LOGGER=Logger.getLogger(CreatureFacadeREST.class.getName());
    /**
     * EntityManager for EMEX51CRUDServerPU persistence unit. Injects an {@link EntityManager} instance.
     */
    @PersistenceContext(unitName = "EMEX51CRUDServerPU")
    private EntityManager em;

    /**
     * Class constructor. Call to the super class {@link AbstractFacade}.
     */
    public CreatureFacadeREST() {
        super(Creature.class);
    }

    /**
     * Create (Insert) operation after receiving a Post HTTP order.
     * @param entity The creature object in xml format.
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Creature entity) {
        LOGGER.log(Level.INFO,"Metodo create de la clase CreatureFacade");
        super.create(entity);
    }

    /**
     * Edit (Update) operation after receiving a Delete HTTP order.
     * @param entity The creature object in xml format.
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(Creature entity) {
        LOGGER.log(Level.INFO,"Metodo edit de la clase CreatureFacade");
        super.edit(entity);
    }

    /**
     * Remove (Delete) operation after receiving a Delete HTTP order. 
     * @param id An id value.
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        LOGGER.log(Level.INFO,"Metodo remove de la clase CreatureFacade");
        super.remove(super.find(id));
    }

    /**
     * Find (Select) operation after receiving a Get HTTP order.
     * @param id An id value.
     * @return A Creature object in xml format.
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Creature find(@PathParam("id") Integer id) {
        LOGGER.log(Level.INFO,"Metodo find de la clase CreatureFacade");
        return super.find(id);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public List <Creature> findAllCreatures() {
        LOGGER.log(Level.INFO,"Metodo findAllCreatures de la clase CreatureFacade");
        List <Creature> creatures = null;
        em.createNamedQuery("findAllCreature").getResultList();
        return creatures;
    }
    
    @GET
    @Path("name/{name}")
    @Produces({MediaType.APPLICATION_XML})
    public List <Creature> findCreatureByName(@PathParam("name") String name) {
        LOGGER.log(Level.INFO,"Metodo find por nombre de la clase CreatureFacade");
        List <Creature> creatures = null;
        creatures = em.createNamedQuery("findCreatureByName").setParameter("name", name).getResultList();
        return creatures;
    }

    @GET
    @Path("sector/{sectorId}")
    @Produces({MediaType.APPLICATION_XML})
    public List <Creature> findCreatureBySector(@PathParam("sectorId") Integer sectorId) {
        LOGGER.log(Level.INFO,"Metodo find por sector de la clase CreatureFacade");
        List <Creature> creatures = null;
        creatures = em.createNamedQuery("findCreatureBySector").setParameter("sector", em.find(Sector.class,sectorId)).
                getResultList();

        return creatures;
    }

    /**
     * Gets an {@link EntityManager} instance.
     * @return An {@link EntityManager} instance.
     */
    @Override
    protected EntityManager getEntityManager() {
        LOGGER.log(Level.INFO,"Metodo getEntityManager de la clase CreatureFacade");
        return em;
    }
    
}