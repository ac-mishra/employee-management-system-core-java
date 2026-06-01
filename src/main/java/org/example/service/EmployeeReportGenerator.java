package org.example.service;

import org.example.model.Employee;

import java.util.ArrayList;

public class EmployeeReportGenerator {

    public static void generateSalaryReport(
            ArrayList<Employee> employees) {

        if (employees.isEmpty()) {

            System.out.println(
                    "No employees found.");

            return;
        }

        double total = 0;

        Employee highest =
                employees.get(0);

        Employee lowest =
                employees.get(0);

        for (Employee e : employees) {

            total += e.getSalary();

            if (e.getSalary() >
                    highest.getSalary()) {

                highest = e;
            }

            if (e.getSalary() <
                    lowest.getSalary()) {

                lowest = e;
            }
        }

        System.out.println(
                "\n=== SALARY REPORT ===");

        System.out.println(
                "Total Employees : "
                        + employees.size());

        System.out.printf(
                "Total Salary : ₹%.2f\n",
                total);

        System.out.printf(
                "Average Salary : ₹%.2f\n",
                total / employees.size());

        System.out.println(
                "Highest Salary : "
                        + highest.getName());

        System.out.println(
                "Lowest Salary : "
                        + lowest.getName());
    }
}