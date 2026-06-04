package org.example.service;

import org.example.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeReportGenerator {

    public static void generateSalaryReport(
            ArrayList<Employee> employees) {

        if (employees.isEmpty()) {

            System.out.println(
                    "No employees found!");

            return;
        }

        double totalSalary = 0;

        Employee highest =
                employees.get(0);

        Employee lowest =
                employees.get(0);

        for (Employee employee : employees) {

            totalSalary +=
                    employee.getSalary();

            if (employee.getSalary() >
                    highest.getSalary()) {

                highest = employee;
            }

            if (employee.getSalary() <
                    lowest.getSalary()) {

                lowest = employee;
            }
        }

        double averageSalary =
                totalSalary / employees.size();

        System.out.println(
                "\n=== EMPLOYEE REPORTS ===");

        System.out.println(
                "\n💰 SALARY STATISTICS:");

        System.out.println(
                "• Total Employees: "
                        + employees.size());

        System.out.printf(
                "• Total Salary: ₹%,.2f\n",
                totalSalary);

        System.out.printf(
                "• Average Salary: ₹%,.2f\n",
                averageSalary);

        System.out.printf(
                "• Highest Salary: ₹%,.2f (%s)\n",
                highest.getSalary(),
                highest.getName());

        System.out.printf(
                "• Lowest Salary: ₹%,.2f (%s)\n",
                lowest.getSalary(),
                lowest.getName());

        // Department Summary
        System.out.println(
                "\n🏢 DEPARTMENT SUMMARY:");

        HashMap<String, Double> deptSalary =
                new HashMap<>();

        HashMap<String, Integer> deptCount =
                new HashMap<>();

        for (Employee employee : employees) {

            String department =
                    employee.getDepartment();

            deptSalary.put(
                    department,
                    deptSalary.getOrDefault(
                            department,
                            0.0)
                            + employee.getSalary());

            deptCount.put(
                    department,
                    deptCount.getOrDefault(
                            department,
                            0) + 1);
        }

        for (String department :
                deptCount.keySet()) {

            double averageDeptSalary =
                    deptSalary.get(department)
                            / deptCount.get(department);

            System.out.printf(
                    "• %s : %d employees, Average Salary ₹%,.2f\n",
                    department,
                    deptCount.get(department),
                    averageDeptSalary);
        }

        // Position Summary
        System.out.println(
                "\n👔 POSITION SUMMARY:");

        HashMap<String, Integer> positionCount =
                new HashMap<>();

        for (Employee employee : employees) {

            String position =
                    employee.getPosition();

            positionCount.put(
                    position,
                    positionCount.getOrDefault(
                            position,
                            0) + 1);
        }

        for (String position :
                positionCount.keySet()) {

            System.out.println(
                    "• " + position
                            + ": "
                            + positionCount.get(position)
                            + " employees");
        }
    }
}