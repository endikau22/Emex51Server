/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFacades;

import security.Hashing;
import entity.Employee;
import entity.User;
import exception.CreateException;
import exception.EmailExistException;
import exception.LoginExistException;
import exception.ReadException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author xabig
 */
public abstract class AbstractEmployeeFacade extends AbstractFacade<Employee> {

    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(AbstractBossFacade.class.getName());

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

    public void createEmployee(Employee employee) throws CreateException, LoginExistException, EmailExistException {
        LOGGER.log(Level.INFO, "Metodo create de la clase AbstractBossFacade");
        try {
            employee.setPassword(Hashing.cifrarTexto(employee.getPassword()));
            super.checkLoginAndEmailNotExist(employee.getLogin(),employee.getEmail());
            super.create(employee);
        } catch (ReadException e) {
            throw new CreateException("Error when trying to create " + employee.toString());
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
