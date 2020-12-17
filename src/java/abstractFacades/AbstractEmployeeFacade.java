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
public abstract class AbstractEmployeeFacade<Employee> extends AbstractFacade<Employee> {

    public AbstractEmployeeFacade(Class<Employee> entityClass) {
        super(entityClass);
    }

    @Override
    protected abstract EntityManager getEntityManager();
    
        public List<Employee> getAllEmployees() throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findAllEmployees").getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get all employees");
        }
    }

    public List<Employee> getEmployeesByName(String name) throws ReadException {
        try {
            return getEntityManager().createNamedQuery("findEmployeesByName")
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            throw new ReadException("Error when trying to get employees by name");
        }
    }
}
