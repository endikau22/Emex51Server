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
public abstract class AbstractBossFacade<Boss> extends AbstractFacade<Boss> {
    
    public AbstractBossFacade(Class<Boss> entityClass) {
        super(entityClass);
    }
    
    @Override
    protected abstract EntityManager getEntityManager();
    
        public List<Boss> getAllBosses() throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findAllBosses").getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all Bosses");
        }
    }

    public List<Boss> getBossesByName(String name) throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findBossesByName")
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get Bosses by name");
        }
    }
}
