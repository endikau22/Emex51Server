/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import abstractFacades.AbstractUserFacade;
import entity.User;
import exception.CreateException;
import exception.DeleteException;
import exception.EmailNotExistException;
import exception.LoginNotExistException;
import exception.ReadException;
import exception.UpdateException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * RESTful service for User entity. Includes CRUD operations.
 *
 * @author Xabier Carnero, Endika Ubierna, Markel Lopez de Uralde
 * @since 04/12/2020
 * @version 1.0
 */
@Stateless
@Path("user")
public class UserFacadeREST extends AbstractUserFacade {
    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(UserFacadeREST.class.getName());
    /**
     * EntityManager for EMEX51CRUDServerPU persistence unit. Injects an
     * {@link EntityManager} instance.
     */
    @PersistenceContext(unitName = "EMEX51CRUDServerPU")
    private EntityManager em;
    /**
     * Class constructor. Call to the super class {@link AbstractUserFacade}.
     */
    public UserFacadeREST() {
        super(User.class);
    }
    /**
     * Create (Insert) operation after receiving a Post HTTP order.
     * @param entity An user object in xml format.
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(User entity) {
        LOGGER.log(Level.INFO, "Metodo create de la clase UserFacade");
        try {
            super.create(entity);
        } catch (CreateException ex) {
            Logger.getLogger(ArmyFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new ForbiddenException(ex);
        }
    }
    /**
     * Edit (Update) operation after receiving a Delete HTTP order.
     * @param entity The user object in xml format.
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    @Override
    public void edit(User entity) {
        LOGGER.log(Level.INFO, "Metodo edit de la clase UserFacade");
        try {
            super.edit(entity);
        } catch (UpdateException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }
    /**
     * Remove (Delete) operation after receiving a Delete HTTP order.
     * @param id An id value of an User.
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        LOGGER.log(Level.INFO, "Metodo remove de la clase UserFacade");
        try {
            super.remove(super.find(id));
        } catch (ReadException | DeleteException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }
    /**
     * Find (Select) operation after receiving a Get HTTP order.
     * @param id An id value of an User.
     * @return A User object in xml format.
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public User find(@PathParam("id") Integer id) {
        LOGGER.log(Level.INFO, "Metodo find de la clase UserFacade");
        try {
            return super.find(id);
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }
    /**
     * This method finds all Area51 <code>User</code>.
     * @return A list of {@link User}.
     */
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_XML})
    public List<User> findAllUsers() {
        LOGGER.log(Level.INFO, "Metodo findAllUsers de la clase UsersFacade");
        try {
            return super.getAllUsers();
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getCause());
        }
    }
    /**
     * This method finds an Area51 <code>User</code> whose login attibute is the same as the String parameter.
     * @param login A String. Represents the login attibute of an Area51 user.
     * @return An user.
     */
    @GET
    @Path("login/{login}")
    @Produces({MediaType.APPLICATION_XML})
    public User findUsersByLogin(@PathParam("login") String login) {
        try {
            LOGGER.log(Level.INFO, "Metodo find by login de la clase UserFacade");
            return super.getUserByLogin(login);
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        } catch (LoginNotExistException ex) {
            Logger.getLogger(UserFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new ForbiddenException(ex.getMessage());
        }
    }
    /**
     * This method assigns a new password to the user. 
     * @param email The email of the user.
     */
    @PUT
    @Path("forgotPassword/")
    @Consumes({MediaType.APPLICATION_XML})
    @Override
    public void editForgotPassword(User user) {
        LOGGER.log(Level.INFO, "Metodo editForgotPassword de la clase UserFacade");
        try {
            super.editForgotPassword(user);
        }catch (UpdateException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex);
        }catch (EmailNotExistException ex) {
            LOGGER.severe(ex.getMessage());
            throw new NotFoundException(ex);
        }
    }
    /**
     * This method handles the petition of an user for a new password. 
     * Checks if the current password is correct and refreshes it with a new one.
     * @param oldPass The current password of an {@link User}.
     * @param newPass The new password of an {@link User}.
     * @param user An user who asked for a new password.
     */
    @PUT
    @Path("changePassword/{oldPass}/{newPass}")
    @Consumes({MediaType.APPLICATION_XML})
    @Override
    public void editChangePassword(@PathParam("oldPass") String oldPass,@PathParam("newPass") String newPass,User user) {
        LOGGER.log(Level.INFO, "Metodo editChangePassword de la clase UserFacade");
        try {
            super.editChangePassword(oldPass,newPass,user);
        }catch (UpdateException|EmailNotExistException ex) {
            LOGGER.severe(ex.getMessage());
            throw new NotFoundException(ex);
        }
    }
    /**
     * This method checks if the credentials of the <code>User</code> are correct. If so the user is authenticated. 
     * @param user An user trying to authenticate into the application.
     * @return An user authenticated.
     */
    @GET
    @Path("loginUser/{login}/{password}")
    @Produces({MediaType.APPLICATION_XML})
    public User loginUser(@PathParam("login") String login,@PathParam("password") String password) {
        //Este método es para comprobar un login. En la abstracta se mira que coincide la user y password
        LOGGER.log(Level.INFO, "Metodo loginUser de la clase UserFacade");
        try {
            return super.loginUser(login,password);
        } catch (LoginNotExistException ex) {
            System.out.println(ex.getMessage());
            throw new ForbiddenException(ex);
        }catch (ReadException ex1) {
            throw new InternalServerErrorException(ex1.getMessage());
        }catch (IOException ex2) {
            throw new InternalServerErrorException(ex2);
        }
    }
    /**
     * Gets an {@link EntityManager} instance.
     * @return An {@link EntityManager} instance.
     */
    @Override
    protected EntityManager getEntityManager() {
        LOGGER.log(Level.INFO, "Metodo getEntityManager de la clase UserFacade");
        return em;
    }
}
