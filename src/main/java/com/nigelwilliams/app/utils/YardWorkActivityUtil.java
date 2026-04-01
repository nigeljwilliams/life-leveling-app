package com.nigelwilliams.app.utils;

import com.nigelwilliams.app.models.enums.YardWorkActivityType;

import java.util.Scanner;

public class YardWorkActivityUtil {
    public static YardWorkActivityType fromActivityCode(char activityCode) {
        return switch (activityCode) {
            case 'A' -> YardWorkActivityType.MOWING;
            case 'B' -> YardWorkActivityType.EDGING;
            case 'C' -> YardWorkActivityType.LANDSCAPING;
            case 'D' -> YardWorkActivityType.PICK_UP_TRASH;
            case 'E' -> YardWorkActivityType.PRESSURE_WASHING;
            case 'F' -> YardWorkActivityType.PULLING_WEEDS;
            default -> YardWorkActivityType.NONE;
        };
    }

    public static void printActivityInputOptions() {
        System.out.println("""
                [A] MOWING, [B] EDGING, [C] LANDSCAPING, [D] PICK UP TRASH
                [E] PRESSURE WASHING, [F] PULLING WEEDS
                [Q] GO BACK""");
    }

    public static YardWorkActivityType promptAndReturnActivity(Scanner scanner) {
        System.out.println("\nWhat was the yard work activity?");
        printActivityInputOptions();

        char activityChar = InputHelperUtil.getLetterFromInput(scanner);
        if (activityChar != 0) {
            System.out.println("\nYou entered [" + activityChar + "]");
            return fromActivityCode(activityChar);
        }

        return YardWorkActivityType.NONE;
    }
}
