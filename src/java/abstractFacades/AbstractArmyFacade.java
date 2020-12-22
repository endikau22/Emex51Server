/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFacades;

import entity.Army;
import exception.ReadException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author xabig
 */
public abstract class AbstractArmyFacade extends AbstractFacade<Army> {

    public AbstractArmyFacade(Class<Army> entityClass) {
        super(entityClass);
    }

    @Override
    protected abstract EntityManager getEntityManager();

    public List<Army> getAllArmys() throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findAllArmys").getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all armys");
        }
    }

    public List<Army> getArmyByName(String name) throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findArmyByName")
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get armys by name");
        }
    }
}
