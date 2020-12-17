/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Boss;
import exception.CreateException;
import exception.ReadException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author xabig
 */
public abstract class AbstractSectorFacade<Sector> extends AbstractFacade<Sector> {

    public AbstractSectorFacade(Class<Sector> entityClass) {
        super(entityClass);
    }

    @Override
    protected abstract EntityManager getEntityManager();

    public List<Sector> getAllSectors() throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findAllSectors").getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all sectors");
        }
    }

    public List<Sector> getSectorsByName(String name) throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findSectorByName")
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get sectors by name");
        }
    }
}
