/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boss;

import employee.Employee;
import java.io.Serializable;
import java.util.ArrayList;
import user.User;

/**
 * Esta clase es para guardar los datos de un Boss
 *
 * @author Xabier Carnero
 */
public class Boss extends User implements Serializable {

    private float salario;
    private ArrayList<Employee> empleado;

    public Boss() {
    }

    public Boss(float salario, ArrayList<Employee> empleado) {
        this.salario = salario;
        this.empleado = empleado;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public ArrayList<Employee> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(ArrayList<Employee> empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Boss{" + "salario=" + salario + ", empleado=" + empleado + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Boss)) {
            return false;
        }
        Boss other = (Boss) obj;
        if ((((User) this).getLogin() == null && ((User) other).getLogin() != null) || (((User) this).getLogin() != null && !((User) this).getLogin().equals(((User) other).getLogin()))) {
            return false;
        }
        return true;
    }
}
