package com.nigelwilliams.app.utils;

import com.nigelwilliams.app.models.enums.CleaningActivityType;

import java.util.Scanner;

public class CleaningActivityUtil {
    public static CleaningActivityType fromActivityCode(char activityCode) {
        return switch (activityCode) {
            case 'A' -> CleaningActivityType.DISHES;
            case 'B' -> CleaningActivityType.LAUNDRY;
            case 'C' -> CleaningActivityType.MOPPING;
            case 'D' -> CleaningActivityType.SWEEPING;
            case 'E' -> CleaningActivityType.TOILET;
            case 'F' -> CleaningActivityType.STOVE;
            case 'G' -> CleaningActivityType.ROOM;
            case 'H' -> CleaningActivityType.DUSTING;
            default -> CleaningActivityType.NONE;
        };
    }

    public static void printActivityInputOptions() {
        System.out.println("[A] DISHES, [B] LAUNDRY, [C] MOPPING, [D] SWEEPING, " +
                "[E] TOILET, [F] STOVE, [G] ROOM, [H] DUSTING\n[Q] GO BACK");
    }

    public static CleaningActivityType promptAndReturnActivity(Scanner scanner) {
        System.out.println("\nWhat was the cleaning activity?");
        printActivityInputOptions();

        String input = scanner.next();
        if (input.length() == 1) {
            System.out.println("\nYou entered [" + input + "]");
            return fromActivityCode(input.charAt(0));
        }

        return CleaningActivityType.NONE;
    }
}
