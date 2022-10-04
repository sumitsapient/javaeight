package org.youtube.pojo;

public class Employee {
    String name;
    String department;
    long salary;

    boolean active;

    public Employee(String name, String department, long salary, boolean active) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
