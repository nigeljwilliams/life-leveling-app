package com.nigelwilliams.app.utils;

import java.util.Scanner;

public class InputHelperUtil {
    public static char getCharFromInput(Scanner scanner) {
        try {
            String input = scanner.next();
            if (input.length() == 1) {
                return input.charAt(0);
            }
        } catch (Exception e) {
            System.err.println("Failed to read input: " + e.getMessage());
        }

        return 0;
    }

    public static String getNameFromInput(Scanner scanner) {
        try {
            return scanner.next();
        } catch (Exception e) {
            System.err.println("Failed to get name from input: " + e.getMessage());
        }

        return null;
    }
}
