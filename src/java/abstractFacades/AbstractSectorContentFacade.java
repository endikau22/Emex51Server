/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFacades;

import exception.ReadException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author xabig
 */
public abstract class AbstractSectorContentFacade<SectorContent> extends AbstractFacade<SectorContent> {
    
    public AbstractSectorContentFacade(Class<SectorContent> entityClass) {
        super(entityClass);
    }
    
    @Override
    protected abstract EntityManager getEntityManager();
    
        public List<SectorContent> getAllSectorContents() throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findAllContents").getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all SectorContents");
        }
    }

    public List<SectorContent> getSectorContentsByName(String name) throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findContentsByName")
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get SectorContents by name");
        }
    }
}
