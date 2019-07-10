package edu.pro.jpa.samples.enterprise.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
    Regular attributes must have getter/setter method pairs.
    Instead of fields properties can be annotated on getters.
    By default:
    1. The name of the table to store any given entity of a particular
    entity type is the name of that entity class in uppercase.
    2. Fields are mapped to columns of the table with the same names in uppercase.
*/

// Marker annotation indicating that this class is an entity.
// Equals to @Entity(name="EMPLOYEE")
@Entity
public class Employee {

    // Annotates field that holds the persistent identity of the entity.
    @Id
    // Bounds to ID column in EMPLOYEE table (default).
    private long id;
    // Bounds to NAME column in EMPLOYEE table (default).
    private String name;
    // Bounds to SALARY column in EMPLOYEE table (default).
    private long salary;

    public Employee() {}
    public Employee(long id) { this.id = id; }
    public Employee(long id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void setId(long id) { this.id = id; }
    public long getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setSalary(long salary) { this.salary = salary; }
    public long getSalary() { return salary; }
}
