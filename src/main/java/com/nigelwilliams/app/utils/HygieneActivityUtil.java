package com.nigelwilliams.app.utils;

import com.nigelwilliams.app.models.enums.HygieneActivityType;

import java.util.Scanner;

public class HygieneActivityUtil {
    public static HygieneActivityType fromActivityCode(char activityCode) {
        return switch (activityCode) {
            case 'A' -> HygieneActivityType.BRUSH_TEETH;
            case 'B' -> HygieneActivityType.SHOWER;
            case 'C' -> HygieneActivityType.WASH_HAIR;
            case 'D' -> HygieneActivityType.CLIP_FINGER_NAILS;
            case 'E' -> HygieneActivityType.CLIP_TOE_NAILS;
            case 'F' -> HygieneActivityType.CLEAN_NOSE;
            case 'G' -> HygieneActivityType.CLEAN_EARS;
            default -> HygieneActivityType.NONE;
        };
    }

    public static void printActivityInputOptions() {
        System.out.println("""
                [A] BRUSH TEETH, [B] SHOWER, [C] WASH HAIR, [D] CLIP FINGER NAILS
                [E] CLIP TOE NAILS, [F] CLEAN NOSE, [G] CLEAN EARS
                [Q] GO BACK""");
    }

    public static HygieneActivityType promptAndReturnActivity(Scanner scanner) {
        System.out.println("\nWhat was the hygiene activity?");
        printActivityInputOptions();

        String input = scanner.next();
        if (input.length() == 1) {
            System.out.println("\nYou entered [" + input + "]");
            return fromActivityCode(input.charAt(0));
        }

        return HygieneActivityType.NONE;
    }
}
