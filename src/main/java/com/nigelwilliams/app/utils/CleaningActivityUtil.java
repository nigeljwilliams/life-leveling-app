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
            case 'I' -> CleaningActivityType.VACUUMING;
            case 'J' -> CleaningActivityType.WINDOWS;
            case 'K' -> CleaningActivityType.CARPET_SCRUBBING;
            default -> CleaningActivityType.NONE;
        };
    }

    public static void printActivityInputOptions() {
        System.out.println("""
                [A] DISHES, [B] LAUNDRY, [C] MOPPING, [D] SWEEPING, \
                [E] TOILET, [F] STOVE, [G] ROOM
                [H] DUSTING, [I] VACUUMING, [J] WINDOWS, [K] CARPET SCRUBBING
                [Q] GO BACK""");
    }

    public static CleaningActivityType promptAndReturnActivity(Scanner scanner) {
        System.out.println("\nWhat was the cleaning activity?");
        printActivityInputOptions();

        char activityChar = InputHelperUtil.getLetterFromInput(scanner);
        if (activityChar != 0) {
            System.out.printf("\nYou entered [" + activityChar + "]");
            return fromActivityCode(activityChar);
        }

        return CleaningActivityType.NONE;
    }
}
