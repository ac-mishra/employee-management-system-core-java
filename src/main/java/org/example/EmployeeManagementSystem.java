package org.example;

import org.example.model.Employee;
import org.example.service.EmployeeReportGenerator;
import org.example.service.EmployeeService;
import org.example.util.ValidationUtils;

import java.util.Scanner;

public class EmployeeManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static EmployeeService service =
            new EmployeeService();

    public static void main(String[] args) {

        int choice=0;

        do {

            System.out.println(
                    "\n=== EMPLOYEE MANAGEMENT SYSTEM ===");

            System.out.println("1. Add New Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Generate Reports");
            System.out.println("7. Save to File");
            System.out.println("8. Load From File");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");

            try {

                choice = Integer.parseInt(
                        sc.nextLine());

            } catch (Exception e) {

                System.out.println(
                        "❌ Invalid input!");

                continue;
            }

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    EmployeeReportGenerator
                            .generateSalaryReport(
                                    service.getEmployees());
                    break;

                case 7:

                    service.saveData();

                    break;

                case 8:

                    service.loadData();

                    break;

                case 9:

                    System.out.println(
                            "\nThank you for using Employee Management System! \nDeveloped By Amrit Chandan Mishra");

                    break;

                default:

                    System.out.println(
                            "❌ Invalid choice!");
            }

        } while (choice != 9);

        sc.close();
    }

    public static void addEmployee() {

        System.out.println(
                "\n=== ADD NEW EMPLOYEE ===");

        System.out.print(
                "Enter Employee ID: ");

        String id = sc.nextLine();

        if (service.findById(id) != null) {

            System.out.println(
                    "❌ Employee already exists!");

            return;
        }

        System.out.print(
                "Enter Name: ");

        String name = sc.nextLine();

        System.out.print(
                "Enter Department: ");

        String department =
                sc.nextLine();

        System.out.print(
                "Enter Position: ");

        String position =
                sc.nextLine();

        double salary;

        try {

            System.out.print(
                    "Enter Salary: ");

            salary =
                    Double.parseDouble(
                            sc.nextLine());

        } catch (Exception e) {

            System.out.println(
                    "❌ Invalid salary!");

            return;
        }

        if (!ValidationUtils.isValidText(name)
                || !ValidationUtils.isValidSalary(salary)) {

            System.out.println(
                    "❌ Invalid employee data!");

            return;
        }

        Employee employee =
                new Employee(
                        id,
                        name,
                        department,
                        position,
                        salary);

        service.addEmployee(employee);

        System.out.println(
                "✅ Employee added successfully!");
    }

    public static void viewEmployees() {

        System.out.println(
                "\n=== ALL EMPLOYEES ===");

        if (service.getEmployees()
                .isEmpty()) {

            System.out.println(
                    "No employees found!");

            return;
        }

        for (Employee e :
                service.getEmployees()) {

            System.out.println(e);
        }
    }

    public static void searchEmployee() {

        System.out.println(
                "\n=== SEARCH EMPLOYEE ===");

        System.out.println(
                "1. Search by ID");

        System.out.println(
                "2. Search by Name");

        System.out.println(
                "3. Search by Department");

        System.out.print(
                "Enter choice: ");

        int choice;

        try {

            choice =
                    Integer.parseInt(
                            sc.nextLine());

        } catch (Exception e) {

            System.out.println(
                    "❌ Invalid choice!");

            return;
        }

        switch (choice) {

            case 1:

                System.out.print(
                        "Enter Employee ID: ");

                Employee employee =
                        service.findById(
                                sc.nextLine());

                if (employee != null) {

                    System.out.println(employee);

                } else {

                    System.out.println(
                            "❌ Employee not found!");
                }

                break;

            case 2:

                System.out.print(
                        "Enter Name: ");

                service.searchByName(
                        sc.nextLine());

                break;

            case 3:

                System.out.print(
                        "Enter Department: ");

                service.searchByDepartment(
                        sc.nextLine());

                break;

            default:

                System.out.println(
                        "❌ Invalid choice!");
        }
    }

    public static void updateEmployee() {

        System.out.print(
                "\nEnter Employee ID: ");

        String id =
                sc.nextLine();

        Employee employee =
                service.findById(id);

        if (employee == null) {

            System.out.println(
                    "❌ Employee not found!");

            return;
        }

        System.out.print(
                "New Name: ");

        employee.setName(
                sc.nextLine());

        System.out.print(
                "New Department: ");

        employee.setDepartment(
                sc.nextLine());

        System.out.print(
                "New Position: ");

        employee.setPosition(
                sc.nextLine());

        try {

            System.out.print(
                    "New Salary: ");

            double salary =
                    Double.parseDouble(
                            sc.nextLine());

            if (!ValidationUtils.isValidSalary(salary)) {

                System.out.println(
                        "❌ Salary must be greater than or equal to 0!");

                return;
            }

            employee.setSalary(salary);

        } catch (Exception e) {

            System.out.println(
                    "❌ Invalid salary!");

            return;
        }

        System.out.println(
                "✅ Employee updated!");
    }

    public static void deleteEmployee() {

        System.out.print(
                "\nEnter Employee ID: ");

        String id =
                sc.nextLine();

        Employee employee =
                service.findById(id);

        if (employee == null) {

            System.out.println(
                    "❌ Employee not found!");

            return;
        }

        service.getEmployees()
                .remove(employee);

        service.getEmployeeMap()
                .remove(id);

        System.out.println(
                "✅ Employee deleted!");
    }
}