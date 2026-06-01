package org.example.service;

import org.example.file.EmployeeFileHandler;
import org.example.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeService {

    private ArrayList<Employee> employees;

    private HashMap<String, Employee> employeeMap;

    public EmployeeService() {

        employees =
                EmployeeFileHandler.loadEmployees();

        employeeMap = new HashMap<>();

        for (Employee e : employees) {

            employeeMap.put(
                    e.getId(),
                    e);
        }
    }

    public void addEmployee(
            Employee employee) {

        employees.add(employee);

        employeeMap.put(
                employee.getId(),
                employee);
    }

    public ArrayList<Employee> getEmployees() {

        return employees;
    }

    public HashMap<String, Employee> getEmployeeMap() {

        return employeeMap;
    }

    public Employee findById(String id) {

        return employeeMap.get(id);
    }

    public void saveData() {

        EmployeeFileHandler
                .saveEmployees(employees);
    }
}