/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Boss;
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
 * RESTful service for Boss entity. Includes CRUD operations.
 * @author Xabier Carnero, Endika Ubierna, Markel Uralde
 * @since 04/12/2020
 * @version 1.0
 */
@Stateless
@Path("boss")
public class BossFacadeREST extends AbstractFacade<Boss> {
    /**
     * Logger for this class.
     */
    private static final Logger LOGGER=Logger.getLogger(BossFacadeREST.class.getName());

    /**
     * EntityManager for EMEX51CRUDServerPU persistence unit. Injects an {@link EntityManager} instance.
     */
    @PersistenceContext(unitName = "EMEX51CRUDServerPU")
    private EntityManager em;

    /**
     * Class constructor. Call to the super class {@link AbstractFacade}.
     */
    public BossFacadeREST() {
        super(Boss.class);
    }

    /**
     * Create (Insert) operation after receiving a Post HTTP order.
     * @param entity The boss object in xml format.
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Boss entity) {
        LOGGER.log(Level.INFO,"Metodo create de la clase BossFacade");
        super.create(entity);
    }

    /**
     * Edit (Update) operation after receiving a Delete HTTP order.
     * @param entity The boss object in xml format.
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(Boss entity) {
        LOGGER.log(Level.INFO,"Metodo edit de la class BossFacade");
        super.edit(entity);
    }

    /**
     * Remove (Delete) operation after receiving a Delete HTTP order. 
     * @param id An id value.
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        LOGGER.log(Level.INFO,"Metodo remove de la clase BossFacade");
        super.remove(super.find(id));
    }

    /**
     * Find (Select) operation after receiving a Get HTTP order.
     * @param id An id value.
     * @return A Boss object in xml format.
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Boss find(@PathParam("id") Integer id) {
        LOGGER.log(Level.INFO,"Metodo find de la clase BossFacade");
        return super.find(id);
    }

    /**
     * Gets an {@link EntityManager} instance.
     * @return An {@link EntityManager} instance.
     */
    @Override
    protected EntityManager getEntityManager() {
        LOGGER.log(Level.INFO,"Metodo getManager de la clase BossFacade");
        return em;
    }
    
}
