package edu.pro.jpa.samples.enterprise;

import edu.pro.jpa.samples.enterprise.model.dao.HardcodedEmployeeDao;
import edu.pro.jpa.samples.enterprise.model.dto.EmployeeDto;
import edu.pro.jpa.samples.enterprise.model.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Runner {
    private static final String persistenceUnitName = "EmployeePersistenceUnit";

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();

        HardcodedEmployeeDao employeeDao = new HardcodedEmployeeDao(em);

        // Create and persist an employee.
        EmployeeDto newDto = new EmployeeDto("Sinitsa Dzmitry", 250);
        em.getTransaction().begin();
        employeeDao.create(newDto);
        em.getTransaction().commit();

        // Find a specific employee.
        EmployeeDto foundDto = employeeDao.read(1);
        System.out.println("name: " + foundDto.getName() +
                "\nsalary: " + foundDto.getSalary());

        // Find all employees.
        List<Employee> employees = employeeDao.findAll();
        System.out.println("\nList of employees:");
        for(Employee employee: employees) {
            System.out.println("name: " + employee.getName());
        }
        System.out.println();

        // Update the employee.

        em.close();
        emf.close();
    }
}
