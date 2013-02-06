/*******************************************************************************
 * Copyright (c) 2010-2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *  dclarke - EclipseLink 2.3 - MySports Demo Bug 344608
 ******************************************************************************/
package eclipselink.example.jpa.employee.web;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import eclipselink.example.jpa.employee.model.Employee;
import eclipselink.example.jpa.employee.services.PersistenceHelper;

/**
 * Return list of available Leagues from JAX-RS call to MySports Admin app.
 * 
 * @author dclarke
 * @since EclipseLink 2.3.0
 */
@ManagedBean
public class EmployeeList {

    private EntityManagerFactory emf;

    protected static final String PAGE = "/employee/search-results?faces-redirect=true";

    private PersistenceHelper persistence;

    private List<Employee> employees;

    public EntityManagerFactory getEmf() {
        return emf;
    }

    @PersistenceUnit(unitName = "employee")
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public PersistenceHelper getPersistence() {
        return persistence;
    }

    @EJB
    public void setPersistence(PersistenceHelper persistence) {
        this.persistence = persistence;
    }

    public List<Employee> getEmployees() {
        if (this.employees == null) {
            getPersistence().startSQLTrace();

            EntityManager em = getEmf().createEntityManager();
            try {
                this.employees = em.createQuery("SELECT e FROM Employee e ORDER BY e.id", Employee.class).getResultList();
            } finally {
                em.close();
            }
        }
        return this.employees;
    }

    public String create() {
        return CreateEmployee.PAGE;
    }
}
