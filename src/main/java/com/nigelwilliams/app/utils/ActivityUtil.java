package com.nigelwilliams.app.utils;

import com.nigelwilliams.app.services.enums.ActivityType;

import java.util.Scanner;

public class ActivityUtil {
    public static ActivityType fromActivityCode(char activityCode) {
        return switch (activityCode) {
            case 'A' -> ActivityType.CLEANING;
            case 'B' -> ActivityType.EXERCISE;
            case 'C' -> ActivityType.FOOD_PREP;
            case 'D' -> ActivityType.HYGIENE;
            case 'E' -> ActivityType.YARD_WORK;
            default -> ActivityType.NONE;
        };
    }

    public static void printActivityInputOptions() {
        System.out.println("[A] CLEANING, [B] EXERCISE, [C] FOOD PREP, [D] HYGIENE, " +
                "[E] YARD WORK\n[Q] Quit/Exit Program");
    }

    public static ActivityType promptAndReturnActivity(Scanner scanner) {
        System.out.println("\nWhat activity do you want to record?");
        printActivityInputOptions();

        char activityChar = InputHelperUtil.getLetterFromInput(scanner);
        if (activityChar != 0) {
            System.out.println("\nYou entered [" + activityChar + "]");
            return fromActivityCode(activityChar);
        }

        return ActivityType.NONE;
    }
}
