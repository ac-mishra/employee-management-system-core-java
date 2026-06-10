package org.example.service;

import org.example.file.EmployeeFileHandler;
import org.example.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Service class responsible for managing
 * employee operations and business logic.
 */

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
    /**
     * Adds a new employee to the system.
     *Employee object
     */
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
    /**
     * Searches employee by Employee ID
     */
    public Employee findById(String id) {

        return employeeMap.get(id);
    }

    /**
     * Searches employees using name keyword.
     */
    public void searchByName(String keyword) {

        boolean found = false;

        for (Employee employee : employees) {

            if (employee.getName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {

                System.out.println(employee);
                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "❌ No employee found!");
        }
    }

    /**
     * Searches employees by department.
     */
    public void searchByDepartment(
            String department) {

        boolean found = false;

        for (Employee employee : employees) {

            if (employee.getDepartment()
                    .equalsIgnoreCase(department)) {

                System.out.println(employee);
                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "❌ No employee found!");
        }
    }

    /**
     * Saves all employee data to file.
     */
    public void saveData() {

        EmployeeFileHandler
                .saveEmployees(employees);
    }

    /**
     * Loads employee data from file
     * and rebuilds HashMap records.
     */
    public void loadData() {

        employees =
                EmployeeFileHandler.loadEmployees();

        employeeMap.clear();

        for (Employee employee : employees) {

            employeeMap.put(
                    employee.getId(),
                    employee);
        }

        System.out.println(
                "✅ Employee data loaded successfully!");
    }
}