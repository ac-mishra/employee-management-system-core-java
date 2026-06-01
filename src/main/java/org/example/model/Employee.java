package org.example.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {

    private String id;
    private String name;
    private String department;
    private String position;
    private double salary;
    private LocalDate joinDate;

    public Employee(String id,
                    String name,
                    String department,
                    String position,
                    double salary) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.joinDate = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {

        return String.format(
                "ID: %s | Name: %s | Dept: %s | Position: %s | Salary: ₹%.2f | Joined: %s",
                id,
                name,
                department,
                position,
                salary,
                joinDate
        );
    }
}