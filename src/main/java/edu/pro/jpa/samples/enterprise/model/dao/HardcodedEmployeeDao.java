package edu.pro.jpa.samples.enterprise.model.dao;

import edu.pro.jpa.samples.enterprise.model.dto.EmployeeDto;
import edu.pro.jpa.samples.enterprise.model.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/*
    A transaction should enclose each mutating operation:
    begin before and commit after a such method.
    find() call is not mutating operation.
    If a transaction is not present, then either:
    - the modifying operation will throw an exception
    OR
    - the change will simply never be persisted to the data store.
    EntityTransaction service is the Java SE transaction service.
*/

public class HardcodedEmployeeDao {
    private static HardcodedEmployeeDao employeeDao;
    private static final String persistenceUnitName = "EmployeePersistenceUnit";
    private static long nextId = 0L;
    private final EntityManager em;

    public HardcodedEmployeeDao(EntityManager em) {
        this.em = em;
    }

    //  1. Create.
    public void create(EmployeeDto dto) {
        Employee employee = new Employee(++nextId);
        employee.setName(dto.getName());
        employee.setSalary(dto.getSalary());
        em.persist(employee);
    }

    /*
        2. Read.
        If the object wasn't found, then the find() call returns null.
    */

    public EmployeeDto read(long id) {
         Employee employee = em.find(Employee.class, id);
         return new EmployeeDto(employee.getName(), employee.getSalary());
    }

    /*
        3. Update.
        The simplest and most common case to update an entity is
        to perform updating operations on the maneged entity.
        There is no call into the entity manager to modify the object.
        The only mean of detecting the change is the persistence context.
    */

    public void update(long id, EmployeeDto dto) {
        Employee entity = em.find(Employee.class, id);
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());
    }

    /*
        4. Delete.
        To remove an entity, it must present in the persistence context.
        This means app should have loaded or accessed the entity before.
    */

    // If found Employee is null, IllegalArgumentException is thrown.
    public void delete(long id)  {
        Employee employee = em.find(Employee.class, id);
        if(employee != null) {
            em.remove(employee);
        }
    }

    public List<Employee> findAll() {
        TypedQuery<Employee> query =
                em.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }
}
