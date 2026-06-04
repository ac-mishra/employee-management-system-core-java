# Employee Management System using Core Java

## Project Overview

Employee Management System is a console-based Java application developed using Core Java, Collections Framework, File Handling, Serialization, and Object-Oriented Programming concepts.

The system allows users to manage employee records efficiently through CRUD operations, employee search, salary reporting, and permanent file storage.

---

## Features

- Add New Employee
- View All Employees
- Search Employee by ID
- Update Employee Information
- Delete Employee
- Generate Salary Reports
- Save Employee Data to File
- Load Employee Data from File
- Input Validation
- Exception Handling

---

## Technologies Used

- Core Java
- Maven
- IntelliJ IDEA
- ArrayList
- HashMap
- File Handling
- Serialization
- Exception Handling
- OOP Concepts

---

## Java Concepts Covered

- Classes and Objects
- Encapsulation
- Collections Framework
- ArrayList
- HashMap
- File Handling
- Serialization & Deserialization
- Exception Handling
- Menu Driven Programming
- Method Reusability

---

## Project Structure

```text
EmployeeManagementSystem
│
├── src
│   └── main
│       └── java
│           └── org.example
│               │
│               ├── model
│               │   └── Employee.java
│               │
│               ├── service
│               │   ├── EmployeeService.java
│               │   └── EmployeeReportGenerator.java
│               │
│               ├── file
│               │   └── EmployeeFileHandler.java
│               │
│               ├── util
│               │   └── ValidationUtils.java
│               │
│               └── EmployeeManagementSystem.java
│
├── data
├── docs
├── reports
├── screenshots
└── README.md
```

---

## System Workflow

1. User selects menu option.
2. Employee details are validated.
3. Employee records are stored in ArrayList.
4. Employee lookup is performed using HashMap.
5. Employee data is saved to file using Serialization.
6. Reports are generated from stored employee data.
7. Data is automatically loaded when the application starts.

---

## Sample Employee Data

| ID | Name | Department | Position | Salary |
|----|------|------------|----------|---------|
| E001 | Amrit Chandan | Engineering | Java Developer | 50000 |
| E002 | Rahul Sharma | HR | Manager | 60000 |
| E003 | Priya Das | Finance | Analyst | 55000 |

---

## How To Run

1. Open the project in IntelliJ IDEA.
2. Ensure JDK 21 is configured.
3. Open `EmployeeManagementSystem.java`.
4. Run the application.
5. Use the menu options to manage employee records.

---

## Reports Generated

- Total Employees
- Total Salary
- Average Salary
- Highest Salary
- Lowest Salary

---

## Future Enhancements

- Search by Name
- Search by Department
- Department-wise Reports
- Employee Sorting
- MySQL Database Integration
- GUI Version using JavaFX

---

## Screenshots

Add screenshots inside the `screenshots` folder:

- Main Menu
- Add Employee
- View Employees
- Search Employee
- Update Employee
- Delete Employee
- Salary Report
- Save Data
- Load Data

---

## Developed By

**Amrit Chandan Mishra**