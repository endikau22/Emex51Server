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
public abstract class AbstractCreatureFacade<Creature> extends AbstractFacade<Creature> {
    
    public AbstractCreatureFacade(Class<Creature> entityClass) {
        super(entityClass);
    }

    @Override
    protected abstract EntityManager getEntityManager();
    
        public List<Creature> getAllCreatures() throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findAllCreatures").getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all creatures");
        }
    }

    public List<Creature> getCreatureByName(String name) throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findCreatureByName")
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get creatures by name");
        }
    }
}
