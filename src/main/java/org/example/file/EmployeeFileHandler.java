package org.example.file;

import org.example.model.Employee;

import java.io.*;
import java.util.ArrayList;

/**
 * Handles file operations such as
 * saving and loading employee data.
 */
public class EmployeeFileHandler {

    private static final String FILE_NAME =
            "data/employees.dat";

    /**
     * Serializes employee list and
     * stores it into a file.
     */
    public static void saveEmployees(
            ArrayList<Employee> employees) {

        try {

            File folder =
                    new File("data");

            if (!folder.exists()) {

                folder.mkdir();
            }

            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream(FILE_NAME));

            oos.writeObject(employees);

            oos.close();

            System.out.println(
                    "✅ Employee data saved.");

        } catch (Exception e) {

            System.out.println(
                    "❌ Error saving file: "
                            + e.getMessage());
        }
    }

    /**
     * Reads employee data from file
     * and returns employee list.
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Employee> loadEmployees() {

        try {

            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream(FILE_NAME));

            ArrayList<Employee> employees =
                    (ArrayList<Employee>) ois.readObject();

            ois.close();

            return employees;

        } catch (Exception e) {

            return new ArrayList<>();
        }
    }
}