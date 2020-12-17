/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import abstractFacades.AbstractFacade;
import abstractFacades.AbstractSectorContentFacade;
import entity.Sector;
import entity.SectorContent;
import exception.CreateException;
import exception.DeleteException;
import exception.ReadException;
import exception.UpdateException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * RESTful service for SectorContent entity. Includes CRUD operations.
 *
 * @author Xabier Carnero, Endika Ubierna, Markel Uralde
 * @since 04/12/2020
 * @version 1.0
 */
@Stateless
@Path("sectorcontent")
//Los @consume y @produce xml es que recibe o envia en formato xml por http.
public class SectorContentFacadeREST extends AbstractSectorContentFacade<SectorContent> {

    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(SectorContentFacadeREST.class.getName());
    /**
     * EntityManager for EMEX51CRUDServerPU persistence unit. Injects an
     * {@link EntityManager} instance.
     */
    @PersistenceContext(unitName = "EMEX51CRUDServerPU")
    private EntityManager em;

    /**
     * Class constructor. Call to the super class {@link AbstractFacade}.
     */
    public SectorContentFacadeREST() {
        super(SectorContent.class);
    }

    /**
     * Create (Insert) operation after receiving a Post HTTP order.
     *
     * @param entity The sectorcontent object in xml format.
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(SectorContent entity) {
        LOGGER.log(Level.INFO, "Metodo create de la clase ExistenceFacade");
        try {
            super.create(entity);
        } catch (CreateException ex) {
            Logger.getLogger(ArmyFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new InternalServerErrorException(ex);
        }
    }

    /**
     *
     * Edit (Update) operation after receiving a Delete HTTP order.
     *
     * @param entity The sectorcontent object in xml format.
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(SectorContent entity) {
        LOGGER.log(Level.INFO, "Metodo edit de la clase SectorContentFacade");
        try {
            super.edit(entity);
        } catch (UpdateException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    /**
     * Remove (Delete) operation after receiving a Delete HTTP order.
     *
     * @param id An id value of a SectorContent.
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        LOGGER.log(Level.INFO, "Metodo remove de la clase SectorContentFacade");
        try {
            super.remove(super.find(id));
        } catch (ReadException | DeleteException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    /**
     * Find (Select) operation after receiving a Get HTTP order.
     *
     * @param id An id value of an SectorContent.
     * @return An SectorContent object in xml format.
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public SectorContent find(@PathParam("id") Integer id) {
        LOGGER.log(Level.INFO, "Metodo find de la clase SectorContentFacade");
        try {
            return super.find(id);
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_XML})
    public List<SectorContent> findAllSectorContents() {
        LOGGER.log(Level.INFO, "Metodo findAllSectorContents de la clase SectorContentFacade");
        try {
            return super.getAllSectorContents();
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    @GET
    @Path("name/{name}")
    @Produces({MediaType.APPLICATION_XML})
    public List<SectorContent> findSectorContentsByName(@PathParam("name") String name) {
        LOGGER.log(Level.INFO, "Metodo find by name de la clase SectorContentFacade");
        try {
            return super.getSectorContentsByName(name);
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    //Por hacer
    @GET
    @Path("sectorId/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public List<SectorContent> findSectorContentBySector(@PathParam("id") Integer id) {
        LOGGER.log(Level.INFO, "Metodo find de la clase SectorContentFacade");
        List<SectorContent> sectorContents = null;
        sectorContents = em.createNamedQuery("findContentsBySector").setParameter("id", getEntityManager().find(Sector.class, id)).getResultList();
        return sectorContents;
    }

    /**
     * Gets an {@link EntityManager} instance.
     *
     * @return An {@link EntityManager} instance.
     */
    @Override
    protected EntityManager getEntityManager() {
        LOGGER.log(Level.INFO, "Metodo getEntityManager de la clase SectorContentFacade");
        return em;
    }

}
