package edu.pro.jpa.samples.enterprise.model.dto;

public class EmployeeDto {
    private String name;
    private long salary;

    public EmployeeDto() {}
    public EmployeeDto(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setSalary(long salary) { this.salary = salary; }
    public long getSalary() { return salary; }


}
