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
public abstract class AbstractVisitorFacade<Visitor> extends AbstractFacade<Visitor> {
    
    public AbstractVisitorFacade(Class<Visitor> entityClass) {
        super(entityClass);
    }

    @Override
    protected abstract EntityManager getEntityManager();
    
        public List<Visitor> getAllVisitors() throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findAllVisitors").getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all visitors");
        }
    }

    public List<Visitor> getVisitorByName(String name) throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findVisitorByName")
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get visitors by name");
        }
    }
}
