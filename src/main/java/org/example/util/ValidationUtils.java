package org.example.util;

/**
 * Utility class for validating
 * employee input data.
 */
public class ValidationUtils {

    /**
     * Validates text fields such as
     * name, department, and position.
     */
    public static boolean isValidText(String text) {

        return text != null &&
                !text.trim().isEmpty();
    }
    /**
     * Validates employee salary.
     *
     * @param salary Employee salary
     * @return true if salary is valid
     */
    public static boolean isValidSalary(double salary) {

        return salary >= 0;
    }
}