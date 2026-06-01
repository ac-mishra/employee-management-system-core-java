package org.example.util;

public class ValidationUtils {

    public static boolean isValidText(String text) {

        return text != null &&
                !text.trim().isEmpty();
    }

    public static boolean isValidSalary(double salary) {

        return salary >= 0;
    }
}